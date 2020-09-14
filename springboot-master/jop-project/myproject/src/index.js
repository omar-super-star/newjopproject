import React from "react"
import ReactDOM from "react-dom"
import Menu from "./first"
import Second from "./second"
import { Switch, Route,BrowserRouter as Router} from "react-router-dom"
import Third from "./third"
import 'bootstrap/dist/css/bootstrap.min.css';

import "./index.css"
class Root extends React.Component{
    render(){
        return(
            <Router>
            <Switch>
                <Route exact path="/">
                    <Menu/>
                </Route>
                <Route exact path="/second">
                       <Second/>
                </Route>
            </Switch>
            </Router>
        )
    }
}

ReactDOM.render(<Root />,document.getElementById("root"));