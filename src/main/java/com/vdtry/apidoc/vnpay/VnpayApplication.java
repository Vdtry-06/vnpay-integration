package com.vdtry.apidoc.vnpay;

import com.vdtry.apidoc.vnpay.category.CategoryDTO;
import com.vdtry.apidoc.vnpay.category.CategoryService;
import com.vdtry.apidoc.vnpay.product.ProductDTO;
import com.vdtry.apidoc.vnpay.product.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VnpayApplication implements CommandLineRunner {
	CategoryService categoryService;
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(VnpayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryService.addCategory(CategoryDTO.CreateRequest.builder().name("Category 1").description("Description 1").build());
		categoryService.addCategory(CategoryDTO.CreateRequest.builder().name("Category 2").description("Description 2").build());
		categoryService.addCategory(CategoryDTO.CreateRequest.builder().name("Category 3").description("Description 3").build());

		productService.create(ProductDTO.CreateRequest
				.builder()
				.name("Product 1")
				.description("Description 1")
				.price(1000)
				.categoryIds(categoryService.getCategories().stream().map(CategoryDTO.CategoryResponse::getId).collect(Collectors.toSet()))
				.build());
	}
}
