package com.example.phamacy_linechatbot_backend.config;

import com.example.phamacy_linechatbot_backend.entities.drug;
import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import com.example.phamacy_linechatbot_backend.repository.drugRepository;
import com.example.phamacy_linechatbot_backend.repository.purchasingDetailRepository;
import com.example.phamacy_linechatbot_backend.security.entity.Authority;
import com.example.phamacy_linechatbot_backend.security.entity.AuthorityName;
import com.example.phamacy_linechatbot_backend.security.entity.User;

import com.example.phamacy_linechatbot_backend.security.repository.AuthorityRepository;
import com.example.phamacy_linechatbot_backend.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class initApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    drugRepository drugRepository;
    @Autowired
    purchasingDetailRepository purchasingDetailRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {

        drug d1,d2,d3;
        d1 = drugRepository.save(drug.builder().name("d1").Description("Desc1").ShortDesc("ShortDesc1").HowToTake("HowtoTake1").build());
        d2 = drugRepository.save(drug.builder().name("d2").Description("Desc2").ShortDesc("ShortDesc2").HowToTake("HowtoTake2").build());
        d3 = drugRepository.save(drug.builder().name("d3").Description("Desc3").ShortDesc("ShortDesc3").HowToTake("HowtoTake3").build());

        purchasingDetail p1,p2,p3;
        p1 = purchasingDetailRepository.save(purchasingDetail.builder().CustomerName("Customer1").SendingOption("TakeHome").Location("CM").ListOfDrug("para").build());

        addUser();
    }

    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();

        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("Doctor")
                .password(encoder.encode("Doctor"))
                .firstname("Doctor")
                .lastname("Dokkutaa")
                .email("Doctor@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        authorityRepository.save(authDoctor);

        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authDoctor);
        user3.getAuthorities().add(authUser);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}
