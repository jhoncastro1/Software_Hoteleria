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
import Exit_Pass from "./components/Exit_Pass";
import Register_Reservation from "./components/Register_Reservation";
import Register_Check_in from "./components/Register_Check_in";
import Register_Check_out from "./components/Register_Ckeck_out";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route
            path="/"
            element={
              <>
                <Navbar_Home /> {/* Se muestra solo en la página de inicio */}
                <Home />
              </>
            }
          />
          <Route path="/login" element={<Login />} />
          <Route path="/main" element={<Main/>} />
          <Route path="/adminLogin" element={<AdminLogin/>} />
          <Route path="/checkIn" element={<Check_in/>}/>
          <Route path="/reservacionGrupal" element={<Reservacion_Grupal/>}/>
          <Route path="/exitPass" element={<Exit_Pass/>}/>
          <Route path="/registroReservacion" element={<Register_Reservation/>}/>
          <Route path="/registroCheckIn" element={<Register_Check_in/>}/>
          <Route path="/registroCheckOut" element={<Register_Check_out/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
