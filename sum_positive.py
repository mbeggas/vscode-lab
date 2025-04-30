def sum_positive(numbers):
    for num in numbers:
        if num < 0:
            raise ValueError("Negative numbers not allowed")
    return sum(numbers)
