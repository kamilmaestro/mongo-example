package com.marnikkamil.account.infrastructure;

import com.marnikkamil.account.domain.ProductFacade;
import com.marnikkamil.account.dto.ImportedProducts;
import com.marnikkamil.account.dto.ProductDto;
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
final class ProductController {

  private final ProductFacade productFacade;

  @Autowired
  public ProductController(ProductFacade productFacade) {
    this.productFacade = productFacade;
  }

  @PostMapping("/")
  public ResponseEntity<ProductDto> importProducts(@RequestBody ImportedProducts products) {
    final ProductDto product = productFacade.importProducts(products);
    return ResponseEntity.ok(product);
  }

}
