package General;

import java.sql.Date;

public class message {
	private int id, _id_env, id_dest;
	private String name_env, name_dest, titre, message;
	private Date date;
	boolean vue;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int get_id_env() {
		return _id_env;
	}
	public void set_id_env(int _id_env) {
		this._id_env = _id_env;
	}
	public int getId_dest() {
		return id_dest;
	}
	public void setId_dest(int id_dest) {
		this.id_dest = id_dest;
	}
	public String getName_env() {
		return name_env;
	}
	public void setName_env(String name_env) {
		this.name_env = name_env;
	}
	public String getName_dest() {
		return name_dest;
	}
	public void setName_dest(String name_dest) {
		this.name_dest = name_dest;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isVue() {
		return vue;
	}
	public void setVue(boolean vue) {
		this.vue = vue;
	}
	
	
}
