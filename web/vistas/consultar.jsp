<%-- 
    Document   : consultar
    Created on : 20 oct. 2023, 09:25:06
    Author     : Pietro
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Invitados</title>

    </head>
    <body>
        
        <h1>Lista de Invitados</h1>

        <p>Invitados dados de alta:</p>
        <table class="bordered-table">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Estado</th>
            </tr>
            <c:forEach items="${listaAlta}" var="invitado">
                <tr>
                    <td>${invitado.invitado_id}</td>
                    <td>${invitado.invitado_nombre}</td>
                    <td>${invitado.invitado_estado}</td>
                </tr>
            </c:forEach>
        </table>

        <br><p>Invitados dados de baja:</p>
        <table class="bordered-table">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Estado</th>
            </tr>
            <c:forEach items="${listaBaja}" var="invitado">
                <tr>
                    <td>${invitado.invitado_id}</td>
                    <td>${invitado.invitado_nombre}</td>
                    <td>${invitado.invitado_estado}</td>
                </tr>
            </c:forEach>
        </table>

        <br><a href="agregarController" class="button" >Agregar mas Invitados</a>
        <a href="altaController" class="button" >Ir a dar de alta a invitado</a>
        <a href="bajaController" class="button" >Ir a dar de baja a invitado</a>
        <a href="index.jsp" class="button" >Regresar a Inicio</a>

    </body>
</html>

