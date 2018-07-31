package MyProjects.averageProcedureCosts;

import org.junit.Assert;
import org.junit.Test;

public class AvgProcedureCostCalculatorTests {

  @Test
  public void happyPath() {
      String allProcedures = "PRO-A:10||PRO-B:15||PRO-A:5||PRO-C:125||PRO-B:25";
      String procedure = "PRO-A";
      float avg = AvgProcedureCostCalculator.getAverageCostForProcedure(allProcedures, procedure);
      Assert.assertEquals(7.5, avg, 0);
  }

  @Test
  public void EmptyInputs() {
      String allProcedures = "";
      String procedure = null;
      float avg = AvgProcedureCostCalculator.getAverageCostForProcedure(allProcedures, procedure);
      Assert.assertEquals(0, avg, 0);
  }

  @Test
  public void malformed() {
      String allProcedures = "PRO-A:10||PRO-B:15PRO-A5||PRO-C:125||PRO-B:25";
      String procedure = "PRO-A";
      float avg = AvgProcedureCostCalculator.getAverageCostForProcedure(allProcedures, procedure);
      Assert.assertEquals(0, avg, 0);
  }

  @Test
  public void unknownTargetProcedure() {
      String allProcedures = "PRO-A:10||PRO-B:15||PRO-A:5||PRO-C:125||PRO-B:25";
      String procedure = "PRO-Z";
      float avg = AvgProcedureCostCalculator.getAverageCostForProcedure(allProcedures, procedure);
      Assert.assertEquals(0, avg, 0);
  }

  @Test
  public void floatProcedurePrices() {
      String allProcedures = "PRO-A:10||PRO-B:15.7||PRO-A:5.77||PRO-C:125.78||PRO-B:25";
      String procedure = "PRO-A";
      float avg = AvgProcedureCostCalculator.getAverageCostForProcedure(allProcedures, procedure);
      Assert.assertEquals(7.885, avg, 0.001);
  }
}
