import React from 'react'
import "./Reservacion_Grupal.css";

const Reservacion_Grupal = () => {
  return (
    <main>  
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