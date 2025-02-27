package Controller_and;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.tiltDAO;
import Model.tiltVO;

@WebServlet("/al_all")
public class al_all extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
//		System.out.println("���");
		
		tiltDAO tdao = new tiltDAO();
		
		ArrayList<tiltVO> tal = tdao.al_all_info();	

		System.out.println(tal.get(0).getMac_code());
		System.out.println(tal.get(0).getTilt_date());
		
		Gson gson = new Gson();
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();

		out.print(gson.toJson(tal));
		
	}

}
