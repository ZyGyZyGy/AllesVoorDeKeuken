package be.vdab.servlets.artikels;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;

@WebServlet("/artikels/zoekenopnaam.htm")
public class ZoekenOpNaamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/artikels/zoekenopnaam.jsp";
    private final transient ArtikelService artikelService = new ArtikelService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	if (request.getQueryString() != null) {
	    String woord = request.getParameter("woord").trim();
	    if (!woord.isEmpty()) {
		request.setAttribute("artikels", artikelService.findByWoord(woord));
	    } else {
		request.setAttribute("fouten", Collections.singletonMap("artikelnaam", "tik een naam in"));
	    }
	}
	request.getRequestDispatcher(VIEW).forward(request, response);
    }

}
