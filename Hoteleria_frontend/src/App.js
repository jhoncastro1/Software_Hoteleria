import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";

import Home from "./components/Home_page";
import Login from "./components/Login";
import NavbarHome from "./components/Navbar_Home";
import Main from "./components/Main_Page";
import AdminLogin from "./components/AdminLogin";
import CheckIn from "./components/Check_in";
import ReservacionGrupal from "./components/Reservacion_Grupal";
import CheckOut from "./components/Check-out";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/"element={
              <>
                <NavbarHome /> {/* Se muestra solo en la página de inicio */}
                <Home />
              </>
            }
          />
          <Route path="/login" element={<Login />} />
          <Route path="/main" element={<Main/>} />
          <Route path="/adminLogin" element={<AdminLogin/>} />
          <Route path="/checkIn" element={<CheckIn/>}/>
          <Route path="/reservacionGrupal" element={<ReservacionGrupal/>}/>
         <Route path="/checkOut" element={<CheckOut/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
