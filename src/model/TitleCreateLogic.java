package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dao.TitleDAO;

/*public class TitleCreateLogic {
	public boolean execute(java.lang.Thread thread) {
		TitleDAO dao = new TitleDAO();
		boolean result = dao.registerTitle(thread);
		return result;
	}
}*/
public class TitleCreateLogic {
	public boolean execute(java.lang.Thread thread) {
		TitleDAO dao = new TitleDAO();
		boolean result = dao.registerTitle(thread);

		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(thread.getName()+".txt")));
			pw.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return result;
	}
}
