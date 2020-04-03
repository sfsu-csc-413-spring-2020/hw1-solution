import com.mongodb.DB;
import com.mongodb.DBCollection;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;





import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.SingletonConnection;
import dto.ItemDto;
import dto.ResponseDto;
import org.bson.Document;
import processor.Processor;
import processor.ProcessorFactory;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static spark.Spark.*;

public class Main {

  public static Map<String, String> processRoute(Request req) {
    Map<String, String> params = new HashMap<>();
    params.put("method", req.queryParams("method"));
    return params;
  }
  public static Map<String, String> processRoute2(Request req) {
    Map<String, String> params = new HashMap<>();
    params.put("name", req.queryParams("name"));
    params.put("price", req.queryParams("price"));
    return params;
  }
  public static Map<String, String> processRoute3(Request req) {
    Map<String, String> params = new HashMap<>();
    params.put("itemCode", req.queryParams("itemCode"));
    params.put("paymentMethod", req.queryParams("paymentMethod"));
    return params;
  }

  public static void main(String[] args) {
    Gson gson = new Gson();
    port(4000);


    get("/addPaymentMethod", (req, res) -> {
      Processor processor = ProcessorFactory.getProcessor(req.pathInfo());

      Map<String, String> arg = processRoute(req);

      ResponseDto response = processor.process(arg);

      return gson.toJson(response);
    });

    get("/getAllPaymentMethods", (req, res) -> {
      Processor processor = ProcessorFactory.getProcessor(req.pathInfo());
      Map<String, String> arg = processRoute(req);
      ResponseDto response = processor.process(arg);

      return gson.toJson(response);
    });

    get("/addItem", (req, res) -> {
      Processor processor = ProcessorFactory.getProcessor(req.pathInfo());
      Map<String, String> arg = processRoute2(req);
      ResponseDto response = processor.process(arg);

      return gson.toJson(response);
    });

    get("/listItems", (req, res) -> {
      Processor processor = ProcessorFactory.getProcessor(req.pathInfo());
      Map<String, String> arg = processRoute2(req);
      ResponseDto response = processor.process(arg);
      return gson.toJson(response);
    });

    get("/createTransaction", (req, res) -> {
      Processor processor = ProcessorFactory.getProcessor(req.pathInfo());
      Map<String, String> arg = processRoute3(req);
      ResponseDto response = processor.process(arg);
      return gson.toJson(response);
    });
    get("/listTransactions", (req, res) -> {
      Processor processor = ProcessorFactory.getProcessor(req.pathInfo());
      Map<String, String> arg = processRoute3(req);
      ResponseDto response = processor.process(arg);
      return gson.toJson(response);
    });




  }

}
