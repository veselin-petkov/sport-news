import axios from "axios";

const TAG_NEWS_REST_API_URL = 'http://localhost:8000/tagtonews';
let user = localStorage.getItem('jwt_token');


class TagNewsService{

    getTagToNewsByNews(){
        return axios.get(TAG_NEWS_REST_API_URL+"/news/",{ headers: {"Authorization" : user} })
    }

    getTagToNewsByTag(){
        return axios.get(TAG_NEWS_REST_API_URL+"/tag/",{ headers: {"Authorization" : user} })
    }


}
export default TagNewsService;