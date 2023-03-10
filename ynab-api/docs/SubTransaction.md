

# SubTransaction


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**transactionId** | **String** |  |  |
|**amount** | **Long** | The subtransaction amount in milliunits format |  |
|**memo** | **String** |  |  [optional] |
|**payeeId** | **UUID** |  |  [optional] |
|**payeeName** | **String** |  |  [optional] |
|**categoryId** | **UUID** |  |  [optional] |
|**categoryName** | **String** |  |  [optional] |
|**transferAccountId** | **UUID** | If a transfer, the account_id which the subtransaction transfers to |  [optional] |
|**transferTransactionId** | **String** | If a transfer, the id of transaction on the other side of the transfer |  [optional] |
|**deleted** | **Boolean** | Whether or not the subtransaction has been deleted.  Deleted subtransactions will only be included in delta requests. |  |



