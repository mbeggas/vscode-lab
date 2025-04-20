from sumPositiveNumbers import sumPositiveNumbers
def test_sumPositiveNumbers():
    assert sumPositiveNumbers([1, 2, 3]) == 6

    assert sumPositiveNumbers([]) == 0

    assert sumPositiveNumbers([0, 0, 0]) == 0

    assert sumPositiveNumbers([1000, 5000, 300]) == 6300

    assert sumPositiveNumbers([10]) == 10

    assert sumPositiveNumbers([1.5, 2.5]) == 4.0

    try:
        sumPositiveNumbers([1, -2, 3])
    except ValueError as e:
        print("Passed negative number test:", e)
    else:
        print("Failed: Did not raise exception for negative number")

    
    try:
        sumPositiveNumbers("123")
    except TypeError as e:
        print("Passed non-list input test:", e)
    else:
        print("Failed: Did not raise exception for non-list input")

test_sumPositiveNumbers()
print("All tests passed (or caught expected exceptions)!")
