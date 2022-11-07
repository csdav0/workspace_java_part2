/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {
  
  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
   */
  public static Employee createEmployee(Map<String,String> inputMap)
  throws IllegalArgumentException {
    // return value
    Employee emp = null;
    if (inputMap.get("type").equals("SE")) {
      emp = new SalariedEmployee(inputMap.get("name"),
              Date.valueOf(inputMap.get("hireDate")),
              Double.valueOf(inputMap.get("salary")));
    } else if (inputMap.get("type").equals("HE")) {
      emp = new HourlyEmployee(inputMap.get("name"),
              Date.valueOf(inputMap.get("hireDate")),
              Double.valueOf(inputMap.get("rate")),
              Double.valueOf(inputMap.get("hours")));
    } else {
      throw new IllegalArgumentException("Employee type must be SE or HE.");
    }
    return emp;
  }
}