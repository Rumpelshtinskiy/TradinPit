package org.tradingpit.demo.rest.register.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto {

    @Schema(name = "clickId", description = "clickId that will contain a UUID")
    private UUID clickId;
}
