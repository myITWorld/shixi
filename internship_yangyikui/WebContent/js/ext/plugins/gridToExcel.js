/**
 * allows for downloading of grid data (store) directly into excel
 * Method: extracts data of gridPanel store, uses columnModel to construct XML excel document,
 * converts to Base64, then loads everything into a data URL link.
 *
 * @author		Animal		<extjs support team>
 *
 */

/**
 * base64 encode / decode
 *
 * @location 	http://www.webtoolkit.info/
 *
 */

var Base64 = (function() {
    // Private property
    var keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    // Private method for UTF-8 encoding
    function utf8Encode(string) {
        string = string.replace(/\r\n/g,"\n");
        var utftext = "";
        for (var n = 0; n < string.length; n++) {
            var c = string.charCodeAt(n);
            if (c < 128) {
                utftext += String.fromCharCode(c);
            }
            else if((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            }
            else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }
        }
        return utftext;
    }

    // Public method for encoding
    return {
        encode : (typeof btoa == 'function') ? function(input) {
            return btoa(utf8Encode(input));
        } : function (input) {
            var output = "";
            var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
            var i = 0;
            input = utf8Encode(input);
            while (i < input.length) {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);
                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;
                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }
                output = output +
                keyStr.charAt(enc1) + keyStr.charAt(enc2) +
                keyStr.charAt(enc3) + keyStr.charAt(enc4);
            }
            return output;
        }
    };
})();

