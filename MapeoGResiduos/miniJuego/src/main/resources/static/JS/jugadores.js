import { initializeApp } from "https://www.gstatic.com/firebasejs/10.10.0/firebase-app.js";
import { getFirestore, collection, getDocs, orderBy, query, limit} from "https://www.gstatic.com/firebasejs/10.10.0/firebase-firestore.js";

const firebaseConfig = {
    apiKey: "AIzaSyARy0NxDNE_LdiBGn7F8qPbOUuGRntgWtg",
    authDomain: "minijuegomapeo-8dfd7.firebaseapp.com",
    databaseURL: "https://minijuegomapeo-8dfd7-default-rtdb.firebaseio.com",
    projectId: "minijuegomapeo-8dfd7",
    storageBucket: "minijuegomapeo-8dfd7.appspot.com",
    messagingSenderId: "803838126247",
    appId: "1:803838126247:web:e9e182b804fd76d90b5382",
    measurementId: "G-P7EQ35XN19"
};
// Initialize Firebase
const app = initializeApp(firebaseConfig);
const db = getFirestore(app);

async function mostrarPodium() {
    try {
        const q = query(collection(db, "usuarios"), orderBy("puntos", "desc"), limit(15));
        const querySnapshot = await getDocs(q);
        const podiumBody = document.getElementById("podiumBody");

        let posicion = 1;

        querySnapshot.forEach((doc) => {
            const jugador = doc.data().nombreUsuario;
            const puntos = doc.data().puntos;

            const row = `<tr>
                            <td>${posicion}</td>
                            <td>${jugador}</td>
                            <td>${puntos}</td>
                        </tr>`;
            podiumBody.innerHTML += row;

            posicion++;
        });
    } catch (error) {
        console.error("Error al obtener los datos de Firestore:", error);
    }
}

// Llamar a la función para mostrar el podium cuando se cargue la página
mostrarPodium();