package ingjulianvega.ximic.msscasuevidence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EvidenceEntity extends BaseEntity {

    private UUID patientId;
    private UUID evidenceTypeId;
    private UUID diseaseId;
    private String observations;
}
