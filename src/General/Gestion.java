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
	private JButton btnGuild = new JButton("Guilde");
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
	public JButton acceptercandidaturebtn = new JButton("Accepter la candidature");
	public JTextArea candidaturemessage=new JTextArea();
	
	// Guild creation :
	public JTextField Guildnamecreate = new JTextField();
	public JTextField CoGMcreate = new JTextField();
	public JTextField MMOcreate = new JTextField();
	public JTextField Serveurcreate = new JTextField();
	public JButton createguildebtn = new JButton("Valider");
	
	//Guild events :
	public LinkedList<JButton> alleventsbtn = new LinkedList<JButton>();
	public JComboBox role = new JComboBox();
	public JButton eventsinscrirebtn = new JButton("S'inscrire");
	
	// Messagerie
	public JButton nouveaumessage = new JButton("Nouveau Message");
	public JButton envoyermessage = new JButton("Envoyer");
	public JTextField name_destinataire = new JTextField();
	public JTextField messagerie_titre = new JTextField();
	public JTextArea messagerie_message = new JTextArea();
	
	
	// private static Annonceur unAnnonceur;

	public Gestion(Utilisateur user) {
		super();
		
		this.CurrentUser = user;

		this.setBounds(100, 100, 500, 500);
		this.setLayout(null);
		this.setTitle("In Real Game");
		this.setResizable(false);

		this.btnGuild.setBounds(0, 0, 100, 166);
		this.btnMessagerie.setBounds(0, 166, 100, 166);
		this.btnProfile.setBounds(0, 332, 100, 166);

		this.panel.setBounds(100, 0, 400, 500);

		this.add(this.btnProfile);
		this.add(this.btnMessagerie);
		this.add(this.btnGuild);
		this.add(this.panel);
		this.guildbtnretour.addActionListener(this);
		this.guildbtnretour.setVisible(true);
		btnGuild.addActionListener(this);
		this.btnMessagerie.addActionListener(this);
		this.nouveaumessage.addActionListener(this);
		this.envoyermessage.addActionListener(this);
		guildcreate.addActionListener(this);
		createguildebtn.addActionListener(this);
		eventsinscrirebtn.addActionListener(this);
		eventsinscrirebtn.setVisible(true);
		
		afficherhome();

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
		if (source == this.guildbtncalendrier) {
			afficherlesevenements();
		}
		if (source == this.eventsinscrirebtn) {
			participant.createparticipant((int) eventsinscrirebtn.getClientProperty("id"), this.CurrentUser.getId(), this.CurrentUser.getUsername(), (String) this.role.getSelectedItem());
			afficherunevent((int) eventsinscrirebtn.getClientProperty("id"));
		}
		if (source==this.acceptercandidaturebtn) {
			accepterunecandidature();
		}
		if (source==this.btnMessagerie) {
			afficherlamessagerie();
		}
		if (source==this.nouveaumessage) {
			afficherformulairedenouveaumessage();
		}
		if (source==this.envoyermessage) {
			// envoyerlemessage
			//cod21
			envoyerlemessage();		
			
		}
		for (int i = 0; i < allcandidaturesbtn.size(); i++) {
			if (source == allcandidaturesbtn.get(i) ) {
				afficherunecadidature(  (int) allcandidaturesbtn.get(i).getClientProperty("id") );
			}
		}	
		for (int i = 0; i < alleventsbtn.size(); i++) {
			if (source == alleventsbtn.get(i) ) {
				afficherunevent(  (int) alleventsbtn.get(i).getClientProperty("id") );
			}
		}

	}

	protected void mouseDblClicked(int row, int column) {
		// TODO Auto-generated method stu
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

			this.getContentPane().add(this.panel);
			this.validate();
			this.repaint();
	}
		
	public void envoyerlemessage(){
		int id = Utilisateur.checkifuserexist( this.name_destinataire.getText() );
		
		if ( id != 0 ) {
			int id_env = this.CurrentUser.getId();
			String name_env =this.CurrentUser.getUsername();
			System.out.println(this.name_destinataire.getText());
			message.createmessage(id_env, name_env, id, this.name_destinataire.getText(), this.messagerie_titre.getText(), this.messagerie_message.getText());
			afficherlamessagerie();
		}else{
		}
	}
		
	public void afficherformulairedenouveaumessage(){
		
		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);
		
		this.panel = new JPanel();
		this.panel.setBounds(0, 0, 600, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		
		
//		JScrollPane scroller = new JScrollPane(table);
//		scroller.setBounds(100, 50, 400, 500);
		
		JLabel labeltitre = new JLabel("Titre:");
		labeltitre.setBounds(100, 50, 90, 25);
		messagerie_titre.setBounds(190, 50, 180, 25);
		
		
		JLabel labeldestinataire = new JLabel("Destinataire:");
		labeldestinataire.setBounds(100, 75, 90, 25);
		name_destinataire.setBounds(190, 75, 180, 25);
		
		JLabel labelmessage = new JLabel("Votre message:");
		labelmessage.setBounds(100, 100, 90, 25);
		
		messagerie_message.setVisible(true);
		messagerie_message.setLineWrap(true); 
		messagerie_message.setWrapStyleWord(true);
		messagerie_message.setEditable(true);
		
		JScrollPane scroll = new JScrollPane(messagerie_message);
		scroll.setBounds(110, 125, 350, 300);
		scroll.setVisible(true);
		
		this.guildNom = new JLabel(" Nouveau message : ");
		this.guildNom.setBounds(100, 0, 350, 50);
		this.guildNom.setFont(new Font("Serif", Font.PLAIN, 30));
		this.envoyermessage.setBounds(360, 5, 130, 40);
		
		this.remove(this.panel);
		this.panel.add(labeltitre);
		this.panel.add(messagerie_titre);
		this.panel.add(labeldestinataire);
		this.panel.add(name_destinataire);
		this.panel.add(labelmessage);
		this.panel.add(scroll);
		this.panel.add(this.envoyermessage);
		this.panel.add(this.guildNom);
		this.panel.add(labeltitre);
		this.panel.add(labeldestinataire);
		this.panel.add(labelmessage);
		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
		
	}
	
	public void afficherunmessage(int id){
		
		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);
		
		this.panel = new JPanel();
		this.panel.setBounds(0, 0, 600, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		
		
//		JScrollPane scroller = new JScrollPane(table);
//		scroller.setBounds(100, 50, 400, 500);
		
		message mess = message.getmessagebyid(id);
		
		
		JLabel labelenvoyeur = new JLabel(mess.getName_env());
		labelenvoyeur.setBounds(100, 50, 90, 25);
		
		JLabel date = new JLabel(mess.getDate()+"");
		date.setBounds(100, 75, 90, 25);
		
		messagerie_message = new JTextArea(mess.getMessage());
		messagerie_message.setVisible(true);
		messagerie_message.setLineWrap(true); 
		messagerie_message.setWrapStyleWord(true);
		messagerie_message.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(messagerie_message);
		scroll.setBounds(110, 125, 350, 300);
		scroll.setVisible(true);
		
		this.guildNom = new JLabel(mess.getTitre());
		this.guildNom.setBounds(100, 0, 350, 50);
		this.guildNom.setFont(new Font("Serif", Font.PLAIN, 30));
//		this.envoyermessage.setBounds(360, 5, 130, 40);
		this.remove(this.panel);
		this.panel.add(messagerie_titre);
		this.panel.add(labelenvoyeur);
		this.panel.add(name_destinataire);
		this.panel.add(scroll);
		this.panel.add(this.guildNom);
		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
		
	}
		
	public void afficherlamessagerie(){
		

		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);
		
		this.panel = new JPanel();
		this.panel.setBounds(0, 0, 600, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		
		
		Object[] columnNames = { "Titre", "Envoyeur", "date",
				 "id" };
		Object[][] data = getallmessagesinaJTable();
		JTable table = new JTable(data, columnNames);
		
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setMaxWidth(0);
		table.setBounds(0, 0, 400, 500);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int ligneclicked = table.rowAtPoint(e.getPoint());
					Object idmess= getmessageidbylineclicked(ligneclicked);
					int id = (int) idmess;

					afficherunmessage(id);
				}
			}
		});
		
		this.table = table;
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(100, 50, 400, 500);
		scroller.setVisible(true);
		this.scroller = scroller;
		
		this.guildNom = new JLabel(" Tous vos messages : ");
		this.guildNom.setBounds(100, 0, 350, 50);
		this.guildNom.setFont(new Font("Serif", Font.PLAIN, 30));
