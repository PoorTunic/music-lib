package com.uttec.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RegisterSong extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtrelease;
	private JTextField txtpublisher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterSong frame = new RegisterSong();
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
	public RegisterSong() {
		setTitle("Register New Song");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("Name:");
		lblname.setForeground(new Color(255, 255, 255));
		lblname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblname.setBounds(51, 84, 76, 14);
		contentPane.add(lblname);
		
		JLabel lblRelease = new JLabel("Release:");
		lblRelease.setForeground(Color.WHITE);
		lblRelease.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblRelease.setBounds(51, 132, 76, 14);
		contentPane.add(lblRelease);
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setForeground(Color.WHITE);
		lblComment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblComment.setBounds(51, 182, 76, 14);
		contentPane.add(lblComment);
		
		JLabel lblpublisher = new JLabel("Publisher:");
		lblpublisher.setForeground(Color.WHITE);
		lblpublisher.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblpublisher.setBounds(51, 272, 76, 22);
		contentPane.add(lblpublisher);
		
		JLabel lbltitle = new JLabel("Register your new song now!");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setForeground(new Color(255, 255, 255));
		lbltitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbltitle.setBounds(68, 23, 354, 22);
		contentPane.add(lbltitle);
		
		txtname = new JTextField();
		txtname.setBounds(137, 82, 216, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtrelease = new JTextField();
		txtrelease.setColumns(10);
		txtrelease.setBounds(137, 130, 216, 20);
		contentPane.add(txtrelease);
		
		JTextArea txtcomment = new JTextArea();
		txtcomment.setBounds(137, 178, 216, 73);
		contentPane.add(txtcomment);
		
		txtpublisher = new JTextField();
		txtpublisher.setColumns(10);
		txtpublisher.setBounds(137, 274, 216, 20);
		contentPane.add(txtpublisher);
		
		JButton btnNewButton = new JButton("Register Now");
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setBounds(182, 349, 112, 32);
		contentPane.add(btnNewButton);
	}

}
