# Array Pairs

## Problem Statement
Given an array of integers, find all pairs such 
that the sum of indicies matches the sum of values.

We are looking for combinations of i and j where
`i + j = a[i] + a[j]` 

Note that we can have many pairs which sum to a certain value,
and many vales could have pairs. Therefore our solution
will be a list of list of pairs.


## Example

Given:    [1 4 5 9]
Solution: ?

## Hint 1
Use basic algebra

## Hint 2
```
   i + j = a[i] + a[j]
       i = a[i] + a[j] - j  # Subtract j from both sides
i - a[i] = a[j] - j         # Subtract a[i] from both sides
i - a[i] = -(j - a[j])      # Make it easy to operate on  
```


## Hint 3
Create temp array of index minus value:
```
index: [ 0  1  2  3] 
value: [ 1  4  5  9]
diff:  [ 1 -3  3  6]
```
Then find pairs of n and -n.

# Solution

### Step 1 
Create array of integers called `diffs`.
Populate it with with index - values. 

`diffs[i] = i - a[i]`

This takes O(n) time and O(n) memory.

### Step 2
Create lookup table called `lookup`. 
Map from value to indexes which contain that value.

`Map<Integer, List<Integer>> lookup = new HashMap<>`

## Step 3
Iterate of the keys of the lookup table.
For each positive number `k`, seek if the lookup table contains
corresponding `-k`. If so, add all permutations of values.

Given: 
```
{
  2: [1, 2],
 -2: [3, 4]
}
```

We would have 4 permutations:
 
`[ [1, 3], [1, 4], [2, 3], [2, 4] ]`

 