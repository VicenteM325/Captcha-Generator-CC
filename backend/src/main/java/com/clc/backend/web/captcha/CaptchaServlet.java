package com.clc.backend.web.captcha;

import com.clc.backend.datos.CaptchaDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import com.clc.backend.model.Captcha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author vicente
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    private final String INIT_LINK = "http://localhost:8080/Captcha-Generator-CC/captchas/";
    private CaptchaDAO captchaDAO = new CaptchaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        List<Captcha> captchas = (List<Captcha>) captchaDAO.getObject();

        switch (accion) {
            case "listar" -> {
                request.setAttribute("captchas", captchas);
                request.getRequestDispatcher("listadoCaptchas.jsp").forward(request, response);
            }
            case "redirect" -> {
                String id = request.getParameter("id");
                for (Captcha c : captchas) {
                    if (c.getId().equals(id)) {
                        int usos = Integer.parseInt(c.getUse()) + 1;
                        c.setUse(String.valueOf(usos));
                        c.setLastDate(LocalDate.now().toString());
                        captchaDAO.create(captchas);
                        response.sendRedirect(INIT_LINK + id + ".html");
                    }
                }
            }
            case "hits" -> {
                String id = request.getParameter("id");
                String link = request.getParameter("link");
                for (Captcha c : captchas) {
                    if (c.getId().equals(id)) {
                        int hits = Integer.parseInt(c.getHits()) + 1;
                        c.setHits(String.valueOf(hits));
                        captchaDAO.create(captchas);
                        response.sendRedirect(link);
                    }
                }
            }
            case "faults" -> {
                String id = request.getParameter("id");
                for (Captcha c : captchas) {
                    if (c.getId().equals(id)) {
                        int faults = Integer.parseInt(c.getFaults()) + 1;
                        c.setFaults(String.valueOf(faults));
                        captchaDAO.create(captchas);
                        response.sendRedirect("index.jsp");
                    }
                }
            }
            case "use" -> {
                request.setAttribute("captchas", captchas);
                request.getRequestDispatcher("utilizacionCaptchas.jsp").forward(request, response);
            }
        }
    }
}
