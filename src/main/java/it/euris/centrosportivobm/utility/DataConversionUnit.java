package it.euris.centrosportivobm.utility;

import it.euris.centrosportivobm.data.enums.SportType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class DataConversionUnit {

  private DataConversionUnit() {
  }

  public static String numberToString(Number value) {
    return value == null ? null : value.toString();
  }

  public static Long stringToLong(String value) {
    return value == null ? null : Long.parseLong(value);
  }

  public static Integer stringToInteger(String value) {
    return value == null ? null : Integer.parseInt(value);
  }

  public static Double stringToDouble(String value) {
    return value == null ? null : Double.parseDouble(value);
  }

  public static LocalDateTime stringToLocalDateTime(String value) {
    return value == null ? null : LocalDateTime.parse(value);
  }

  public static String localDateTimeToString(LocalDateTime value) {
    return value == null ? null : value.toString();
  }

  public static SportType stringToSportType(String value) {
    for (SportType sportTypeValue : SportType.values()) {
      if (sportTypeValue.name().equalsIgnoreCase(value))
        return sportTypeValue;
    }
    return null;
  }

  public static String sportTypeToString(SportType value) {
    return value == null ? null : value.name();
  }

  public static String booleanToString(Boolean bool) {
    return bool ? "true" : "false";
  }

  public static Boolean stringToBoolean(String value) {
    return value == null ? null : Boolean.valueOf(value);
  }
}
