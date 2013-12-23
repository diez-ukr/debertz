package com.debertz.servlet;

import com.debertz.authorization.Authorization;
import com.debertz.authorization.AuthorizationException;
import com.debertz.dao.Users;
import com.debertz.status.Status;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Sholtun on 21.12.13.
 */
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("sid") != null)
        {
            session.removeAttribute("sid");
            session.removeAttribute("login");
            resp.sendRedirect("/");
            return;
        }
        String name = req.getParameter(AttributeNames.NAME_PARAM);
        String password = req.getParameter(AttributeNames.PASSWORD_PARAM);
        String sid = "";
        try {
            if((sid = Authorization.authorize(name, password)).isEmpty())
            {
                req.setAttribute(AttributeNames.STATUS_PARAM, Status.Authorization.WrongCredentials);
                resp.sendRedirect("/");
            }
        } catch (AuthorizationException ex) {
            req.setAttribute(AttributeNames.STATUS_PARAM, Status.Authorization.WrongCredentials);
            resp.sendRedirect("/");
            return;
        }
        session.setAttribute(AttributeNames.SID_PARAM, sid);
        session.setAttribute(AttributeNames.USER_PARAM, Users.getUser(name));
        resp.sendRedirect("/main");
    }
}
