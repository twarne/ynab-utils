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
import com.kickthedrawer.ynab.model.SaveSubTransaction;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
 * SaveTransactionWithOptionalFields
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-18T14:52:04.431395-07:00[America/Phoenix]")
public class SaveTransactionWithOptionalFields {
  public static final String SERIALIZED_NAME_ACCOUNT_ID = "account_id";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private UUID accountId;

  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private LocalDate date;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Long amount;

  public static final String SERIALIZED_NAME_PAYEE_ID = "payee_id";
  @SerializedName(SERIALIZED_NAME_PAYEE_ID)
  private UUID payeeId;

  public static final String SERIALIZED_NAME_PAYEE_NAME = "payee_name";
  @SerializedName(SERIALIZED_NAME_PAYEE_NAME)
  private String payeeName;

  public static final String SERIALIZED_NAME_CATEGORY_ID = "category_id";
  @SerializedName(SERIALIZED_NAME_CATEGORY_ID)
  private UUID categoryId;

  public static final String SERIALIZED_NAME_MEMO = "memo";
  @SerializedName(SERIALIZED_NAME_MEMO)
  private String memo;

  /**
   * The cleared status of the transaction
   */
  @JsonAdapter(ClearedEnum.Adapter.class)
  public enum ClearedEnum {
    CLEARED("cleared"),
    
    UNCLEARED("uncleared"),
    
    RECONCILED("reconciled");

    private String value;

    ClearedEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ClearedEnum fromValue(String value) {
      for (ClearedEnum b : ClearedEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ClearedEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ClearedEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ClearedEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ClearedEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CLEARED = "cleared";
  @SerializedName(SERIALIZED_NAME_CLEARED)
  private ClearedEnum cleared;

  public static final String SERIALIZED_NAME_APPROVED = "approved";
  @SerializedName(SERIALIZED_NAME_APPROVED)
  private Boolean approved;

  /**
   * The transaction flag
   */
  @JsonAdapter(FlagColorEnum.Adapter.class)
  public enum FlagColorEnum {
    RED("red"),
    
    ORANGE("orange"),
    
    YELLOW("yellow"),
    
    GREEN("green"),
    
    BLUE("blue"),
    
    PURPLE("purple");

    private String value;

    FlagColorEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FlagColorEnum fromValue(String value) {
      for (FlagColorEnum b : FlagColorEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<FlagColorEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FlagColorEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FlagColorEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return FlagColorEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_FLAG_COLOR = "flag_color";
  @SerializedName(SERIALIZED_NAME_FLAG_COLOR)
  private FlagColorEnum flagColor;

  public static final String SERIALIZED_NAME_IMPORT_ID = "import_id";
  @SerializedName(SERIALIZED_NAME_IMPORT_ID)
  private String importId;

  public static final String SERIALIZED_NAME_SUBTRANSACTIONS = "subtransactions";
  @SerializedName(SERIALIZED_NAME_SUBTRANSACTIONS)
  private List<SaveSubTransaction> subtransactions = null;

  public SaveTransactionWithOptionalFields() {
  }

  public SaveTransactionWithOptionalFields accountId(UUID accountId) {
    
    this.accountId = accountId;
    return this;
  }

   /**
   * Get accountId
   * @return accountId
  **/
  @javax.annotation.Nullable

  public UUID getAccountId() {
    return accountId;
  }


  public void setAccountId(UUID accountId) {
    this.accountId = accountId;
  }


  public SaveTransactionWithOptionalFields date(LocalDate date) {
    
    this.date = date;
    return this;
  }

   /**
   * The transaction date in ISO format (e.g. 2016-12-01).  Future dates (scheduled transactions) are not permitted.  Split transaction dates cannot be changed and if a different date is supplied it will be ignored.
   * @return date
  **/
  @javax.annotation.Nullable

  public LocalDate getDate() {
    return date;
  }


  public void setDate(LocalDate date) {
    this.date = date;
  }


  public SaveTransactionWithOptionalFields amount(Long amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * The transaction amount in milliunits format.  Split transaction amounts cannot be changed and if a different amount is supplied it will be ignored.
   * @return amount
  **/
  @javax.annotation.Nullable

  public Long getAmount() {
    return amount;
  }


  public void setAmount(Long amount) {
    this.amount = amount;
  }


  public SaveTransactionWithOptionalFields payeeId(UUID payeeId) {
    
    this.payeeId = payeeId;
    return this;
  }

   /**
   * The payee for the transaction.  To create a transfer between two accounts, use the account transfer payee pointing to the target account.  Account transfer payees are specified as &#x60;tranfer_payee_id&#x60; on the account resource.
   * @return payeeId
  **/
  @javax.annotation.Nullable

  public UUID getPayeeId() {
    return payeeId;
  }


  public void setPayeeId(UUID payeeId) {
    this.payeeId = payeeId;
  }


  public SaveTransactionWithOptionalFields payeeName(String payeeName) {
    
    this.payeeName = payeeName;
    return this;
  }

   /**
   * The payee name.  If a &#x60;payee_name&#x60; value is provided and &#x60;payee_id&#x60; has a null value, the &#x60;payee_name&#x60; value will be used to resolve the payee by either (1) a matching payee rename rule (only if &#x60;import_id&#x60; is also specified) or (2) a payee with the same name or (3) creation of a new payee.
   * @return payeeName
  **/
  @javax.annotation.Nullable

  public String getPayeeName() {
    return payeeName;
  }


  public void setPayeeName(String payeeName) {
    this.payeeName = payeeName;
  }


  public SaveTransactionWithOptionalFields categoryId(UUID categoryId) {
    
    this.categoryId = categoryId;
    return this;
  }

   /**
   * The category for the transaction.  To configure a split transaction, you can specify null for &#x60;category_id&#x60; and provide a &#x60;subtransactions&#x60; array as part of the transaction object.  If an existing transaction is a split, the &#x60;category_id&#x60; cannot be changed.  Credit Card Payment categories are not permitted and will be ignored if supplied.
   * @return categoryId
  **/
  @javax.annotation.Nullable

  public UUID getCategoryId() {
    return categoryId;
  }


  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }


  public SaveTransactionWithOptionalFields memo(String memo) {
    
    this.memo = memo;
    return this;
  }

   /**
   * Get memo
   * @return memo
  **/
  @javax.annotation.Nullable

  public String getMemo() {
    return memo;
  }


  public void setMemo(String memo) {
    this.memo = memo;
  }


  public SaveTransactionWithOptionalFields cleared(ClearedEnum cleared) {
    
    this.cleared = cleared;
    return this;
  }

   /**
   * The cleared status of the transaction
   * @return cleared
  **/
  @javax.annotation.Nullable

  public ClearedEnum getCleared() {
    return cleared;
  }


  public void setCleared(ClearedEnum cleared) {
    this.cleared = cleared;
  }


  public SaveTransactionWithOptionalFields approved(Boolean approved) {
    
    this.approved = approved;
    return this;
  }

   /**
   * Whether or not the transaction is approved.  If not supplied, transaction will be unapproved by default.
   * @return approved
  **/
  @javax.annotation.Nullable

  public Boolean getApproved() {
    return approved;
  }


  public void setApproved(Boolean approved) {
    this.approved = approved;
  }


  public SaveTransactionWithOptionalFields flagColor(FlagColorEnum flagColor) {
    
    this.flagColor = flagColor;
    return this;
  }

   /**
   * The transaction flag
   * @return flagColor
  **/
  @javax.annotation.Nullable

  public FlagColorEnum getFlagColor() {
    return flagColor;
  }


  public void setFlagColor(FlagColorEnum flagColor) {
    this.flagColor = flagColor;
  }


  public SaveTransactionWithOptionalFields importId(String importId) {
    
    this.importId = importId;
    return this;
  }

   /**
   * If specified, the new transaction will be assigned this &#x60;import_id&#x60; and considered \&quot;imported\&quot;.  We will also attempt to match this imported transaction to an existing \&quot;user-entered\&quot; transation on the same account, with the same amount, and with a date +/-10 days from the imported transaction date.&lt;br&gt;&lt;br&gt;Transactions imported through File Based Import or Direct Import (not through the API) are assigned an import_id in the format: &#39;YNAB:[milliunit_amount]:[iso_date]:[occurrence]&#39;. For example, a transaction dated 2015-12-30 in the amount of -$294.23 USD would have an import_id of &#39;YNAB:-294230:2015-12-30:1&#39;.  If a second transaction on the same account was imported and had the same date and same amount, its import_id would be &#39;YNAB:-294230:2015-12-30:2&#39;.  Using a consistent format will prevent duplicates through Direct Import and File Based Import.&lt;br&gt;&lt;br&gt;If import_id is omitted or specified as null, the transaction will be treated as a \&quot;user-entered\&quot; transaction. As such, it will be eligible to be matched against transactions later being imported (via DI, FBI, or API).
   * @return importId
  **/
  @javax.annotation.Nullable

  public String getImportId() {
    return importId;
  }


  public void setImportId(String importId) {
    this.importId = importId;
  }


  public SaveTransactionWithOptionalFields subtransactions(List<SaveSubTransaction> subtransactions) {
    
    this.subtransactions = subtransactions;
    return this;
  }

  public SaveTransactionWithOptionalFields addSubtransactionsItem(SaveSubTransaction subtransactionsItem) {
    if (this.subtransactions == null) {
      this.subtransactions = new ArrayList<>();
    }
    this.subtransactions.add(subtransactionsItem);
    return this;
  }

   /**
   * An array of subtransactions to configure a transaction as a split.  Updating &#x60;subtransactions&#x60; on an existing split transaction is not supported.
   * @return subtransactions
  **/
  @javax.annotation.Nullable

  public List<SaveSubTransaction> getSubtransactions() {
    return subtransactions;
  }


  public void setSubtransactions(List<SaveSubTransaction> subtransactions) {
    this.subtransactions = subtransactions;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaveTransactionWithOptionalFields saveTransactionWithOptionalFields = (SaveTransactionWithOptionalFields) o;
    return Objects.equals(this.accountId, saveTransactionWithOptionalFields.accountId) &&
        Objects.equals(this.date, saveTransactionWithOptionalFields.date) &&
        Objects.equals(this.amount, saveTransactionWithOptionalFields.amount) &&
        Objects.equals(this.payeeId, saveTransactionWithOptionalFields.payeeId) &&
        Objects.equals(this.payeeName, saveTransactionWithOptionalFields.payeeName) &&
        Objects.equals(this.categoryId, saveTransactionWithOptionalFields.categoryId) &&
        Objects.equals(this.memo, saveTransactionWithOptionalFields.memo) &&
        Objects.equals(this.cleared, saveTransactionWithOptionalFields.cleared) &&
        Objects.equals(this.approved, saveTransactionWithOptionalFields.approved) &&
        Objects.equals(this.flagColor, saveTransactionWithOptionalFields.flagColor) &&
        Objects.equals(this.importId, saveTransactionWithOptionalFields.importId) &&
        Objects.equals(this.subtransactions, saveTransactionWithOptionalFields.subtransactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, date, amount, payeeId, payeeName, categoryId, memo, cleared, approved, flagColor, importId, subtransactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaveTransactionWithOptionalFields {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    payeeId: ").append(toIndentedString(payeeId)).append("\n");
    sb.append("    payeeName: ").append(toIndentedString(payeeName)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    cleared: ").append(toIndentedString(cleared)).append("\n");
    sb.append("    approved: ").append(toIndentedString(approved)).append("\n");
    sb.append("    flagColor: ").append(toIndentedString(flagColor)).append("\n");
    sb.append("    importId: ").append(toIndentedString(importId)).append("\n");
    sb.append("    subtransactions: ").append(toIndentedString(subtransactions)).append("\n");
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
    openapiFields.add("account_id");
    openapiFields.add("date");
    openapiFields.add("amount");
    openapiFields.add("payee_id");
    openapiFields.add("payee_name");
    openapiFields.add("category_id");
    openapiFields.add("memo");
    openapiFields.add("cleared");
    openapiFields.add("approved");
    openapiFields.add("flag_color");
    openapiFields.add("import_id");
    openapiFields.add("subtransactions");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to SaveTransactionWithOptionalFields
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!SaveTransactionWithOptionalFields.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SaveTransactionWithOptionalFields is not found in the empty JSON string", SaveTransactionWithOptionalFields.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!SaveTransactionWithOptionalFields.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SaveTransactionWithOptionalFields` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("account_id") != null && !jsonObj.get("account_id").isJsonNull()) && !jsonObj.get("account_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account_id").toString()));
      }
      if ((jsonObj.get("payee_id") != null && !jsonObj.get("payee_id").isJsonNull()) && !jsonObj.get("payee_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payee_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payee_id").toString()));
      }
      if ((jsonObj.get("payee_name") != null && !jsonObj.get("payee_name").isJsonNull()) && !jsonObj.get("payee_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payee_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payee_name").toString()));
      }
      if ((jsonObj.get("category_id") != null && !jsonObj.get("category_id").isJsonNull()) && !jsonObj.get("category_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `category_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("category_id").toString()));
      }
      if ((jsonObj.get("memo") != null && !jsonObj.get("memo").isJsonNull()) && !jsonObj.get("memo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `memo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("memo").toString()));
      }
      if ((jsonObj.get("cleared") != null && !jsonObj.get("cleared").isJsonNull()) && !jsonObj.get("cleared").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cleared` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cleared").toString()));
      }
      if ((jsonObj.get("flag_color") != null && !jsonObj.get("flag_color").isJsonNull()) && !jsonObj.get("flag_color").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `flag_color` to be a primitive type in the JSON string but got `%s`", jsonObj.get("flag_color").toString()));
      }
      if ((jsonObj.get("import_id") != null && !jsonObj.get("import_id").isJsonNull()) && !jsonObj.get("import_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `import_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("import_id").toString()));
      }
      if (jsonObj.get("subtransactions") != null && !jsonObj.get("subtransactions").isJsonNull()) {
        JsonArray jsonArraysubtransactions = jsonObj.getAsJsonArray("subtransactions");
        if (jsonArraysubtransactions != null) {
          // ensure the json data is an array
          if (!jsonObj.get("subtransactions").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `subtransactions` to be an array in the JSON string but got `%s`", jsonObj.get("subtransactions").toString()));
          }

          // validate the optional field `subtransactions` (array)
          for (int i = 0; i < jsonArraysubtransactions.size(); i++) {
            SaveSubTransaction.validateJsonObject(jsonArraysubtransactions.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SaveTransactionWithOptionalFields.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SaveTransactionWithOptionalFields' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SaveTransactionWithOptionalFields> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SaveTransactionWithOptionalFields.class));

       return (TypeAdapter<T>) new TypeAdapter<SaveTransactionWithOptionalFields>() {
           @Override
           public void write(JsonWriter out, SaveTransactionWithOptionalFields value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SaveTransactionWithOptionalFields read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SaveTransactionWithOptionalFields given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SaveTransactionWithOptionalFields
  * @throws IOException if the JSON string is invalid with respect to SaveTransactionWithOptionalFields
  */
  public static SaveTransactionWithOptionalFields fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SaveTransactionWithOptionalFields.class);
  }

 /**
  * Convert an instance of SaveTransactionWithOptionalFields to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

