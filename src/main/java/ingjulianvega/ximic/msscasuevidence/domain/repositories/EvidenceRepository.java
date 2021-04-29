package ingjulianvega.ximic.msscasuevidence.domain.repositories;

import ingjulianvega.ximic.msscasuevidence.domain.EvidenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface EvidenceRepository extends JpaRepository<EvidenceEntity, UUID>, JpaSpecificationExecutor<EvidenceEntity> {
    List<EvidenceEntity> findByPatientId(UUID patientId);
}
