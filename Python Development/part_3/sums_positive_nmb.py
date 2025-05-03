def sum_positive_numbers(numbers):
    
    if any(n < 0 for n in numbers):
        raise ValueError("القائمة تحتوي على أعداد سالبة!")

    return sum(n for n in numbers if n > 0)
