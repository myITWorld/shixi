/*
 * Copyright: Tianjin ZoomKey Software Development Co.,Ltd.
 * hcs_project_xb
 * com.berheley.hcms.util.Mapor.java
 * Created on 2010-5-25-上午08:44:26
 */

package com.zoomkey.util;

/**
 * 类功能描述：灵活度更好的map，其中键值也可以重复
 *
 * @author <a href="mailto:yuannan@zoomkey.com.cn">Yuan Nan</a>
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 * 键值对应集合
 * 
 * @author marvy
 */
public class Mapor implements Map, Serializable, Cloneable
{

	/**
	 * <code> serialVersionUID </code>
	 */
	private static final long	serialVersionUID			= 7214434983321214663L;

	// 允许键值重复
	public static final int		DENY_NOTHING				= 0;

	// 不允许键重复
	public static final int		DENY_SAME_KEY_BUT_VALUE	= 1;

	// 不允许值重复
	public static final int		DENY_SAME_VALUE_BUT_KEY	= 2;

	// 不允许建与值同时重复
	public static final int		DENY_SAME_VALUE_AND_KEY	= 3;

	// 值
	private List					values;

	// 键
	private List					keys;

	// 大小
	private int						size							= 0;

	// 模式
	private int						mode							= DENY_NOTHING;

	/**
	 * 构造集合。允许键值重复
	 */
	public Mapor()
	{
		this(DENY_NOTHING);
	}

	/**
	 * 构造集合，并指定集合模式。
	 * 
	 * @param mode 指定的模式。 <br>
	 *           模式应该为Mapor.DENY_NOTHING、Mapor.DENY_SAME_KEY_BUT_VALUE、Mapor.DENY_SAME_VALUE_BUT_KEY
	 *           、Mapor.DENY_SAME_VALUE_AND_KEY中的一个！
	 */
	public Mapor(int mode)
	{
		super();
		this.size = 0;
		this.values = new Vector();
		this.keys = new Vector();
		setMode(mode);
	}

	/**
	 * 设置集合模式。
	 * 
	 * @param mode 指定的模式。 <br>
	 *           模式应该为Mapor.DENY_NOTHING、Mapor.DENY_SAME_KEY_BUT_VALUE、Mapor.DENY_SAME_VALUE_BUT_KEY
	 *           、Mapor.DENY_SAME_VALUE_AND_KEY中的一个！
	 */
	public void setMode(int mode)
	{
		switch (mode)
		{
			case DENY_NOTHING :
				break;
			case DENY_SAME_KEY_BUT_VALUE :
				break;
			case DENY_SAME_VALUE_BUT_KEY :
				break;
			case DENY_SAME_VALUE_AND_KEY :
				break;
			default :
				throw new IllegalArgumentException("模式应该为Mapor.DENY_NOTHING、Mapor.DENY_SAME_KEY_BUT_VALUE、Mapor.DENY_SAME_VALUE_BUT_KEY、Mapor.DENY_SAME_VALUE_AND_KEY中的一个！ ");
		}
		this.mode = mode;
	}

	/**
	 * 得到集合模式
	 * 
	 * @return 集合模式
	 */
	public int getMode()
	{
		return this.mode;
	}

	/**
	 * @see java.util.Map#size()
	 */
	public int size()
	{
		return this.size;
	}

	/**
	 * @see java.util.Map#clear()
	 */
	public void clear()
	{
		this.size = 0;
		this.values = new Vector();
		this.keys = new Vector();
	}

