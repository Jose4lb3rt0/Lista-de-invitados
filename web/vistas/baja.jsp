<%-- 
    Document   : baja
    Created on : 20 oct. 2023, 09:25:37
    Author     : Pietro
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dar de Baja al Invitado</title>
</head>
<body>
    <h1>Baja</h1>
    <form action="bajaController?accion=baja" method="post">
        Introduzca un nombre: 
        <br><input type="text" id = "nombre" name="invitado_nombre" class="input-field">
        <button id="guardar" name="guardar" type="submit" class="submit-button">Dar de baja</button>
    </form>
    <a href="consultarController" class="button" >Volver a Consultar Invitados</a>
    <a href="index.jsp" class="button" >Regresar a Inicio</a>
</body>
</html>
