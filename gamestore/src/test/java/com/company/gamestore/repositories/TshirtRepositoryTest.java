package com.company.gamestore.repositories;


import com.company.gamestore.models.Tshirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class TshirtRepositoryTest {
    @Autowired
    com.company.gamestore.repositories.TshirtRepository TshirtRepository;

    @Before
    public void Setup() throws Exception {
        TshirtRepository.deleteAll();
    }

    @Test
    public void ShouldCreateATshirt () throws Exception {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);


        tshirt = TshirtRepository.save(tshirt);

        Optional<Tshirt> tshirt1 = TshirtRepository.findById(tshirt.getId());

        //Assert
        assertEquals(tshirt,tshirt1.get());

    }

    @Test
    public void ShouldGetATshirtById () throws Exception {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);


        tshirt = TshirtRepository.save(tshirt);

        Optional<Tshirt> tshirt1 = TshirtRepository.findById(tshirt.getId());

        assertEquals(tshirt,tshirt1.get());

    }

    @Test
    public void ShouldGetAllTshirts () throws Exception {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);

        //Act
        tshirt = TshirtRepository.save(tshirt);
        List<Tshirt> gameList = TshirtRepository.findAll();



        //Assert
       // assertEquals(tshirtList.size(),1);


    }

    @Test
    public void ShouldUpdateATshirt () throws Exception {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);

       tshirt = TshirtRepository.save(tshirt);

        tshirt.setColor("Blue");

        Tshirt newTshirt = TshirtRepository.save(tshirt);

        //Assert
        assertEquals(tshirt,newTshirt);

    }

    @Test
    public void ShouldDeleteATshirtById() throws Exception {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);

        //Act
        tshirt = TshirtRepository.save(tshirt  );

        TshirtRepository.deleteById(tshirt.getId());

        Optional<Tshirt> tshirt1 = TshirtRepository.findById(tshirt.getId());

        //Assert
        assertFalse(tshirt1.isPresent());

    }

    @Test
    public void ShouldGetTshirtsBySize() throws Exception {

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);

        tshirt = TshirtRepository.save(tshirt);

        List<Tshirt> tshirtsList = TshirtRepository.findAllBySize("L");

        //Assert
        assertEquals(tshirtsList.size(),0);

    }

    @Test
    public void ShouldGetTshirtsByColor() throws Exception {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);

        //Act
        tshirt = TshirtRepository.save(tshirt);

        List<Tshirt> tshirtList = TshirtRepository.findAllByColor("Yellow");

        //Assert
        assertEquals(tshirtList.size(),0);

    }


}
