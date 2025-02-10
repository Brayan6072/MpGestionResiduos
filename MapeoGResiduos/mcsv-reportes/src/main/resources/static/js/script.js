const menu = document.querySelector('.menu');
const btnsignup = document.getElementById('btn-sign-up');
const header = document.querySelector('header');
const controllers = document.querySelector('.controllers');
const headerContainer = document.querySelector('.header-container');

const responsivey = () => {
    if (window.innerHeight <= 362) {
        if (menu.classList.contains('active')) {
            menu.classList.add('min');
        }else{
            menu.classList.remove('min');
        }
    }else{
        menu.classList.remove('min');
    }
      
};

const btnmenu = document.getElementById('btn-menu');
btnmenu.addEventListener('click', () => {
  menu.classList.toggle('active');
    responsivey();
});

const responsive = () => {
  if (window.innerWidth <= 865) {
    menu.children[0].appendChild(btnsignup);
    header.appendChild(menu);
  }else{
    controllers.appendChild(btnsignup);
    headerContainer.appendChild(menu);
  } 
  responsivey();
}

responsive();
window.addEventListener('resize', responsive);


//rutas de imagenes de cada clasificacion****************************************************
var img_madera = 'Images/contenedores/madera.png';
var img_metal = 'Images/contenedores/Metal.png';
var img_organicos = 'Images/contenedores/organicos.png';
var img_sanitarios = 'Images/contenedores/sanitarios.png';
var img_dificil_reclaje ='Images/contenedores/dificil_reciclaje.png';
var img_papel = 'Images/contenedores/Papel.png';
var img_vidrio = 'Images/contenedores/Vidrio.png';
var img_plasticos = 'Images/contenedores/Plasticos.png';
var img_inorganicos = img_dificil_reclaje;
var img_construccion = 'Images/contenedores/.png';
var img_peligrosos='Images/contenedores/Peligrosos.png';
var img_unicel='Images/contenedores/Unicel.png';
var img_textiles='Images/contenedores/Textiles.png';

/*-------- */




