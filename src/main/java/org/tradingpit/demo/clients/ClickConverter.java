package org.tradingpit.demo.clients;

import org.springframework.stereotype.Component;
import org.tradingpit.demo.clients.dto.ClickDto;
import org.tradingpit.demo.clients.dto.ClickSaveDto;
import org.tradingpit.demo.model.AffiliateClient;
import org.tradingpit.demo.rest.register.dto.ClientSaveDto;

@Component
public class ClickConverter {

    public ClickDto toDto(AffiliateClient client) {
        return null;
    }

    public ClickSaveDto toSaveDto(ClientSaveDto clientSaveDto) {
        return new ClickSaveDto(
                clientSaveDto.getReferalCode(),
                clientSaveDto.getLandingPage(),
                clientSaveDto.getUserAgent(),
                clientSaveDto.getIp()
        );
    }
}
