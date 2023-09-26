package hoteleria.webApi.reports;

import hoteleria.model.entity.reports.IReports;
import hoteleria.services.reports.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
            private ReportsService reportsService;
}
