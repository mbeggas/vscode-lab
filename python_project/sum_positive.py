def sum_positive(numbers):
    total = 0
    for num in numbers:
        if num < 0:
            raise ValueError("f Found a negative number: {num}")
        total += num
    return total
