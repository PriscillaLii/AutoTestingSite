# Auto Testing Site
================================

#### Application Requires/Java Dependencies:
- Java JDK 1.8
- Maven 3.5.0
- Spring Boot (spring-boot-starter-parent - 2.1.9.RELEASE)
- Spring Security
- Spring Data JPA
- MySQL 5.6+ / MariaDB

#### Other libraries:
- Bootstrap 4.3.1
- jQuery 2.2.4

#### Build + Run:

1. Eclipse -> Files -> Import: 导入项目
2. 确认MySQL Server或者MariaDB Server正在运行。建一个Schema命名为AutoTestingSite
3. 修改：
  1）src/main/resources/application.properties：
      ·spring.datasource.username=    
      ·spring.datasource.password=    
      ·spring.datasource.url=jdbc:mysql://localhost:3306/AutoTestingSite?serverTimezone=CST 这个不改也不影响运行    
  2）controller/TestingController.java：    
      ·Line 29: UPLOADED_FOLDER 改成你的本地路径
4. 右键WebApplication.java -> Run As -> Java Application
5. 打开localhost:8080, 然后它就跑起来啦！

#### To Do:
1. TestingController.java 
  ·line 50: 把运行截图的代码放在这里   
  ·第49行的Result也要根据运行结果修改   
2. testingHistory.jsp
  ·目前还没有那个删除和导出的按钮，毕竟还没能运行那个截图软件。。以后加上。。   
3. UserValidator.java
  ·validateChange这个method里，要是有时间的话可以想想该怎么测试老密码是否输入正确。没时间就别管了，反正能糊弄过去

