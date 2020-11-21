# Array Pairs

## Problem Statement
Given an array of integers, find all pairs such 
that the sum of indicies matches the sum of values.

We are looking for combinations of i and j where
`i + j = a[i] + a[j]` 

Note that we can have many pairs which sum to a certain value,
and for any sum there could be many pairs. 
Therefore our solution will be a list of list of pairs.


## Example

Given:    `[1, 5, 2, 4, 3]`

Solution: `[[(4, 0), (4, 3)]]`

## Hint 1
Use simple algebra

## Hint 2
```
i + j = a[i] + a[j]
i = a[i] + a[j] - j  # Subtract j from both sides
i - a[i] = a[j] - j  # Subtract a[i] from both sides
i - a[i] = -(j - a[j])     
```


## Hint 3
Create temp array of index minus value:
```
index: [ 0  1  2  3  4] 
value: [ 1  5  2  4  3]
diff:  [-1 -4  0  1  1] 
```
Then find pairs of n and -n and create 
permutations of their indicies.

This this example we have a single pair: 1 and -1 
The indicies are [3, 4] and [0]. 
Permuting those gives us (3, 0) and (4, 0)


# Solution

### Step 1 
Create array of integers called `diffs`.
Populate it with with index - values. 

`diffs[i] = i - a[i]`


### Step 2
Create lookup table called `lookup`. 
Map from value to indexes which contain that value.

The values in our lookup table are lists of int.

## Step 3
Iterate over the keys of the lookup table.
For each positive number `k`, see if the lookup table contains
corresponding `-k`. If so, add all permutations of their values.

Given lookup table: 
```
{
  1: [1, 2],
 -1: [3, 4]
}
```

We would have 4 permutations:
 
`[(1, 3), (1, 4), (2, 3), (2, 4)]`

 