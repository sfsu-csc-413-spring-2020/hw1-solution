package dao;

import dto.BaseDto;
import dto.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
  private static TransactionDao instance = null;
  private List<BaseDto> dataStore = new ArrayList<>();

  private TransactionDao(){
  }

  public static TransactionDao getInstance(){
    if(instance == null){
      instance = new TransactionDao();
    }
    return instance;
  }

  public void addTransaction(String itemCode, String paymentMethod){
    TransactionDto transactionDto = new TransactionDto(itemCode, paymentMethod);
    dataStore.add(transactionDto);
  }

  public List<BaseDto> getTransactions(){
    return dataStore;
  }
}
