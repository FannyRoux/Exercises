package fr.eni.RechercherNombre;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTraitementProposition
 */
@WebServlet(
				name = "ServletNombreMystere",
				urlPatterns="/nombre-mystere",
				initParams =
				{
						@WebInitParam(
						description="paramétrage de la borne min pour généraer le nombre",
						name="paramBorneMinRandom",
						value="0"
					),
						
						@WebInitParam(
								description="paramétrage de la borne max pour généraer le nombre",
								name="paramBorneMaxRandom",
								value="10"
							)
				}
			)
public class ServletNombreMystere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int nombreMystere;

	@Override
	public void init() throws ServletException {
		int borneMin = Integer.valueOf(getInitParameter("paramBorneMinRandom"));
		int borneMax = Integer.valueOf(getInitParameter("paramBorneMaxRandom"));
		nombreMystere = ThreadLocalRandom.current().nextInt(borneMin, borneMax + 1);
		System.out.println("nombre mystère : " + nombreMystere);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reponseUtilisateur = Integer.valueOf(request.getParameter("champ_saisie"));
		System.out.println("réponse du joueur : " + request.getParameter("champ_saisie"));
		if (nombreMystere != reponseUtilisateur) {
			response.sendRedirect("Echec.html");
		} else {
			init();
			response.sendRedirect("Victoire.html");
		}
	}
}
