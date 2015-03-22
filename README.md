1.系统介绍
c-platform是基于Hibernate,Spring,SpringMVC,Spring Data JPA的技术开发框架，主体语言java。物理上c-platform以标准的三层架构设计，分客户端、服务端、数据库端；逻辑上c-platform以多层架构设计，包括表现层(view)、控制层(controller)、业务对象层(service)、视图对象层(dto)、实体对象层(domain)、数据访问层(repository)等。

2.技术特点
c-platform控制层使用了springmvc，可以防止非法用户直接访问真实文件,加强安全.                                   
c-platform使用hibernate，可以跨多种数据库！如sql Server Oracle MySQL
c-platform持久层使用sping data jpa 可以大量减轻开发人员编写持久层代码
c-platform使用Hibernate Validator实现JSR-303标准，只要在实体定义好验证标准就可以验证前台传入过来的数据合法性，也可以自定义验证类，实现更强大的验证
c-platform使用了aop技术对服务端ajax回传数据打包封装，包括数据验证失败信息，所有的后台异常信息！
c-platform使用了反射技术实现了对数据进行部分更新！如一个实体有id，name，title，可以只提交id和title进行更新数据，name属性不会被更新
c-platform支持对查询数据不分页，前台分页，后台分页三种数据显示方式！

代码即将公布....请稍等...
