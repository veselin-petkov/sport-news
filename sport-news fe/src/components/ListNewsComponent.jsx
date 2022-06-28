import React, { Component } from 'react'
import img from "../9468647.m.webp"
import NewsService from '../services/NewsService';
import '../css/maintry.css'


export default class ListNewsComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
          news:[],
        };
      }

    componentDidMount() {
        NewsService.getNews().then((response) => {
          this.setState({ news: response.data });
        });
    }

  render() {
    const dateOpions = { month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit'};
    let hrefPath="/news/";

    return (
      <div className='list-news'>
         {this.state.news.map((news) => (
        <article id="feature-list-news" className=" active">
            <a className="post-category" href={"http://localhost:3000/category/"+news.category}>{news.category}</a>				
            <a className="featureanchor" href={hrefPath+news.id}>
                <div className="abstr-top"></div>
                <time datetime="2022-06-12 20:51:00">{new Date(news.date).toLocaleDateString("bg-BG", dateOpions)}</time>
                <img src={news.image_url} alt="България сложи край на юнските мъки с хикс срещу Грузия"/>
                <div className="abstr"></div>
                <h3 className="title">{news.title}</h3>
            </a>
        </article>
 ))}
      </div>
    )
  }
}
