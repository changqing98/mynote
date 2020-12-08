from unittest import TestCase

from . import SelectionSort


class Test(TestCase):
	def test_sort(self):
		array = [1, 5, 8, 3, 2, 9]
		SelectionSort.sort(array)
		self.assertEqual([1, 2, 3, 5, 8, 9], array)
