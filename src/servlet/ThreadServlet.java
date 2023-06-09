package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TitleCreateLogic;

@WebServlet("/ThreadServlet")
public class ThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/thread.jsp");
		dispatcher.forward(request, response);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");

		Thread thread = new Thread(title);

		TitleCreateLogic bo = new TitleCreateLogic();
		boolean result = bo.execute(thread);

		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("title", title);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/thread.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("/3ch/ThreadServlet");
		}
	}

}
