package org.tradingpit.demo.services;

import org.tradingpit.demo.clients.dto.ClickSaveDto;
import org.tradingpit.demo.model.AffiliateClient;

import java.util.UUID;

public interface RegisterService {

    AffiliateClient register(ClickSaveDto clickSaveDto, UUID clientId);
}
