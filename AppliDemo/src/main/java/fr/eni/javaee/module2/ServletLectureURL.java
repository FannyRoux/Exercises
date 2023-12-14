package fr.eni.javaee.module2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletLectureURL
 */
@WebServlet("/modules/module2/ServletLectureURL")
public class ServletLectureURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String protocole = request.getScheme();
		String nomServeur = request.getServerName();
		int port = request.getServerPort();
		String nomApplication = request.getContextPath();
		String cheminRessource = request.getServletPath();
		
		String reponse = String.format("Protocole : %s%nNom serveur : %s%nPort : %d%nNom application : %s%nChemin ressource : %s%n ",
				protocole, nomServeur,port, nomApplication, cheminRessource);
	
		response.getWriter().append(reponse);

	}
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
