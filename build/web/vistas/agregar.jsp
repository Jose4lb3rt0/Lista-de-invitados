<%-- 
    Document   : agregar
    Created on : 16 oct. 2023, 16:13:23
    Author     : Pietro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Invitado</title>
    </head>
    <body>
        <h2>Agregar Invitado</h2>

        <div class="container">
            <div class="card">
                <div class="card-body">

                    <!-- Agregar esta sección para mostrar el mensaje -->
                    <div>
                        <c:if test="${not empty mensaje}">
                            <p class="mensaje error">${mensaje}</p>
                        </c:if>
                    </div>

                    <form action="agregarController?accion=agregar" method="POST" autocomplete="off">

                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <br>
                            <input id="nombre" name="invitado_nombre" type="text" class="input-field" required>
                        </div>

                        <br>

                        <div class="form-group">
                            <label for="estado">Estado:</label>
                            <br>
                            <select id="estado" name="invitado_estado" class="select-diseño">
                                <option value="alta" selected>alta</option>
                                <option value="baja">baja</option>
                            </select>
                        </div>

                        <br>

                        <button id="guardar" name="guardar" type="submit" class="submit-button" >Agregar</button>
                    </form>

                    <a href="consultarController" class="button" >Volver a Consultar Invitados</a>
                    <a href="index.jsp" class="button" >Regresar a Inicio</a>

                </div>
            </div>
        </div>
    </body>
</html>
