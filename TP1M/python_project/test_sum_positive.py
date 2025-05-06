import pytest
from sum_positive import sum_positive

def test_sum_positive():
    assert sum_positive([1, 2, 3]) == 6
    assert sum_positive([]) == 0
    with pytest.raises(ValueError):
        sum_positive([1, -2, 3])
