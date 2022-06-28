import { useState, useEffect } from "react";
import {
  ref,
  uploadBytes,
  getDownloadURL,
  listAll,
  list,
} from "firebase/storage";
import storage  from "../services/firebase";
import { v4 } from "uuid";
import React from "react";
import NewsService from "../services/NewsService";

function UploadComponent() {
  const [imageUpload, setImageUpload] = useState(null);
  const [imageUrls, setImageUrls] = useState([]);
  const [imageUrl, setImageUrl] = useState("");

  const imagesListRef = ref(storage, "images/");
  const uploadFile = () => {
    if (imageUpload == null) return;
    const imageRef = ref(storage, `images/${imageUpload.name + v4()}`);
    uploadBytes(imageRef, imageUpload).then((snapshot) => {
      getDownloadURL(snapshot.ref).then((url) => {
        setImageUrl(url);
     
      });
    });
  };


  return (
    <div className="App">
        <label >Title</label>
        <input type="text" className="form-control" id="title"  placeholder="Title"/>


        <label >Content</label>
        <textarea type="text" className="form-control" id="content" placeholder="Content"/>

        <label >Category</label>
        <input type="text" className="form-control" id="category"  placeholder="Category"/>
        <input type="file" onChange={(event) => { setImageUpload(event.target.files[0]); }} />

        <button onClick={uploadFile}> Upload Image</button>

        <br/><br/>
        <button type="submit" className="btn btn-primary" onClick={() => NewsService.createNews(imageUrl)}>Create News</button>

    </div>
  );
}

export default UploadComponent;