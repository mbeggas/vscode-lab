def sum_positive_numbers(numbers):
    if not numbers:
        return 0
    
    for num in numbers:
        if num < 0:
            raise ValueError(f"Negative number found: {num}")
    
    return sum(num for num in numbers if num > 0) 