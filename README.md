###############################################################################################
#############################           financialBankAPI            ###########################

Приложение было разработано в Редакторе Eclipse.
- Запуск приложения :
  - Это приложение могло бы запускаться с :
    * IDE (затмение);
    * Из терминала, выполнив следующие команды :
      - - Spring Initializr использует оболочку maven, это позволяет выполнить эту команду :
        $ ./mvnw чистая весенняя загрузка:запуск
      - Также можно использовать установленную версию maven, выполнив приведенную ниже команду :
        $ mvn чистая весенняя загрузка:запуск
      - После запуска приложения его можно будет опросить.
        $ curl-v локальный хост:8080/bank_api
        
        
        
Запуск этого приложения не был завершен до конца, потому что мне не удалось заставить "liquibase" работать с базой данных PostgreSQL.