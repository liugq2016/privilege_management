# 企业进销权限管理
技术选型：SpringMVC+Springsecurity+Spring+Mybatis+Mysql
>功能模块
>>产品订单模块
>>>产品的详细信息。
>>>订单的提交。
>>权限管理模块：
>>>管理员：可进行所有的操作，如用户、角色、权限三者间的绑定与解绑，或对订单和商品的操作。
>>>仓库管理员：能看到产品、订单相关页面，但只能对订单页面相关数据进行操作。
>>>产品管理员：能看到产品、订单相关页面，但只能对产品相关数据进行操作。
>>AOP操作日志
>>>记录所有人的任何操作，管理员可见及修改，其他角色仅可见。
管理员账号：lgq pw:123
其他角色在一个账户上:ljl pw:123
