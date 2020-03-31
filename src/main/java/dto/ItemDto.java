package dto;

public class ItemDto implements BaseDto{
  public final String name;
  public final Double price;
  public final String machineCode;

  public ItemDto(String name, Double price, String machineCode) {
    this.name = name;
    this.price = price;
    this.machineCode = machineCode;
  }
}
