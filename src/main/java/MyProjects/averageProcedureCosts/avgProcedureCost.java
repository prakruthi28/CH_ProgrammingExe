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

  static float getAverageCostForProcedure(String procedureCosts, String procedureCode) {
    String[] allProceduresArr = procedureCosts.split(":|\\|\\|");
    System.out.println(Arrays.toString(allProceduresArr));
    Map<String, Float> map = new HashMap<String, Float>();
    int count = 1;
    float avgPrice = 0;
    float price = 0; // When you operate on two integers, Java will produce an integer result. Hence
                     // price is float

    for (int i = 0; i < allProceduresArr.length; i++) {
      if (allProceduresArr[i].equals(procedureCode) && map.get(allProceduresArr[i]) == null) {
        map.put(allProceduresArr[i], Float.parseFloat(allProceduresArr[i + 1]));
        price = Integer.parseInt(allProceduresArr[i + 1]);
        i++;
      } else if (map.get(allProceduresArr[i]) != null) {
        price = map.get(allProceduresArr[i]) + Integer.parseInt(allProceduresArr[i + 1]);
        map.put(allProceduresArr[i], price);
        count++;
        i++;
      } else {
        i++;
      }
    }
    avgPrice = price / count;
    return avgPrice;
  }
}
