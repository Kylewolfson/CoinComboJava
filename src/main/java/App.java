import java.util.Arrays;
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
      int[] results = myCoinCombinations.runCoinCombinations(inputtedCents);
      Integer quarters = results[0];
      Integer dimes = results[1];
      Integer nickels = results[2];
      Integer pennies = results[3];

      model.put("quarters", quarters);
      model.put("dimes", dimes);
      model.put("nickels", nickels);
      model.put("pennies", pennies);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
