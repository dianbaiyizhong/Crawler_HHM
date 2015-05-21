package org.hhm.crawler.analyzer.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hhm.crawler.database.DBConnByMySql;
import org.hhm.crawler.pojo.Content;

public class DataImpl {

	public void saveData(Content content) {
		PreparedStatement stmt = null;
		Connection conn = DBConnByMySql.getConnection();

		try {

			stmt = conn
					.prepareStatement("INSERT INTO content (`url`,`title`,`text`,`author`,`time`) VALUES (?,?,?,?,?)");
			stmt.setString(1, content.getUrl());
			stmt.setString(2, content.getTitle());
			stmt.setString(3, content.getText());
			stmt.setString(4, content.getAuthor());
			stmt.setString(5, content.getTime());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
