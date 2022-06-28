import React, { Component } from 'react'
import img from "../288635276_412085557599535_2854637889399851132_n.jpg"
import '../css/maintry.css'

export default class MainNewsComponent extends Component {

  constructor(props){
    super(props)
    this.state = {
        news:[]
    }
}
  render() {
    return (
        <div id="mainfeature" className="main">
        <article id="feature.default.main" className=" active">
            <a className="post-category" href="https://dsport.bg/nacionalen-otbor~49287.html">Левски</a>				
            <a className="featureanchor" href="na-zivo-balgaria-izliza-za-toshko-i-chestta-si-srestu-gruzia-sastavi~84923.html">
                <div className="abstr-top"></div>
                <time datetime="2022-06-12 20:51:00">12 Юни | 20:51</time>
                <img src={img} alt="Левски представи официално Роналдо"/>
                <div className="abstr"></div>
                <h3 className="title">Левски представи официално Роналдо</h3>
            </a>
        </article>
    </div>
    )
  }
}
