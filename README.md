#Настройка окружения
1. Установка Zookeper и Kafka
2. Установка СУБД PostgreSQL, версия 11+
3. Установка Apache Maven

#Запуск проекта
1. Запустить  zookeper и kafka
2. Создать БД message в PostgreSQL
3. Перейти в корень проекта
4. $ mvn install
5. cd first && mvn spring-boot:run
5. cd second && mvn spring-boot:run
5. cd third && mvn spring-boot:run
5. cd forth && mvn spring-boot:run

#Тестирование проекта
1. **Создание message**  
curl -d '{"userName":"userName", "message":"message"}' -H "Content-Type: application/json" -X POST http://localhost:8080/message

2. **Получение списка всех сообщений**  
curl http://localhost:8085/message?from=1598910613792&to=1598910613792