package com.greenzoo.resttdd.greenzooresttdd.controller;

import com.greenzoo.resttdd.greenzooresttdd.accounts.Account;
import com.greenzoo.resttdd.greenzooresttdd.accounts.AccountResource;
import com.greenzoo.resttdd.greenzooresttdd.accounts.AccountRole;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/accounts", produces = MediaTypes.HAL_JSON_VALUE)
public class GreenZooController {


    @GetMapping("/{id}")
    public ResponseEntity getAccount(@PathVariable Integer id, Error errors){
        Account account = new Account();
        account.setId(1);
        account.setEmail("email@email.com");
        account.setPassword("********");
        account.setRoles(Collections.singleton(AccountRole.USER));

        AccountResource accountResource = new AccountResource(account);
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("get-account"));
        accountResource.add(linkTo(GreenZooController.class).withRel("create-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("update-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("delete-account"));

        return ResponseEntity.ok(accountResource);
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody Account account, Error errors){
        // DB 상에서 account를 insert함
        Account newAccount = account;

        AccountResource accountResource = new AccountResource(newAccount);
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("get-account"));
        accountResource.add(linkTo(GreenZooController.class).withRel("create-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("update-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("delete-account"));
        return ResponseEntity.ok(accountResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable Integer id,
                                        @RequestBody Account account, Error errors){
        // Account Id가 Id인 애를 조회한다.
        Account findOneAccount = new Account();

        // DB상에서 업데이트함
        findOneAccount = account;

        AccountResource accountResource = new AccountResource(findOneAccount);
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("get-account"));
        accountResource.add(linkTo(GreenZooController.class).withRel("create-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("update-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("delete-account"));
        return ResponseEntity.ok(accountResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Integer id, Error errors){
        // Account Id가 Id인 애를 조회한다.
        Account account = new Account();

        // DB상에서 삭제함
        account.setId(id);

        AccountResource accountResource = new AccountResource(account);
        // 삭제했으므로 조회하지못함? 조회는 가능하나 null인걸로 해야하나...?
        //accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("get-account"));
        accountResource.add(linkTo(GreenZooController.class).withRel("create-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("update-account"));
        accountResource.add(linkTo(GreenZooController.class).slash(account.getId()).withRel("delete-account"));
        return ResponseEntity.ok(accountResource);
    }
}
