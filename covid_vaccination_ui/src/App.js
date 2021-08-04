import React from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from "./components/Login/login";
import Header from "./components/Header/header";
import SignUp from "./components/Login/signup";
import Home from "./components/Home/home";
import UpdateUser from "./components/Login/update_user1";
import { DeleteForeverOutlined } from "@material-ui/icons";
import Receiver from "./components/Receiver/receiver";
import UpdateReceiver from "./components/Receiver/update._receiver";
import Vaccination from "./components/Vaccination/vaccination"
import VaccinationUpdate from "./components/Vaccination/vaccine_update"
import DataTable from "./components/utils/dataTable";

const App = () => {

  return (
        <>
          <Router>
            <div className="app">
            {/* <Header /> */}
              <Switch>
                <Route exact path="/">
                  <Header />
                </Route>
                <Route exact path="/login">
                  <Login />
                </Route>
                <Route exact path="/signUp">
                  <SignUp />
                </Route>
                {/* <Route exact path="/table">
                  <DataTable />
                </Route> */}
                <Route exact path="/home">
                  <Home />
                </Route>
                <Route exact path="/receiver">
                  <Receiver />
                </Route>
                <Route exact path="/update_user1">
                  <UpdateUser />
                </Route>
                <Route exact path="/update_receiver">
                  <UpdateReceiver />
                </Route>
                <Route exact path="/vaccination">
                  <Vaccination />
                </Route>
                <Route exact path="/vaccine_update">
                  <VaccinationUpdate />
                </Route>
                

              </Switch>
            </div>
          </Router>
        </>
  );
};

export default App;