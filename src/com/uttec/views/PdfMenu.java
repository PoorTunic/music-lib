package com.uttec.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class PdfMenu extends JFrame implements ActionListener {

	JPanel root;
	SpringLayout layout;

	JButton jbtCreateArtist;
	JButton jbtCreateBand;
	JButton jbtFind;
	JTextField jtfQuery;

	JTable jtbResult;
	JScrollPane jScroll;

	JRadioButton jrbByName;
	JRadioButton jrbByAlbum;
	JRadioButton jrbByBSName;
	ButtonGroup bgSearcher;

	public PdfMenu() {
		super();

		setBounds(100, 100, 860, 640);

		setTitle("Proyecto - Librería musical");
		setDefaultLookAndFeelDecorated(true);

		root = new JPanel();
		root.setPreferredSize(new Dimension(860, 640));
		getContentPane().add(root);

		layout = new SpringLayout();
		root.setLayout(layout);

		jtfQuery = new JTextField();
		jtfQuery.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				queryUpdate(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				queryUpdate(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				queryUpdate(e);
			}
		});

		bgSearcher = new ButtonGroup();
		jrbByName = new JRadioButton("Nombre del artista");
		jrbByAlbum = new JRadioButton("Nombre álbum");
		jrbByBSName = new JRadioButton("Nombre del grupo");

		bgSearcher.add(jrbByName);
		bgSearcher.add(jrbByAlbum);
		bgSearcher.add(jrbByBSName);

		jtbResult = new JTable(new String[][] {}, this.tableHeaders());
		jScroll = new JScrollPane(jtbResult);

		root.add(jrbByName);
		root.add(jrbByAlbum);
		root.add(jrbByBSName);

		root.add(jtfQuery);

		layout.putConstraint(SpringLayout.NORTH, jrbByName, 10, SpringLayout.NORTH, root);
		layout.putConstraint(SpringLayout.WEST, jrbByName, 10, SpringLayout.WEST, root);

		layout.putConstraint(SpringLayout.NORTH, jrbByAlbum, 10, SpringLayout.NORTH, root);
		layout.putConstraint(SpringLayout.WEST, jrbByAlbum, 210, SpringLayout.WEST, root);

		layout.putConstraint(SpringLayout.NORTH, jrbByBSName, 10, SpringLayout.NORTH, root);
		layout.putConstraint(SpringLayout.WEST, jrbByBSName, 410, SpringLayout.WEST, root);

		layout.putConstraint(SpringLayout.NORTH, jtfQuery, 50, SpringLayout.NORTH, root);
		layout.putConstraint(SpringLayout.WEST, jtfQuery, 10, SpringLayout.WEST, root);
		layout.putConstraint(SpringLayout.EAST, jtfQuery, 450, SpringLayout.WEST, root);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.jbtCreateArtist)) {
			// Open new Dialog
		} else if (arg0.getSource().equals(this.jbtCreateBand)) {
			// Open new Dialog
		}
	}

	private String[] tableHeaders() {
		return new String[] { "ID", "TITLE", "CREATOR", "RELEASE DATE" };
	}

	private void queryUpdate(DocumentEvent e) {
		// fetch this.jtfQuery.getText().trim()
	}
}
