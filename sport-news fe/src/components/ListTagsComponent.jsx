import axios from "axios";
import React, { Component } from "react";

const TAG_NEWS_REST_API_URL = "http://localhost:8000/tagtonews";
export default class ListTagsComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tagToNews: []
    };
  }
  componentDidMount() {
    this.getTagToNewsByTag().then((response) => {
      this.setState({
        tagToNews: response.data,
      });
    });
  }

  getTagToNewsByTag() {
    let pathname = window.location.pathname;
    let link = TAG_NEWS_REST_API_URL + pathname;
    console.log(link)
    return axios.get(link, {
      headers: {
        Authorization: localStorage.getItem("jwt_token"),
      },
    });
  }

  render() {
    return (
      <div>
       <div>{ this.state.tagToNews && 
        this.state.tagToNews.map((tag, ind) => <div key={tag.news_id}>{tag.news_id}<br/>
        {tag.tag_id} <br/> {tag.tag_name} <br/><br/>
        </div>)}</div>
      </div>
    );
  }
}
