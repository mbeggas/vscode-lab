import pytest
from sum_positive import sum_positive

def test_sum_positive_valid():
    assert sum_positive([1, 2, 3]) == 6
    assert sum_positive([0, 5, 10]) == 15

def test_sum_positive_negative():
    with pytest.raises(ValueError):
        sum_positive([1, -2, 3])
