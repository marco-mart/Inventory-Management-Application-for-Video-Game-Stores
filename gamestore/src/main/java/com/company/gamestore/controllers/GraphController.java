package com.company.gamestore.controllers;

import com.company.gamestore.models.Game;
import com.company.gamestore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController
{
    @Autowired
    GameRepository gameRepository;

    @QueryMapping
    public List<Game> findAllGames()
    {
        List<Game> games = gameRepository.findAll();
        return !games.isEmpty() ? games : null;
    }



//    findAllGames(): [Game]
//    findGameById(id: Int): Game
//findGameByTitle(title: String): Game
//findGamesByEsrbRating(esrb: String): [Game]
//    findGamesByStudio(studio: String): [Game]
}
