package com.bookhaus.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AdvSearchTest {

	@Test
	public void AdvSerTest() {
		//fail("Not yet implemented");
		
		SearchDAO search = new SearchDAO();
		
		Map<String, String[]> queryMap = new HashMap<String, String[]>();
		String [] val = {"1000jiu90"};
		String [] firstval = {"Book"};
		queryMap.put("category", firstval);
		queryMap.put("isbn",val);
		assertEquals(0, search.doAdvanceSearch(queryMap).size());
		
	}

}
