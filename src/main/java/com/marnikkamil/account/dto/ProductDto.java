package com.marnikkamil.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public final class ProductDto {

  String id;
  String name;
  Integer amount;
  double price;

}
