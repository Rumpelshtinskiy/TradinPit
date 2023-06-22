package org.tradingpit.demo.clients.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.InetAddress;
import java.net.URL;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClickSaveDto {

    @Schema(name = "referalCode", description = "referalCode that will contain an alphanumeric value")
    private String referralCode;
    @Schema(name = "landingPage", description = "landing page that will contain a URL")
    private URL landingPage;
    @Schema(name = "userAgent", description = "userAgent that will contain the browser type of the caller")
    private String userAgent; //TODO get from header ?
    @Schema(name = "ip", description = "ip that will contain the IP of the caller")
    private InetAddress ip; //TODO get from header ?
}
