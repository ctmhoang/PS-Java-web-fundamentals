package com.mantiso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(
        name = "SimpleServlet", // provide a name or web.xml trying to mapping this servlet and an internal name provide by this servlet will conflict with each other (class path)
        urlPatterns = {"/home", "*.pro"}, //web.xml also rewrite it. It is not gonna union 2 list of pattern
        initParams = @WebInitParam(name = "ProductName", value = "Welcome application") // will be overwrite if web.xml specified
)
public class SimpleServlet extends HttpServlet
{
    String appName = "My Application";
    String connstr;


    @Override
    public void init() throws ServletException
    {
        appName = getServletContext().getInitParameter("ProductName");
        connstr = getInitParameter("connstr");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        if (name != null)
        {
            response.setContentType("text/xml"); // html is default
            response.getWriter().printf("<application>" +
                    "<name>Hello %s</name>" +
                    "<product>%s</product>" +
                    "<connstr>%s</connstr>" +
                    "</application>", name, appName, connstr);
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
