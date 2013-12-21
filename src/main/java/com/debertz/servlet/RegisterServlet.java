package com.debertz.servlet;

import com.debertz.authorization.Authorization;
import com.debertz.status.Status;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sholtun on 21.12.13.
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(AttributeNames.NAME_PARAM);
        String password = req.getParameter(AttributeNames.PASSWORD_PARAM);
        Status.Authorization registrationResult = Authorization.register(name, password);
        if (Status.Authorization.OK != registrationResult){
            req.setAttribute(AttributeNames.STATUS_PARAM, registrationResult);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("/registrationSuccessful.jsp");
    }
}
