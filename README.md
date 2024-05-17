# Text Analyzer

---

## Overview

The TextAnalyzer program is a Java program designed to analyze text input and provide various functionalities such as counting words, characters, and lines in a text, as well as calculating the frequency of each word, counting words ending with a specific letter, counting words of a certain length, finding the longest word, finding the most common word, finding palindromes, finding the shortest word, determining if the text is a pangram and much more. This README.md file provides comprehensive information about the project, including its purpose, structure, setup instructions, and functionalities.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Project Structure](#project-structure)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Contributing](#contributing)
6. [Contact Information](#contact-information)

---

## 1. Introduction

The TextAnalyzer program is a collaborative effort of six individuals who worked together to develop a Java application that provides various text analysis functionalities. The program aims to offer a convenient tool for analyzing text input, making it easier for users to perform common text analysis tasks efficiently.

---

## 2. Project Structure

The project structure is organized as follows:

- **Source Code**:
  - [`TextAnalyzer.java`](./TextAnalyzer.java): The main Java class containing methods to perform text analysis tasks.
  - [`TextAnalyzerCLI.java`](./TextAnalyzerCLI.java): Command-line interface for the TextAnalyzer program.
- **Test Files**:
  - [`TextAnalyzerTest.java`](./TextAnalyzerTest.java): JUnit test class containing test cases for the TextAnalyzer class.
- **JAR Files**:
  - [`junit-4.12.jar`](./JAR%20Files/junit-4.12.jar): JUnit library for running test cases.
  - [`hamcrest-core-1.3.jar`](./JAR%20Files/hamcrest-core-1.3.jar): Hamcrest core library for testing.

---


## 3. Installation

Follow the steps below to set up the TextAnalyzer program on your local machine:

1. Clone the repository:

   ```bash
   git clone https://github.com/Eduniyaa/text-analyzer.git
   ```

2. Navigate to the project directory:

   ```bash
   cd text-analyzer
   ```

### Windows

3. Compile the Java files:

   ```bash
   javac TextAnalyzer.java TextAnalyzerCLI.java
   ```

4. (Optional) Compile the test files if you want to run the tests:

   ```bash
   javac -cp ".;JAR Files/*" TextAnalyzer.java TextAnalyzerTest.java
   ```

### Linux

3. Compile the Java files:

   ```bash
   javac TextAnalyzer.java TextAnalyzerCLI.java
   ```

4. (Optional) Compile the test files if you want to run the tests:

   ```bash
   javac -cp ".:JAR Files/*" TextAnalyzer.java TextAnalyzerTest.java
   ```

---

## 4. Usage

To use the TextAnalyzer program, you can either integrate it into your Java project, use the CLI or run the provided test cases.

### Integration:

1. Import the `TextAnalyzer.java` file into your Java project.
2. Create an instance of the `TextAnalyzer` class.
3. Call the appropriate methods to perform text analysis tasks.

### Running the CLI

```bash
java TextAnalyzerCLI
```

### Running Tests

To run the JUnit tests, use the following command:

#### Windows

```bash
java -cp ".;JAR Files/*" org.junit.runner.JUnitCore TextAnalyzerTest
```

#### Linux

```bash
java -cp ".:JAR Files/*" org.junit.runner.JUnitCore TextAnalyzerTest
```

This will execute all the test cases defined in [`TextAnalyzerTest.java`](./TextAanlyzerTest.java) and display the results in the console.

---

## 5. Contributing

If you want to add more functionalities or improve on the already existing ones, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Implement your changes.
4. Test thoroughly.
5. Create a pull request.

---

## 6. Contact Information

For any inquiries or feedback, please contact the members of the development team:

- **Team Members**:
  - **Ahsan Mohammed**
    - Email: @gmail.com
    - GitHub: [](https://github.com/)
  - **Daniel Kindeya**
    - Email: danielkindeya19@gmail.com
    - GitHub: [Danielkindeya](https://github.com/Danielkindeya)
  - **Eden Werke**
    - Email: @gmail.com
    - GitHub: [edenWerke](https://github.com/edenWerke)
  - **Eduniya Ambachew**
    - Email: @gmail.com
    - GitHub: [Eduniyaa](https://github.com/Eduniyaa)
  - **Filimon Haftom**
    - Email: filimon.haftomh@haftomhgmail.com
    - GitHub: [phila-hh](https://github.com/phila-hh)
  - **Nardos Zemariam**
    - Email: nardoszemariatesfaym@gmail.com
    - GitHub: [nardoszemariamtesfay](https://github.com/nardoszemariamtesfay)

Feel free to reach out for assistance, feedback, or collaboration!
