import axios from "axios";

const NEWS_REST_API_URL = 'http://localhost:8000/news';
let user = localStorage.getItem('jwt_token');
   
class NewsService{

    
    getNews(){
        return axios.get(NEWS_REST_API_URL,{ headers: {"Authorization" : user} })
    }
    getNewsByCategory(category){
        return axios.get(NEWS_REST_API_URL+category,{ headers: {"Authorization" : user} })
    }

    getNewsByTag(tag){
        return axios.get(NEWS_REST_API_URL+tag,{ headers: {"Authorization" : user} })
    }
    createNews(imageUrl){
        let titleVal =document.getElementById("title").value;
        let contentVal = document.getElementById("content").value;
        let categoryVal = document.getElementById("category").value;

        let newsToSave = {title:titleVal,content:contentVal,category:categoryVal,user_id:1,image_url:imageUrl};
        return axios.post(NEWS_REST_API_URL+"/add",newsToSave,{ headers: {"Authorization": user}}
        ).then((response) => {
             window.location.href = "http://localhost:3000/";
          });
    }
}

export default new NewsService();