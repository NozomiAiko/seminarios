
<%@page import="com.emergentes.inscripcion"%>
<%
 inscripcion ins = (inscripcion)request.getAttribute("inscripcion");
 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSCRIPCIONES</title>
    </head>
    <body>
        <h1>REGISTRO DE SEMINARIOS</h1>
        
        <form action="MainServlet" method="post">
            <input  type="hidden" name="id" value="<%= ins.getId() %>">
            <table border="1">
                <tr>
                    <td>fecha:</td>
                    <td><input type="date" name="fecha" value="<%= ins.getFecha() %>"></td>
                </tr>
                <tr>
                    <td>nombres:</td>
                    <td><input type="text" name="nombres" value="<%= ins.getNombres() %>"></td>
                    
                </tr>
                <tr>
                    <td>apellidos:</td>
                    <td><input type="text" name="apellidos" value="<%= ins.getApellidos() %>"></td>
                </tr>
                <tr>
                    <td>turno:</td>
                    <td>Mañana<input type="radio" value="Mañana" name="turno">
                    Tarde<input type="radio" value="Tarde" name="turno">
                    Noche<input type="radio" value="Noche" name="turno"></td>
                    
                </tr>
                <tr>
                    <td>seminarios disponibles:</td>
                    <td>
                       <label for="seminarios">Seminarios:</label><br>
            <input type="checkbox" id="ia" name="seminarios" value="Inteligencia Artificial" >
            <label for="ia">Inteligencia Artificial</label><br>
            <input type="checkbox" id="ml" name="seminarios" value="Machine Learning" >
            <label for="ml">Machine Learning</label><br>
            <input type="checkbox" id="sa" name="seminarios" value="Simulacion con Arena" >
            <label for="sa">Simulación con Arena</label><br>
            <input type="checkbox" id="re" name="seminarios" value="Robotica Educativa" >
            <label for="re">Robótica Educativa</label><br>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="ENVIAR REGISTRO"></td>
                </tr>
            </table>
            
            
        </form>
    </body>
</html>
