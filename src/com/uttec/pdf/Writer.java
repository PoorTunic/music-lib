package com.uttec.pdf;

import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.uttec.entities.Album;
import com.uttec.enums.Content;

/**
 * Represents the PDF Writer to create PDF files
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 *
 */
public class Writer {

	/**
	 * PDF Writer Instance
	 */
	private static Writer instance;
	/**
	 * Path to store PDF
	 */
	private static String DEST = "results";

	/**
	 * PDF Content map
	 */
	@SuppressWarnings({ "serial", "unused" })
	private static final Map<String, Font> FONTS = Collections.unmodifiableMap(new HashMap<String, Font>() {
		{
			put("HELV", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
		}
	});

	/**
	 * Constructor
	 */
	private Writer() {
		createPath();
	}

	/**
	 * Return the singleton instance
	 * 
	 * @return Writer
	 */
	public static Writer getInstance() {
		if (instance == null) {
			instance = new Writer();
		}
		return instance;
	}

	/**
	 * Destroy the instance
	 */
	public static void close() {
		instance = null;
	}

	/**
	 * Create PDF folder
	 */
	private void createPath() {
		java.io.File folder = new java.io.File(DEST);
		if (!folder.exists()) {
			folder.mkdir();
		}
	}

	/**
	 * Create the PDF content
	 * 
	 * @param filename of the document
	 * @param pdf      body parts
	 * @throws Exception Can't create the document
	 */
	public void writePDF(String filename, Map<Content, String> pdf) throws Exception {
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

		doc.close();
	}

	public boolean createPDF(Album fetchedAlbum) {
		boolean created = false;
		String filename = fetchedAlbum.getName();
		String strSongs = "";
		for (int i = 0; i < fetchedAlbum.getSongs().size(); i++) {
			strSongs += (i + 1) + ".- " + fetchedAlbum.getSongs().get(i).getName() + "\n";
		}

		Map<Content, String> pdf = new HashMap<Content, String>();
		pdf.put(Content.TITLE, fetchedAlbum.getName());
		pdf.put(Content.BODY, strSongs);
		pdf.put(Content.ARTIST, fetchedAlbum.getBand().getName());

		try {
			writePDF(filename, pdf);
			created = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

}
