/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.TaxCalculator;

import java.util.Collection;

public class Order {

  private String id;
  private double totalCost;
  private TaxCalculator taxStrategy;

  public Order(String id, TaxCalculator taxStrategy) {
    this.id = id;
    this.taxStrategy = taxStrategy;
  }

  /**
   * DONE:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");
    
    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }
    System.out.println("Order Total: " + cart.total());
    totalCost = cart.total();
  }

  public double getTax() {
    return taxStrategy.taxAmount(totalCost);
  }
  
  public String getId() {
    return id;
  }

  public double getTotalCost() {
    return totalCost;
  }
}