package com.xyz.ata.print;



import java.util.ArrayList;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.xyz.ata.bean.ReservationBean;
 
/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {
 
    @SuppressWarnings("unchecked")
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        ArrayList<ReservationBean> list=(ArrayList<ReservationBean>) model.get("reservations");
         
        doc.add(new Paragraph("Your Bookings"));
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("ReservationID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Boarding Point", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Drop Point", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Journey Date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Vehicle ID", font));
        table.addCell(cell);
         
        // write table row data
        for (ReservationBean reservation : list) {
        	
            table.addCell(reservation.getReservationID());
            table.addCell(reservation.getBoardingPoint());
            table.addCell(reservation.getDropPoint());
            table.addCell(String.valueOf(reservation.getJourneyDate()));
            table.addCell(reservation.getVehicleID());
        }
         
        doc.add(table);
         
    }
 
}
