# Social Network
==================================================
Для завантаження необхідно:
1. Java 8
2. MySQL база даних
3. Tomcat
4. Git
5. Maven

Завантаження:
```bash
 git clone https://github.com/LillyLyubarskaya/SocialNet
```


У файлі конфігурації Hibarnate необхідно сконфігурувати під свою базу (url, user, password).

```bash
https://github.com/LillyLyubarskaya/SocialNet/blob/master/SocialNetwork/src/main/resources/hibernate.cfg.xml
```

==================================================


Потім, необхідно встановити плагін customer-maven-plugin у свій репозиторій
Для цього необхідно перейти в директорію customer-maven-plugin  і виконати наступну команду:

```bash
mvn install
```

Потім необхідно скомпілювати і розвернути на локальному Tomcat цей додаток

```bash
cd ..
mvn install
```

Для запуску тестів необхідно виконати команду:

```bash
mvn test
```

