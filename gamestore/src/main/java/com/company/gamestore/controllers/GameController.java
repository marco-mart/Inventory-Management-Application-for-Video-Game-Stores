package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.repositories.GameRepository;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository repo;

    /*
    CRUD
     */

    @PostMapping("/games") //Create a game
    @ResponseStatus(HttpStatus.CREATED)
    public void createGame(@RequestBody Game game){ repo.save(game);}

    @GetMapping("/games/{id}") //Get game by Id
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable int id){
        Optional<Game> game  = repo.findById(id);

        if (game.isPresent()){
            return game.get();
        } else {
            return null;
        }
    }

    @GetMapping("/games") //Get all games
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {return repo.findAll();}

    @PutMapping("/games") //Update a game
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game){repo.save(game);}

    @DeleteMapping("/games/{id}") //Delete a game by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id){ repo.deleteById(id);}

    /*
    Custom querys
     */

    @GetMapping("/games/studio/{studio}") //Get all games by studio
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByStudio(@PathVariable String studio){return repo.findAllByStudio(studio);}

    @GetMapping("/games/esrb/{esrb}") //Get all games by esrb rating
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByRating(@PathVariable String esrb){return repo.findAllByEsrbRating(esrb);}

    @GetMapping("/games/title/{title}") // Get all game by title ----should maybe make this return one object instead of a list
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByTitle(@PathVariable String title){return repo.findAllByTitle(title);}


}
