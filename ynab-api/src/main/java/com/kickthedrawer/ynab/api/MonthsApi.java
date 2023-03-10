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


import com.kickthedrawer.ynab.model.ErrorResponse;
import java.time.LocalDate;
import com.kickthedrawer.ynab.model.MonthDetailResponse;
import com.kickthedrawer.ynab.model.MonthSummariesResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class MonthsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public MonthsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MonthsApi(ApiClient apiClient) {
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
     * Build call for getBudgetMonth
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The budget month detail </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The budget month was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBudgetMonthCall(String budgetId, LocalDate month, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/budgets/{budget_id}/months/{month}"
            .replace("{" + "budget_id" + "}", localVarApiClient.escapeString(budgetId.toString()))
            .replace("{" + "month" + "}", localVarApiClient.escapeString(month.toString()));

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
    private okhttp3.Call getBudgetMonthValidateBeforeCall(String budgetId, LocalDate month, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getBudgetMonth(Async)");
        }

        // verify the required parameter 'month' is set
        if (month == null) {
            throw new ApiException("Missing the required parameter 'month' when calling getBudgetMonth(Async)");
        }

        return getBudgetMonthCall(budgetId, month, _callback);

    }

    /**
     * Single budget month
     * Returns a single budget month
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @return MonthDetailResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The budget month detail </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The budget month was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public MonthDetailResponse getBudgetMonth(String budgetId, LocalDate month) throws ApiException {
        ApiResponse<MonthDetailResponse> localVarResp = getBudgetMonthWithHttpInfo(budgetId, month);
        return localVarResp.getData();
    }

    /**
     * Single budget month
     * Returns a single budget month
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @return ApiResponse&lt;MonthDetailResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The budget month detail </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The budget month was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<MonthDetailResponse> getBudgetMonthWithHttpInfo(String budgetId, LocalDate month) throws ApiException {
        okhttp3.Call localVarCall = getBudgetMonthValidateBeforeCall(budgetId, month, null);
        Type localVarReturnType = new TypeToken<MonthDetailResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Single budget month (asynchronously)
     * Returns a single budget month
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The budget month detail </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The budget month was not found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBudgetMonthAsync(String budgetId, LocalDate month, final ApiCallback<MonthDetailResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBudgetMonthValidateBeforeCall(budgetId, month, _callback);
        Type localVarReturnType = new TypeToken<MonthDetailResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getBudgetMonths
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of budget months </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No budget months were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBudgetMonthsCall(String budgetId, Long lastKnowledgeOfServer, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/budgets/{budget_id}/months"
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
    private okhttp3.Call getBudgetMonthsValidateBeforeCall(String budgetId, Long lastKnowledgeOfServer, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getBudgetMonths(Async)");
        }

        return getBudgetMonthsCall(budgetId, lastKnowledgeOfServer, _callback);

    }

    /**
     * List budget months
     * Returns all budget months
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @return MonthSummariesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of budget months </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No budget months were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public MonthSummariesResponse getBudgetMonths(String budgetId, Long lastKnowledgeOfServer) throws ApiException {
        ApiResponse<MonthSummariesResponse> localVarResp = getBudgetMonthsWithHttpInfo(budgetId, lastKnowledgeOfServer);
        return localVarResp.getData();
    }

    /**
     * List budget months
     * Returns all budget months
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @return ApiResponse&lt;MonthSummariesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of budget months </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No budget months were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<MonthSummariesResponse> getBudgetMonthsWithHttpInfo(String budgetId, Long lastKnowledgeOfServer) throws ApiException {
        okhttp3.Call localVarCall = getBudgetMonthsValidateBeforeCall(budgetId, lastKnowledgeOfServer, null);
        Type localVarReturnType = new TypeToken<MonthSummariesResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List budget months (asynchronously)
     * Returns all budget months
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The list of budget months </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No budget months were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBudgetMonthsAsync(String budgetId, Long lastKnowledgeOfServer, final ApiCallback<MonthSummariesResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBudgetMonthsValidateBeforeCall(budgetId, lastKnowledgeOfServer, _callback);
        Type localVarReturnType = new TypeToken<MonthSummariesResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}