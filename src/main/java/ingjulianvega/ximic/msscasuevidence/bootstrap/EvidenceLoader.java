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
                EvidenceEntity.builder().patientId(UUID.randomUUID())
                        .evidenceTypeId(UUID.randomUUID())
                        .diseaseId(UUID.randomUUID())
                        .observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID())
                        .evidenceTypeId(UUID.randomUUID())
                        .diseaseId(UUID.randomUUID())
                        .observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID())
                        .evidenceTypeId(UUID.randomUUID())
                        .diseaseId(UUID.randomUUID())
                        .observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID())
                        .evidenceTypeId(UUID.randomUUID())
                        .diseaseId(UUID.randomUUID())
                        .observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID())
                        .evidenceTypeId(UUID.randomUUID())
                        .diseaseId(UUID.randomUUID())
                        .observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID())
                        .evidenceTypeId(UUID.randomUUID())
                        .diseaseId(UUID.randomUUID())
                        .observations("observación").build(),
                EvidenceEntity.builder().patientId(UUID.randomUUID())
                        .evidenceTypeId(UUID.randomUUID())
                        .diseaseId(UUID.randomUUID())
                        .observations("observación").build()
        ));
    }
}