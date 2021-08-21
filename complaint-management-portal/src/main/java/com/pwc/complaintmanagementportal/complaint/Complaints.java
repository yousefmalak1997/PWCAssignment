package com.pwc.complaintmanagementportal.complaint;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Complaints {

    @Id
    @SequenceGenerator(
            name = "complaints_sequence",
            sequenceName = "complaints_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "complaints_sequence"
    )
    private Long cId; // auto gen
    private Long creatorId; // from the system
    @Column(nullable = false , length = 45)
    private String complaintName; //user input
    private String complaintDesc; //user input
    @Column(nullable = false)
    private LocalDateTime dateCreated; //system
    private LocalDateTime dateUpdated; //system
    @Enumerated(EnumType.STRING)
    private ComplaintsStats complaintsStatus; // admin
    private String complaintReasons; // user

    public Complaints(Long creatorId, String complaintName, String complaintDesc, LocalDateTime dateCreated, ComplaintsStats complaintsStatus, String complaintReasons) {
        this.creatorId = creatorId;
        this.complaintName = complaintName;
        this.complaintDesc = complaintDesc;
        this.dateCreated = dateCreated;
        this.complaintsStatus = complaintsStatus;
        this.complaintReasons = complaintReasons;
    }
}
