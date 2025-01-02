package utilities;

    import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import org.apache.poi.ss.usermodel.DataFormatter;


	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility 
	{
		public FileInputStream fi;
		public FileOutputStream fo;
		public XSSFWorkbook workbook;
		public XSSFSheet sheet;
		public XSSFRow row;
		public XSSFCell cell;
		public CellStyle style;
		String path;
		public  ExcelUtility (String path)
		{
			this.path=path;
		}
		public int getRowCount(String Sheet1) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(Sheet1);
			int rowcount=sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowcount;
		}

		public int getCellCount(String Sheet1, int rownum) throws IOException {
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi); 
			sheet=workbook.getSheet(Sheet1); 
			row=sheet.getRow(rownum);
			int cellcount=row.getLastCellNum();
			workbook.close();
			fi.close();
			return cellcount;
		}
		public String getCellData(String Sheet1, int rownum, int colnum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(Sheet1);
			row=sheet.getRow(rownum); 
			cell=row.getCell(colnum);
			DataFormatter formatter = new DataFormatter();
			String data;
			try
			{
				data = formatter.formatCellValue(cell);
			}
			catch(Exception e)
			{
				data="";
			}
			workbook.close(); 
			fi.close(); 
			return data;
		}
		public void setCellData(String Sheet1, int rownum, int colnum, String data) throws IOException
		{
			File xlfile=new File(path);
			if(!xlfile.exists()) // If file not exists then create new file
			{
				workbook=new XSSFWorkbook();
			}

			fo=new FileOutputStream(path);
			workbook.write(fo);

			fi=new FileInputStream(path); 
			workbook=new XSSFWorkbook(fi);

			if(workbook.getSheetIndex(Sheet1)==-1) // If sheet not exists then create new Sheet workbook.createSheet(sheetName);
				sheet=workbook.getSheet(Sheet1);

			if(sheet.getRow(rownum)==null) // If row not exists then create new Row sheet.createRow(rownum);
				row=sheet.getRow(rownum);
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}
	}


