package processor;

import dao.PaymentMethodDao;
import dto.ResponseDto;
import dto.ResponseDto.ResponseBuilder;
import java.util.Date;
import java.util.Map;

public class AddPaymentMethodProcessor implements Processor {

  public ResponseDto process(Map<String, String> args) {
    PaymentMethodDao dao = PaymentMethodDao.getInstance();
    ResponseBuilder builder = new ResponseDto.ResponseBuilder();
    String name = args.get("method");
    builder.setDate(new Date());
    builder.setParams(args);
    if(name != null){
      dao.addPayment(name);
      builder.setResponseCode("OK");
    }else{
      builder.setResponseCode("ERROR");
    }
    return builder.build();
  }
}
