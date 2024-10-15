/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var mapa = L.map("mapa-del-cut").setView([20.566736996117946, -103.22846090067654],17.49)
L.tileLayer("https://tile.openstreetmap.org/{z}/{x}/{y}.png?,{}").addTo(mapa)

var marcador1 =L.marker([20.567257, -103.226077]).addTo(mapa)
marcador1.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje A </h3>  <p> Con cordenadas :20.567257, -103.226077</p> <img class='imgbt' src='Images/Botes/img (22).jpg' /> ")
marcador1.on('click', function(e) {
    mostrarCuadroTexto(
        'Contenedores de reciclaje',
        [img_papel, img_inorganicos, img_organicos, img_plasticos],
        'Puedes reciclar este tipo de residuos',
        true,
        'Contenedores A'
    );
    grafica(['Papel', 'Inorganicos', 'Organicos','Plasticos']);
});

var marcador2 =  L.marker([20.566290, -103.228069]).addTo(mapa)
marcador2.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje B </h3>  <p> Con cordenadas :20.566290, -103.228069 </p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador2.on('click', function(e) {

    mostrarCuadroTexto('Contenedores de reciclaje',[img_plasticos, img_papel, img_metal, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores B");
    grafica(['Plasticos', 'Papel', 'Metal', 'Dificil Reciclaje']);
});

var marcador3 =  L.marker([20.567930, -103.227679]).addTo(mapa)
marcador3.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje C </h3>  <p> Con cordenadas :20.567930, -103.227679 </p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador3.on('click', function(e) {

   mostrarCuadroTexto('Contenedores de reciclaje', [img_papel, img_inorganicos, img_organicos,img_plasticos],'Puedes reciclar este tipo de residuos', true, "Contenedores C");
   grafica(['Papel', 'Inorganicos', 'Organicos','Plasticos']);
});

var marcador4 =  L.marker([20.567837917655613, -103.22862054715823]).addTo(mapa)
marcador4.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje D </h3>  <p> Con cordenadas :20.567837917655613, -103.22862054715823 </p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador4.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_papel, img_vidrio, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores D")
    grafica(['Papel', 'Vidrio', 'Plasticos', 'Dificil Reciclaje'])

});
var marcador5 =  L.marker([20.566773982106564, -103.22694831474072]).addTo(mapa)
marcador5.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje E </h3>  <p> Con cordenadas : 20.566773982106564, -103.22694831474072</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador5.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_plasticos, img_vidrio, img_metal, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores E")
    grafica(['Plasticos','Vidrio', 'Metal', 'Dificil Reciclaje'])

});


