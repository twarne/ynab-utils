

# Account


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**name** | **String** |  |  |
|**type** | **AccountType** |  |  |
|**onBudget** | **Boolean** | Whether this account is on budget or not |  |
|**closed** | **Boolean** | Whether this account is closed or not |  |
|**note** | **String** |  |  [optional] |
|**balance** | **Long** | The current balance of the account in milliunits format |  |
|**clearedBalance** | **Long** | The current cleared balance of the account in milliunits format |  |
|**unclearedBalance** | **Long** | The current uncleared balance of the account in milliunits format |  |
|**transferPayeeId** | **UUID** | The payee id which should be used when transferring to this account |  |
|**directImportLinked** | **Boolean** | Whether or not the account is linked to a financial institution for automatic transaction import. |  [optional] |
|**directImportInError** | **Boolean** | If an account linked to a financial institution (direct_import_linked&#x3D;true) and the linked connection is not in a healthy state, this will be true. |  [optional] |
|**lastReconciledAt** | **OffsetDateTime** | A date/time specifying when the account was last reconciled. |  [optional] |
|**debtOriginalBalance** | **Long** | The original debt/loan account balance, specified in milliunits format. |  [optional] |
|**debtInterestRates** | **Map&lt;String, Long&gt;** |  |  [optional] |
|**debtMinimumPayments** | **Map&lt;String, Long&gt;** |  |  [optional] |
|**debtEscrowAmounts** | **Map&lt;String, Long&gt;** |  |  [optional] |
|**deleted** | **Boolean** | Whether or not the account has been deleted.  Deleted accounts will only be included in delta requests. |  |



