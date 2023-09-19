import React from 'react'
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

const Home_page = () => {
  return (
    <div className='container'>
      <div className='col-lg-12'>
          Hola
      </div>
      
    

    <div className='container'>
      <div className='col-lg-6'>
        <p>Home_page</p>
          <Link to="/login" className="btn btn-primary" role="button">Boton para Login pruebas</Link>
          <Link to="/main" className="btn btn-primary" role="button">Boton para pagina principal pruebas</Link>
        </div>
      </div>
    </div>
  )
}

export default Home_page