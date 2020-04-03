package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dto.BaseDto;
import dto.PaymentMethodDto;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentMethodDao {
  private List<BaseDto> dataStore = new ArrayList<>();
  //private MongoCollection<Document> paymentCollection;
  private Map<String, PaymentMethodDto> methodMap = new HashMap<>();
  private static PaymentMethodDao instance = null;
  private PaymentMethodDao(){
  }

  public static PaymentMethodDao getInstance(){
    if(instance == null){
      instance = new PaymentMethodDao();
    }
    return instance;
  }
  public void addPayment(String name){
    PaymentMethodDto paymentMethodDto = new PaymentMethodDto(name, String.valueOf(name.hashCode()));
    if(!hasMethod(paymentMethodDto.machineCode)){
      dataStore.add(paymentMethodDto);
      methodMap.put(paymentMethodDto.machineCode, paymentMethodDto);
    }
  }

  public List<BaseDto> getPaymentMethods(){
    return dataStore;
  }

  public boolean hasMethod(String code){
    return methodMap.containsKey(code);
  }
}
