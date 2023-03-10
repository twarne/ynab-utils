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

import com.kickthedrawer.ynab.ApiException;
import com.kickthedrawer.ynab.model.ErrorResponse;
import com.kickthedrawer.ynab.model.HybridTransactionsResponse;
import java.time.LocalDate;
import com.kickthedrawer.ynab.model.PatchTransactionsWrapper;
import com.kickthedrawer.ynab.model.PostTransactionsWrapper;
import com.kickthedrawer.ynab.model.PutTransactionWrapper;
import com.kickthedrawer.ynab.model.SaveTransactionsResponse;
import com.kickthedrawer.ynab.model.TransactionResponse;
import com.kickthedrawer.ynab.model.TransactionsImportResponse;
import com.kickthedrawer.ynab.model.TransactionsResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TransactionsApi
 */
@Disabled
public class TransactionsApiTest {

    private final TransactionsApi api = new TransactionsApi();

    /**
     * Create a single transaction or multiple transactions
     *
     * Creates a single transaction or multiple transactions.  If you provide a body containing a &#x60;transaction&#x60; object, a single transaction will be created and if you provide a body containing a &#x60;transactions&#x60; array, multiple transactions will be created.  Scheduled transactions cannot be created on this endpoint.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createTransactionTest() throws ApiException {
        String budgetId = null;
        PostTransactionsWrapper data = null;
        SaveTransactionsResponse response = api.createTransaction(budgetId, data);
        // TODO: test validations
    }

    /**
     * Deletes an existing transaction
     *
     * Deletes a transaction
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteTransactionTest() throws ApiException {
        String budgetId = null;
        String transactionId = null;
        TransactionResponse response = api.deleteTransaction(budgetId, transactionId);
        // TODO: test validations
    }

    /**
     * Single transaction
     *
     * Returns a single transaction
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTransactionByIdTest() throws ApiException {
        String budgetId = null;
        String transactionId = null;
        TransactionResponse response = api.getTransactionById(budgetId, transactionId);
        // TODO: test validations
    }

    /**
     * List transactions
     *
     * Returns budget transactions
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTransactionsTest() throws ApiException {
        String budgetId = null;
        LocalDate sinceDate = null;
        String type = null;
        Long lastKnowledgeOfServer = null;
        TransactionsResponse response = api.getTransactions(budgetId, sinceDate, type, lastKnowledgeOfServer);
        // TODO: test validations
    }

    /**
     * List account transactions
     *
     * Returns all transactions for a specified account
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTransactionsByAccountTest() throws ApiException {
        String budgetId = null;
        String accountId = null;
        LocalDate sinceDate = null;
        String type = null;
        Long lastKnowledgeOfServer = null;
        TransactionsResponse response = api.getTransactionsByAccount(budgetId, accountId, sinceDate, type, lastKnowledgeOfServer);
        // TODO: test validations
    }

    /**
     * List category transactions
     *
     * Returns all transactions for a specified category
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTransactionsByCategoryTest() throws ApiException {
        String budgetId = null;
        String categoryId = null;
        LocalDate sinceDate = null;
        String type = null;
        Long lastKnowledgeOfServer = null;
        HybridTransactionsResponse response = api.getTransactionsByCategory(budgetId, categoryId, sinceDate, type, lastKnowledgeOfServer);
        // TODO: test validations
    }

    /**
     * List payee transactions
     *
     * Returns all transactions for a specified payee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTransactionsByPayeeTest() throws ApiException {
        String budgetId = null;
        String payeeId = null;
        LocalDate sinceDate = null;
        String type = null;
        Long lastKnowledgeOfServer = null;
        HybridTransactionsResponse response = api.getTransactionsByPayee(budgetId, payeeId, sinceDate, type, lastKnowledgeOfServer);
        // TODO: test validations
    }

    /**
     * Import transactions
     *
     * Imports available transactions on all linked accounts for the given budget.  Linked accounts allow transactions to be imported directly from a specified financial institution and this endpoint initiates that import.  Sending a request to this endpoint is the equivalent of clicking \&quot;Import\&quot; on each account in the web application or tapping the \&quot;New Transactions\&quot; banner in the mobile applications.  The response for this endpoint contains the transaction ids that have been imported.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void importTransactionsTest() throws ApiException {
        String budgetId = null;
        TransactionsImportResponse response = api.importTransactions(budgetId);
        // TODO: test validations
    }

    /**
     * Updates an existing transaction
     *
     * Updates a single transaction
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateTransactionTest() throws ApiException {
        String budgetId = null;
        String transactionId = null;
        PutTransactionWrapper data = null;
        TransactionResponse response = api.updateTransaction(budgetId, transactionId, data);
        // TODO: test validations
    }

    /**
     * Update multiple transactions
     *
     * Updates multiple transactions, by &#x60;id&#x60; or &#x60;import_id&#x60;.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateTransactionsTest() throws ApiException {
        String budgetId = null;
        PatchTransactionsWrapper data = null;
        SaveTransactionsResponse response = api.updateTransactions(budgetId, data);
        // TODO: test validations
    }

}