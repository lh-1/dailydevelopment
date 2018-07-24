package info.mjy.tools;

import com.google.common.collect.Sets;
import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class CreateModel {

    private static final long serialVersionUID = 0;

    @Test
    public void createModel() throws Exception {
        String baseUrl = "D:\\temp\\test\\class\\";
        String codeExcelUrl = "D:\\temp\\test\\model.xlsx";
        InputStream is = new FileInputStream(codeExcelUrl);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {

            if (xssfWorkbook.getSheetAt(numSheet).getLastRowNum() <= 1) {
                continue;
            }

            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            String sheetName = xssfSheet.getSheetName();
            File newFile = new File(baseUrl + sheetName + ".java");
            StringBuilder sb = new StringBuilder();
            sb.append("package info.mjy.tools.model;\n\n");

            //引入
            sb.append("import lombok.Data;\n");
            Set<String> typeSet = Sets.newHashSet();
            for (int i = 1; i < xssfSheet.getLastRowNum(); i++) {
                typeSet.add(xssfSheet.getRow(i).getCell(2) + "");
            }
            if (typeSet.contains("Date")) {
                sb.append("import java.util.Date;\n");
            }
            if (typeSet.contains("BigDecimal")) {
                sb.append("import java.math.BigDecimal;\n\n");
            }
            sb.append("import com.baozun.scm.primservice.baseinfo.model.BaseModel;\n");
            sb.append("\n");

            //类注解
            sb.append("@Data\n");
            sb.append(String.format("public class %s extends BaseModel {\n", sheetName));
            //serialVersionUID
            sb.append("    private static final long serialVersionUID = -1L;\n\n");
            //alias
            sb.append("    /** alias */\n");
            sb.append(String.format("    public static final String TABLE_ALIAS = \"%s\";\n", sheetName));
            for (int i = 0; i < xssfSheet.getLastRowNum(); i++) {
                sb.append(String.format("    public static final String ALIAS_%s = \"%s\";\n",
                        xssfSheet.getRow(i).getCell(0).toString().toUpperCase(),
                        xssfSheet.getRow(i).getCell(1)));
            }
            sb.append("\n    //columns START\n");
            //基础字段
            for (int i = 0; i < xssfSheet.getLastRowNum(); i++) {
                sb.append(String.format("    /** %s */\n", xssfSheet.getRow(i).getCell(1)));
                sb.append(String.format("    private %s %s;\n",
                        xssfSheet.getRow(i).getCell(2),
                        xssfSheet.getRow(i).getCell(0)));
            }
            sb.append("\n}");

            FileOutputStream os = new FileOutputStream(newFile);
            os.write(sb.toString().getBytes());

        }


    }

    public static void main(String[] args) {
        String path = "D:\\work\\code.xlsx";
        try {
            InputStream is = new FileInputStream(path);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            List<List<String>> result = new ArrayList<List<String>>();
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xassfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xassfSheet == null) {
                    continue;
                }
                for (int rowNum = 1; rowNum < xassfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xassfSheet.getRow(rowNum);
                    int minColIx = xssfRow.getFirstCellNum();
                    int maxColIx = xssfRow.getLastCellNum();
//                    List<ExcelDto> rowList = new ArrayList<ExcelDto>();
//                    for (int colIx = minColIx; colIx < maxColIx; colIx++) {
//                        XSSFCell cell = xssfRow.getCell(colIx);
//                        if (cell == null) {
//                            continue;
//                        }
//                        System.out.print(cell + "--||--");
//                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
