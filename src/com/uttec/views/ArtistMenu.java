package com.uttec.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import com.uttec.entities.Artist;
import com.uttec.views.dialogs.RegisterArtist;

@SuppressWarnings("serial")
public class ArtistMenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblAction;
	private JLabel lblBio;
	private JLabel lblDebut;
	private JLabel lblArtistName;
	private JButton btnAdd;
	private JButton btnDelete;

	private List<Artist> artistToSave = new ArrayList<Artist>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtistMenu frame = new ArtistMenu();
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
	public ArtistMenu() {
		setTitle("Artist Menu");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 356);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblArtistName = new JLabel("Artist Name");
		lblArtistName.setForeground(new Color(255, 255, 255));
		lblArtistName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblArtistName.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistName.setBounds(28, 51, 76, 20);
		contentPane.add(lblArtistName);

		lblDebut = new JLabel("Debut ");
		lblDebut.setForeground(new Color(255, 255, 255));
		lblDebut.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDebut.setHorizontalAlignment(SwingConstants.CENTER);
		lblDebut.setBounds(193, 54, 46, 14);
		contentPane.add(lblDebut);

		lblBio = new JLabel("Bibliography");
		lblBio.setForeground(new Color(255, 255, 255));
		lblBio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblBio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBio.setBounds(343, 51, 76, 20);
		contentPane.add(lblBio);

		lblAction = new JLabel("Actions");
		lblAction.setForeground(new Color(255, 255, 255));
		lblAction.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		lblAction.setBounds(500, 54, 46, 14);
		contentPane.add(lblAction);

		lblTitle = new JLabel("The artists we have for you!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(163, 11, 265, 20);
		contentPane.add(lblTitle);

		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBounds(473, 82, 89, 23);
		contentPane.add(btnDelete);

		btnAdd = new JButton("Add Artist");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBackground(new Color(50, 205, 50));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBounds(232, 277, 127, 29);
		contentPane.add(btnAdd);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnAdd)) {
			RegisterArtist registerArtist = new RegisterArtist(this);
			String[] data = registerArtist.run();
			if (data != null) {
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					Date bornDate = formatter.parse(data[3]);
					Artist newArtist = new Artist(UUID.randomUUID(), data[0], data[1], data[2], bornDate);
					this.artistToSave.add(newArtist);
				} catch (ParseException ex) {
					new JOptionPane("Error en la fecha ingresada", JOptionPane.WARNING_MESSAGE);
				} catch (Exception ex) {
					new JOptionPane("Error, intente de nuevo", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}
