package com.uttec.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.uttec.controllers.AlbumControl;
import com.uttec.entities.Album;
import com.uttec.entities.Band;
import com.uttec.entities.Song;
import com.uttec.views.dialogs.ArtistDialog;

/**
 * Represents the GUI to Register a New Album
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AlbumMenu extends JFrame implements ActionListener {

	/**
	 * GUI components
	 */
	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblDeparture;
	private JLabel lblComment;

	private JTextField txtName;
	private JTextField txtRelease;
	private JTextField txtComments;

	private JTable jtSong;

	private JButton btnAddSong;
	private JButton btnSave;
	private JButton btnRemove;
	private JButton btnBack;

	/**
	 * Represents table data
	 */
	private List<Song> albumSongs = new ArrayList<Song>();

	/**
	 * Represents the headers of the table
	 */
	private String[] jtHeaders = new String[] { "POS.", "SONG NAME", "RELEASE DATE", "COMMENTS" };

	/**
	 * Initializes view
	 */
	public AlbumMenu() {
		setTitle("Album Register");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(20, 20, 25, 20));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		lblName = new JLabel("Song Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblName.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblName, constraints);

		lblDeparture = new JLabel("Release (YYYY-MM-DD):");
		lblDeparture.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeparture.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDeparture.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblDeparture, constraints);

		lblComment = new JLabel("Comments:");
		lblComment.setHorizontalAlignment(SwingConstants.CENTER);
		lblComment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblComment.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblComment, constraints);

		txtName = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtName, constraints);

		txtRelease = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtRelease, constraints);

		txtComments = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtComments, constraints);

		btnAddSong = new JButton("Add Song");
		btnAddSong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnAddSong.setBackground(new Color(50, 205, 50));
		btnAddSong.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		btnAddSong.addActionListener(this);
		contentPane.add(btnAddSong, constraints);

		btnSave = new JButton("Save Album");
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnSave.addActionListener(this);
		contentPane.add(btnSave, constraints);

		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnRemove.setBackground(new Color(204, 11, 0));
		btnRemove.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnRemove.addActionListener(this);
		contentPane.add(btnRemove, constraints);

		btnBack = new JButton("Menu");
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnBack.addActionListener(this);
		contentPane.add(btnBack, constraints);

		jtSong = new JTable();
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		this.getTableModel();
		contentPane.add(new JScrollPane(jtSong), constraints);

		pack();
		setLocationRelativeTo(null);
	}

	/**
	 * Captures Action Performance events
	 * 
	 * @see ActionListener#actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnAddSong)) {
			if (this.emptyFields()) {
				JOptionPane.showMessageDialog(this, "Empty fields", "Complete all the fields",
						JOptionPane.WARNING_MESSAGE);
			} else {
				this.addArtist();
			}
		} else if (e.getSource().equals(this.btnSave)) {
			this.saveData();
		} else if (e.getSource().equals(this.btnRemove)) {
			if (this.albumSongs.size() == 0) {
				JOptionPane.showMessageDialog(this, "Add elements first", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				String index = JOptionPane.showInputDialog(this, "Type the position to remove:", "Remove item",
						JOptionPane.INFORMATION_MESSAGE);
				if (index != null || index != "") {
					try {
						this.albumSongs.remove(Integer.parseInt(index));
						this.getTableModel();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(this, "Index not found", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} else if (e.getSource().equals(this.btnBack)) {
			Inicio inicio = new Inicio();
			inicio.setVisible(true);

			this.dispose();
		}
	}

	/**
	 * Validates JTextFields on the GUI
	 * 
	 * @return boolean
	 */
	private boolean emptyFields() {
		if (this.txtName.getText().isEmpty() || this.txtRelease.getText().isEmpty()
				|| this.txtComments.getText().isEmpty() || this.txtRelease.getText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds JTextFields content to a new Class and it adds that Class into general
	 * list
	 */
	private void addArtist() {
		if (checkDate(this.txtRelease.getText().trim())) {
			try {
				this.albumSongs.add(new Song(this.txtName.getText().trim().toUpperCase(),
						new SimpleDateFormat("yyyy-MM-dd").parse(this.txtRelease.getText().trim()),
						this.txtComments.getText().trim()));
				this.clearForm();
				this.getTableModel();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Date format not correct", "Put the date as the format",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Validates a String if it is valid
	 * 
	 * @param strDate to Check
	 * @return boolean
	 */
	private boolean checkDate(String strDate) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			@SuppressWarnings("unused")
			Date date = formatter.parse(strDate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Clears content of the JTextFields
	 */
	private void clearForm() {
		this.txtName.setText(null);
		this.txtRelease.setText(null);
		this.txtComments.setText(null);
		this.txtRelease.setText(null);
	}

	/**
	 * Loads the initial data (empty) or updates the content according to List
	 * elements
	 */
	private void getTableModel() {
		String[][] data = new String[this.albumSongs.size()][this.jtHeaders.length];
		if (this.albumSongs.size() == 0) {
			data = new String[this.albumSongs.size() + 1][this.jtHeaders.length];
			data[0][0] = null;
			data[0][1] = null;
			data[0][2] = null;
			data[0][3] = null;
		} else {
			for (int i = 0; i < this.albumSongs.size(); i++) {
				data[i][0] = String.valueOf(this.albumSongs.indexOf(this.albumSongs.get(i)));
				data[i][1] = this.albumSongs.get(i).getName();
				data[i][2] = this.albumSongs.get(i).getRelease().toString();
				data[i][3] = this.albumSongs.get(i).getComment();
			}
		}
		this.jtSong.setModel(new DefaultTableModel(data, this.jtHeaders));
	}

	/**
	 * Saves the content of the List of artists stored in the JTable. Depending the
	 * size of the list, it select the way to create the Band
	 */
	private void saveData() {
		if (this.albumSongs.size() == 0) {
			JOptionPane.showMessageDialog(this, "Add some songs to save", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Object[] result = new ArtistDialog(this).run();
				if (result == null) {
					JOptionPane.showMessageDialog(this, "Please, add an artist creator", "Incomplete information",
							JOptionPane.ERROR_MESSAGE);
				} else {

					Album newAlbum = new Album(result[2].toString(),
							new SimpleDateFormat("YYYY-MM-DD").parse(result[3].toString()), result[1].toString(),
							(Band) result[0], albumSongs);
					if (AlbumControl.save(newAlbum)) {
						JOptionPane.showMessageDialog(this, "Album created", "Success operation",
								JOptionPane.OK_CANCEL_OPTION);
						dispose();
						new Inicio().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "An error has occurred", "Failed operation",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlbumMenu frame = new AlbumMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
