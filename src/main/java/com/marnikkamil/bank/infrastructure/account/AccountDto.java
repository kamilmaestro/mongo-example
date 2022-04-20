package com.marnikkamil.bank.infrastructure.account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class AccountDto {

  String id;
  String accountName;

}
