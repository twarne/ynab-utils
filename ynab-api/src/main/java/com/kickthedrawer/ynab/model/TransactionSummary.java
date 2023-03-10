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
import java.io.IOException;
import java.time.LocalDate;
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
 * TransactionSummary
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-18T14:52:04.431395-07:00[America/Phoenix]")
public class TransactionSummary {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private LocalDate date;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Long amount;

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

  public static final String SERIALIZED_NAME_ACCOUNT_ID = "account_id";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private UUID accountId;

  public static final String SERIALIZED_NAME_PAYEE_ID = "payee_id";
  @SerializedName(SERIALIZED_NAME_PAYEE_ID)
  private UUID payeeId;

  public static final String SERIALIZED_NAME_CATEGORY_ID = "category_id";
  @SerializedName(SERIALIZED_NAME_CATEGORY_ID)
  private UUID categoryId;

  public static final String SERIALIZED_NAME_TRANSFER_ACCOUNT_ID = "transfer_account_id";
  @SerializedName(SERIALIZED_NAME_TRANSFER_ACCOUNT_ID)
  private UUID transferAccountId;

  public static final String SERIALIZED_NAME_TRANSFER_TRANSACTION_ID = "transfer_transaction_id";
  @SerializedName(SERIALIZED_NAME_TRANSFER_TRANSACTION_ID)
  private String transferTransactionId;

  public static final String SERIALIZED_NAME_MATCHED_TRANSACTION_ID = "matched_transaction_id";
  @SerializedName(SERIALIZED_NAME_MATCHED_TRANSACTION_ID)
  private String matchedTransactionId;

  public static final String SERIALIZED_NAME_IMPORT_ID = "import_id";
  @SerializedName(SERIALIZED_NAME_IMPORT_ID)
  private String importId;

  public static final String SERIALIZED_NAME_IMPORT_PAYEE_NAME = "import_payee_name";
  @SerializedName(SERIALIZED_NAME_IMPORT_PAYEE_NAME)
  private String importPayeeName;

  public static final String SERIALIZED_NAME_IMPORT_PAYEE_NAME_ORIGINAL = "import_payee_name_original";
  @SerializedName(SERIALIZED_NAME_IMPORT_PAYEE_NAME_ORIGINAL)
  private String importPayeeNameOriginal;

  /**
   * If the transaction is a debt/loan account transaction, the type of transaction
   */
  @JsonAdapter(DebtTransactionTypeEnum.Adapter.class)
  public enum DebtTransactionTypeEnum {
    PAYMENT("payment"),
    
    REFUND("refund"),
    
    FEE("fee"),
    
    INTEREST("interest"),
    
    ESCROW("escrow"),
    
    BALANCEDADJUSTMENT("balancedAdjustment"),
    
    CREDIT("credit"),
    
    CHARGE("charge");

    private String value;

    DebtTransactionTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DebtTransactionTypeEnum fromValue(String value) {
      for (DebtTransactionTypeEnum b : DebtTransactionTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DebtTransactionTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DebtTransactionTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DebtTransactionTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DebtTransactionTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DEBT_TRANSACTION_TYPE = "debt_transaction_type";
  @SerializedName(SERIALIZED_NAME_DEBT_TRANSACTION_TYPE)
  private DebtTransactionTypeEnum debtTransactionType;

  public static final String SERIALIZED_NAME_DELETED = "deleted";
  @SerializedName(SERIALIZED_NAME_DELETED)
  private Boolean deleted;

  public TransactionSummary() {
  }

  public TransactionSummary id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public TransactionSummary date(LocalDate date) {
    
    this.date = date;
    return this;
  }

   /**
   * The transaction date in ISO format (e.g. 2016-12-01)
   * @return date
  **/
  @javax.annotation.Nonnull

  public LocalDate getDate() {
    return date;
  }


  public void setDate(LocalDate date) {
    this.date = date;
  }


  public TransactionSummary amount(Long amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * The transaction amount in milliunits format
   * @return amount
  **/
  @javax.annotation.Nonnull

  public Long getAmount() {
    return amount;
  }


  public void setAmount(Long amount) {
    this.amount = amount;
  }


  public TransactionSummary memo(String memo) {
    
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


  public TransactionSummary cleared(ClearedEnum cleared) {
    
    this.cleared = cleared;
    return this;
  }

   /**
   * The cleared status of the transaction
   * @return cleared
  **/
  @javax.annotation.Nonnull

  public ClearedEnum getCleared() {
    return cleared;
  }


  public void setCleared(ClearedEnum cleared) {
    this.cleared = cleared;
  }


  public TransactionSummary approved(Boolean approved) {
    
    this.approved = approved;
    return this;
  }

   /**
   * Whether or not the transaction is approved
   * @return approved
  **/
  @javax.annotation.Nonnull

  public Boolean getApproved() {
    return approved;
  }


  public void setApproved(Boolean approved) {
    this.approved = approved;
  }


  public TransactionSummary flagColor(FlagColorEnum flagColor) {
    
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


  public TransactionSummary accountId(UUID accountId) {
    
    this.accountId = accountId;
    return this;
  }

   /**
   * Get accountId
   * @return accountId
  **/
  @javax.annotation.Nonnull

  public UUID getAccountId() {
    return accountId;
  }


  public void setAccountId(UUID accountId) {
    this.accountId = accountId;
  }


  public TransactionSummary payeeId(UUID payeeId) {
    
    this.payeeId = payeeId;
    return this;
  }

   /**
   * Get payeeId
   * @return payeeId
  **/
  @javax.annotation.Nullable

  public UUID getPayeeId() {
    return payeeId;
  }


  public void setPayeeId(UUID payeeId) {
    this.payeeId = payeeId;
  }


  public TransactionSummary categoryId(UUID categoryId) {
    
    this.categoryId = categoryId;
    return this;
  }

   /**
   * Get categoryId
   * @return categoryId
  **/
  @javax.annotation.Nullable

  public UUID getCategoryId() {
    return categoryId;
  }


  public void setCategoryId(UUID categoryId) {
    this.categoryId = categoryId;
  }


  public TransactionSummary transferAccountId(UUID transferAccountId) {
    
    this.transferAccountId = transferAccountId;
    return this;
  }

   /**
   * If a transfer transaction, the account to which it transfers
   * @return transferAccountId
  **/
  @javax.annotation.Nullable

  public UUID getTransferAccountId() {
    return transferAccountId;
  }


  public void setTransferAccountId(UUID transferAccountId) {
    this.transferAccountId = transferAccountId;
  }


  public TransactionSummary transferTransactionId(String transferTransactionId) {
    
    this.transferTransactionId = transferTransactionId;
    return this;
  }

   /**
   * If a transfer transaction, the id of transaction on the other side of the transfer
   * @return transferTransactionId
  **/
  @javax.annotation.Nullable

  public String getTransferTransactionId() {
    return transferTransactionId;
  }


  public void setTransferTransactionId(String transferTransactionId) {
    this.transferTransactionId = transferTransactionId;
  }


  public TransactionSummary matchedTransactionId(String matchedTransactionId) {
    
    this.matchedTransactionId = matchedTransactionId;
    return this;
  }

   /**
   * If transaction is matched, the id of the matched transaction
   * @return matchedTransactionId
  **/
  @javax.annotation.Nullable

  public String getMatchedTransactionId() {
    return matchedTransactionId;
  }


  public void setMatchedTransactionId(String matchedTransactionId) {
    this.matchedTransactionId = matchedTransactionId;
  }


  public TransactionSummary importId(String importId) {
    
    this.importId = importId;
    return this;
  }

   /**
   * If the transaction was imported, this field is a unique (by account) import identifier.  If this transaction was imported through File Based Import or Direct Import and not through the API, the import_id will have the format: &#39;YNAB:[milliunit_amount]:[iso_date]:[occurrence]&#39;.  For example, a transaction dated 2015-12-30 in the amount of -$294.23 USD would have an import_id of &#39;YNAB:-294230:2015-12-30:1&#39;.  If a second transaction on the same account was imported and had the same date and same amount, its import_id would be &#39;YNAB:-294230:2015-12-30:2&#39;.
   * @return importId
  **/
  @javax.annotation.Nullable

  public String getImportId() {
    return importId;
  }


  public void setImportId(String importId) {
    this.importId = importId;
  }


  public TransactionSummary importPayeeName(String importPayeeName) {
    
    this.importPayeeName = importPayeeName;
    return this;
  }

   /**
   * If the transaction was imported, the payee name that was used when importing and before applying any payee rename rules
   * @return importPayeeName
  **/
  @javax.annotation.Nullable

  public String getImportPayeeName() {
    return importPayeeName;
  }


  public void setImportPayeeName(String importPayeeName) {
    this.importPayeeName = importPayeeName;
  }


  public TransactionSummary importPayeeNameOriginal(String importPayeeNameOriginal) {
    
    this.importPayeeNameOriginal = importPayeeNameOriginal;
    return this;
  }

   /**
   * If the transaction was imported, the original payee name as it appeared on the statement
   * @return importPayeeNameOriginal
  **/
  @javax.annotation.Nullable

  public String getImportPayeeNameOriginal() {
    return importPayeeNameOriginal;
  }


  public void setImportPayeeNameOriginal(String importPayeeNameOriginal) {
    this.importPayeeNameOriginal = importPayeeNameOriginal;
  }


  public TransactionSummary debtTransactionType(DebtTransactionTypeEnum debtTransactionType) {
    
    this.debtTransactionType = debtTransactionType;
    return this;
  }

   /**
   * If the transaction is a debt/loan account transaction, the type of transaction
   * @return debtTransactionType
  **/
  @javax.annotation.Nullable

  public DebtTransactionTypeEnum getDebtTransactionType() {
    return debtTransactionType;
  }


  public void setDebtTransactionType(DebtTransactionTypeEnum debtTransactionType) {
    this.debtTransactionType = debtTransactionType;
  }


  public TransactionSummary deleted(Boolean deleted) {
    
    this.deleted = deleted;
    return this;
  }

   /**
   * Whether or not the transaction has been deleted.  Deleted transactions will only be included in delta requests.
   * @return deleted
  **/
  @javax.annotation.Nonnull

  public Boolean getDeleted() {
    return deleted;
  }


  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionSummary transactionSummary = (TransactionSummary) o;
    return Objects.equals(this.id, transactionSummary.id) &&
        Objects.equals(this.date, transactionSummary.date) &&
        Objects.equals(this.amount, transactionSummary.amount) &&
        Objects.equals(this.memo, transactionSummary.memo) &&
        Objects.equals(this.cleared, transactionSummary.cleared) &&
        Objects.equals(this.approved, transactionSummary.approved) &&
        Objects.equals(this.flagColor, transactionSummary.flagColor) &&
        Objects.equals(this.accountId, transactionSummary.accountId) &&
        Objects.equals(this.payeeId, transactionSummary.payeeId) &&
        Objects.equals(this.categoryId, transactionSummary.categoryId) &&
        Objects.equals(this.transferAccountId, transactionSummary.transferAccountId) &&
        Objects.equals(this.transferTransactionId, transactionSummary.transferTransactionId) &&
        Objects.equals(this.matchedTransactionId, transactionSummary.matchedTransactionId) &&
        Objects.equals(this.importId, transactionSummary.importId) &&
        Objects.equals(this.importPayeeName, transactionSummary.importPayeeName) &&
        Objects.equals(this.importPayeeNameOriginal, transactionSummary.importPayeeNameOriginal) &&
        Objects.equals(this.debtTransactionType, transactionSummary.debtTransactionType) &&
        Objects.equals(this.deleted, transactionSummary.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, amount, memo, cleared, approved, flagColor, accountId, payeeId, categoryId, transferAccountId, transferTransactionId, matchedTransactionId, importId, importPayeeName, importPayeeNameOriginal, debtTransactionType, deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSummary {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    cleared: ").append(toIndentedString(cleared)).append("\n");
    sb.append("    approved: ").append(toIndentedString(approved)).append("\n");
    sb.append("    flagColor: ").append(toIndentedString(flagColor)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    payeeId: ").append(toIndentedString(payeeId)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    transferAccountId: ").append(toIndentedString(transferAccountId)).append("\n");
    sb.append("    transferTransactionId: ").append(toIndentedString(transferTransactionId)).append("\n");
    sb.append("    matchedTransactionId: ").append(toIndentedString(matchedTransactionId)).append("\n");
    sb.append("    importId: ").append(toIndentedString(importId)).append("\n");
    sb.append("    importPayeeName: ").append(toIndentedString(importPayeeName)).append("\n");
    sb.append("    importPayeeNameOriginal: ").append(toIndentedString(importPayeeNameOriginal)).append("\n");
    sb.append("    debtTransactionType: ").append(toIndentedString(debtTransactionType)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("date");
    openapiFields.add("amount");
    openapiFields.add("memo");
    openapiFields.add("cleared");
    openapiFields.add("approved");
    openapiFields.add("flag_color");
    openapiFields.add("account_id");
    openapiFields.add("payee_id");
    openapiFields.add("category_id");
    openapiFields.add("transfer_account_id");
    openapiFields.add("transfer_transaction_id");
    openapiFields.add("matched_transaction_id");
    openapiFields.add("import_id");
    openapiFields.add("import_payee_name");
    openapiFields.add("import_payee_name_original");
    openapiFields.add("debt_transaction_type");
    openapiFields.add("deleted");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("date");
    openapiRequiredFields.add("amount");
    openapiRequiredFields.add("cleared");
    openapiRequiredFields.add("approved");
    openapiRequiredFields.add("account_id");
    openapiRequiredFields.add("deleted");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TransactionSummary
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!TransactionSummary.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TransactionSummary is not found in the empty JSON string", TransactionSummary.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!TransactionSummary.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TransactionSummary` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TransactionSummary.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("memo") != null && !jsonObj.get("memo").isJsonNull()) && !jsonObj.get("memo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `memo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("memo").toString()));
      }
      if (!jsonObj.get("cleared").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cleared` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cleared").toString()));
      }
      if ((jsonObj.get("flag_color") != null && !jsonObj.get("flag_color").isJsonNull()) && !jsonObj.get("flag_color").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `flag_color` to be a primitive type in the JSON string but got `%s`", jsonObj.get("flag_color").toString()));
      }
      if (!jsonObj.get("account_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `account_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("account_id").toString()));
      }
      if ((jsonObj.get("payee_id") != null && !jsonObj.get("payee_id").isJsonNull()) && !jsonObj.get("payee_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payee_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payee_id").toString()));
      }
      if ((jsonObj.get("category_id") != null && !jsonObj.get("category_id").isJsonNull()) && !jsonObj.get("category_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `category_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("category_id").toString()));
      }
      if ((jsonObj.get("transfer_account_id") != null && !jsonObj.get("transfer_account_id").isJsonNull()) && !jsonObj.get("transfer_account_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `transfer_account_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("transfer_account_id").toString()));
      }
      if ((jsonObj.get("transfer_transaction_id") != null && !jsonObj.get("transfer_transaction_id").isJsonNull()) && !jsonObj.get("transfer_transaction_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `transfer_transaction_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("transfer_transaction_id").toString()));
      }
      if ((jsonObj.get("matched_transaction_id") != null && !jsonObj.get("matched_transaction_id").isJsonNull()) && !jsonObj.get("matched_transaction_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `matched_transaction_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("matched_transaction_id").toString()));
      }
      if ((jsonObj.get("import_id") != null && !jsonObj.get("import_id").isJsonNull()) && !jsonObj.get("import_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `import_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("import_id").toString()));
      }
      if ((jsonObj.get("import_payee_name") != null && !jsonObj.get("import_payee_name").isJsonNull()) && !jsonObj.get("import_payee_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `import_payee_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("import_payee_name").toString()));
      }
      if ((jsonObj.get("import_payee_name_original") != null && !jsonObj.get("import_payee_name_original").isJsonNull()) && !jsonObj.get("import_payee_name_original").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `import_payee_name_original` to be a primitive type in the JSON string but got `%s`", jsonObj.get("import_payee_name_original").toString()));
      }
      if ((jsonObj.get("debt_transaction_type") != null && !jsonObj.get("debt_transaction_type").isJsonNull()) && !jsonObj.get("debt_transaction_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `debt_transaction_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("debt_transaction_type").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TransactionSummary.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TransactionSummary' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TransactionSummary> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TransactionSummary.class));

       return (TypeAdapter<T>) new TypeAdapter<TransactionSummary>() {
           @Override
           public void write(JsonWriter out, TransactionSummary value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TransactionSummary read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TransactionSummary given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TransactionSummary
  * @throws IOException if the JSON string is invalid with respect to TransactionSummary
  */
  public static TransactionSummary fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TransactionSummary.class);
  }

 /**
  * Convert an instance of TransactionSummary to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

