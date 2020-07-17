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

import com.uttec.controllers.ArtistControl;
import com.uttec.entities.Artist;
import com.uttec.entities.Band;

/**
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ArtistMenu extends JFrame implements ActionListener {

	/**
	 * Represents GUI components
	 */
	JPanel contentPane;
	JLabel lblName;
	JLabel lblArtisticName;
	JLabel lblBio;
	JLabel lblBorn;

	JTextField txtName;
	JTextField txtArtisticName;
	JTextField txtBio;
	JTextField txtBorn;

	JTable jtArtist;

	JButton btnAddArtist;
	JButton btnRemoveArtist;
	JButton btnSave;
	JButton btnRemove;

	/**
	 * Represents table data
	 */
	private List<Artist> artistsToSave = new ArrayList<Artist>();

	/**
	 * Represents the headers of the table
	 */
	private String[] jtHeaders = new String[] { "POS.", "NAME", "ARTISTIC NAME", "BORN AT" };

	/**
	 * Initializes view
	 */
	public ArtistMenu() {
		setTitle("Artist Register");
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

		lblArtisticName = new JLabel("Artistic Name:");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblArtisticName, constraints);

		lblBio = new JLabel("Bio:");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblBio, constraints);

		lblBorn = new JLabel("Born Date(YYYY-MM-DD):");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblBorn, constraints);

		txtName = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtName, constraints);

		txtArtisticName = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtArtisticName, constraints);

		txtBio = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtBio, constraints);

		txtBorn = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtBorn, constraints);

		btnAddArtist = new JButton("Add");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		btnAddArtist.addActionListener(this);
		contentPane.add(btnAddArtist, constraints);

		btnRemove = new JButton("Remove");
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		btnRemove.addActionListener(this);
		contentPane.add(btnRemove);

		btnSave = new JButton("Save");
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnSave.addActionListener(this);
		contentPane.add(btnSave, constraints);

		jtArtist = new JTable();
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		this.getTableModel();
		contentPane.add(new JScrollPane(jtArtist), constraints);

		pack();
	}

	/**
	 * Captures Action Performance events
	 * 
	 * @see ActionListener#actionPerformed(ActionEvent)
	 */
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
		} else if (e.getSource().equals(this.btnRemove)) {
			if (this.artistsToSave.size() == 0) {
				JOptionPane.showMessageDialog(this, "Add elements first", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				String index = JOptionPane.showInputDialog(this, "Type the position to remove:", "Remove item",
						JOptionPane.INFORMATION_MESSAGE);
				if (index != null || index != "") {
					try {
						this.artistsToSave.remove(Integer.parseInt(index));
						this.getTableModel();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(this, "Index not found", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

	/**
	 * Validates JTextFields on the GUI
	 * 
	 * @return boolean
	 */
	private boolean emptyFields() {
		if (this.txtName.getText().isEmpty() || this.txtArtisticName.getText().isEmpty()
				|| this.txtBio.getText().isEmpty() || this.txtBorn.getText().isEmpty()) {
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
		if (checkDate(this.txtBorn.getText().trim())) {
			try {
				this.artistsToSave.add(new Artist(this.txtName.getText().trim().toUpperCase(),
						this.txtArtisticName.getText().trim().toUpperCase(), this.txtBio.getText().trim().toUpperCase(),
						new SimpleDateFormat("yyyy-MM-dd").parse(this.txtBorn.getText().trim())));
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
		this.txtArtisticName.setText(null);
		this.txtBio.setText(null);
		this.txtBorn.setText(null);
	}

	/**
	 * Loads the initial data (empty) or updates the content according to List
	 * elements
	 */
	private void getTableModel() {
		String[][] data = new String[this.artistsToSave.size()][this.jtHeaders.length];
		if (this.artistsToSave.size() == 0) {
			data = new String[this.artistsToSave.size() + 1][this.jtHeaders.length];
			data[0][0] = null;
			data[0][1] = null;
			data[0][2] = null;
			data[0][3] = null;
		} else {
			for (int i = 0; i < this.artistsToSave.size(); i++) {
				data[i][0] = String.valueOf(this.artistsToSave.indexOf(this.artistsToSave.get(i)));
				data[i][1] = this.artistsToSave.get(i).getName();
				data[i][2] = this.artistsToSave.get(i).getArtisticName();
				data[i][3] = this.artistsToSave.get(i).getBorn().toString();
			}
		}
		this.jtArtist.setModel(new DefaultTableModel(data, this.jtHeaders));
	}

	/**
	 * Saves the content of the List of artists stored in the JTable. Depending the
	 * size of the list, it select the way to create the Band
	 */
	private void saveData() {
		if (this.artistsToSave.size() == 0) {
			JOptionPane.showMessageDialog(this, "Add some artists to save", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (this.artistsToSave.size() == 1) {
			if (ArtistControl.save(artistsToSave)) {
				this.artistsToSave = new ArrayList<Artist>();
				this.getTableModel();
			} else {
				JOptionPane.showMessageDialog(this, "Unexpected error, try later", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			boolean givenName = false;
			while (!givenName) {
				String name = JOptionPane.showInputDialog(this, "Band Name", "Please, give a band name:",
						JOptionPane.INFORMATION_MESSAGE);
				if (name != null && !name.isEmpty()) {
					givenName = true;
					Band newBand = new Band(name.toUpperCase(), artistsToSave);
					if (ArtistControl.save(newBand)) {
						this.artistsToSave = new ArrayList<Artist>();
						this.getTableModel();
					} else {
						JOptionPane.showMessageDialog(this, "Unexpected error, try later", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "You need to give a band name", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
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
					ArtistMenu frame = new ArtistMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
