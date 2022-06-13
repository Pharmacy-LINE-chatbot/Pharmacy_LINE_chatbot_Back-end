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
    String Customer_name;
    String Location;
    String Option;
    String List_of_Drug;
}
