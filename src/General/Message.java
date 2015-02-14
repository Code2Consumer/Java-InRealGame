package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Message {
	public int  id;
	public String mess;
	
	Message(int id, String mess){
		this.id=id;
		this.mess=mess;
	}

}
