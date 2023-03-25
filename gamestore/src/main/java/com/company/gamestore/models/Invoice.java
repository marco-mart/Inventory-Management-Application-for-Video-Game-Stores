package com.company.gamestore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer",  "handler"})
@Table(name = "invoice")
public class Invoice
{
    /**
     * Note: attributes without "NotNull" annotation is intentional,
     * and in line with the database
     * */

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @NotNull
    private String name;

    @Size(max = 100)
    private String street;

    @Size(max = 50)
    @NotNull
    private String city;

    /**
     * Database invoice table allows for the value of "state" to be 20
     * characters long, however, the tax table only allows "state" to be
     * 2 characters long. Therefore, because we are not allowed to change
     * the database, the max size of the "state" that is allowed to be entered
     * in the invoice table is 2.
     *
     * Also, "state" can only be capital letters for consistency
     *
     * This would make it easier for queries based on "state"
     * */
    @Size(max = 2)
    @Pattern(regexp = "[A-Z]+", message = "State must be 2 capital letters eg. CA, NY, NM")
    @NotNull
    private String state;

    @Pattern(regexp = "[0-9]+", message = "Zip code must be at max 10 numbers long")
    @Size(max = 10)
    private String zipcode;

    @Size(max = 50)
    @Column(name = "item_type")
    @NotNull
    private String itemType;

    @Column(name = "item_id")
    @NotNull
    private Integer itemId;

    @Column(name = "unit_price")
    @NotNull
    private BigDecimal unitPrice;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal subtotal;
    @NotNull
    private BigDecimal tax;

    @Column(name = "processing_fee")
    @NotNull
    private BigDecimal processingFee;

    @NotNull
    private BigDecimal total;


    // getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
