# JAVA_TECH_LAB

Данный проект представляет собой связку
Java-демон  -   LogStash    -   ElasticSearch   -   KIBANA(? или/и свое окно)

https://www.elastic.co/downloads/logstash  
https://www.elastic.co/downloads/elasticsearch  
https://www.elastic.co/downloads/kibana

Java-программа собирает логи(Процессор, память и тд.) и отправляет их в ELK-стек.

Для запуска необходимо:  
Установить Java 8 и задать JAVA_HOME:  
http://www.oracle.com/technetwork/java/javase/downloads/2133151  
http://stackoverflow.com/questions/2619584/how-to-set-java-home-on-windows-7  
  
1) Скачать все файлы по всем ссылкам  
2) Через командую строку запустить elastic -> kibana -> logstash командами вида:  
elastic:      elasticsearch    
kibana :      kibana  
logstash :    logstash logstash -f configName  
где имя конфига это local.conf для теста на локальном компе, а server.conf для работы с удаленным сервером.
(в момент вызова команд вы находитесь в bin/)

3) Kibana доступна по адресу http://localhost:5601  
Далее программу можно запускать из IDE или с помощью JAR-файла.
Если запускать из IDE:  
4) В Intellij idea выставить run-> edit configurations -> program agruments -> localhost 4445  
5) Start  
Если Jar:  
Jar файл создается в IDE с помощью команды:
mvn clean compile assembly:single
Команда запуска Jar в консоли:
java -jar JATA-TECH-1-jar-with-dependencies.jar localhost 4445
Оставить программу можно нажав Ctrl+C
  
После запуска, в окне командной строки с logstash'eм появятся загруженные в цикле логи.  
Посмотреть их можно в kiban'e  
После этого Java-прогу можно вырубить, чтобы не засорять логами память  

