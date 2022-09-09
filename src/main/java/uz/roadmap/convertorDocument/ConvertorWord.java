package uz.roadmap.convertorDocument;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class ConvertorWord {
    //
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //---------word document-------

    public void convertorWord(JSONArray jsonArray) throws IOException {
        XWPFDocument word = new XWPFDocument();
        XWPFParagraph paragraph = word.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(gson.toJson(jsonArray).toLowerCase(Locale.ROOT));
        FileOutputStream out = new FileOutputStream( new File("studentDataWord.docx"));
        word.write(out);
        out.close();
    }
}
