import React, { Component } from 'react';
import NewsService from '../services/NewsService';
import storage from "../services/firebase";
import { ref,uploadBytesResumable ,getDownloadURL } from "firebase/storage";
import { useState } from "react";

// const [file, setFile] = useState("");
// // progress
// const [percent, setPercent] = useState(0);
// // Handle file upload event and update state
// function handleChange(event) {
//     setFile(event.target.files[0]);
// }

// const handleUpload = () => {
//     if (!file) {
//         alert("Please upload an image first!");
//     }

//     const storageRef = ref(storage, `/files/${file.name}`);

//     // progress can be paused and resumed. It also exposes progress updates.
//     // Receives the storage reference and the file to upload.
//     const uploadTask = uploadBytesResumable(storageRef, file);

//     uploadTask.on(
//         "state_changed",
//         (snapshot) => {
//             const percent = Math.round(
//                 (snapshot.bytesTransferred / snapshot.totalBytes) * 100
//             );

//             // update progress
//             setPercent(percent);
//         },
//         (err) => console.log(err),
//         () => {
//             // download url
//             getDownloadURL(uploadTask.snapshot.ref).then((url) => {
//                 console.log(url);
//             });
//         }
//     );
// };

class CreateNewsComponent extends Component {


    render() {

        

        return (
            <div>
                <label >Title</label>
                <input type="text" className="form-control" id="title"  placeholder="Title"/>


                <label >Content</label>
                <input type="text" className="form-control" id="content" placeholder="Content"/>

                <label >Category</label>
                <input type="text" className="form-control" id="category"  placeholder="Category"/>
                
                <button type="submit" className="btn btn-primary" onClick={NewsService.createNews}>Create News</button>

            </div>
        );
    }
}

export default CreateNewsComponent;