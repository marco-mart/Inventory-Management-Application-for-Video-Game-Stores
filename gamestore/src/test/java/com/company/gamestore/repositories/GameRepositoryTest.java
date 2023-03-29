package com.company.gamestore.repositories;

import com.company.gamestore.models.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameRepositoryTest {

    @Autowired
    GameRepository GameRepo;

    @Before
    public void Setup() throws Exception {
        GameRepo.deleteAll();
    }

    @Test
    public void ShouldCreateAGame () throws Exception {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);

        Optional<Game> game1 = GameRepo.findById(game.getId());

        //Assert
        assertEquals(game,game1.get());

    }

    @Test
    public void ShouldGetAGameById () throws Exception {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);

        Optional<Game> game1 = GameRepo.findById(game.getId());

        //Assert
        assertEquals(game,game1.get());

    }

    @Test
    public void ShouldGetAllGames () throws Exception {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);
        List<Game> gameList = GameRepo.findAll();


        //Assert
        assertEquals(gameList.size(),1);


    }

    @Test
    public void ShouldUpdateAGame () throws Exception {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);

        game.setTitle("VALORANT");

        Game newGame = GameRepo.save(game);

        //Assert
        assertEquals(game,newGame);

    }

    @Test
    public void ShouldDeleteAGameById() throws Exception {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);

        GameRepo.deleteById(game.getId());

        Optional<Game> game1 = GameRepo.findById(game.getId());

        //Assert
        assertFalse(game1.isPresent());

    }

    @Test
    public void ShouldGetGamesByStudio() throws Exception {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);

        List<Game> gameList = GameRepo.findAllByStudio("Microsoft");

        //Assert
        assertEquals(gameList.size(),1);

    }

    @Test
    public void ShouldGetGamesByEsrbRating() throws Exception {

        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);

        List<Game> gameList = GameRepo.findAllByEsrbRating("Teen");

        //Assert
        assertEquals(gameList.size(),1);

    }

    @Test
    public void ShouldGetAllGamesByTitle () throws Exception {
        //Arrange
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        //Act
        game = GameRepo.save(game);

        List<Game> gameList = GameRepo.findAllByTitle("Minecraft");

        //Assert
        assertEquals(gameList.size(),1);

    }

}
