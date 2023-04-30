package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Registration;
import model.RegistrationLogic;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		Registration registration = new Registration(userId, pass);

		RegistrationLogic bo = new RegistrationLogic();
		boolean result = bo.execute(registration);

		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrationJUDGE.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("/3ch/RegistrationServlet");
		}
	}

}

