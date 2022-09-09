package uz.roadmap.convertorDocument;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConvertorExcel {
    //
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //--------excel document------

    public void convertorExcel(JSONArray jsonArray) throws IOException, ParseException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet
                = workbook.createSheet(" Student Data ");
        XSSFRow row;
        Map<String, Object[]> studentData
                = new TreeMap<String, Object[]>();
        studentData.put(
                "1",
                new Object[] { "ID", "FIRST_NAME", "LAST_NAME", "MIDDLE_NAME", "DESCRIPTION", "STUDY_STATE_DATE", "STUDY_END_DATE", "GENDER", "BIRTHDAY", "CREATED_AT" });
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(gson.toJson(jsonArray).toLowerCase(Locale.ROOT));
        JSONArray jsonArray1 = (JSONArray) object;

        for (int i = 0; i < jsonArray1.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray1.get(i);
            jsonObject.put("id", String.valueOf(jsonObject.get("id")));
            studentData.put(String.valueOf((i+2)), new Object[] {jsonObject.get("id"), jsonObject.get("first_name"), jsonObject.get("last_name"),
                    jsonObject.get("middle_name"), jsonObject.get("description"), jsonObject.get("study_state_date"), jsonObject.get("study_end_date"), jsonObject.get("gender")
                    ,jsonObject.get("birthdate"), jsonObject.get("created_at")});
        }
        Set<String> keyid = studentData.keySet();

        int rowid = 0;

        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        FileOutputStream out1 = new FileOutputStream(
                new File("studentDataExcel.xlsx"));

        workbook.write(out1);
        out1.close();
    }
}
