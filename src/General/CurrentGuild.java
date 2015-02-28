package General;

public class CurrentGuild {
	static private int id, GM_id;
	static private String Guild_name, GM, CoGM, MMO_Principale, Serveur;
	
	public static void setCurrentGuild(guild guild){
		CurrentGuild.setId( guild.getId() );
		CurrentGuild.setGM_id( guild.getGM_id() );
		CurrentGuild.setGuild_name( guild.getGuild_name() );
		CurrentGuild.setGM( guild.getGM() );
		CurrentGuild.setCoGM( guild.getCoGM() );
		CurrentGuild.setMMO_Principale( guild.getMMO_Principale() );
		CurrentGuild.setServeur( guild.getServeur() );
	}
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		CurrentGuild.id = id;
	}
	public static int getGM_id() {
		return GM_id;
	}
	public static void setGM_id(int gM_id) {
		GM_id = gM_id;
	}
	public static String getGuild_name() {
		return Guild_name;
	}
	public static void setGuild_name(String guild_name) {
		Guild_name = guild_name;
	}
	public static String getGM() {
		return GM;
	}
	public static void setGM(String gM) {
		GM = gM;
	}
	public static String getCoGM() {
		return CoGM;
	}
	public static void setCoGM(String coGM) {
		CoGM = coGM;
	}
	public static String getMMO_Principale() {
		return MMO_Principale;
	}
	public static void setMMO_Principale(String mMO_Principale) {
		MMO_Principale = mMO_Principale;
	}
	public static String getServeur() {
		return Serveur;
	}
	public static void setServeur(String serveur) {
		Serveur = serveur;
	}
	

}
