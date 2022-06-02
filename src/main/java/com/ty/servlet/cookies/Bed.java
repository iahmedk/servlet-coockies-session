package com.ty.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/bed")
public class Bed extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		PrintWriter printWriter = resp.getWriter();

		if (cookies != null) {
			String name = cookies[0].getValue();
			String password = cookies[1].getValue();

			if (name.equals("imtiyaz1787@gmail.com") && password.equals("Imtiyaz@123")) {
				printWriter.write("<html><body><h1>" + name + " is authorised to the Bed" + "</h1></body></html>");
			} else {
				printWriter.write("<html><body><h1>Not Authorised to the Bed</h1></body></html>");
			}
		} else {
			printWriter.write("<html><body><h1>Not Authorised to the Bed</h1></body></html>");
		}
	}
}
