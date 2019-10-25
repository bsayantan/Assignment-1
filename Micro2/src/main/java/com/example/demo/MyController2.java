package com.example.demo;
import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyController2 {
	String str1=null,str2=null,str=null;
	int c=0,ct=0;
	boolean flag=true;
	@RequestMapping("/second")
	public String fun3() throws EncryptedDocumentException, InvalidFormatException, IOException
	{		
		read();		
		return str;
	}
	public void read() throws IOException, EncryptedDocumentException, InvalidFormatException
    {
			String path = "f://excel.xls";	
			Workbook workbook = WorkbookFactory.create(new File(path));
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			for (Row row: sheet) {
	            for(org.apache.poi.ss.usermodel.Cell cell: row) {
	                String cellValue = dataFormatter.formatCellValue(cell);
	                System.out.print(cellValue + "\t");
	                if(c==0)
	                {
	                	str1= new String(cellValue);
	                	c++;
	                }
	                else
	                {
	                    	str2= new String(cellValue);
	                    	c=0;
	                }
	               }
	           if(flag==true) {
	            str=str1+","+str2;
	            flag=false;
	            }
	            else
	                str=str+","+str1+","+str2;
	        }
		// TODO Auto-generated method stub
		
	}
	
}