var marcador6 =  L.marker([20.567132188574096, -103.22762347254994]).addTo(mapa)
marcador6.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje F </h3>  <p> Con cordenadas : 20.567132188574096, -103.22762347254994</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador6.on('click', function(e) {

   mostrarCuadroTexto('Contenedores de reciclaje',[img_papel, img_metal, img_vidrio, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores F")
   grafica(['Papel', 'Metal', 'Vidrio', 'Plasticos', 'Dificil Reciclaje'])
});



var marcador7 =  L.marker([20.56711414829566, -103.23022014143083]).addTo(mapa)
marcador7.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje G </h3>  <p> Con cordenadas : 20.56711414829566, -103.23022014143083</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador7.on('click', function(e) {

   mostrarCuadroTexto('Contenedores de reciclaje',[img_papel,img_organicos, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores G")
   grafica(['Papel','Organicos', 'Plasticos', 'Dificil Reciclaje'])
});

var marcador8 =  L.marker([20.567099872026592, -103.22819050770538]).addTo(mapa)
marcador8.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje H </h3>  <p> Con cordenadas : 20.567099872026592, -103.22819050770538</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador8.on('click', function(e) {

   mostrarCuadroTexto('Contenedores de reciclaje',[img_plasticos,img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores H")
   grafica(['Plasticos','Dificil Reciclaje'])
});

var marcador9 =  L.marker([20.56710049983879, -103.2281167469584]).addTo(mapa)
marcador9.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje I </h3>  <p> Con cordenadas : 20.56710049983879, -103.2281167469584</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador9.on('click', function(e) {

   mostrarCuadroTexto('Contenedores de reciclaje',[img_papel, img_metal],'Puedes reciclar este tipo de residuos', true, "Contenedores I")
   grafica(['Papel', 'Metal'])
});
var marcador11=  L.marker([20.567080308476694, -103.22619588100355]).addTo(mapa)
marcador11.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje J </h3>  <p> Con cordenadas : 20.567080308476694, -103.22619588100355</p> <img class='imgbt' src='Images/Botes/img (23).jpg'  /> ")
marcador11.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_plasticos, img_vidrio, img_metal, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores J")
    grafica(['Plasticos', 'Vidrio', 'Metal', 'Dificil Reciclaje'])

});
var marcador12 =  L.marker([20.567004373533045, -103.22994141729409]).addTo(mapa)
marcador12.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje K </h3>  <p> Con cordenadas : 20.567004373533045, -103.22994141729409</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador12.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_metal, img_vidrio, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true,"Contenedores K")
    grafica(['Metal', 'Vidrio', 'Plasticos', 'Dificil Reciclaje'])

});
var marcador13 =  L.marker([20.566560166194456, -103.2258512664946]).addTo(mapa)
marcador13.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje L </h3>  <p> Con cordenadas : 20.566560166194456, -103.2258512664946</p> <img class='imgbt' src='Images/Botes/img (20).jpg'  /> ")
marcador13.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_plasticos, img_metal, img_vidrio, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores L")
    grafica(['Plasticos', 'Metal', 'Vidrio', 'Dificil Reciclaje'])

});
var marcador14 =  L.marker([20.56660798126268, -103.22758511374145]).addTo(mapa)
marcador14.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje M </h3>  <p> Con cordenadas : 20.56660798126268, -103.22758511374145</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador14.on('click', function(e) {

   mostrarCuadroTexto('Contenedores de reciclaje',[img_metal, img_vidrio, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores M")
   grafica(['Metal', 'Vidrio', 'Plasticos', 'Dificil Reciclaje'])
});

var marcador15 = L.marker([20.566429054105644, -103.22697759340359]).addTo(mapa)
marcador15.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje N </h3>  <p> Con cordenadas : 20.566429054105644, -103.22697759340359</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador15.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_metal, img_vidrio, img_plasticos,img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores N")
    grafica(['Metal', 'Vidrio', 'Plasticos', 'Dificil Reciclaje'])

});

var marcador16 =  L.marker([20.566374414071444, -103.2278476803845]).addTo(mapa)
marcador16.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje U </h3>  <p> Con cordenadas : 20.566374414071444, -103.2278476803845</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador16.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_plasticos, img_vidrio, img_metal, img_organicos, img_papel, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true,"Contenedores U")
    grafica(['Plasticos', 'Vidrio', 'Metal','Organicos','Papel', 'Dificil Reciclaje'])

});

var marcador17 = L.marker([20.56631188320407, -103.22738529234732]).addTo(mapa)
marcador17.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje O </h3>  <p> Con cordenadas : 20.56631188320407, -103.22738529234732</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador17.on('click', function(e) {

   mostrarCuadroTexto('Contenedores de reciclaje',[img_papel, img_organicos, img_metal, img_vidrio, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores O")
   grafica(['Papel', 'Organicos', 'Metal', 'Vidrio', 'Plasticos', 'Dificil Reciclaje'])
});

var marcador18 =  L.marker([20.56629947926341, -103.2290175527782]).addTo(mapa)
marcador18.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje Q </h3>  <p> Con cordenadas : 20.56629947926341, -103.2290175527782</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador18.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_metal, img_vidrio, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores Q")
    grafica(['Metal', 'Vidrio', 'Plasticos', 'Dificil Reciclaje'])

});

