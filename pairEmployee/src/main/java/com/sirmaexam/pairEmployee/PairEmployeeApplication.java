package com.sirmaexam.pairEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class PairEmployeeApplication {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "7005038450");
			statement = connection.createStatement();
			statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname = 'employeepair'");

			ResultSet resultSet = statement.getResultSet();
			resultSet.next();
			int count = resultSet.getInt(1);

			if (count <= 0) {
				statement.executeUpdate("CREATE DATABASE if not exists employeepair");
				statement.executeQuery("CREATE TABLE test (id SERIAL PRIMARY KEY name VARCHAR(255) NOT NULL);");
			}

		} catch (SQLException e) {
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
		SpringApplication.run(PairEmployeeApplication.class, args);
	}

}
