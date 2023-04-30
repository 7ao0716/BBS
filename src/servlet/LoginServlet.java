package servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TitleDAO;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginJUDGE.jsp");
		dispatcher.forward(request, response);*/
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("サーチ.txt")));
		pw.close();
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		Login login = new Login(userId, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);

		if(request.getParameter("userId")==null) {
			TitleDAO dao = new TitleDAO();
			boolean rs = dao.TitleIntoFile();
			if(rs) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginJUDGE.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {

			//ifログインの時
			if(result) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				//データベースから.txtファイル

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginJUDGE.jsp");
				dispatcher.forward(request, response);
			}
			else {
				int caution1 = 2;
				HttpSession session = request.getSession();
				session.setAttribute("caution1", caution1);
				response.sendRedirect("/3ch/LoginServlet");
			}
		}
		//ifスレッド作成から戻ってきたときint=1などを代入しておく
	}

}
