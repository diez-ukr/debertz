package com.debertz.servlet;

import com.debertz.authorization.Authorization;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sholtun on 21.12.13.
 */
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Authorization.validateSid(req.getSession().getAttribute(AttributeNames.NAME_PARAM),
                req.getSession().getAttribute(AttributeNames.SID_PARAM))) {
            getServletContext().getRequestDispatcher("/templates/headerAuthorized.jsp").include(req, resp);
            return;
        }
        getServletContext().getRequestDispatcher("/templates/headerNotAuthorized.jsp").include(req, resp);
    }
}
