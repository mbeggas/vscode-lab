import pytest
from sum_positive import sum_positive

def test_empty_list():
    assert sum_positive([]) == 0

def test_all_positive():
    assert sum_positive([1, 2, 3, 4]) == 10

def test_with_zero():
    assert sum_positive([0, 5, 7]) == 12

def test_negative_number():
    with pytest.raises(ValueError):
        sum_positive([1, -2, 3])
