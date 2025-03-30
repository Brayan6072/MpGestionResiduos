var map = L.map('google_map').setView([20.567257, -103.226077], 15);


L.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors &copy; <a href="https://carto.com/attributions">CARTO</a>',
    subdomains: 'abcd',
    maxZoom: 25,
    minZoom: 17.5
}).addTo(map);


var marker;


map.on('click', function(e) {
    var lat = e.latlng.lat.toFixed(6);
    var lng = e.latlng.lng.toFixed(6);


    if (marker) {
        marker.setLatLng(e.latlng);
    } else {

        marker = L.marker(e.latlng).addTo(map);
    }


    marker.bindPopup("Lat: " + lat + "<br>Lng: " + lng).openPopup();
    var latitud = document.getElementById('latitud');
    var longitud = document.getElementById('longitud');
    var nombre = document.getElementById('nombre');
    latitud.value = lat;
    longitud.value = lng;


});

const contenedor_id = document.getElementById("selectclass");

document.addEventListener('DOMContentLoaded', (event) => {
    const form = document.getElementById('contenedorForm');
    const checkboxes = form.querySelectorAll('input[type="checkbox"]');
    const selectedValues = [];

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', (event) => {
            if (event.target.checked) {
                selectedValues.push(event.target.value);
            } else {
                const index = selectedValues.indexOf(event.target.value);
                if (index > -1) {
                    selectedValues.splice(index, 1);
                }
            }
            contenedor_id.value = selectedValues
            console.log(selectedValues);
        });
    });
});



