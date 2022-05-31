package com.marnikkamil.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public final class ChangedCategory {

  String oldCategoryId;
  String newCategoryId;

}
