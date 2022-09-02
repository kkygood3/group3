package group.domain;

import group.domain.*;
import group.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ConferenceReserved extends AbstractEvent {

    private Long id;
    private Long reserveId;
    private Date reserveStartTime;
    private Date reserveEndTime;
    private String reserveName;
    private Integer roomId;
    private Integer hostId;
    private List<Integer> userIds;

    public ConferenceReserved(Conference aggregate) {
        super(aggregate);
    }

    public ConferenceReserved() {
        super();
    }
    // keep

}
