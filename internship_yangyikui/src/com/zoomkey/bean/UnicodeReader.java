/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * hcs_develop20110412
 * com.berheley.hcms.bean.UnicodeReader.java
 * Created on 2011-11-23-下午02:05:34
 */

package com.zoomkey.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

/**
 * 类功能描述:本类处理了java读取utf-8文件时开头出现"？"的问题
 * java读取（UTF-8或者unicode编码）txt文件的时，读取的前三个字节是"EF BB BF",转换成UTF-8编码的字符是"?"。
 * 其实这时JDK的一个bug（Bug ID:4508058官网上有详细描述）,JDK1.6只是解决了读取带有BOM文件失败的问题，
 * 还是不能区别处理有BOM和无BOM的UTF-8编码的文件。
 *
 * @author <a href="mailto:zhaoxinchun@zoomkey.com.cn">zhaoxinchun</a>
 * Create:  2011-11-23 下午02:05:34
 */
public class UnicodeReader extends Reader
{

	PushbackInputStream			internalIn;

	InputStreamReader				internalIn2	= null;

	String							defaultEnc;

	private static final int	BOM_SIZE		= 4;

	/**
	 *
	 * @param in  inputstream to be read
	 * @param defaultEnc default encoding if stream does not have 
	 *                   BOM marker. Give NULL to use system-level default.
	 */
	public UnicodeReader(InputStream in, String defaultEnc)
	{
		this.internalIn = new PushbackInputStream(in, BOM_SIZE);
		this.defaultEnc = defaultEnc;
	}

	public String getDefaultEncoding()
	{
		return this.defaultEnc;
	}

	/**
	 * Get stream encoding or NULL if stream is uninitialized.
	 * Call init() or read() method to initialize it.
	 */
	public String getEncoding()
	{
		if (this.internalIn2 == null)
		{
			return null;
		}
		return this.internalIn2.getEncoding();
	}

	/**
	 * Read-ahead four bytes and check for BOM marks. Extra bytes are
	 * unread back to the stream, only BOM bytes are skipped.
	 */
	protected void init() throws IOException
	{
		if (this.internalIn2 != null)
		{
			return;
		}
		String encoding;
		byte bom[] = new byte[BOM_SIZE];
		int n, unread;
		n = this.internalIn.read(bom, 0, bom.length);
		if (bom[0] == (byte) 0x00 && bom[1] == (byte) 0x00 && bom[2] == (byte) 0xFE && bom[3] == (byte) 0xFF)
		{
			encoding = "UTF-32BE";
			unread = n - 4;
		} else if (bom[0] == (byte) 0xFF && bom[1] == (byte) 0xFE && bom[2] == (byte) 0x00 && bom[3] == (byte) 0x00)
		{
			encoding = "UTF-32LE";
			unread = n - 4;
		} else if (bom[0] == (byte) 0xEF && bom[1] == (byte) 0xBB && bom[2] == (byte) 0xBF)
		{
			encoding = "UTF-8";
			unread = n - 3;
		} else if (bom[0] == (byte) 0xFE && bom[1] == (byte) 0xFF)
		{
			encoding = "UTF-16BE";
			unread = n - 2;
		} else if (bom[0] == (byte) 0xFF && bom[1] == (byte) 0xFE)
		{
			encoding = "UTF-16LE";
			unread = n - 2;
		} else
		{
			// Unicode BOM mark not found, unread all bytes
			encoding = this.defaultEnc;
			unread = n;
		}
		// System.out.println("read=" + n + ", unread=" + unread);
		if (unread > 0)
		{
			this.internalIn.unread(bom, (n - unread), unread);
		}
		// Use given encoding
		if (encoding == null)
		{
			this.internalIn2 = new InputStreamReader(this.internalIn);
		} else
		{
			this.internalIn2 = new InputStreamReader(this.internalIn, encoding);
		}
	}

	@Override
	public void close() throws IOException
	{
		init();
		this.internalIn2.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		init();
		return this.internalIn2.read(cbuf, off, len);
	}
}
