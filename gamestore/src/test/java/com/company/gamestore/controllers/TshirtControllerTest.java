package com.company.gamestore.controllers;

import com.company.gamestore.models.Tshirt;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TshirtController.class)
public class TshirtControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreateNewTshirt() throws Exception{
        Tshirt tshirt = new Tshirt();
        tshirt.setColor("Pink");
        tshirt.setSize("M");
        tshirt.setDescription("It's a pink shirt");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(15);

        String tshirtJson = mapper.writeValueAsString(tshirt);


        mockMVC.perform(
                put("/tshirts")
                .content(tshirtJson)
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

}

    @Test
    public void shouldDeleteTshirt() throws Exception {
        mockMVC.perform(
                        delete("/tshirts/1")
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetTshirtById() throws Exception {

        mockMVC.perform(
                        get("/tshirts/1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllTshirts()throws Exception
    {

        mockMVC.perform(
                        get("/tshirts")
                )
                .andDo(print())
                .andExpect(status().isOk());   // Assert status code 200
    }

    @Test
    public void shouldGetAllTshirtBySize () throws Exception {

        mockMVC.perform(
                        get("/tshirts/size/M")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllTshirtByColor () throws Exception {


        mockMVC.perform(
                        get("/tshirts/color/pink")
                )
                .andDo(print())
                .andExpect(status().isOk());   // Assert status code 200
    }



}


