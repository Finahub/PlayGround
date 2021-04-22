import { useState, useEffect } from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

// import BankTable from './components/BankTable';

import Home from './components/Home'
import lastPage from './components/LastPage'


// function App() {
//   return (
//     <div className="container">
//      <BankComponent />
//     </div>
//   );
// }

const App = () => {


  return (

    <Router>
      <div>
        {/* <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
            <li>
              <Link to="/users">Users</Link>
            </li>
          </ul>
        </nav> */}


        <Switch>
          {/* <Route path="/about">
            <About />
          </Route> */}
          <Route path="/lastPage">
            <lastPage />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        </Switch>
      </div>

    </Router>
  );

}

export default App;
