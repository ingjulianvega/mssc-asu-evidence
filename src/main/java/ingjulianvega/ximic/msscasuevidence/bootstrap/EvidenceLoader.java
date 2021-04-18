package ingjulianvega.ximic.msscasuevidence.bootstrap;

import ingjulianvega.ximic.msscasuevidence.domain.EvidenceEntity;
import ingjulianvega.ximic.msscasuevidence.domain.repositories.EvidenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class EvidenceLoader implements CommandLineRunner {

    private final EvidenceRepository evidenceRepository;

    @Override
    public void run(String... args) throws Exception {
        if (evidenceRepository.count() == 0) {
            loadEvidenceObjects();
        }
    }

    private void loadEvidenceObjects() {
        evidenceRepository.saveAll(Arrays.asList(
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Acidez de estómago").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Alergia").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Bronquitis").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Bradicardia").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Cáncer de colon").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Cáncer de estómago").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Dengue").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Dermatitis atópica").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Encefalitis").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Edema Pulmonar").observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID()).name("Otro").observations("observación").build()
        ));
    }
}