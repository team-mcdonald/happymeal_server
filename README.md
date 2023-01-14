# happymeal_server
제8회 하이톤 서버 레포입니다

### application.yml
```yaml
port: 8080

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/happymeal?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
    username: {username}
    password: {password}
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
      show_sql: true
      format_sql: true

logging.level:
  org.springframework.boot.autoconfigure: ERROR

app:
  jwt:
    secret:
      access: {access}
      refresh: {refresh}
```