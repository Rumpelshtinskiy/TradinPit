package org.tradingpit.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.tradingpit.demo.clients.config.ClickFeignConfiguration;
import org.tradingpit.demo.clients.dto.ClickDto;
import org.tradingpit.demo.clients.dto.ClickSaveDto;

import java.util.Optional;

@FeignClient(
        name = "clickclient",
        url = "${application.url}",
        decode404 = true,
        configuration = ClickFeignConfiguration.class
)
public interface ClickClient {

    @PostMapping("/clicks")
    Optional<ClickDto> click(ClickSaveDto clickSaveDto) throws Exception;
}
