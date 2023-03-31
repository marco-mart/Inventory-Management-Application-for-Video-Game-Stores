package com.company.gamestore.repositories;

import com.company.gamestore.models.Tax;
import org.aspectj.weaver.patterns.ExactAnnotationTypePattern;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaxRepositoryTest {


    @Autowired
    TaxRepository TaxRepo;

    @Before
    public void setUp() throws Exception {
        TaxRepo.deleteAll();
    }

    @Test
    public void ShouldFindTaxByState() throws Exception {

        //Arrange
        Tax tax = new Tax();
        tax.setId(1);
        BigDecimal rate = new BigDecimal("0.01");
        tax.setRate(rate);
        tax.setState("FL");

        //Act
        tax = TaxRepo.save(tax);

        Optional<Tax> tax1 = TaxRepo.findByState("FL");

        //Assert
        assertEquals(tax,tax1.get());

    }

}
