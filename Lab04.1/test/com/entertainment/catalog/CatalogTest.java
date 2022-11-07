/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

  private Collection<Television> SonyCollection;
  private Collection<Television> ZenithCollection;
  @Before

  public void setUp() throws Exception {
    SonyCollection = new ArrayList<>();
    SonyCollection.add(new Television("Sony", 4));
    SonyCollection.add(new Television("Sony", 50));
    SonyCollection.add(new Television("Sony", 94));
    SonyCollection.add(new Television("Sony", 50));
    SonyCollection.add(new Television("Sony", 87));
    SonyCollection.add(new Television("Sony", 28));
    SonyCollection.add(new Television("Sony", 22));

    ZenithCollection = new ArrayList<>();
    ZenithCollection.add(new Television("Zenith",  0));
    ZenithCollection.add(new Television("Zenith",  33));
    ZenithCollection.add(new Television("Zenith",  86));
    ZenithCollection.add(new Television("Zenith",  46));
    ZenithCollection.add(new Television("Zenith",  37));
    ZenithCollection.add(new Television("Zenith",  27));
    ZenithCollection.add(new Television("Zenith",  12));
    ZenithCollection.add(new Television("Zenith",  50));
    ZenithCollection.add(new Television("Zenith",  77));
  }

  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches() {
    //arrange
    //what is the test target object, test target method, and arguments to that method
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    //act
    //create your expected value
    Collection<Television> expectedCollection = new ArrayList<>(SonyCollection);
    //assert
    Assert.assertEquals(expectedCollection, tvs);
  }


  @Test
  public void findByBrands_when_input_is_null() {

    //arrange
    Map<String, Collection<Television>> tvsMap = Catalog.findByBrands();
    //act
//    Map<Object, Object> expectedMap = new HashMap<>();
    //assert
    assertTrue(tvsMap.isEmpty());
  }


  @Test
  public void findByBrands_when_input_is_Strings() {

    //arrange
    Map<String, Collection<Television>> tvsMap =
            Catalog.findByBrands("Sony", "Zenith", "NO-MATCHES");
    //act
    Map<String, Collection<Television>> expectedMap = new HashMap<>();
    expectedMap.put("Sony", SonyCollection);
    expectedMap.put("Zenith", ZenithCollection);
    expectedMap.put("NO-MATCHES", new ArrayList<>());

    //assert
    Assert.assertEquals(expectedMap, tvsMap);
  }
}