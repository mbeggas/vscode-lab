def sum_positive(numbers):
    if not numbers:
        return 0
    if min(numbers) < 0:
        raise ValueError("Negative numbers are not allowed.")  
    return sum(numbers)
