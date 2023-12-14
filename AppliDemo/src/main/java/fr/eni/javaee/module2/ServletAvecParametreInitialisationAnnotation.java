²package fr.eni.javaee.module2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletAvecParametreInitialisationAnnotation
 */
@WebServlet(
		urlPatterns = "/modules/module2/ServletAvecParametreInitialisationAnnotation",
		initParams = 
		{
				@WebInitParam(
						description = "Un autre paramètre d'initialisation",
						name = "NOM_DU_PARAMETRE",
						value = "VALEUR_DU_PARAMETRE"
						)
		}
		)
public class ServletAvecParametreInitialisationAnnotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String valeurDuParametre;

	@Override
	public void init() throws ServletException {
		this.valeurDuParametre = this.getInitParameter("NOM_DU_PARAMETRE");
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("NOM_PARAMETRE =  ").append(this.valeurDuParametre);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
