package com.uttec;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.uttec.enums.Content;
import com.uttec.pdf.Writer;

public class Main {

	public static void main(String[] args) {
		Writer.getInstance();

		@SuppressWarnings("serial")
		Map<Content, String> pdf = Collections.unmodifiableMap(new HashMap<Content, String>() {
			{
				put(Content.TITLE, "An awesome title");
				put(Content.BODY, "1.Song\n2.Song\n3.Song");
				put(Content.ARTIST, "Leel Pump");
			}
		});

		try {
			Writer.writePDF(pdf.get(Content.TITLE), pdf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}