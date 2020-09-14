import React from "react"
class Third extends React.Component{
    constructor(props){
        super(props)
        this.got=this.goto.bind(this)
    }
    goto(){
        window.location.href="http://localhost:3000/second";
    };
    render(){
        return(
            <div>
            <button onClick={this.goto}>gotosecond</button>
            <h1>hello{this.props.num}</h1>
            </div>
        );
    }
}
export default Third;