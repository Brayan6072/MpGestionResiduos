

var mapa = L.map("mapa-del-cut").setView([20.566736996117946, -103.22846090067654], 17.49);


var CartoDB_Positron = L.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors &copy; <a href="https://carto.com/attributions">CARTO</a>',
    subdomains: 'abcd',
    maxZoom: 25,
    minZoom: 17.5
});



CartoDB_Positron.addTo(mapa);
mapa.zoomControl.setPosition('bottomright');

var customIcon = L.icon({
    iconUrl: '/Images/marker.png',
    iconSize: [34, 34],
    iconAnchor: [18, 34],
    popupAnchor: [0, -32]
});

var grupoPapel = L.layerGroup();
var grupoMetal = L.layerGroup();
var grupoVidrio = L.layerGroup();
var grupoPlasticos = L.layerGroup();
var grupoDificilReciclaje = L.layerGroup();
var grupoOrganicos = L.layerGroup();


const url = 'http://localhost:8099/contenedores/ubicaciones/clasificaciones'; // Cambia la URL según tu configuración

fetch(url)
  .then(response => {
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    return response.json(); // Parsear la respuesta como JSON
  })
  .then(data => {
      var punteros = [];
      var marcadores = data;
       var divmain = document.querySelector(".bottom-gallery");
for (var i = 0; i < marcadores.length; i++) {

    punteros[i] = L.marker([marcadores[i][2], marcadores[i][1]], {icon: customIcon});

    var residuos = marcadores[i][3].split(",").map(r => r.trim());

    residuos.forEach(grupo => {
            
            switch (grupo) {
                case "Papel":
                    punteros[i].addTo(grupoPapel);
                    break;
                case "Dificil Reciclaje":
                    punteros[i].addTo(grupoDificilReciclaje);
                    break;
                case "Organicos":
                    punteros[i].addTo(grupoOrganicos);
                    break;
                case "Plasticos":
                    punteros[i].addTo(grupoPlasticos);
                    break;
                case "Vidrio":
                    punteros[i].addTo(grupoVidrio);
                    break;
                case "Metal":
                    punteros[i].addTo(grupoMetal);
                    break;
            }        

        });
    punteros[i].bindPopup("<img class='imgbt' src='/Images/Botes/img (22).jpg'  onload='getimg(" + JSON.stringify(residuos) + ")';/> <div class='content'><h3 class='etiqueta_contenedor'>" + marcadores[i][0] + "</h3>  <p class='coordenadas_contenedor'> Con cordenadas :" + marcadores[i][2] + ", " + marcadores[i][1] + "</p><a href='http://localhost:8099/contenedores/ubicaciones/reporte/"+marcadores[i][0]+"'><button class='btn-reportar'>Reportar</button></a></div>");

}



grupoPapel.addTo(mapa);
grupoMetal.addTo(mapa);
grupoVidrio.addTo(mapa);
grupoPlasticos.addTo(mapa);
grupoDificilReciclaje.addTo(mapa);

var overlayMaps = {
    "Papel": grupoPapel,
    "Metal": grupoMetal,
    "Vidrio": grupoVidrio,
    "Plasticos": grupoPlasticos,
    "Dificil Reciclaje": grupoDificilReciclaje
};


L.control.layers(null, overlayMaps,{ position: 'bottomleft' }).addTo(mapa);
    //console.log('Clasificaciones obtenidas:', marcadores);


  })
  .catch(error => {
    console.error('Error al consumir el endpoint:', error);
  });

//Codigo de  ubicacion  ****************************************************************

if(!navigator.geolocation) {
    console.log("Tu navegador no es compatible con tu geolocalizacion")
}else{
    setInterval(() =>{
        navigator.geolocation.getCurrentPosition(getPosition)

    } ,5000);//Segundos de actualizacion ubicacion esta en 5s

}

var marker , circle;

function getPosition (position){

    var lat = position.coords.latitude
    var long = position.coords.longitude
    var accuracy = position.coords.accuracy



     if(marker){
        mapa.removeLayer(marker)
     }
     if(circle){
        mapa.removeLayer(circle)
     }

     marker = L.marker([lat, long])
     circle= L.circle ([lat, long] , {radius:20,accuracy})

     var featureGroup = L.featureGroup([marker,circle]).addTo(mapa).bindPopup("<h3> Tu ubicacion actual </h3>").openPopup()

     mapa.fitBounds(featureGroup.getBounds())

     console.log("Tus coordenadas son :Lat "+lat+"long:"+long+"Accuracy "+accuracy)
}



function getimg(residuos) {
    var divmain = document.querySelector(".bottom-gallery");
    if (!divmain) {
        console.error("El contenedor principal no se encontró.");
        return;
    }

    divmain.innerHTML = ''; 

    for (var i = 0; i < residuos.length; i++) {
        var divcls = document.createElement('div');
        divcls.className = 'image-container';
        var imgcls = document.createElement('img');

        imgcls.src = "/Images/contenedores/" + residuos[i] + ".png";
        divcls.appendChild(imgcls);
        divmain.appendChild(divcls);
    }
}

var btnsp = document.getElementById("btn-sign-up");

btnsignup.addEventListener("click", function(){
    window.location.href = "http://localhost:9090/login/index";
});