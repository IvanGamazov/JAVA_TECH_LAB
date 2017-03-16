# JAVA_TECH_LAB

Данный проект представляет собой связку
Java-демон  -   LogStash    -   ElasticSearch   -   KIBANA(? или/и свое окно)

https://www.elastic.co/downloads/logstash  
https://www.elastic.co/downloads/elasticsearch
https://www.elastic.co/downloads/kibana

Java-программа собирает логи(Процессор, память и тд.) и отправляет их в ELK-стек.

Для добавления новых логов необходимо:
1) Cоздать класс по аналогии с ProcessorLogger и добавить в класс Solution.
2) Создать новый конфиг Logstash по аналогии с processor.conf
3) В Kibana создать новую вьюху.

