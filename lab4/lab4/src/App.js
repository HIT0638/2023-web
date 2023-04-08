import './App.css';
import ListView from "./components/ListView";
import axios  from "axios";
import {render} from "react-dom";
import {useEffect, useState} from "react";
function App(props) {

    let movieUrl = "http://172.17.237.245:8080/hit/DoubanServlet?type=movie";
    let tvUrl = "http://172.17.237.245:8080/hit/DoubanServlet?type=tv";

    return (
        <div className="App">
            <ListView title="电影"  url={movieUrl} />
            <ListView title="电视剧" url={tvUrl} />
        </div>
    );
}

export default App;
