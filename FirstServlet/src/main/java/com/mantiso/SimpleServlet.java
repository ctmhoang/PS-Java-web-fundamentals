package com.mantiso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SimpleServlet", urlPatterns = {"/home", "*.pro"})
public class SimpleServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        if (name != null)
        {
            response.setContentType("text/xml"); // html is default
            response.getWriter().printf("<name>Hello %s</name>", name);
        }
        else
            response.getWriter().write("Please enter a name value");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
    String name = request.getParameter("name"); // if not enter value from form => value is passed back in as an empty string
    if (name != null && !name.isEmpty())
        response.getWriter().printf("Hello %s", name);
    else
        response.sendRedirect("index.jsp");
}
}
