import React from "react"
class Second extends React.Component{
    constructor(props){
        super(props)
        this.state={name:"",
            brand:"",
            perhour:"",
            iamge:"",
        }
    }
    componentDidMount(){
        fetch("http://localhost:8000/senddata")
        .then((response)=>{response.json().then(
            (res) =>
                  {

                  this.setState({name:res["name"],
                  brand:res["brand"],
                  perhour:res["perhour"],
                  image:"http://localhost:8000/image/"+res.file.filename
                })

                  }
                  )
             });
    }
    render(){
        return(
            <div>
            <h1>name</h1>
            <p>{this.state.name}</p>
            <h1>brand</h1>
            <p>{this.state.brand}</p>
            <h1>perhour</h1>
            <p>{this.state.perhour}</p>
            <h1>image</h1>
            <img src={this.state.image} width="250" height="250" />
            </div>
           
        )
    }
}
export default Second;