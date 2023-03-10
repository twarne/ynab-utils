

# ScheduledSubTransaction


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**scheduledTransactionId** | **UUID** |  |  |
|**amount** | **Long** | The scheduled subtransaction amount in milliunits format |  |
|**memo** | **String** |  |  [optional] |
|**payeeId** | **UUID** |  |  [optional] |
|**categoryId** | **UUID** |  |  [optional] |
|**transferAccountId** | **UUID** | If a transfer, the account_id which the scheduled subtransaction transfers to |  [optional] |
|**deleted** | **Boolean** | Whether or not the scheduled subtransaction has been deleted.  Deleted scheduled subtransactions will only be included in delta requests. |  |



