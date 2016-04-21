import java.util.Arrays;

public class CoinCombinations {

  public int[] runCoinCombinations(Integer cents) {
    int[] outputArray = {0, 0, 0, 0};
    while (cents >= 25) {
      cents -= 25;
      outputArray[0] ++;
    }
    while (cents >= 10) {
      cents -= 10;
      outputArray[1] ++;
    }
    while (cents >= 5) {
      cents -= 5;
      outputArray[2] ++;
    }
    outputArray[3] = cents;
    return outputArray;
  }
}
