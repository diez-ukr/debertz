package com.debertz.servlet;

import com.debertz.logic.Table;
import com.debertz.logic.TableParams;
import com.debertz.logic.TablePool;
import com.debertz.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sholtun on 22.12.13.
 */
public class NewTableServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userCurrent = (User)req.getSession().getAttribute(AttributeNames.USER_PARAM);
        String players = req.getParameter("players");
        String points = req.getParameter("points");
        Table tableNew = TablePool.add(new TableParams(Integer.parseInt(players),
                Integer.parseInt(points)),
                userCurrent);
        tableNew.join(userCurrent);
        req.getSession().setAttribute(AttributeNames.TABLE_PARAM, tableNew);
        resp.sendRedirect("/table");
    }
}
