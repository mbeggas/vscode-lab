def sum_positive(numbers):
    for n in numbers:
        if n < 0:
            raise ValueError("Negative number found!")
    return sum(numbers)
