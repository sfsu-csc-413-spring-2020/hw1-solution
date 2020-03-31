package dao;

import dto.BaseDto;
import dto.PaymentMethodDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaymentMethodDao {
  private List<BaseDto> dataStore = new ArrayList<>();
  private Map<String, PaymentMethodDto> methodMap;
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
    dataStore.add(paymentMethodDto);
    methodMap.put(paymentMethodDto.machineCode, paymentMethodDto);
  }

  public List<BaseDto> getPaymentMethods(){
    return dataStore;
  }

  public boolean hasMethod(String code){
    return methodMap.containsKey(code);
  }
}
