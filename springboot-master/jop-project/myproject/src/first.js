import React from "react"
class Menu extends React.Component{
    constructor(props){
        super(props);
        this.handlereq=this.handlereq.bind(this);
        this.setimage=this.setimage.bind(this);
        this.setname=this.setname.bind(this);
        this.setbrand=this.setbrand.bind(this);
        this.setperhour=this.setperhour.bind(this);
        this.state={name:"",
                   brand:"",
                   perhour:"",
                   image:null,}
    }
    setname(e){
     this.setState({
         name:e.target.value
     });
     console.log(e.target.value)
    }
    setbrand(e){
        console.log(e.target.value)
        this.setState({
            brand:e.target.value
        });

    }
    setperhour(e){
        console.log(e.target.value)
        this.setState({
            perhour:e.target.value
        });
    }
    setimage(e){
        console.log(e.target.files[0])
        this.setState({
            image:e.target.files[0]
        });
    }
    handlereq(e){
         var datasend = new FormData();
         datasend.append("name",this.state.name);
	     datasend.append("brand",this.state.brand);
	     datasend.append("file",this.state.image);
         datasend.append("perhour",this.state.perhour);
         datasend.append("user",datasend);
         fetch("http://localhost:8000/course",{
            method:"POST",
            body:datasend
            })
            .then((response)=>{response.json().then((res) => {
            console.log(res)
            window.location.href="http://localhost:3000/second"
            
            })
       })
       
    }
    render(){
        return(
        <div>
            <label>name</label><input type="text" id="name" name="name" onChange={this.setname}></input> <br/>
            <label>brand</label><input type="text" id="brand" name="brand" onChange={this.setbrand}></input> <br/>
            <label>perhour</label><input type="text" id="ph" name="perhour" onChange={this.setperhour}></input> <br/>
            <input type="file" id="image" name="file" onChange={this.setimage}></input> <br/>
            <input type="submit" onClick={this.handlereq}></input>
        </div>
        );
    };
};
export default Menu;