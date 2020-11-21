from unittest import TestCase
import solution as s

class TestSolution(TestCase):

    GIVEN_1 = [1, 5, 2, 4, 3]
    DIFFS_1 = [-1, -4, 0, -1, 1]
    LOOKUP_1 = {-1: [0, 3], -4: [1], 0: [2], 1: [4]}
    SOLUTION_1 = [[(4, 0), (4, 3)]]

    def test_diffs_terse(self):
        expected = TestSolution.DIFFS_1
        actual = s.make_diffs_terse(TestSolution.GIVEN_1)
        self.assertEqual(expected, actual)

    def test_diffs_readable(self):
        expected = TestSolution.DIFFS_1
        actual = s.make_diffs_readable(TestSolution.GIVEN_1)
        self.assertEqual(expected, actual)

    def test_lookups(self):
        expected = TestSolution.LOOKUP_1
        actual = s.make_lookup(TestSolution.DIFFS_1)
        self.assertEqual(expected, actual)

    def test_permutations(self):
        expected = [(1,3), (1,4), (2,3), (2,4)]
        actual = s.make_permutations([1,2], [3,4])
        self.assertEqual(expected, actual)

    def test_solution(self):
        expected = TestSolution.SOLUTION_1
        actual = s.solve(TestSolution.GIVEN_1)
        self.assertEqual(expected, actual)

    def test_solution_2(self):
        expected = [
            [(4, 2), (4, 3)],
            [(12, 1), (15, 1), (21, 1)],
            [(13, 0), (16, 0), (18, 0), (19, 0), (20, 0), (22, 0), (23, 0)]
        ]
        actual = s.solve([11, 10, 3, 4, 3, 2, 1, 4, 5, 4, 5, 6, 3, 2, 1, 6, 5, 7, 7, 8, 9, 12, 11, 12, 12, 1, 1, 1])
        self.assertEqual(expected, actual)