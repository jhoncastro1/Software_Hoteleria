import React from 'react'
import './StylesPage.css'

const Main_Page = () => {
  return (
    <main>
      <section className='d-flex align-items-center col-12 min-vh-100 room'>
        <div className='col-6 room'>
          <div className='py-5'>
            <h1 className='display-1 font_wig'>Tú aprendizaje es lo <span className='underline'>Mas importante</span> Para nosotros</h1>
          </div>
          <div className='py-4'>
            <h4 className='font_size'>Estamos comprometidos en proporcionarte las herramientas y recursos necesarios para que alcances tus metas de formación en hotelería de la manera más efectiva y enriquecedora posible</h4>
          </div>
          <div className='py-5 col-12 d-flex justify-content-center text-center'>
            <a type='submit' href='/' className='py-5 my-5 col-4'>
              <svg xmlns="http://www.w3.org/2000/svg" class='svg_width' fill="currentColor" viewBox="0 0 16 16">
                <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zm-5.146-5.146-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708z"/>
              </svg>
              <h3 className='font_size py-4'>Reservacion</h3>
            </a>
            <a type='submit' href='/' className='py-5 my-5 col-4 border_sp'>
              <svg xmlns="http://www.w3.org/2000/svg" class='svg_width' fill="currentColor" viewBox="0 0 16 16">
                <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zm-5.146-5.146-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708z"/>
              </svg>
              <h3 className='font_size py-4'>Check-In</h3>
            </a>
            <a type='submit' href='/' className='py-5 my-5 col-4'>
              <svg xmlns="http://www.w3.org/2000/svg" class='svg_width' fill="currentColor" viewBox="0 0 16 16">
                <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zm-5.146-5.146-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708z"/>
              </svg>
              <h3 className='font_size py-4'>Check-out</h3>
            </a>
          </div>
          
        </div>
        <div className='col-6 d-flex justify-content-center'>
          <div className='col-6'>
            <div className='col-8 bg_color_three'>
              <div className='px-5 py-4'>
                <div className='div_w_one'></div>
              </div>
              <h3 className='font_size font_color px-5'>Reservacion</h3>
              <p className='font_size_letter px-5'>Es un acuerdo formal entre un cliente y un establecimiento</p>
              <div className='text-center'>
                <svg xmlns="http://www.w3.org/2000/svg" class='svg_width_one py-4' fill="currentColor" viewBox="0 0 16 16">
                  <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zm-5.146-5.146-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708z"/>
                </svg>
              </div>
            </div>
          </div>
          <div className='col-6'>
            <div className='col-8 bg_color'>
              <div className='px-5 py-4'>
                <div className='div_w_two'></div>
              </div>
              <h3 className='font_size font_color px-5'>Check-In</h3>
              <p className='font_size_letter px-5'>Es un acuerdo formal entre un cliente y un establecimiento</p>
              <div className='text-center'>
                <svg xmlns="http://www.w3.org/2000/svg" class='svg_width_one py-4' fill="currentColor" viewBox="0 0 16 16">
                  <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zm-5.146-5.146-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708z"/>
                </svg>
              </div>
            </div>
            <div className='p-4'></div>
            <div className='col-8 bg_color_three'>
              <div className='px-5 py-4'>
                <div className='div_w_three'></div>
              </div>
              <h3 className='font_size font_color px-5'>Check-out</h3>
              <p className='font_size_letter px-5'>Es un acuerdo formal entre un cliente y un establecimiento</p>
              <div className='text-center'>
                <svg xmlns="http://www.w3.org/2000/svg" class='svg_width_one py-4' fill="currentColor" viewBox="0 0 16 16">
                  <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zm-5.146-5.146-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708z"/>
                </svg>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  )
}

export default Main_Page