package com.bookhaus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookhaus.utils.DBManager;

public class InitDAO {

	public List<String> getAuthorList (){
		
		Connection conn = DBManager.getConnection();
		
		List<String> authorList = new ArrayList<String>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT DISTINCT AUTHOR FROM bookhaus_db.books ORDER BY AUTHOR ASC");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				String items[] = rs.getString("AUTHOR").split(",");
				for(String it : items)
				{
					authorList.add(it.trim());
				}
				
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			System.err.println("Error. " + e.getMessage());
		}
		finally {
			DBManager.cleanup(ps, rs, conn);
		}
		return authorList;
	}
	
	
	public List<String> getPublisherList (){
		
		Connection conn = DBManager.getConnection();
		
		List<String> publisherList = new ArrayList<String>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT DISTINCT PUBLISHER FROM bookhaus_db.books ORDER BY PUBLISHER ASC");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				String items[] = rs.getString("PUBLISHER").split(",");
				for(String it : items)
				{
					publisherList.add(it.trim());
				}
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			System.err.println("Error. " + e.getMessage());
		}
		finally {
			DBManager.cleanup(ps, rs, conn);
		}
		return publisherList;
	}
	
	public List<String> getArtistList (){
		
		Connection conn = DBManager.getConnection();
		
		List<String> artistList = new ArrayList<String>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT DISTINCT ARTIST FROM bookhaus_db.music ORDER BY ARTIST ASC");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				String items[] = rs.getString("ARTIST").split(",");
				for(String it : items)
				{
					artistList.add(it.trim());
				}
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			System.err.println("Error. " + e.getMessage());
		}
		finally {
			DBManager.cleanup(ps, rs, conn);
		}
		return artistList;
	}
}
