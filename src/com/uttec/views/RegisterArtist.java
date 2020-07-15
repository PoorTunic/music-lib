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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RegisterArtist extends JFrame {

	private JPanel contentPane;
	private JTextField txtartistname;
	private JTextField txtname;
	private JTextField txtdebut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterArtist frame = new RegisterArtist();
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
	public RegisterArtist() {
		setTitle("Register Artist");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitle = new JLabel("Sign up right now!");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbltitle.setForeground(new Color(255, 255, 255));
		lbltitle.setBounds(123, 11, 153, 27);
		contentPane.add(lbltitle);
		
		JLabel lbltype = new JLabel("Type Artist:");
		lbltype.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbltype.setForeground(new Color(255, 255, 255));
		lbltype.setBounds(46, 83, 83, 27);
		contentPane.add(lbltype);
		
		JComboBox jcbtype = new JComboBox();
		jcbtype.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jcbtype.setModel(new DefaultComboBoxModel(new String[] {"To select", "Band", "Vocalist"}));
		jcbtype.setBounds(139, 86, 153, 20);
		contentPane.add(jcbtype);
		
		JLabel lblartistname = new JLabel("Artist Name:");
		lblartistname.setForeground(Color.WHITE);
		lblartistname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblartistname.setBounds(46, 145, 83, 27);
		contentPane.add(lblartistname);
		
		JLabel lblbio = new JLabel("Bibliography:");
		lblbio.setForeground(Color.WHITE);
		lblbio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblbio.setBounds(46, 315, 83, 27);
		contentPane.add(lblbio);
		
		JLabel lblname = new JLabel("Name:");
		lblname.setForeground(Color.WHITE);
		lblname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblname.setBounds(46, 200, 83, 27);
		contentPane.add(lblname);
		
		JLabel lbldebut = new JLabel("Debut:");
		lbldebut.setForeground(Color.WHITE);
		lbldebut.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbldebut.setBounds(46, 261, 83, 27);
		contentPane.add(lbldebut);
		
		txtartistname = new JTextField();
		txtartistname.setBounds(139, 149, 153, 20);
		contentPane.add(txtartistname);
		txtartistname.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(139, 204, 153, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtdebut = new JTextField();
		txtdebut.setBounds(139, 265, 153, 20);
		contentPane.add(txtdebut);
		txtdebut.setColumns(10);
		
		JTextArea txtabio = new JTextArea();
		txtabio.setBounds(139, 317, 153, 57);
		contentPane.add(txtabio);
		
		JButton btnregister = new JButton("Register Now");
		btnregister.setBackground(new Color(50, 205, 50));
		btnregister.setForeground(new Color(255, 255, 255));
		btnregister.setBounds(157, 409, 119, 33);
		contentPane.add(btnregister);
	}
}
