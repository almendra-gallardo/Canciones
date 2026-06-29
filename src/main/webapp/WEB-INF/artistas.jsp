<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Artistas</title>
</head>
<body>
    <h1>Catálogo de Artistas</h1>
    
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${listaArtistas}">
                <tr>
                    <td><c:out value="${item.nombre}"/></td>
                    <td><c:out value="${item.apellido}"/></td>
                    <td>
                        <a href="/artistas/detalle/${item.id}">Ver Detalle</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br><br>
    <a href="/artistas/formulario/agregar/0">Agregar un Artista</a> | 
    <a href="/canciones">Ir a canciones</a>
</body>
</html>