package dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ResponseDto {

  public final Date date;
  public final Map<String, String> params;
  public final String responseCode;
  public final List<BaseDto> response;

  public ResponseDto(Date date, Map<String, String> params, String responseCode,
      List<BaseDto> response) {
    this.date = date;
    this.params = params;
    this.responseCode = responseCode;
    this.response = response;
  }

  public static class ResponseBuilder{
    public Date date;
    public Map<String, String> params;
    public String responseCode;
    public List<BaseDto> response;

    public void setDate(Date date) {
      this.date = date;
    }

    public void setParams(Map<String, String> params) {
      this.params = params;
    }

    public void setResponseCode(String responseCode) {
      this.responseCode = responseCode;
    }

    public void setResponse(List<BaseDto> response) {
      this.response = response;
    }

    public ResponseDto build(){
      return new ResponseDto(this.date, this.params,
          this.responseCode, this.response);
    }
  }
}
