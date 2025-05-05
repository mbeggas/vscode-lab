def sum_positive(numbers):
    total = 0
    for num in numbers:
        if num < 0:
            raise ValueError("Negative number found")
        total += num
    return total
