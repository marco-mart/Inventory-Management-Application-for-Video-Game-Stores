package com.company.gamestore.repositories;

import com.company.gamestore.models.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest
{
    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception
    {
        invoiceRepository.deleteAll();
    }


    @Test
    public void shouldCreateInvoice() throws Exception
    {

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

        // Action
        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> invoiceSaveCheck = invoiceRepository.findById(invoice.getId());

        // Assert
        assertEquals(invoice, invoiceSaveCheck.get());
    }

    @Test
    public void shouldFindAllInvoices()
    {
        // Set Up
        List<Invoice> invoices = new ArrayList<>();

        Invoice invoice1 = new Invoice();
        invoice1.setName("Marco");
        invoice1.setStreet("Bruh St");
        invoice1.setCity("Deming");
        invoice1.setState("NM");
        invoice1.setZipcode("88012");
        invoice1.setItemType("Game");
        invoice1.setItemId(269);
        invoice1.setUnitPrice(new BigDecimal("12.99"));
        invoice1.setQuantity(3);
        invoice1.setSubtotal(new BigDecimal("38.97"));
        invoice1.setTax(new BigDecimal("0.05"));
        invoice1.setProcessingFee(new BigDecimal("15.49"));
        invoice1.setTotal(new BigDecimal("57.18"));

        invoice1 = invoiceRepository.save(invoice1);
        invoices.add(invoice1);

        Invoice invoice2 = new Invoice();
        invoice2.setName("Jonathan");
        invoice2.setStreet("Ayo Ave");
        invoice2.setCity("Miami");
        invoice2.setState("FL");
        invoice2.setZipcode("33172");
        invoice2.setItemType("Game");
        invoice2.setItemId(85);
        invoice2.setUnitPrice(new BigDecimal("8.99"));
        invoice2.setQuantity(2);
        invoice2.setSubtotal(new BigDecimal("17.98"));
        invoice2.setTax(new BigDecimal("0.05"));
        invoice2.setProcessingFee(new BigDecimal("15.49"));
        invoice2.setTotal(new BigDecimal("35.14"));

        invoice2 = invoiceRepository.save(invoice2);
        invoices.add(invoice2);


        Invoice invoice3 = new Invoice();
        invoice3.setName("Tremayne");
        invoice3.setStreet("Walnut St");
        invoice3.setCity("New York");
        invoice3.setState("NY");
        invoice3.setZipcode("10001");
        invoice3.setItemType("Console");
        invoice3.setItemId(41);
        invoice3.setUnitPrice(new BigDecimal("297.99"));
        invoice3.setQuantity(1);
        invoice3.setSubtotal(new BigDecimal("313.48"));
        invoice3.setTax(new BigDecimal("0.05"));
        invoice3.setProcessingFee(new BigDecimal("15.49"));
        invoice3.setTotal(new BigDecimal("329.15"));

        invoice3 = invoiceRepository.save(invoice3);
        invoices.add(invoice3);


        // Assert
        assertEquals(invoices, invoiceRepository.findAll());
    }

    @Test
    public void shouldFindAllInvoicesByName()
    {
        // Set Up
        List<Invoice> marcoInvoices = new ArrayList<>();

        Invoice invoice1 = new Invoice();
        invoice1.setName("Marco");
        invoice1.setStreet("Bruh St");
        invoice1.setCity("Deming");
        invoice1.setState("NM");
        invoice1.setZipcode("88012");
        invoice1.setItemType("Game");
        invoice1.setItemId(269);
        invoice1.setUnitPrice(new BigDecimal("12.99"));
        invoice1.setQuantity(3);
        invoice1.setSubtotal(new BigDecimal("38.97"));
        invoice1.setTax(new BigDecimal("0.05"));
        invoice1.setProcessingFee(new BigDecimal("15.49"));
        invoice1.setTotal(new BigDecimal("57.18"));

        invoice1 = invoiceRepository.save(invoice1);
        marcoInvoices.add(invoice1);

        Invoice invoice2 = new Invoice();
        invoice2.setName("Marco");
        invoice2.setStreet("Ayo Ave");
        invoice2.setCity("Miami");
        invoice2.setState("FL");
        invoice2.setZipcode("33172");
        invoice2.setItemType("Game");
        invoice2.setItemId(85);
        invoice2.setUnitPrice(new BigDecimal("8.99"));
        invoice2.setQuantity(2);
        invoice2.setSubtotal(new BigDecimal("17.98"));
        invoice2.setTax(new BigDecimal("0.05"));
        invoice2.setProcessingFee(new BigDecimal("15.49"));
        invoice2.setTotal(new BigDecimal("35.14"));

        invoice2 = invoiceRepository.save(invoice2);
        marcoInvoices.add(invoice2);


        Invoice invoice3 = new Invoice();
        invoice3.setName("Tremayne");
        invoice3.setStreet("Walnut St");
        invoice3.setCity("New York");
        invoice3.setState("NY");
        invoice3.setZipcode("10001");
        invoice3.setItemType("Console");
        invoice3.setItemId(41);
        invoice3.setUnitPrice(new BigDecimal("297.99"));
        invoice3.setQuantity(1);
        invoice3.setSubtotal(new BigDecimal("313.48"));
        invoice3.setTax(new BigDecimal("0.05"));
        invoice3.setProcessingFee(new BigDecimal("15.49"));
        invoice3.setTotal(new BigDecimal("329.15"));

        invoice3 = invoiceRepository.save(invoice3);


        // Assert
        assertEquals(marcoInvoices, invoiceRepository.findAllByName("Marco"));
    }

    @Test
    public void shouldFindInvoiceById()
    {
        // Set Up
        Invoice invoice1 = new Invoice();
        invoice1.setName("Marco");
        invoice1.setStreet("Bruh St");
        invoice1.setCity("Deming");
        invoice1.setState("NM");
        invoice1.setZipcode("88012");
        invoice1.setItemType("Game");
        invoice1.setItemId(269);
        invoice1.setUnitPrice(new BigDecimal("12.99"));
        invoice1.setQuantity(3);
        invoice1.setSubtotal(new BigDecimal("38.97"));
        invoice1.setTax(new BigDecimal("0.05"));
        invoice1.setProcessingFee(new BigDecimal("15.49"));
        invoice1.setTotal(new BigDecimal("57.18"));

        // Action
        invoice1 = invoiceRepository.save(invoice1);
        Optional<Invoice> result = invoiceRepository.findById(invoice1.getId());

        // Assert
        assertEquals(invoice1, result.get());
    }
}