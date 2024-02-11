# RabbitMQ-producer-consumer
Проект с рективными сервисами rabbitmq-producer и rabbitmq-consumer для записи и получения сообщений из RabbitMQ.

Для запуска двух контейнеров *rabbitmq-producer* и *rabbitmq-consumer*
используйте команду `docker-compose up`.

Docker Compose запустит сервисы *rabbitmq-producer* и *rabbitmq-consumer*, описанные в нем, на портах
`8081` и `8082` соответственно.

Для конфигурации *host*, *port*, *username*, *password* используйте переменные окружения `RABBITMQ_HOST`,
`RABBITMQ_PORT`, `RABBITMQ_USERNAME` и `RABBITMQ_PASSWORD` 
(По умолчанию сервисы настроены на локальный RabbitMQ, запущеннный в контейнере,
адрес которого `host.docker.internal:5672` под стандартным пользователем `guset:guest`).

С инструкцией как запустить RabbitMQ локально в контейнере при помощи Docker
можно ознакомиться по ссылке [rabbitmq-docker](https://hub.docker.com/_/rabbitmq).

Каждый сервис логирует сообщения в консоль при отправке или получении сообщений из RabbitMQ.
По умолчанию *rabbitmq-producer* создает обменник (exchange) `rotiez-exchange` и очередь (queue) `rotiez-queue`, 
а также связывает их при помощи ключа маршрутизации (routing key) `rotiez-routingKey`.
Сервис *rabbitmq-consumer* подписывается на очередь `rotiez-queue`.
> Для изменения стандартных настроек используйте переменные окружения, описанные в конце файла.

Отправка сообщений в топик происходит через сервис *rabbitmq-producer* с помощью _REST API_,
c документацией для каждого сервиса можно ознакомиться по
эндпоинту `/swagger-ui.html`.

---

Для конфигурации сервисов используйте следующие переменные окружения:
* `RABBITMQ_DEFAULT_QUEUE` - стандратная очередь
* `RABBITMQ_DEFAULT_EXCHANGE` - стандартный обменник
* `RABBITMQ_DEFAULT_ROUTING_KEY` - стандартный ключ маршрутизации
* `RABBITMQ_HOST` - хост RabbitMQ
* `RABBITMQ_PORT` - порт RabbitMQ
* `RABBITMQ_USERNAME` - имя пользователя для подключения к RabbitMQ
* `RABBITMQ_PASSWORD` - пароль пользователя для подключения к RabbitMQ