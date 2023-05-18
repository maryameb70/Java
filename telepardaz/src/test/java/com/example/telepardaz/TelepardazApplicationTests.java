package com.example.telepardaz;

import com.example.telepardaz.dto.QRCodeDto;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;
import com.example.telepardaz.models.QrCode;
import com.example.telepardaz.repositories.PersonMerchantRepository;
import com.example.telepardaz.repositories.QRCodeRepository;
import com.example.telepardaz.services.MerchantService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Import(TelepardazApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional(readOnly = false)
@EnableTransactionManagement
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase
@Rollback(false)
class TelepardazApplicationTests {
    @Autowired
    private QRCodeRepository qrCodeRepository;
    @Autowired
    private PersonMerchantRepository personMerchantRepository;
    @Autowired
    private MerchantService merchantService;

    @Test
    void contextLoads() {
    }

    @BeforeAll
    public void init() {
        PersonMerchant personMerchant =new PersonMerchant();
              personMerchant.setName("maryam");
              personMerchant.setPhone("22209318");
              personMerchant.setMobile("09920852138");
              personMerchant.setEmail("maryam.ebrahimzade@gmail.com");
              personMerchant.setIban("IR520170000000110528698006");
        this.personMerchantRepository.save(personMerchant);

        QrCode qrCode= QrCode.builder()
                .qrCodeId("1")
                .terminalId("1000")
                .merchant(personMerchant).build();
        this.qrCodeRepository.save(qrCode);
    }

    @Test
    public void findTerminalId_before_generateQRCode() throws ServiceException {
        QRCodeDto qr =new  QRCodeDto();
        qr.setMerchantId(1l);
        qr.setTerminalId("1001");
        //Act
        QrCode qrCode1 =qrCodeRepository.findByTerminalId(qr.getTerminalId());
        //Assertion
        org.assertj.core.api.Assertions.assertThat(qrCode1).isNull();
    }

    @Test
    public void findMerchant_before_generateQRCode() throws ServiceException {
        QRCodeDto qr =new  QRCodeDto();
        qr.setMerchantId(1l);
        qr.setTerminalId("1001");
        //Act
        Optional<Merchant> merchantOptional =merchantService.findById(qr.getId());
        //Assertion
        org.assertj.core.api.Assertions.assertThat(merchantOptional).isNotEmpty();
    }

    @Test
    public void givenMerchantList_whenFindAll_thenMerchantsList() {
        PersonMerchant person = new PersonMerchant();
        person.setName("arezo");
        person.setPhone("22209318");
        person.setMobile("09920852138");
        person.setEmail("maryam.ebrahimzade@gmail.com");
        person.setIban("IR520170000000110528698006");
        personMerchantRepository.save(person);
        //Act
        List<PersonMerchant> merchantList = personMerchantRepository.findAll();
        //Assertion
        org.assertj.core.api.Assertions.assertThat(merchantList).isNotNull();
        org.assertj.core.api.Assertions.assertThat(merchantList.size()).isEqualTo(2);
    }

    @Test
    public void givenMerchantObject_whenDeleteById_thenRemoveMerchant() {
        PersonMerchant person = new PersonMerchant();
        person.setName("asma");
        person.setPhone("22209318");
        person.setMobile("09920852138");
        person.setEmail("maryam.ebrahimzade@gmail.com");
        person.setIban("IR520170000000110528698006");
        personMerchantRepository.save(person);
        //Act
        personMerchantRepository.deleteById(person.getId());
        List<PersonMerchant> merchantList = personMerchantRepository.findAll();
        //Assertion
        org.assertj.core.api.Assertions.assertThat(merchantList.size()).isEqualTo(2);
    }

}
