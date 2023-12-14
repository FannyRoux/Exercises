package fr.eni.javaee.module2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEcrivantCorpsEsthetique
 */
@WebServlet("/modules/module2/ServletEcrivantCorpsEsthetique")
public class ServletEcrivantCorpsEsthetique extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		try
		{
			out.print("html");
			out.print("<head><title>Une belle réponse !</title></head>");
			out.print("<body>");
			out.print("<h1>Une réponse esthétique</h1>");
			out.flush();

			Thread.sleep(1000);
			
			out.print("<h2>Un sous-titre</h2>");
			out.flush();
			
			Thread.sleep(1000);
			
			out.print("<p>Un paragraphe...</p>");
			out.flush();
			
			Thread.sleep(1000);
			
			out.print("</body>");
			out.print("</html>");
			out.close();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
