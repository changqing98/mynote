# 用户管理

### 用户

* adduser：会自动为创建的用户指定主目录、系统shell版本，会在创建时输入用户密码。
* useradd：需要使用参数选项指定上述基本设置，如果不使用任何参数，则创建的用户无密码、无主目录、没有指定shell版本。

### 密码

* 修改密码：passwd

### 用户组

* groups：查看当前登录用户的组内成员
* groups test：查看test用户所在的组，以及组内成员
* whoami：查看当前登录用户名
* usermod -aG groupName userName：将user添加到group中
* gpasswd -d userName groupNam：将user移除group中

