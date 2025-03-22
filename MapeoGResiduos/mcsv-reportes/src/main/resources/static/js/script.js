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

var btnsp = document.getElementById("btn-sign-up");

btnsignup.addEventListener("click", function(){
    window.location.href = "https://microservice-login-latest.onrender.com/login/index";
});


var btngame = document.getElementById("gamecontroller");

btngame.addEventListener("click", function(){
    window.location.href = "http://localhost:9990/mapa";
});






