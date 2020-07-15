package com.uttec.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSong extends JFrame {

	private JPanel contentPane;
	private JTextField txtsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSong frame = new ViewSong();
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
	public ViewSong() {
		setTitle("Music List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton dbbtnartist = new JRadioButton("Artist Name");
		dbbtnartist.setBackground(new Color(0, 0, 0));
		dbbtnartist.setForeground(new Color(255, 255, 255));
		dbbtnartist.setBounds(30, 49, 109, 23);
		contentPane.add(dbbtnartist);
		
		JRadioButton rbtbnalbum = new JRadioButton("Album Name");
		rbtbnalbum.setBackground(new Color(0, 0, 0));
		rbtbnalbum.setForeground(new Color(255, 255, 255));
		rbtbnalbum.setBounds(260, 49, 109, 23);
		contentPane.add(rbtbnalbum);
		
		JRadioButton rdbtnband = new JRadioButton("Band Name");
		rdbtnband.setBackground(new Color(0, 0, 0));
		rdbtnband.setForeground(new Color(255, 255, 255));
		rdbtnband.setBounds(448, 49, 109, 23);
		contentPane.add(rdbtnband);
		
		JLabel lbltitle = new JLabel("Music List!");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbltitle.setForeground(new Color(255, 255, 255));
		lbltitle.setBounds(202, 11, 220, 14);
		contentPane.add(lbltitle);
		
		txtsearch = new JTextField();
		txtsearch.setBounds(88, 79, 418, 20);
		contentPane.add(txtsearch);
		txtsearch.setColumns(10);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBackground(new Color(50, 205, 50));
		btnsearch.setForeground(new Color(255, 255, 255));
		btnsearch.setBounds(260, 110, 109, 23);
		contentPane.add(btnsearch);
		
		JLabel lblsong = new JLabel("Song Name");
		lblsong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblsong.setHorizontalAlignment(SwingConstants.CENTER);
		lblsong.setForeground(new Color(255, 255, 255));
		lblsong.setBounds(64, 164, 76, 23);
		contentPane.add(lblsong);
		
		JLabel lblalbum = new JLabel("Album Name");
		lblalbum.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblalbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblalbum.setForeground(new Color(255, 255, 255));
		lblalbum.setBounds(275, 164, 76, 23);
		contentPane.add(lblalbum);
		
		JLabel lblartist = new JLabel("Artist Name");
		lblartist.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblartist.setHorizontalAlignment(SwingConstants.CENTER);
		lblartist.setForeground(new Color(255, 255, 255));
		lblartist.setBounds(448, 164, 86, 23);
		contentPane.add(lblartist);
		
		JButton btnnewalbum = new JButton("Register New Album");
		btnnewalbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterAlbum ra = new RegisterAlbum();
				ra.setVisible(true);
			}
		});
		btnnewalbum.setForeground(Color.WHITE);
		btnnewalbum.setBackground(new Color(50, 205, 50));
		btnnewalbum.setBounds(88, 406, 158, 32);
		contentPane.add(btnnewalbum);
		
		JButton btnnewsong = new JButton("Register New Song");
		btnnewsong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterSong rg= new RegisterSong();
				rg.setVisible(true);
			}
		});
		btnnewsong.setForeground(Color.WHITE);
		btnnewsong.setBackground(new Color(50, 205, 50));
		btnnewsong.setBounds(356, 406, 150, 32);
		contentPane.add(btnnewsong);
	}
}
