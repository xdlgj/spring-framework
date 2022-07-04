# IOC作业
## 需求
模拟一用户注册操作
### Dao 
* 需要定义一个dao接口（UserDao），接口中的方法insertUser（SysUser user）
* 定义接口的实现类MySqlUserDao，insertUser()方法里面不需要操作数据，输入"使用了dao执行insert操作"
### UserService
* 需要定义一个service接口（UserService），接口中的方法addUser
* 定义接口的实现类UserServiceImpl，在service的实现类中有一个UserDao类型属性
* 操作service类中的addUser(){userDao.insertUser()}完成注册。
### SysUser
* 定义一个实体类SysUser表示用户的数据
## 要求实现
程序中的UserServiceImpl、MysqlUserDao这些类都由spring容器创建和管理，同时给UserServiceImpl
类中的UserDao属性赋值，从spring容器中获取UserServiceImpl类型的对象，调用addUser()。