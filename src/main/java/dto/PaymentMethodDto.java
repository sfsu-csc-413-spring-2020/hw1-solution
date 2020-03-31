package dto;

public class PaymentMethodDto implements BaseDto {
  public final String name;
  public final String machineCode;

  public PaymentMethodDto(String name, String machineCode) {
    this.name = name;
    this.machineCode = machineCode;
  }
}
