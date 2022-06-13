package com.example.phamacy_linechatbot_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class purchasingDetailDTO {
    Long id;
    String CustomerName;
    String Location;
    String SendingOption;
    String ListOfDrug;
}
