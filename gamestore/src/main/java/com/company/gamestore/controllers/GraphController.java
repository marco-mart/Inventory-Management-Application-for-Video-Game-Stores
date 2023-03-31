package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.models.Game;
import com.company.gamestore.repositories.ConsoleRepository;
import com.company.gamestore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController
{
    @Autowired
    GameRepository gameRepository;

    @Autowired
    ConsoleRepository consoleRepository;

    /**
     * Game queries
     * */
    @QueryMapping
    public List<Game> findAllGames()
    {
        return gameRepository.findAll();
    }

    @QueryMapping
    public Game findGameById(@Argument Integer id)
    {
        Optional<Game> game = gameRepository.findById(id);
        return game.isPresent() ? game.get() : null;
    }

    @QueryMapping
    public List<Game> findGamesByTitle(@Argument String title)
    {
        /**
         * Note: Games could have the same name. Example:
         *       A revamp of an old game like "Tomb Raider" (1996)
         *       and "Tomb Raider" (2013)
         * */
        return gameRepository.findAllByTitle(title);
    }

    @QueryMapping
    public List<Game> findGamesByEsrbRating(@Argument String esrb)
    {
        return gameRepository.findAllByEsrbRating(esrb);
    }

    @QueryMapping
    public List<Game> findGamesByStudio(@Argument String studio)
    {
        return gameRepository.findAllByStudio(studio);
    }


    /**
     * Console queries
     * */
    @QueryMapping
    public List<Console> findAllConsoles()
    {
        return consoleRepository.findAll();
    }

    @QueryMapping
    public Console findConsoleById(@Argument Integer id)
    {
        Optional<Console> console = consoleRepository.findById(id);
        return console.isPresent() ? console.get() : null;
    }

    @QueryMapping
    public List<Console> findConsolesByManufacturer(@Argument String manufacturer)
    {
        return consoleRepository.findAllByManufacturer(manufacturer);
    }
}
