<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Podium</title>
    <script src="/JS/jugadores.js" defer type="module"></script></head>
<body>


    <h1>Podium</h1>

    <div class="d-flex justify-content-center">
        <form action="/tirarBasura" method="post">
            <button type="submit" class="btn" >Tirar Basura</button>
        </form>
      </div>
    <table id="podiumTable">
        <thead>
            <tr>
                <th>Posición</th>
                <th>Jugador</th>
                <th>Puntos</th>
            </tr>
        </thead>
        <tbody id="podiumBody">
            <!-- Aquí se llenará dinámicamente la tabla -->
        </tbody>
    </table>


    <link rel="stylesheet" href="/css/estilos.css">
</body>
</html>