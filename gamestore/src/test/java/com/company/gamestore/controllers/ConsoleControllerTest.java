package com.company.gamestore.controllers;

import com.company.gamestore.models.Console;
import com.company.gamestore.repositories.ConsoleRepository;
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
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreateNewConsole() throws Exception {

        Console console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("500 gb");
        console.setProcessor("Intel i9");
        BigDecimal price = new BigDecimal("500.00");
        console.setPrice(price);
        console.setQuantity(20);

        String consoleJson = mapper.writeValueAsString(console);

//        Act
        mockMvc.perform(
                post("/consoles").content(consoleJson).
                        contentType(MediaType.APPLICATION_JSON)).
                andDo(print()).
                andExpect(status().isCreated());
    }

    @Test
    public void shouldGetConsoleById() throws Exception {
        mockMvc.perform(get("/consoles/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllConsoles() throws Exception {


        mockMvc.perform(get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetConsolesByManufacturer() throws Exception {
        mockMvc.perform(
                get("/consoles/manufacturer/Sony")).andDo(print()).andExpect(status().isOk());
    }


}