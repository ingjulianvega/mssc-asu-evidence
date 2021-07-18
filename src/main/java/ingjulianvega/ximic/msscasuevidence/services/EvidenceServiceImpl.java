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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepository;
    private final EvidenceMapper evidenceMapper;

    @Cacheable(cacheNames = "evidenceListCache", condition = "#usingCache == false")
    @Override
    public EvidenceList get(Boolean usingCache) {
        log.debug("get()...");
        return EvidenceList
                .builder()
                .evidenceDtoList(evidenceMapper.evidendeEntityListToEvidendeDtoList(evidenceRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "evidenceCache")
    @Override
    public EvidenceDto getById(UUID id) {
        log.debug("getById()...");
        return evidenceMapper.evidendeEntityToEvidendeDto(
                evidenceRepository.findById(id)
                        .orElseThrow(() -> EvidenceException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.EVIDENCE_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.EVIDENCE_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.EVIDENCE_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.EVIDENCE_NOT_FOUND_SOLUTION)
                                .build()));
    }

    @Override
    public EvidenceList getByPatientId(UUID patientId) {
        log.debug("getByPatientId()...");
        return EvidenceList
                .builder()
                .evidenceDtoList(evidenceMapper.evidendeEntityListToEvidendeDtoList(evidenceRepository.findByPatientId(patientId)))
                .build();
    }

    @Override
    public void create(Evidence evidence) {
        log.debug("create()...");
        evidenceMapper.evidendeEntityToEvidendeDto(
                evidenceRepository.save(
                        evidenceMapper.evidendeDtoToEvidendeEntity(
                                EvidenceDto
                                        .builder()
                                        .patientId(evidence.getPatientId())
                                        .evidenceTypeId(evidence.getEvidenceTypeId())
                                        .diseaseId(evidence.getDiseaseId())
                                        .observations(evidence.getObservations())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Evidence evidence) {
        log.debug("updateById...");
        EvidenceEntity evidenceEntity = evidenceRepository.findById(id)
                .orElseThrow(() -> EvidenceException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.EVIDENCE_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.EVIDENCE_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.EVIDENCE_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.EVIDENCE_NOT_FOUND_SOLUTION)
                        .build());

        evidenceEntity.setPatientId(evidence.getPatientId());
        evidenceEntity.setEvidenceTypeId(evidence.getEvidenceTypeId());
        evidenceEntity.setDiseaseId(evidence.getDiseaseId());
        evidenceEntity.setObservations(evidence.getObservations());

        evidenceRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        evidenceRepository.deleteById(id);
    }
}
