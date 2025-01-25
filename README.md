# Lab: Python Development with VS Code

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
   - Open the integrated terminal (`Ctrl+` or `Cmd+`).
   - Run the following command:
     ```bash
     python -m venv venv
     ```
   - Activate the virtual environment:
     - **Windows:**
       ```bash
       .\venv\Scripts\activate
       ```
     - **Mac/Linux:**
       ```bash
       source venv/bin/activate
       ```

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

---

## Expected Deliverables

1. A functional Python program (`main.py`) with a `greet` function.
2. Debugging results with breakpoints.
3. A passing test suite using `pytest`.

---

## Wrap-Up

- Discuss common errors encountered during the lab and their solutions.
- Explore additional features in VS Code, such as linting with Pylint or auto-formatting with Black.

---

## Notes

For further details or troubleshooting, refer to the [VS Code Python documentation](https://code.visualstudio.com/docs/languages/python).

