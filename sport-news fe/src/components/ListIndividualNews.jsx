import React, { Component } from "react";
import axios from "axios";
import "../css/maintry.css"

const GET_NEWS_URL = "http://localhost:8000";
const TAG_NEWS_REST_API_URL = 'http://localhost:8000/tagtonews';

export default class ListIndividualNews extends Component {
  constructor(props) {
    super(props);
    this.state = {
      news: "",
      tags: []
    };
  }

  componentDidMount() {
    this.getNews().then((response) => {
      this.setState({
        news: response.data,
      });
    });
    this.getNewsTags().then((response) => {
        this.setState({
          tags: response.data,
        });
      });
  }

  getNews() {
    let pathname = window.location.pathname;
    let link = GET_NEWS_URL + pathname;
    return axios.get(link, {
        headers: {
          Authorization: localStorage.getItem("jwt_token"),
        },
      });
  }

  getNewsTags(){
    let pathname = window.location.pathname;
    return axios.get(TAG_NEWS_REST_API_URL+pathname, {
        headers: {
          Authorization: localStorage.getItem("jwt_token"),
        },
      });

  }

  reditectToTag(props){
    window.location.href = "http://localhost:3000/tag/" + props;
  }

  render() {
    return (
        <div>
        <div className="individual-news">
          <div className="header">
            <div>{this.state.news.title}</div>
            <img src={this.state.news.image_url} className="news-image"/>
            <hr className="bar"></hr>
            <div>{this.state.news.content}</div>
            <div>Category:     {this.state.news.category}</div>
            <div > Tags:{this.state.tags && 
                this.state.tags.map((tag, ind) => <div className="tags" key={tag.tag_id} onClick={() => this.reditectToTag(tag.tag_id)}>{tag.tag_name}</div>)}    </div>
          </div>
          {/* { onClick={window.location.href = "http://localhost:3000/tag/"}} */}
        </div>
      </div>
    );
  }
}
