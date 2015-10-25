package com.liw.mybatis.demo.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JdbcDemo {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8";
			String username="root";
			String password="root";
			Class.forName(driver);
			connection=DriverManager.getConnection(url,username,password);
			
			String sql="select * from user where username = ?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, "liw");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getString("id")+" "+resultSet.getString("birthday"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
