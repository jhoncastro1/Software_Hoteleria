package hoteleria.model.entity.pay;


import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = ITables.TABLE_PAY)
@Getter
@Setter
@ToString
public class PayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pay")
    private Integer id_pay;

    @Column(name = "descuentos")
    private Integer descuentos;

    @Column(name = "name_customer")
    private String name_customer;

    @Column(name = "number")
    private Integer number;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "room")
    private String room;

    @Column(name = "people")
    private Integer people;
    @Column(name = "cambio")
    private Integer cambio;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "seguro")
    private Integer seguro;
    @Column(name = "tmo")
    private Integer tmo;
    @Column(name = "restaurante")
    private Integer restaurante;
    @Column(name = "consumo")
    private Integer consumo;
    @Column(name = "minibar")
    private Integer minibar;

    @Column(name = "gastostel")
    private Integer gastostel;
    @Column(name = "miscelaneos")
    private Integer miscelaneos;
    @Column(name = "lavanderia")
    private Integer lavanderia;
    @Column(name = "totalcargos")
    private Integer totalcargos;
    @Column(name = "abonos")
    private Integer abonos;
    @Column(name = "ncaja")
    private String ncaja;
    @Column(name = "totalpagar")
    private Integer totalpagar;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "identificacion")
    private String identificacion;






}
