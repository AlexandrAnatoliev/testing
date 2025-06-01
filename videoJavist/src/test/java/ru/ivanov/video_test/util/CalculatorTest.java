/*
 * Тесты принято писать в папке
 * test/
 * java/
 * Стараются придерживаться той же иерархии папок, что и в main/
 * тестируемый класс: main/java/ru/ivanov/video_test/util/Calculator.java
 * =>
 * тест-класс: test/java/ru/ivanov/video_test/util/CalculatorTest.java
 * Тест-классы называют так же как и классы, которые собираются тестировать
 * добавляя в конец слово Test:
 * Calculator.java -> CalculatorTest.java
 */
package ru.ivanov.video_test.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

// public class CalculatorTest { - в junit5 ключевое слово public не обязательно
class CalculatorTest {
  /*
   * именование метода:
   * testSum - пишем в начале слово test
   * sum - можно не писать, но наименование тестируемого метода пишется
   * обязательно!
   * метод_условие_желаемыйРезультат - полное наименование метода
   */

  // Чтобы не создавать объект calculator каждый раз заново
  private Calculator calculator;

  // этот метод будет выполнен перед каждым тестом
  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test // любой тестовый метод помечается аннотацией @Test - для junit
  void sum() {
    // Calculator calculator = new Calculator();
    int sum = calculator.sum(10, 15);
    // сравниваем фактическое возвращаемое значение с ожидаемым
    Assertions.assertEquals(25, sum);
  }

  // 2 сценария тестирования: на четность и нечетность
  // именование метода: метод_условие
  @Test
  void evenOrOdd_evenNumber() {
    // Calculator calculator = new Calculator();
    boolean even = calculator.evenOrOdd(10);
    // тест пройдет если even == true
    Assertions.assertTrue(even);
  }

  @Test
  void evenOrOdd_oddNumber() {
    // Calculator calculator = new Calculator();
    boolean odd = calculator.evenOrOdd(15);
    // тест пройдет если odd == false
    Assertions.assertFalse(odd);
  }

  @Test
  void divide_byZero() {
     // calculator.divide(10, 0); этот тест выбросит исключения, т.к. происходит деление на ноль
    // нужное исключение, метод который это исключение бросает
    Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
  }
}
