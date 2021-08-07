package com.greenzoo.resttdd.greenzooresttdd.accounts;

import com.greenzoo.resttdd.greenzooresttdd.controller.GreenZooController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class AccountResource extends EntityModel<Account> {

    public AccountResource(Account account, Link... links) {
        super(account, links);
        add(linkTo(GreenZooController.class).slash(account.getId()).withSelfRel());
    }
}
