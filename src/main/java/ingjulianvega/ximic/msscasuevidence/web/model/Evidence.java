package ingjulianvega.ximic.msscasuevidence.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evidence implements Serializable {

    static final long serialVersionUID = -7309482740220635006L;

    @NotNull
    private UUID patientId;
    @NotNull
    private UUID evidenceTypeId;
    @NotNull
    private UUID diseaseId;
    private String observations;

}
