package processor;

import dao.ItemDao;
import dto.ResponseDto;
import dto.ResponseDto.ResponseBuilder;
import java.util.Date;
import java.util.Map;

public class ListItemsProcessor implements Processor {

  public ResponseDto process(Map<String, String> args) {
    ItemDao dao = ItemDao.getInstance();
    ResponseBuilder builder = new ResponseDto.ResponseBuilder();
    builder.setDate(new Date());
    builder.setResponseCode("OK");
    builder.setParams(args);
    builder.setResponse(dao.getAllItems());
    return builder.build();
  }
}
