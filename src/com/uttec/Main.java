package com.uttec;

import com.uttec.views.Inicio;

public class Main {

	public static void main(String[] args) {

		Inicio inicio = new Inicio();
		inicio.setVisible(true);

		/*
		 * Writer.getInstance();
		 * 
		 * @SuppressWarnings("serial") Map<Content, String> pdf =
		 * Collections.unmodifiableMap(new HashMap<Content, String>() { {
		 * put(Content.TITLE, "An awesome title"); put(Content.BODY,
		 * "1.Song\n2.Song\n3.Song"); put(Content.ARTIST, "Leel Pump"); } });
		 * 
		 * try { Writer.writePDF(pdf.get(Content.TITLE), pdf); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}

}