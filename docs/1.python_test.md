# Lab 01: Python Development with VS Code

# Part 01

## Objective
Learn how to set up a Python project in VS Code, including configuring a virtual environment, writing and debugging code, and adding tests.

---

## Steps

### 1. Set Up the Project

1. **Create a Python folder:**
   - Open VS Code and go to `File > Open Folder`.
   - Create a folder named `python_project` and open it in VS Code.

2. **Install the Python extension:**
   - Open the Extensions view (`Ctrl+Shift+X` or `Cmd+Shift+X`).
   - Search for `Python` (published by Microsoft) and install it.

3. **Create a Python virtual environment:**
   - Open the integrated terminal (`Ctrl+ù`).
   - Run the following command:
     ```bash
     python -m venv venv
     ```
   - Activate the virtual environment:
     - **Windows:**
       ```bash
       .\venv\Scripts\activate
       ```
or use VS Code command to do so

4. **Select the Python interpreter:**
   - Press `Ctrl+Shift+P` to open the Command Palette.
   - Type `Python: Select Interpreter` and choose your virtual environment.

---

### 2. Write and Execute Code

1. **Create a Python file:**
   - Create a file named `main.py` in the folder.

2. **Add a function:**
   - Write the following code:
     ```python
     def greet(name):
         return f"Hello, {name}!"

     if __name__ == "__main__":
         print(greet("World"))
     ```

3. **Run the file:**
   - Right-click anywhere in the editor and select **Run Python File in Terminal**.
   - Verify the output: `Hello, World!`.

---

### 3. Debug the Code

1. **Set up debugging:**
   - Add a breakpoint on the `return` line in the `greet` function.
   - Open the Debug view (`Ctrl+Shift+D` or `Cmd+Shift+D`).
   - Click **Run and Debug**, then select `Python File`.

2. **Step through the code:**
   - Use the Debug toolbar to step into the function, observe variable values, and monitor the program's execution.

---

### 4. Add a Test

1. **Install testing tools:**
   - In the terminal, install `pytest`:
     ```bash
     pip install pytest
     ```

2. **Create a test file:**
   - Create a new file named `test_main.py`.

3. **Write a test for the `greet` function:**
   - Add the following code:
     ```python
     from main import greet

     def test_greet():
         assert greet("Alice") == "Hello, Alice!"
         assert greet("Bob") == "Hello, Bob!"
     ```

4. **Run the test:**
   - Open the terminal and run:
     ```bash
     pytest
     ```
   - Verify all tests pass.

### Now, use VS code tools for testing your python code

# PART 02

## 1. Fixing a Buggy Factorial Function

### Step 1: Write the Function (Buggy Code)

Create a file **`factorial.py`**:

```python
def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n - 1) + 1  
```

- This function should calculate the factorial of n.
- However, there’s a mistake that will cause incorrect results!

### Step 2: Write a Test and Find the Bug

Create a file test_factorial.py:

```python
from factorial import factorial

def test_factorial():
    assert factorial(0) == 1
    assert factorial(1) == 1
    assert factorial(5) == 120  # This will fail
```

- Execute the test
- You will see an AssertionError, meaning the function is incorrect.

### Step 3: Debug and Fix the Function and Test Again to Confirm the Fix

- Modify factorial.py to remove the bug
- Execute the test again, now, all tests should pass!

## 2. Fixing a Buggy Prime Number Function

Create prime.py

```python
def is_prime(n):
    if n < 2:
        return False
    for i in range(2, 2*n): 
        if n % i == 0:
            return False
    return True
```

Create test_prime.py:

```python
from prime import is_prime

def test_is_prime():
    assert is_prime(2) == True
    assert is_prime(3) == True
    assert is_prime(4) == False
    assert is_prime(29) == True
```
**Debug and Fix the Function**

# PART 3

- Write a function that sums positive numbers in a list.
- If negative numbers are present, the function should raise an exception.
- Test for different edge cases.
- Debug and fix errors if the function fails.

