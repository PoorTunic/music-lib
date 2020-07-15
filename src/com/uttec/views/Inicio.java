package com.uttec.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
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
		setTitle("Welcome to Music-Lib");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 307);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitle = new JLabel("Hi! Welcome to Music-Lib");
		lbltitle.setForeground(new Color(255, 255, 255));
		lbltitle.setBackground(new Color(60, 179, 113));
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lbltitle.setBounds(162, 34, 248, 40);
		contentPane.add(lbltitle);
		
		JButton btnmenu = new JButton("Menu");
		btnmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnmenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnmenu.setForeground(new Color(255, 255, 255));
		btnmenu.setBackground(new Color(50, 205, 50));
		btnmenu.setBounds(238, 95, 109, 40);
		contentPane.add(btnmenu);
		
		JButton btnalbum = new JButton("Album");
		btnalbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSong vs = new ViewSong();
				vs.setVisible(true);
			}
		});
		btnalbum.setForeground(new Color(255, 255, 255));
		btnalbum.setBackground(new Color(50, 205, 50));
		btnalbum.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnalbum.setBounds(370, 167, 132, 40);
		contentPane.add(btnalbum);
		
		JButton btnartist = new JButton("Artist");
		btnartist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewArtist va = new ViewArtist();
				va.setVisible(true);
				
			}
		});
		
		btnartist.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnartist.setBackground(new Color(50, 205, 50));
		btnartist.setForeground(new Color(255, 255, 255));
		btnartist.setBounds(80, 167, 124, 40);
		contentPane.add(btnartist);
	}
}
