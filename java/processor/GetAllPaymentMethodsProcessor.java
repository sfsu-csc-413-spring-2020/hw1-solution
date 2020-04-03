package processor;

import dao.PaymentMethodDao;
import dto.ResponseDto;
import dto.ResponseDto.ResponseBuilder;
import java.util.Date;
import java.util.Map;

public class GetAllPaymentMethodsProcessor implements Processor {
  public ResponseDto process(Map<String, String> args) {
    PaymentMethodDao dao = PaymentMethodDao.getInstance();
    ResponseBuilder builder = new ResponseDto.ResponseBuilder();
    builder.setDate(new Date());
    builder.setResponseCode("OK");
    builder.setParams(args);
    builder.setResponse(dao.getPaymentMethods());
    return builder.build();
  }
}
