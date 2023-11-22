package hoteleria.commons.constans.endPoints.check_in;

public interface ICheckInEndPoints {
    String CHECK_IN_BASE_URL = "/checkin";
    String CHECK_IN_FIND_ALL_URL = "/findAll";
    String CHECK_IN_CREATE_URL = "/create";
    String CHECK_IN_DELETE_URL = "/delete/{checkInId}";
    String CHECK_IN_UPDATE_URL = "/update";
    String CHECK_IN_GET_URL = "/find/{checkInId}";
}
