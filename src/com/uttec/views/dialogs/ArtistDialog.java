package com.uttec.views.dialogs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.uttec.controllers.BandControl;
import com.uttec.entities.Band;

@SuppressWarnings("serial")
public class ArtistDialog extends JDialog implements ActionListener {

	JPanel contentPane;

	JLabel lblBand;
	JLabel lblName;
	JLabel lblDeparture;
	JLabel lblGenre;

	JTextField txtBand;
	JTextField txtDeparture;
	JTextField txtAlbumName;

	JButton btnFind;
	JButton btnCancel;
	JButton btnAccept;

	JComboBox<String> cbxArtists;
	JComboBox<String> cbxGenres;

	List<Band> artists = new ArrayList<Band>();
	Object[] data;
	Band selectedBand = null;
	String[] genres = { "ACAPELLA", "ACID", "ACID JAZZ", "ACID PUNK", "ACOUSTIC", "ALTERNROCK", "ALTERNATIVE",
			"AMBIENT", "AVANTGARDE", "BALLAD", "BASS", "BEBOB", "BIG BAND", "BLUEGRASS", "BLUES", "BOOTY BASS",
			"CABARET", "CELTIC", "CHAMBER MUSIC", "CHANSON", "CHORUS", "CHRISTIAN RAP", "CLASSIC ROCK", "CLASSICAL",
			"CLUB", "COMEDY", "COUNTRY", "CULT", "DANCE", "DANCE HALL", "DARKWAVE", "DEATH METAL", "DISCO", "DREAM",
			"DRUM SOLO", "DUET", "EASY LISTENING", "ELECTRONIC", "ETHNIC", "EURO-HOUSE", "EURO-TECHNO", "EURODANCE",
			"FAST FUSION", "FOLK", "FOLK-ROCK", "FOLKLORE", "FREESTYLE", "FUNK", "FUSION", "GAME", "GANGSTA", "GOSPEL",
			"GOTHIC", "GOTHIC ROCK", "GRUNGE", "HARD ROCK", "HIP-HOP", "HOUSE", "HUMOUR", "INDUSTRIAL", "INSTRUMENTAL",
			"INSTRUMENTAL POP", "INSTRUMENTAL ROCK", "JAZZ", "JAZZ+FUNK", "JUNGLE", "LATIN", "LO-FI", "MEDITATIVE",
			"METAL", "MUSICAL", "NATIONAL FOLK", "NATIVE AMERICAN", "NEW AGE", "NEW WAVE", "NOISE", "OLDIES", "OPERA",
			"OTHER", "POLKA", "POP", "POP-FOLK", "POP/FUNK", "PORN GROOVE", "POWER BALLAD", "PRANKS", "PRIMUS",
			"PROGRESSIVE ROCK", "PSYCHADELIC", "PSYCHEDELIC ROCK", "PUNK", "PUNK ROCK", "R&B", "RAP", "RAVE", "REGGAE",
			"RETRO", "REVIVAL", "RHYTHMIC SOUL", "ROCK", "ROCK & ROLL", "SAMBA", "SATIRE", "SHOWTUNES", "SKA",
			"SLOW JAM", "SLOW ROCK", "SONATA", "SOUL", "SOUND CLIP", "SOUNDTRACK", "SOUTHERN ROCK", "SPACE", "SPEECH",
			"SWING", "SYMPHONIC ROCK", "SYMPHONY", "TANGO", "TECHNO", "TECHNO-INDUSTRIAL", "TOP 40", "TRAILER",
			"TRANCE", "TRIBAL", "TRIP-HOP", "VOCAL" };

	public ArtistDialog(JFrame parent) {
		super(parent, "Album owner", true);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		lblBand = new JLabel("Find Artist/Band Name");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		contentPane.add(lblBand, constraints);

		lblGenre = new JLabel("Album genre");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		contentPane.add(lblGenre, constraints);

		lblName = new JLabel("Album name");
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		contentPane.add(lblName, constraints);

		lblDeparture = new JLabel("Album departure (YYYY-MM-DD)");
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		contentPane.add(lblDeparture, constraints);

		txtBand = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtBand, constraints);

		txtAlbumName = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtAlbumName, constraints);

		txtDeparture = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 9;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtDeparture, constraints);

		btnFind = new JButton("Find");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnFind.addActionListener(this);
		contentPane.add(btnFind, constraints);

		btnAccept = new JButton("Accept");
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnAccept.addActionListener(this);
		contentPane.add(btnAccept, constraints);

		btnCancel = new JButton("Cancel");
		constraints.gridx = 0;
		constraints.gridy = 11;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel, constraints);

		cbxArtists = new JComboBox<String>();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(cbxArtists, constraints);

		cbxGenres = new JComboBox<String>(genres);
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(cbxGenres, constraints);

		pack();
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnFind)) {
			if (txtBand.getText().trim().isEmpty() || txtBand.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Please, give an artist name", "Nothing to search",
						JOptionPane.WARNING_MESSAGE);
			} else {
				fetch();
			}
		} else if (e.getSource().equals(btnAccept)) {
			if (cbxArtists.getItemCount() == 0) {
				JOptionPane.showMessageDialog(this, "Select the creator", "Empty fields", JOptionPane.WARNING_MESSAGE);
			} else if (validateFields()) {
				data = new Object[5];
				data[0] = artists.get(cbxArtists.getSelectedIndex());
				data[1] = cbxGenres.getSelectedItem();
				data[2] = txtAlbumName.getText().trim().toUpperCase();
				data[3] = txtDeparture.getText().trim().toUpperCase();
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Complete album's information", "Empty fields",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource().equals(btnCancel)) {
			dispose();
		}
	}

	public Object[] run() {
		setVisible(true);
		return data;
	}

	private void fetch() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		artists = BandControl.findByBand(txtBand.getText().trim().toUpperCase());
		if (artists.size() != 0) {
			artists.forEach(band -> {
				model.addElement(band.getName());
			});
		}
		cbxArtists.setModel(model);
		txtBand.setText(null);
	}

	private boolean validateFields() {
		if (txtAlbumName.getText().trim().isEmpty() || txtAlbumName.getText().trim().equals("")
				|| txtDeparture.getText().trim().isEmpty() || txtDeparture.getText().trim().equals(""))
			return false;
		else
			return true;
	}
}
