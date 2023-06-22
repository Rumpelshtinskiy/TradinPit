package org.tradingpit.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.tradingpit.demo.clients.ClickClient;
import org.tradingpit.demo.clients.dto.ClickDto;
import org.tradingpit.demo.clients.dto.ClickSaveDto;
import org.tradingpit.demo.model.AffiliateClient;
import org.tradingpit.demo.model.FailedCall;
import org.tradingpit.demo.repository.AffiliateRepository;
import org.tradingpit.demo.repository.FailedRepository;
import org.tradingpit.demo.rest.register.converter.ClientConverter;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.tradingpit.demo.model.RequestType.CREATE_CLICK;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final AffiliateRepository clientRepository;
    private final FailedRepository failedRepository;
    private final ClickClient externalClient;
    private final ClientConverter clientConverter;
    private final ObjectMapper mapper;

    @Override
    public AffiliateClient register(ClickSaveDto clickSaveDto, UUID clientId) {
        try {
            Optional<ClickDto> optionalClickDto = externalClient.click(clickSaveDto);
            ClickDto clickDto = optionalClickDto.orElseThrow(() -> new RuntimeException("No such element"));

            AffiliateClient client = clientConverter.toDomain(clickDto.getClickId(), clickSaveDto);
            return clientRepository.save(client);
        }
        catch (Exception ex) {
            failedRepository.save(getFailedCall(clientId, clickSaveDto));
            throw new RuntimeException("External client unreachable");
        }
    }

    @SneakyThrows
    private FailedCall getFailedCall(UUID clientId, ClickSaveDto clickSaveDto) {
        return new FailedCall(
                clientId,
                CREATE_CLICK,
                mapper.writeValueAsString(clickSaveDto),
                "External",
                ZonedDateTime.now(),
                false
        );
    }
}
