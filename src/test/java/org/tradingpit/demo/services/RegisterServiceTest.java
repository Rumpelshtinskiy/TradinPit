package org.tradingpit.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tradingpit.demo.clients.ClickClient;
import org.tradingpit.demo.clients.dto.ClickDto;
import org.tradingpit.demo.clients.dto.ClickSaveDto;
import org.tradingpit.demo.model.AffiliateClient;
import org.tradingpit.demo.repository.AffiliateRepository;
import org.tradingpit.demo.repository.FailedRepository;
import org.tradingpit.demo.rest.register.converter.ClientConverter;

import java.net.InetAddress;
import java.net.URL;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {
    @InjectMocks
    private RegisterServiceImpl service;
    @Mock
    private AffiliateRepository clientRepository;
    @Mock
    private FailedRepository failedRepository;
    @Mock
    private ClickClient externalClient;
    @Mock
    private ClientConverter clientConverter;
    @Mock
    private ObjectMapper mapper;

    private static final AffiliateClient EXPECTED_CLIENT = Mockito.mock(AffiliateClient.class);
    private static final String EXPECTED_REFERRAL = "testReferralCode";
    private static final String EXPECTED_USER_AGENT = "testUserAgent";
    private static final UUID EXPECTED_CLICK_ID = UUID.fromString("0380f561-c975-496b-b11a-d165f4665e3a");

    @Test
    @DisplayName("Register should return client with expected values")
    public void test() throws Exception {
        AffiliateClient expectedClient = Mockito.mock(AffiliateClient.class);
        UUID expectedClickId = UUID.fromString("0380f561-c975-496b-b11a-d165f4665e3a");
        ClickSaveDto clickSaveDto = createClickSaveDto();

        UUID clientId = UUID.fromString("498341f1-b666-41d6-96e9-d1be4850561c");
        Mockito.when(externalClient.click(clickSaveDto)).thenReturn(Optional.of(new ClickDto(expectedClickId)));
        Mockito.when(clientConverter.toDomain(expectedClickId, clickSaveDto)).thenReturn(expectedClient);
        service.register(clickSaveDto, clientId);

        Mockito.verify(clientRepository).save(Mockito.argThat(affiliateClient -> affiliateClient.equals(expectedClient)));
    }

    @Test
    @DisplayName("Should throw a RuntimeException")
    public void test2() throws Exception {

        ClickSaveDto clickSaveDto = createClickSaveDto();

        UUID clientId = UUID.fromString("498341f1-b666-41d6-96e9-d1be4850561c");
        Mockito.when(externalClient.click(clickSaveDto)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> service.register(clickSaveDto, clientId));
    }

    @Test
    @DisplayName("Should throw a RuntimeException if external client is not available")
    public void test3() throws Exception {

        ClickSaveDto clickSaveDto = createClickSaveDto();

        UUID clientId = UUID.fromString("498341f1-b666-41d6-96e9-d1be4850561c");
        Mockito.when(externalClient.click(clickSaveDto)).thenThrow(new Exception());

        Assertions.assertThrows(RuntimeException.class, () -> service.register(clickSaveDto, clientId));
    }

    @SneakyThrows
    private ClickSaveDto createClickSaveDto() {
        return new ClickSaveDto(
                EXPECTED_REFERRAL,
                new URL("https://www.uuidgenerator.net/"),
                EXPECTED_USER_AGENT,
                InetAddress.getByName("localhost")
        );
    }
}
