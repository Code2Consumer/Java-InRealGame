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
	}
	
	public void chargerPilote () 
	{
		try
		{
			//verification de la présence du pilote jdbc, mysql
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
			// connexion au serveur et à la bdd 
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
