# xeQA_Challenge

**The three tests must be placed into the xeQAChallenge-master\src\test\java\gr\xe\selenium\qaChallenge from the xe-gr/xeQAChallenge git repository that was given as example.


Test One:
Opening WebDriver,clicking the property tab and then clicking the search button. After this I click the the first search result clicking the property-ad-url.

Test-Two:
First maximize the window. Select the property tab and after that select from dropdown menu the buy option from property-transaction-class and the residence option from property-type-class. Click search button.
When search results are ready, select the price filter,set the minimum price value and hit enter. Click again the price filter to close it.
Wait until the first search result to be clickable and get the price of the property.Split the string in order to cut the euro symbol from the price, replace the "." with "" and finally turn string into int.Check if the price of the search result is within the limits we set and print a message.

SelectLandForSaleApplyPlotFilterSaveSearch:
In visitXeSelectLandForSaleFromCategoriesPerformSearch() close the cookies banner because obstructs our test. We select the land for sale from the categories list below search and the hit the search button.

In expandFiltersApplyPlot() select to expand the filter,check the plot value and hit the submit button.

If connection is needed,the connect button must be clicked manually (saw that in the code there wasnt a call for this so I didnt change that)

All the other classes are the same.

