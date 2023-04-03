package com.company.gamestore.controllers;

import com.company.gamestore.models.Invoice;
import com.company.gamestore.repositories.InvoiceRepository;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Tests creating a new Invoice record and its response
     *
     * HTTP Method: POST
     * Endpoint: "/invoices"
     * Request body: new Invoice object
     * Response body: newly added Invoice object
     *
     * Response Status: 201 Created
     */
    @Test
    public void shouldCreateNewInvoice() throws Exception {

        // Set Up
        Invoice invoice = new Invoice();
        invoice.setName("Marco");
        invoice.setStreet("Bruh St");
        invoice.setCity("Deming");
        invoice.setState("NM");
        invoice.setZipcode("88012");
        invoice.setItemType("Game");
        invoice.setItemId(269);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(3);
        invoice.setSubtotal(new BigDecimal("38.97"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("15.49"));
        invoice.setTotal(new BigDecimal("57.18"));

        String invoiceJson = mapper.writeValueAsString(invoice);

        // ACT
        mockMvc.perform(
                        post("/invoices")                          // Perform the POST request
                                .content(invoiceJson)                            // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)       // Tell the server that it is in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // Assert status code is 201
    }

    /**
     * Tests getting an Invoice by id
     *
     * HTTP Method: GET
     * Endpoint: "/invoices/{id}"
     * Request body: n/a
     * Response body: Invoice (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetInvoiceById() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/invoices/1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Tests getting all Invoices
     *
     * HTTP Method: GET
     * Endpoint: "/invoices"
     * Request body: n/a
     * Response body: invoices (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetAllInvoices() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/invoices")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Tests getting Invoice by Customer Name
     *
     * HTTP Method: GET
     * Endpoint: "/invoices/customer/{name}"
     * Request body: n/a
     * Response body: Invoice (if found)
     *
     * Response Status: 200 Ok
     */
    @Test
    public void shouldGetInvoicesByCustomerName() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                        get("/invoices/customer/Joe")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
