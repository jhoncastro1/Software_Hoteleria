import React from 'react'
import SenaLogo from '../images/LogoSena.png';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

import './Navbar_Home.css'

const Navbar_Home = () => {
    return (
        <nav className="navbar navbar-expand-sm">
          <a className="navbar-brand">
            <img src={SenaLogo} width="50" height="50" className="img-fluid" />
          </a>
          
          <div className="navbar-collapse nav-link d-flex align-items-center justify-content-center">
            <ul className="navbar-nav mx-auto justify-content-center">
              <li className="nav-item bold">
                <a className="nav-link" href="#">Regional Tolima</a>
              </li>
              <li className="nav-item bold">
                <a className="nav-link" href="#">Conoce más</a>
              </li>
              <li className="nav-item bold">
                <a className="nav-link" href="#">Hotelería</a>
              </li>
            </ul>
          </div>
        </nav>
      );
    }

export default Navbar_Home