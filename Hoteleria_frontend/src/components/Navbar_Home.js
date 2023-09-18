import React from 'react'

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

import './Navbar_Home.css'

const Navbar_Home = () => {
    return (
        <nav className="navbar navbar-expand-sm">
          <a className="navbar-brand">
            <img src="../images/SenaLogo.png" width="50" height="30" />
          </a>
          <div className="navbar-collapse">
            <ul className="navbar-nav mx-auto">
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