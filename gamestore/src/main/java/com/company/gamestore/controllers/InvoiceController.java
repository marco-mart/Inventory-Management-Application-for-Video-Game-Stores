package com.company.gamestore.controllers;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController
{

    @Autowired
    InvoiceRepository invoiceRepository;

    /**
     * Get Invoice by Id
     *
     * HTTP Method: GET
     * Endpoint: "/invoices/{invoice_id}"
     * Request body: n/a
     * Response body: Invoice View Model (if found)
     *
     * Response Status: 200 OK
     *
     * *Retrieves Invoice View Model by id
     * */
    @GetMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id)
    {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.isPresent() ? invoice.get() : null;
    }

    /**
     * Get all Invoices
     *
     * HTTP Method: GET
     * Endpoint: "/invoices"
     * Request body: n/a
     * Response body: Invoice View Models (if any)
     *
     * Response Status: 200 OK
     *
     * *Retrieves all Invoice View Models
     * */
    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoice()
    {
        Optional<List<Invoice>> invoices = Optional.of(invoiceRepository.findAll());
        return invoices.isPresent() ? invoices.get() : null;
    }

    /**
     * Get all Invoices by Customer name
     *
     * HTTP Method: GET
     * Endpoint: "/invoices/{customer_name}"
     * Request body: n/a
     * Response body: Invoice View Models (if any)
     *
     * Response Status: 200 OK
     *
     * *Retrieves Invoice View Models by Customer Name (if any)
     * */
    @GetMapping("/invoices/customer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoicesByCustomerName(@PathVariable String name)
    {
        Optional<List<Invoice>> invoicesByCustomerName = Optional.of(invoiceRepository.findAllByName(name));
        return invoicesByCustomerName.isPresent() ? invoicesByCustomerName.get() : null;
    }


    /**
     * Create new Invoice
     *
     * HTTP Method: POST
     * Endpoint: "/invoices"
     * Request body: new Invoice object
     * Response body: newly added Invoice object
     *
     * Response Status: 201 Created
     * */
    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice)
    {
        return invoiceRepository.save(invoice);
    }



}
