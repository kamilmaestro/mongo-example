package com.marnikkamil.bank.infrastructure.account;

import com.marnikkamil.bank.module.account.AccountFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
final class AccountController {

  AccountFacade accountFacade;

  @Autowired
  public AccountController(AccountFacade accountFacade) {
    this.accountFacade = accountFacade;
  }

  @PostMapping("/")
  public ResponseEntity<AccountDto> addPost(@RequestBody CreateDto name) {
    final AccountDto accountDto = accountFacade.saveAccount(name.getName());

    return ResponseEntity.ok(accountDto);
  }

}
