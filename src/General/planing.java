package General;

import java.sql.Date;

public class planing {
	private int id, guild_id, auteur_id;
	private String auteur_name, titre, infos;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuild_id() {
		return guild_id;
	}
	public void setGuild_id(int guild_id) {
		this.guild_id = guild_id;
	}
	public int getAuteur_id() {
		return auteur_id;
	}
	public void setAuteur_id(int auteur_id) {
		this.auteur_id = auteur_id;
	}
	public String getAuteur_name() {
		return auteur_name;
	}
	public void setAuteur_name(String auteur_name) {
		this.auteur_name = auteur_name;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
