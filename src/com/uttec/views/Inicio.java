package com.uttec.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Inicio extends JFrame implements ActionListener {

	/**
	 * GUI Components
	 */
	private JPanel contentPane;
	private JLabel lblTitle;
	private JButton btnPdf;
	private JButton btnAlbum;
	private JButton btnArtist;

	/**
	 * Launches the application
	 * 
	 * @param args JVM args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setForeground(Color.ORANGE);
		setTitle("Music - Library Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 570, 307);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("Welcome to Music-Lib");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBackground(new Color(60, 179, 113));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblTitle.setBounds(162, 34, 248, 40);
		contentPane.add(lblTitle);

		btnPdf = new JButton("PDF");
		btnPdf.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnPdf.setForeground(new Color(255, 255, 255));
		btnPdf.setBackground(new Color(50, 205, 50));
		btnPdf.setBounds(238, 95, 109, 40);
		btnPdf.addActionListener(this);
		contentPane.add(btnPdf);

		btnAlbum = new JButton("Album");
		btnAlbum.setForeground(new Color(255, 255, 255));
		btnAlbum.setBackground(new Color(50, 205, 50));
		btnAlbum.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnAlbum.setBounds(370, 167, 132, 40);
		btnAlbum.addActionListener(this);
		contentPane.add(btnAlbum);

		btnArtist = new JButton("Artist");
		btnArtist.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnArtist.setBackground(new Color(50, 205, 50));
		btnArtist.setForeground(new Color(255, 255, 255));
		btnArtist.setBounds(80, 167, 124, 40);
		btnArtist.addActionListener(this);
		contentPane.add(btnArtist);

	}

	/**
	 * Handle Performed Actions
	 * 
	 * @see ActionListener#actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnPdf)) {
			PdfMenu pdfMenu = new PdfMenu();
			pdfMenu.setVisible(true);
			dispose();
		} else if (e.getSource().equals(this.btnArtist)) {
			ArtistMenu viewArtist = new ArtistMenu();
			viewArtist.setVisible(true);
			dispose();
		} else if (e.getSource().equals(this.btnAlbum)) {
			AlbumMenu albumMenu = new AlbumMenu();
			albumMenu.setVisible(true);
			dispose();
		}
	}
}
