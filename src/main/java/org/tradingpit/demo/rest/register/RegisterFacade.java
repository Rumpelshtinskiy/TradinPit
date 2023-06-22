package org.tradingpit.demo.rest.register;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tradingpit.demo.clients.ClickConverter;
import org.tradingpit.demo.clients.dto.ClickSaveDto;
import org.tradingpit.demo.model.AffiliateClient;
import org.tradingpit.demo.rest.register.converter.ClientConverter;
import org.tradingpit.demo.rest.register.dto.ClientDto;
import org.tradingpit.demo.rest.register.dto.ClientSaveDto;
import org.tradingpit.demo.services.RegisterService;

@Service
@RequiredArgsConstructor
public class RegisterFacade {

    private final RegisterService service;
    private final ClientConverter clientConverter;
    private final ClickConverter clickConverter;

    public ClientDto register(ClientSaveDto clientSaveDto) {
        ClickSaveDto clickSaveDto = clickConverter.toSaveDto(clientSaveDto);
        AffiliateClient client = service.register(clickSaveDto, clientSaveDto.getClientId());
        return clientConverter.toDto(client);
    }
}

