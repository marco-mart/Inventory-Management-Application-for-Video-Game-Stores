package com.company.gamestore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "fee")

public class Fee {

    @Id
    @Column(name = "fee_id")
    //@GeneratedValue(strategy =  GenerationType.IDENTITY)  we hard code fee data into the database the values aren't generated
    private int id;

    @NotNull
    @DecimalMax("999.99")
    @DecimalMin("0")
    @Digits(integer =8, fraction =2)
    private BigDecimal fee;

    @Size(max = 50)
    @NotNull
    @Column(name = "product_type")
    private String product;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fee fee1 = (Fee) o;
        return id == fee1.id && Objects.equals(fee, fee1.fee) && Objects.equals(product, fee1.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fee, product);
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", fee=" + fee +
                ", product_type='" + product + '\'' +
                '}';
    }
}
