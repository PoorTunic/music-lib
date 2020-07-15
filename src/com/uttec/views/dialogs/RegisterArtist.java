package com.uttec.views.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class RegisterArtist extends JDialog {

	private JPanel contentPane;
	private JTextField txtArtistName;
	private JTextField txtName;
	private JTextField txtDebut;
	private JTextArea txaBio;
	private String[] data;
	private JLabel lblTitle;
	private JLabel lblType;
	private JLabel lblArtistName;
	private JLabel lblBio;
	private JLabel lblName;
	private JLabel lblDebut;
	private JButton btnRegister;

	public String[] run() {
		setVisible(true);
		return this.data;
	}

	/**
	 * Create the frame.
	 */
	public RegisterArtist(JFrame parent) {
		super(parent, "Datos", true);
		setTitle("Register Artist");
		setBounds(100, 100, 402, 492);
		setLocation(parent.getLocation().x + 80, parent.getLocation().y + 80);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("Sign up right now!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(123, 11, 153, 27);
		contentPane.add(lblTitle);

		lblType = new JLabel("Type Artist:");
		lblType.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblType.setForeground(new Color(255, 255, 255));
		lblType.setBounds(46, 83, 83, 27);
		contentPane.add(lblType);

		lblArtistName = new JLabel("Artist Name:");
		lblArtistName.setForeground(Color.WHITE);
		lblArtistName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblArtistName.setBounds(46, 145, 83, 27);
		contentPane.add(lblArtistName);

		lblBio = new JLabel("Bibliography:");
		lblBio.setForeground(Color.WHITE);
		lblBio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblBio.setBounds(46, 315, 83, 27);
		contentPane.add(lblBio);

		lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblName.setBounds(46, 200, 83, 27);
		contentPane.add(lblName);

		lblDebut = new JLabel("Debut:");
		lblDebut.setForeground(Color.WHITE);
		lblDebut.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDebut.setBounds(46, 261, 83, 27);
		contentPane.add(lblDebut);

		txtArtistName = new JTextField();
		txtArtistName.setBounds(139, 149, 153, 20);
		contentPane.add(txtArtistName);
		txtArtistName.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(139, 204, 153, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtDebut = new JTextField();
		txtDebut.setBounds(139, 265, 153, 20);
		contentPane.add(txtDebut);
		txtDebut.setColumns(10);

		txaBio = new JTextArea();
		txaBio.setBounds(139, 317, 153, 57);
		contentPane.add(txaBio);

		btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(50, 205, 50));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBounds(157, 409, 119, 33);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				data = new String[4];
				data[0] = txtArtistName.getText().trim().toUpperCase();
				data[1] = txtName.getText().trim().toUpperCase();
				data[2] = txtDebut.getText().trim().toUpperCase();
				data[3] = txaBio.getText().trim().toUpperCase();
				dispose();
			}
		});
	}
}
