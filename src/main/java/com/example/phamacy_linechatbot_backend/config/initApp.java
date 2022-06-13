package com.example.phamacy_linechatbot_backend.config;

import com.example.phamacy_linechatbot_backend.entities.drug;
import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import com.example.phamacy_linechatbot_backend.repository.drugRepository;
import com.example.phamacy_linechatbot_backend.repository.purchasingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class initApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    drugRepository drugRepository;
    @Autowired
    purchasingDetailRepository purchasingDetailRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {

        drug d1,d2,d3;
        d1 = drugRepository.save(drug.builder().name("d1").Description("Desc1").ShortDesc("ShortDesc1").HowToTake("HowtoTake1").build());
        d2 = drugRepository.save(drug.builder().name("d2").Description("Desc2").ShortDesc("ShortDesc2").HowToTake("HowtoTake2").build());
        d3 = drugRepository.save(drug.builder().name("d3").Description("Desc3").ShortDesc("ShortDesc3").HowToTake("HowtoTake3").build());

//        purchasingDetail p1,p2,p3;
//        p1 = purchasingDetailRepository.save(purchasingDetail.builder().Customer_name("Customer1").build());
//        p2 = purchasingDetailRepository.save(purchasingDetail.builder().Customer_name("Customer2").build());
//        p3 = purchasingDetailRepository.save(purchasingDetail.builder().Customer_name("Customer3").build());
    }
}
