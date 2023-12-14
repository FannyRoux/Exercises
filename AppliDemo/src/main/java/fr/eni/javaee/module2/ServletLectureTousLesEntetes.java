package fr.eni.javaee.module2;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLectureTousLesEntetes
 */
@WebServlet("/modules/module2/ServletLectureTousLesEntetes")
public class ServletLectureTousLesEntetes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAgent = response.getHeader("user-agent");
		
		Enumeration<String> listeEntetes = request.getHeaderNames();
		while(listeEntetes.hasMoreElements()) {
			String entete = listeEntetes.nextElement();
		}
		
		
		String entetes = String.format("User-Agent : %s%nLocale : %s%n",userAgent );
		
		response.getWriter().append(entetes);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
