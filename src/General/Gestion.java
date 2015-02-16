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
        
        this.add( this.panel );
        
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
            
            affichertoutelesguilds();

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
    
    public void createguildJpanel(guild guild){
    	
    	JPanel Gpanel = new JPanel();
    	
        JButton VoirGuild = new JButton("Voir La Guild ");
        JButton Postuler = new JButton(" Postuler ");
        
        JLabel GuildName = new JLabel( guild.getGuild_name() );
        JLabel GuildgM = new JLabel( guild.getGM() );
        JLabel GuildMmoPrincipale = new JLabel( guild.getMMO_Principale() );
        JLabel GuildServeur= new JLabel( guild.getServeur() );
        
//        GuildName.setBounds(100, 0, 400, 500);
//        GuildgM.setBounds(100, 0, 400, 500);
//        GuildMmoPrincipale.setBounds(100, 0, 400, 500);
//        GuildServeur.setBounds(100, 0, 400, 500);
        
//        GuildName;
//        GuildgM;
//        GuildMmoPrincipale;
//        GuildServeur;
        

//        this.panel.setBounds(100, 0, 400, 500);
//        this.add( this.btnProfile );
    }
    
    
    
}