package com.bookhaus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookhaus.model.ProductDetailModel;
import com.bookhaus.model.StoreModel;
import com.bookhaus.utils.DBManager;

public class ProductDAO {

	public ProductDetailModel getProductDetails(String id, String category)
	{
		ProductDetailModel product = null;
		int productId = -1;
		
		try {
			productId = Integer.parseInt(id);
		}
		catch(NumberFormatException nfe)
		{
		}
		
		if(productId != -1 && (category.equals("Books") || category.equals("Music") || category.equals("Accessories") || category.equals("Office Supplies")))
		{
			Connection conn = DBManager.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				if(category.equals("Books"))
				{
					ps = conn.prepareStatement("SELECT * FROM bookhaus_db.books where ID=?");
					ps.setInt(1, productId);
					
					rs = ps.executeQuery();
					if(rs.next())
					{
						product = new ProductDetailModel();
						product.setId(rs.getInt("ID"));
						product.setIsbn(rs.getString("ISBN"));
						product.setTitle(rs.getString("TITLE"));
						product.setAuthor(rs.getString("AUTHOR"));
						product.setPrice(rs.getDouble("PRICE"));
						product.setPublishedDate(rs.getDate("PUBLISHED_DATE"));
						product.setPublisher(rs.getString("PUBLISHER"));
						product.setImagePath(rs.getString("IMAGE_PATH"));
						product.setGenre(rs.getString("GENRE"));
						product.setDescription(rs.getString("DESCRIPTION"));
						product.setCategory(category);
					}
				}
				else if(category.equals("Music"))
				{
					ps = conn.prepareStatement("SELECT * FROM bookhaus_db.music where ID=?");
					ps.setInt(1, productId);
					
					rs = ps.executeQuery();
					if(rs.next())
					{
						product = new ProductDetailModel();
						product.setId(rs.getInt("ID"));
						product.setTitle(rs.getString("ALBUM_TITLE"));
						product.setArtist(rs.getString("ARTIST"));
						product.setPrice(rs.getDouble("PRICE"));
						product.setYear(rs.getInt("YEAR"));
						product.setImagePath(rs.getString("IMAGE_PATH"));
						product.setGenre(rs.getString("GENRE"));
						product.setDescription(rs.getString("DESCRIPTION"));
						product.setCategory(category);
					}
				}
				else if(category.equals("Office Supplies"))
				{
					ps = conn.prepareStatement("SELECT * FROM bookhaus_db.office_supplies where ID=?");
					ps.setInt(1, productId);
					
					rs = ps.executeQuery();
					if(rs.next())
					{
						product = new ProductDetailModel();
						product.setId(rs.getInt("ID"));
						product.setTitle(rs.getString("ITEM_NAME"));
						product.setPrice(rs.getDouble("PRICE"));
						product.setImagePath(rs.getString("IMAGE_PATH"));
						product.setDescription(rs.getString("DESCRIPTION"));
						product.setCategory(category);
					}
				}
				else if(category.equals("Accessories"))
				{
					ps = conn.prepareStatement("SELECT * FROM bookhaus_db.accessories where ID=?");
					ps.setInt(1, productId);
					
					rs = ps.executeQuery();
					if(rs.next())
					{
						product = new ProductDetailModel();
						product.setId(rs.getInt("ID"));
						product.setTitle(rs.getString("NAME"));
						product.setPrice(rs.getDouble("PRICE"));
						product.setImagePath(rs.getString("IMAGE_PATH"));
						product.setDescription(rs.getString("DESCRIPTION"));
						product.setCategory(category);
					}
				}
				
				if(product != null && product.getId() != 0)
				{
					DBManager.cleanup(ps, rs, null);
					List<StoreModel> storeList = new ArrayList<StoreModel>();
					
					ps = conn.prepareStatement("SELECT i.STORE_ID, i.QUANTITY, s.STORE_NAME, s.CITY, s.STATE FROM bookhaus_db.inventory i, bookhaus_db.stores s where i.ITEM_ID=? AND i.ITEM_TYPE = ? AND i.STORE_ID = s.ID");
					ps.setInt(1, product.getId());
					ps.setString(2, product.getCategory());
					
					rs = ps.executeQuery();
					while (rs.next())
					{
						StoreModel store = new StoreModel();
						store.setStoreId(rs.getInt("STORE_ID"));
						store.setStoreName(rs.getString("STORE_NAME"));
						store.setCity(rs.getString("CITY"));
						store.setState(rs.getString("STATE"));
						store.setQuantity(rs.getInt("QUANTITY"));
						storeList.add(store);
					}
					product.setStoreAvailability(storeList);
				}
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
				System.err.println("Error. " + e.getMessage());
			}
			finally {
				DBManager.cleanup(ps, rs, conn);
			}
		}
		
		return product;
	}
}
