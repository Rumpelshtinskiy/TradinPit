package org.tradingpit.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationSettings {
    private URL url;
}
