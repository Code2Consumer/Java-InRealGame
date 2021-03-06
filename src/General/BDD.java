package General;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD
{
	private String uneBDD, unServeur, unUser, unMdp;
	private Connection uneConnexion ;
	
	public BDD (String unServeur,String uneBDD,String unUser,String unMdp )
	{
		this.unServeur = unServeur;
		this.uneBDD = uneBDD;
		this.unUser = unUser;
		this.unMdp = unMdp;
		this.uneConnexion = null;
	}
	
	public BDD(){
		this.unServeur = "localhost";
		this.uneBDD = "symfony";
		this.unUser = "root";
		this.unMdp = "";
		this.uneConnexion = null;
		
//		this.unServeur = "192.168.56.1";
//		this.uneBDD = "symfony";
//		this.unUser = "root";
//		this.unMdp = "";
//		this.uneConnexion = null;
		
//		this.unServeur = "db572590630.db.1and1.com";
//		this.uneBDD = "db572590630";
//		this.unUser = "dbo572590630";
//		this.unMdp = "mysqlmdp";
//		this.uneConnexion = null;
		
//		this.unServeur = "sql2.olympe.in";
//		this.uneBDD = "r6k35uom";
//		this.unUser = "r6k35uom";
//		this.unMdp = "letmein";
//		this.uneConnexion = null;
		
//		this.unServeur = "mysql1.hostinger.fr";
//		this.uneBDD = "u826733868_data";
//		this.unUser = "u826733868_user";
//		this.unMdp = "ymf0N5OHnz";
//		this.uneConnexion = null;

	}
	
	public void chargerPilote () 
	{
		try
		{
			//verification de la pr�sence du pilote jdbc, mysql
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException exp)
		{
			System.out.println("Pilote absent, mysql.connector.java");
		}
	}
	
	public void seConnecter ()
	{
		String url = "jdbc:mysql://"+this.unServeur+"/"+this.uneBDD;
		try{
			
			// connexion au serveur et � la bdd 
			this.uneConnexion = DriverManager.getConnection(url,this.unUser, this.unMdp); 
		}	
		catch(SQLException exp)
		{
			System.out.println("Connexion impossible au "+url);
		}
	}
	public void seDeconnecter ()
	{
		if (this.uneConnexion!= null)
		{
			try{
				this.uneConnexion.close();
			}
			catch (SQLException exp)
			{
				System.out.println("Erreur de fermeture de la connexion !");
			}
		}
	}
	public Connection getMaConnection ()
	{
		return this.uneConnexion;
	}
	
	
}
