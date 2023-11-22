package hoteleria.commons.constans.endPoints.recordReservations;

public interface IRecordReservationEndPoints {
    String BASE_RECORD_RESERVATIONS_URL = "/recordReservations";
    String RECORD_RESERVATIONS_CREATE_URL = "/create";
    String RECORD_RESERVATIONS_DELETE_URL = "/delete/{idRecord}";
    String RECORD_RESERVATIONS_UPDATE_URL = "/update";
    String RECORD_RESERVATIONS_FIND_URL = "/find/{idRecord}";
}
