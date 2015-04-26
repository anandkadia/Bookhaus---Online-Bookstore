package com.bookhaus.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class NavigateTest {

	@Test
	public void testDoNavSearch() {
		//fail("Not yet implemented");
		//SearchDAO nav = new SearchDAO();
		SearchDAO search = new SearchDAO();
		
		String category = "fun"; 
		String genre = "fun";
				assertEquals(0, search.doNavSearch(category,genre).size());
		
		
		
	}

}
