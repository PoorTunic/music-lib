package com.uttec.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.uttec.entities.Artist;
import com.uttec.views.dialogs.RegisterAlbum;
import com.uttec.views.dialogs.RegisterSong;

@SuppressWarnings("serial")
public class SongMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JRadioButton dbbtnArtist;
	private JRadioButton rbtbnAlbum;
	private JRadioButton rdbtnBand;
	private JLabel lblTitle;
	private JButton btnSearch;
    private JLabel lblSong;
    private JLabel lblAlbum;
    private JLabel lblArtist;
    private JButton btnNewAlbum;
    private JButton btnNewSong;
    
    private String[] data;
    
    private ArrayList<String> SongToSave = new ArrayList<String>();
    
    public String[] run() {
    	setVisible(true);
    	return this.data;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SongMenu frame = new SongMenu();
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
	public SongMenu() {
		setTitle("Music List");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 606, 502);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dbbtnArtist = new JRadioButton("Artist Name");
		dbbtnArtist.setBackground(new Color(0, 0, 0));
		dbbtnArtist.setForeground(new Color(255, 255, 255));
		dbbtnArtist.setBounds(30, 49, 109, 23);
		contentPane.add(dbbtnArtist);

		rbtbnAlbum = new JRadioButton("Album Name");
		rbtbnAlbum.setBackground(new Color(0, 0, 0));
		rbtbnAlbum.setForeground(new Color(255, 255, 255));
		rbtbnAlbum.setBounds(260, 49, 109, 23);
		contentPane.add(rbtbnAlbum);

		rdbtnBand = new JRadioButton("Band Name");
		rdbtnBand.setBackground(new Color(0, 0, 0));
		rdbtnBand.setForeground(new Color(255, 255, 255));
		rdbtnBand.setBounds(448, 49, 109, 23);
		contentPane.add(rdbtnBand);

		lblTitle = new JLabel("Music List!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(202, 11, 220, 14);
		contentPane.add(lblTitle);

		txtSearch = new JTextField();
		txtSearch.setBounds(88, 79, 418, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = new String[1];
				data[0] = txtSearch.getText().trim().toUpperCase();
				dispose();
			}
		});
		
		
		btnSearch.setBackground(new Color(50, 205, 50));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBounds(260, 110, 109, 23);
		contentPane.add(btnSearch);

		lblSong = new JLabel("Song Name");
		lblSong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSong.setHorizontalAlignment(SwingConstants.CENTER);
		lblSong.setForeground(new Color(255, 255, 255));
		lblSong.setBounds(64, 164, 76, 23);
		contentPane.add(lblSong);

		lblAlbum = new JLabel("Album Name");
		lblAlbum.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setForeground(new Color(255, 255, 255));
		lblAlbum.setBounds(275, 164, 76, 23);
		contentPane.add(lblAlbum);

		lblArtist = new JLabel("Artist Name");
		lblArtist.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setForeground(new Color(255, 255, 255));
		lblArtist.setBounds(448, 164, 86, 23);
		contentPane.add(lblArtist);
	

		btnNewAlbum = new JButton("Register New Album");
		
		btnNewAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterAlbum ra = new RegisterAlbum();
				ra.setVisible(true);
			}
		});
		
		btnNewAlbum.setForeground(Color.WHITE);
		btnNewAlbum.setBackground(new Color(50, 205, 50));
		btnNewAlbum.setBounds(88, 406, 158, 32);
		contentPane.add(btnNewAlbum);

		btnNewSong = new JButton("Register New Song");
		btnNewSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterSong rg = new RegisterSong();
				rg.setVisible(true);
			}
		});
		btnNewSong.setForeground(Color.WHITE);
		btnNewSong.setBackground(new Color(50, 205, 50));
		btnNewSong.setBounds(356, 406, 150, 32);
		contentPane.add(btnNewSong);
	}
}
