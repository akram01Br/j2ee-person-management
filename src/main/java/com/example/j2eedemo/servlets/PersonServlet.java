package com.example.j2eedemo.servlet;

import com.example.j2eedemo.dao.PersonDAO;
import com.example.j2eedemo.model.Person;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/persons")
public class PersonServlet extends HttpServlet {
    private PersonDAO dao;

    @Override
    public void init() {
        dao = new PersonDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> persons = dao.findAll();
        req.setAttribute("persons", persons);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        if (name != null && !name.isEmpty())
            dao.create(new Person(name, email));
        resp.sendRedirect(req.getContextPath() + "/persons");
    }
}
