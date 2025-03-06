# redis
Spring Boot + Redis

JDK17 + Maven + Spring Boot 3.4.3
https://start.spring.io/

D:\Software\Redis-x64-5.0.9
# Windows环境启动
1.启动server，执行命令：redis-server   
2.启动client，执行命令：redis-cli

redis服务会定时把数据保存到dump.rdb文件中。下次启动redis server，会自动加载dump.rdb文件。
