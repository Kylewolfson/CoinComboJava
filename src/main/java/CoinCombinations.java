import java.util.ArrayList;

public class CoinCombinations {

  public ArrayList<Object> runCoinCombinations(Integer cents) {
    ArrayList<Object> outputArray = new ArrayList<Object>();
      outputArray.add(0);
      outputArray.add(0);
      outputArray.add(0);
      outputArray.add(0);
    Integer quarterSupply = 2;
    Integer dimeSupply = 2;
    Integer nickelSupply = 3;
    Integer counter = 0;
    boolean ranOutOfQuarters = false;
    boolean ranOutOfDimes = false;
    boolean ranOutOfNickels = false;
    if ((quarterSupply + 1) * 25 <= cents) {
      ranOutOfQuarters = true;
    }
    outputArray.add(ranOutOfQuarters);
    while (cents >= 25 && quarterSupply > 0) {
      cents -= 25;
      counter ++;
      quarterSupply --;
    }
    outputArray.set(0, counter);
    if ((dimeSupply + 1) * 10 <= cents) {
      ranOutOfDimes = true;
    }
    outputArray.add(ranOutOfDimes);
    counter = 0;
    while (cents >= 10 && dimeSupply > 0) {
      cents -= 10;
      counter ++;
      dimeSupply --;
    }
    outputArray.set(1, counter);
    counter = 0;
    if ((nickelSupply + 1) * 5 <= cents) {
      ranOutOfNickels = true;
    }
    outputArray.add(ranOutOfNickels);
    while (cents >= 5 && nickelSupply > 0) {
      cents -= 5;
      counter ++;
      nickelSupply --;
    }
    outputArray.set(2, counter);
    outputArray.set(3, cents);
    return outputArray;
  }
}
