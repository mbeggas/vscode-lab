from sum_positive import sum_positive
import pytest

def test_sum_positive_valid():
    assert sum_positive([1, 2, 3]) == 6

def test_sum_positive_empty():
    assert sum_positive([]) == 0

def test_sum_positive_negative():
    with pytest.raises(ValueError):
        sum_positive([1, -2, 3])
