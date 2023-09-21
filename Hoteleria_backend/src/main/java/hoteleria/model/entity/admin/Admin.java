package hoteleria.model.entity.admin;

import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = ITables.TABLE_ADMIN)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "user")
    private String user;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
