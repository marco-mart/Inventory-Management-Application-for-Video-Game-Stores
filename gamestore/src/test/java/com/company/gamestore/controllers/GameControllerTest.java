package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreateNewGame() throws Exception {

        //ARRANGE

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        String gameJson = mapper.writeValueAsString(game);

        //ACT

        mockMvc.perform(
                        post("/games")                          // Perform the POST request
                                .content(gameJson)                            // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)       // Tell the server that it is in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());               // Assert status code is 201
    }

    @Test
    public void shouldUpdateGame () throws Exception {

        // ARRANGE

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("Teen");
        game.setDescription("Dont mine at night");
        BigDecimal price = new BigDecimal("9.99");
        game.setPrice(price);
        game.setStudio("Microsoft");
        game.setQuantity(21);

        String gameJson = mapper.writeValueAsString(game);

        // ACT

        mockMvc.perform(
                        put("/games")                                 // Perform the PUT request
                                .content(gameJson)                           // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)            // Tell the server that it is JSON format
                )
                .andDo(print())                                             // Print results to console
                .andExpect(status().isNoContent());                         // Assert status code is 204
    }

    @Test
    public void shouldDeleteGame() throws Exception {

        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        delete("/games/1")                        // Perform DELETE
                )
                .andDo(print())                                         // Print results to Console
                .andExpect(status().isNoContent());                     // Assert status code 204
    }

    @Test
    public void shouldGetGameById() throws Exception {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/games/1")
                )
                .andDo(print())
                .andExpect(status().isOk());   // Assert status code 200
    }

    @Test
    public void shouldGetAllGames () throws Exception {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/games")
                )
                .andDo(print())
                .andExpect(status().isOk());   // Assert status code 200
    }

    @Test
    public void shouldGetAllGamesByStudio () throws Exception {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/games/studio/Riot")
                )
                .andDo(print())
                .andExpect(status().isOk());   // Assert status code 200
    }

    @Test
    public void shouldGetAllGamesByEsrbRating () throws Exception {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/games/esrb/Teen")
                )
                .andDo(print())
                .andExpect(status().isOk());   // Assert status code 200
    }

    @Test
    public void shouldGetAllGamesByTitle () throws Exception {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/games/title/Roblox")
                )
                .andDo(print())
                .andExpect(status().isOk());   // Assert status code 200
    }


}
