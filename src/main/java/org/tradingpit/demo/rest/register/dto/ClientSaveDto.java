package org.tradingpit.demo.rest.register.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.InetAddress;
import java.net.URL;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientSaveDto {

    @Schema(name = "clientId", description = "clientId that will contain a UUID")
    @JsonProperty(value = "clientId", required = true)
    private UUID clientId;

    @Schema(name = "referalCode", description = "referalCode that will contain an alphanumeric value")
    @JsonProperty(value = "referalCode", required = true)
    private String referalCode;

    @JsonProperty(value = "landingPage", required = true)
    @Schema(name = "landingPage", description = "landing page that will contain a URL")
    private URL landingPage;

    @JsonProperty(value = "userAgent", required = true)
    @Schema(name = "userAgent", description = "userAgent that will contain the browser type of the caller")
    private String userAgent;

    @JsonProperty(value = "ip", required = true)
    @Schema(name = "ip", description = "ip that will contain the IP of the caller")
    private InetAddress ip;
}
