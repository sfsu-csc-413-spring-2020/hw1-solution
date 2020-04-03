package dto;

public class TransactionDto implements BaseDto {
  public final String itemCode;
  public final String paymentCode;

  public TransactionDto(String itemCode, String paymentCode) {
    this.itemCode = itemCode;
    this.paymentCode = paymentCode;
  }
}
