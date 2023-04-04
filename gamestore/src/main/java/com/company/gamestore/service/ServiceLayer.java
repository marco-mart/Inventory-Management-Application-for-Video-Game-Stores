package com.company.gamestore.service;

import com.company.gamestore.models.*;
import com.company.gamestore.repositories.*;
import com.company.gamestore.repositories.TshirtRepository;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.View;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

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

    public InvoiceViewModel saveInvoice(InvoiceViewModel InvoiceView)
    {
        Invoice invoice = new Invoice();

        BigDecimal total = new BigDecimal("0.00");

        /*
          {
            "name": "Customer 1",
            "street": "100 Main Street",
            "city": "Clovis",
            "state": "CA",
            "zipcode": "93612",
            "itemType": "Game",
            "itemId": 269,
            "quantity": 12
          }
        */

        /*
         invoice_id int primary key auto_increment,
        name varchar(50) not null,
        street varchar(100) null,
        city varchar(50) not null,
        state varchar(20) not null,
        zipcode varchar(10) null,
        item_type varchar(50) not null,
        item_id int not null, -- links to either game, console, or t_shirt ids
        unit_price decimal(8,2) not null,
        quantity int not null,
        subtotal decimal(8,2) not null,
        tax decimal(8,2) not null,
        processing_fee decimal(8,2) not null,
        total decimal(8,2) not null
        * */

        BigDecimal subtotal = new BigDecimal("0.00");

        try{

            if (InvoiceView.getItemType().equals("Console") || InvoiceView.getItemType().equals("console")){

                Optional<Console> getConsole = consoleRepository.findById(InvoiceView.getItemId());


                if (!getConsole.isPresent()){
                    throw new InputMismatchException();
                }

                Console console = getConsole.get();

                if (InvoiceView.getQuantity() > console.getQuantity() || InvoiceView.getQuantity() < 1){
                    throw new InputMismatchException();
                } else {
                    console.setQuantity(console.getQuantity() - InvoiceView.getQuantity());

                }

                subtotal = console.getPrice();
                invoice.setUnitPrice(console.getPrice());

                BigDecimal BigQuantity = new BigDecimal(console.getQuantity());

                subtotal = subtotal.multiply(BigQuantity);

                consoleRepository.save(console);

            }
            else if(InvoiceView.getItemType().equals("Game")  || InvoiceView.getItemType().equals("game")) {

                Optional<Game> getGame = gameRepository.findById(InvoiceView.getItemId());

                if (!getGame.isPresent()){
                    throw new InputMismatchException();
                }

                Game game = getGame.get();

                if (InvoiceView.getQuantity() > game.getQuantity() || InvoiceView.getQuantity() < 1){
                    throw new InputMismatchException();
                } else {
                    game.setQuantity(game.getQuantity() - InvoiceView.getQuantity());
                }

                subtotal = game.getPrice();
                invoice.setUnitPrice(game.getPrice());

                BigDecimal BigQuantity = new BigDecimal(game.getQuantity());

                subtotal = subtotal.multiply(BigQuantity);

                gameRepository.save(game);


            } else if (InvoiceView.getItemType().equals("Tshirt")   || InvoiceView.getItemType().equals("tshirt")
                    || InvoiceView.getItemType().equals("T-shirt")  || InvoiceView.getItemType().equals("t-shirt")){

                Optional<Tshirt> getTshirt = tshirtRepository.findById(InvoiceView.getItemId());

                if (!getTshirt.isPresent()){
                  throw new InputMismatchException();
                }

                Tshirt tshirt = getTshirt.get();

                if (InvoiceView.getQuantity() > tshirt.getQuantity() || InvoiceView.getQuantity() < 1){
                    throw new InputMismatchException();
                } else {
                    tshirt.setQuantity(tshirt.getQuantity() - InvoiceView.getQuantity());
                }

                subtotal = tshirt.getPrice();
                invoice.setUnitPrice(tshirt.getPrice());

                BigDecimal BigQuantity = new BigDecimal(tshirt.getQuantity());

                subtotal = subtotal.multiply(BigQuantity);

                tshirtRepository.save(tshirt);


            } else {
                throw new InputMismatchException();

            }
        }

        catch (InputMismatchException e) {

        }

        invoice.setSubtotal(subtotal);

        BigDecimal extraFee = new BigDecimal("0.00");

        if (InvoiceView.getQuantity() > 10){
           extraFee = new BigDecimal("15.49");
        }

        Optional<Fee> ProcessingFee = feeRepository.findByProduct(InvoiceView.getItemType());
        BigDecimal fee = ProcessingFee.get().getFee();
        fee = fee.add(extraFee);
        invoice.setProcessingFee(fee);

        Optional<Tax> StateTax = taxRepository.findByState(InvoiceView.getState());

        try {
            if (!StateTax.isPresent()) {
                throw new InputMismatchException();
            }
        }
        catch(InputMismatchException e) {}


        BigDecimal tax = StateTax.get().getRate();
        invoice.setTax(tax);

        total = total.add(subtotal);
        BigDecimal taxAmount = subtotal;
        taxAmount = taxAmount.multiply(tax);
        total = total.add(taxAmount);
        total = total.add(fee);

        invoice.setTotal(total);
        invoice.setName(InvoiceView.getName());
        invoice.setStreet(InvoiceView.getStreet());
        invoice.setCity(InvoiceView.getCity());
        invoice.setState(InvoiceView.getState());
        invoice.setZipcode(InvoiceView.getZipcode());
        invoice.setItemType(InvoiceView.getItemType());
        invoice.setItemId(InvoiceView.getItemId());
        invoice.setQuantity(InvoiceView.getQuantity());

        invoiceRepository.save(invoice);

        return InvoiceView;
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