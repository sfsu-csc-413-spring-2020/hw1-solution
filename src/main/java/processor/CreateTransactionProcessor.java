package processor;

import dao.ItemDao;
import dao.PaymentMethodDao;
import dao.TransactionDao;
import dto.ResponseDto;
import dto.ResponseDto.ResponseBuilder;
import java.util.Date;
import java.util.Map;

public class CreateTransactionProcessor implements Processor {
  public ResponseDto process(Map<String, String> args) {
    ItemDao itemDao = ItemDao.getInstance();
    PaymentMethodDao paymentMethodDao = PaymentMethodDao.getInstance();
    TransactionDao dao = TransactionDao.getInstance();
    ResponseBuilder builder = new ResponseDto.ResponseBuilder();
    String itemCode = args.get("itemCode");
    String paymentCode = args.get("paymentMethod");
    builder.setDate(new Date());
    builder.setParams(args);
    if(itemCode != null && paymentCode != null){
      // Note does not check if these exists
      if(itemDao.hasItem(itemCode) && paymentMethodDao.hasMethod(paymentCode)){
        dao.addTransaction(itemCode, paymentCode);
        builder.setResponseCode("OK");
      }else{
        builder.setResponseCode("ERROR");
      }
    }else{
      builder.setResponseCode("ERROR");
    }
    return builder.build();
  }
}
