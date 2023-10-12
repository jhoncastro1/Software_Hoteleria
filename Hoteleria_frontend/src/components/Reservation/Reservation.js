import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
function ReservationForm() {
    const [formData, setFormData] = useState({
      reservation_id: '',
      reservation_date: '',
      check_in_date: '',
      check_out_date: '',
      contact_first_name: '',
      contact_last_name: '',
      contact_email: '',
      contact_phone: '',
      guests_total: '',
      reservation_status: '',
      special_requests: '',
      id_assigned_room: '',
      nightsCount: '',
      typeReservation: false,
      nameStudent:'',
    });
  
    const handleChange = (e) => {
      const { name, value, type, checked } = e.target;
      const newValue = type === 'checkbox' ? checked : value;
      setFormData({
        ...formData,
        [name]: newValue,
      });
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
      fetch('http://localhost:8080/reservation/create', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      })
        .then((response) => response.json())
        .then((data) => {
          console.log('Mensaje de respuesta desde el backend:', data);
        })
        .catch((error) => {
          console.error('Error:', error);
        });
    };
  return (
    <div className="container">
      <h2>Reservation Form</h2>
      <form onSubmit={handleSubmit}>

      <div className="mb-3">
          <label htmlFor="reservation_id" className="form-label">Id</label>
          <input type="number" className="form-control" id="reservation_id" name="reservation_id" value={formData.reservation_id} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="reservation_date" className="form-label">Reservation Date</label>
          <input type="date" className="form-control" id="reservation_date" name="reservation_date" value={formData.reservation_date} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="check_in_date" className="form-label">Check-in Date</label>
          <input type="date" className="form-control" id="check_in_date" name="check_in_date" value={formData.check_in_date} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="check_out_date" className="form-label">Check-out Date</label>
          <input type="date" className="form-control" id="check_out_date" name="check_out_date" value={formData.check_out_date} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="contact_first_name" className="form-label">Contact First Name</label>
          <input type="text" className="form-control" id="contact_first_name" name="contact_first_name" value={formData.contact_first_name} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="contact_last_name" className="form-label">Contact Last Name</label>
          <input type="text" className="form-control" id="contact_last_name" name="contact_last_name" value={formData.contact_last_name} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="contact_email" className="form-label">Contact Email</label>
          <input type="email" className="form-control" id="contact_email" name="contact_email" value={formData.contact_email} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="contact_phone" className="form-label">Contact Phone</label>
          <input type="text" className="form-control" id="contact_phone" name="contact_phone" value={formData.contact_phone} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="guests_total" className="form-label">Total Guests</label>
          <input type="number" className="form-control" id="guests_total" name="guests_total" value={formData.guests_total} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="reservation_status" className="form-label">Reservation Status</label>
          <input type="text" className="form-control" id="reservation_status" name="reservation_status" value={formData.reservation_status} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="special_requests" className="form-label">Special Requests</label>
          <textarea className="form-control" id="special_requests" name="special_requests" value={formData.special_requests} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="id_assigned_room" className="form-label">Assigned Room ID</label>
          <input type="number" className="form-control" id="id_assigned_room" name="id_assigned_room" value={formData.id_assigned_room} onChange={handleChange} />
        </div>

        <div className="mb-3 form-check">
          <input type="checkbox" className="form-check-input" id="typeReservation" name="typeReservation" checked={formData.typeReservation} onChange={handleChange} />
          <label className="form-check-label" htmlFor="typeReservation">Is Type Reservation?</label>
        </div>

        <div className="mb-3">
          <label htmlFor="nightsCount" className="form-label">Nights Count</label>
          <input type="number" className="form-control" id="nightsCount" name="nightsCount" value={formData.nightsCount} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label htmlFor="nameStudent" className="form-label">Name Student</label>
          <input type="text" className="form-control" id="nameStudent" name="nameStudent" value={formData.nameStudent} onChange={handleChange} />
        </div>

        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
}

export default ReservationForm;