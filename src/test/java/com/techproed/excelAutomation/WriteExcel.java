package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public WriteExcel() throws FileNotFoundException {
    }

    /*
        Write the Row 1 Column 4 : POPULATION
        And Set the value of Paris population Row 2 Column 4 = 21480000
         */
    @Test
    public void writeExcel() throws IOException {
        String path = "/Users/Dell E7250/Desktop/Capitals.xlsx";
        FileInputStream file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);  //getting the 1.row
        Cell cell = row.createCell(3);  //creating a cell
        cell.setCellValue("POPULATION");
      //  row.removeCell(row.getCell(4));

        //opening a file to send data to the created cell
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        //we are creating the cell on the 2. row and 4. cell, setting the value at 21480000
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("21480000");
        workbook.write(fileOutputStream);  // writing on the cell and saving the workbook


        fileOutputStream.close();
        file.close();
        workbook.close();






}
}
