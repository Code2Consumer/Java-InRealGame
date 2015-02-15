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
        this.setTitle("Etude de cas Trelis");
        this.setResizable(false);
        
        
        this.btnProfile.setBounds(0, 0, 100, 40);
        this.btnMessagerie.setBounds(0, 40, 100, 40);
        this.btnGuild.setBounds(0, 80, 100, 40);
        
        this.panel.setBounds(100, 0, 400, 500);
        
        this.add( this.btnProfile );
        this.add( this.btnMessagerie );
        this.add( this.btnGuild );
        
        this.panel.setBackground(Color.BLACK);
        
        this.add( this.panel );
        
//        this.add(this.valider);
//        this.add(this.insert);
        
//        valider.addActionListener(this);
//        insert.addActionListener(this);

        
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
    	
        Gestion Gestion = new Gestion();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object  source=e.getSource();
     
        
        if  (source==source){
            System.out.println("source clicked");
            
            Message mess= new Message(12, "lol");
            
//            mess.test();
            
            Utilisateur ut = new Utilisateur();
            ut.getallusers();
//            System.out.println(this.zoneCode.getText());
//            this.vueXML.setText(this.zoneCode.getText());
            
//            Diffusion diff=new Diffusion();
//            String test= diff.toXML();
//            
//            this.vueXML.setText(test);
//            
//            this.zoneCode.setText("its done");
            
//            Model testance = new Model();
//            LinkedList<Message> messms=testance.selectAll();
//            String afficher="";
//            
//            for (Message message : messms) {
//                afficher+=message.getSms();
//            }
//            
            
//            Message Message = messms.get(0);
//            Message.getSms();
//            this.vueXML.setText(afficher);
            
            }
        
//        if  (source==insert){
//            Model testance = new Model();
//            testance.insertsms(this.zoneCode.getText());
//            
//            this.zoneCode.getText();
            
    }
    
    
    
    
}