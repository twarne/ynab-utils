/*
 * YNAB API Endpoints
 * Our API uses a REST based design, leverages the JSON data format, and relies upon HTTPS for transport. We respond with meaningful HTTP response codes and if an error occurs, we include error details in the response body.  API Documentation is at https://api.youneedabudget.com
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.kickthedrawer.ynab.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.kickthedrawer.ynab.model.PayeeLocation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kickthedrawer.ynab.JSON;

/**
 * PayeeLocationsResponseData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-18T14:52:04.431395-07:00[America/Phoenix]")
public class PayeeLocationsResponseData {
  public static final String SERIALIZED_NAME_PAYEE_LOCATIONS = "payee_locations";
  @SerializedName(SERIALIZED_NAME_PAYEE_LOCATIONS)
  private List<PayeeLocation> payeeLocations = new ArrayList<>();

  public PayeeLocationsResponseData() {
  }

  public PayeeLocationsResponseData payeeLocations(List<PayeeLocation> payeeLocations) {
    
    this.payeeLocations = payeeLocations;
    return this;
  }

  public PayeeLocationsResponseData addPayeeLocationsItem(PayeeLocation payeeLocationsItem) {
    this.payeeLocations.add(payeeLocationsItem);
    return this;
  }

   /**
   * Get payeeLocations
   * @return payeeLocations
  **/
  @javax.annotation.Nonnull

  public List<PayeeLocation> getPayeeLocations() {
    return payeeLocations;
  }


  public void setPayeeLocations(List<PayeeLocation> payeeLocations) {
    this.payeeLocations = payeeLocations;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayeeLocationsResponseData payeeLocationsResponseData = (PayeeLocationsResponseData) o;
    return Objects.equals(this.payeeLocations, payeeLocationsResponseData.payeeLocations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payeeLocations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayeeLocationsResponseData {\n");
    sb.append("    payeeLocations: ").append(toIndentedString(payeeLocations)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("payee_locations");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("payee_locations");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PayeeLocationsResponseData
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PayeeLocationsResponseData.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PayeeLocationsResponseData is not found in the empty JSON string", PayeeLocationsResponseData.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!PayeeLocationsResponseData.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PayeeLocationsResponseData` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PayeeLocationsResponseData.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // ensure the json data is an array
      if (!jsonObj.get("payee_locations").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `payee_locations` to be an array in the JSON string but got `%s`", jsonObj.get("payee_locations").toString()));
      }

      JsonArray jsonArraypayeeLocations = jsonObj.getAsJsonArray("payee_locations");
      // validate the required field `payee_locations` (array)
      for (int i = 0; i < jsonArraypayeeLocations.size(); i++) {
        PayeeLocation.validateJsonObject(jsonArraypayeeLocations.get(i).getAsJsonObject());
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PayeeLocationsResponseData.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PayeeLocationsResponseData' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PayeeLocationsResponseData> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PayeeLocationsResponseData.class));

       return (TypeAdapter<T>) new TypeAdapter<PayeeLocationsResponseData>() {
           @Override
           public void write(JsonWriter out, PayeeLocationsResponseData value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PayeeLocationsResponseData read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PayeeLocationsResponseData given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PayeeLocationsResponseData
  * @throws IOException if the JSON string is invalid with respect to PayeeLocationsResponseData
  */
  public static PayeeLocationsResponseData fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PayeeLocationsResponseData.class);
  }

 /**
  * Convert an instance of PayeeLocationsResponseData to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
