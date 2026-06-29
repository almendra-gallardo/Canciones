<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
</head>
<body>
    <h1>Catálogo de Canciones</h1>
    
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${listaCanciones}">
                <tr>
                    <td><c:out value="${item.titulo}"/></td>
                    <td><c:out value="${item.artista}"/></td>
                    <td>
                        <a href="/canciones/detalle/${item.id}">Ver Detalle</a>
                    </td>
                </tr>
            </c:forEach></tbody>
    </table>
	<br><br>
	    <a href="/canciones/formulario/agregar/0">
	        <button type="button">Agregar una Canción</button>
	    </a>
</body>
</html>