var marcador19 =  L.marker([20.565390042111762, -103.22811060293905]).addTo(mapa)
marcador19.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje R </h3>  <p> Con cordenadas : 20.565390042111762, -103.22811060293905</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador19.on('click', function(e) {
   mostrarCuadroTexto('Contenedores de reciclaje',[img_papel, img_organicos, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true, "Contenedores R")
   grafica(['Papel', 'Organicos', 'Plasticos', 'Dificil Reciclaje'])
});

var marcador20 =  L.marker([20.56556404481185, -103.22716214703281]).addTo(mapa)
marcador20.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje S </h3>  <p> Con cordenadas : </p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador20.on('click', function(e) {

 mostrarCuadroTexto('Contenedores de reciclaje',[img_vidrio, img_plasticos, img_dificil_reclaje],'Puedes reciclar este tipo de residuos', true,  'Contenedores S')
 grafica(['Vidrio','Plasticos','Dificil Reciclaje'])
});

var marcador21 =  L.marker([20.56554834934846, -103.22709039794258]).addTo(mapa)
marcador21.bindPopup("<a href='http://localhost:9990/mapa'><img src='Images/Minijuego.jpg' alt='Imagen del cuadro' style='width: 10%; height: 10%'></a><h3> Contenedor de reciclaje T </h3>  <p> Con cordenadas : 20.56554834934846, -103.22709039794258</p> <img class='imgbt' src='Images/Botes/img (22).jpg'  /> ")
marcador21.on('click', function(e) {
    mostrarCuadroTexto('Contenedores de reciclaje',[img_papel, img_metal],'Puedes reciclar este tipo de residuos', true,"Contenedores S")
    grafica(['Papel', 'Metal'])

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



//****************************************************
var img_madera = 'Images/madera.png';
var img_metal = 'Images/Metal.png';
var img_organicos = 'Images/organicos.png';
var img_sanitarios = 'Images/sanitarios.png';
var img_dificil_reclaje ='Images/dificil_reciclaje.png';
var img_papel = 'Images/Papel.png';
var img_vidrio = 'Images/Vidrio.png';
var img_plasticos = 'Images/Plasticos.png';
var img_inorganicos = img_dificil_reclaje;
var img_construccion = 'Images/.png';
var img_peligrosos='Images/Peligrosos.png';
var img_unicel='Images/Unicel.png';
var img_textiles='Images/Textiles.png';

function getRandomPercentage() {
  return (Math.random() * 100).toFixed(2);
}

function grafica(tpbt){
    var tpbte = document.getElementById('TpBt');

     while (tpbte.firstChild) {
        tpbte.removeChild(tpbte.firstChild);
    }

    for (var i = 0; i < tpbt.length; i++) {
        var nwop = document.createElement('option');
        nwop.value = tpbt[i];
        nwop.innerHTML=tpbt[i];
        tpbte.appendChild(nwop);
    }


}

function mostrarCuadroTexto(texto, imagenes, informacionAdicional, bote, ubicacion) {
  var cuadroTexto = document.getElementById('cuadroTexto');
  var cuadroreporte = document.getElementById('cuadroreporte');
  var textoCuadro = document.getElementById('textoCuadro');
  var imagenCuadro = document.getElementById('imagenCuadro');
  var informacionCuadro = document.getElementById('informacionCuadro');
  var Etubicacion = document.getElementById('ub');

  textoCuadro.innerHTML = texto;
  imagenCuadro.innerHTML = '';

  ocultarCuadroTexto();
  for (var i = 0; i < imagenes.length; i++) {
    var nuevaImagen = document.createElement('img');
    nuevaImagen.src = imagenes[i];

    if (bote == false) {
      nuevaImagen.alt = 'Imagen del cuadro';
      nuevaImagen.style.width = '100%';
      nuevaImagen.style.height = '90%';
      document.getElementById("imagenCuadro").href = "https://www.google.com.mx/maps/place/CUTONALA+Centro+Universitario+de+Tonal%C3%A1+-+UDG/@20.5664097,-103.2286777,217m/data=!3m1!1e3!4m14!1m7!3m6!1s0x842f4b24202abe73:0xd33161e2e4345862!2sCUTONALA+Centro+Universitario+de+Tonal%C3%A1+-+UDG!8m2!3d20.5666667!4d-103.2286111!16s%2Fg%2F12hy9f77n!3m5!1s0x842f4b24202abe73:0xd33161e2e4345862!8m2!3d20.5666667!4d-103.2286111!16s%2Fg%2F12hy9f77n?entry=ttu";
    } else {
      nuevaImagen.alt = 'Iconos del cuadro';
      nuevaImagen.style.width = '25%';
      nuevaImagen.style.height = '25%';
      cuadroreporte.style.display = 'block';
      Etubicacion.value = ubicacion;
      document.getElementById("imagenCuadro").href = "Others/Infografias.pdf";
    }
    imagenCuadro.appendChild(nuevaImagen);
  }

  informacionCuadro.innerHTML = informacionAdicional;
  cuadroTexto.style.display = 'block';
}

function ocultarCuadroTexto() {
  var cuadroTexto = document.getElementById('cuadroTexto');
  var cuadroreporte = document.getElementById('cuadroreporte');
  cuadroTexto.style.display = 'none';
  cuadroreporte.style.display = 'none';
}

