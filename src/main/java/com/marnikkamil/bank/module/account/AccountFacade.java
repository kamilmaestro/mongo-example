package com.marnikkamil.bank.module.account;

import com.marnikkamil.bank.infrastructure.account.AccountDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class AccountFacade {

  AccountRepository accountRepository;

  public AccountDto saveAccount(String name) {
    final Account account = new Account(name);
    return accountRepository.save(account).dto();
  }

}
