import React from "react";
import { BrowserRouter as Router, Route, Routes, Redirect, Switch, Navigate } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";


import Login from "./components/Login";
import Main from "./components/Main_Page";
import AdminLogin from "./components/AdminLogin";

import CheckIn from "./components/Check_in";
import ListaHuespedes from "./components/ListaHuespedes";
import RecordReservations from "./components/RecordReservations";
import ReservacionGrupal from "./components/Reservacion_Grupal";
import CustomerList from "./components/AccommodationContract";
import CheckOut from "./components/Check_Out";
import ExitPass from "./components/Exit_Pass";
import PageAdmin from "./components/Page_Admin";
import Home_page from "./components/Home_page";
import HotelRegistration from "./components/HotelRegistration";
import RackReservation from "./components/RackReservation";
import Facturacion from "./components/Facturacion";
import Reservacion from "./components/Reservacion";

function App() {
  const jwtToken = localStorage.getItem('jwtToken');
  console.log(jwtToken);
  let role = "";


  function isTokenExpired(jwtToken) {
    if (!jwtToken) {
      // Handle the case where jwtToken is null or undefined
      return false;
    }
    try {
      const arrayToken = jwtToken.split(".");
      const tokenPayload = JSON.parse(atob(arrayToken[1]));
      role =
        tokenPayload[
        "http://localhost:8080/mensaje"
        ];
      return Math.floor(new Date().getTime() / 1000) >= tokenPayload?.sub;
    } catch (error) {
      console.error('Error decoding token:', error);
      return false;
    }
  }

  isTokenExpired(jwtToken);

  // Función para verificar si el usuario ha iniciado sesión
  const isAuthenticated = () => {
    // Obtiene el token JWT del almacenamiento local

    if (jwtToken) {
      try {
        const tokenData = JSON.parse(atob(jwtToken.split('.')[1]));
        const tokenExpiration = new Date(tokenData.exp * 1000);
        const currentDate = new Date();

        if (currentDate < tokenExpiration) {
          return true;
        }
      } catch (error) {
        console.error('Error al decodificar el token JWT:', error);
      }
    }



    // Si no hay token o ha expirado, el usuario no está autenticado
    return false;


  };

  const ProtectedRoute = ({ element, path, ...props }) => {
    return isAuthenticated() ? (
      // Check if the user has the 'Admin' role before rendering the element
      (role === 'Admin') ? element : <Home_page to="/homePage" />
    ) : (
      <Home_page to="/homePage" /> // Redirect to login if not authenticated
    );
  };

  return (
    <Router>
      <div>
        <Routes>
          {/* Route for the login page */}
          <Route path='/homePage' element={<Home_page />} />
          <Route path='/login' element={<Login />} />
          <Route path="/adminLogin" element={<AdminLogin />} />


          {/* Default route with the sidebar and navbar */}
          <Route
            path='/*'
            element={
              isAuthenticated() ? (
                <div>
                  <div className="container min-vw-100" id="container-dad" style={{ padding: "0", margin: "0" }}>
                    <Routes>
                      {/* Route for the home page */}
                      <Route
                        path='/homePage'
                        element={<Home_page />}
                      />
                      <Route
                        path="/PageAdmin"
                        element={<ProtectedRoute element={<PageAdmin />} path="/PageAdmin" />}
                      />

                      {/* Other protected routes */}
                      <Route path="/login" element={<Login />} />
                      <Route path="/listaHuespedes" element={<ListaHuespedes />} />
                      <Route path="/RackReservation" element={<RackReservation />} />
                      <Route path="/main" element={<Main />} />
                      <Route path="/hotelRegistration" element={<HotelRegistration />} />
                      <Route path="/checkIn" element={<CheckIn />} />
                      <Route path="/CustomerList" element={<CustomerList />} />
                      <Route path="/reservacionGrupal" element={<ReservacionGrupal />} />
                      <Route path="/checkOut" element={<CheckOut />} />
                      <Route path="/exitPass" element={<ExitPass />} />
                      <Route path="/PageAdmin" element={<PageAdmin />} />
                      <Route path="/RecordReservations" element={<RecordReservations />} />
                      <Route path="/facturacion" element={<Facturacion />} />
                      <Route path="/reservacion" element={<Reservacion />} />

                    </Routes>
                  </div>
                </div>
              ) : (
                <Navigate to="/homePage" /> // Redirect to login if not authenticated
              )
            }
          />
        </Routes>
      </div>
    </Router>
  );

}
export default App;

