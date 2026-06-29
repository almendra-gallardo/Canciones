<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Artista</title>
    <style>
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 100px; }
    </style>
</head>
<body>
    <h2>Agregar Nuevo Artista</h2>

    <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
        <div class="form-group">
            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" />
        </div>
        <div class="form-group">
            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" />
        </div>
        <div class="form-group">
            <form:label path="biografia">Biografía:</form:label>
            <form:textarea path="biografia" rows="4" cols="30"/>
        </div>
        <button type="submit">Guardar Artista</button>
    </form:form>

    <br>
    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>