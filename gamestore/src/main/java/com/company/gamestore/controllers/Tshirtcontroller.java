package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
import com.company.gamestore.respositories.TshirtRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Tshirtcontroller {

    @Autowired
    TshirtRespository tshirtRespository;

    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt (@RequestBody Tshirt tshirt){
        return tshirtRespository.save(tshirt);
    }

    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody Tshirt tshirt){
        tshirtRespository.save(tshirt);
    }
    @GetMapping("/tshirts/{id}")
    public Tshirt findTshirtById(@PathVariable int id){
        Optional <Tshirt> tshirtFromRepo = tshirtRespository.findById(id);
        if(tshirtFromRepo.isPresent()){
            return tshirtFromRepo.get();
        } else{
            return null;
        }
    }

    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id){
        tshirtRespository.deleteById(id);
    }

    @GetMapping("/tshirts")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> findAllTshirt(){
        return tshirtRespository.findAll();
    }

    @GetMapping("/tshirts/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String size){
        return tshirtRespository.findAllBySize(size);
    }

    @GetMapping("/tshirts/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String color) {
        return tshirtRespository.findAllByColor(color);
    }
}

