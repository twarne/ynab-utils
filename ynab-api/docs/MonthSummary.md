

# MonthSummary


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**month** | **LocalDate** |  |  |
|**note** | **String** |  |  [optional] |
|**income** | **Long** | The total amount of transactions categorized to &#39;Inflow: Ready to Assign&#39; in the month |  |
|**budgeted** | **Long** | The total amount budgeted in the month |  |
|**activity** | **Long** | The total amount of transactions in the month, excluding those categorized to &#39;Inflow: Ready to Assign&#39; |  |
|**toBeBudgeted** | **Long** | The available amount for &#39;Ready to Assign&#39; |  |
|**ageOfMoney** | **Integer** | The Age of Money as of the month |  [optional] |
|**deleted** | **Boolean** | Whether or not the month has been deleted.  Deleted months will only be included in delta requests. |  |



