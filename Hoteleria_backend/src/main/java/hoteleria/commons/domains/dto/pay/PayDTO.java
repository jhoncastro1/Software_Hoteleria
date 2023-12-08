package hoteleria.commons.domains.dto.pay;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
public class PayDTO {

    private Integer id_pay;
    private Integer descuentos;
    private String name_customer;
    private Integer number;
    private LocalDate date;
    private String room;
    private Integer people;
    private Integer cambio;
    private Integer balance;
    private Integer seguro;
    private Integer tmo;
    private Integer restaurante;
    private Integer consumo;
    private Integer minibar;
    private Integer gastostel;
    private Integer miscelaneos;
    private Integer lavanderia;
    private Integer totalcargos;
    private Integer abonos;
    private String ncaja;
    private Integer totalpagar;
    private String observaciones;
    private String identificacion;
}
