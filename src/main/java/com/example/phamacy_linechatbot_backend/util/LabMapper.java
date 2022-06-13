package com.example.phamacy_linechatbot_backend.util;
import com.example.phamacy_linechatbot_backend.entities.drug;
import com.example.phamacy_linechatbot_backend.entities.drugDTO;
import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import com.example.phamacy_linechatbot_backend.entities.purchasingDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    drugDTO getDrugDTO(drug drug);
    List<drugDTO> getDrugDTO(List<drug> drugs);

    purchasingDetailDTO getPurchasingDetailDTO(purchasingDetail purchasingDetail);
    List<purchasingDetailDTO> getPurchasingDetailDTO(List<purchasingDetail> purchasingDetails);
}
