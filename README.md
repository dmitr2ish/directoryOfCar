# directoryOfCar
Service directory of cars with the storage of data in database  
  
Используемые технологии:  
  
Java 11  
Maven  
Spring boot 2.3.2.RELEASE  
PostgresSQL 12.3  
Html5\CSS(Bootstrap)\Thymeleaf\JQery\Ajax  
  
Задача:  
  
Необходимо реализовать сервис справочника автомобилей с хранением данных в  
базе или файле.  
  
Описание задачи:  
Минимальная информация по объекту:  
● Номер (регистрационный знак, например АА999А96);  
● Марка;  
● Цвет;  
● Год выпуска;  
  
Описание API:  
Методы:  
● Вывод списка;  
● Добавление автомобиля;  
● Удаление автомобиля;  
● Статистика базы;  
  
Описание запуска приложения:  
  
Настройки приложения:  
Порт приложения: 8080  
Порт базы данных: 5432  
Имя пользователя: postgres  
Пароль пользователя: postgres  
  
Изменить настройки вы можете в файле currencyConverter\src\main\resources\application.properties  
  
ВАЖНО  
Первоначально удостоверитесь, что у вас установлена база данных PostgresSQL 12.3,  
в случае если имя пользователя или пароль отличаются измените их в файле application.properties  
  
Команды выполнять из корневой папки,  
для Windows  
Запуск из командной строки из корневой папки  
mvnw spring-boot:run для Windows  
  
Создание и запуск jar файла  
mvnw clean package  
cd target  
java -jar directoryOfCar-0.0.1-SNAPSHOT.jar  
  
Описание приложения:  
При запуске необходимо перейти по локальному адресу, развертываемого приложения  
(по умолчанию http://localhost:8080/), после чего главную страницу проекта.  
На навигационной панели будет текущая дата, кнопка открывающая описание проекта на текущем языке,  
кнопка получения статистики по базе данных (пока что только получения количество записей в базе данных).  
В центре вы увидите пустую таблицу с двумя вкладками. Вкладка "Таблица машин" и "Добавить машину".  
Чтобы добавить новую машину нажмите на вкладку добаить машину, окно откроется без перезагрузки,  
где вы сможете вбить данные и добавить машину. При клике на таблицу машин, также без перезагрузки  
страницы, машина будет добавлена. В строке добавленной машины, будут кнопка "Редактировать" и "Удалить".  
При нажатии на данные кнопки будут открываться модальные окна, с информацией о машине, после чего  
вы можете кликнуть по кнопке в модальном окне "Редактировать" или "Удалить" соответственно. Далее также  
без перезагрузки информация в таблице изменится, модальное окно автоматически скроется.
  
Приложение на английском языке.  
Планируется добавить:  
● получение новых статистик по базе данных;  
● выбор языка, добавление русской локализации;  
● фильтры поиска по базе данных;  
  
Внимание  
  
Для запуска приложения требуется Java 11 или выше, а также установленная на компьютер PostgresSQL.  

