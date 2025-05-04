def sum_positive_numbers(numbers):
   
    if not isinstance(numbers, list):
        raise TypeError("Input must be a list.")
    
    total = 0
    for num in numbers:
        if num < 0:
            raise ValueError(f"Negative number found: {num}")
        total += num
    return total

def test_sum_positive_numbers():
    
    assert sum_positive_numbers([1, 2, 3, 4, 5]) == 15
    

    assert sum_positive_numbers([]) == 0
    
    assert sum_positive_numbers([0, 1, 2]) == 3
    
    try:
        sum_positive_numbers([1, -2, 3])
    except ValueError as e:
        assert str(e) == "Negative number found: -2"
    
    try:
        sum_positive_numbers("123")
    except TypeError as e:
        assert str(e) == "Input must be a list."
    
    print("All tests passed!")

# تشغيل الاختبارات
test_sum_positive_numbers()
