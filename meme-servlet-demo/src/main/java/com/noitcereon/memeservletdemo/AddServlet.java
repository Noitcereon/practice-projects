package com.noitcereon.memeservletdemo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int number1 = Integer.parseInt(request.getParameter("numberInput1"));
        int number2 = Integer.parseInt(request.getParameter("numberInput2"));

        int result = number1 + number2;

        PrintWriter writer = response.getWriter();
        writer.println("<h1>Result of servlet add: " + result + "</h1>");
    }
}
