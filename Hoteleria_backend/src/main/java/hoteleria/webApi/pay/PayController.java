package hoteleria.webApi.pay;

import hoteleria.commons.constans.endPoints.front.IFrontHost;
import hoteleria.commons.constans.endPoints.outletPass.IOutletPassEndPoints;
import hoteleria.commons.constans.endPoints.pay.IPayEndPoints;
import hoteleria.commons.domains.dto.pay.PayDTO;
import hoteleria.model.entity.pay.PayEntity;
import hoteleria.services.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IPayEndPoints.PAY_BASE_URL)
@CrossOrigin(origins = IFrontHost.FRONT_URL)
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping(IPayEndPoints.PAY_CREATE_URL)
    public String createPay(@RequestBody PayEntity payEntity){
        return this.payService.createPay(payEntity);
    }

    @DeleteMapping(IPayEndPoints.PAY_DELETE_URL)
    public String deletePay(@PathVariable Integer id_pay){
        return this.payService.deletePay(id_pay);
    }

    @PutMapping(IPayEndPoints.PAY_UPDATE_URL)
    public String updatePay(@RequestBody PayDTO payDTO){
        return this.payService.updatePay(payDTO);
    }

    @GetMapping(IPayEndPoints.PAY_FIND_URL)
    public String findPay(@PathVariable Integer id_pay){
        return this.payService.findPay(id_pay);
    }
}
