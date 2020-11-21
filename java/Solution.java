import java.util.*;

public class Solution {


    public static List<List<List<Integer>>> solve(int[] given) {

        // Step 1: compute diffs
        int[] diffs = new int[given.length];
        for (int i=0; i<given.length; i++) {
            diffs[i] = i - given[i];
        }

        // Step 2: create lookup
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        for (int i=0; i<diffs.length; i++) {
            int key = diffs[i];
            if (! lookup.containsKey(key)) {
                lookup.put(key, new ArrayList<Integer>());
            }
            lookup.get(key).add(i);
        }

        // Step 3: Find pairs and permute indices
        List<List<List<Integer>>> result = new ArrayList<>();
        for (int key: lookup.keySet()) {
            if (key > 0 && lookup.containsKey(-key)) {
                result.add(
                        Solution.create_permutations(
                                lookup.get(key),
                                lookup.get(-key)
                        )
                );
            }
        }
        return result;
    }

    private static List<List<Integer>> create_permutations(List<Integer> list_a, List<Integer> list_b) {
        List<List<Integer>> result = new ArrayList<>();
        for (int a: list_a) {
            for (int b: list_b) {
                result.add(Arrays.asList(a, b));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] given1 = new int[]{1, 5, 2, 4, 3};
        System.out.println("Given: " + Arrays.toString(given1));
        System.out.println("Result: " + Solution.solve(given1));

        int[] given2 = new int[]{11, 10, 3, 4, 3, 2, 1, 4, 5, 4, 5, 6, 3, 2, 1, 6, 5, 7, 7, 8, 9, 12, 11, 12, 12, 1, 1, 1};
        System.out.println("Given: " + Arrays.toString(given2));
        System.out.println("Result: " + Solution.solve(given2));
    }
}
