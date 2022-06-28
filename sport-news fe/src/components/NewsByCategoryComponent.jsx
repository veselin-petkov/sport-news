import React, { Component ,fetchData , useEffect} from "react";
import { useLocation } from 'react-router-dom';
import NewsService from '../services/NewsService';
import '../css/maintry.css'

export default class NewsByCategoryComponent extends Component {

  constructor(props) {
    super(props);
    this.state = {
      news: [],
    };
  }

  componentDidMount() {

    NewsService.getNewsByCategory(window.location.pathname).then((response) => {
      this.setState({ news: response.data });
    });
  }

  render() {
    const dateOpions = { month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit'};
    //window.location.reload
    return (
      <div>
        {this.state.news.map((news) => (
          <article id="feature-list-news" className=" active">
            <a
              className="post-category"
            href={"http://localhost:3000/category/"+news.category}
            >
              {news.category}
            </a>
            <a className="featureanchor" href={"http://localhost:3000/news/"+news.id}>
              <div className="abstr-top"></div>
              <time datetime="2022-06-12 20:51:00">
                {new Date(news.date).toLocaleDateString("bg-BG", dateOpions)}
              </time>
              <img
                src={news.image_url}
                alt="България сложи край на юнските мъки с хикс срещу Грузия"
              />
              <div className="abstr"></div>
              <h3 className="title">{news.title}</h3>
            </a>
          </article>
        ))}
      </div>
    );
  }
}
