import React from "react";
import ViewItem from "./ViewItem";
// import './View.css';
import axios from "axios";
import ReactDOM from "react-dom";


class ListViews extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            data: []

        }
    }

    componentDidMount() {
        axios.get(this.props.url)
            .then(res => {
                const data = res.data.subjects;
                this.setState({data});
            })
    }

    render() {
        return (
            <div>
                <div className="title"><h2>{this.props.title}</h2></div>
                <div className="ListView">
                    {this.state.data.map((item, index) => (
                        <ViewItem key={index} url={item.url} cover={item.cover} title={item.title} rate={item.rate}
                                  id={item.id}/>
                    ))}
                </div>
            </div>
        );
    }


}

const ListView = ReactDOM.createRoot(document.getElementById('root'));
ListView.render(
    <ListViews />,
    document.getElementById('root')
);
export default ListViews;