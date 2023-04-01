package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.repositories.ConsoleRepository;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ConsoleController {


    @Autowired
    ServiceLayer serviceLayer;

//    Get Console by ID
//    HTTP Method GET
//    Endpoint: "/consoles/{console_id}"
//    Request body: n/a
//    Response Status: 200 OK

    @GetMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id) {
        return serviceLayer.findConsoleById(id);
    }

    @GetMapping("/consoles")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsole() {
        return serviceLayer.findAllConsoles();
    }

    @GetMapping("consoles/manufacturer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String name) {
        return serviceLayer.findAllConsoleByManufacturer(name);
    }

    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {
        return serviceLayer.saveConsole(console);
    }

    @PutMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid Console console, @PathVariable int id) {
        serviceLayer.saveConsole(console);
    }

    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        serviceLayer.deleteConsoleById(id);
    }

}
