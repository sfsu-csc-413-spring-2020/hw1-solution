package processor;

import dao.ItemDao;
import dto.ResponseDto;
import dto.ResponseDto.ResponseBuilder;
import java.util.Date;
import java.util.Map;

public class AddItemProcessor implements Processor {
  public ResponseDto process(Map<String, String> args) {
    ItemDao dao = ItemDao.getInstance();
    ResponseBuilder builder = new ResponseDto.ResponseBuilder();
    String name = args.get("name");
    String priceString = args.get("price");
    builder.setDate(new Date());
    builder.setParams(args);
    if(name != null && priceString != null){
      dao.addItem(name, Double.valueOf(priceString));
      builder.setResponseCode("OK");
    }else{
      builder.setResponseCode("ERROR");
    }
    return builder.build();
  }
}
