import java.sql.*;

public class Connection_demo {
	private Connection connection;
	private PreparedStatement statement;
	Connection_demo() throws ClassNotFoundException, SQLException{
			//STEP 1: registering driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//STEP 2: creating connection object
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Alliswell12!");
			//STEP 3: creating statement object			
			//STEP 4: executing query - each inside class that is making query string
			//STEP 5: close connection - each inside class that is making query string
	}
	
	
	public Connection getC() {
		return connection;
	}
	public PreparedStatement getS() {
		return statement;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public void setStatement(PreparedStatement statement) {
		this.statement = statement;
	}
	
	
	
}
