package com.example.phamacy_linechatbot_backend.util;
import com.example.phamacy_linechatbot_backend.entities.drug;
import com.example.phamacy_linechatbot_backend.entities.drugDTO;
import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import com.example.phamacy_linechatbot_backend.entities.purchasingDetailDTO;
import com.example.phamacy_linechatbot_backend.security.entity.User;
import com.example.phamacy_linechatbot_backend.security.entity.UserAuthDTO;
import com.example.phamacy_linechatbot_backend.security.entity.UserDTO;
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

    UserDTO getUserDTO(User user);
    UserDTO getRegisterDto(User user);
//    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
//    UserAuthDTO getUserAuthDTO(User user);
}
