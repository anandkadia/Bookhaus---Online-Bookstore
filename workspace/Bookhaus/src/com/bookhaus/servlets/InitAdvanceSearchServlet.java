package com.bookhaus.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookhaus.dao.InitDAO;

/**
 * Servlet implementation class InitAdvanceSearchServlet
 */
@WebServlet("/InitAdvanceSearch")
public class InitAdvanceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitAdvanceSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InitDAO dao = new InitDAO();
		
		request.setAttribute("authorList", dao.getAuthorList());
		request.setAttribute("artistList", dao.getArtistList());
		request.setAttribute("publisherList", dao.getPublisherList());
		
		request.getRequestDispatcher("advanceSearch.jsp").forward(request, response);
	}

}
