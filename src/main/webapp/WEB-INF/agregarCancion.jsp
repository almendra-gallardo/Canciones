<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción</title>
    <style>
        .error-message { color: red; font-size: 0.9em; margin-left: 10px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 100px; }
    </style>
</head>
<body>

    <h2>Agregar Nueva Canción</h2>

    <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
        
        <div class="form-group">
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" />
            <form:errors path="titulo" cssClass="error-message" />
        </div>

        <div class="form-group">
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista" />
            <form:errors path="artista" cssClass="error-message" />
        </div>

        <div class="form-group">
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" />
            <form:errors path="album" cssClass="error-message" />
        </div>

        <div class="form-group">
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" />
            <form:errors path="genero" cssClass="error-message" />
        </div>

        <div class="form-group">
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" />
            <form:errors path="idioma" cssClass="error-message" />
        </div>

        <button type="submit">Guardar Canción</button>
    </form:form>

    <br>
    <a href="/canciones">Volver a lista de canciones</a>

</body>
</html>