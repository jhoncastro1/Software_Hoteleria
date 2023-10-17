import React from "react";
import "./Exit_Pass.css";

const Exit_Pass = () => {
    return(
      <>
      <div className="row m-3">
        <img className="IMG"></img>
        <h1 className="Titulo_Exit_Pass">Pase de Salida</h1>
          <a class="nav-link active col-md-1">Descargar</a>
          <a class="nav-link active col-md-2">Correo Electronico</a>
          <a class="nav-link active col-md-1">Guardar</a>
      </div>



      <nav class="navbar navbar-formatos navbar-expand-lg justify-content-center mx-auto p-2">
        <div class="container-fluid ">
        
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-start" id="navbarNav">
            <ul class="navbar-nav fw-bold">
              <li class="nav-item">
                <a class="nav-link active text-white">Check Out</a>
              </li>
            </ul>
          </div>
          <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav fw-bold">
              <li class="nav-item">
              <a class="nav-link active text-white" href="#">Ver Otros Formatos</a>
              </li>
            </ul>
          </div>

        </div>
      </nav>
      <hr className=" border-dark" ></hr>
      
      <section className="Seccion-Pass col-md-7 offset-md-3 d-flex align-items-center justify-content-center">

          <div className="container-Exit-pass m-3">

            <form class="row g-3">

              <div class="card col-md-6 offset-md-3 d-flex align-items-center justify-content-center border-dark">
                <div class="card-body">
                  <h4 class="card-title ">PASE DE SALIDA</h4>
                </div>
              </div>

              <div class="col-md-12">
                <label for="input" class="form-label-Nombre">NOMBRE DE HÚESPED</label>
                <input type="text" class="form-control form-control-nombre border-top-0 border-end-0 border-start-0 border-dark" id="input"></input>
              </div>
              <div class="col-md-4 border-end border-start border-bottom border-dark">
                <label for="input" class="form-label">FECHA:</label>
                <input type="date" class="form-control form-control-nombre border-0 " id="input"></input>
              </div>
              <div class="col-md-4 border-end border-bottom border-dark">
                <label for="input" class="form-label">NÚMERO DE HABITACIÓN</label>
                <input type="number" class="form-control form-control-nombre border-0 " id="input"></input>
              </div>
              <div class="col-md-4 border-end border-bottom border-dark">
                <label for="input" class="form-label">NÚMERO DE PERSONAS</label>
                <input type="number" class="form-control form-control-nombre border-0 " id="input"></input>
              </div>
              <label for="input" class="form-label">¿Dejó su llave?</label>
              <select class="form-select-Key form-select-md mg-3 form-control border-dark" aria-label=".form-select-lg example">
                <option selected="1">Si</option>
                <option value="2">No</option>
              </select>
              <div class="col-md-6">
                <label for="input" class="form-label">FIRMA DEL CAJERO</label>
                <input type="text" class="form-control form-control-nombre border-top-0 border-end-0 border-start-0 border-dark" id="input"></input>
              </div>
              <div class="col-md-6">
                <label for="input" class="form-label">SELLO DE CAJAS</label>
                <input type="text" class="form-control form-control-nombre border-top-0 border-end-0 border-start-0 border-dark" id="inputPassword4"></input>
              </div>
            </form>
          </div>
        </section></>
    
    )
}

export default Exit_Pass;

//<Route path="/exitPass" element={<Exit_Pass/>}/>
//import Exit_Pass from "./components/Exit_Pass";