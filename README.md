# SpringBoot Demo

[第一个SpringBoot程序](#第一个SpringBoot程序)

## 第一个SpringBoot程序
- 注解
    - @Component -- 把普通pojo实例化到spring容器中，相当于配置文件中的`<bean id="" class=""/>`
    - @Autowired -- 表示被修饰的类需要注入对象,spring会扫描所有被@Autowired标注的类,然后根据 类型 在ioc容器中找到匹配的类注入。
- 配置

## AOP（面向切面）

- AOP是一种编程范式，与语言无关，是一种程序设计思想

- 将==通用==逻辑从==业务==逻辑中==分离==出来

## 程序结构

### domain
- @Entity -- 与数据表相对应
    - @Id -- 对应表中主键
    - @GeneratedValue -- 自增
    - @Max -- 最大值
    
      @Min -- 最小值
      
      (value, message) -- value: 区间值，message: 错误信息
    
    
### controller -- 控制器
- @RestController -- 返回的内容就是return的内容
    - @Controller -- 在对应的方法上可以解析return的html，jsp页面，处理http请求
    
    - @ResponseBody -- 方法上加上这个注解，可以返回json，xml等内容
    - @RestController -- 相当于@Controller和@ResponseBody的组合，但是不可以返回html和jsp页面
- @RequestMapping -- 配置url映射

- @GetMapping
- @PostMapping
- @Valid -- 验证对象，BindingResult 返回验证结果

### repository(dao)
数据访问对象，面向对象的数据库接口,操作数据库
- JpaRepository 
    - 使用JPA规范操作数据库
    
    - spring-boot-starter-data-jpa
    
### service -- 服务
- @Service

### [事务](/src/main/java/com/selune/luckymoney/service/transaction.md)
数据库事务，是指作为单个逻辑工作单元执行的一系列操作，要么完全执行，要么完全不执行
- @Transactional

### config
配置类

### aspect
AOP

### RESTful API
- GET
- POST
- PUT

### application.yml
配置文件，上下文
```yaml
spring:
  datasource: #配置数据库连接项
    driver-class-name:
    url:
    username:
    password:
```
选择配置环境
```yaml
spring: 
  profiles: 
    active: 
```
