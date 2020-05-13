package com.PM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.PM.Student;

public class StudentDao {

	public int registerStudent(Student student) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO student"
				+ "  (id, first_name, last_name, username, password, email, contact) VALUES " + " (id, ?, ?, ?, ?,?,?);";

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/students?useSSL=false",
				"root", "8520");

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
		
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getUsername());
			preparedStatement.setString(4, student.getPassword());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getContact());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}