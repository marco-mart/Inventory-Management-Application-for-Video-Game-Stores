package com.company.gamestore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table
public class Console implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 50)
    @NotNull
    private String model;

    @Size(max = 50)
    @NotNull
    private String manufacturer;

    @Size(max = 20)
    @NotNull
    private String memory_amount;

    @Size(max = 20)
    @NotNull
    private String processor;

    @NotNull
    @DecimalMax("999.99")
    @DecimalMin("0")
    @Digits(integer=5, fraction=2)
    private BigDecimal price;

    @NotNull
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console that = (Console) o;
        return id == that.id && quantity == that.quantity && Objects.equals(model, that.model) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(memory_amount, that.memory_amount) && Objects.equals(processor, that.processor) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memory_amount, processor, price, quantity);
    }
}

