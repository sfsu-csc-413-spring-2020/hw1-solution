package processor;

public class ProcessorFactory {

  public static Processor getProcessor(String endpoint){
    switch (endpoint){
      case "/addPaymentMethod":
        return new AddPaymentMethodProcessor();
      case "/getAllPaymentMethods":
        return new GetAllPaymentMethodsProcessor();
      case "/addItem":
        return new AddItemProcessor();
      case "/listItems":
        return new ListItemsProcessor();
      case "/createTransaction":
        return new CreateTransactionProcessor();
      case "/listTransactions":
        return new ListTransactionsProcessor();
      default:
        return new BackupProcessor();
    }
  }
}
