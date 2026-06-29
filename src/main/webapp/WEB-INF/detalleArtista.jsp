<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle del Artista</title>
</head>
<body>
    <h2>Detalle de: <c:out value="${artista.nombre}"/> <c:out value="${artista.apellido}"/></h2>
    <p><strong>Biografía:</strong> <c:out value="${artista.biografia}"/></p>

    <h3>Canciones de este artista:</h3>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
            <li><c:out value="${cancion.titulo}"/> (<c:out value="${cancion.album}"/>)</li>
        </c:forEach>
        <c:if var="vacio" test="${empty artista.canciones}">
            <li>Este artista no tiene canciones registradas aún.</li>
        </c:if>
    </ul>

    <br>
    <a href="/artistas">Volver a lista de artistas</a>
	<a href="/artistas">Ir a artistas</a>
</body>
</html>