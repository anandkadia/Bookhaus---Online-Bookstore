package com.bookhaus.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductDetailTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		ProductDAO product = new ProductDAO();
		
		String id = "1"; 
		String category = "sports";
				assertEquals(null, product.getProductDetails(id, category));
	}

}
