package com.bookhaus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bookhaus.model.SearchResultModel;
import com.bookhaus.utils.DBManager;

/**
 * Data Access Object for Search functionality
 */
public class SearchDAO {

	private final static String BASIC_SEARCH_PRIMARY=    "SELECT * FROM ("
												+" SELECT ID as id, TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Books' as category, MATCH(TITLE) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.books "
												+" UNION "
												+" SELECT ID as id, NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Accessories' as category, MATCH(NAME) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.accessories"
												+" UNION "
												+" SELECT ID as id, ALBUM_TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Music' as category, MATCH(ALBUM_TITLE) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.music"
												+" UNION "
												+" SELECT ID as id, ITEM_NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Office Supplies' as category, MATCH(ITEM_NAME) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.office_supplies"
												+" ) searchResults"
												+" WHERE SCORE>0"
												+" ORDER BY SCORE DESC";
			
    private final static String BASIC_SEARCH_SECONDARY=  "SELECT * FROM ("
									    		+" SELECT ID as id, TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Books' as category, MATCH(DESCRIPTION) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.books "
									    		+" UNION "
									    		+" SELECT ID as id, NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Accessories' as category, MATCH(DESCRIPTION) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.accessories"
									    		+" UNION "
									    		+" SELECT ID as id, ALBUM_TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Music' as category, MATCH(ARTIST) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.music"
									    		+" UNION "
									    		+" SELECT ID as id, ALBUM_TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Music' as category, MATCH(GENRE) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.music"
									    		+" UNION "
									    		+" SELECT ID as id, ITEM_NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Office Supplies' as category, MATCH(DESCRIPTION) AGAINST (? IN BOOLEAN MODE) AS SCORE FROM bookhaus_db.office_supplies"
									    		+" ) searchResults"
									    		+" WHERE SCORE>0"
									    		+" ORDER BY SCORE DESC";		
	
	private final static String NAV_SEARCH_BOOKS = "SELECT ID as id, TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Books' as category FROM bookhaus_db.books where GENRE LIKE ?";
	private final static String NAV_SEARCH_ACCESSORIES = "SELECT ID as id, NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Accessories' as category FROM bookhaus_db.accessories";
	private final static String NAV_SEARCH_MUSIC = "SELECT ID as id, ALBUM_TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Music' as category FROM bookhaus_db.music where GENRE LIKE ?";
	private final static String NAV_SEARCH_SUPPLIES = "SELECT ID as id, ITEM_NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Office Supplies' as category FROM bookhaus_db.office_supplies";

	
	private final static String ADV_SEARCH_BOOKS = "SELECT ID as id, TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Books' as category FROM bookhaus_db.books where";
	private final static String ADV_SEARCH_ACCESSORIES = "SELECT ID as id, NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Accessories' as category FROM bookhaus_db.accessories where";
	private final static  String ADV_SEARCH_MUSIC = "SELECT ID as id, ALBUM_TITLE as title, PRICE as price, IMAGE_PATH as imagePath, 'Music' as category FROM bookhaus_db.music where";
	private final static String ADV_SEARCH_SUPPLIES = "SELECT ID as id, ITEM_NAME as title, PRICE as price, IMAGE_PATH as imagePath, 'Office Supplies' as category FROM bookhaus_db.office_supplies where";

	
	private List<String> excludeList = null;
	
	public SearchDAO(){
		excludeList = Arrays.asList(new String[] {"and","is","the","a","am","an","are","as","be","by","can","did","didn't","do","does","doesn't","don't","for","i","i'd","i'll","i'm","i've","if","in","it","it's","its","may","me","of","or","so","than","that","that'll","that's","the","then","to"});
	}
	
	public String getCleanToken (String str)
	{
		String[] strTokens = str.split(" ");
		String rez= "";
		int count = 0;
		for(String s : strTokens)
		{
			if(!excludeList.contains(s))
			{
				rez = rez + " " + s;
				count++;
			}
		}
		
		if(count == 0)
		{
			return str;
		}
		else
		{
			return rez + "*";
		}
	}
	
