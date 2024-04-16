package com.emergentes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "view";
        switch (action) {
            case "view":
                response.sendRedirect("index.jsp");
                break;
            case "nuevo":
                inscripcion ins = new inscripcion();
                request.setAttribute("inscripcion", ins);
                request.getRequestDispatcher("editar.jsp").forward(request, response);

                break;
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                HttpSession sesion = request.getSession();
                List<inscripcion> lista = (ArrayList<inscripcion>) sesion.getAttribute("lista");
                inscripcion editins = new inscripcion();
                for (inscripcion item : lista) {
                    if (item.getId() == idEditar) {
                        editins = item;
                        break;
                    }
                }
                request.setAttribute("inscripcion", editins);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                 HttpSession sesion1 = request.getSession();
                List<inscripcion> lista1 = (ArrayList<inscripcion>) sesion1.getAttribute("lista");
                
                for(inscripcion item:lista1){
                    System.out.println(item.toString());
                    if(item.getId()==idEliminar){
                        lista1.remove(item);
                        break;
                    }
                }
                response.sendRedirect("index.jsp");
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String turno = request.getParameter("turno");
        String seminarios = request.getParameter("seminarios");

        HttpSession ses = request.getSession();
        List<inscripcion> lista = (ArrayList<inscripcion>) ses.getAttribute("lista");
        if (id == 0) {
            inscripcion ins = new inscripcion();
            int idNuevo = obtenerNuevoId(lista);
            ins.setId(idNuevo);
            ins.setFecha(fecha);
            ins.setNombres(nombres);
            ins.setApellidos(apellidos);
            ins.setTurno(turno);
            ins.setSeminarios(seminarios);

            lista.add(ins);
        }else{
            for(inscripcion item : lista){
                if(item.getId() ==id){
                    item.setFecha(fecha);
                    item.setNombres(nombres);
                    item.setApellidos(apellidos);
                    item.setTurno(turno);
                    item.setSeminarios(seminarios);
                    break;
                }
            }
        }
        response.sendRedirect("index.jsp");
    }

    private int obtenerNuevoId(List<inscripcion> lista) {
        int nuevoId = 1;
        for (inscripcion item : lista) {
            if (item.getId() >= nuevoId) {
                nuevoId = item.getId() + 1;
            }
        }
        return nuevoId;
    }

}
