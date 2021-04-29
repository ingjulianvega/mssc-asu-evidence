package ingjulianvega.ximic.msscasuevidence.web.controller;


import ingjulianvega.ximic.msscasuevidence.services.EvidenceService;
import ingjulianvega.ximic.msscasuevidence.web.model.Evidence;
import ingjulianvega.ximic.msscasuevidence.web.model.EvidenceDto;
import ingjulianvega.ximic.msscasuevidence.web.model.EvidenceList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EvidenceController implements EvidenceI {

    private final EvidenceService evidenceService;

    @Override
    public ResponseEntity<EvidenceList> get() {
        return new ResponseEntity<>(evidenceService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EvidenceDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(evidenceService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EvidenceList> getByPatientId(UUID patientId) {
        return new ResponseEntity<>(evidenceService.getByPatientId(patientId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Evidence evidence) {
        evidenceService.create(evidence);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Evidence evidence) {
        evidenceService.updateById(id, evidence);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        evidenceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
