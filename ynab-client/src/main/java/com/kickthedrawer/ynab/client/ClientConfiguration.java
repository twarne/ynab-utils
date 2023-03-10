package com.kickthedrawer.ynab.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.kickthedrawer.ynab.ApiClient;
import com.kickthedrawer.ynab.Configuration;
import com.kickthedrawer.ynab.api.AccountsApi;
import com.kickthedrawer.ynab.api.BudgetsApi;
import com.kickthedrawer.ynab.api.TransactionsApi;
import com.kickthedrawer.ynab.auth.ApiKeyAuth;

@org.springframework.context.annotation.Configuration
public class ClientConfiguration {

    @Value("${ynab.accessToken}")
    private String accessToken;

    @Value("${ynab.baseUrl}")
    private String baseUrl;

    @Value("${ynab.budgetName}")
    private String budgetName;

    @Bean
    public ApiClient apiClient() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath(baseUrl);

        // Configure API key authorization: bearer
        ApiKeyAuth bearer = (ApiKeyAuth) defaultClient.getAuthentication("bearer");
        bearer.setApiKey(accessToken);

        return defaultClient;
    }

    @Bean
    public BudgetsApi budgetsApi(ApiClient apiClient) {
        return new BudgetsApi(apiClient);
    }

    @Bean
    public AccountsApi accountsApi(ApiClient apiClient) {
        return new AccountsApi(apiClient);
    }

    @Bean
    public TransactionsApi transactionsApi(ApiClient apiClient) {
        return new TransactionsApi(apiClient);
    }

}
