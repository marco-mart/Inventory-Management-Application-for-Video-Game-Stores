package com.company.gamestore.service;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
import com.company.gamestore.models.Tshirt;
import com.company.gamestore.repositories.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ServiceLayer service;

    ConsoleRepository consoleRepository;
    FeeRepository feeRepository;
    GameRepository gameRepository;
    InvoiceRepository invoiceRepository;
    TaxRepository taxRepository;
    TshirtRepository tshirtRepository;

    @Before
    public void setUp() throws Exception {
        setUpConsoleRepositoryMock();
        //setUpFeeRepositoryMock();
        setUpGameRepositoryMock();
        //setUpInvoiceRepositoryMock();
        //setUpTaxRepositoryMock();
        setUpTshirtRepositoryMock();

        service = new ServiceLayer(consoleRepository,gameRepository,tshirtRepository,invoiceRepository,taxRepository,feeRepository);

    }

    private void setUpConsoleRepositoryMock() {
        consoleRepository = mock(ConsoleRepository.class);

        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);
        console.setId(1);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleRepository).save(console);
        doReturn(Optional.of(console)).when(consoleRepository).findById(1);
        doReturn(cList).when(consoleRepository).findAll();
    }

    private void setUpGameRepositoryMock() {
        gameRepository = mock(GameRepository.class);


        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);
        game.setId(1);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameRepository).save(game);
        doReturn(Optional.of(game)).when(gameRepository).findById(1);
        doReturn(gList).when(gameRepository).findAll();

    }

    private void setUpTshirtRepositoryMock() {
        tshirtRepository = mock(TshirtRepository.class);

        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);
        tshirt.setId(1);

        List<Tshirt> tList = new ArrayList<>();
        tList.add(tshirt);

        doReturn(tshirt).when(tshirtRepository).save(tshirt);
        doReturn(Optional.of(tshirt)).when(tshirtRepository).findById(1);
        doReturn(tList).when(tshirtRepository).findAll();

    }

    @Test
    public void shouldSaveTshirt() {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);
        tshirt.setId(1);

        Tshirt expectedResult = new Tshirt();
        expectedResult.setColor("Pink");
        expectedResult.setSize("M");
        expectedResult.setDescription("Pink shirts");
        BigDecimal price2 = new BigDecimal("10.99");
        expectedResult.setPrice(price2);
        expectedResult.setQuantity(15);
        expectedResult.setId(1);

        //ACT
        Tshirt createdTshirt = service.saveTshirt(tshirt);
        assertEquals(expectedResult,createdTshirt);
    }

    @Test
    public void shouldFindTshirtById() {

        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);
        tshirt.setId(1);

        //ACT
        Tshirt tshirtToFind = service.findTshirtById(1);
        assertEquals(tshirt,tshirtToFind);

    }

    @Test
    public void shouldFindAllTshirts(){


        //Arrange
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("Pink shirts");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);
        tshirt.setId(1);

        List<Tshirt> tList = new ArrayList<>();
        tList.add(tshirt);

        //ACT
        List<Tshirt> tList2 = service.findAllTshirts();
        assertEquals(tList2,tList);

    }

    @Test
    public void shouldSaveGame() {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);
        game.setId(1);

        Game expectedResult = new Game();
        expectedResult.setTitle("Minecraft");
        expectedResult.setEsrbRating("Teen");
        expectedResult.setDescription("Dont mine at night");
        BigDecimal price2 = new BigDecimal("9.99");
        expectedResult.setPrice(price2);
        expectedResult.setStudio("Microsoft");
        expectedResult.setQuantity(21);
        expectedResult.setId(1);


        //ACT
        Game createdGame = service.saveGame(game);
        assertEquals(expectedResult,createdGame);
    }

    @Test
    public void shouldFindGameById() {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);
        game.setId(1);

        //ACT
        Game gameToFind = service.findGameById(1);
        assertEquals(game,gameToFind);
    }

    @Test
    public void shouldFindAllGames() {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);
        game.setId(1);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        //ACT
        List<Game> gList2 = service.findAllGames();

        assertEquals(gList,gList2);


    }

    @Test
    public void shouldSaveConsole() {

        //Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);
        console.setId(1);

        Console expectedResult = new Console();
        expectedResult.setModel("PlayStation 5");
        expectedResult.setManufacturer("Sony");
        expectedResult.setMemoryAmount("500 gb");
        expectedResult.setProcessor("Intel i9");
        BigDecimal price2 = new BigDecimal("500.00");
        expectedResult.setPrice(price2);
        expectedResult.setQuantity(20);
        expectedResult.setId(1);

        //ACT
        Console createdConsole = service.saveConsole(console);
        assertEquals(expectedResult,createdConsole);

    }

    @Test
    public void shouldFindConsoleById() {

        //Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);
        console.setId(1);

        //ACT
        Console consoleToFind = service.findConsoleById(1);
        assertEquals(console,consoleToFind);
    }

    @Test
    public void shouldFindAllConsoles() {

        //Arrange
        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);
        console.setId(1);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        List<Console> cList2 = service.findAllConsoles();

        //ACT
        assertEquals(cList,cList2);

    }
}
