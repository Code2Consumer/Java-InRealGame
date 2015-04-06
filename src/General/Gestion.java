package General;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class Gestion extends JFrame implements ActionListener {
	
	public static Utilisateur CurrentUser = new Utilisateur();

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
	private JButton envoyerguildpostbtn = new JButton();
	private JButton guildbtnretour = new JButton("Retour");
	private JTextField messagefieldguildpost =new JTextField();
	
	public JButton guildbtncandidatures = new JButton("Les candidatures");
	public JButton guildbtnmembres = new JButton("Les membres");
	public JButton guildbtncalendrier = new JButton("Le calendrier");
	public JButton guildcreate = new JButton("Créer une guilde");
	
	// Guild candidatures :
	
	public LinkedList<JButton> allcandidaturesbtn = new LinkedList<JButton>();
	
	// Guild creation :
	public JTextField Guildnamecreate = new JTextField();
	public JTextField CoGMcreate = new JTextField();
	public JTextField MMOcreate = new JTextField();
	public JTextField Serveurcreate = new JTextField();
	public JButton createguildebtn = new JButton("Valider");

	// private static Annonceur unAnnonceur;

	public Gestion(Utilisateur user) {
		super();
		
		this.CurrentUser = user;

		this.setBounds(100, 100, 500, 500);
		this.setLayout(null);
		this.setTitle("In Real Game");
		this.setResizable(false);

		this.btnProfile.setBounds(0, 0, 100, 40);
		this.btnMessagerie.setBounds(0, 40, 100, 40);
		this.btnGuild.setBounds(0, 80, 100, 40);
		this.voirguild.setBounds(0, 120, 100, 40);

		this.voirguild.setVisible(true);
		this.voirguild.addActionListener(this);
		this.panel.add(this.voirguild);

		this.panel.setBounds(100, 0, 400, 500);

		this.add(this.btnProfile);
		this.add(this.btnMessagerie);
		this.add(this.btnGuild);
		this.add(this.panel);
		this.add(this.voirguild);

		btnGuild.addActionListener(this);
		guildcreate.addActionListener(this);
		createguildebtn.addActionListener(this);
		guildbtnretour.addActionListener(this);
		guildbtnretour.setVisible(true);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		Gestion gest = new Gestion(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == btnGuild) {
			affichertoutelesguildes();
		}
		if (source == this.envoyerguildpostbtn) {
			envoyerunguildpost();	
		}
		if (source==this.guildbtnmembres){
			affichertouslesmembresdelaguilde();
		}
		if (source == this.guildbtnretour) {
			afficheruneguild(CurrentGuild.getId());
		}
		if (source == this.guildcreate) {
			afficherleformulairedecreationdeguilde();
		}
		if (source == this.createguildebtn) {
			envoisduformulairedeguilde();
		}
		if (source == this.guildbtncandidatures ) {
			afficherlescandidatures();
		}
		if (source == this.voirguild) {
//			System.out.println("void guild lcicked");
//			guildpost.envoyerguildpost("balisto");
			System.out.println(this.CurrentUser.getUsername());
		}
		
		for (int i = 0; i < allcandidaturesbtn.size(); i++) {
			if (source == allcandidaturesbtn.get(i) ) {
				System.out.println( allcandidaturesbtn.get(i).getClientProperty("id")+"//" );
			}
		}

	}

	protected void mouseDblClicked(int row, int column) {
		// TODO Auto-generated method stu
	}
	
	public void afficherlescandidatures(){

		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);
		
		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.panel.setBackground(Color.white);
		this.validate();
		this.repaint();
		

		this.guildNom = new JLabel("Toutes les canddatures :");
		this.guildNom.setBounds(20, 0, 350, 50);
		this.guildNom.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//code21
		
		JScrollPane scroll = addallcandidatures();
		
		this.guildbtnretour.setBounds(300, 50, 80, 40);
		this.panel.add(this.guildbtnretour);
		this.panel.add(this.guildNom);
		this.panel.add(scroll);
		
		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
	}
	
	public void envoisduformulairedeguilde(){
	System.out.println("creation de la guild avc les info rentrés");
	String guildname = Guildnamecreate.getText();
	String Cogm = CoGMcreate.getText();
	String mmo = MMOcreate.getText();
	String serveur = Serveurcreate.getText();
	
	if ( !mmo.isEmpty() && !guildname.isEmpty() && !Cogm.isEmpty() && !serveur.isEmpty() ) {
		if (guild.createguilde(guildname, this.CurrentUser.username, Cogm, this.CurrentUser.getId(), mmo, serveur)) {
			System.out.println("la guild a été créer");
			affichertoutelesguildes();
		}else {
			System.out.println(" impossible de créer la guild ");
			}
	}else {
		System.out.println("nope");
		JLabel label = new JLabel("<html><font color='red'>Tous les champs doivent être remplis.</font></html>");
		label.setBounds(50, 300, 350, 50);
		label.setVisible(true);
		this.panel.add(label);
		this.validate();
		this.repaint();
		}
	}
	
	public void afficherleformulairedecreationdeguilde(){

//		int Gm_id = CurrentUser.getId();
//		String GM = CurrentUser.getUsername();
		
		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);

		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		
		// label 
		JLabel label = new JLabel("Créez votre guilde :");
		label.setBounds(50, 20, 350, 50);
		label.setFont(new Font("Serif", Font.PLAIN, 30));

		// Guild_name
		JLabel Guildnamelabel = new JLabel("Nom de la guilde :");
		Guildnamelabel.setBounds(50, 100, 130, 20);
		Guildnamecreate = new JTextField();
		Guildnamecreate.setBounds(180, 100, 130, 20);

		// CoGM
		JLabel CoGMlabel = new JLabel("Co GM :");
		CoGMlabel.setBounds(50, 140, 130, 20);
		CoGMcreate = new JTextField();
		CoGMcreate.setBounds(180, 140, 130, 20);
		
		// MMO_Principale
		JLabel MMOlabel = new JLabel("MMORPG Principale :");
		MMOlabel.setBounds(50, 180, 130, 20);
		MMOcreate = new JTextField();
		MMOcreate.setBounds(180, 180, 130, 20);
		
		// Serveur 
		JLabel Serveurlabel = new JLabel("Serveur de la guilde :");
		Serveurlabel.setBounds(50, 220, 130, 20);
		Serveurcreate = new JTextField();
		Serveurcreate.setBounds(180, 220, 130, 20);
		
		createguildebtn.setBounds(50, 270, 260, 40);
		
		this.panel.add(label);
		this.panel.add(Guildnamelabel);
		this.panel.add(Guildnamecreate);
		this.panel.add(CoGMlabel);
		this.panel.add(CoGMcreate);
		this.panel.add(MMOlabel);
		this.panel.add(MMOcreate);		
		this.panel.add(Serveurlabel);
		this.panel.add(Serveurcreate);
		this.panel.add(createguildebtn);
		this.panel.setBackground(Color.green);

		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
	}

	public void affichertouslesmembresdelaguilde(){

	this.getContentPane().remove(this.panel);
	this.getContentPane().remove(this.scroller);
	
	this.panel = new JPanel();
	this.panel.setBounds(100, 0, 400, 500);
	this.panel.setLayout(null);
	this.validate();
	this.repaint();
	
	
	Object[] columnNames = { "Nom De l'Utilisateur", "idjoueur", "idguild" };
	Object[][] data = getallmembresguildinaJTable();
	JTable table = new JTable(data, columnNames);
	
	table.getColumnModel().getColumn(2).setMinWidth(0);
	table.getColumnModel().getColumn(2).setMaxWidth(0);			
	table.getColumnModel().getColumn(1).setMinWidth(0);
	table.getColumnModel().getColumn(1).setMaxWidth(0);
	
	table.setBounds(0, 100, 400, 500);

//	table.addMouseListener(new MouseAdapter() {
//		public void mousePressed(MouseEvent e) {
//			if (e.getClickCount() == 2) {
//
//			}
//		}
//	});
	
	this.guildbtnretour.setBounds(300, 50, 80, 40);

	this.table = table; //code24
	JScrollPane scroller = new JScrollPane(table);
	scroller.add(this.guildNom);
	scroller.setBounds(0, 100, 400, 500);
	scroller.setVisible(true);
	this.panel.add(this.guildbtnretour);
	this.panel.add(this.guildNom);
	this.panel.add(this.guildbtnretour);
	this.panel.add(scroller);
	this.scroller = scroller;
	
	this.getContentPane().add(this.panel);
	this.validate();
	this.repaint();
	
}
	
	public void envoyerunguildpost(){
	System.out.println("message en cour d'envoi magle");
	String message = this.messagefieldguildpost.getText();
	this.messagefieldguildpost.setText("");
	guildpost.envoyerguildpost(this.CurrentUser, message);
	afficheruneguild(CurrentGuild.getId());
	}
	
	public void affichertoutelesguildes(){

	this.getContentPane().remove(this.panel);
	this.getContentPane().remove(this.scroller);
	
	this.panel = new JPanel();
	this.panel.setBounds(0, 0, 600, 500);
	this.panel.setLayout(null);
	this.validate();
	this.repaint();
	
	
	Object[] columnNames = { "Guild", "GuildMaster", "MMO Principale",
			"Server", "id" };
	Object[][] data = getallguildinaJTable();
	JTable table = new JTable(data, columnNames);
	
	table.getColumnModel().getColumn(4).setMinWidth(0);
	table.getColumnModel().getColumn(4).setMaxWidth(0);
	table.setBounds(0, 0, 400, 500);

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
	scroller.setBounds(100, 50, 400, 500);
	scroller.setVisible(true);
	this.scroller = scroller;
	
	this.guildNom = new JLabel(" Toute les guildes : ");
	this.guildNom.setBounds(100, 0, 350, 50);
	this.guildNom.setFont(new Font("Serif", Font.PLAIN, 30));
	this.guildcreate.setBounds(360, 5, 130, 40);
	
	this.remove(this.panel);

	this.panel.add(scroller);
	this.panel.add(this.guildNom);
	this.panel.add(guildcreate);
	this.getContentPane().add(this.panel);
	this.validate();
	this.repaint();
	
}
	
	public Object[][] getallmembresguildinaJTable() {
		LinkedList<guildmembres> allmembres = guildmembres.getallguildmembresbyguildid(CurrentGuild.getId());
		System.out.println(CurrentGuild.getId()+"//");
		Object[][] data = new Object[allmembres.size()][5];
		for (int i = 0; i < allmembres.size(); i++) {
			data[i][0] = allmembres.get(i).username;
			System.out.println(allmembres.get(i).username+"/*");
			data[i][1] = allmembres.get(i).userid; 
			data[i][2] = allmembres.get(i).Guildid; 
		}
		return data;
	}

	public void afficheruneguild(int idguild) {

		guild guild = new guild(idguild, true);
		CurrentGuild.setCurrentGuild(guild);

		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);

		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();

		// Nom de la guild
		this.guildNom = new JLabel(guild.getGuild_name());
		this.guildNom.setBounds(20, 0, 350, 50);
		this.guildNom.setFont(new Font("Serif", Font.PLAIN, 30));

		
		// Candiatures
		
		// Jbuton ?

		this.guildbtncandidatures.setBounds(260, 100, 140, 40);
		this.guildbtnmembres.setBounds(260, 160, 140, 40);
		this.guildbtncalendrier.setBounds(260, 220, 140, 40);
		this.guildbtncandidatures.addActionListener(this);
		this.guildbtnmembres.addActionListener(this);
		this.guildbtncalendrier.addActionListener(this);
		
		// Actualitï¿½

		JScrollPane scroll = addallguildpost();
		this.panel.add(scroll);
		this.panel.add(addenvoisguildpost());
		this.panel.add(this.guildNom);
		this.panel.add(this.guildbtncalendrier);
		this.panel.add(this.guildbtnmembres);
		this.panel.add(this.guildbtncandidatures);
		this.panel.setBackground(Color.RED);

		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
	}
	
	public JPanel addenvoisguildpost(){
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setBounds(20, 50, 220, 200);
		
		JLabel mess = new JLabel(" Ecrivez un message :");
		mess.setBounds(0, 0, 200, 40);
		
	    this.messagefieldguildpost = new JTextField();
	    this.messagefieldguildpost.setBounds(0, 40, 220, 50);
	    
	    this.envoyerguildpostbtn = new JButton("Envoyer");
	    this.envoyerguildpostbtn.addActionListener(this);
	    this.envoyerguildpostbtn.setBounds(140, 100, 80, 40);
	    
	    panel.setBackground(Color.YELLOW);
	    panel.add(mess);		
	    panel.add(this.messagefieldguildpost);	
	    panel.add(this.envoyerguildpostbtn);
		
		return panel;
	}

	public JScrollPane addallguildpost(){
		JPanel panel = new JPanel();
		panel.setLayout(null);	
		panel.setBounds(0, 0, 300, 300);
		panel.setVisible(true);
		LinkedList<guildpost> allposts=guildpost.getallpostforguild( CurrentGuild.getId() );
		int hauteur = 0;
        for (int i = allposts.size()-1; i > 0; i--) {
        	if(allposts.get(i).getUserName() != null){
        		JLabel Auteur = new JLabel("//"+allposts.get(i).getUserName());
        		Auteur.setBounds( 10, hauteur, 190, 50);
        		panel.add( Auteur );
        		
        		JLabel Message = new JLabel("//"+allposts.get(i).getMessage());
        		Message.setBounds( 10, hauteur+10, 190, 50);
        		panel.add(Message);  
        		
        		hauteur += 30;
        	}
        }
        panel.setPreferredSize(new Dimension(50, hauteur+50));
		JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVisible(true);
		scroll.setBounds(20, 200, 220, 250);
		return scroll;
	}
	
	
	public JScrollPane addallcandidatures(){
		JPanel panel = new JPanel();
		panel.setLayout(null);	
		panel.setBounds(0, 0, 300, 300);
		panel.setVisible(true);
		LinkedList<guildpost> allposts=guildpost.getallpostforguild( CurrentGuild.getId() );
		allcandidaturesbtn = new LinkedList<JButton>();
		int hauteur = 0;
		
		
		LinkedList<candidature> allcandidatures=candidature.getcandidaturebyguildid(CurrentGuild.getId());
		
		for (int i = 0; i < allcandidatures.size(); i++) {
        	if(allcandidatures.get(i).getUser_name() != null){
        		
        		JLabel Auteur = new JLabel("//"+allcandidatures.get(i).getUser_name());
        		Auteur.setBounds( 10, hauteur, 190, 50);
        		panel.add( Auteur );
        		
        		JLabel Message = new JLabel("<html><div style='width=150px;'><p style='width=150px;'>"+allcandidatures.get(i).getMessage()+"</p></div></html>");
        		Message.setBounds( 10, hauteur+10, 190, 150);
        		panel.add(Message);  
        		
        		JButton accepter = new JButton("Accepter");
        		accepter.setBounds( 200, hauteur+20, 120, 30);
        		accepter.putClientProperty("id", Integer.valueOf(allcandidatures.get(i).getId()));
        		accepter.addActionListener(this);
        		allcandidaturesbtn.add(accepter);
        		
//        		System.out.println(accepter.getClientProperty("id"));
        		panel.add(accepter);

        		hauteur += 50;
        	}
        }
        panel.setPreferredSize(new Dimension(50, hauteur+50));
		JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVisible(true);
		scroll.setBounds(20, 100, 350, 350);
		return scroll;
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
	
}

//class ButtonRenderer extends JButton implements TableCellRenderer {
//
//	public ButtonRenderer() {
//		setOpaque(true);
//	}
//
//	@Override
//	public Component getTableCellRendererComponent(JTable table, Object value,
//			boolean isSelected, boolean hasFocus, int row, int column) {
//		if (isSelected) {
//			setForeground(table.getSelectionForeground());
//			setBackground(table.getSelectionBackground());
//		} else {
//			setForeground(table.getForeground());
//			setBackground(UIManager.getColor("Button.background"));
//		}
//		setText((value == null) ? "" : value.toString());
//		return this;
//	}
//}
