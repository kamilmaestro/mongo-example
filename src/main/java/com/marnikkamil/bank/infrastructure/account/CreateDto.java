package com.marnikkamil.bank.infrastructure.account;

public final class CreateDto {

  String name;

  public CreateDto() {
  }

  public CreateDto(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
