import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";

import Home from "./components/Home_page";
import Login from "./components/Login";
import Navbar_Home from "./components/Navbar_Home";
import Main from "./components/Main_Page";
import AdminLogin from "./components/AdminLogin";
import Check_in from "./components/Check_in";
import Reservacion_Grupal from "./components/Reservacion_Grupal";
import ReservationForm from "./components/Reservation/Reservation";
import Exit_Pass from "./components/Exit_Pass";
function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/"element={
              <>
                <Navbar_Home /> {/* Se muestra solo en la página de inicio */}
                <Home />
              </>
            }
          />
          <Route path="/reservation" element={<ReservationForm/>}/>
          <Route path="/login" element={<Login />} />
          <Route path="/main" element={<Main/>} />
          <Route path="/adminLogin" element={<AdminLogin/>} />
          <Route path="/checkIn" element={<Check_in/>}/>
          <Route path="/reservacionGrupal" element={<Reservacion_Grupal/>}/>
          <Route path="/exitPass" element={<Exit_Pass/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
