package General;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
public class Gestion extends JFrame implements ActionListener{

    private JButton btnProfile = new JButton("Profile");
    private JButton btnMessagerie = new JButton("Messagerie");
    private JButton btnGuild = new JButton("Guild");
    private JButton voirguild = new JButton("voidguild");
    private JTable table = new JTable();
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
        this.voirguild.setBounds(0, 120, 100, 40);
        

    	this.voirguild.setVisible(true);
    	this.panel.add(this.voirguild);
        
//        this.btnGuild.
        
        this.panel.setBounds(100, 0, 400, 500);
        
        this.add( this.btnProfile );
        this.add( this.btnMessagerie );
        this.add( this.btnGuild );
        this.add( this.panel );
        this.add(this.voirguild);
        
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
            
        	Object[] columnNames = {"Guild", "GuildMaster", "MMO Principale", "Server", "Button"};
        	Object[][] data =getallguildinaJTable();
            JTable table = new JTable(data, columnNames);

            table.getColumn("Button").setCellRenderer(new ButtonRenderer());
            
            table.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                  if (e.getClickCount() == 2) {

                    int ligneclicked = table.rowAtPoint(e.getPoint());
                    getguildidbylineclicked(ligneclicked);
                  }
                }
              });
            
            this.table=table;
        
        	JScrollPane scroller = new JScrollPane( table );

     
          	// pan.setBounds(100, 0, 300, 400);
      		scroller.setBounds(100, 0, 400, 500);
      		scroller.setVisible(true);
        	
        	this.remove( this.panel );
        	
        	this.getContentPane().add( scroller);
            
            this.validate();
            this.repaint();

            }
        
        if  (source==this.voirguild){
        	
        	afficheruneguild();	

    }
            
    }
    
    protected void mouseDblClicked(int row, int column) {
		// TODO Auto-generated method stu
	}

	public void afficheruneguild(){

    	this.panel.removeAll();
    	this.voirguild.setVisible(true);
    	this.panel.add(this.voirguild);
    	
    }
	
	public void getguildidbylineclicked(int ligneclicked){
		String id = this.table.getValueAt(ligneclicked, 2)+"";
		System.out.println(id);
	}
    
    public Object[][] getallguildinaJTable(){
    	
    	LinkedList<guild> allguilds = guild.getallguilds();
    	
    	Object[][] data = new Object[allguilds.size()][5];

    	for (int i = 0; i < allguilds.size(); i++) {
    		data[i][0] = allguilds.get(i).getGuild_name();
    		data[i][1] = allguilds.get(i).getGM();
    		data[i][2] = allguilds.get(i).getMMO_Principale();
    		data[i][3] = allguilds.get(i).getServeur();
    		data[i][4] = new JButton("Voir la guild");
        }    	
    	return data;
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
    
    public JPanel afficheruneguild(guild guild, int hauteur){
    	JPanel pan = this.createguildJpanel(guild, hauteur);
    	return pan;
    }
    
    
    public JPanel createguildJpanel(guild guild, int hauteur){
    	
    	JPanel Gpanel = new JPanel();
    	Gpanel.setBounds(100, hauteur, 40, 50);
    	
    	
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
      
      Gpanel.setBackground(Color.YELLOW);
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
