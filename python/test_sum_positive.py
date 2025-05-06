from sum_positive import sum_positive
import pytest

def test_all_positive():
    assert sum_positive([1, 2, 3]) == 6

def test_with_zero():
    assert sum_positive([0, 4, 5]) == 9

def test_empty_list():
    assert sum_positive([]) == 0

def test_with_negative():
    with pytest.raises(ValueError):
        sum_positive([1, -2, 3])

def test_all_zeros():
    assert sum_positive([0, 0, 0]) == 0

def test_single_negative():
    with pytest.raises(ValueError):
        sum_positive([-1])
