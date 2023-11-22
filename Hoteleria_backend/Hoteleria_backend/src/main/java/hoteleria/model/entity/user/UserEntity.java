package hoteleria.model.entity.user;

import hoteleria.commons.constans.tables.ITables;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Data
@Table(name = ITables.TABLE_USER)
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name_email")
    private String userEmail;

    @Column(name = "password")
    private String userPassword;

}
