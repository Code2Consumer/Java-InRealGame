package General;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

public class Visuel extends JFrame implements ActionListener{
    private JTextField connectionlogin = new JTextField();
    private JPasswordField connectionmdp = new JPasswordField();
    private JButton connection = new JButton("Connection");
    private JButton inscription = new JButton("Inscription");
    private JLabel LabelLogin = new JLabel(" Login : ");
    private JLabel LabelMDP = new JLabel(" Password :  ");
    private JLabel LabelTitre = new JLabel(" In Real Game ");
    private JLabel LabelMessage = new JLabel(" Connection ");
//    private static Annonceur unAnnonceur;

    public Visuel(){
        super();
        this.setBounds(300, 300, 300, 350);
        this.setLayout(null);
        this.setTitle("In Real Game");
        this.setResizable(false);
        
        this.connection.setBounds(40, 170, 200, 40);
        this.inscription.setBounds(40, 220, 200, 40);
        this.connectionlogin.setBounds(120, 100, 120, 20);
        this.connectionmdp.setBounds(120, 130, 120, 20);
        this.LabelLogin.setBounds(40, 100, 100, 20);
        this.LabelMDP.setBounds(40, 130, 100, 20);
        this.LabelTitre.setBounds(40, 20, 200, 50);
        this.LabelMessage.setBounds(110, 60, 200, 40);
        
        this.add(this.connection);
        this.add(this.inscription);
        this.add(this.connectionlogin);
        this.add(this.connectionmdp);
        this.add(this.connection);
        this.add(this.LabelLogin);
        this.add(this.LabelMDP);
        this.add(this.LabelTitre);
        this.add(this.LabelMessage);
        
        this.LabelTitre.setFont( new Font("Serif", Font.PLAIN, 30));
        
        
        connection.addActionListener(this);
        inscription.addActionListener(this);

        
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
    	Visuel visu = new Visuel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object  source=e.getSource();
     
        
        if  (source==connection){
        	
        	String login = this.connectionlogin.getText();
        	String mdp = this.connectionmdp.getText();
            
            Utilisateur ut = new Utilisateur();
            ut.connection(login, mdp);
            
            if( ut.getId() != 0 ){
            	
            	Gestion gest = new Gestion();
            	
            	this.setVisible(false); //you can't see me!
            	this.dispose(); //Destroy the JFrame object
            	
            }else{
            	
            	this.LabelMessage.setText(" Indentiffiants incorecte ");
            	
            }

            
//            Message mess= new Message(12, "lol");
//            
//            mess.test();
//            
//            Utilisateur ut = new Utilisateur();
//            ut.getallusers();
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
        
        if  (source==inscription){
//            Model testance = new Model();
//            testance.insertsms(this.zoneCode.getText());
//            
//            this.zoneCode.getText();
            }
    }
    
    
    
    
}