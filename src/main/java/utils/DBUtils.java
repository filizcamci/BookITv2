package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	public static Connection connection;
	public String username, password;

	public void startDBConnection() {
		String URL = ConfigurationReader.getProperty("dburl" + ConfigurationReader.getProperty("environment"));
//		username = ConfigurationReader.getProperty("dbusername") + ConfigurationReader.getProperty("environment");
//		password = ConfigurationReader.getProperty("dbpassword") + ConfigurationReader.getProperty("environment");
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void stopDBConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String executeQuery(String query) {
		Statement statement;
		Object result = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				result = resultSet.getObject(1);
				result = String.valueOf(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (String) result;
	}

	public void executeDeleteUpdateInsertDBCommand(String query) {

		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<String> executeDBCommandForList(String query) {
		List<String> outputList = new ArrayList<String>();
		Statement statement;
		Object result = null;
		String output;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				result = resultSet.getObject(1);
				output = String.valueOf(result);
				outputList.add(output);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outputList;
	}
}
