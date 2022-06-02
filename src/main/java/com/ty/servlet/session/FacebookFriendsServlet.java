package com.ty.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/fbfriends")
public class FacebookFriendsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String email = (String) httpSession.getAttribute("myusername");
		PrintWriter printWriter = resp.getWriter();

		if (email != null) {
			printWriter.write("<html><body><h1>Welcome " + email + " to friends page" + "</h1></body></html>");
		} else {
			printWriter.write("<html><body><h1>Not an authorised person</h1></body></html>");
		}

	}
}
