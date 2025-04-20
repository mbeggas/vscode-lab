def sumPositiveNumbers(numbers):
    if not isinstance(numbers, list):
        raise TypeError("Input must be a list of numbers.")

    total = 0
    for num in numbers:
        if num < 0:
            raise ValueError(f"Negative number found: {num}")
        total += num
    return total
