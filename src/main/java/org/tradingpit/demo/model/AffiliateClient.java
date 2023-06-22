package org.tradingpit.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "affiliate_client_map")
public class AffiliateClient {

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private UUID id;

    @Size(max = 50)
    @Column(name = "referral_code")
    private String referralCode;

    @NotNull
    @Column(name = "click_id")
    private UUID clickId;

    @Size(max = 255)
    @Column(name = "user_agent")
    private String userAgent;

    @CreationTimestamp
    @Column(name = "creation_date")
    private ZonedDateTime creationDate;

}
