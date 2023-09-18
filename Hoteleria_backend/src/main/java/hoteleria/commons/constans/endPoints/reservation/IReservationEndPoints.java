package hoteleria.commons.constans.endPoints.reservation;

public interface IReservationEndPoints {

    String RESERVATION_BASE_URL = "/reservation";
    String RESERVATION_CREATE_URL = "/create";
    String RESERVATION_DELETE_URL = "/delete/{reservation_id}";
    String RESERVATION_UPDATE_URL = "/update";
    String RESERVATION_FIND_URL = "/find/{reservation_id}";



}
