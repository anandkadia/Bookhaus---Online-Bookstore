package com.bookhaus.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchDAOTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		SearchDAO search = new SearchDAO();
		String str = search.getCleanToken("java is the book");
		System.out.println(str);
		
		String expectedOutput = " java book*".toString(); 
		assertEquals(expectedOutput, str.toString());
		
		
	}

}
