package ingjulianvega.ximic.msscasuevidence.web.Mappers;


import ingjulianvega.ximic.msscasuevidence.domain.EvidenceEntity;
import ingjulianvega.ximic.msscasuevidence.web.model.EvidenceDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface EvidenceMapper {
    EvidenceDto diseaseEntityToDiseaseDto(EvidenceEntity evidenceEntity);

    EvidenceEntity diseaseDtoToDiseaseEntity(EvidenceDto evidenceDto);

    ArrayList<EvidenceDto> diseaseEntityListToDiseaseDtoList(List<EvidenceEntity> evidenceEntityList);
}