	//doBasicSearch
	public Set<SearchResultModel> doBasicSearch (String searchTokens)
	{
		
		searchTokens = getCleanToken(searchTokens);
			
		Connection conn = DBManager.getConnection();
		
		//LinkedHashSet maintains insertion order.
		//Set takes care about unique elements
		Set<SearchResultModel> resultSet = new LinkedHashSet<SearchResultModel>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
			
		try {
			ps = conn.prepareStatement(SearchDAO.BASIC_SEARCH_PRIMARY);
			ps.setString(1, searchTokens);
			ps.setString(2, searchTokens);
			ps.setString(3, searchTokens);
			ps.setString(4, searchTokens);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				SearchResultModel result = new SearchResultModel(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"), rs.getString("imagePath"), rs.getString("category"));
				result.setScore(1);
				resultSet.add(result);
			}
			
			DBManager.cleanup(ps, rs, null);
			
			ps = conn.prepareStatement(SearchDAO.BASIC_SEARCH_SECONDARY);
			ps.setString(1, searchTokens);
			ps.setString(2, searchTokens);
			ps.setString(3, searchTokens);
			ps.setString(4, searchTokens);
			ps.setString(5, searchTokens);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				SearchResultModel result = new SearchResultModel(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"), rs.getString("imagePath"), rs.getString("category"));
				resultSet.add(result);
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			System.err.println("Error. " + e.getMessage());
		}
		finally {
			DBManager.cleanup(ps, rs, conn);
		}
		
		return resultSet;
	}
	
	
	public Set<SearchResultModel> doNavSearch (String category, String genre){
		
		Connection conn = DBManager.getConnection();
		
		//LinkedHashSet maintains insertion order.
		//Set takes care about unique elements
		Set<SearchResultModel> resultSet = new LinkedHashSet<SearchResultModel>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				if(category.equals("Books"))
				{
					ps = conn.prepareStatement(SearchDAO.NAV_SEARCH_BOOKS);
					ps.setString(1, genre);
				}
				else if(category.equals("Music"))
				{
					ps = conn.prepareStatement(SearchDAO.NAV_SEARCH_MUSIC);
					ps.setString(1, genre);
				}
				else if(category.equals("Office Supplies"))
				{
					ps = conn.prepareStatement(SearchDAO.NAV_SEARCH_SUPPLIES);
				}
				else if(category.equals("Accessories"))
				{
					ps = conn.prepareStatement(SearchDAO.NAV_SEARCH_ACCESSORIES);
				}
				
				if(ps != null)
				{
					rs = ps.executeQuery();
					
					while(rs.next())
					{
						SearchResultModel result = new SearchResultModel(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"), rs.getString("imagePath"), rs.getString("category"));
						resultSet.add(result);
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
		
		return resultSet;
	}
	
	//doAdvanceSearch
	public Set<SearchResultModel> doAdvanceSearch (Map<String, String[]> queryMap)
	{
		Connection conn = DBManager.getConnection();
		
		Set<SearchResultModel> resultSet = new LinkedHashSet<SearchResultModel>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String category = queryMap.get("category")[0];
		try {
			
			String query = null;
			if(category.equals("Books"))
			{
				query = getQuery(SearchDAO.ADV_SEARCH_BOOKS, queryMap);
			}
			else if(category.equals("Music"))
			{
				query = getQuery(SearchDAO.ADV_SEARCH_MUSIC, queryMap);
			}
			else if(category.equals("Office Supplies"))
			{
				query = getQuery(SearchDAO.ADV_SEARCH_SUPPLIES, queryMap);
			}
			else if(category.equals("Accessories"))
			{
				query = getQuery(SearchDAO.ADV_SEARCH_ACCESSORIES, queryMap);
			}
			
			if(query != null)
			{
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				
				while(rs.next())
				{
					SearchResultModel result = new SearchResultModel(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"), rs.getString("imagePath"), rs.getString("category"));
					resultSet.add(result);
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
		
		return resultSet;
	}
	
	private String getQuery (String q, Map<String, String[]> queryMap){
		String query = q;
		String[] keys = queryMap.keySet().toArray(new String[0]);
		int count = 0;
		for(int i=0; i<keys.length; i++ )
		{
			String key = keys[i];
			String value = queryMap.get(key)[0];
			if(!key.contains("sortBy") && !key.equals("category") && !key.equals("sortOrder") && value.length() > 0)
			{
				count++;
				if(count>1)
				{
					query += " AND";
				}
				
				if(key.equals("description"))
				{
					query += " MATCH (DESCRIPTION) AGAINST('" + value + "')";
				}
				else if(key.equals("isbn"))
				{
					query += " ISBN = '" + value + "'";
				}
				else if(key.equals("price"))
				{
					String prices[] = value.split("-");
					query += " PRICE >=" + prices[0] + " AND PRICE <" + prices[1];
				}
				else if(key.equals("year"))
				{
					String year[] = value.split("-");
					query += " YEAR >=" + year[0] + " AND YEAR <" + year[1];
				}
				else if(key.equals("published_date"))
				{
					String prices[] = value.split("_");
					query += " PUBLISHED_DATE BETWEEN '" + prices[0] + "' AND '" + prices[1] + "'";
				}
				else
				{
					query += " " + key.toUpperCase() + " LIKE '%" +  value + "%'";
				}
			}
		}
		
		String sortBy= queryMap.get("sortOrder")[0];
		if(!sortBy.equals(""))
		{
			query += " ORDER BY " + sortBy.toUpperCase();
		}
		System.out.println(query);
		return query;
	}
}
