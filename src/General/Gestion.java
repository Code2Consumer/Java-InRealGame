package General;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

public class Gestion extends JFrame implements ActionListener{
    private JTextField zoneCode = new JTextField();
    private JTextArea vueXML = new JTextArea();
    private JButton valider = new JButton("Valider");
    private JButton insert = new JButton("insert");
//    private static Annonceur unAnnonceur;
    
    public Gestion(){
        super();
        this.setBounds(100, 100, 500, 500);
        this.setLayout(null);
        this.setTitle("Etude de cas Trelis");
        this.setResizable(false);
        
        
        this.zoneCode.setBounds(40, 40, 100, 20);
        this.vueXML.setBounds(160, 40, 250, 200);
        this.valider.setBounds(50, 200, 90, 20);
        this.insert.setBounds(50, 250, 90, 20);
        
        
        this.add(this.zoneCode);
        this.add(this.valider);
        this.add(this.vueXML);
        this.add(this.insert);
        
        valider.addActionListener(this);
        insert.addActionListener(this);

        
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
//        Gestion Gestion = new Gestion();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object  source=e.getSource();
     
        
        if  (source==valider){
            System.out.println("source clicked");
            
            Message mess= new Message(12, "lol");
            
            mess.test();
            
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
        
        if  (source==insert){
//            Model testance = new Model();
//            testance.insertsms(this.zoneCode.getText());
//            
//            this.zoneCode.getText();
            }
    }
    
    
    
    
}