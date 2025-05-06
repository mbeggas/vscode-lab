def greet(name):
    return f"Hello, {name}!"

if __name__ == "__main__":
  print(greet("World"))
from main import greet

def test_greet():
    assert greet("Alice") == "Hello, Alice!"
    assert greet("Bob") == "Hello, Bob!"