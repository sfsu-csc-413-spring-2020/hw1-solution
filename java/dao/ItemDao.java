package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dto.BaseDto;
import dto.ItemDto;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemDao {
  private static ItemDao instance = null;
  private Map<String, ItemDto> itemMap = new HashMap<>();
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
    if(!hasItem(item.machineCode)){
      dataStore.add(item);
      itemMap.put(item.machineCode, item);
    }


    //
//    ItemDto item = new ItemDto(name, price, String.valueOf(name.hashCode()));
//
//
//
//    if(!hasItem(item.machineCode)){
//
//      MongoDatabase db2 = SingletonConnection
//              .mongoClient.getDatabase("MyDataB");
//      MongoCollection<Document> itemCollection = db2.getCollection("Items");
//      Document newItem = new Document("item", item);
//      itemCollection.insertOne(newItem);
//
//    }
  }

  public List<BaseDto> getAllItems(){
    return dataStore;
  }

  public boolean hasItem(String code){
    return itemMap.containsKey(code);
  }
}
