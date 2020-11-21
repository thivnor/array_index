import collections


def solve(given):
    diffs = make_diffs_terse(given) # Step 1 from readme.md
    lookup = make_lookup(diffs) # Step 2
    return make_pairs(lookup) # Step 3

def make_diffs_terse(given: list) -> list:
    return [i-given[i] for i in range(len(given))]

def make_diffs_readable(given: list) -> list:
    # This does the same thing make_diffs_terse but is more readable.
    result = []
    for index, value in enumerate(given):
        result.append(index-value)
    return result

def make_lookup(diffs: list) -> dict:
    result = collections.defaultdict(list)
    for index, value in enumerate(diffs):
        result[value].append(index)
    return result

def make_pairs(lookup: dict) -> list:
    result = []
    for key in lookup.keys():
        if key > 0 and -key in lookup:
            result.append(make_permutations(lookup.get(key), lookup.get(-key)))
    return result

def make_permutations(list_a: list, list_b: list) -> list:
    result = []
    for a in list_a:
        for b in list_b:
            result.append((a, b))
    return result

