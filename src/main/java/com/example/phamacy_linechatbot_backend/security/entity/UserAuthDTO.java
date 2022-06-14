package com.example.phamacy_linechatbot_backend.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDTO {
    Long id;
    String firstname;
    String lastname;
    List<String> authorities;
}
