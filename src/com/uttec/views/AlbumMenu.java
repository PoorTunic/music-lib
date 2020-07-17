package com.uttec.views;

import java.awt.EventQueue;
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
import javax.swing.table.DefaultTableModel;

import com.uttec.controllers.AlbumControl;
import com.uttec.entities.Album;
import com.uttec.entities.Song;

@SuppressWarnings("serial")
public class AlbumMenu extends JFrame implements ActionListener {

	JPanel contentPane;
	JLabel lblName;
	JLabel lblDeparture;
	JLabel lblBio;

	JTextField txtName;
	JTextField txtRelease;
	JTextField txtComments;

	JTable jtArtist;

	JButton btnAddArtist;
	JButton btnRemoveArtist;
	JButton btnSave;

	List<Song> albumSongs = new ArrayList<Song>();

	private String[] jtHeaders = new String[] { "POS.", "SONG NAME", "RELEASE DATE", "COMMENTS" };

	public AlbumMenu() {
		setTitle("Album Register");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());

		lblName = new JLabel("Name:");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblName, constraints);

		lblDeparture = new JLabel("Departure:");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblDeparture, constraints);

		lblBio = new JLabel("Comments:");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblBio, constraints);

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

		btnAddArtist = new JButton("Add");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		btnAddArtist.addActionListener(this);
		contentPane.add(btnAddArtist, constraints);

		btnSave = new JButton("Save");
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnSave.addActionListener(this);
		contentPane.add(btnSave, constraints);

		jtArtist = new JTable();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		this.getTableModel();
		contentPane.add(new JScrollPane(jtArtist), constraints);

		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnAddArtist)) {
			if (this.emptyFields()) {
				JOptionPane.showMessageDialog(this, "Empty fields", "Complete all the fields",
						JOptionPane.WARNING_MESSAGE);
			} else {
				this.addArtist();
			}
		} else if (e.getSource().equals(this.btnSave)) {
			this.saveData();
		}
	}

	private boolean emptyFields() {
		if (this.txtName.getText().isEmpty() || this.txtRelease.getText().isEmpty()
				|| this.txtComments.getText().isEmpty() || this.txtRelease.getText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

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
			JOptionPane.showConfirmDialog(this, "Date format not correct", "Put the date as the format",
					JOptionPane.WARNING_MESSAGE);
		}
	}

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

	private void clearForm() {
		this.txtName.setText(null);
		this.txtRelease.setText(null);
		this.txtComments.setText(null);
		this.txtRelease.setText(null);
	}

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
		this.jtArtist.setModel(new DefaultTableModel(data, this.jtHeaders));
	}

	private void saveData() {
		if (this.albumSongs.size() == 0) {
			JOptionPane.showMessageDialog(this, "Add some artists to save", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Album newAlbum = new Album(this.txtName.getText().trim().toUpperCase(),
						new SimpleDateFormat().parse(this.txtRelease.getText().trim()), getName(), albumSongs);
				AlbumControl.save(newAlbum);
			} catch (ParseException e) {

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
