package com.example.phamacy_linechatbot_backend.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;

    @Column(columnDefinition = "TEXT", length=8192)
    String Description;
    String ShortDesc;
    String HowToTake;
}
