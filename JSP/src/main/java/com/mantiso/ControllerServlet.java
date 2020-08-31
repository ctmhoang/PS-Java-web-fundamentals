package com.mantiso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = "*.do")
public class ControllerServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,
            IOException
    {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException
    {
        User user = new User();
        user.set_email("blah@blah.com");
        user.set_name("Cameron");

        RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
//        getServletContext().setAttribute(); global scope
//        request.getSession().setAttribute(); session scope
//        request.setAttribute(); request scope
        request.setAttribute("user", user);
        dispatcher.forward(request,response);
    }
}
