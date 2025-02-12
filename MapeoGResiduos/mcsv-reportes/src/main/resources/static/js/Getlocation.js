// Inicializar el mapa
var map = L.map('map').setView([20.567257, -103.226077], 15);

// Cargar capa de OpenStreetMap
L.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors &copy; <a href="https://carto.com/attributions">CARTO</a>',
    subdomains: 'abcd',
    maxZoom: 25,
    minZoom: 17.5
}).addTo(map);

// Variable para el marcador
var marker;

// Evento de clic en el mapa
map.on('click', function(e) {
    var lat = e.latlng.lat.toFixed(6);
    var lng = e.latlng.lng.toFixed(6);

    // Si ya hay un marcador, lo actualiza
    if (marker) {
        marker.setLatLng(e.latlng);
    } else {
        // Crear un nuevo marcador
        marker = L.marker(e.latlng).addTo(map);
    }

    // Mostrar coordenadas en el popup del marcador
    marker.bindPopup("Lat: " + lat + "<br>Lng: " + lng).openPopup();
    var latitud = document.getElementById('latitud');
    var longitud = document.getElementById('longitud');
    var nombre = document.getElementById('nombre');
    latitud.value = lat;
    longitud.value = lng;
    

});