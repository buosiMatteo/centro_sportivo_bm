package it.euris.centrosportivobm.utility;

import it.euris.centrosportivobm.data.enums.SportType;
import it.euris.centrosportivobm.data.model.key.CustomerCourseKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

  public static String customerCourseKeyToString(CustomerCourseKey idCustomerCourse){return idCustomerCourse == null ? null : idCustomerCourse.getCourseId().toString()+"-"+idCustomerCourse.getCustomerId().toString();}

  public static CustomerCourseKey stringToCustomerCourseKey(String value){
    Pattern pattern = Pattern.compile("([0-9]+)-([0-9]+)");
    Matcher matcher = pattern.matcher(value);
    String idCourse = matcher.group(1);
    String idCustomer = matcher.group(2);
    return new CustomerCourseKey(Long.parseLong(idCourse),Long.parseLong(idCustomer));
  }
}
