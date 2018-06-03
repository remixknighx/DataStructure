## aop常用三大注解
- @Aspect 
- @Pointcut
- @Advice(@Before， @After)

### 匹配包/类型
```
// 匹配ProductService类里头的所有方法
@Pointcut("within(com.imooc.service.ProductService)")
public void matchType(){}

// 匹配com.imooc包及子包下所有类的方法
@Pointcut("within(com.imooc.*)")
public void matchPackage(){}
```

### 匹配对象
```
// 匹配AOP对象的目标对象为指定类型的方法，如DemoDao的aop代理对象的方法
@Pointcut("this(com.imooc.DemoDao)")
public void thisDemo(){}

// 匹配实现IDao接口的目标对象（而不是aop代理后的对象）的方法，这里即DemoDao的方法
@Pointcut("target(com.imooc.IDao)")
public void targetDemo(){}

// 匹配所有以Service结尾的bean里头的方法
@Pointcut("bean(*Service)")
public void beanDemo(){}
```

### 匹配参数
```
// 匹配任何以find开头且只有一个Long参数的方法
@Pointcut("executiion(* *..find*(Long))")
public void argsDemo1(){}

// 匹配任何只有一个Long参数的方法
@Pointcut("args(Long)")
public void argsDemo2(){}

// 匹配任何以find开头的而且第一个参数为Long型的方法
@Pointcut("execution(* *..find*(Long,..))")
public void argsDemo3(){}

// 匹配第一个参数为Long型的方法
@Pointcut("args(Long,..)")
public void argsDemo4(){}
```

### 匹配注解
```
// 匹配方法标注有AdminOnly的注解的方法
@Pointcut("@annotation(com.imooc.demo.security.AdminOnly)")
public void annoDemo(){}

// 匹配标注有Beta的类底下的方法，要求的annotation的RetentionPolicy级别为class
@Pointcut("@within(com.google.common.annotations.Beta)")
public void annoWithinDemo(){}

// 匹配标注有Repository的类底下的方法，要求的annotation的RetentionPolicy级别为RUNTIME
@Pointcut("@target(org.springframework.stereotype.Repository)")
public void annoTargetDemo(){}

// 匹配传入的参数类标注有Repository注解的方法
@Pointcut("@args(org.springframework.stereotype.Repository)")
public void annoArgsDemo(){}
```

### execution()表达式
```
execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
```

### Advice注解
- @Before，前置通知
- @After(finally)，后置通知，方法执行完之后
- @AfterReturning，返回通知，成功执行之后
- @AfterThrowing，异常通知，抛出异常之后
- @Around，环绕通知

### spring AOP三大应用
- @Transactional 事务
- @PreAuthorize 安全
- @Cacheable 缓存




