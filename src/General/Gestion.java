package General;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class Gestion extends JFrame implements ActionListener {

	private JButton btnProfile = new JButton("Profile");
	private JButton btnMessagerie = new JButton("Messagerie");
	private JButton btnGuild = new JButton("Guild");
	private JButton voirguild = new JButton("voidguild");
	private JTable table = new JTable();
	private JPanel panel = new JPanel();
	private JScrollPane scroller = new JScrollPane();
	// Guild affichage :

	private JLabel guildNom = new JLabel();
	private JLabel guildCandidature = new JLabel();

	// private static Annonceur unAnnonceur;

	public Gestion() {
		super();

		this.setBounds(100, 100, 500, 500);
		this.setLayout(null);
		this.setTitle("In Real Game");
		this.setResizable(false);

		this.btnProfile.setBounds(0, 0, 100, 40);
		this.btnMessagerie.setBounds(0, 40, 100, 40);
		this.btnGuild.setBounds(0, 80, 100, 40);
		this.voirguild.setBounds(0, 120, 100, 40);

		this.voirguild.setVisible(true);
		this.panel.add(this.voirguild);

		// this.btnGuild.

		this.panel.setBounds(100, 0, 400, 500);

		this.add(this.btnProfile);
		this.add(this.btnMessagerie);
		this.add(this.btnGuild);
		this.add(this.panel);
		this.add(this.voirguild);

		btnGuild.addActionListener(this);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		Gestion gest = new Gestion();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if (source == btnGuild) {

			System.out.println("source clicked");

			Object[] columnNames = { "Guild", "GuildMaster", "MMO Principale",
					"Server", "id" };
			Object[][] data = getallguildinaJTable();
			JTable table = new JTable(data, columnNames);

			table.getColumnModel().getColumn(4).setMinWidth(0);
			table.getColumnModel().getColumn(4).setMaxWidth(0);

			table.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (e.getClickCount() == 2) {
						int ligneclicked = table.rowAtPoint(e.getPoint());
						Object idguild = getguildidbylineclicked(ligneclicked);
						int id = Integer.valueOf((String) idguild);

						afficheruneguild(id);

					}
				}
			});

			this.table = table;

			JScrollPane scroller = new JScrollPane(table);
			scroller.setBounds(100, 0, 400, 500);
			scroller.setVisible(true);
			this.scroller = scroller;
			this.remove(this.panel);
			this.getContentPane().add(scroller);
			this.validate();
			this.repaint();

		}

		if (source == this.voirguild) {

		}

	}

	protected void mouseDblClicked(int row, int column) {
		// TODO Auto-generated method stu
	}

	public void afficheruneguild(int idguild) {

		guild guild = new guild(idguild, true);

		// this.getContentPane().removeAll();

		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);

		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();

		// Nom de la guil
		this.guildNom = new JLabel(guild.getGuild_name());
		this.guildNom.setBounds(40, 20, 20, 50);
		this.guildNom.setFont(new Font("Serif", Font.PLAIN, 30));
		// this.panel.add(this.guildNom);

		// Candiatures
		// Jbuton ?
		// file d'actualité candidatures ?

		// Actualit�
		JPanel uneactu = new JPanel();
		// uneactu.setAlignmentX(100);
		// uneactu.setAlignmentY(100);
		uneactu.setBounds(10, 200, 250, 250);
		uneactu.setBackground(Color.GREEN);
		uneactu.setVisible(true);

//		uneactu.add(this.guildNom);

		// JLabel mess = new JLabel(" message d'essay ");
		// mess.setBounds(0, 400, 20, 10);
		//
		// JLabel nom = new JLabel(" nom dessay ");
		// nom.setBounds(10, 400, 20, 10);
		//
		// JScrollBar scroll = new JScrollBar();
		//
		// uneactu.add(mess);
		// uneactu.add(nom);

		this.panel.add(uneactu);
		this.panel.setBackground(Color.RED);

		// scroll.setBounds(150, 500, 10, 100);
		// scroll.setBackground(Color.BLACK);
		// this.panel.add(scroll);

		this.getContentPane().add(this.panel);

		this.validate();
		this.repaint();
	}

	public Object getguildidbylineclicked(int ligneclicked) {
		Object id = this.table.getValueAt(ligneclicked, 4);
		return id;
	}

	public Object[][] getallguildinaJTable() {
		LinkedList<guild> allguilds = guild.getallguilds();
		Object[][] data = new Object[allguilds.size()][5];

		for (int i = 0; i < allguilds.size(); i++) {
			data[i][0] = allguilds.get(i).getGuild_name();
			data[i][1] = allguilds.get(i).getGM();
			data[i][2] = allguilds.get(i).getMMO_Principale();
			data[i][3] = allguilds.get(i).getServeur();
			data[i][4] = "" + allguilds.get(i).getId();
		}

		return data;
	}

	public JPanel getallguildspanelsinapanel() {
		int hauteur = 0;
		LinkedList<guild> allguilds = guild.getallguilds();
		JPanel panguild = new JPanel();
		JPanel pan = new JPanel();
		pan.setBounds(100, 0, 400, 500);
		pan.setVisible(true);

		for (int i = 0; i < allguilds.size(); i++) {
			System.out.println(allguilds.get(i).getId());
			panguild = afficheruneguild(allguilds.get(i), hauteur);
			hauteur += 100;
			pan.add(panguild);
		}

		return pan;
	}

	public JPanel afficheruneguild(guild guild, int hauteur) {
		JPanel pan = this.createguildJpanel(guild, hauteur);
		return pan;
	}

	public JPanel createguildJpanel(guild guild, int hauteur) {

		JPanel Gpanel = new JPanel();
		Gpanel.setBounds(100, hauteur, 40, 50);

		JButton VoirGuild = new JButton("Voir La Guild ");
		// <html> <body> <span style='color=red;'> </body> </span> </html>
		JButton Postuler = new JButton(" Postuler ");

		JLabel GuildName = new JLabel(guild.getGuild_name());
		JLabel GuildgM = new JLabel(guild.getGM());
		JLabel GuildMmoPrincipale = new JLabel(guild.getMMO_Principale());
		JLabel GuildServeur = new JLabel(guild.getServeur());

		Gpanel.add(GuildName);
		Gpanel.add(GuildgM);
		Gpanel.add(GuildMmoPrincipale);
		Gpanel.add(GuildServeur);
		Gpanel.add(VoirGuild);
		Gpanel.add(Postuler);

		Gpanel.setBackground(Color.YELLOW);
		Gpanel.setVisible(true);

		return Gpanel;
	}

}

class ButtonRenderer extends JButton implements TableCellRenderer {

	public ButtonRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText((value == null) ? "" : value.toString());
		return this;
	}
}
