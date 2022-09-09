package uz.roadmap.convertorDocument;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class ConvertorFile {
    //
            //----------API findAll DataBase-----

    public  void convertor() {
        ConvertorExcel excel = new ConvertorExcel();
        ConvertorPdf pdf = new ConvertorPdf();
        ConvertorWord word = new ConvertorWord();
        try {
            URL url = new URL("http://localhost:8181/api/student/showAll");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            URLConnection urlConnection = url.openConnection();
            InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream());
            JSONArray jsonArray = gson.fromJson(reader, JSONArray.class);

            //entering information into methods

            excel.convertorExcel(jsonArray);
            word.convertorWord(jsonArray);
            pdf.convertorPdf(jsonArray);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

}
