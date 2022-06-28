import React, { Component } from 'react'
import img1 from "../33_3.m.webp"
import img2 from "../290179.m.webp"
import '../css/maintry.css'


export default class SideNewsComponent extends Component {
  render() {
    return (
        <div id="sidenews" className="list">
        <article id="feature.0" className=" " data-img="/media/160/33~3.m.webp">
          <a className="post-category" href="https://dsport.bg/levski.html">Левски</a>			
          	<a className="featureanchor" href="hose-kordoba-zapochna-podgotovka-s-levski~84972.html">
            <div className="abstr-top"></div>
            <time datetime="2022-06-13 10:43:00">13 Юни | 10:43</time>
            <img className="thumb" src={img1} alt="Хосе Кордоба започна подготовка с Левски"/>
            <div className="abstr"></div>
            <h3 className="title">Хосе Кордоба започна подготовка с Левски</h3>	
          </a>
        </article>
        <article id="feature.1" className=" " data-img="/media/160/290179.m.webp">
          <a className="post-category" href="https://dsport.bg/ludogorec.html">Лудогорец</a>		
          		<a className="featureanchor" href="ludogorec-razpila-strumska-slava-v-mach-s-mnogo-krasivi-golove-za-start-na-podgotovkata~84981.html">
            <div className="abstr-top"></div>
            <time datetime="2022-06-13 12:23:27">13 Юни | 12:23</time>
            <img className="thumb" src={img2} alt="Лудогорец разпиля Струмска слава в мач с много красиви голове за старт на подготовката"/>
            <div className="abstr"></div>
            <h3 className="title">Лудогорец разпиля Струмска слава в мач с много красиви голове за старт на подготовката</h3>	
          </a>
        </article>
      </div>
    )
  }
}
