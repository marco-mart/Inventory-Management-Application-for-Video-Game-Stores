package com.company.gamestore.controllers;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.service.ServiceLayer;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController
{

    @Autowired
    ServiceLayer serviceLayer;

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
        return serviceLayer.findInvoiceById(id);
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
        return serviceLayer.findAllInvoices();
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
        return serviceLayer.findAllInvoicesByName(name);
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
    public InvoiceViewModel createInvoice(@RequestBody @Valid InvoiceViewModel invoice)
    {
        return serviceLayer.saveInvoice(invoice);
    }



}
