import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class CoinCombinationsTest {
  @Test
  public void runCoinCombinations_coinsAboveOrEqualTo25_quarter() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    Integer expected = 1;
    Integer returnValue = testCoinCombinations.runCoinCombinations(25)[0];
    assertEquals(expected, returnValue);
  }
}
