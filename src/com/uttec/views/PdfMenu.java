package com.uttec.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.uttec.controllers.AlbumControl;
import com.uttec.controllers.ArtistControl;
import com.uttec.controllers.BandControl;
import com.uttec.controllers.SearcherContext;
import com.uttec.entities.Album;

@SuppressWarnings("serial")
public class PdfMenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JButton btnSearch;
	private JTextField txtArtist;
	private JRadioButton rdbtnArtisName;
	private JRadioButton rdbtnAlbumName;
	private JRadioButton rdbtnBandName;

	private String[] data;

	private List<Album> albums = new ArrayList<Album>();

	public String[] run() {
		setVisible(true);
		return this.data;
	}

	/* dejo pendiente la acción que se vaya a relizar */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PdfMenu frame = new PdfMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PdfMenu() {
		setTitle("Generate PDF");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 505);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("Generate PDF Now!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(206, 11, 189, 26);
		contentPane.add(lblTitle);

		btnSearch = new JButton("Generate PDF");
		btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSearch.setBackground(new Color(50, 205, 50));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBounds(235, 410, 149, 34);
		contentPane.add(btnSearch);

		rdbtnArtisName = new JRadioButton("Artis Name");
		rdbtnArtisName.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnArtisName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnArtisName.setForeground(new Color(255, 255, 255));
		rdbtnArtisName.setBackground(new Color(0, 0, 0));
		rdbtnArtisName.setBounds(52, 56, 109, 23);
		contentPane.add(rdbtnArtisName);

		rdbtnAlbumName = new JRadioButton("Album Name");
		rdbtnAlbumName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnAlbumName.setBackground(new Color(0, 0, 0));
		rdbtnAlbumName.setForeground(new Color(255, 255, 255));
		rdbtnAlbumName.setBounds(235, 56, 109, 23);
		contentPane.add(rdbtnAlbumName);

		rdbtnBandName = new JRadioButton("Band Name");
		rdbtnBandName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnBandName.setBackground(new Color(0, 0, 0));
		rdbtnBandName.setForeground(new Color(255, 255, 255));
		rdbtnBandName.setBounds(422, 56, 109, 23);
		contentPane.add(rdbtnBandName);

		txtArtist = new JTextField();
		txtArtist.setBounds(72, 98, 410, 20);
		contentPane.add(txtArtist);
		txtArtist.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnSearch)) {
			if (rdbtnBandName.isSelected()) {
				SearcherContext ctx = new SearcherContext(new BandControl());
				this.albums = ctx.search(this.txtArtist.getText().trim().toUpperCase());
			} else if (rdbtnArtisName.isSelected()) {
				SearcherContext ctx = new SearcherContext(new ArtistControl());
				this.albums = ctx.search(this.txtArtist.getText().trim().toUpperCase());
			} else if (rdbtnAlbumName.isSelected()) {
				SearcherContext ctx = new SearcherContext(new AlbumControl());
				this.albums = ctx.search(this.txtArtist.getText().trim().toUpperCase());
			}
		}
	}
}