package fr.eni.TPChifoumi;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletChifoumi
 */
@WebServlet("/chifoumi")
public class ServletChifoumi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String [] choixServer = {"Caillou", "Papier", "Ciseaux"};
	String coupServer = null;
	Random rand = new Random();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChifoumi() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int selectionCoupServer = rand.nextInt(choixServer.length);
    	coupServer = choixServer[selectionCoupServer];
    	System.out.println(coupServer);
		RequestDispatcher rdTentative = this.getServletContext().getNamedDispatcher("jspTentative");
		rdTentative.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String choixJoueur = request.getParameter("userChoice");
		String resultat = null;
		
		System.out.println(choixJoueur);
		
		switch (choixJoueur) {
		case "Ciseaux" : 
			if (coupServer.equals("Caillou")) {
				resultat = "Désolé, vous avez perdu !";
			}
			if (coupServer.equals("Papier")) {
				resultat = "Bravo, vous avez gagné !";
			}
			if (coupServer.equals("Ciseaux")) {
				resultat = "Egalité !";
			}
		break;
		case "Papier" : 
			if (coupServer.equals("Ciseaux")) {
				resultat = "Désolé, vous avez perdu !";
			}
			if (coupServer.equals("Caillou")) {
				resultat = "Bravo, vous avez gagné !";
			}
			if (coupServer.equals("Papier")) {
				resultat = "Egalité !";
			}
		break;
		case "Caillou" : 
			if (coupServer.equals("Papier")) {
				resultat = "Désolé, vous avez perdu !";
			}
			if (coupServer.equals("Ciseaux")) {
				resultat = "Bravo, vous avez gagné !";
			}
			if (coupServer.equals("Caillou")) {
				resultat = "Egalité !";
			}
		break;
		default : resultat = null;
		}
		request.setAttribute("résultat", resultat);
		System.out.println(resultat);
		
		RequestDispatcher rdResultat = this.getServletContext().getNamedDispatcher("jspResultat");
		rdResultat.forward(request, response);
	}

}
