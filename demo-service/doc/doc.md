# 项目说明
演示了springboot项目的最佳实践，包括如下功能
1. 统一的切面入口处理，有基于类扫描的切面（BaseInterceptorByClass）和基于注解（BaseInterceptorByAnnotations）的切面两种
2. 统一的异常处理（GlobalExceptionResolver）
3. 拦截器的使用（SystemInterceptor），可配置过滤URL
4. 时间类型接收格式化（WebConfig）
5. 演示了Maven模块化包划分，service-common，common中放一些util等公共类，由于entity，dao，service，mapper每个服务的需求不一样，所以不建议抽成公共包。