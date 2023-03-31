package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Tshirtcontroller {

    @Autowired
    com.company.gamestore.repositories.TshirtRepository tshirtRepository;

    @PostMapping("/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt (@RequestBody Tshirt tshirt){
        return tshirtRepository.save(tshirt);
    }

    @PutMapping("tshirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody Tshirt tshirt){
        tshirtRepository.save(tshirt);
    }
    @GetMapping("/tshirt/{id}")
    public Tshirt findTshirtById(@PathVariable int id){
        Optional <Tshirt> tshirtFromRepo = tshirtRepository.findById(id);
        if(tshirtFromRepo.isPresent()){
            return tshirtFromRepo.get();
        } else{
            return null;
        }
    }

    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id){
        tshirtRepository.deleteById(id);
    }

    @GetMapping("/tshirts")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> findAllTshirt(){
        return tshirtRepository.findAll();
    }

    @GetMapping("/tshirts/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String size){
        return tshirtRepository.findAllBySize(size);
    }

    @GetMapping("/tshirts/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String color) {
        return tshirtRepository.findAllByColor(color);
    }
}

