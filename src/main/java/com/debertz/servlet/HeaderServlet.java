package com.debertz.servlet;

import com.debertz.authorization.Authorization;
import com.debertz.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Sholtun on 21.12.13.
 */
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(AttributeNames.USER_PARAM);
        if (user != null &&
                Authorization.validateSid(user.getName(),
                session.getAttribute(AttributeNames.SID_PARAM))) {
            req.setAttribute(AttributeNames.NAME_PARAM, user.getName());
            getServletContext().getRequestDispatcher("/templates/headerAuthorized.jsp").include(req, resp);
            return;
        }
        getServletContext().getRequestDispatcher("/templates/headerNotAuthorized.jsp").include(req, resp);
    }
}
