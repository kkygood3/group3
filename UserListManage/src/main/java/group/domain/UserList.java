package group.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "UserList_table")
@Data
public class UserList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