	/**
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty()
	{
		return this.size == 0 || values.isEmpty();
	}

	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key)
	{
		return this.keys.contains(key);
	}

	public boolean containsKeyByValue(Object key, Object value)
	{
		return this.getKeysByValue(value).contains(key);
	}

	/**
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value)
	{
		return this.values.contains(value);
	}

	public boolean containsValueByKey(Object value, Object key)
	{
		return this.getValuesByKey(key).contains(value);
	}

	/**
	 * @see java.util.Map#values()
	 */
	public Collection values()
	{
		return this.values;
	}

	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map t)
	{
		if (t == null)
		{
			return;
		}
		Iterator keysIterator = t.keySet().iterator();
		while (keysIterator.hasNext())
		{
			this.put(keysIterator.next(), t.get(keysIterator.next()));
		}
	}

	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(List addKeys, List addValues)
	{
		if (addKeys == null
					|| addValues == null
					|| addValues.size() != addKeys.size())
		{
			throw new IllegalArgumentException("不匹配的键值长度! ");
		}
		for (int i = 0; i < addKeys.size(); i++)
		{
			this.put(addKeys.get(i), addValues.get(i));
		}
	}

	/**
	 * @see java.util.Map#entrySet()
	 */
	public Set entrySet()
	{
		return null;
	}

	/**
	 * @see java.util.Map#keySet()
	 */
	public Set keySet()
	{
		return new TreeSet(this.keys);
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Object get(Object key)
	{
		int index = this.keys.indexOf(key);
		if (index < 0)
		{
			return null;
		}
		return this.values.get(index);
	}

	/**
	 * 得到键所对应的值集合
	 * 
	 * @param akey 建
	 * @return 键所对应的值集合
	 */
	public List getValuesByKey(Object akey)
	{
		if (akey == null)
		{
			return new Vector();
		}
		Vector selectedValues = new Vector();
		for (int i = 0; i < this.keys.size(); i++)
		{
			if (this.keys.get(i).equals(akey))
			{
				selectedValues.add(this.values.get(i));
			}
		}
		return selectedValues;
	}

	/**
	 * 得到值所对应的键集合
	 * 
	 * @param aValue 值
	 * @return 值所对应的键集合
	 */
	public List getKeysByValue(Object aValue)
	{
		if (aValue == null)
		{
			return new Vector();
		}
		Vector selectedKeys = new Vector();
		for (int i = 0; i < this.values.size(); i++)
		{
			if (this.values.get(i).equals(aValue))
			{
				selectedKeys.add(this.keys.get(i));
			}
		}
		return selectedKeys;
	}

	/**
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public Object remove(Object key)
	{
		Object removedValue = this.get(key);
		if (removedValue != null)
		{
			this.keys.remove(key);
			this.values.remove(removedValue);
			this.size = this.keys.size();
		}
		return removedValue;
	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(Object key, Object value)
	{
		Object oldValue = this.get(key);
		boolean isContains = false;
		switch (this.getMode())
		{
			case DENY_NOTHING :
				isContains = false;
				break;
			case DENY_SAME_KEY_BUT_VALUE :
				isContains = this.containsKey(key);
				break;
			case DENY_SAME_VALUE_BUT_KEY :
				isContains = this.containsValue(value);
				break;
			case DENY_SAME_VALUE_AND_KEY :
				isContains = this.containsKeyByValue(key, value);
				if (!isContains)
				{
					isContains = this.containsValueByKey(value, key);
				}
				break;
		}
		if (isContains)
		{
			return oldValue;
		}
		this.keys.add(key);
		this.values.add(value);
		this.size = this.keys.size();
		return oldValue;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	protected Object clone()
	{
		Mapor mapor = new Mapor(this.getMode());
		mapor.putAll(this.keys, this.values);
		return mapor;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj)
	{
		if (obj == this)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		Mapor mapor = (Mapor) obj;
		if (!isSame(this.keySet(), mapor.keySet())
					|| !isSame(this.values(), mapor.values()))
		{
			return false;
		}
		return true;
	}

	private boolean isSame(Collection one, Collection anther)
	{
		if (one == null || anther == null)
		{
			return false;
		}
		int size = one.size();
		Object[] oneArray = one.toArray();
		Object[] antherArray = anther.toArray();
		for (int i = 0; i < size; i++)
		{
			if (oneArray[i] == null
						|| antherArray[i] == null
						|| !oneArray[i].equals(antherArray[i]))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return 31
					* super.hashCode()
					+ this.keys.hashCode()
					+ this.values.hashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer tmp = new StringBuffer("[ ");
		for (int i = 0; i < this.size; i++)
		{
			tmp.append(keys.get(i));
			tmp.append("= ");
			tmp.append(values.get(i));
			if (i != this.size - 1)
			{
				tmp.append(", ");
			}
		}
		tmp.append("] ");
		return tmp.toString();
	}

	public static void main(String[] args)
	{
		String[] keys = new String[]{
					"01 ", "01 ", "03 ", "03 "};
		String[] values = new String[]{
					"011value ", "012value ", "011value ", "031value "};
		Mapor mapor = new Mapor();
		int size = keys.length;
		for (int i = 0; i < size; i++)
		{
			mapor.put(keys[i], values[i]);
		}
		System.out.println("mapor= " + mapor);
		mapor = new Mapor(Mapor.DENY_SAME_VALUE_BUT_KEY);
		for (int i = 0; i < size; i++)
		{
			mapor.put(keys[i], values[i]);
		}
		System.out.println("mapor= " + mapor);
	}
}
