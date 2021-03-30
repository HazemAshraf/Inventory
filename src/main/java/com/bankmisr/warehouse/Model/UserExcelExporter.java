package com.bankmisr.warehouse.Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.bankmisr.warehouse.entity.Items;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Items> listItems;

    public UserExcelExporter(List<Items> listItems) {
        this.listItems = listItems;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Items");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ItemCategory", style);
        createCell(row, 1, "ItemTypes", style);
        createCell(row, 2, "ItemBrand", style);
        createCell(row, 3, "ItemModel", style);
        createCell(row, 4, "Description", style);
        createCell(row, 5, "Item Code", style);
        createCell(row, 6, "ItemTagType", style);
        createCell(row, 7, "ItemImage", style);
        createCell(row, 8, "LocationLevel1", style);
        createCell(row, 9, "LocationLevel2", style);
        createCell(row, 10, "LocationLevel3", style);
        createCell(row, 11, "LocationLevel4", style);
        createCell(row, 12, "Quantity", style);
        createCell(row, 13, "UserCode", style);
        createCell(row, 14, "Username", style);
        createCell(row, 15, "SerialNumber", style);
        createCell(row, 16, "BusinessLine", style);
        createCell(row, 17, "Department", style);
        createCell(row, 18, "Notes", style);
        createCell(row, 19, "PurchaseDate", style);
        createCell(row, 20, "OperationDate", style);
        createCell(row, 21, "SupplierName", style);
        createCell(row, 22, "Useful life", style);
        createCell(row, 23, "WarrantyEndDate", style);
        createCell(row, 24, "Price", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        else if (value == null) {
            cell.setCellValue("");
        }else {
            cell.setCellValue(value.toString());
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Items item : listItems) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, item.getCategoryId().getName(), style);
            createCell(row, columnCount++, item.getType(), style);
            createCell(row, columnCount++, item.getBrand(), style);
            createCell(row, columnCount++, item.getModel(), style);
            createCell(row, columnCount++, item.getDescription(), style);
            createCell(row, columnCount++, item.getItemCode(), style);
            createCell(row, columnCount++, item.getAssetTagType(), style);
            if(item.getPictureId() != null) createCell(row, columnCount++, item.getPictureId().getUrl(), style);
            else createCell(row, columnCount++, "", style);
            createCell(row, columnCount++, item.getLocationLevel1(), style);
            createCell(row, columnCount++, item.getLocationLevel2(), style);
            createCell(row, columnCount++, item.getLocationLevel3(), style);
            createCell(row, columnCount++, item.getLocationLevel4(), style);
            createCell(row, columnCount++, item.getQuantity(), style);
            createCell(row, columnCount++, item.getUserCode(), style);
            createCell(row, columnCount++, item.getUserName(), style);
            createCell(row, columnCount++, item.getSerialNo(), style);
            createCell(row, columnCount++, item.getBusinessLine(), style);
            createCell(row, columnCount++, item.getDepartmentId().getName(), style);
            createCell(row, columnCount++, item.getNotes(), style);
            createCell(row, columnCount++, item.getPurchaseDate(), style);
            createCell(row, columnCount++, item.getOperationDate(), style);
            createCell(row, columnCount++, item.getSupplierName(), style);
            createCell(row, columnCount++, item.getUsefulLife(), style);
            createCell(row, columnCount++, item.getWarrantyEndDate(), style);
            createCell(row, columnCount++, item.getPrice(), style);


        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
