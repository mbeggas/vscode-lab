from factorial_module import factorial

def test_factorial():
    assert factorial(0) == 1
    assert factorial(1) == 1
    assert factorial(5) == 120

test_factorial()
print("All tests passed!")
