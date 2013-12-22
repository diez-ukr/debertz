package com.debertz.servlet;

import com.debertz.authorization.Authorization;
import com.debertz.authorization.AuthorizationException;
import com.debertz.status.Status;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sholtun on 21.12.13.
 */
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(AttributeNames.NAME_PARAM);
        String password = req.getParameter(AttributeNames.PASSWORD_PARAM);
        String sid = "";
        try {
            sid = Authorization.authorize(name, password);
        } catch (AuthorizationException ex) {
            req.setAttribute(AttributeNames.STATUS_PARAM, Status.Authorization.WrongCredentials);
            resp.sendRedirect("/");
            return;
        }
        req.getSession().setAttribute(AttributeNames.SID_PARAM, sid);
        req.getSession().setAttribute(AttributeNames.NAME_PARAM, name);
        resp.sendRedirect("/main");
    }
}
