Implementation of Genetic Algorithm connected with Knapsack problem.

Project includes item list as csv files with weight and score.
At start we are using Loader, which let us to save items to an ArrayList.
Later we are creating individuals (Solutions). All of these has backpack (tab[] int)
and scores and weights. If weight of backpack is more than capacity, score is replace
with 0 or second method main_score/10. Moreover there are implemented functions:
-Tournament()
	Select two solutions from population and return better.
-Tournament2()
	Select specific number of solutions and return better of these.
-Cross()
	Sets crossing point from backpack index and cross first part of solution1 backpack
	with solution2 backpack and do the same operation in next indexes of solution2 backpack
	and solution1 backpack
-Mutate()
	Go with for loop on backpack indexes and each times we use random to set probability of mutation.
	If probability is higher than our specyfic value, our gene(backpack value at index) is change from 1->0/0->1
-Mutate2()
	Go with for loop on backpack indexes and one time we use random to set probability of mutation before for loop.
	If probability is higher than our all values, our genes(backpack value at index) is change from 1->0/0->1
 	