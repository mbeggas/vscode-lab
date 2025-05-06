def sum_positive(numbers):
    for num in numbers:
        if num < 0:
            raise ValueError("negative value")
    return sum(numbers)
