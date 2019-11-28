### Установка Maven проекта и запуск API Test:
  
1.Открываем среду разработки Intellij Idea

2.Скачиваем и устанавливаем java -jdk(Java SE Development)

3.Создаём проект в IntelliJ Idea

4.Выбираем Maven

5.Нажимаем Next

6.Подклчаем библиотеки, прописываем dependency в pom.xml // это позволит подкачивать всегда новые библиотеки для теста

-allure //получение отчетов
```
<dependencies>
        <dependency>
            <groupId>io.qameta.allure</groupId> //получение отчетов
            <artifactId>allure-testng</artifactId>
            <version>2.13.0</version>
        </dependency>
        ```
- rest-assured// библиотека, которая помогает отправлять запросы и получать ответы, получать статус код
 
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.1.2</version>
            <scope>test</scope>
        </dependency>
        ```
- Hamcrest – это библиотека matcher-ов, которая используется в паре с JUnit или другим аналогичным фреймворком для тестирования.Matcher – это такое выражение, тестирующее на совпадение с определенным условием.    
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-library</artifactId>
            <version>1.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-core</artifactId>
            <version>2.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
        </dependency>
        </dependencies>
    ```
 7.Добавляем properties
   <properties>
          <aspectj.version>1.8.10</aspectj.version>
          <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      </properties>
8. Добавляем plugins
   <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
 9. Начинаем писать API тест                 
    