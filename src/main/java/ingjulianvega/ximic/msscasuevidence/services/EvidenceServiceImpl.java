package ingjulianvega.ximic.msscasuevidence.services;


import ingjulianvega.ximic.msscasuevidence.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuevidence.domain.EvidenceEntity;
import ingjulianvega.ximic.msscasuevidence.domain.repositories.EvidenceRepository;
import ingjulianvega.ximic.msscasuevidence.exception.EvidenceException;
import ingjulianvega.ximic.msscasuevidence.web.Mappers.EvidenceMapper;
import ingjulianvega.ximic.msscasuevidence.web.model.Evidence;
import ingjulianvega.ximic.msscasuevidence.web.model.EvidenceDto;
import ingjulianvega.ximic.msscasuevidence.web.model.EvidenceList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepository;
    private final EvidenceMapper evidenceMapper;

    @Cacheable(cacheNames = "evidenceListCache")
    @Override
    public EvidenceList get() {
        log.debug("get()...");
        return EvidenceList
                .builder()
                .genderList(evidenceMapper.diseaseEntityListToDiseaseDtoList(evidenceRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "evidenceCache")
    @Override
    public EvidenceDto getById(UUID id) {
        log.debug("getById()...");
        return evidenceMapper.diseaseEntityToDiseaseDto(
                evidenceRepository.findById(id)
                        .orElseThrow(() -> new EvidenceException(ErrorCodeMessages.EVIDENCE_NOT_FOUND, "")));
    }

    @Override
    public void create(Evidence evidence) {
        log.debug("create()...");
        evidenceMapper.diseaseEntityToDiseaseDto(
                evidenceRepository.save(
                        evidenceMapper.diseaseDtoToDiseaseEntity(
                                EvidenceDto
                                        .builder()
                                        .patientId(evidence.getPatientId())
                                        .name(evidence.getName())
                                        .observations(evidence.getObservations())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Evidence evidence) {
        log.debug("updateById...");
        EvidenceEntity evidenceEntity = evidenceRepository.findById(id)
                .orElseThrow(() -> new EvidenceException(ErrorCodeMessages.EVIDENCE_NOT_FOUND, ""));

        evidenceEntity.setPatientId(evidence.getPatientId());
        evidenceEntity.setName(evidence.getName());
        evidenceEntity.setObservations(evidence.getObservations());

        evidenceRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        evidenceRepository.deleteById(id);
    }
}
