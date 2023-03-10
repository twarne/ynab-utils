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


package com.kickthedrawer.ynab.api;

import com.kickthedrawer.ynab.ApiCallback;
import com.kickthedrawer.ynab.ApiClient;
import com.kickthedrawer.ynab.ApiException;
import com.kickthedrawer.ynab.ApiResponse;
import com.kickthedrawer.ynab.Configuration;
import com.kickthedrawer.ynab.Pair;
import com.kickthedrawer.ynab.ProgressRequestBody;
import com.kickthedrawer.ynab.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.kickthedrawer.ynab.model.AccountResponse;
import com.kickthedrawer.ynab.model.AccountsResponse;
import com.kickthedrawer.ynab.model.ErrorResponse;
import com.kickthedrawer.ynab.model.PostAccountWrapper;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class AccountsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public AccountsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AccountsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for createAccount
     * @param budgetId The id of the budget (\&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget) (required)
     * @param data The account to create. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The account was successfully created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s). </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createAccountCall(String budgetId, PostAccountWrapper data, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = data;

        // create path and map variables
        String localVarPath = "/budgets/{budget_id}/accounts"
            .replace("{" + "budget_id" + "}", localVarApiClient.escapeString(budgetId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "bearer" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createAccountValidateBeforeCall(String budgetId, PostAccountWrapper data, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling createAccount(Async)");
        }

        // verify the required parameter 'data' is set
        if (data == null) {
            throw new ApiException("Missing the required parameter 'data' when calling createAccount(Async)");
        }

        return createAccountCall(budgetId, data, _callback);

    }

    /**
     * Create a new account
     * Creates a new account
     * @param budgetId The id of the budget (\&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget) (required)
     * @param data The account to create. (required)
     * @return AccountResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The account was successfully created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s). </td><td>  -  </td></tr>
     </table>
     */
    public AccountResponse createAccount(String budgetId, PostAccountWrapper data) throws ApiException {
        ApiResponse<AccountResponse> localVarResp = createAccountWithHttpInfo(budgetId, data);
        return localVarResp.getData();
    }

    /**
     * Create a new account
     * Creates a new account
     * @param budgetId The id of the budget (\&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget) (required)
     * @param data The account to create. (required)
     * @return ApiResponse&lt;AccountResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The account was successfully created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s). </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AccountResponse> createAccountWithHttpInfo(String budgetId, PostAccountWrapper data) throws ApiException {
        okhttp3.Call localVarCall = createAccountValidateBeforeCall(budgetId, data, null);
        Type localVarReturnType = new TypeToken<AccountResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a new account (asynchronously)
     * Creates a new account
     * @param budgetId The id of the budget (\&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget) (required)
     * @param data The account to create. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The account was successfully created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s). </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createAccountAsync(String budgetId, PostAccountWrapper data, final ApiCallback<AccountResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = createAccountValidateBeforeCall(budgetId, data, _callback);
        Type localVarReturnType = new TypeToken<AccountResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getAccountById
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param accountId The id of the account (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested account </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested account was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAccountByIdCall(String budgetId, UUID accountId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/budgets/{budget_id}/accounts/{account_id}"
            .replace("{" + "budget_id" + "}", localVarApiClient.escapeString(budgetId.toString()))
            .replace("{" + "account_id" + "}", localVarApiClient.escapeString(accountId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "bearer" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getAccountByIdValidateBeforeCall(String budgetId, UUID accountId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getAccountById(Async)");
        }

        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getAccountById(Async)");
        }

        return getAccountByIdCall(budgetId, accountId, _callback);

    }

    /**
     * Single account
     * Returns a single account
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param accountId The id of the account (required)
     * @return AccountResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested account </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested account was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public AccountResponse getAccountById(String budgetId, UUID accountId) throws ApiException {
        ApiResponse<AccountResponse> localVarResp = getAccountByIdWithHttpInfo(budgetId, accountId);
        return localVarResp.getData();
    }

    /**
     * Single account
     * Returns a single account
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param accountId The id of the account (required)
     * @return ApiResponse&lt;AccountResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested account </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested account was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AccountResponse> getAccountByIdWithHttpInfo(String budgetId, UUID accountId) throws ApiException {
        okhttp3.Call localVarCall = getAccountByIdValidateBeforeCall(budgetId, accountId, null);
        Type localVarReturnType = new TypeToken<AccountResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Single account (asynchronously)
     * Returns a single account
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param accountId The id of the account (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested account </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The requested account was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAccountByIdAsync(String budgetId, UUID accountId, final ApiCallback<AccountResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAccountByIdValidateBeforeCall(budgetId, accountId, _callback);
        Type localVarReturnType = new TypeToken<AccountResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getAccounts
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of requested accounts </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No accounts were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAccountsCall(String budgetId, Long lastKnowledgeOfServer, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/budgets/{budget_id}/accounts"
            .replace("{" + "budget_id" + "}", localVarApiClient.escapeString(budgetId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (lastKnowledgeOfServer != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("last_knowledge_of_server", lastKnowledgeOfServer));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "bearer" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getAccountsValidateBeforeCall(String budgetId, Long lastKnowledgeOfServer, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getAccounts(Async)");
        }

        return getAccountsCall(budgetId, lastKnowledgeOfServer, _callback);

    }

    /**
     * Account list
     * Returns all accounts
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @return AccountsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of requested accounts </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No accounts were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public AccountsResponse getAccounts(String budgetId, Long lastKnowledgeOfServer) throws ApiException {
        ApiResponse<AccountsResponse> localVarResp = getAccountsWithHttpInfo(budgetId, lastKnowledgeOfServer);
        return localVarResp.getData();
    }

    /**
     * Account list
     * Returns all accounts
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @return ApiResponse&lt;AccountsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of requested accounts </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No accounts were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AccountsResponse> getAccountsWithHttpInfo(String budgetId, Long lastKnowledgeOfServer) throws ApiException {
        okhttp3.Call localVarCall = getAccountsValidateBeforeCall(budgetId, lastKnowledgeOfServer, null);
        Type localVarReturnType = new TypeToken<AccountsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Account list (asynchronously)
     * Returns all accounts
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of requested accounts </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No accounts were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAccountsAsync(String budgetId, Long lastKnowledgeOfServer, final ApiCallback<AccountsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAccountsValidateBeforeCall(budgetId, lastKnowledgeOfServer, _callback);
        Type localVarReturnType = new TypeToken<AccountsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}