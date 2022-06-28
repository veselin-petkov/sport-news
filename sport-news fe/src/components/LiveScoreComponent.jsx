import "../css/livescore.css"
import React, { Component } from 'react'
let axios = require("axios").default;

const LIVE_SCORE_API_URL = "http://localhost:8000/livescore"
let user = localStorage.getItem('jwt_token');

export default class LiveScoreComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
          games: []
        };
      }


    componentDidMount() {
        this.getLiveGames().then((response) => {
          this.setState({
            games: response.data.events
          });
        });
    }

  getLiveGames(){
    return axios.get(LIVE_SCORE_API_URL,{
      headers: {"Authorization" : user}
      });

}
  render() {
    return (
      <div className='livescore'>Live Matches
       <hr className="bar"></hr>
      
      <div>{ this.state.games && 
        this.state.games.map((game, ind) => <div key={game.id}>{game.tournament.name} - {game.tournament.category.name}<br/>
        {game.homeTeam.shortName} {game.homeScore.current} -  {game.awayScore.current} {game.awayTeam.shortName} <br/><br/></div>)}</div>
    
      
      </div>
    )
  }
}
