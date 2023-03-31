package com.company.gamestore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name ="tax")


public class Tax {

    @Id
    @Column(name = "tax_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)  we hard code tax data into the database the values aren't generated
    private int id;

    @NotNull
    @Size(max = 2)
    private String state;

    @NotNull
    @DecimalMax("999.99")
    @DecimalMin("0")
    @Digits(integer= 8, fraction= 2)
    private BigDecimal rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return id == tax.id && Objects.equals(state, tax.state) && Objects.equals(rate, tax.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, rate);
    }

    @Override
    public String toString() {
        return "Tax{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
