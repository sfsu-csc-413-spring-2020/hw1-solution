package processor;

import dao.TransactionDao;
import dto.ResponseDto;
import dto.ResponseDto.ResponseBuilder;
import java.util.Date;
import java.util.Map;

public class ListTransactionsProcessor implements Processor {
  public ResponseDto process(Map<String, String> args) {
    TransactionDao dao = TransactionDao.getInstance();
    ResponseBuilder builder = new ResponseDto.ResponseBuilder();
    builder.setDate(new Date());
    builder.setResponseCode("OK");
    builder.setParams(args);
    builder.setResponse(dao.getTransactions());
    return builder.build();
  }
}
