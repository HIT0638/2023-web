import React from "react";
// import './View.css';
function ViewItem(props){
    console.log(props);
    return (
        <div className="ViewItem">
            <a href={props.url} target="_blank"><img src={props.cover}/></a>
            <div className="txt">
                <a href={props.url} target="_blank">{props.title}</a>
                <div id="rate">  评分:{props.rate}</div>
            </div>
        </div>
    );
}

export default ViewItem;