# 视频系统--科目管理模块
## 项目功能说明
* 视频系统可实现学员观看某科目视频功能，教师上传视频功能
* 科目管理模块可对“复合科目”和“单一科目”进行修改和增加
## 项目技术说明
* 开发环境为Eclipse、Tomcat 8.0、Navicat for MySQL
* 使用语言为HTML(5)/CSS(3)、JavaScript、Java
* 前端使用bootstrap-table实现可编辑表格对科目进行添加和修改，对数据进行整合后通过ajax向后台发送JSON格式数据
* 后台使用Java，通过spring MVC全注解方式结合Hibernate的C3P0数据库连接池对MySQL数据库进行连接和配置，使用HQL语句对数据库进行操作
	* config：对spring MVC包扫描和数据库等进行配置
	* controller：负责与前端进行“交流”，对前端发来的请求进行识别，下发给service层，从service层获取要返回给前端的数据，返回给前端
	* service：负责具体的业务逻辑，引用controller层和dao层的数据进行整合、逻辑判断
	* dao：使用HQL语句通过对对象的操作达到操作数据库的目的，功能单一
	* model：对应数据库表的实体类
### 项目需要改进的地方
	* 前端没有进行MVC分类，代码耦合度高，难以修改
	* 代码复用性低，好多重复代码段，应单独出来做成方法调用
	* 方法功能不够简单、单一
![页面构造图](https://github.com/enka33/subjectManagement/tree/gh-pages/TestTable0.1/WebContent/resource/pic/pagesPic/构造图.png)
![查看复合科目](https://github.com/enka33/subjectManagement/tree/gh-pages/TestTable0.1/WebContent/resource/pic/pagesPic/复合科目查看.png)
![修改科目名称](https://github.com/enka33/subjectManagement/tree/gh-pages/TestTable0.1/WebContent/resource/pic/pagesPic/修改名称.png)
