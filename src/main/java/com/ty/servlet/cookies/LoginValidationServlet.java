package com.ty.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/login")
public class LoginValidationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("userEmail");
		String pwd = req.getParameter("userPwd");

		if (name.equals("imtiyaz1787@gmail.com") && pwd.equals("Imtiyaz@123")) {
			Cookie cookie1 = new Cookie("name", name);
			Cookie cookie2 = new Cookie("password", pwd);
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.html");
			dispatcher.forward(req, resp);
		}
		else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Either mail or password is wrong</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
	}
}
