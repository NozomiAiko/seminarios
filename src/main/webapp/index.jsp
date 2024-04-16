<%@page import="java.lang.String"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.inscripcion"%>
<%
if(session.getAttribute("lista")==null){
    //solo la primerza vez se ejecuta
    ArrayList<inscripcion> listaAux = new ArrayList<inscripcion>();
    session.setAttribute("lista", listaAux);
    }
    List<inscripcion> lista = (ArrayList<inscripcion>)session.getAttribute("lista");
    

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAGINA PRINCIPAL
        </title>
    </head>
    <body>
        <h1>LISTADO DE INSCRITOS</h1>
        <p> <a href="MainServlet?action=nuevo">Nuevo</a></p>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>FECHA</th>
                <th>NOMBRES</th>
                <th>APELLIDOS</th>
                <th>TURNO</th>
                <th>SEMINARIOS</th>
                <th> </th>
                <th></th>
                
            </tr>
            <%
            for(inscripcion ins : lista){ 
            
                
            %>
            <tr>
                <td><%= ins.getId()%></td>
                <td><%= ins.getFecha()%></td>
                <td><%= ins.getNombres()%></td>
                <td><%= ins.getApellidos()%></td>
                <td><%= ins.getTurno()%></td>
                <td><%= ins.getSeminarios()%></td>
                <td><a href="MainServlet?action=editar&id=<%= ins.getId() %>">EDITAR</a></td>
                <td><a href="MainServlet?action=eliminar&id=<%= ins.getId() %>">ELIMINAR</a></td>
                
                
            </tr>
            <%
                }
            %>
            
        </table>
    </body>
</html>
