

# ScheduledTransactionDetail


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**dateFirst** | **LocalDate** | The first date for which the Scheduled Transaction was scheduled. |  |
|**dateNext** | **LocalDate** | The next date for which the Scheduled Transaction is scheduled. |  |
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) |  |  |
|**amount** | **Long** | The scheduled transaction amount in milliunits format |  |
|**memo** | **String** |  |  [optional] |
|**flagColor** | [**FlagColorEnum**](#FlagColorEnum) | The scheduled transaction flag |  [optional] |
|**accountId** | **UUID** |  |  |
|**payeeId** | **UUID** |  |  [optional] |
|**categoryId** | **UUID** |  |  [optional] |
|**transferAccountId** | **UUID** | If a transfer, the account_id which the scheduled transaction transfers to |  [optional] |
|**deleted** | **Boolean** | Whether or not the scheduled transaction has been deleted.  Deleted scheduled transactions will only be included in delta requests. |  |
|**accountName** | **String** |  |  |
|**payeeName** | **String** |  |  [optional] |
|**categoryName** | **String** |  |  [optional] |
|**subtransactions** | [**List&lt;ScheduledSubTransaction&gt;**](ScheduledSubTransaction.md) | If a split scheduled transaction, the subtransactions. |  |



## Enum: FrequencyEnum

| Name | Value |
|---- | -----|
| NEVER | &quot;never&quot; |
| DAILY | &quot;daily&quot; |
| WEEKLY | &quot;weekly&quot; |
| EVERYOTHERWEEK | &quot;everyOtherWeek&quot; |
| TWICEAMONTH | &quot;twiceAMonth&quot; |
| EVERY4WEEKS | &quot;every4Weeks&quot; |
| MONTHLY | &quot;monthly&quot; |
| EVERYOTHERMONTH | &quot;everyOtherMonth&quot; |
| EVERY3MONTHS | &quot;every3Months&quot; |
| EVERY4MONTHS | &quot;every4Months&quot; |
| TWICEAYEAR | &quot;twiceAYear&quot; |
| YEARLY | &quot;yearly&quot; |
| EVERYOTHERYEAR | &quot;everyOtherYear&quot; |



## Enum: FlagColorEnum

| Name | Value |
|---- | -----|
| RED | &quot;red&quot; |
| ORANGE | &quot;orange&quot; |
| YELLOW | &quot;yellow&quot; |
| GREEN | &quot;green&quot; |
| BLUE | &quot;blue&quot; |
| PURPLE | &quot;purple&quot; |



