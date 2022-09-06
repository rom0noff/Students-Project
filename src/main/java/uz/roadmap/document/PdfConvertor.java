package uz.roadmap.document;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Autowired;
import uz.roadmap.service.StudentService;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfConvertor {
    //
    @Autowired
    private StudentService studentService;

//    public void pdfDocument() {
//        Document doc = new Document();
//        try {
//            PDDocument pdDocument = new PDDocument();
////            pdDocument.addPage(new PDPage());
////            pdDocument.save("/Desktop/document.pdf");
//            pdDocument.close();
//            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("document.pdf"));
//            System.out.println("document create");
//            doc.open();
//            doc.add(new Paragraph((Chunk) studentService.findAll()));
//            doc.close();
//            writer.close();
//
//        } catch (DocumentException | IOException e) {
//            e.printStackTrace();
//        }
//    }


}
