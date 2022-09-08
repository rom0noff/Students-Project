package uz.roadmap.document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConvertorFile {
    //
    public  void convertor() {
        try {
            //----------API findAll DataBase-----

            URL url = new URL("http://localhost:8181/api/student/showAll");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            URLConnection urlConnection = url.openConnection();
            InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream());
            JSONArray jsonArray = gson.fromJson(reader, JSONArray.class);

            //-----------PDF document write-------

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("file1.pdf"));
                document.open();
                Font font = FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK);
                Chunk chunk = new Chunk(gson.toJson(jsonArray).toLowerCase(Locale.ROOT), font);
                document.add(chunk);
                document.newPage();
                document.close();

                //---------word document-------

            XWPFDocument word = new XWPFDocument();
            XWPFParagraph paragraph = word.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(gson.toJson(jsonArray).toLowerCase(Locale.ROOT));
            FileOutputStream out = new FileOutputStream( new File("hero.docx"));
            word.write(out);
            out.close();

            //--------excel document------

            XSSFWorkbook workbook = new XSSFWorkbook();

            // spreadsheet object
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

            // writing the data into the sheets...

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
                    new File("studentData.xlsx"));

            workbook.write(out1);
            out1.close();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
