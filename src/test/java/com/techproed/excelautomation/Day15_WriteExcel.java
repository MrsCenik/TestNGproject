package com.techproed.excelautomation;
        /*
        Create a new class: WriteExcel
        Create a new method: writeExcel()
        Store the path of the file as string and open the file
        Open the workbook
        Open the first worksheet
        Go to the first row
        Create a cell on the 3rd index on the first row
        Write “POPULATION” on that cell
        Create a cell on the 2nd row 4th cell(index3), and write 150000
        Create a cell on the 3rd row 4th cell(index3), and write 250000
        Create a cell on the 4th row 4th cell(index3), and write 54000
        Write and save the workbook
        Close the file
        Close the workbook
         */
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day15_WriteExcel{
    @Test
    public void writeExcel() throws IOException {
        //Store the path of the file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";

        //Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0);//index of sheet starts at 0

        //Go to first row
        Row firstRow = sheet.getRow(0);//index of row starts at 0

        // Create a cell on the 2nd index or 3rd column on the first row
                //go to the first row 2nd index
                //create a cell in 2nd column
        Cell row1Cell3 = firstRow.createCell(2);

        // Write “POPULATION” on that cell
        row1Cell3.setCellValue("POPULATION");

        //Create a cell on the 2nd row 4th cell(index3), and write 150000
        sheet.getRow(1).createCell(2).setCellValue(150000);

        //Create a cell on the 3rd row 4th cell(index3), and write 250000
        sheet.getRow(2).createCell(2).setCellValue(250000);

        //Create a cell on the 4th row 4th cell(index3), and write 54000
        sheet.getRow(3).createCell(2).setCellValue(54000);

        //Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Close the file
        fileInputStream.close();
        fileOutputStream.close();

        //Close the workbook
        workbook.close();
    }

}
