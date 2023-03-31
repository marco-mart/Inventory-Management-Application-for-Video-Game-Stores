package com.company.gamestore.service;

import com.company.gamestore.models.*;
import com.company.gamestore.repositories.*;
import com.company.gamestore.repositories.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer
{
    private ConsoleRepository consoleRepository;
    private GameRepository gameRepository;
    private TshirtRepository tshirtRepository;
    private InvoiceRepository invoiceRepository;
    private TaxRepository taxRepository;
    private FeeRepository feeRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository,
                        GameRepository gameRepository,
                        TshirtRepository tshirtRepository,
                        InvoiceRepository invoiceRepository,
                        TaxRepository taxRepository,
                        FeeRepository feeRepository)
    {

        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.tshirtRepository = tshirtRepository;
        this.invoiceRepository = invoiceRepository;
        this.taxRepository = taxRepository;
        this.feeRepository = feeRepository;
    }

    // --------------------- SAVES -----------------------------

    public Console saveConsole(Console console) {

        return consoleRepository.save(console);
    }

    public Tshirt saveTshirt(Tshirt tshirt) {

        return tshirtRepository.save(tshirt);
    }

    public Game saveGame(Game game) {

        return gameRepository.save(game);
    }

    public Invoice saveInvoice(Invoice invoice)
    {
        return invoiceRepository.save(invoice);
    }

    // ------------------- GET BY ID -------------------------

    public Console findConsoleById(Integer id) {
        Optional<Console> console = consoleRepository.findById(id);
        return console.isPresent() ? console.get() : null;
    }

    public Tshirt findTshirtById(Integer id) {
        Optional<Tshirt> tshirt = tshirtRepository.findById(id);
        return tshirt.isPresent() ? tshirt.get() : null;
    }

    public Game findGameById(Integer id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.isPresent() ? game.get() : null;
    }

    public Invoice findInvoiceById(Integer id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.isPresent() ? invoice.get() : null;
    }



    // ------------------------ GET ALL ----------------------------

    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    public List<Tshirt> findAllTshirts()
    {
        return tshirtRepository.findAll();
    }

    public List<Game> findAllGames()
    {
        return gameRepository.findAll();
    }

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }


    // --------------------- DELETE BY ID ------------------------------

    public void deleteConsoleById(Integer id)
    {
        consoleRepository.deleteById(id);
    }

    public void deleteTshirtById(Integer id)
    {
        tshirtRepository.deleteById(id);
    }

    public void deleteGameById(Integer id)
    {
        gameRepository.deleteById(id);
    }

    public void deleteInvoiceById(Integer id)
    {
        invoiceRepository.deleteById(id);
    }


    // ------------------------- CUSTOM QUERIES -----------------------------------------

    // Console
    public List<Console> findAllConsoleByManufacturer(String manufacturer)
    {
        return consoleRepository.findAllByManufacturer(manufacturer);
    }

    // Game
    public List<Game> findAllGamesByStudio(String studio)
    {
        return gameRepository.findAllByStudio(studio);
    }

    public List<Game> findAllGamesByEsrbRating(String esrbRating)
    {
        return gameRepository.findAllByEsrbRating(esrbRating);
    }

    public List<Game> findAllGamesByTitle(String title)
    {
        return gameRepository.findAllByTitle(title);
    }

    // Invoice
    public List<Invoice> findAllInvoicesByName(String name)
    {
        return invoiceRepository.findAllByName(name);
    }

    // Tshirt
    public List<Tshirt> findAllTshirtsByColor(String color)
    {
        return tshirtRepository.findAllByColor(color);
    }

    public List<Tshirt> findAllTshirtBySize(String size)
    {
        return tshirtRepository.findAllBySize(size);
    }



}