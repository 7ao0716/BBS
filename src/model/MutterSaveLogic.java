package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.TitleDAO;

public class MutterSaveLogic {
	public boolean execute(String title, String comment, String userId) {
		int num = 0;
		TitleDAO dao = new TitleDAO();
		num = dao.CommentNumber(title);
		try {
			Date dateObj = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			File file = new File(title+".txt");
			FileWriter pw = new FileWriter(file, true);
			String display = format.format(dateObj);
			//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(title+".txt")));

			pw.write(num+"<span style=\"color:green;\">"+userId+":@"+display+"\n</span>");
			pw.write(comment+"\n");
			//pw.println(userId);
			//pw.println(comment);
			pw.close();
		}
		catch(IOException e){
			return false;
		}

		return true;
	}
}
