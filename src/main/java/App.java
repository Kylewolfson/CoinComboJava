import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String inputtedCentsAsString = request.queryParams("userCents");
      Integer inputtedCents = Integer.parseInt(inputtedCentsAsString);

      CoinCombinations myCoinCombinations = new CoinCombinations();
      ArrayList<Object> results = myCoinCombinations.runCoinCombinations(inputtedCents);
      Integer quarters = (Integer) results.get(0);
      Integer dimes = (Integer) results.get(1);
      Integer nickels = (Integer) results.get(2);
      Integer pennies = (Integer) results.get(3);
      boolean ranOutOfQuarters = (boolean) results.get(4);
      boolean ranOutOfDimes = (boolean) results.get(5);
      boolean ranOutOfNickels = (boolean) results.get(6);

      if (ranOutOfQuarters) {
        model.put("ranOutOfQuarters", "Sorry, we ran out of quarters and need to use smaller change.");
      } else {
        model.put("ranOutOfQuarters", "");
      }
      model.put("quarters", quarters);
      model.put("dimes", dimes);
      model.put("nickels", nickels);
      model.put("pennies", pennies);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
