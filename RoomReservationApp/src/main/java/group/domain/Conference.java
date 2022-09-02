package group.domain;

import group.RoomReservationAppApplication;
import group.domain.ConferenceInformationChanged;
import group.domain.ConferenceReservationCanceled;
import group.domain.ConferenceReserved;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Conference_table")
@Data
public class Conference {

    private Long reserveId;

    private Date startTime;

    private Date endTime;

    private String name;

    private Integer roomId;

    private Integer hostId;

    @ElementCollection
    @ElementCollection
    private List<Integer> userIds;

    @PostPersist
    public void onPostPersist() {
        ConferenceReserved conferenceReserved = new ConferenceReserved(this);
        conferenceReserved.publishAfterCommit();

        ConferenceInformationChanged conferenceInformationChanged = new ConferenceInformationChanged(
            this
        );
        conferenceInformationChanged.publishAfterCommit();
        // Get request from MeetingRoom
        //group.external.MeetingRoom meetingRoom =
        //    Application.applicationContext.getBean(group.external.MeetingRoomService.class)
        //    .getMeetingRoom(/** mapping value needed */);

    }

    @PreUpdate
    public void onPreUpdate() {}

    @PreRemove
    public void onPreRemove() {
        ConferenceReservationCanceled conferenceReservationCanceled = new ConferenceReservationCanceled(
            this
        );
        conferenceReservationCanceled.publishAfterCommit();
    }

    public static ConferenceRepository repository() {
        ConferenceRepository conferenceRepository = RoomReservationAppApplication.applicationContext.getBean(
            ConferenceRepository.class
        );
        return conferenceRepository;
    }
}
