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


import com.kickthedrawer.ynab.model.CategoriesResponse;
import com.kickthedrawer.ynab.model.CategoryResponse;
import com.kickthedrawer.ynab.model.ErrorResponse;
import java.time.LocalDate;
import com.kickthedrawer.ynab.model.PatchMonthCategoryWrapper;
import com.kickthedrawer.ynab.model.SaveCategoryResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class CategoriesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public CategoriesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CategoriesApi(ApiClient apiClient) {
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
     * Build call for getCategories
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The categories grouped by category group </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No categories were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCategoriesCall(String budgetId, Long lastKnowledgeOfServer, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/budgets/{budget_id}/categories"
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
    private okhttp3.Call getCategoriesValidateBeforeCall(String budgetId, Long lastKnowledgeOfServer, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getCategories(Async)");
        }

        return getCategoriesCall(budgetId, lastKnowledgeOfServer, _callback);

    }

    /**
     * List categories
     * Returns all categories grouped by category group.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @return CategoriesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The categories grouped by category group </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No categories were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public CategoriesResponse getCategories(String budgetId, Long lastKnowledgeOfServer) throws ApiException {
        ApiResponse<CategoriesResponse> localVarResp = getCategoriesWithHttpInfo(budgetId, lastKnowledgeOfServer);
        return localVarResp.getData();
    }

    /**
     * List categories
     * Returns all categories grouped by category group.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @return ApiResponse&lt;CategoriesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The categories grouped by category group </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No categories were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoriesResponse> getCategoriesWithHttpInfo(String budgetId, Long lastKnowledgeOfServer) throws ApiException {
        okhttp3.Call localVarCall = getCategoriesValidateBeforeCall(budgetId, lastKnowledgeOfServer, null);
        Type localVarReturnType = new TypeToken<CategoriesResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List categories (asynchronously)
     * Returns all categories grouped by category group.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param lastKnowledgeOfServer The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The categories grouped by category group </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No categories were found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCategoriesAsync(String budgetId, Long lastKnowledgeOfServer, final ApiCallback<CategoriesResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCategoriesValidateBeforeCall(budgetId, lastKnowledgeOfServer, _callback);
        Type localVarReturnType = new TypeToken<CategoriesResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getCategoryById
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param categoryId The id of the category (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The category not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCategoryByIdCall(String budgetId, String categoryId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/budgets/{budget_id}/categories/{category_id}"
            .replace("{" + "budget_id" + "}", localVarApiClient.escapeString(budgetId.toString()))
            .replace("{" + "category_id" + "}", localVarApiClient.escapeString(categoryId.toString()));

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
    private okhttp3.Call getCategoryByIdValidateBeforeCall(String budgetId, String categoryId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getCategoryById(Async)");
        }

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new ApiException("Missing the required parameter 'categoryId' when calling getCategoryById(Async)");
        }

        return getCategoryByIdCall(budgetId, categoryId, _callback);

    }

    /**
     * Single category
     * Returns a single category.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param categoryId The id of the category (required)
     * @return CategoryResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The category not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public CategoryResponse getCategoryById(String budgetId, String categoryId) throws ApiException {
        ApiResponse<CategoryResponse> localVarResp = getCategoryByIdWithHttpInfo(budgetId, categoryId);
        return localVarResp.getData();
    }

    /**
     * Single category
     * Returns a single category.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param categoryId The id of the category (required)
     * @return ApiResponse&lt;CategoryResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The category not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoryResponse> getCategoryByIdWithHttpInfo(String budgetId, String categoryId) throws ApiException {
        okhttp3.Call localVarCall = getCategoryByIdValidateBeforeCall(budgetId, categoryId, null);
        Type localVarReturnType = new TypeToken<CategoryResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Single category (asynchronously)
     * Returns a single category.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param categoryId The id of the category (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The category not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCategoryByIdAsync(String budgetId, String categoryId, final ApiCallback<CategoryResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCategoryByIdValidateBeforeCall(budgetId, categoryId, _callback);
        Type localVarReturnType = new TypeToken<CategoryResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getMonthCategoryById
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested month category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The month category was not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMonthCategoryByIdCall(String budgetId, LocalDate month, String categoryId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/budgets/{budget_id}/months/{month}/categories/{category_id}"
            .replace("{" + "budget_id" + "}", localVarApiClient.escapeString(budgetId.toString()))
            .replace("{" + "month" + "}", localVarApiClient.escapeString(month.toString()))
            .replace("{" + "category_id" + "}", localVarApiClient.escapeString(categoryId.toString()));

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
    private okhttp3.Call getMonthCategoryByIdValidateBeforeCall(String budgetId, LocalDate month, String categoryId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling getMonthCategoryById(Async)");
        }

        // verify the required parameter 'month' is set
        if (month == null) {
            throw new ApiException("Missing the required parameter 'month' when calling getMonthCategoryById(Async)");
        }

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new ApiException("Missing the required parameter 'categoryId' when calling getMonthCategoryById(Async)");
        }

        return getMonthCategoryByIdCall(budgetId, month, categoryId, _callback);

    }

    /**
     * Single category for a specific budget month
     * Returns a single category for a specific budget month.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @return CategoryResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested month category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The month category was not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public CategoryResponse getMonthCategoryById(String budgetId, LocalDate month, String categoryId) throws ApiException {
        ApiResponse<CategoryResponse> localVarResp = getMonthCategoryByIdWithHttpInfo(budgetId, month, categoryId);
        return localVarResp.getData();
    }

    /**
     * Single category for a specific budget month
     * Returns a single category for a specific budget month.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @return ApiResponse&lt;CategoryResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested month category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The month category was not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoryResponse> getMonthCategoryByIdWithHttpInfo(String budgetId, LocalDate month, String categoryId) throws ApiException {
        okhttp3.Call localVarCall = getMonthCategoryByIdValidateBeforeCall(budgetId, month, categoryId, null);
        Type localVarReturnType = new TypeToken<CategoryResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Single category for a specific budget month (asynchronously)
     * Returns a single category for a specific budget month.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC).
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested month category </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> The month category was not was found </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> An error occurred </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMonthCategoryByIdAsync(String budgetId, LocalDate month, String categoryId, final ApiCallback<CategoryResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getMonthCategoryByIdValidateBeforeCall(budgetId, month, categoryId, _callback);
        Type localVarReturnType = new TypeToken<CategoryResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateMonthCategory
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @param data The category to update.  Only &#x60;budgeted&#x60; amount can be updated and any other fields specified will be ignored. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The month category was successfully updated </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s) </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateMonthCategoryCall(String budgetId, LocalDate month, String categoryId, PatchMonthCategoryWrapper data, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/budgets/{budget_id}/months/{month}/categories/{category_id}"
            .replace("{" + "budget_id" + "}", localVarApiClient.escapeString(budgetId.toString()))
            .replace("{" + "month" + "}", localVarApiClient.escapeString(month.toString()))
            .replace("{" + "category_id" + "}", localVarApiClient.escapeString(categoryId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateMonthCategoryValidateBeforeCall(String budgetId, LocalDate month, String categoryId, PatchMonthCategoryWrapper data, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'budgetId' is set
        if (budgetId == null) {
            throw new ApiException("Missing the required parameter 'budgetId' when calling updateMonthCategory(Async)");
        }

        // verify the required parameter 'month' is set
        if (month == null) {
            throw new ApiException("Missing the required parameter 'month' when calling updateMonthCategory(Async)");
        }

        // verify the required parameter 'categoryId' is set
        if (categoryId == null) {
            throw new ApiException("Missing the required parameter 'categoryId' when calling updateMonthCategory(Async)");
        }

        // verify the required parameter 'data' is set
        if (data == null) {
            throw new ApiException("Missing the required parameter 'data' when calling updateMonthCategory(Async)");
        }

        return updateMonthCategoryCall(budgetId, month, categoryId, data, _callback);

    }

    /**
     * Update a category for a specific month
     * Update a category for a specific month.  Only &#x60;budgeted&#x60; amount can be updated.
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @param data The category to update.  Only &#x60;budgeted&#x60; amount can be updated and any other fields specified will be ignored. (required)
     * @return SaveCategoryResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The month category was successfully updated </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s) </td><td>  -  </td></tr>
     </table>
     */
    public SaveCategoryResponse updateMonthCategory(String budgetId, LocalDate month, String categoryId, PatchMonthCategoryWrapper data) throws ApiException {
        ApiResponse<SaveCategoryResponse> localVarResp = updateMonthCategoryWithHttpInfo(budgetId, month, categoryId, data);
        return localVarResp.getData();
    }

    /**
     * Update a category for a specific month
     * Update a category for a specific month.  Only &#x60;budgeted&#x60; amount can be updated.
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @param data The category to update.  Only &#x60;budgeted&#x60; amount can be updated and any other fields specified will be ignored. (required)
     * @return ApiResponse&lt;SaveCategoryResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The month category was successfully updated </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s) </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<SaveCategoryResponse> updateMonthCategoryWithHttpInfo(String budgetId, LocalDate month, String categoryId, PatchMonthCategoryWrapper data) throws ApiException {
        okhttp3.Call localVarCall = updateMonthCategoryValidateBeforeCall(budgetId, month, categoryId, data, null);
        Type localVarReturnType = new TypeToken<SaveCategoryResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update a category for a specific month (asynchronously)
     * Update a category for a specific month.  Only &#x60;budgeted&#x60; amount can be updated.
     * @param budgetId The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.youneedabudget.com/#oauth-default-budget). (required)
     * @param month The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) (required)
     * @param categoryId The id of the category (required)
     * @param data The category to update.  Only &#x60;budgeted&#x60; amount can be updated and any other fields specified will be ignored. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The month category was successfully updated </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The request could not be understood due to malformed syntax or validation error(s) </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateMonthCategoryAsync(String budgetId, LocalDate month, String categoryId, PatchMonthCategoryWrapper data, final ApiCallback<SaveCategoryResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateMonthCategoryValidateBeforeCall(budgetId, month, categoryId, data, _callback);
        Type localVarReturnType = new TypeToken<SaveCategoryResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
