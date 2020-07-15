package com.uttec.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewArtist extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewArtist frame = new ViewArtist();
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
	public ViewArtist() {
		setTitle("Artist");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblartistname = new JLabel("Artist Name");
		lblartistname.setForeground(new Color(255, 255, 255));
		lblartistname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblartistname.setHorizontalAlignment(SwingConstants.CENTER);
		lblartistname.setBounds(28, 51, 76, 20);
		contentPane.add(lblartistname);
		
		JLabel lbldebut = new JLabel("Debut ");
		lbldebut.setForeground(new Color(255, 255, 255));
		lbldebut.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbldebut.setHorizontalAlignment(SwingConstants.CENTER);
		lbldebut.setBounds(193, 54, 46, 14);
		contentPane.add(lbldebut);
		
		JLabel lblbio = new JLabel("Bibliography");
		lblbio.setForeground(new Color(255, 255, 255));
		lblbio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblbio.setHorizontalAlignment(SwingConstants.CENTER);
		lblbio.setBounds(343, 51, 76, 20);
		contentPane.add(lblbio);
		
		JLabel lblaction = new JLabel("Actions");
		lblaction.setForeground(new Color(255, 255, 255));
		lblaction.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblaction.setBounds(500, 54, 46, 14);
		contentPane.add(lblaction);
		
		JLabel lblNewLabel = new JLabel("The artists we have for you!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(163, 11, 265, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(473, 82, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnadd = new JButton("Add Artist");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterArtist ga = new RegisterArtist();
				ga.setVisible(true);
			}
		});
		
		btnadd.setBackground(new Color(50, 205, 50));
		btnadd.setForeground(new Color(255, 255, 255));
		btnadd.setBounds(232, 277, 127, 29);
		contentPane.add(btnadd);
	}

}
