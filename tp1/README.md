# 1. Compile and run
```sh
gradle build
gradle run
```

# 2. Run all tests
```sh
gradle test
```

# 3. Run specific test
```sh
gradle test --tests "org.example.CalculatorTest.testSubtraction"
```

# 4. Build the Fat JAR
```sh
gradle shadowJar
```

# 4. Build jar and run it
```sh
java -jar app/build/libs/app-all.jar
```
