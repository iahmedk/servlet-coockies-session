package com.ty.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/fblogin")
public class FacebookLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("userEmail");
		String pwd = req.getParameter("userPwd");

		if (name.equals("imtiyaz1787@gmail.com") && pwd.equals("Imtiyaz@123")) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("myusername", name);

			RequestDispatcher dispatcher = req.getRequestDispatcher("fbwelcome.html");
			dispatcher.forward(req, resp);
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Either mail or password is wrong</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}

	}
}
