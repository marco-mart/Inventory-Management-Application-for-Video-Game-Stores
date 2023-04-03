package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TshirtController {


    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt (@RequestBody Tshirt tshirt){
        return serviceLayer.saveTshirt(tshirt);
    }

    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody Tshirt tshirt){
        serviceLayer.saveTshirt(tshirt);
    }
    @GetMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tshirt findTshirtById(@PathVariable int id){
        return serviceLayer.findTshirtById(id);
    }

    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id){
        serviceLayer.deleteTshirtById(id);
    }

    @GetMapping("/tshirts")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> findAllTshirt(){
        return serviceLayer.findAllTshirts();
    }

    @GetMapping("/tshirts/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String size){
        return serviceLayer.findAllTshirtBySize(size);
    }

    @GetMapping("/tshirts/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String color) {
        return serviceLayer.findAllTshirtsByColor(color);
    }
}

