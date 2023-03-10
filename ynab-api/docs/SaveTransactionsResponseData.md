

# SaveTransactionsResponseData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**transactionIds** | **List&lt;String&gt;** | The transaction ids that were saved |  |
|**transaction** | [**TransactionDetail**](TransactionDetail.md) |  |  [optional] |
|**transactions** | [**List&lt;TransactionDetail&gt;**](TransactionDetail.md) | If multiple transactions were specified, the transactions that were saved |  [optional] |
|**duplicateImportIds** | **List&lt;String&gt;** | If multiple transactions were specified, a list of import_ids that were not created because of an existing &#x60;import_id&#x60; found on the same account |  [optional] |
|**serverKnowledge** | **Long** | The knowledge of the server |  |



