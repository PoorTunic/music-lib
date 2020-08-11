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

import com.uttec.controllers.BandControl;
import com.uttec.entities.Artist;
import com.uttec.entities.Band;

/**
 * Represents the GUI to Register a New Artist or Band
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
	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblArtisticName;
	private JLabel lblBio;
	private JLabel lblBorn;

	private JTextField txtName;
	private JTextField txtArtisticName;
	private JTextField txtBio;
	private JTextField txtBorn;

	private JTable jtArtist;

	private JButton btnAddArtist;
	private JButton btnSave;
	private JButton btnRemove;
	private JButton btnBack;
	
	private JButton btnEdit;

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
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(20, 20, 25, 20));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblName.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblName, constraints);

		lblArtisticName = new JLabel("Artistic Name:");
		lblArtisticName.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtisticName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblArtisticName.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblArtisticName, constraints);

		lblBio = new JLabel("Bio:");
		lblBio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblBio.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(lblBio, constraints);

		lblBorn = new JLabel("Born Date(YYYY-MM-DD):");
		lblBorn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblBorn.setForeground(new Color(255, 255, 255));
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
		btnAddArtist.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnAddArtist.setBackground(new Color(50, 205, 50));
		btnAddArtist.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		btnAddArtist.addActionListener(this);
		contentPane.add(btnAddArtist, constraints);

		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnRemove.setBackground(new Color(204, 11, 0));
		btnRemove.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		btnRemove.addActionListener(this);
		contentPane.add(btnRemove, constraints);
		
		// edit
		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnEdit.setBackground(new Color(22, 111, 245));
		btnEdit.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 10;
	    constraints.gridwidth = 7;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnEdit.addActionListener(this);
		contentPane.add(btnEdit, constraints);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnSave.addActionListener(this);
		contentPane.add(btnSave, constraints);

		btnBack = new JButton("Menu");
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 9;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnBack.addActionListener(this);
		contentPane.add(btnBack, constraints);

		jtArtist = new JTable();
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		this.getTableModel();
		contentPane.add(new JScrollPane(jtArtist), constraints);

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
		} else if (e.getSource().equals(this.btnBack)) {
			Inicio inicio = new Inicio();
			inicio.setVisible(true);

			this.dispose();
			
			
		} else if(e.getSource().equals(this.btnEdit)) {
			if (this.artistsToSave.size() == 0) {
				JOptionPane.showMessageDialog(this, "Add elements first", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					int edit = Integer.parseInt((JOptionPane.showInputDialog(this, "Type the position to Edit:", "Edit item", 
							JOptionPane.INFORMATION_MESSAGE)));
					if (btnEdit.getText().equals("Edit") && edit != -1) {
						
						this.txtName.setText(artistsToSave.get(edit).getName());
						this.txtArtisticName.setText(artistsToSave.get(edit).getArtisticName());
						this.txtBio.setText(artistsToSave.get(edit).getBio());
						//this.txtBorn.setText("2019-09-09");
						this.txtBorn.setText(String.valueOf(artistsToSave.get(edit).getBorn()));
						btnEdit.setText("Confirmar");
					} else if (btnEdit.getText().equals("Confirmar")) {
						try {
							artistsToSave.get(edit).setName(txtName.getText().trim().toUpperCase());
							artistsToSave.get(edit).setArtisticName(txtArtisticName.getText().trim());
							artistsToSave.get(edit).setBio(txtBio.getText().trim());
							artistsToSave.get(edit).setBorn(
									new SimpleDateFormat("yyyy-MM-dd").parse(this.txtBorn.getText().trim()));
							clearForm();
							btnEdit.setText("Edit");
							this.getTableModel();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(this, "Index not found", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Index not found", "Error", JOptionPane.ERROR_MESSAGE);
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
			System.out.println(txtBorn.getText());
			JOptionPane.showMessageDialog(this, "Write the date as the format", "Date format",
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
			if (BandControl.saveSolist(artistsToSave)) {
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
					if (BandControl.saveBand(newBand)) {
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
