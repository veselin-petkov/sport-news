import React from "react";
import NewsService from "../services/NewsService";



class NewsComponent extends React.Component {
    
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

  logOut(){
      localStorage.clear();
      window.location.href = "http://localhost:3000/login"
  }
  render() {
    return (
      <div>
        <h1 className="text-center">News</h1>
        <table className="table table-striped">
          <thead>
            <tr>
              <td>News Title</td>
              <td>News content</td>
              <td>News views</td>
              <td>News votes</td>
              <td>News date</td>
              <td>News category</td>
              <td>News user_id</td>
            </tr>
          </thead>
          <tbody>
            {this.state.news.map((news) => (
              <tr key={news.id}>
                <td> {news.title}</td>
                <td> {news.content}</td>
                <td> {news.views}</td>
                <td> {news.votes}</td>
                <td> {news.date}</td>
                <td> {news.category}</td>
                <td> {news.user_id}</td>
              </tr>
            ))}
          </tbody>
        </table>
        <button onClick={this.logOut}>Log Out</button>

      </div>
    );
  }
}

export default NewsComponent;
