package group.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MeetingRoomList_table")
@Data
public class MeetingRoomList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
