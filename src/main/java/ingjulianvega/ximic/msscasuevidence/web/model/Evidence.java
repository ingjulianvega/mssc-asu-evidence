package ingjulianvega.ximic.msscasuevidence.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evidence implements Serializable {

    static final long serialVersionUID = -7309482740220635006L;

    private UUID patientId;
    private UUID evidenceTypeId;
    private UUID diseaseId;
    private String observations;

}
