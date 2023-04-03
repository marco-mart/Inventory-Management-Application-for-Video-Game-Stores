package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {


    @Autowired
    ServiceLayer serviceLayer;

    /*
    CRUD
     */

    @PostMapping("/games") //Create a game
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game){ return serviceLayer.saveGame(game);}

    @GetMapping("/games/{id}") //Get game by Id
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable int id){
        return serviceLayer.findGameById(id);
    }

    @GetMapping("/games") //Get all games
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {return serviceLayer.findAllGames();}

    @PutMapping("/games") //Update a game
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game){serviceLayer.saveGame(game);}

    @DeleteMapping("/games/{id}") //Delete a game by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id){ serviceLayer.deleteGameById(id);}

    /*
    Custom querys
     */

    @GetMapping("/games/studio/{studio}") //Get all games by studio
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio){return serviceLayer.findAllGamesByStudio(studio);}

    @GetMapping("/games/esrb/{esrb}") //Get all games by esrb rating
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByRating(@PathVariable String esrb){return serviceLayer.findAllGamesByEsrbRating(esrb);}

    @GetMapping("/games/title/{title}") // Get all game by title ----should maybe make this return one object instead of a list
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title){return serviceLayer.findAllGamesByTitle(title);}


}
