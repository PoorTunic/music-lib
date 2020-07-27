package com.uttec.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.uttec.controllers.AlbumControl;
import com.uttec.controllers.ArtistControl;
import com.uttec.controllers.BandControl;
import com.uttec.controllers.SearcherContext;
import com.uttec.entities.Album;

@SuppressWarnings("serial")
public class PdfMenu extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JLabel lblTitle;

	private JButton btnSearch;

	private JTextField txtArtist;

	private JRadioButton rdbtnArtistName;
	private JRadioButton rdbtnAlbumName;
	private JRadioButton rdbtnBandName;

	private JTable jtAlbum;

	private String[] data;

	private List<Album> albums = new ArrayList<Album>();

	private String[] jtHeaders = new String[] { "ID", "NAME", "DEPARTURE", "PDF" };

	public String[] run() {
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
					PdfMenu frame = new PdfMenu();
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
	public PdfMenu() {
		setTitle("Generate Cover Album");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		lblTitle = new JLabel("Start Finding an Album !");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitle.setForeground(new Color(255, 255, 255));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		contentPane.add(lblTitle, constraints);

		rdbtnArtistName = new JRadioButton("Artist Name", true);
		rdbtnArtistName.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnArtistName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnArtistName.setForeground(new Color(255, 255, 255));
		rdbtnArtistName.setBackground(new Color(0, 0, 0));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(rdbtnArtistName, constraints);

		rdbtnAlbumName = new JRadioButton("Album Name");
		rdbtnAlbumName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnAlbumName.setBackground(new Color(0, 0, 0));
		rdbtnAlbumName.setForeground(new Color(255, 255, 255));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(rdbtnAlbumName, constraints);

		rdbtnBandName = new JRadioButton("Band Name");
		rdbtnBandName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		rdbtnBandName.setBackground(new Color(0, 0, 0));
		rdbtnBandName.setForeground(new Color(255, 255, 255));
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		contentPane.add(rdbtnBandName, constraints);

		txtArtist = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(txtArtist, constraints);
		txtArtist.setColumns(10);

		btnSearch = new JButton("Find");
		btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSearch.setBackground(new Color(50, 205, 50));
		btnSearch.setForeground(new Color(255, 255, 255));
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch, constraints);

		jtAlbum = new JTable();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 3;
		constraints.gridheight = 2;
		this.getTableModel();
		contentPane.add(new JScrollPane(jtAlbum), constraints);

		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(rdbtnAlbumName);
		btnGrp.add(rdbtnArtistName);
		btnGrp.add(rdbtnBandName);

		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnSearch)) {
			if (rdbtnBandName.isSelected()) {
				SearcherContext ctx = new SearcherContext(new BandControl());
				this.albums = ctx.search(this.txtArtist.getText().trim().toUpperCase());
				this.getTableModel();
			} else if (rdbtnArtistName.isSelected()) {
				SearcherContext ctx = new SearcherContext(new ArtistControl());
				this.albums = ctx.search(this.txtArtist.getText().trim().toUpperCase());
				this.getTableModel();
			} else if (rdbtnAlbumName.isSelected()) {
				SearcherContext ctx = new SearcherContext(new AlbumControl());
				this.albums = ctx.search(this.txtArtist.getText().trim().toUpperCase());
				this.getTableModel();
			}
		}
	}

	private void getTableModel() {
		String[][] data = new String[this.albums.size()][this.jtHeaders.length];
		if (this.albums.size() != 0) {
			for (int i = 0; i < this.albums.size(); i++) {
				data[i][0] = String.valueOf(this.albums.indexOf(this.albums.get(i)));
				data[i][1] = this.albums.get(i).getName();
				data[i][2] = this.albums.get(i).getDeparture().toString();
			}
		}
		DefaultTableModel model = new DefaultTableModel(data, this.jtHeaders) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		this.jtAlbum.setModel(model);
	}

	class JTableButtonRenderer implements TableCellRenderer {
		private TableCellRenderer defaultRenderer;

		public JTableButtonRenderer(TableCellRenderer renderer) {
			defaultRenderer = renderer;
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value instanceof Component)
				return (Component) value;
			return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}

	class JTableButtonModel extends AbstractTableModel {
		private Object[][] rows = { { "Button1", new JButton("Button1") }, { "Button2", new JButton("Button2") },
				{ "Button3", new JButton("Button3") }, { "Button4", new JButton("Button4") } };
		private String[] columns = { "Count", "Buttons" };

		public String getColumnName(int column) {
			return columns[column];
		}

		public int getRowCount() {
			return rows.length;
		}

		public int getColumnCount() {
			return columns.length;
		}

		public Object getValueAt(int row, int column) {
			return rows[row][column];
		}

		public boolean isCellEditable(int row, int column) {
			return false;
		}

		public Class getColumnClass(int column) {
			return getValueAt(0, column).getClass();
		}
	}
}