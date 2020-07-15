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

@SuppressWarnings("serial")
public class RegisterAlbum extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtdeparture;
	private JTextField txtcomment;
	private JLabel lbltitle;
	private JLabel lblartist;
	private JLabel lblname;
	private JLabel lbldeparture;
	private JLabel lblcomment;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbltitle = new JLabel("Register Your Album!");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbltitle.setForeground(new Color(255, 255, 255));
		lbltitle.setBounds(111, 11, 181, 28);
		contentPane.add(lbltitle);

		lblartist = new JLabel("Artist:");
		lblartist.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblartist.setForeground(new Color(255, 255, 255));
		lblartist.setBounds(49, 58, 62, 16);
		contentPane.add(lblartist);

		lblname = new JLabel("Name:");
		lblname.setForeground(Color.WHITE);
		lblname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblname.setBounds(49, 108, 62, 16);
		contentPane.add(lblname);

		lbldeparture = new JLabel("Departure:");
		lbldeparture.setForeground(Color.WHITE);
		lbldeparture.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbldeparture.setBounds(49, 156, 62, 16);
		contentPane.add(lbldeparture);

		lblcomment = new JLabel("Comment:");
		lblcomment.setForeground(Color.WHITE);
		lblcomment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblcomment.setBounds(49, 201, 62, 16);
		contentPane.add(lblcomment);

		JComboBox jcbartist = new JComboBox();
		jcbartist.setBounds(121, 57, 171, 20);
		contentPane.add(jcbartist);

		txtname = new JTextField();
		txtname.setBounds(121, 107, 171, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);

		txtdeparture = new JTextField();
		txtdeparture.setBounds(121, 155, 171, 20);
		contentPane.add(txtdeparture);
		txtdeparture.setColumns(10);

		txtcomment = new JTextField();
		txtcomment.setBounds(121, 200, 171, 20);
		contentPane.add(txtcomment);
		txtcomment.setColumns(10);

		JLabel lblgender = new JLabel("Gender:");
		lblgender.setForeground(Color.WHITE);
		lblgender.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblgender.setBounds(49, 250, 62, 16);
		contentPane.add(lblgender);

		JComboBox jcbgender = new JComboBox();
		jcbgender.setBounds(121, 249, 171, 20);
		contentPane.add(jcbgender);

		JLabel lblsong = new JLabel("Select your song:");
		lblsong.setForeground(Color.WHITE);
		lblsong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblsong.setBounds(49, 302, 108, 16);
		contentPane.add(lblsong);

		JComboBox jcbsong = new JComboBox();
		jcbsong.setBounds(170, 301, 125, 20);
		contentPane.add(jcbsong);

		JButton btnregister = new JButton("Register Now");
		btnregister.setBackground(new Color(50, 205, 50));
		btnregister.setForeground(new Color(255, 255, 255));
		btnregister.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnregister.setBounds(138, 377, 131, 28);
		contentPane.add(btnregister);
	}

}
