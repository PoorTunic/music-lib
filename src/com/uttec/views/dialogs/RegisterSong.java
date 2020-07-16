package com.uttec.views.dialogs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegisterSong extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtRelease;
	private JTextField txtPublisher;
	private JLabel lblRelease;
	private JLabel lblName;
	private JLabel lblComment;
	private JLabel lblPublisher;
	private JLabel lblTitle;
	private JTextArea txtComment;
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 456);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblName = new JLabel("Name:");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblName.setBounds(51, 84, 76, 14);
		contentPane.add(lblName);

		lblRelease = new JLabel("Release:");
		lblRelease.setForeground(Color.WHITE);
		lblRelease.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblRelease.setBounds(51, 132, 76, 14);
		contentPane.add(lblRelease);

		lblComment = new JLabel("Comment:");
		lblComment.setForeground(Color.WHITE);
		lblComment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblComment.setBounds(51, 182, 76, 14);
		contentPane.add(lblComment);

		lblPublisher = new JLabel("Publisher:");
		lblPublisher.setForeground(Color.WHITE);
		lblPublisher.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPublisher.setBounds(51, 272, 76, 22);
		contentPane.add(lblPublisher);

		lblTitle = new JLabel("Register your new song now!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitle.setBounds(68, 23, 354, 22);
		contentPane.add(lblTitle);

		txtName = new JTextField();
		txtName.setBounds(137, 82, 216, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtRelease = new JTextField();
		txtRelease.setColumns(10);
		txtRelease.setBounds(137, 130, 216, 20);
		contentPane.add(txtRelease);

		txtComment = new JTextArea();
		txtComment.setBounds(137, 178, 216, 73);
		contentPane.add(txtComment);

		txtPublisher = new JTextField();
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(137, 274, 216, 20);
		contentPane.add(txtPublisher);

		btnRegister = new JButton("Register Now");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = new String[4];
				data[0] = txtName.getText().trim().toUpperCase();
				data[1] = txtRelease.getText().trim().toUpperCase();
				data[2] = txtComment.getText().trim().toUpperCase();
				data[3] = txtPublisher.getText().trim().toUpperCase();
				dispose();
			}
		});
		
		
		btnRegister.setBackground(new Color(50, 205, 50));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnRegister.setBounds(182, 349, 112, 32);
		contentPane.add(btnRegister);
	}

}
