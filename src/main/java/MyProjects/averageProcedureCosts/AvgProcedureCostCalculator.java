package MyProjects.averageProcedureCosts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class AvgProcedureCostCalculator {

  public static void main(String[] args) {
    String allProcedures = "PRO-A:10||PRO-B:15||PRO-A:5||PRO-C:125||PRO-B:25";
    String procedure = "PRO-A";
    float avg = getAverageCostForProcedure(allProcedures, procedure);
    System.out.println("Average cost of " + procedure + " is " + avg);
  }

  /**
   * This methods calculates the average cost of a procedure
   *
   * @author Prakruthi Nagaraj
   */

  public static float getAverageCostForProcedure(String procedureCosts,
      String targetProcedureCode) {
    if (StringUtils.isEmpty(procedureCosts) || StringUtils.isEmpty(targetProcedureCode)) {
      System.out.println("Malformed Procedure price. Please double check your procedure input.");
      return 0;
    }

    Map<String, Float> procedureCodeMap = new HashMap<String, Float>();
    int count = 0;

    String[] procedurePrices = procedureCosts.split(Pattern.quote("||"));
    for (String procedurePrice : procedurePrices) {
      if (!procedurePrice.contains(":")) {
        System.out.println("Malformed Procedure price. Please double check your procedure input.");
        return 0;
      }
      String[] procedurePriceSplit = procedurePrice.split(":");
      String procedureCode = procedurePriceSplit[0];
      float price;
      try {
        price = Float.parseFloat(procedurePriceSplit[1]);
      } catch (NumberFormatException ex) {
        System.out.println("Malformed Procedure price. Please double check your procedure input.");
        return 0;
      }

      if (procedureCode.equals(targetProcedureCode)) {
        count++;
      }
      if (!procedureCodeMap.containsKey(procedureCode)) {
        procedureCodeMap.put(procedureCode, price);
      } else {
        float totalProcedurePrice = procedureCodeMap.get(procedureCode) + price;
        procedureCodeMap.put(procedureCode, totalProcedurePrice);
      }
    }

    if (count == 0) {
      System.out
          .println("Target procedure code not found! Please double check your procedure input.");
      return 0;
    } else {
      return (float) procedureCodeMap.get(targetProcedureCode) / count;
    }
  }
}