//		this.guildcreate.setBounds(360, 5, 130, 40);
		this.nouveaumessage.setBounds(360, 5, 130, 40);
		
		this.remove(this.panel);
		this.panel.add(this.nouveaumessage);
		this.panel.add(scroller);
		this.panel.add(this.guildNom);
		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
		
	}
		
	public void accepterunecandidature(){
		candidature cand = candidature.getcandidaturebyID((int) this.acceptercandidaturebtn.getClientProperty("id"));
		guildmembres.createmember(CurrentGuild.getId(), cand.getUser_id(), cand.getUser_name());
		candidature.deletcandidaturebyid((int) this.acceptercandidaturebtn.getClientProperty("id"));
		afficherlescandidatures();
	}
		
	public void afficherunevent(int id){
		
		planing event = planing.geteventbyid(id);

		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);

		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		
		this.guildbtnretour.setBounds(280, 50, 100, 50);
		
		
		JLabel titre = new JLabel("<html><p>"+event.getTitre()+"</p></html>");
		titre.setBounds(20, 0, 350, 50);
		titre.setFont(new Font("Serif", Font.PLAIN, 30));
		
		JTextArea description = new JTextArea(""+event.getInfos()+"");
		description.setEditable(false);
		description.setBounds(20, 150, 350, 200);
		description.setLineWrap(true);
		
		JLabel auteur = new JLabel("<html><p>Auteur:"+event.getAuteur_name()+"</p></html>");
		auteur.setBounds(20, 30, 350, 50);
		
		participant par = participant.getparticipant(id, this.CurrentUser.id);
		
		if (par == null) {
			
			JLabel rolelabel = new JLabel("Role:");
			rolelabel.setBounds(50, 400, 100, 30);
			
			String[] items = {"Heal", "DPS", "Tank"};
			role = new JComboBox(items);
			role.setBounds(100, 400, 100, 30);
			
			eventsinscrirebtn.putClientProperty("id", id);
			eventsinscrirebtn.setBounds(250, 400, 100, 30);
			
			this.panel.add(eventsinscrirebtn);
			this.panel.add(role);
			this.panel.add(rolelabel);
			
		}else{
			JLabel rolelabel = new JLabel("Vous étes bien inscrit en tant que:"+par.getRole());
			rolelabel.setBounds(50, 400, 300, 30);
			this.panel.add(rolelabel);
		}

		this.panel.add(titre);
		this.panel.add(auteur);
		this.panel.add(description);
		this.panel.add(this.guildbtnretour);
		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
	}
	
	public void afficherlescandidatures(){

		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);
		
		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		

		this.guildNom = new JLabel("Toutes les candidatures :");
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
	String guildname = Guildnamecreate.getText();
	String Cogm = CoGMcreate.getText();
	String mmo = MMOcreate.getText();
	String serveur = Serveurcreate.getText();
	
	if ( !mmo.isEmpty() && !guildname.isEmpty() && !Cogm.isEmpty() && !serveur.isEmpty() ) {
		if (guild.createguilde(guildname, this.CurrentUser.username, Cogm, this.CurrentUser.getId(), mmo, serveur)) {
			affichertoutelesguildes();
		}else {
			}
	}else {
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

		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
	}
	
	public void afficherlesevenements(){
		
		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);
		
		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		
		this.guildbtnretour.setBounds(280, 50, 100, 50);
		
		this.acceptercandidaturebtn = new JButton("Accepter");
		this.acceptercandidaturebtn.setBounds(280, 400, 100, 50);
		this.acceptercandidaturebtn.setVisible(true);
		
		JLabel entete = new JLabel("Tous les évenements:");
		entete.setBounds(20, 0, 350, 50);
		entete.setFont(new Font("Serif", Font.PLAIN, 30));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);	
		panel.setBounds(0, 0, 300, 300);
		panel.setVisible(true);
		int hauteur = 0;
		
		LinkedList<planing> allevents= planing.getalleventbyguildID(CurrentGuild.getId());

	if (allevents != null) {
			
		for (int i = 0; i < allevents.size(); i++) {

        	if(allevents.get(i).getAuteur_name() != null){
        		
        		JLabel Auteur = new JLabel(""+allevents.get(i).getAuteur_name());
        		Auteur.setBounds( 10, hauteur, 130, 30);
        		panel.add( Auteur );
        		
        		JLabel titre = new JLabel(""+allevents.get(i).getTitre());
        		titre.setBounds( 10, hauteur+10, 120, 30);
        		panel.add(titre);
        		
        		JLabel date = new JLabel(allevents.get(i).getDate()+"");
        		date.setBounds(10, hauteur+20, 120, 30);
        		
        		
        		JButton afficher = new JButton("Afficher");
        		afficher.setBounds( 200, hauteur, 120, 30);
        		afficher.putClientProperty("id", Integer.valueOf(allevents.get(i).getId()));
        		afficher.addActionListener(this);
        		
        		alleventsbtn.add(afficher);
        		
        		panel.add(afficher);

        		hauteur += 70;
        	}
        }
	}
        panel.setPreferredSize(new Dimension(50, hauteur+50));
		JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVisible(true);
		scroll.setBounds(20, 100, 350, 350);
		this.panel.add(entete);
		this.panel.add(this.guildbtnretour);
		this.panel.add(scroll);
		
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
	table = new JTable(data, columnNames);
	
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
		Object[][] data = new Object[allmembres.size()][5];
		for (int i = 0; i < allmembres.size(); i++) {
			data[i][0] = allmembres.get(i).username;
			data[i][1] = allmembres.get(i).userid; 
			data[i][2] = allmembres.get(i).Guildid; 
		}
		return data;
	}

	public void afficherunecadidature(int idcanddature) {

		candidature cand = new candidature();
		cand= cand.getcandidaturebyID(idcanddature);

		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);

		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		
		this.guildbtnretour.setBounds(280, 50, 100, 50);
		
		this.acceptercandidaturebtn = new JButton("Accepter");
		this.acceptercandidaturebtn.addActionListener(this);
		this.acceptercandidaturebtn.putClientProperty("id", cand.getId());
		this.acceptercandidaturebtn.setBounds(280, 400, 100, 50);
		this.acceptercandidaturebtn.setVisible(true);
		
		JLabel titre = new JLabel("<html><p>"+cand.getMessage_titre()+"</p></html>");
		titre.setBounds(20, 0, 350, 50);
		titre.setFont(new Font("Serif", Font.PLAIN, 30));
		
		this.candidaturemessage = new JTextArea(cand.getMessage());
		this.candidaturemessage.setBounds(20, 110, 320, 250);
		this.candidaturemessage.setVisible(true);
		this.candidaturemessage.setEditable(false);
		this.candidaturemessage.setLineWrap(true); 
		this.candidaturemessage.setWrapStyleWord(true); 

		
		this.panel.add(this.acceptercandidaturebtn);
		this.panel.add(this.guildbtnretour);
		this.panel.add(titre);
		this.panel.add(this.candidaturemessage);
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
        		JLabel Auteur = new JLabel(""+allposts.get(i).getUserName());
        		Auteur.setBounds( 10, hauteur, 190, 50);
        		panel.add( Auteur );
        		
        		JLabel Message = new JLabel(""+allposts.get(i).getMessage());
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
        		
        		JLabel Auteur = new JLabel(""+allcandidatures.get(i).getUser_name());
        		Auteur.setBounds( 10, hauteur, 190, 50);
        		panel.add( Auteur );
        		
        		JLabel Message = new JLabel("<html><div style='width=150px;'><p style='width=150px;'>"+allcandidatures.get(i).getMessage()+"</p></div></html>");
        		Message.setBounds( 10, hauteur+10, 190, 150);
        		panel.add(Message);  
        		
        		JButton afficher = new JButton("Afficher");
        		afficher.setBounds( 200, hauteur+20, 120, 30);
        		afficher.putClientProperty("id", Integer.valueOf(allcandidatures.get(i).getId()));
        		afficher.addActionListener(this);
        		allcandidaturesbtn.add(afficher);
        		
        		panel.add(afficher);

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
	
	public Object getmessageidbylineclicked(int ligneclicked){
		Object id = this.table.getValueAt(ligneclicked, 3);
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
	public Object[][] getallmessagesinaJTable() {
		LinkedList<message> allmessages = message.getallmessageforuser(this.CurrentUser.getId());
		Object[][] data = new Object[allmessages.size()][5];

		for (int i = 0; i < allmessages.size(); i++) {
			data[i][0] = allmessages.get(i).getTitre();
			data[i][1] = allmessages.get(i).getName_env();
			data[i][2] = allmessages.get(i).getDate();
			data[i][3] = allmessages.get(i).getId();
		}
		return data;
	}
	
	public void afficherhome(){
		this.getContentPane().remove(this.panel);
		this.getContentPane().remove(this.scroller);

		this.panel = new JPanel();
		this.panel.setBounds(100, 0, 400, 500);
		this.panel.setLayout(null);
		this.validate();
		this.repaint();
		

		JLabel titre = new JLabel("In");
		titre.setBounds(20, 0, 350, 100);
		titre.setFont(new Font("Serif", Font.PLAIN, 80));
		this.panel.add(titre);

		titre = new JLabel("Real");
		titre.setBounds(90, 90, 350, 100);
		titre.setFont(new Font("Serif", Font.PLAIN, 80));
		this.panel.add(titre);
		
		titre = new JLabel("Game");
		titre.setBounds(160, 180, 350, 100);
		titre.setFont(new Font("Serif", Font.PLAIN, 80));
		this.panel.add(titre);
		
		
		this.getContentPane().add(this.panel);
		this.validate();
		this.repaint();
	}
	
}
