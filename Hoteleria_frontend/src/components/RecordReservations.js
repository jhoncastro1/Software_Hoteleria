import React, {useState } from 'react';
import "./Exit_Pass.css";
const RecordReservation = () =>{
   

    return(
        <>
        <div className="row m-3">
          <img src="your_image_url_here" alt="Your Image" className="IMG" />
          <h5 className='display-4 font_wig'>
                <div className='underline-up'><span className="palabra">Record de Reservacion</span><div className="subrayado-OutletPass"></div ></div> 
              </h5> 
          <a className="nav-link active col-md-1">DESCARGAR</a>
          <a className="nav-link active col-md-2">CORREO</a>
        </div>
  
        <nav className="navbar navbar-formatos navbar-expand-lg justify-content-center mx-auto p-2">
          <div className="container-fluid">
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div
              className="collapse navbar-collapse justify-content-start"
              id="navbarNav"
            >
              <ul className="navbar-nav fw-bold">
                <li className="nav-item">
                  <a className="nav-link active text-white">Reservacion</a>
                </li>
              </ul>
            </div>
            <div
              className="collapse navbar-collapse justify-content-end"
              id="navbarNav"
            >
              <ul className="navbar-nav fw-bold">
                <li className="nav-item">
                  <a className="nav-link active text-white" href="#">
                    View Other Formats
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
  
        <hr className="border border-dark" />
  <div className="container">
      <section className="Seccion-Pass col-md-7 offset-md-3 d-flex align-items-center justify-content-center">
      <div className="container-Exit-pass m-4">
      <form className="row">
      <div className="card d-flex align-items-center justify-content-center border border-dark">
              <div className="card-body">
                <h5 className="card-title">Record de Reservacion</h5>
              </div>
            </div>
           
            <div className="col-md-8 border border-dark">
              <label htmlFor="nameCustomer" className="form-label-Nombre">
                Nombre Completo
              </label>
              <input
                type="text"
                className="form-control form-control-nombre border-top-0 border-end-0 border-start-0 border-dark"
              />
            </div>
            
            <div className="col-md-4 border border-dark">
              <label htmlFor="date" className="form-label">
                Fecha de llegada:
              </label>
              <input
                type="date"
                className="form-control form-control-nombre border-0"
              />
            </div>

            <div className="col-md-6 border border-dark">
              <label htmlFor="nameCustomer" className="form-label-Nombre">
                Direccion
              </label>
              <input
                type="text"
                className="form-control form-control-nombre border-top-0 border-end-0 border-start-0 border-dark"
              />
            </div>

            <div className="col-md-6 border border-dark">
              <label htmlFor="nameCustomer" className="form-label-Nombre">
                Telefono
              </label>
              <input
                type="text"
                className="form-control form-control-nombre border-top-0 border-end-0 border-start-0 border-dark"
              />
            </div>

            <div className="col-md-8 border border-dark">
              <label htmlFor="nameCustomer" className="form-label-Nombre">
                Reserva:
              </label>
              <input
                type="text"
                className="form-control form-control-nombre border-top-0 border-end-0 border-start-0 border-dark"
              />
            </div>
            
            <div className="col-md-4 border border-dark">
              <label htmlFor="date" className="form-label">
                Fecha de Salida:
              </label>
              <input
                type="date"
                className="form-control form-control-nombre border-0"
              />
            </div>

            <div className="col-md-6 border border-dark">
            <label className="form-label">Tipo de habitacion</label>
            <select
              className="form-select-Key form-select-md mg-3 form-control border border-dark"
              aria-label=".form-select-lg example"
              name="keyRoom"
            >
              <option value="SGL">SGL</option>
              <option value="DBL">DBL</option>
              <option value="TWIN">TWIN</option>
              <option value="TPL">TPL</option>
              <option value="JRS">JRS</option>
              <option value="STE">STE</option>


            </select>
            </div>

            <div className="col-md-6 border border-dark">
              <label htmlFor="guestsCount" className="form-label">
                Numero de huespedes
              </label>
              <input
                type="number"
                className="form-control form-control-nombre border-0"
                id="guestsCount"
                name="guestsCount"
              />
            </div>
      </form>
        </div>
      </section>
      </div>
  </>
       
    );
};

export default RecordReservation;