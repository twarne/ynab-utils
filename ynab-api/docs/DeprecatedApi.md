# DeprecatedApi

All URIs are relative to *https://api.youneedabudget.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bulkCreateTransactions**](DeprecatedApi.md#bulkCreateTransactions) | **POST** /budgets/{budget_id}/transactions/bulk | Bulk create transactions |


<a name="bulkCreateTransactions"></a>
# **bulkCreateTransactions**
> BulkResponse bulkCreateTransactions(budgetId, transactions)

Bulk create transactions

Creates multiple transactions.  Although this endpoint is still supported, it is recommended to use &#39;POST /budgets/{budget_id}/transactions&#39; to create multiple transactions.

### Example
```java
// Import classes:
import com.kickthedrawer.ynab.ApiClient;
import com.kickthedrawer.ynab.ApiException;
import com.kickthedrawer.ynab.Configuration;
import com.kickthedrawer.ynab.auth.*;
import com.kickthedrawer.ynab.models.*;
import com.kickthedrawer.ynab.api.DeprecatedApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.youneedabudget.com/v1");
    
    // Configure API key authorization: bearer
    ApiKeyAuth bearer = (ApiKeyAuth) defaultClient.getAuthentication("bearer");
    bearer.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //bearer.setApiKeyPrefix("Token");

    DeprecatedApi apiInstance = new DeprecatedApi(defaultClient);
    String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget).
    BulkTransactions transactions = new BulkTransactions(); // BulkTransactions | The list of transactions to create
    try {
      BulkResponse result = apiInstance.bulkCreateTransactions(budgetId, transactions);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DeprecatedApi#bulkCreateTransactions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **budgetId** | **String**| The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). | |
| **transactions** | [**BulkTransactions**](BulkTransactions.md)| The list of transactions to create | |

### Return type

[**BulkResponse**](BulkResponse.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The bulk request was processed successfully |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s) |  -  |

