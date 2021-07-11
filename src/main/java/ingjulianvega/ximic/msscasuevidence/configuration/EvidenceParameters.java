package ingjulianvega.ximic.msscasuevidence.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "evidence")
public class EvidenceParameters {

    private String api;
}
