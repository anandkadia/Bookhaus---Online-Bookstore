package com.bookhaus.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.bookhaus.dao.SearchDAO;
import com.bookhaus.model.SearchResultModel;

/**
 * Servlet implementation class BasicSearch
 */
@WebServlet("/BasicSearch")
public class BasicSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doSearch(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doSearch(request, response);
	}

	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String searchTokens = request.getParameter("searchTokens");
		
		SearchDAO dao = new SearchDAO();
		Set<SearchResultModel> resultSet = dao.doBasicSearch(searchTokens);
		
/*		ArrayList<JSONObject> result = new ArrayList<JSONObject>();
		
		for(SearchResultModel sr:resultSet)
		{
			JSONObject jobj = new JSONObject();
			try {
				jobj.put("id", sr.getId());
				jobj.put("title",sr.getTitle());
				jobj.put("price", sr.getPrice());
				jobj.put("imagePath", sr.getImagePath());
				jobj.put("category", sr.getCategory());
				jobj.put("score", sr.getScore());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result.add(jobj);
		}
		
		request.setAttribute("searchResults", result);*/
		
		request.setAttribute("searchResults", resultSet);
		request.setAttribute("searchType", "BASIC");
		
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}
	
}
