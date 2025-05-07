import pytest
from sum_positive import sum_positive_numbers

def test_sum_positive_numbers():
    # Test empty list
    assert sum_positive_numbers([]) == 0
    
    # Test list with only positive numbers
    assert sum_positive_numbers([1, 2, 3]) == 6
    
    # Test list with zero
    assert sum_positive_numbers([0, 1, 2]) == 3
    
    # Test with negative number (should raise exception)
    with pytest.raises(ValueError):
        sum_positive_numbers([1, -2, 3]) 