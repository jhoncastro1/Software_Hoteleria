package hoteleria.commons.constans.endPoints.rackReservation;

public interface IRackReservationEndPoints {

    String RACK_RESERVATION_BASE_URL = "/rackReservation";
    String RACK_RESERVATION_CREATE_URL = "/create";
    String RACK_RESERVATION_DELETE_URL = "/delete/{rackId}";
    String RACK_RESERVATION_UPDATE_URL = "/update";
    String RACK_RESERVATION_FIND_URL = "/find/{rackId}";
}
