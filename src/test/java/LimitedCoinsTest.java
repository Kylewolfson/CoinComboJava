import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LimitedCoinsTest {
  @Test
  public void runCoinCombinations_limitedCoinsEqualTo75_2quarters() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    Integer expected = 2;
    Integer returnValue = (Integer) testCoinCombinations.runCoinCombinations(75).get(0);
    assertEquals(expected, returnValue);
  }
  @Test
  public void runCoinCombinations_limitedCoinsEqualTo75_2dimes() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    Integer expected = 2;
    Integer returnValue = (Integer) testCoinCombinations.runCoinCombinations(75).get(1);
    assertEquals(expected, returnValue);
  }
  @Test
  public void runCoinCombinations_limitedCoinsEqualTo75_1nickel() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    Integer expected = 1;
    Integer returnValue = (Integer) testCoinCombinations.runCoinCombinations(75).get(2);
    assertEquals(expected, returnValue);
  }
  @Test
  public void runCoinCombinations_limitedCoinsEqualTo75_ranOutOfQuarters_true() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    boolean expected = true;
    boolean returnValue = (boolean) testCoinCombinations.runCoinCombinations(75).get(4);
    assertEquals(expected, returnValue);
  }
}
