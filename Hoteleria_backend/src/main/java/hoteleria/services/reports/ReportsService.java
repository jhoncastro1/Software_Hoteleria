package hoteleria.services.reports;

import hoteleria.model.entity.reports.IReports;
import hoteleria.model.repository.check_in.ICheck_inRepository;
import hoteleria.model.repository.check_out.ICheck_outRepository;
import hoteleria.model.repository.reservation.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsService {
    @Autowired
    private IReservationRepository iReservationRepository;

    @Autowired
    private ICheck_inRepository iCheckInRepository;

    @Autowired
    private ICheck_outRepository iCheckOutRepository;

    ArrayList list = new ArrayList<>();


}
