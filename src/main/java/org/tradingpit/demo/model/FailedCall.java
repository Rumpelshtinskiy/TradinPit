package org.tradingpit.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "failed_calls")
public class FailedCall {

    @Id
    @Column(name = "client_id")
    private UUID clientId;

    @Enumerated(EnumType.STRING)
    @Column(name = "request_type")
    private RequestType requestType;

    @Column(name = "payload")
    private String payload;

    @Column(name = "reason_of_failure")
    private String reasonOfFailure;

    @Column(name = "time_of_failure")
    private ZonedDateTime timeOfFailure;

    @Column(name = "processed")
    private Boolean processed;
}
