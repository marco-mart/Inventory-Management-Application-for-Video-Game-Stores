package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.repositories.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ConsoleController {


    @Autowired
    ConsoleRepository consoleRepository;

//    Get Console by ID
//    HTTP Method GET
//    Endpoint: "/consoles/{console_id}"
//    Request body: n/a
//    Response Status: 200 OK

    @GetMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id) {
        Optional<Console> console = consoleRepository.findById(id);
        return console.isPresent() ? console.get() : null;
    }

    @GetMapping("/consoles")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllInvoice() {
        Optional<List<Console>> consoles = Optional.of(consoleRepository.findAll());
        return consoles.isPresent() ? consoles.get() : null;
    }

    @GetMapping("consoles/manufacturer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String name) {
        Optional<List<Console>> consoleByManufacturer = Optional.of(consoleRepository.findAllByManufacturer(name));
        return consoleByManufacturer.isPresent() ? consoleByManufacturer.get() : null;
    }

    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public void createConsole(@RequestBody @Valid Console console) {
        consoleRepository.save(console);
    }

    @PutMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid Console console, @PathVariable int id) {
        consoleRepository.save(console);
    }

    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        consoleRepository.deleteById(id);
    }

}
