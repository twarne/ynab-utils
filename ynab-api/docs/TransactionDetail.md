

# TransactionDetail


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**date** | **LocalDate** | The transaction date in ISO format (e.g. 2016-12-01) |  |
|**amount** | **Long** | The transaction amount in milliunits format |  |
|**memo** | **String** |  |  [optional] |
|**cleared** | [**ClearedEnum**](#ClearedEnum) | The cleared status of the transaction |  |
|**approved** | **Boolean** | Whether or not the transaction is approved |  |
|**flagColor** | [**FlagColorEnum**](#FlagColorEnum) | The transaction flag |  [optional] |
|**accountId** | **UUID** |  |  |
|**payeeId** | **UUID** |  |  [optional] |
|**categoryId** | **UUID** |  |  [optional] |
|**transferAccountId** | **UUID** | If a transfer transaction, the account to which it transfers |  [optional] |
|**transferTransactionId** | **String** | If a transfer transaction, the id of transaction on the other side of the transfer |  [optional] |
|**matchedTransactionId** | **String** | If transaction is matched, the id of the matched transaction |  [optional] |
|**importId** | **String** | If the transaction was imported, this field is a unique (by account) import identifier.  If this transaction was imported through File Based Import or Direct Import and not through the API, the import_id will have the format: &#39;YNAB:[milliunit_amount]:[iso_date]:[occurrence]&#39;.  For example, a transaction dated 2015-12-30 in the amount of -$294.23 USD would have an import_id of &#39;YNAB:-294230:2015-12-30:1&#39;.  If a second transaction on the same account was imported and had the same date and same amount, its import_id would be &#39;YNAB:-294230:2015-12-30:2&#39;. |  [optional] |
|**importPayeeName** | **String** | If the transaction was imported, the payee name that was used when importing and before applying any payee rename rules |  [optional] |
|**importPayeeNameOriginal** | **String** | If the transaction was imported, the original payee name as it appeared on the statement |  [optional] |
|**debtTransactionType** | [**DebtTransactionTypeEnum**](#DebtTransactionTypeEnum) | If the transaction is a debt/loan account transaction, the type of transaction |  [optional] |
|**deleted** | **Boolean** | Whether or not the transaction has been deleted.  Deleted transactions will only be included in delta requests. |  |
|**accountName** | **String** |  |  |
|**payeeName** | **String** |  |  [optional] |
|**categoryName** | **String** |  |  [optional] |
|**subtransactions** | [**List&lt;SubTransaction&gt;**](SubTransaction.md) | If a split transaction, the subtransactions. |  |



## Enum: ClearedEnum

| Name | Value |
|---- | -----|
| CLEARED | &quot;cleared&quot; |
| UNCLEARED | &quot;uncleared&quot; |
| RECONCILED | &quot;reconciled&quot; |



## Enum: FlagColorEnum

| Name | Value |
|---- | -----|
| RED | &quot;red&quot; |
| ORANGE | &quot;orange&quot; |
| YELLOW | &quot;yellow&quot; |
| GREEN | &quot;green&quot; |
| BLUE | &quot;blue&quot; |
| PURPLE | &quot;purple&quot; |



## Enum: DebtTransactionTypeEnum

| Name | Value |
|---- | -----|
| PAYMENT | &quot;payment&quot; |
| REFUND | &quot;refund&quot; |
| FEE | &quot;fee&quot; |
| INTEREST | &quot;interest&quot; |
| ESCROW | &quot;escrow&quot; |
| BALANCEDADJUSTMENT | &quot;balancedAdjustment&quot; |
| CREDIT | &quot;credit&quot; |
| CHARGE | &quot;charge&quot; |



