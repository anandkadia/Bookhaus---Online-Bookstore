package com.bookhaus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookhaus.model.StoreModel;
import com.bookhaus.utils.DBManager;

public class StoreDAO {

	public List<StoreModel> getStoreList (){
	
		Connection conn = DBManager.getConnection();
		
		List<StoreModel> storeList = new ArrayList<StoreModel>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM stores");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				StoreModel store = new StoreModel(rs.getInt("ID"), rs.getString("STORE_NAME"), rs.getString("ADDRESS"),rs.getString("CITY"),rs.getString("ZIP"),rs.getString("STATE"),rs.getString("PHONE"), rs.getString("EMAIL"),rs.getString("HOURS"),rs.getString("LATITUDE"),rs.getString("LONGITUDE"));;
				storeList.add(store);
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			System.err.println("Error. " + e.getMessage());
		}
		finally {
			DBManager.cleanup(ps, rs, conn);
		}
		return storeList;
	}
}
