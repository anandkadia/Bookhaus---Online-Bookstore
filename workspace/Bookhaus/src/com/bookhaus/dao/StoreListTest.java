package com.bookhaus.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class StoreListTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		StoreDAO s = new StoreDAO();
		
		assertEquals(5, s.getStoreList().size());
	}

}
