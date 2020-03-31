package dao;

import dto.BaseDto;
import dto.ItemDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDao {
  private static ItemDao instance = null;
  private Map<String, ItemDto> itemMap;
  private List<BaseDto> dataStore = new ArrayList<>();

  private ItemDao(){
  }

  public static ItemDao getInstance(){
    if(instance == null){
      instance = new ItemDao();
    }
    return instance;
  }

  public void addItem(String name, Double price){
    ItemDto item = new ItemDto(name, price, String.valueOf(name.hashCode()));
    dataStore.add(item);
    itemMap.put(item.machineCode, item);
  }

  public List<BaseDto> getAllItems(){
    return dataStore;
  }

  public boolean hasItem(String code){
    return itemMap.containsKey(code);
  }
}
