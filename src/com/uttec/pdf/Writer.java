package com.uttec.pdf;

import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import com.uttec.enums.Content;

public class Writer {

	private static Writer instance;
	private static String DEST = "results";
	@SuppressWarnings({ "serial", "unused" })
	private static final Map<String, Font> FONTS = Collections.unmodifiableMap(new HashMap<String, Font>() {
		{
			put("HELV", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
		}
	});

	private Writer() {
		createPath();
	}

	public static Writer getInstance() {
		if (instance == null) {
			instance = new Writer();
		}
		return instance;
	}

	public static void close() {
		instance = null;
	}

	private void createPath() {
		java.io.File folder = new java.io.File(DEST);
		if (!folder.exists()) {
			folder.mkdir();
		}
	}

	public static void writePDF(String filename, Map<Content, String> pdf) throws Exception {
		Document doc = new Document(new Rectangle(1015, 445), 40, 40, 40, 40);

		PdfWriter.getInstance(doc, new FileOutputStream(DEST + "/" + filename + ".pdf"));
		doc.open();

		doc.addTitle(pdf.get(Content.TITLE));
		doc.addKeywords("Java, iText, UTTEC");
		doc.addAuthor("Daniel CA, Juan A OO, Daniela HH");
		doc.addCreator("Daniel CA, Juan A OO, Daniela HH");

		doc.add(new Paragraph(pdf.get(Content.TITLE)));
		doc.add(new Paragraph(pdf.get(Content.BODY)));
		doc.add(new Paragraph(pdf.get(Content.ARTIST)));
		//Image img = Image.getInstance(pdf.get(Content.IMG));
		//PdfImage stream = new PdfImage(img, "", null);
		//stream.put(new PdfName("ID"), new PdfName("img"));
		
		doc.close();
	}

}
