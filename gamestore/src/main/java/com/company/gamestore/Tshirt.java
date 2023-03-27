package com.company.gamestore.models;

import javax.persistence.*;

import javax.validation.constraints.*;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import javax.validation.constraints.Size;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nonapi.io.github.classgraph.json.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tshirt")

public class Tshirt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tshirt_id")
    private int id;

    @NotNull
    @DecimalMax("999.99")
    @DecimalMin("0")
    @Digits(integer=5, fraction=2)
    private BigDecimal price;

    @NotNull
    private int quantity;

    @Size(max = 50)
    @NotNull
    private String color;

    @Size(max = 10)
    @NotNull
    private String size;

    @Size(max = 250)
    @NotNull
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tshirt tshirt = (Tshirt) o;
        return id == tshirt.id && quantity == tshirt.quantity && Objects.equals(price, tshirt.price) && Objects.equals(color, tshirt.color) && Objects.equals(size, tshirt.size) && Objects.equals(description, tshirt.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity, color, size, description);
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

