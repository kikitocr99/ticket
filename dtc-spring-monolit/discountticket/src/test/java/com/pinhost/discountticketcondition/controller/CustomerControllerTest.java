package com.pinhost.discountticketcondition.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinhost.discountticketcondition.DiscountTicketConditionApplication;
import com.pinhost.discountticketcondition.config.DataSorceTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {DiscountTicketConditionApplication.class, DataSorceTestConfig.class})
//@AutoConfigureMockMvc
public class CustomerControllerTest {

    private MultiValueMap<String, String> params;

    private String wrongTocken;

    @Autowired
    private WebApplicationContext context;
    //@Autowired
    private MockMvc mvc;

    @Before
    public void setUp(){
        this.mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

        params = new LinkedMultiValueMap<>();
        params.add("username", "lnaranjo");
        params.add("password", "Test");

        wrongTocken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
    }

    @Test
    @WithMockUser(value = "lnaranjo", password = "Test")
    public void userIsAuthenticated() throws Exception {

        this.mvc.perform(post("/api/login").params(params)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
    @Test
    public void userIsForbidden() throws Exception {
        this.mvc.perform(get("/customer/hello")
                .header("Authorization", "Bearer " + obtainTocken()))
                .andExpect(status().isOk());
    }

    @Test
    public void getCustomerByName() throws Exception {
        MvcResult resul = this.mvc.perform(get("/customer/Luis")
                .header("Authorization", "Bearer " + obtainTocken()))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("DEr User ist: " + resul.getResponse().getContentAsString());
    }

    @Test
    public void userIsNotForbidden() throws Exception {
        this.mvc.perform(get("/customer/hello")
                .header("Authorization", "Bearer " + wrongTocken))
                .andExpect(status().isForbidden());
    }

    private String obtainTocken() throws Exception {

        ResultActions result =this.mvc.perform(post("/api/login").params(params)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(result.andReturn().getResponse().getContentAsString()).get("token").toString();
    }
}
