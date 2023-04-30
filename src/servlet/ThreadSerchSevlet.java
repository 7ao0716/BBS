package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TitleDAO;

/**
 * Servlet implementation class ThreadSerchSevlet
 */
@WebServlet("/ThreadSerchSevlet")
public class ThreadSerchSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadSerchSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		TitleDAO dao = new TitleDAO();
		boolean rs = dao.SerchTitle(title);
		if(rs) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginJUDGE.jsp");
			dispatcher.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
