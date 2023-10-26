import React from 'react'
import "./Reservacion_Grupal.css";

const Reservacion_Grupal = () => {
  return (
    <main> 

        <section className='col-lg-12 d-flex'>
            <div className='col-lg-12 row'>
                <div className='col-lg-6'>
                    <h2>
                    <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="40" height="40" viewBox="0 0 48 48">
                    <path fill="#43a047" d="M37,45H11c-1.657,0-3-1.343-3-3V6c0-1.657,1.343-3,3-3h19l10,10v29C40,43.657,38.657,45,37,45z"></path><path fill="#c8e6c9" d="M40 13L30 13 30 3z"></path><path fill="#2e7d32" d="M30 13L40 23 40 13z"></path><path fill="#e8f5e9" d="M31,23H17h-2v2v2v2v2v2v2v2h18v-2v-2v-2v-2v-2v-2v-2H31z M17,25h4v2h-4V25z M17,29h4v2h-4V29z M17,33h4v2h-4V33z M31,35h-8v-2h8V35z M31,31h-8v-2h8V31z M31,27h-8v-2h8V27z"></path>
                    </svg>
                        Reserva grupal
                    </h2>
                </div>
                <div className='col-lg-6'>
                    
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                    </svg>
                </div>
            </div>


        </section> 
        <section className='col-lg-12 d-flex justify-content-center'>
            <div className='col-lg-8  border_special '>
                <div className='col-lg-12 d-flex'>
                    <h2 className='col-lg-6 text-center'>Instructivo de grupos</h2>
                    <div className='col-lg-3 d-flex'>
                        <p className='font_size_one'>LLEGA</p>
                        <input className='input_special'></input>
                    </div>
                    <div className='col-lg-3 d-flex'>
                        <p className='font_size_one'>HORA</p>
                        <input className='input_special'></input>
                    </div>
                </div>
                <div className='col-lg-12 d-flex'>
                    
                    <div className='col-lg-6 d-flex'>
                        <p className='font_size_one padding-left'> NOMBRE DEL GRUPO</p>
                        <input className='input_special'></input>
                    </div>
                    <div className='col-lg-3 d-flex'>
                    <p className='font_size_one'>SALE</p>
                        <input className='input_special'></input>
                    </div>
                    <div className='col-lg-3 d-flex'>
                        <p className='font_size_one'>HORA</p>
                        <input className='input_special' type=''></input>
                    </div>
                </div>
                <div className='col-lg-12 d-flex border_top'>
                <div className='col-lg-7'>
                    <div className=' col-12 border_special_2'>
                            <p className='font_size_one'>NOMBRE DEL CONDUCTOR DEL GRUPO:  </p>
                            <input className='input_none' type='text'></input>  
                    </div>
                    <div className='border_special_2 '> 
                            <p className='font_size_one'>PAGA: </p>
                            <input className='input_none number' type='Number'></input> 
                    </div>
                </div>
                <div className='col-lg-5 d-flex'>
                    
                </div>
            </div>
            </div>
        </section>
    </main>
    
  )
}

export default Reservacion_Grupal