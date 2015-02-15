package General;

import java.sql.Date;

public class candidature {
	private int id, Guild_Id, user_id;
	private String guild_name, user_name, message, message_titre, situation;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuild_Id() {
		return Guild_Id;
	}
	public void setGuild_Id(int guild_Id) {
		Guild_Id = guild_Id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getGuild_name() {
		return guild_name;
	}
	public void setGuild_name(String guild_name) {
		this.guild_name = guild_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage_titre() {
		return message_titre;
	}
	public void setMessage_titre(String message_titre) {
		this.message_titre = message_titre;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
