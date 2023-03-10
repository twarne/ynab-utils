

# CategoryGroupWithCategories


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**name** | **String** |  |  |
|**hidden** | **Boolean** | Whether or not the category group is hidden |  |
|**deleted** | **Boolean** | Whether or not the category group has been deleted.  Deleted category groups will only be included in delta requests. |  |
|**categories** | [**List&lt;Category&gt;**](Category.md) | Category group categories.  Amounts (budgeted, activity, balance, etc.) are specific to the current budget month (UTC). |  |



