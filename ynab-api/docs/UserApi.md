# UserApi

All URIs are relative to *https://api.youneedabudget.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getUser**](UserApi.md#getUser) | **GET** /user | User info |


<a name="getUser"></a>
# **getUser**
> UserResponse getUser()

User info

Returns authenticated user information

### Example
```java
// Import classes:
import com.kickthedrawer.ynab.ApiClient;
import com.kickthedrawer.ynab.ApiException;
import com.kickthedrawer.ynab.Configuration;
import com.kickthedrawer.ynab.auth.*;
import com.kickthedrawer.ynab.models.*;
import com.kickthedrawer.ynab.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.youneedabudget.com/v1");
    
    // Configure API key authorization: bearer
    ApiKeyAuth bearer = (ApiKeyAuth) defaultClient.getAuthentication("bearer");
    bearer.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //bearer.setApiKeyPrefix("Token");

    UserApi apiInstance = new UserApi(defaultClient);
    try {
      UserResponse result = apiInstance.getUser();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#getUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The user info |  -  |
| **0** | An error occurred |  -  |

