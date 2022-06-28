// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getStorage } from "firebase/storage";
//import { getStorage, ref, uploadBytes, getDownloadURL } from "firebase/storage";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyAjEdwAQtzaAkGJXtwpeQWk1XFiNPyQGF4",
  authDomain: "sportsnewsbg-753cb.firebaseapp.com",
  projectId: "sportsnewsbg-753cb",
  storageBucket: "sportsnewsbg-753cb.appspot.com",
  messagingSenderId: "285936750155",
  appId: "1:285936750155:web:2d3de7095b8db415b147ce",
  measurementId: "G-YGJ34Z3P0L"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig)
const storage = getStorage(app);
export default storage;