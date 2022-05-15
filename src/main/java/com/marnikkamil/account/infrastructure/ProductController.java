package com.marnikkamil.account.infrastructure;

import com.marnikkamil.account.domain.ProductFacade;
import com.marnikkamil.account.dto.ImportedProducts;
import com.marnikkamil.account.dto.ProductCategoryDto;
import com.marnikkamil.account.dto.ProductDto;
import com.marnikkamil.account.dto.SearchProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/product")
final class ProductController {

  private final ProductFacade productFacade;

  @Autowired
  public ProductController(ProductFacade productFacade) {
    this.productFacade = productFacade;
  }

  @PostMapping("/")
  public ResponseEntity<Collection<ProductCategoryDto>> importProducts(@RequestBody ImportedProducts products) {
    final Collection<ProductCategoryDto> product = productFacade.importProducts(products);
    return ResponseEntity.ok(product);
  }

  @PostMapping("/search/")
  public ResponseEntity<Collection<ProductDto>> search(@RequestBody SearchProductsDto products) {
    final Collection<ProductDto> product = productFacade.searchProducts(products);
    return ResponseEntity.ok(product);
  }

}
