package uz.roadmap.convertorDocument;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.stream.Stream;

public class ConvertorPdf {
    //
    //-----------PDF document write-------

    public void convertorPdf(JSONArray jsonArray) throws IOException, DocumentException, URISyntaxException, ParseException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("studentDataPdf.pdf"));

        document.open();

        PdfPTable table = new PdfPTable(10);
        addTableHeader(table);
        addRows(table,jsonArray);
        document.add(table);
        document.close();

    }
    private void addTableHeader(PdfPTable table) {
            Stream.of("id", "first_name", "last_name",
                            "middle_name", "description", "study_state_date", "study_end_date", "gender"
                            ,"birthdate", "created_at")
                    .forEach(columnTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setBorderWidth(1);
                        header.setPhrase(new Phrase(columnTitle));
                        table.addCell(header);
                    });
    }
    private void addRows(PdfPTable table,JSONArray jsonArray) throws ParseException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(gson.toJson(jsonArray).toLowerCase(Locale.ROOT));
        JSONArray jsonArray1 = (JSONArray) object;
        for (int i = 0; i < jsonArray1.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray1.get(i);
            table.addCell(String.valueOf(jsonObject.get("id")));
            table.addCell(String.valueOf(jsonObject.get("first_name")));
            table.addCell(String.valueOf(jsonObject.get("last_name")));
            table.addCell(String.valueOf(jsonObject.get("middle_name")));
            table.addCell(String.valueOf(jsonObject.get("description")));
            table.addCell(String.valueOf(jsonObject.get("study_state_date")));
            table.addCell(String.valueOf(jsonObject.get("study_end_date")));
            table.addCell(String.valueOf(jsonObject.get("gender")));
            table.addCell(String.valueOf(jsonObject.get("birthdate")));
            table.addCell(String.valueOf(jsonObject.get("created_at")));
        }
    }
}
