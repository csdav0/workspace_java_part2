/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import static org.junit.Assert.*;
import com.javatunes.billing.TaxCalculator;
import org.junit.Before;
import org.junit.Test;

public class OrderTaxTest {
  private ShoppingCart<Product> cart1;
  private ShoppingCart<Product> cart2;
  private OrderFactory orderFactory;
  private Order myOrder1;
  private Order myOrder2;
  private TaxCalculator USATax;
  private TaxCalculator EuropeTax;
  private TaxCalculator OnlineTax;

  @Before
  public void init() {
    cart1 = new ShoppingCart<Product>();  // $20.00
    cart1.addItem(new MusicItem("CD-501"));
    cart1.addItem(new MusicItem("CD-519"));
    
    cart2 = new ShoppingCart<Product>();  // $120.00 
    cart2.addItem(new MusicItem("CD-511"));
    cart2.addItem(new MusicItem("CD-512"));
    cart2.addItem(new MediaPlayer("MP3-LP150"));
    cart2.addItem(new MediaPlayer("MP4-JR1205"));

    orderFactory = new OrderFactory();

  }

  /**
   * TODO: (for each of the test cases below)
   * 1. Create an order for *each* cart in the setup, e.g., Order order1 = new Order(...)
   * 2. Remember to call order1.processCart(cart1) -> that method computes the order's total cost.
   * 3. DEPENDING ON YOUR IMPLEMENTATION, initialize somehow the Order's TaxCalculator strategy.
   *     - For example, if you wrote a factory for TaxCalculator (option 1), make sure the Order has a Location set,
   *       since the factory (most likely) is using this to determine which strategy to provide.
   *     - If you are injecting the TaxCalculator into the Order (option 2, perhaps from an OrderFactory), use that 
   *       factory to create the Orders.
   *     - If you're injecting the TaxCalculator from the client, do so here.
   * 4. Verify that the order's tax is as expected.
   * 
   * TEST NOTE: you can split the two orders per location into two test cases, if desired.
   */
//  @Test
//  public void testTaxOnlineOrder() {
//
//    //order1 arrange&act
//    order1.processCart(cart1);
//    order1.setMyTaxReference("OnlineTax");
//    double actualTaxAmountOnline1 = order1.getTax();
//
//    //order2 arrange&act
//    order2.processCart(cart2);
//    order2.setMyTaxReference("OnlineTax");
//    double actualTaxAmountOnline2 = order2.getTax();
//
//    //asserts
//    assertEquals(0, actualTaxAmountOnline1, 0.001);
//    assertEquals(0, actualTaxAmountOnline2, 0.001);
//  }
//
//  @Test
//  public void testTaxEuropeOrder() {
//    //order1 arrange&act
//    order1.processCart(cart1);
//    order1.setMyTaxReference("EuropeTax");
//    double actualTaxAmountEU1 = order1.getTax();
//
//    //order2 arrange&act
//    order2.processCart(cart2);
//    order2.setMyTaxReference("EuropeTax");
//    double actualTaxAmountEU2 = order2.getTax();
//    double predictedTaxAmountEU2 = (120 * 0.17) + (120 - 100) * 0.25;
//
//    //asserts
//    assertEquals((0.17 * 20), actualTaxAmountEU1, 0.001);
//    assertEquals(predictedTaxAmountEU2, actualTaxAmountEU2, 0.001);
//  }
  
  @Test
  public void testTaxUSAOrder() {

    //order1 arrange & act
    myOrder1 = orderFactory.createOrder("1", "USA");
    myOrder1.processCart(cart1);
    double actualTaxForUSATax1 = myOrder1.getTax();

//    //order2 arrange & act
    myOrder2 = orderFactory.createOrder("2", "USA");
    myOrder2.processCart(cart2);
    double actualTaxForUSATax2 = myOrder2.getTax();

    //asserts
    assertEquals(0, actualTaxForUSATax1, 0.001);
    assertEquals(10, actualTaxForUSATax2, 0.001);
  }
}