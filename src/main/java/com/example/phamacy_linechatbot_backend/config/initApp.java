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

        drug d1,d2,d3,d4,d5,d6,d7,d8;
        d1 = drugRepository.save(drug.builder()
                .name("Paracetamol").
                Description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vestibulum sem turpis, a iaculis nibh scelerisque eu. Aliquam tellus risus, consectetur et malesuada nec, porta id ipsum. Quisque vel mauris eget nisl convallis accumsan mollis sit amet ligula. Mauris lobortis augue sit amet lectus blandit, non maximus leo iaculis. Nullam dictum massa leo, vehicula eleifend lorem consectetur non. Cras erat justo, elementum non accumsan id, fringilla in urna. Pellentesque a tortor vel nisl iaculis fermentum. Proin sed nisi ac mi blandit imperdiet id ac erat.\n" +
                        "\n" +
                        "Mauris vestibulum risus nec erat accumsan, eget cursus odio commodo. Nunc euismod eget enim ut porta. Vestibulum porttitor dui tortor, porta placerat diam pretium ac. Aliquam lacus purus, iaculis vel orci ac, condimentum faucibus risus. Vestibulum sit amet est sit amet nisi dapibus mattis. Mauris molestie orci vel ipsum sollicitudin efficitur. Phasellus consectetur metus erat, ac molestie ipsum fermentum vitae. Nullam rutrum nunc at maximus posuere. Vivamus tempor vel turpis a ornare. Ut ac scelerisque enim, et viverra metus. Nam auctor pretium elit, et pharetra sapien posuere ac. Nunc quis tristique risus. Vivamus sed ipsum quis metus blandit blandit et eu augue.\n" +
                        "\n" +
                        "Quisque vulputate finibus augue sit amet pellentesque. Vivamus eget dolor luctus, elementum nibh ut, consectetur odio. Nulla enim odio, vulputate sed auctor et, suscipit quis purus. Quisque sit amet pretium neque, vitae ultricies justo. Donec quam tellus, laoreet vitae fermentum eu, iaculis et mauris. Pellentesque lorem ipsum, tempus ut elementum nec, fringilla consequat arcu. Maecenas interdum nunc eget sem blandit, nec maximus odio commodo.\n" +
                        "\n" +
                        "Sed vel ullamcorper magna, eget facilisis odio. Duis vestibulum, tellus quis faucibus gravida, leo nisl dictum magna, at suscipit eros purus non nulla. Donec faucibus arcu at eros egestas, nec ultricies felis tristique. In hac habitasse platea dictumst. Donec quis tortor ligula. Duis auctor tincidunt augue a scelerisque. Curabitur dictum nibh id nisl dignissim suscipit. Donec sit amet porttitor felis. Integer sit amet magna vel lectus consequat euismod. Vivamus sed fringilla mauris, sed lobortis risus.").
                ShortDesc("Paracetamol, also known as acetaminophen, is a medication used to treat fever and mild to moderate pain. Common brand names include Tylenol and Panadol.").
                HowToTake("Ask a pharmacist")
                .build());
        d2 = drugRepository.save(drug.builder()
                .name("Antipyretic")
                .Description("An antipyretic is a substance that reduces fever.Antipyretics cause the hypothalamus to override a prostaglandin-induced increase in temperature. The body then works to lower the temperature, which results in a reduction in fever.")
                .ShortDesc("An antipyretic is a substance that reduces fever. Antipyretics cause the hypothalamus to override a prostaglandin-induced increase in temperature. The body then works to lower the temperature, which results in a reduction in fever.")
                .HowToTake("Ask a pharmacist")
                .build());
        d3 = drugRepository.save(drug.builder()
                .name("mood stabilizer ")
                .Description("A mood stabilizer is a psychiatric medication used to treat mood disorders characterized by intense and sustained mood shifts, such as bipolar disorder and the bipolar type of schizoaffective disorder.")
                .ShortDesc("Mood stabilizers are best known for the treatment of bipolar disorder, preventing mood shifts to mania (or hypomania) and depression. Mood stabilizers are also used in schizoaffective disorder when it is the bipolar type.")
                .HowToTake("Ask a pharmacist")
                .build());
        d4 = drugRepository.save(drug.builder()
                .name("Paracetamol").
                Description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vestibulum sem turpis, a iaculis nibh scelerisque eu. Aliquam tellus risus, consectetur et malesuada nec, porta id ipsum. Quisque vel mauris eget nisl convallis accumsan mollis sit amet ligula. Mauris lobortis augue sit amet lectus blandit, non maximus leo iaculis. Nullam dictum massa leo, vehicula eleifend lorem consectetur non. Cras erat justo, elementum non accumsan id, fringilla in urna. Pellentesque a tortor vel nisl iaculis fermentum. Proin sed nisi ac mi blandit imperdiet id ac erat.\n" +
                        "\n" +
                        "Mauris vestibulum risus nec erat accumsan, eget cursus odio commodo. Nunc euismod eget enim ut porta. Vestibulum porttitor dui tortor, porta placerat diam pretium ac. Aliquam lacus purus, iaculis vel orci ac, condimentum faucibus risus. Vestibulum sit amet est sit amet nisi dapibus mattis. Mauris molestie orci vel ipsum sollicitudin efficitur. Phasellus consectetur metus erat, ac molestie ipsum fermentum vitae. Nullam rutrum nunc at maximus posuere. Vivamus tempor vel turpis a ornare. Ut ac scelerisque enim, et viverra metus. Nam auctor pretium elit, et pharetra sapien posuere ac. Nunc quis tristique risus. Vivamus sed ipsum quis metus blandit blandit et eu augue.\n" +
                        "\n" +
                        "Quisque vulputate finibus augue sit amet pellentesque. Vivamus eget dolor luctus, elementum nibh ut, consectetur odio. Nulla enim odio, vulputate sed auctor et, suscipit quis purus. Quisque sit amet pretium neque, vitae ultricies justo. Donec quam tellus, laoreet vitae fermentum eu, iaculis et mauris. Pellentesque lorem ipsum, tempus ut elementum nec, fringilla consequat arcu. Maecenas interdum nunc eget sem blandit, nec maximus odio commodo.\n" +
                        "\n" +
                        "Sed vel ullamcorper magna, eget facilisis odio. Duis vestibulum, tellus quis faucibus gravida, leo nisl dictum magna, at suscipit eros purus non nulla. Donec faucibus arcu at eros egestas, nec ultricies felis tristique. In hac habitasse platea dictumst. Donec quis tortor ligula. Duis auctor tincidunt augue a scelerisque. Curabitur dictum nibh id nisl dignissim suscipit. Donec sit amet porttitor felis. Integer sit amet magna vel lectus consequat euismod. Vivamus sed fringilla mauris, sed lobortis risus.").
                ShortDesc("Paracetamol, also known as acetaminophen, is a medication used to treat fever and mild to moderate pain. Common brand names include Tylenol and Panadol.").
                HowToTake("Ask a pharmacist")
                .build());
        d5 = drugRepository.save(drug.builder()
                .name("Paracetamol").
                Description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vestibulum sem turpis, a iaculis nibh scelerisque eu. Aliquam tellus risus, consectetur et malesuada nec, porta id ipsum. Quisque vel mauris eget nisl convallis accumsan mollis sit amet ligula. Mauris lobortis augue sit amet lectus blandit, non maximus leo iaculis. Nullam dictum massa leo, vehicula eleifend lorem consectetur non. Cras erat justo, elementum non accumsan id, fringilla in urna. Pellentesque a tortor vel nisl iaculis fermentum. Proin sed nisi ac mi blandit imperdiet id ac erat.\n" +
                        "\n" +
                        "Mauris vestibulum risus nec erat accumsan, eget cursus odio commodo. Nunc euismod eget enim ut porta. Vestibulum porttitor dui tortor, porta placerat diam pretium ac. Aliquam lacus purus, iaculis vel orci ac, condimentum faucibus risus. Vestibulum sit amet est sit amet nisi dapibus mattis. Mauris molestie orci vel ipsum sollicitudin efficitur. Phasellus consectetur metus erat, ac molestie ipsum fermentum vitae. Nullam rutrum nunc at maximus posuere. Vivamus tempor vel turpis a ornare. Ut ac scelerisque enim, et viverra metus. Nam auctor pretium elit, et pharetra sapien posuere ac. Nunc quis tristique risus. Vivamus sed ipsum quis metus blandit blandit et eu augue.\n" +
                        "\n" +
                        "Quisque vulputate finibus augue sit amet pellentesque. Vivamus eget dolor luctus, elementum nibh ut, consectetur odio. Nulla enim odio, vulputate sed auctor et, suscipit quis purus. Quisque sit amet pretium neque, vitae ultricies justo. Donec quam tellus, laoreet vitae fermentum eu, iaculis et mauris. Pellentesque lorem ipsum, tempus ut elementum nec, fringilla consequat arcu. Maecenas interdum nunc eget sem blandit, nec maximus odio commodo.\n" +
                        "\n" +
                        "Sed vel ullamcorper magna, eget facilisis odio. Duis vestibulum, tellus quis faucibus gravida, leo nisl dictum magna, at suscipit eros purus non nulla. Donec faucibus arcu at eros egestas, nec ultricies felis tristique. In hac habitasse platea dictumst. Donec quis tortor ligula. Duis auctor tincidunt augue a scelerisque. Curabitur dictum nibh id nisl dignissim suscipit. Donec sit amet porttitor felis. Integer sit amet magna vel lectus consequat euismod. Vivamus sed fringilla mauris, sed lobortis risus.").
                ShortDesc("Paracetamol, also known as acetaminophen, is a medication used to treat fever and mild to moderate pain. Common brand names include Tylenol and Panadol.").
                HowToTake("Ask a pharmacist")
                .build());
        d6 = drugRepository.save(drug.builder()
                .name("Paracetamol").
                Description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vestibulum sem turpis, a iaculis nibh scelerisque eu. Aliquam tellus risus, consectetur et malesuada nec, porta id ipsum. Quisque vel mauris eget nisl convallis accumsan mollis sit amet ligula. Mauris lobortis augue sit amet lectus blandit, non maximus leo iaculis. Nullam dictum massa leo, vehicula eleifend lorem consectetur non. Cras erat justo, elementum non accumsan id, fringilla in urna. Pellentesque a tortor vel nisl iaculis fermentum. Proin sed nisi ac mi blandit imperdiet id ac erat.\n" +
                        "\n" +
                        "Mauris vestibulum risus nec erat accumsan, eget cursus odio commodo. Nunc euismod eget enim ut porta. Vestibulum porttitor dui tortor, porta placerat diam pretium ac. Aliquam lacus purus, iaculis vel orci ac, condimentum faucibus risus. Vestibulum sit amet est sit amet nisi dapibus mattis. Mauris molestie orci vel ipsum sollicitudin efficitur. Phasellus consectetur metus erat, ac molestie ipsum fermentum vitae. Nullam rutrum nunc at maximus posuere. Vivamus tempor vel turpis a ornare. Ut ac scelerisque enim, et viverra metus. Nam auctor pretium elit, et pharetra sapien posuere ac. Nunc quis tristique risus. Vivamus sed ipsum quis metus blandit blandit et eu augue.\n" +
                        "\n" +
                        "Quisque vulputate finibus augue sit amet pellentesque. Vivamus eget dolor luctus, elementum nibh ut, consectetur odio. Nulla enim odio, vulputate sed auctor et, suscipit quis purus. Quisque sit amet pretium neque, vitae ultricies justo. Donec quam tellus, laoreet vitae fermentum eu, iaculis et mauris. Pellentesque lorem ipsum, tempus ut elementum nec, fringilla consequat arcu. Maecenas interdum nunc eget sem blandit, nec maximus odio commodo.\n" +
                        "\n" +
                        "Sed vel ullamcorper magna, eget facilisis odio. Duis vestibulum, tellus quis faucibus gravida, leo nisl dictum magna, at suscipit eros purus non nulla. Donec faucibus arcu at eros egestas, nec ultricies felis tristique. In hac habitasse platea dictumst. Donec quis tortor ligula. Duis auctor tincidunt augue a scelerisque. Curabitur dictum nibh id nisl dignissim suscipit. Donec sit amet porttitor felis. Integer sit amet magna vel lectus consequat euismod. Vivamus sed fringilla mauris, sed lobortis risus.").
                ShortDesc("Paracetamol, also known as acetaminophen, is a medication used to treat fever and mild to moderate pain. Common brand names include Tylenol and Panadol.").
                HowToTake("Ask a pharmacist")
                .build());
        d7 = drugRepository.save(drug.builder()
                .name("Paracetamol").
                Description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vestibulum sem turpis, a iaculis nibh scelerisque eu. Aliquam tellus risus, consectetur et malesuada nec, porta id ipsum. Quisque vel mauris eget nisl convallis accumsan mollis sit amet ligula. Mauris lobortis augue sit amet lectus blandit, non maximus leo iaculis. Nullam dictum massa leo, vehicula eleifend lorem consectetur non. Cras erat justo, elementum non accumsan id, fringilla in urna. Pellentesque a tortor vel nisl iaculis fermentum. Proin sed nisi ac mi blandit imperdiet id ac erat.\n" +
                        "\n" +
                        "Mauris vestibulum risus nec erat accumsan, eget cursus odio commodo. Nunc euismod eget enim ut porta. Vestibulum porttitor dui tortor, porta placerat diam pretium ac. Aliquam lacus purus, iaculis vel orci ac, condimentum faucibus risus. Vestibulum sit amet est sit amet nisi dapibus mattis. Mauris molestie orci vel ipsum sollicitudin efficitur. Phasellus consectetur metus erat, ac molestie ipsum fermentum vitae. Nullam rutrum nunc at maximus posuere. Vivamus tempor vel turpis a ornare. Ut ac scelerisque enim, et viverra metus. Nam auctor pretium elit, et pharetra sapien posuere ac. Nunc quis tristique risus. Vivamus sed ipsum quis metus blandit blandit et eu augue.\n" +
                        "\n" +
                        "Quisque vulputate finibus augue sit amet pellentesque. Vivamus eget dolor luctus, elementum nibh ut, consectetur odio. Nulla enim odio, vulputate sed auctor et, suscipit quis purus. Quisque sit amet pretium neque, vitae ultricies justo. Donec quam tellus, laoreet vitae fermentum eu, iaculis et mauris. Pellentesque lorem ipsum, tempus ut elementum nec, fringilla consequat arcu. Maecenas interdum nunc eget sem blandit, nec maximus odio commodo.\n" +
                        "\n" +
                        "Sed vel ullamcorper magna, eget facilisis odio. Duis vestibulum, tellus quis faucibus gravida, leo nisl dictum magna, at suscipit eros purus non nulla. Donec faucibus arcu at eros egestas, nec ultricies felis tristique. In hac habitasse platea dictumst. Donec quis tortor ligula. Duis auctor tincidunt augue a scelerisque. Curabitur dictum nibh id nisl dignissim suscipit. Donec sit amet porttitor felis. Integer sit amet magna vel lectus consequat euismod. Vivamus sed fringilla mauris, sed lobortis risus.").
                ShortDesc("Paracetamol, also known as acetaminophen, is a medication used to treat fever and mild to moderate pain. Common brand names include Tylenol and Panadol.").
                HowToTake("Ask a pharmacist")
                .build());
        d8 = drugRepository.save(drug.builder()
                .name("Paracetamol").
                Description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vestibulum sem turpis, a iaculis nibh scelerisque eu. Aliquam tellus risus, consectetur et malesuada nec, porta id ipsum. Quisque vel mauris eget nisl convallis accumsan mollis sit amet ligula. Mauris lobortis augue sit amet lectus blandit, non maximus leo iaculis. Nullam dictum massa leo, vehicula eleifend lorem consectetur non. Cras erat justo, elementum non accumsan id, fringilla in urna. Pellentesque a tortor vel nisl iaculis fermentum. Proin sed nisi ac mi blandit imperdiet id ac erat.\n" +
                        "\n" +
                        "Mauris vestibulum risus nec erat accumsan, eget cursus odio commodo. Nunc euismod eget enim ut porta. Vestibulum porttitor dui tortor, porta placerat diam pretium ac. Aliquam lacus purus, iaculis vel orci ac, condimentum faucibus risus. Vestibulum sit amet est sit amet nisi dapibus mattis. Mauris molestie orci vel ipsum sollicitudin efficitur. Phasellus consectetur metus erat, ac molestie ipsum fermentum vitae. Nullam rutrum nunc at maximus posuere. Vivamus tempor vel turpis a ornare. Ut ac scelerisque enim, et viverra metus. Nam auctor pretium elit, et pharetra sapien posuere ac. Nunc quis tristique risus. Vivamus sed ipsum quis metus blandit blandit et eu augue.\n" +
                        "\n" +
                        "Quisque vulputate finibus augue sit amet pellentesque. Vivamus eget dolor luctus, elementum nibh ut, consectetur odio. Nulla enim odio, vulputate sed auctor et, suscipit quis purus. Quisque sit amet pretium neque, vitae ultricies justo. Donec quam tellus, laoreet vitae fermentum eu, iaculis et mauris. Pellentesque lorem ipsum, tempus ut elementum nec, fringilla consequat arcu. Maecenas interdum nunc eget sem blandit, nec maximus odio commodo.\n" +
                        "\n" +
                        "Sed vel ullamcorper magna, eget facilisis odio. Duis vestibulum, tellus quis faucibus gravida, leo nisl dictum magna, at suscipit eros purus non nulla. Donec faucibus arcu at eros egestas, nec ultricies felis tristique. In hac habitasse platea dictumst. Donec quis tortor ligula. Duis auctor tincidunt augue a scelerisque. Curabitur dictum nibh id nisl dignissim suscipit. Donec sit amet porttitor felis. Integer sit amet magna vel lectus consequat euismod. Vivamus sed fringilla mauris, sed lobortis risus.").
                ShortDesc("Paracetamol, also known as acetaminophen, is a medication used to treat fever and mild to moderate pain. Common brand names include Tylenol and Panadol.").
                HowToTake("Ask a pharmacist")
                .build());
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
