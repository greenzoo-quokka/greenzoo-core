package com.greenzoo.resttdd.greenzooresttdd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenzoo.resttdd.greenzooresttdd.accounts.Account;
import com.greenzoo.resttdd.greenzooresttdd.accounts.AccountRole;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureRestDocs
//@Import(RestDocsConfiguration.class)
@ActiveProfiles("test")
@Disabled
class GreenzooResttddApplicationTests{

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ModelMapper modelMapper;

    @Test
    @DisplayName("기존 계정 하나 조회하기")
    public void getAccount() throws Exception {
        // Given
        Account account = new Account();
        account.setId(1);

        // When & Then
        this.mockMvc.perform(get("/accounts/{id}", account.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("1"))
                .andExpect(jsonPath("email").value("email@email.com"))
                .andExpect(jsonPath("password").value("********"))
                .andExpect(jsonPath("_links.self").exists())
        ;
    }

    @Test
    @DisplayName("기존 계정 하나 저장하기")
    public void createAccount() throws Exception {
        // Given
        Account account = new Account();
        account.setId(1);
        account.setEmail("email");
        account.setPassword("password");
        account.setRoles(Collections.singleton(AccountRole.USER));

        // When & Then
        this.mockMvc.perform(post("/accounts/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_links.self").exists())
        ;
    }

    @Test
    @DisplayName("기존 계정 하나 업데이트하기")
    public void updateAccount() throws Exception {
        // Given
        Account account = new Account();
        account.setId(1);
        account.setEmail("email");
        account.setPassword("password");
        account.setRoles(Collections.singleton(AccountRole.USER));

        // When & Then
        this.mockMvc.perform(put("/accounts/{id}", account.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_links.self").exists())
        ;
    }

    @Test
    @DisplayName("기존 계정 하나 삭제하기")
    public void deleteAccount() throws Exception {
        // When & Then
        this.mockMvc.perform(delete("/accounts/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_links.self").exists())
        ;
    }
}
