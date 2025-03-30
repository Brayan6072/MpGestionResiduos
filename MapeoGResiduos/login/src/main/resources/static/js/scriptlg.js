/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.addEventListener("DOMContentLoaded", function() {
    const container = document.getElementById('container');
    const registerBtn = document.getElementById('register');
    const loginBtn = document.getElementById('login');
    const userTypeSelect = document.getElementById("usertype");
    const claveField = document.getElementById("clave-field");
    const claveExtraField = document.getElementById("clave-extra-field");

    registerBtn.addEventListener('click', () => {
        container.classList.add("active");
    });

    loginBtn.addEventListener('click', () => {
        container.classList.remove("active");
    });

    userTypeSelect.addEventListener("change", function() {
        if (userTypeSelect.value === "administrador") {
            claveField.style.display = "block";
            claveExtraField.style.display = "block";
        } else {
            claveField.style.display = "none";
            claveExtraField.style.display = "none";
        }
    });
});
