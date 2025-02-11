package com.mantiso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kevinj.
 */
public class ControllerServlet extends HttpServlet
{

    @Override
    public void init() throws ServletException
    {
        ApplicationSettings applicationSettings = new ApplicationSettings();
        CssClass cssClass = new CssClass();
        cssClass.setName("redUser");
        List<Tab> tabs = new ArrayList<>(Arrays.asList(
                new Tab("SignIn", "#signin"),
                new Tab("Home", "#home"),
                new Tab("Profile", "#profile"),
                new Tab("Messages", "#messages"),
                new Tab("Settings", "settings")));
        applicationSettings.setTabs(tabs);
        String[] tabNames = {"SignIn", "Home", "Profile", "Settings"};
        applicationSettings.setTabNames(tabNames);
        applicationSettings.setFormCssClass(cssClass);
        getServletContext().setAttribute("app", applicationSettings);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = new User();
        user.setName("Kevin");
        user.setEmail("kevinj@mantiso.com");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }
}
