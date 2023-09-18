import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

import Home from "./components/Home_page";
import Login from "./components/Login";
import Main from "./components/Main_Page";
import Check from "./components/Check_in";
import Navbar_Home from "./components/Navbar_Home";


function App() {
  return <div className="App">
    <Navbar_Home/>
    <Home/>
    <Login/>
    <Main/>
    <Check/>
    
  </div>;
  
}

export default App;
