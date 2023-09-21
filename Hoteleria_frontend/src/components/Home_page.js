import React from 'react'
import { Link } from 'react-router-dom';

const Home_page = () => {
  return (
    <main>
      <section className='d-flex align-items-center col-12 min-vh-100 room'>
        <div className='col-6 room'>
          <div className='py-5'>
            <h1 className='display-1 font_wig'>Bienvenido a tu  <span className='underline'>Software de hoteleria</span></h1>
          </div>
          <div className='py-4'>
            <h4 className='font_size'>Estamos aquí para ayudarte en cada paso de tu formación y crecimiento en la industria hotelera.</h4>
          </div>
          <div className='py-5 col-12 d-flex justify-content-center '>
            <a className='py-5 my-5 col-5'>
            <svg xmlns="http://www.w3.org/2000/svg" class='svg_width' fill="currentColor" viewBox="0 0 16 16">
              <path d="M8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
            </svg>
              <h3 className='font_size py-4'>"La excelencia en la hospitalidad comienza con una educación sólida."</h3>
            </a>
            <a className='py-5 my-5 col-5'>
            <svg xmlns="http://www.w3.org/2000/svg" class='svg_width' fill="currentColor" viewBox="0 0 16 16">
              <path d="M11 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm-9 8c0 1 1 1 1 1h5.256A4.493 4.493 0 0 1 8 12.5a4.49 4.49 0 0 1 1.544-3.393C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4Zm9.886-3.54c.18-.613 1.048-.613 1.229 0l.043.148a.64.64 0 0 0 .921.382l.136-.074c.561-.306 1.175.308.87.869l-.075.136a.64.64 0 0 0 .382.92l.149.045c.612.18.612 1.048 0 1.229l-.15.043a.64.64 0 0 0-.38.921l.074.136c.305.561-.309 1.175-.87.87l-.136-.075a.64.64 0 0 0-.92.382l-.045.149c-.18.612-1.048.612-1.229 0l-.043-.15a.64.64 0 0 0-.921-.38l-.136.074c-.561.305-1.175-.309-.87-.87l.075-.136a.64.64 0 0 0-.382-.92l-.148-.045c-.613-.18-.613-1.048 0-1.229l.148-.043a.64.64 0 0 0 .382-.921l-.074-.136c-.306-.561.308-1.175.869-.87l.136.075a.64.64 0 0 0 .92-.382l.045-.148ZM14 12.5a1.5 1.5 0 1 0-3 0 1.5 1.5 0 0 0 3 0Z"/>
            </svg>
              <h3 className='font_size py-4'>"El conocimiento es el equipaje más valioso que puedes llevar en la industria hotelera."</h3>
            </a>
            
          </div>
          
        </div>
        <div className='col-6 d-flex justify-content-center'>
          <div className='col-6'>
            <div className='col-8 bg_color'>
              <div className='p-4'>
                <div className='div_w_two'></div>
              </div>
              <h3 className='font_size font_color px-4'>Aprendiz</h3>
              <p className='font_size_three px-4'>Iniciar sesion como aprendiz </p>
              <p className='font_size_two px-4'>Ingresa con tu cuenta sena</p>
              
              <div className='text-center px-5 py-3'>
                 <a className='div_w_four font_size font_color px-5' href="/login" role='button'>IR</a>
              </div>
            </div>
          </div>
          <div className='col-6'>
            <div className='col-8 bg_color_two'>
              <div className='p-4'>
                <div className='div_w_three'></div>
              </div>
              <h3 className='font_size font_color px-4'>Hotelería</h3>
              <p className='font_size_three px-4'>Explora la hospitalidad y forja tu futuro en la industria hotelera con nuestra plataforma educativa </p>
              
              <p className='font_size_three px-4 py-2'>Leer más -D</p>
              
            </div>
            <div className='col-8 bg_color_three'>
              <div className='p-4'>
                <div className='div_w_one'></div>
              </div>
              <h3 className='font_size font_color px-4'>Administrador</h3>
              <p className='font_size_three px-4'>Iniciar sesion como administrador </p>
              <p className='font_size_two px-4'>Ingresa con tu cuenta de instructor sena</p>
              <div className='text-center px-5 py-3'>
                 <a className='div_w_five font_color_two px-5' href="/AdminLogin" role='button'>IR</a>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
    
  )
}

export default Home_page