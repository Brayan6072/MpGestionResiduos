import { initializeApp } from "https://www.gstatic.com/firebasejs/10.10.0/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.10.0/firebase-analytics.js";
import { getAuth, GoogleAuthProvider, signInWithPopup } from "https://www.gstatic.com/firebasejs/10.10.0/firebase-auth.js";
import { getFirestore } from "https://www.gstatic.com/firebasejs/10.10.0/firebase-firestore.js";

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
const auth = getAuth(app);
const analytics = getAnalytics(app);
const db = getFirestore(app);
const provider = new GoogleAuthProvider();
auth.languageCode = 'es';


const googleLogin = document.getElementById("button-login");
googleLogin.addEventListener("click", function() {
    signInWithPopup(auth, provider)
            .then((result) => {
                const credential = GoogleAuthProvider.credentialFromResult(result);
        const user = result.user;
        console.log(user);
        
        
    }).catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
    });

});

