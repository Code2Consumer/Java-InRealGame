package General;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Gestion extends JFrame implements ActionListener{

    private JButton btnProfile = new JButton("Profile");
    private JButton btnMessagerie = new JButton("Messagerie");
    private JButton btnGuild = new JButton("Guild");
    private JPanel panel = new JPanel();
    
    
//    private static Annonceur unAnnonceur;
    
    public Gestion(){
        super();
        
        this.setBounds(100, 100, 500, 500);
        this.setLayout(null);
        this.setTitle("In Real Game");
        this.setResizable(false);
        
        
        this.btnProfile.setBounds(0, 0, 100, 40);
        this.btnMessagerie.setBounds(0, 40, 100, 40);
        this.btnGuild.setBounds(0, 80, 100, 40);
        
//        this.btnGuild.
        
        this.panel.setBounds(100, 0, 400, 500);
        
        this.add( this.btnProfile );
        this.add( this.btnMessagerie );
        this.add( this.btnGuild );
        this.add( this.panel );
        
        this.panel.setBackground(Color.BLACK);
        
       
        
//        this.add(this.valider);
//        this.add(this.insert);
        
        	btnGuild.addActionListener(this);
//        insert.addActionListener(this);

        
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
    	
        Gestion gest = new Gestion();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object  source=e.getSource();
     
        
        if  (source==btnGuild){
        	
            System.out.println("source clicked");
            
            // affichertoutelesguilds();
            
            guild guild = new guild(12, 2, "nom de la guild", "nomgm", "nom co gm", "nom mmo proincipale", "nom serveur");
            
            JPanel pan = this.getallguildspanelsinapanel();
            
            pan.setBackground(Color.BLUE);
            pan.setVisible(true);

        	//pan.setBounds(100, 0, 300, 400);
        	JScrollPane scroller = new JScrollPane(pan,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        	scroller.setBounds(100, 0, 300, 400);
        	scroller.setVisible(true);

        	//pan.add(scroller);
        	this.remove( this.panel );
        	this.panel = pan;
        	this.add( scroller );
            
        	

            
            
            this.revalidate();
            this.repaint();
            }
        
//        if  (source==insert){
//            Model testance = new Model();
//            testance.insertsms(this.zoneCode.getText());
//            
//            this.zoneCode.getText();
            
    }
    
    public JPanel getallguildspanelsinapanel(){
     	int hauteur = 0;
    	LinkedList<guild> allguilds = guild.getallguilds();
    	JPanel panguild = new JPanel();
    	JPanel pan = new JPanel();
    	pan.setBounds(100, 0, 400, 500);
    	pan.setVisible(true);
    	
    	for (int i = 0; i < allguilds.size(); i++) {
            System.out.println(allguilds.get(i).getId());
            panguild = afficheruneguild(allguilds.get(i), hauteur);
            hauteur+=100;
            pan.add(panguild);
        }
    	
    	return pan;
    }
    
    public JPanel affichertoutelesguilds(){

    	LinkedList<guild> allguilds = guild.getallguilds();
    	int hauteur = 0;
    	JPanel pan = new JPanel();
    	
        for (int i = 0; i < allguilds.size(); i++) {
            System.out.println(allguilds.get(i).getId());
            pan = afficheruneguild(allguilds.get(i), hauteur);
            hauteur+=100;
        }
        return pan;
    	
    }
    
    public JPanel afficheruneguild(guild guild, int hauteur){
    	JPanel pan = this.createguildJpanel(guild, hauteur);
    	return pan;
    }
    
    
    public JPanel createguildJpanel(guild guild, int hauteur){
    	
    	JPanel Gpanel = new JPanel();
    	Gpanel.setBounds(100, hauteur, 400, 500);
    	
        JButton VoirGuild = new JButton("Voir La Guild ");
        // <html> <body> <span style='color=red;'> </body> </span> </html>
        JButton Postuler = new JButton(" Postuler ");
        
        JLabel GuildName = new JLabel( guild.getGuild_name() );
        JLabel GuildgM = new JLabel( guild.getGM() );
        JLabel GuildMmoPrincipale = new JLabel( guild.getMMO_Principale() );
        JLabel GuildServeur= new JLabel( guild.getServeur() );
        
      Gpanel.add( GuildName );
      Gpanel.add(GuildgM);
      Gpanel.add(GuildMmoPrincipale);
      Gpanel.add(GuildServeur);
      Gpanel.add(VoirGuild);
      Gpanel.add(Postuler);
      
      Gpanel.setBackground(Color.BLUE);
      Gpanel.setVisible(true);
      
      return Gpanel;


        
//        GuildName.setBounds(0, 10, 40, 50);
//        GuildgM.setBounds(0, 10, 40, 500);
//        GuildMmoPrincipale.setBounds(0, 10, 40, 50);
//        GuildServeur.setBounds(0, 10, 40, 50);
        
//        GuildName;
//        GuildgM;
//        GuildMmoPrincipale;
//        GuildServeur;
        

//        this.panel.setBounds(100, 0, 400, 500);
//        this.add( this.btnProfile );
    }
    
    
    
}