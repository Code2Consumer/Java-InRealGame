package General;

import java.awt.Color;
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
            
            JPanel pan = createguildJpanel(guild);
            pan.setBackground(Color.BLACK);
            pan.setVisible(true);
            this.add(pan);
            
            }
        
//        if  (source==insert){
//            Model testance = new Model();
//            testance.insertsms(this.zoneCode.getText());
//            
//            this.zoneCode.getText();
            
    }
    
    public void affichertoutelesguilds(){

    	LinkedList<guild> allguilds = guild.getallguilds();
        for (int i = 0; i < allguilds.size(); i++) {
            System.out.println(allguilds.get(i).getId());
        }
    	
    }
    
    public JPanel createguildJpanel(guild guild){
    	
    	JPanel Gpanel = new JPanel();
    	Gpanel.setBounds(100, 0, 400, 500);
    	
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