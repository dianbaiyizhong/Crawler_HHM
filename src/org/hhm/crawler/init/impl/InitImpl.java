package org.hhm.crawler.init.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hhm.crawler.database.DBConnByMySql;
import org.hhm.crawler.pojo.Seeds;
import org.hhm.crawler.pojo.db.Taskinfo;
import org.hhm.crawler.util.template.AnalyzerConvert;

public class InitImpl {

	public List<Seeds> getGatherwebsite(int TaskID) {
		PreparedStatement stmt = null;
		Connection conn = DBConnByMySql.getConnection();
		String sql = "select * from gatherwebsite where  gatherwebsite.TaskID = "
				+ TaskID;

		AnalyzerConvert ac = new AnalyzerConvert();

		List<Seeds> list = new ArrayList<Seeds>();
		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Seeds seeds = new Seeds();
				seeds.setAuthor(ac.Convert_Author(rs.getString("Template")));
				seeds.setDirectDomain(rs.getString("DirectDomain"));
				seeds.setFilterSuffix(rs.getString("FilterDomain"));
				seeds.setId(rs.getString("SiteID"));
				seeds.setNow_depth(0);
				seeds.setPoint_depth(rs.getInt("CrawlerDepth"));
				seeds.setText(ac.Convert_Text(rs.getString("Template")));
				seeds.setTime(ac.Convert_Time(rs.getString("Template")));
				seeds.setTitle(ac.Convert_Title(rs.getString("Template")));
				seeds.setUrl(rs.getString("SiteEnterURL"));

				list.add(seeds);

			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return list;
		}

	}

	public void getTaskInfo(int taskid) {
		PreparedStatement stmt = null;
		Connection conn = DBConnByMySql.getConnection();
		String sql = "select * from taskinfo where  taskinfo.TaskID = "
				+ taskid;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Taskinfo.setGatherThread(rs.getInt("GatherThread"));

			}

		} catch (Exception e) {

		}
	}
}
