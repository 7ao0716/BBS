package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MutterSaveLogic;

@WebServlet("/MutterServlet")
public class MutterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String comment = request.getParameter("comment");
		HttpSession session = request.getSession();
		String title = (String) session.getAttribute("title");
		String userId = (String) session.getAttribute("userId");

		MutterSaveLogic bo = new MutterSaveLogic();
		boolean result = bo.execute(title, comment, userId);

		if(result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/thread.jsp");
			dispatcher.forward(request, response);
		}
		else {

		}
	}
}
