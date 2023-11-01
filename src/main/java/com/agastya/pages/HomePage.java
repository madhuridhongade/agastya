package com.agastya.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(css = "input#woocommerce-product-search-field-0")
	WebElement searchComponent;
	
	@FindBy(css = "div.storefront-sorting+ul.products>li:nth-child(1)>a.add_to_cart_button")
	WebElement addToCartBtn;

	public void searchProduct(String productName) {
		searchComponent.sendKeys(productName);
		searchComponent.sendKeys(Keys.RETURN);
		System.out.println("Entered the product name "+productName+" to search");

	}
	
	public void clickOnAddToCartBtn() {
		addToCartBtn.click();
	}
}
