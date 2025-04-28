# Установка junit5, создание и запуск теста

* Скачать **junit5**

`apt install junit5`

*  Для тестирования понадобится два файла: **junit-jupiter-api-5.3.2.jar** и **junit-platform-console-standalone-1.3.2.jar**. Место их установки можно узнать командой:

`dpkg -L junit5`

* Пути будут выглядеть так:

<pre>
/usr/share/java/junit-jupiter-api-5.3.2.jar
/usr/share/java/junit-platform-console-standalone-1.3.2.jar
</pre>

* Структура директорий выглядит так:

<pre>
MyProject/
  src/
    main/
      java/
        Calculator.java
    test/
      java/
        CalculatorTest.java
</pre>

* Скомпилируем исходный код:

<pre>
javac -d out -sourcepath src/main/java src/main/java/Calculator.java
  где:
-d out - указание директории куда будут помещены скомпилированные классы
-sourcepath src/main/java - путь к исходному коду (*.java)
</pre>

* Создается директория **out/** куда попадает скомпилированный класс

<pre>
MyProject/
  src/
    main/
      java/
        Calculator.java
    test/
      java/
        CalculatorTest.java
  out/
    Calculator.class
</pre>

* Компилируем тестовый код

`javac -d out -cp "/usr/share/java/junit-jupiter-api-5.3.2.jar:/usr/share/java/junit-platform-console-standalone-1.3.2.jar:out" -sourcepath src/test/java src/test/java/CalculatorTest.java`

 где:
-d - указание директории куда будут помещены скомпилированные классы;
-cp - места расположения заранее скомпилированных классов, разделяются (**:**) друг от друга, включают в себя **jar**-файлы и директория **out**, где распологаются **class**-файлы;
-sourcepath - путь к исходному коду (*.java)


* Скомпилированный класс появится в **out/**

<pre>
MyProject/
  src/
    main/
      java/
        Calculator.java
    test/
      java/
        CalculatorTest.java
  out/
    Calculator.class
    CalculatorTest.class
</pre>

* Переходим в директорию **out/**
* Запускаем тест 

`java -jar /usr/share/java/junit-platform-console-standalone-1.3.2.jar --classpath . --scan-class-path`
