package com.marnikkamil.bank.module.account;

final class Share {

  private final String companyId;
  private final float percentage;

  Share(String companyId, float percentage) {
    this.companyId = companyId;
    this.percentage = percentage;
  }

}
