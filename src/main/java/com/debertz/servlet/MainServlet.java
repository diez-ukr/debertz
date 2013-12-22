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
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Authorization.validateSid(req.getSession().getAttribute(AttributeNames.NAME_PARAM),
                req.getSession().getAttribute(AttributeNames.SID_PARAM))) {
            resp.sendRedirect("/");
            return;
        }
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
