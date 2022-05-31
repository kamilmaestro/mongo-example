package com.marnikkamil.account.infrastructure;

import com.marnikkamil.account.domain.ProductFacade;
import com.marnikkamil.account.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PutMapping("/change/")
  public ResponseEntity<ProductCategoryDto> moveProducts(@RequestBody ChangedCategory changedCategory) {
    final ProductCategoryDto category = productFacade.changeCategoryForProducts(changedCategory);
    return ResponseEntity.ok(category);
  }

  @GetMapping("/search")
  public ResponseEntity<Collection<ProductDto>> search(@RequestParam String text,
                                                       @RequestParam double minPrice,
                                                       @RequestParam double maxPrice) {
    final Collection<ProductDto> product = productFacade.searchProducts(
        new SearchProductsDto(text, minPrice, maxPrice));
    return ResponseEntity.ok(product);
  }

}
