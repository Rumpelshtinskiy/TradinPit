package org.tradingpit.demo.rest.register.converter;

import org.springframework.stereotype.Component;
import org.tradingpit.demo.clients.dto.ClickSaveDto;
import org.tradingpit.demo.model.AffiliateClient;
import org.tradingpit.demo.rest.register.dto.ClientDto;

import java.util.UUID;

@Component
public class ClientConverter {

    public ClientDto toDto(AffiliateClient Client) {
        return new ClientDto(Client.getClickId());
    }

    public AffiliateClient toDomain(UUID clickId, ClickSaveDto clickSaveDto) {
        return new AffiliateClient(
                null,
                clickSaveDto.getReferralCode(),
                clickId,
                clickSaveDto.getUserAgent(),
                null
        );
    }

}
