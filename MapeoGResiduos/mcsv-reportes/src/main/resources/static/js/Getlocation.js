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
            console.log(selectedValues);
        });
    });
});

function agregarCampo() {
        const container = document.getElementById("clasificacion-container");
        const index = container.children.length; // Obtener el número actual de campos
        const nuevoCampo = `
            <div>
                <input type="number" name="clasificacion_id[${index}]" placeholder="Clasificación ${index + 1}">
                <button type="button" onclick="eliminarCampo(this)">Eliminar</button>
            </div>
        `;
        container.insertAdjacentHTML("beforeend", nuevoCampo);
    }


    function eliminarCampo(boton) {
        const campo = boton.parentElement;
        campo.remove();
    }

    function ShowAddSection(){
        const AddSection = document.getElementById("AddSection");
        const hidden = AddSection.getAttribute("hidden");
        const RemoveSection = document.getElementById("RemoveSection");
        const hiddenRemove = RemoveSection.getAttribute("hidden");

        if(hidden){
            AddSection.removeAttribute("hidden");
            RemoveSection.setAttribute("hidden", true);
        }else{
            AddSection.setAttribute("hidden", true);
            RemoveSection.removeAttribute("hidden");
        }

    }