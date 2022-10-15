package com.example.phamacy_linechatbot_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class drugDTO {
    Long id;
    String name;
    String Description;
    String ShortDesc;
    String HowToTake;
    String imgUrl;
}