Ext.override(Ext.grid.GridPanel, {
    getExcelXml: function(store,includeHidden) {
    	  var title = document.getElementById('tab_tit').innerHTML;
        var worksheet = this.createWorksheet(store,includeHidden);
        var totalWidth = this.getColumnModel().getTotalWidth(includeHidden);
        return '<xml version="1.0" encoding="utf-8">' +
            '<ss:Workbook xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns:o="urn:schemas-microsoft-com:office:office">' +
            '<o:DocumentProperties><o:Title>' + title + '</o:Title></o:DocumentProperties>' +
            '<ss:ExcelWorkbook>' +
            '<ss:WindowHeight>' + worksheet.height + '</ss:WindowHeight>' +
            '<ss:WindowWidth>' + worksheet.width + '</ss:WindowWidth>' +
            '<ss:ProtectStructure>False</ss:ProtectStructure>' +
            '<ss:ProtectWindows>False</ss:ProtectWindows>' +
            '</ss:ExcelWorkbook>' +
            '<ss:Styles>' +
            '<ss:Style ss:ID="Default">' +
            '<ss:Alignment ss:Vertical="Top" ss:WrapText="1" />' +
            '<ss:Font ss:FontName="arial" ss:Size="10" />' +
            '<ss:Borders>' +
            '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Top" />' +
            '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Bottom" />' +
            '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Left" />' +
            '<ss:Border ss:Color="#e4e4e4" ss:Weight="1" ss:LineStyle="Continuous" ss:Position="Right" />' +
            '</ss:Borders>' +
            '<ss:Interior />' +
            '<ss:NumberFormat />' +
            '<ss:Protection />' +
            '</ss:Style>' +
            '<ss:Style ss:ID="title">' +
            '<ss:Borders />' +
            '<ss:Font />' +
            '<ss:Alignment ss:WrapText="1" ss:Vertical="Center" ss:Horizontal="Center" />' +
            '<ss:NumberFormat ss:Format="@" />' +
            '</ss:Style>' +
            '<ss:Style ss:ID="headercell">' +
            '<ss:Font ss:Bold="1" ss:Size="10" />' +
            '<ss:Alignment ss:WrapText="1" ss:Horizontal="Center" />' +
            '<ss:Interior ss:Pattern="Solid" />' +
            '</ss:Style>' +
            '<ss:Style ss:ID="even">' +
            '<ss:Interior ss:Pattern="Solid" />' +
            '</ss:Style>' +
            '<ss:Style ss:Parent="even" ss:ID="evendate">' +
            '<ss:NumberFormat ss:Format="yyyy-mm-dd" />' +
            '</ss:Style>' +
            '<ss:Style ss:Parent="even" ss:ID="evenint">' +
            '<ss:NumberFormat ss:Format="0" />' +
            '</ss:Style>' +
            '<ss:Style ss:Parent="even" ss:ID="evenfloat">' +
            '<ss:NumberFormat ss:Format="0.00" />' +
            '</ss:Style>' +
            '<ss:Style ss:ID="odd">' +
            '<ss:Interior ss:Pattern="Solid" />' +
            '</ss:Style>' +
            '<ss:Style ss:Parent="odd" ss:ID="odddate">' +
            '<ss:NumberFormat ss:Format="yyyy-mm-dd" />' +
            '</ss:Style>' +
            '<ss:Style ss:Parent="odd" ss:ID="oddint">' +
            '<ss:NumberFormat ss:Format="0" />' +
            '</ss:Style>' +
            '<ss:Style ss:Parent="odd" ss:ID="oddfloat">' +
            '<ss:NumberFormat ss:Format="0.00" />' +
            '</ss:Style>' +
            '</ss:Styles>' +
            worksheet.xml +
            '</ss:Workbook>';
    },

    createWorksheet: function(store,includeHidden) {
    	  var title = document.getElementById('tab_tit').innerHTML;
        // Calculate cell data types and extra class names which affect formatting
        var cellType = [];
        var cellTypeClass = [];
        var cm = this.getColumnModel();
        var totalWidthInPixels = 0;
        var colXml = '';
        var headerXml = '';
        var headerRowXmlArray = [];
        var visibleColumnCountReduction = 0;
        var colCount = cm.getColumnCount();
        var headRowCount = 0;
        var totalRowLength = 0;
        if(typeof(cm.rows) != "undefined"&&cm.rows != "")
        {
        	//|| cm.rows != ""
        	headRowCount = cm.rows.length;
        	for(var r = 0; r < headRowCount; r++)
        	{
        		var rowLength = cm.rows[r].length ;
        		totalRowLength += rowLength ;
        		var headerRowXml = '';
        		for(var t = 0, gcol = 0; t < rowLength; t++)
        		{
        			var group = cm.rows[r][t];
                	var w = Ext.grid.GridPanel.prototype.getCellWidth(group,gcol,cm);
                    headerRowXml += '<ss:Cell ss:StyleID="headercell" ss:MergeAcross="'+(group.colspan-1)+'">' +
                        '<ss:Data ss:Type="String">' + cm.rows[r][t].header + '</ss:Data>' +
                        '<ss:NamedCell ss:Name="Print_Titles" /></ss:Cell>';
                    cellType.push("String");
                    cellTypeClass.push("");
	        		gcol += group.colspan;
        		}
        		headerRowXmlArray[r] = headerRowXml ;
        	}
        }
        for (var i = 0; i < colCount; i++) {
            if ((cm.getDataIndex(i) != '')
                && (includeHidden || !cm.isHidden(i))) {
                var w = cm.getColumnWidth(i)
                totalWidthInPixels += w;
                if (cm.getColumnHeader(i) === ""){
                	cellType.push("None");
                	cellTypeClass.push("");
                	++visibleColumnCountReduction;
                }
                else
                {
                    colXml += '<ss:Column ss:AutoFitWidth="1" ss:Width="' + w + '" />';
                    headerXml += '<ss:Cell ss:StyleID="headercell">' +
                        '<ss:Data ss:Type="String">' + cm.getColumnHeader(i) + '</ss:Data>' +
                        '<ss:NamedCell ss:Name="Print_Titles" /></ss:Cell>';
                    cellType.push("String");
                    cellTypeClass.push("");
//                    alert(cm.getDataIndex(i));
//                    var fld = store.recordType.prototype.fields.get(cm.getDataIndex(i));
//                 alert(fld);
//                    switch(fld.type) {
//                        case "int":
//                            cellType.push("Number");
//                            cellTypeClass.push("int");
//                            break;
//                        case "float":
//                            cellType.push("Number");
//                            cellTypeClass.push("float");
//                            break;
//                        case "bool":
//                        case "boolean":
//                            cellType.push("String");
//                            cellTypeClass.push("");
//                            break;
//                        case "date":
//                            cellType.push("DateTime");
//                            cellTypeClass.push("date");
//                            break;
//                        default:
//                            cellType.push("String");
//                            cellTypeClass.push("");
//                            break;
//                    }
                }
            }
        }
      
        var visibleColumnCount = cellType.length - visibleColumnCountReduction - totalRowLength;

        var result = {
            height: 9000,
            width: Math.floor(totalWidthInPixels * 30) + 50
        };

        // Generate worksheet header details.
        var t = '<ss:Worksheet ss:Name="' + title + '">' +
            '<ss:Names>' +
            '<ss:NamedRange ss:Name="Print_Titles" ss:RefersTo="=\'' + title + '\'!R1:R2" />' +
            '</ss:Names>' +
            '<ss:Table x:FullRows="1" x:FullColumns="1"' +
            ' ss:ExpandedColumnCount="' + (visibleColumnCount + 2) +
            '" ss:ExpandedRowCount="' + (store.getCount() + headRowCount + 2) + '">' +
            colXml +
            '<ss:Row ss:Height="38">' +
            '<ss:Cell ss:StyleID="title" ss:MergeAcross="' + (visibleColumnCount - 1) + '">' +
            '<ss:Data xmlns:html="http://www.w3.org/TR/REC-html40" ss:Type="String">' +
            '<html:B>'+ title +'</html:B></ss:Data><ss:NamedCell ss:Name="Print_Titles" />' +
            '</ss:Cell>' +
            '</ss:Row>' ;
           
		if(totalRowLength > 0)
		{
			var headerRowArrayStr = "";
			for(var i = 0 ,len = headerRowXmlArray.length; i < len; i++)
			{
				t +=  '<ss:Row ss:AutoFitHeight="1">' + 
						headerRowXmlArray[i] +
						'</ss:Row>';
			}
			t += '<ss:Row ss:AutoFitHeight="1">' +
		            headerXml +
		            '</ss:Row>';
		}
		else
		{
			t += '<ss:Row ss:AutoFitHeight="1">' +
		            headerXml +
		            '</ss:Row>';
		}
        // Generate the data rows from the data in the Store
        for (var i = 0, it = store.data.items, l = it.length; i < l; i++) {
            t += '<ss:Row>';
            var cellClass = (i & 1) ? 'odd' : 'even';
            r = it[i].data;
            var k = 0;
            for (var j = 0; j < colCount; j++) {
                if ((cm.getDataIndex(j) != '')
                    && (includeHidden || !cm.isHidden(j))) {
                    var v = r[cm.getDataIndex(j)];
                    if (cellType[k] !== "None") {
                        t += '<ss:Cell ss:StyleID="' + cellClass + cellTypeClass[k] + '"><ss:Data ss:Type="' + cellType[k] + '">';
                        if (cellType[k] == 'DateTime') {
                            t += v.format('Y-m-d');
                        } else {
                            t += v;
                        }
                        t +='</ss:Data></ss:Cell>';
                    }
                    k++;
                }
            }
            t += '</ss:Row>';
        }
        result.xml = t + '</ss:Table>' +
            '<x:WorksheetOptions>' +
            '<x:PageSetup>' +
            '<x:Layout x:CenterHorizontal="1" x:Orientation="Landscape" />' +
            '<x:Footer x:Data="Page &amp;P of &amp;N" x:Margin="0.5" />' +
            '<x:PageMargins x:Top="0.5" x:Right="0.5" x:Left="0.5" x:Bottom="0.8" />' +
            '</x:PageSetup>' +
            '<x:FitToPage />' +
            '<x:Print>' +
            '<x:PrintErrors>Blank</x:PrintErrors>' +
            '<x:FitWidth>1</x:FitWidth>' +
            '<x:FitHeight>32767</x:FitHeight>' +
            '<x:ValidPrinterInfo />' +
            '<x:VerticalResolution>600</x:VerticalResolution>' +
            '</x:Print>' +
            '<x:Selected />' +
            '<x:DoNotDisplayGridlines />' +
            '<x:ProtectObjects>False</x:ProtectObjects>' +
            '<x:ProtectScenarios>False</x:ProtectScenarios>' +
            '</x:WorksheetOptions>' +
            '</ss:Worksheet>';
        return result;
    },
    getCellWidth:function(group,gcol,cm)
        {
        	var width = 0;
	        for (var i = gcol, len = gcol + group.colspan; i < len; i++) 
	        {
				if (!cm.isHidden(i)) {
					var cw = cm.getColumnWidth(i);
					if(typeof cw == 'number'){
						width += cw;
					}
				}
			}
			return width;
        }
});
