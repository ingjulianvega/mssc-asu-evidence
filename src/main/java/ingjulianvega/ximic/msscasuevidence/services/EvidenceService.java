package ingjulianvega.ximic.msscasuevidence.services;


import ingjulianvega.ximic.msscasuevidence.web.model.Evidence;
import ingjulianvega.ximic.msscasuevidence.web.model.EvidenceDto;
import ingjulianvega.ximic.msscasuevidence.web.model.EvidenceList;

import java.util.UUID;

public interface EvidenceService {
    EvidenceList get(Boolean usingCache);

    EvidenceDto getById(UUID id);

    EvidenceList getByPatientId(UUID patientId);

    void create(Evidence evidence);

    void updateById(UUID id, Evidence evidence);

    void deleteById(UUID id);


}
