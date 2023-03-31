package com.company.gamestore.repositories;

import com.company.gamestore.models.Fee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FeeRepositoryTest {

    @Autowired
    FeeRepository FeeRepo;

    @Before
    public void setUp() throws Exception{
        FeeRepo.deleteAll();
    }

    @Test
    public void ShouldFindFeeByProductType() throws Exception {

        //Arrange
        Fee fee = new Fee();
        fee.setId(1);
        fee.setProduct("Pants");
        BigDecimal price = new BigDecimal("10.00");
        fee.setFee(price);

        //Act
        fee = FeeRepo.save(fee);

        Optional<Fee> fee1 = FeeRepo.findByProduct("Pants");

        //Assert
        assertEquals(fee,fee1.get());

    }








}
