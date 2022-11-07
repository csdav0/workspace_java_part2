/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.ArrayList;
import java.util.Collection;

public class Order {
  private String id;
  
  public Order(String id) {
    this.id = id;
  }
  
  /**
   * TODO:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> reference_to_cart) {

    System.out.println("Order ID #: " + getId());
    Collection<? extends Product> cartItems = reference_to_cart.allItems();
    for (Product item : cartItems) {
      System.out.println(item.getCode());
    }
    System.out.println(reference_to_cart.total());
  }

  public String getId() {
    return id;
  }
}