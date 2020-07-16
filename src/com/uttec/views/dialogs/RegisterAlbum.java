package com.uttec.views.dialogs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegisterAlbum extends JFrame {

	private JLabel lblTitle;
	private JLabel lblArtist;
	private JLabel lblName;
	private JLabel lblDeparture;
	private JLabel lblComment;
	private JLabel lblGender;
	private JLabel lblSong;
	private JComboBox jcbGender;
	private JComboBox jcbArtist;
	private JComboBox jcbSong;
	private JPanel contentPane;
	private JTextField txName;
	private JTextField txtDeparture;
	private JTextField txtComment;
	private JButton btnRegister;
	
	private String[] data;
	
	public String[] run(){
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
					RegisterAlbum frame = new RegisterAlbum();
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
	public RegisterAlbum() {
		setTitle("New Album");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 490);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("Register Your Album!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(111, 11, 181, 28);
		contentPane.add(lblTitle);

		lblArtist = new JLabel("Artist:");
		lblArtist.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblArtist.setForeground(new Color(255, 255, 255));
		lblArtist.setBounds(49, 58, 62, 16);
		contentPane.add(lblArtist);

		lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblName.setBounds(49, 108, 62, 16);
		contentPane.add(lblName);

		lblDeparture = new JLabel("Departure:");
		lblDeparture.setForeground(Color.WHITE);
		lblDeparture.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDeparture.setBounds(49, 156, 62, 16);
		contentPane.add(lblDeparture);

		lblComment = new JLabel("Comment:");
		lblComment.setForeground(Color.WHITE);
		lblComment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblComment.setBounds(49, 201, 62, 16);
		contentPane.add(lblComment);

		jcbArtist = new JComboBox();
		jcbArtist.setBounds(121, 57, 171, 20);
		contentPane.add(jcbArtist);

		txName = new JTextField();
		txName.setBounds(121, 107, 171, 20);
		contentPane.add(txName);
		txName.setColumns(10);

		txtDeparture = new JTextField();
		txtDeparture.setBounds(121, 155, 171, 20);
		contentPane.add(txtDeparture);
		txtDeparture.setColumns(10);

		txtComment = new JTextField();
		txtComment.setBounds(121, 200, 171, 20);
		contentPane.add(txtComment);
		txtComment.setColumns(10);

		lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblGender.setBounds(49, 250, 62, 16);
		contentPane.add(lblGender);

		jcbGender = new JComboBox();
		jcbGender.setBounds(121, 249, 171, 20);
		contentPane.add(jcbGender);

		lblSong = new JLabel("Select your song:");
		lblSong.setForeground(Color.WHITE);
		lblSong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSong.setBounds(49, 302, 108, 16);
		contentPane.add(lblSong);

		jcbSong = new JComboBox();
		jcbSong.setBounds(170, 301, 125, 20);
		contentPane.add(jcbSong);

		btnRegister = new JButton("Register Now");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = new String[3];
				data[0] = txName.getText().trim().toUpperCase();
				data[1] = txtDeparture.getText().trim().toUpperCase();
				data[2] = txtComment.getText().trim().toUpperCase();
				dispose();
			}
		});
		
		
		
		
		btnRegister.setBackground(new Color(50, 205, 50));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnRegister.setBounds(138, 377, 131, 28);
		contentPane.add(btnRegister);
	}

}
