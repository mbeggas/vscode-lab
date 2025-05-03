# **Lab 02: Building Java Applications Using Gradle**

## **Objectives**
- Understand the basics of Gradle and its role in Java project builds.
- Learn how to set up a Java project with Gradle.
- Configure dependencies and build automation tasks.
- Compile, test, and package a Java application using Gradle.

## **Steps**

### **Step 1: Setting Up Gradle and Java**
- Install Gradle and Java (if not already installed).
- Verify installation by running:
  ```sh
  gradle -v
  java -version
  ```
- Create a new Gradle project:
  ```sh
  gradle init --type java-application
  ```

### **Step 2: Understanding the Project Structure**
- The default folder structure created by Gradle:
  ```
  my-gradle-app/
  ├── build.gradle
  ├── settings.gradle
  ├── src/
  │   ├── main/java/com/example/App.java
  │   └── test/java/com/example/AppTest.java
  ├── gradlew (Linux/macOS)
  ├── gradlew.bat (Windows)
  ├── gradle/
  ```

### **Step 3: Configuring Dependencies**
- Open `build.gradle` and add dependencies:
```gradle
  dependencies {
      implementation 'org.apache.commons:commons-lang3:3.12.0'
       testImplementation 'org.junit.jupiter:junit-jupiter:5.7.1'
  }
```
- Run:
```sh
  gradle dependencies
```

### **Step 4: Compiling and Running the Application**
- Modify `src/main/java/App.java`:
```java
public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        int sum = calculator.add(10, 5);
        int product = calculator.multiply(10, 5);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}
```
Create a new file `src/main/java/Calculator.java`:
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
```
Create a new file `src/main/java/Calculator.java`:
- Compile and run:
  
```sh
  gradle build
  gradle run
```

### **Step 5: Writing and Running Tests**
- Modify `src/test/java/CalculatorTest.java`:
  ```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(0, calculator.multiply(0, 5));
    }
}

- Run tests:

```sh
  gradle test
```

### **Step 6: Packaging the Application**
- Build a JAR file:
  ```sh
  gradle jar
  ```
- Run the JAR:
  ```sh
  java -jar build/libs/my-gradle-app.jar
  ```

## **TODO PART (For Students)**
- Modify the `Calculator` class to include a `subtract` and `divide` method.
- Add corresponding test cases in `CalculatorTest.java`.
- Explore how Gradle can run a specific test case instead of the entire test suite.
- Add a method that reverses a string using `StringUtils` from the package `org.apache.commons:commons-lang3` and test it.
