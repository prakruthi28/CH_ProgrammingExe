package MyProjects.averageProcedureCosts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class avgProcedureCost {

  public static void main(String[] args) {
    String allProcedures = "PRO-A:10||PRO-B:15||PRO-A:5||PRO-C:125||PRO-B:25";
    float avg = getAverageCostForProcedure(allProcedures, "PRO-A");
    System.out.println("Average cost is " + avg);
  }

  /**
   * This methods calculates the average cost of a procedure
   * 
   * 
   * @author Prakruthi Nagaraj
   */

    public static float getAverageCostForProcedure(String procedureCosts, String targetProcedureCode) {
        float avgPrice = 0;
        Map<String, Integer> procedureCodeMap = new HashMap<>();
        int count = 0;

        String[] procedurePrices = procedureCosts.split(Pattern.quote("||"));
        for (String procedurePrice : procedurePrices) {
            if(!procedurePrice.contains(":")){
                System.out.println("Malformed Procedure price. Please double check your procedure input.");
                return 0;
            }
            String[] procedurePriceSplit = procedurePrice.split(":");
            String procedureCode = procedurePriceSplit[0];
            int price;
            try {
                price = Integer.parseInt(procedurePriceSplit[1]);
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
                int currentProcedurePrice = procedureCodeMap.get(procedureCode) + price;
                procedureCodeMap.put(procedureCode, currentProcedurePrice);
            }
        }

        if (count == 0) {
            System.out.println("Target procedure code not found! Please double check your procedure input.");
            return 0;
        }else {
            return (float)procedureCodeMap.get(targetProcedureCode) / count;
        }
    }
}
