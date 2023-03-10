package com.kickthedrawer.ynab.client;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kickthedrawer.ynab.ApiException;
import com.kickthedrawer.ynab.api.AccountsApi;
import com.kickthedrawer.ynab.api.BudgetsApi;
import com.kickthedrawer.ynab.api.TransactionsApi;
import com.kickthedrawer.ynab.model.Account;
import com.kickthedrawer.ynab.model.AccountsResponse;
import com.kickthedrawer.ynab.model.BudgetSummary;
import com.kickthedrawer.ynab.model.BudgetSummaryResponse;
import com.kickthedrawer.ynab.model.PostTransactionsWrapper;
import com.kickthedrawer.ynab.model.SaveTransaction;
import com.kickthedrawer.ynab.model.SaveTransactionsResponse;

import lombok.extern.java.Log;

@Component
@Log
public class YnabClient {

    @Autowired
    private BudgetsApi budgetsApi;

    @Autowired
    private AccountsApi accountsApi;

    @Autowired
    private TransactionsApi transactionsApi;

    private List<BudgetSummary> budgetSummaries;

    private BudgetSummary defaultBudget;

    private Map<BudgetSummary, List<Account>> budgetAccounts;

    public void loadBudgets(boolean force) throws ApiException {
        if(!force && budgetSummaries != null) {
            log.info("Budgets already loaded; using cached response");
            return;
        }
        BudgetSummaryResponse budgetSummary = budgetsApi.getBudgets(false);
        budgetSummaries = new ArrayList<>();
        budgetSummaries.addAll(budgetSummary.getData().getBudgets());
        defaultBudget = budgetSummary.getData().getDefaultBudget();
    }

    public BudgetSummary getBudgetByName(String budgetName) throws ApiException {
        loadBudgets(false);

        Optional<BudgetSummary> budget = budgetSummaries.stream()
                .filter(budgetSummary -> budgetName.equals(budgetSummary.getName())).findFirst();

        return budget.orElse(null);
    }

    public void loadAccounts(BudgetSummary budget, boolean force) throws ApiException {
        if(!force && budgetAccounts.containsKey(budget)) {
            log.info("Accounts already loaded; using cached response");
            return;
        }

        AccountsResponse accountsResponse = accountsApi.getAccounts(budget.getId().toString(), null);
        List<Account> accounts = new ArrayList<>();
        accounts.addAll(accountsResponse.getData().getAccounts());
        budgetAccounts.put(budget, accounts);
    }

    public Account getAccountByName(String accountName) throws ApiException {
        return getAccountByName(defaultBudget, accountName);
    }

    public Account getAccountByName(BudgetSummary budget, String accountName) throws ApiException {
        loadAccounts(budget, false);
    
        Optional<Account> account = budgetAccounts.getOrDefault(budget, Collections.emptyList()).stream()
                .filter(item -> accountName.equals(item.getName())).findFirst();

        return account.orElse(null);
    }

    public void addTransactions(String accountName, List<SaveTransaction> transactions) throws ApiException {
        Account account = getAccountByName(accountName);
        addTransactions(defaultBudget, account, transactions);
    }

    public void addTransactions(Account account, List<SaveTransaction> transactions) throws ApiException {
        addTransactions(defaultBudget, account, transactions);
    }

    public void addTransactions(BudgetSummary budget, Account account, List<SaveTransaction> transactions) throws ApiException {
        log.info(format("Saving %d transactions to account (%s / %s) in budget (%s / %s)", transactions.size(),
                account.getId().toString(), account.getName(), budget.getId().toString(), budget.getName()));
        PostTransactionsWrapper wrapper = new PostTransactionsWrapper();
        transactions.stream().peek(transaction -> transaction.setAccountId(account.getId()))
                .forEach(item -> wrapper.addTransactionsItem(item));
        SaveTransactionsResponse response = transactionsApi.createTransaction(budget.getId().toString(), wrapper);
        if(transactions.size() != response.getData().getTransactionIds().size()) {
            log.info(format("Some transactions did not get saved (sent: %d; received: %d)", transactions.size(),
                    response.getData().getTransactionIds().size()));
        } else {
            log.info("Successfully saved transactions");
        }
    }
    
}
