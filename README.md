# JAVA_TECH_LAB

Данный проект представляет собой связку
Java-демон  -   LogStash    -   ElasticSearch   -   KIBANA(? или/и свое окно)

https://www.elastic.co/downloads/logstash  
https://www.elastic.co/downloads/elasticsearch  
https://www.elastic.co/downloads/kibana

Java-программа собирает логи(Процессор, память и тд.) и отправляет их в ELK-стек.

Для запуска необходимо  
1) Скачать все файлы по всем ссылкам  
2) Через командую строку запустить elastic -> kibana -> logstash командами вида:  
elastic:      elasticsearch    
kibana :      kibana  
logstash :    logstash -f pathToConfigFolder/*   или logstash -f configName  
(в момент вызова команд вы находитесь в bin/)  
3) Kibana доступна по адресу http://localhost:5601  
4) В Intellij idea выставить run-> edit configurations -> program agruments -> 4445
5) Запустить Java-прогу из Intellij Idea (пока так, потом запилю джарник).

После запуска, в окне командной строки с logstash'eм появятся загруженные в цикле логи.  
Посмотреть их можно в kiban'e  
После этого Java-прогу можно вырубить, чтобы не засорять логами память  

