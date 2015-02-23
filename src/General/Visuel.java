package General;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

public class Visuel extends JFrame implements ActionListener{
	
	public JPanel PanelContent = new JPanel(new BorderLayout());
    private JTextField connectionlogin = new JTextField();
    private JTextField connectionemail = new JTextField();
    private JPasswordField connectionmdp = new JPasswordField();
    private JButton connection = new JButton("Connection");
    private JButton inscription = new JButton("Inscription");
    private JButton inscriptionValider = new JButton("Valider");
    private JButton sinscrire = new JButton(" S'inscrire ");
    private JLabel LabelLogin = new JLabel(" Login : ");
    private JLabel LabelMDP = new JLabel(" Password :  ");
    private JLabel LabelEmail = new JLabel(" Email : ");
    private JLabel LabelTitre = new JLabel(" In Real Game ");
    private JLabel LabelMessage = new JLabel(" Connection ");

    public Visuel(){
        super();
        this.setBounds(300, 300, 300, 350);
        this.setLayout(null);
        this.setTitle("In Real Game");
        this.setResizable(false);
        
        setpanelconnection();

        this.add(this.PanelContent);
        this.setVisible(true);
        
        this.inscription.addActionListener(this);          
        this.inscriptionValider.addActionListener(this);        
        this.connection.addActionListener(this);
        this.sinscrire.addActionListener(this);
        
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
        }
        
        if  (source==inscription){
        	

            System.out.println("inscription pressed");
            setpanelinscription();

            }
        if  (source==sinscrire){
        	
            System.out.println("sinscrire pressed");
            
            String username = connectionlogin.getText();
            String password = connectionmdp.getText();
            String email = connectionemail.getText();
            
            Utilisateur.inscription(username, email, password);
            
            setpanelconnection();
            
            }
    }
    
    public void setpanelinscription() {
    	
    	JPanel PanelContentt = new JPanel(new BorderLayout());
    	
    	this.remove(PanelContent);
    	PanelContent.remove(connection);
    	
    	this.LabelEmail.setVisible(true);

    	this.connectionlogin.setBounds(120, 100, 120, 20);
        this.connectionmdp.setBounds(120, 130, 120, 20);
        this.connectionemail.setBounds(120, 160, 120, 20);
        this.LabelLogin.setBounds(40, 100, 100, 20);
        this.LabelMDP.setBounds(40, 130, 100, 20);
        this.LabelEmail.setBounds(40, 160, 100, 20);
        this.LabelTitre.setBounds(40, 20, 200, 50);
        this.LabelMessage.setBounds(110, 60, 200, 40);
        this.sinscrire.setBounds(40, 220, 200, 40);
        sinscrire.setVisible(true);
        
        
    	
        PanelContentt.add(this.connectionlogin);
        PanelContentt.add(this.connectionemail);
        PanelContentt.add(this.connectionmdp);
        PanelContentt.add(this.LabelLogin);
        PanelContentt.add(this.LabelMDP);
        PanelContentt.add(this.LabelTitre);
        PanelContentt.add(this.LabelEmail);
        PanelContentt.add(this.sinscrire);
        
        
        PanelContentt.add(this.LabelMessage);
        
        PanelContentt.setBounds(0, 0, 500, 700);
        PanelContentt.setVisible(true);
        
        this.remove(PanelContent);
        PanelContent = PanelContentt;
        this.add(PanelContent);

        this.validate();
        this.repaint();

    // PanelContent = new JPanel();
    }
    
    
    public void setpanelconnection(){
    	
    	JPanel PanelContentt = new JPanel(new BorderLayout());
    	
    	this.remove(PanelContent);
    	
        this.validate();
        this.repaint();
    	
    	// this.PanelContent.setBackground(Color.black);

        
        this.connection.setBounds(40, 170, 200, 40);
        this.inscription.setBounds(40, 220, 200, 40);
        this.connectionlogin.setBounds(120, 100, 120, 20);
        this.connectionmdp.setBounds(120, 130, 120, 20);
        this.LabelLogin.setBounds(40, 100, 100, 20);
        this.LabelMDP.setBounds(40, 130, 100, 20);
        this.LabelTitre.setBounds(40, 20, 200, 50);
        this.LabelMessage.setBounds(110, 60, 200, 40);
        this.LabelTitre.setFont( new Font("Serif", Font.PLAIN, 30));
        
        PanelContentt.setBounds(0, 0, 500, 700);
        PanelContentt.setVisible(true);
        
        PanelContentt.add(this.connection);
        PanelContentt.add(this.inscription);
        PanelContentt.add(this.connectionlogin);
        PanelContentt.add(this.connectionmdp);
        PanelContentt.add(this.connection);
        PanelContentt.add(this.LabelLogin);
        PanelContentt.add(this.LabelMDP);
        PanelContentt.add(this.LabelTitre);
        PanelContentt.add(this.LabelMessage);
        
        PanelContent = PanelContentt;
        
        this.add(this.PanelContent);
        
        this.validate();
        this.repaint();
    }
    
    
    
    
}