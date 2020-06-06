package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {
	private Document doc;
	private PdfWriter pw;
	private Image map;
	private String[] rooms;
	private InvitedStudent is;
	private String out;
	private String[] urls;
	
	public PDFGenerator(InvitedStudent is, String map, String[] rooms, String out, String[] urls) {
		doc = new Document();
		try {
			pw = PdfWriter.getInstance(doc, new FileOutputStream(out+is.getName()+"Schedule.pdf"));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.is = is;
		try {
			this.map = Image.getInstance(map);
		} catch (BadElementException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.rooms = rooms;
		this.out = out;
		this.urls = urls;
	}
	
	private String loc(int i) {
		if(is.getSession(i) == null) return "";
		switch(is.getSession(i)) {
			case "gen":
				return rooms[1] + " - PHS Whole School Magnet: Parents\r\n" + 
						"                      " + rooms[2] + " - PHS Whole School Magnet: Students\r\n";
			case "g":
				return rooms[3] + " - Global Ecology House\r\n";
			case "m":
				return rooms[4] + " - Science, Math, Computer Science House\r\n";
			case "h":
				return rooms[5] + " - Humanities House\r\n";
			default:
				return "";
		}
	}
	
	public void generate() throws DocumentException {
		doc.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 20, BaseColor.BLACK);
		Paragraph p = new Paragraph(is.getName() + ", welcome to Poolesville High School!\r\nHere is your schedule for the evening:\r\n ", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		doc.add(p);
		
		font = FontFactory.getFont(FontFactory.HELVETICA, 17, Font.UNDERLINE, BaseColor.BLACK);
		p = new Paragraph("6:00 - 6:10     " + rooms[0], font);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		doc.add(p);
		
		p = new Paragraph("6:15 - 6:45     " + loc(0), font);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		doc.add(p);
		
		p = new Paragraph("6:50 - 7:20     " + loc(1), font);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		doc.add(p);
		
		p = new Paragraph("7:25 - 7:55     " + loc(2), font);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		doc.add(p);
		
		p = new Paragraph("8:00 - 8:30     " + loc(3), font);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		doc.add(p);
		
		Font gold = FontFactory.getFont(FontFactory.HELVETICA, 30, Font.BOLD, new BaseColor(191, 143, 0));
		p = new Paragraph(" \r\nPoolesville High School Invited Meeting Map\r\n", gold);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		doc.add(p);

		float scaler = ((doc.getPageSize().getWidth() - doc.leftMargin()
		               - doc.rightMargin()) / map.getWidth()) * 100;

		map.scalePercent(scaler);
		doc.add(map);
		
		font = FontFactory.getFont(FontFactory.HELVETICA, 20, BaseColor.BLACK);
		doc.add(new Paragraph(" \r\n \r\n", font));
		
		p = new Paragraph("Poolesville High School-\r\n" + 
				"More Than the Magnets!\r\n\r\n ", gold);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		doc.add(p);
		
		
		Font qr = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
		PdfPTable table = new PdfPTable(3);

		table.addCell(textCell("Where can you Innovate?\r\n" + 
				"Recreate? Advocate?\r\n" + 
				"(Clubs and Activities)", qr));
		table.addCell(textCell("Getting to School - Transportation", qr));
		table.addCell(textCell("Where Do PHS Students Go?\r\n" + 
				"- College and University Acceptance List\r\n", qr));
		
		try {
			table.addCell(Image.getInstance(new QRGenerator(urls[0]).generate()));
			table.addCell(Image.getInstance(new QRGenerator(urls[1]).generate()));
			table.addCell(Image.getInstance(new QRGenerator(urls[2]).generate()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.addCell(textCell("For the Compete Story -\r\n" + 
				"PHS Website\r\n", qr));
		table.addCell(textCell("Communication Options-List\r\n" + 
				"Serves and Parent Forums\r\n" + 
				"", qr));
		table.addCell(textCell("Sports! Sports! Sports!", qr));
		
		try {
			table.addCell(Image.getInstance(new QRGenerator(urls[3]).generate()));
			table.addCell(Image.getInstance(new QRGenerator(urls[4]).generate()));
			table.addCell(Image.getInstance(new QRGenerator(urls[5]).generate()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doc.add(table);
		
		Font qr2 = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD + Font.UNDERLINE, BaseColor.BLUE);
		Chunk c = new Chunk(" \r\n\r\nWhere can you Innovate? Recreate? Advocate?(Clubs and Activities): ", qr);
		Chunk c1 = new Chunk(urls[0], qr2);
		p = new Paragraph();
		p.add(c);
		p.add(c1);
		doc.add(p);
		c = new Chunk("Getting to School – Transportation: ", qr);
		c1 = new Chunk(urls[1], qr2);
		p = new Paragraph();
		p.add(c);
		p.add(c1);
		doc.add(p);
		c = new Chunk("Where Do PHS Students Go? College and University Acceptance List: ", qr);
		c1 = new Chunk(urls[2], qr2);
		p = new Paragraph();
		p.add(c);
		p.add(c1);
		c = new Chunk("For the Complete Story – PHS Website : ", qr);
		c1 = new Chunk(urls[3], qr2);
		p = new Paragraph();
		p.add(c);
		p.add(c1);
		doc.add(p);
		c = new Chunk("Communication Options – List Serves and Parent Forums : ", qr);
		c1 = new Chunk(urls[4], qr2);
		p = new Paragraph();
		p.add(c);
		p.add(c1);
		doc.add(p);
		c = new Chunk("Sports! Sports! Sports!: ", qr);
		c1 = new Chunk(urls[5], qr2);
		p = new Paragraph();
		p.add(c);
		p.add(c1);
		doc.add(p);
		doc.close();
	}
	
	private PdfPCell textCell(String text, Font font) {
		Paragraph p = new Paragraph(text, font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		PdfPCell cell = new PdfPCell(p);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		return cell;
	}
}
