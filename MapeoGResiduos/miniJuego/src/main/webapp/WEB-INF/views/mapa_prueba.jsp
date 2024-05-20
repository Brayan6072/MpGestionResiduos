<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mapa - Tirar Basura</title>
</head>
<body>
    <h1>Mapa</h1>
    <p>¡Bienvenido al mapa!</p>
    
    <!-- Cambia el botón por un enlace <a> -->
    <a href="login.jsp" id="tirarBasuraButton">Tirar Basura</a>

    <!-- Incluye el script JavaScript -->
    <script>
        // Asigna el evento onclick al enlace
        document.getElementById("tirarBasuraButton").onclick = function() {
            // Redirige a la página de login.jsp
            window.location.href = "login.jsp";
        };
    </script>
</body>
</html>