<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle de la Canción</title>
</head>
<body>
    <c:choose>
        <c:when test="${cancion == null}">
            <h2>La canción solicitada no existe en el catálogo.</h2>
        </c:when>
        <c:otherwise>
            <h1>Detalle de la Canción</h1>
            <p><strong>ID:</strong> ${cancion.id}</p>
            <p><strong>Título:</strong> ${cancion.titulo}</p>
            <p><strong>Artista:</strong> ${cancion.artista}</p>
            <p><strong>Álbum:</strong> ${cancion.album}</p>
            <p><strong>Género:</strong> ${cancion.genero}</p>
            <p><strong>Idioma:</strong> ${cancion.idioma}</p>
        </c:otherwise>
    </c:choose>
    
    <br>
    <a href="/canciones">Volver al catálogo</a>
	<br><br>
	    <a href="/canciones/formulario/editar/${cancion.id}">
	        <button type="button">Editar Canción</button>
	    </a>

	</html>
</body>
</html>