

# Category


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**categoryGroupId** | **UUID** |  |  |
|**name** | **String** |  |  |
|**hidden** | **Boolean** | Whether or not the category is hidden |  |
|**originalCategoryGroupId** | **UUID** | If category is hidden this is the id of the category group it originally belonged to before it was hidden. |  [optional] |
|**note** | **String** |  |  [optional] |
|**budgeted** | **Long** | Budgeted amount in milliunits format |  |
|**activity** | **Long** | Activity amount in milliunits format |  |
|**balance** | **Long** | Balance in milliunits format |  |
|**goalType** | [**GoalTypeEnum**](#GoalTypeEnum) | The type of goal, if the category has a goal (TB&#x3D;&#39;Target Category Balance&#39;, TBD&#x3D;&#39;Target Category Balance by Date&#39;, MF&#x3D;&#39;Monthly Funding&#39;, NEED&#x3D;&#39;Plan Your Spending&#39;) |  [optional] |
|**goalDay** | **Integer** | The day of the goal |  [optional] |
|**goalCadence** | **Integer** | The goal cadence |  [optional] |
|**goalCadenceFrequency** | **Integer** | The goal cadence frequency |  [optional] |
|**goalCreationMonth** | **LocalDate** | The month a goal was created |  [optional] |
|**goalTarget** | **Long** | The goal target amount in milliunits |  [optional] |
|**goalTargetMonth** | **LocalDate** | The original target month for the goal to be completed.  Only some goal types specify this date. |  [optional] |
|**goalPercentageComplete** | **Integer** | The percentage completion of the goal |  [optional] |
|**goalMonthsToBudget** | **Integer** | The number of months, including the current month, left in the current goal period. |  [optional] |
|**goalUnderFunded** | **Long** | The amount of funding still needed in the current month to stay on track towards completing the goal within the current goal period.  This amount will generally correspond to the &#39;Underfunded&#39; amount in the web and mobile clients except when viewing a category with a Needed for Spending Goal in a future month.  The web and mobile clients will ignore any funding from a prior goal period when viewing category with a Needed for Spending Goal in a future month. |  [optional] |
|**goalOverallFunded** | **Long** | The total amount funded towards the goal within the current goal period. |  [optional] |
|**goalOverallLeft** | **Long** | The amount of funding still needed to complete the goal within the current goal period. |  [optional] |
|**deleted** | **Boolean** | Whether or not the category has been deleted.  Deleted categories will only be included in delta requests. |  |



## Enum: GoalTypeEnum

| Name | Value |
|---- | -----|
| TB | &quot;TB&quot; |
| TBD | &quot;TBD&quot; |
| MF | &quot;MF&quot; |
| NEED | &quot;NEED&quot; |
| DEBT | &quot;DEBT&quot; |



