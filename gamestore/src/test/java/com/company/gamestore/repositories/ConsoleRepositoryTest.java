package com.company.gamestore.repositories;

import com.company.gamestore.models.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepo;

    @Before
    public void setUp() throws Exception {
        consoleRepo.deleteAll();
    }

    @Test
    public void shouldCreateAConsole() throws Exception {

        //    Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);

//        DeleteLater: Had to cast this to a console because it did not work, if program
//        does not work, this might be the CULPRIT!
//        Act
        console = (Console) consoleRepo.save(console);

        Optional<Console> console1 = consoleRepo.findById(console.getId());

//        Assert
        assertEquals(console, console1.get());
    }

    @Test
    public void shouldGetAConsoleById() throws Exception {

//        Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);

//        Act
        console = (Console) consoleRepo.save(console);

        Optional<Console> console1 = consoleRepo.findById(console.getId());

//        Assert
        assertEquals(console, console1.get());

    }

    @Test
    public void shouldGetAllConsoles() throws Exception {

//        Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);

//        Act
        console = (Console) consoleRepo.save(console);

        List<Console> consoleList = consoleRepo.findAll();

//        Assert
        assertEquals(consoleList.size(), 1);
    }

    @Test
    public void shouldUpdateAGame () throws Exception {

//        Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);

//        Act
        console = (Console) consoleRepo.save(console);

        console.setModel("PlayStation 1");

        Console newConsole = (Console) consoleRepo.save(console);

//        Assert
        assertEquals(console, newConsole);
    }

    @Test
    public void shouldDeleteAConsoleById() throws Exception {

        //        Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);

//        Act
        console = (Console) consoleRepo.save(console);

        consoleRepo.deleteById(console.getId());

        Optional<Console> console1 = consoleRepo.findById(console.getId());

//        Assert
        assertFalse(console1.isPresent());
    }

    @Test
    public void shouldGetAConsoleByManufacturer() throws Exception {

//        Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemory_amount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);

//        Act
        console = (Console) consoleRepo.save(console);

        List<Console> consoleList = consoleRepo.findAllByManufacturer("Sony");

//        Assert
        assertEquals(consoleList.size(), 1);
    }


}