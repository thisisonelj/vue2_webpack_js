# 前端学习汇总：

## 一、javaScript(原生js)

### 1.js基础(函数闭包=》函数的函数、存储局部变量于内存、js作用域=》全局、函数作用域、数据类型转换=》根本上为基本类型的转换)

### 2.js标准库(Number、String、Boolean、Object、Array、JSON、Date、封装pojo)

### 3.js面向对象编程(this指向=》函数的函数、回调函数、绑定this、prototype原型链=》理解原型链机制、js面向对象的根本、object的主要api=>Object.keys()、Object(实例).hasownProperty())

### 4.js运行机制(js为单线程单任务运行机制、同步为主异步为辅、事件循环、定时器的运用、异步统一接口实现Promise对象、严格模式use strict)

### 5.js操作dom(页面动态变化的根本dom接口的Api=》document对象、element对象、属性操作、text文本节点、Css操作)

### 6.js事件(事件回调三种定义、this指向、事件传播=》捕获和冒泡、事件event接口的属性和Api、preventDefault()和stopProfragtion()方法、自定义事件、事件种类=》鼠标、键盘、滚轮、滚动条、进度事件=》ajax通信、外部资源加载、load和error事件、拖拽事件=》drag、传递数据Datatransfer对象、触摸事件touchevent、doucument文档事件=》文档加载、dom加载、表单事件、焦点事件=》focus和blur)

### 7.js浏览器渲染(加载html文档=》html解析和script脚本解析=》加载外部js和css=》加载css=》渲染dom=》操作dom重流改变布局=》渲染页面重绘)、dom操作是在dom渲染完成后进行的操作、重流时将dom操作和css操作尽量都各自写完整一起、使用虚拟dom、从浏览器渲染以及js引擎方面来考虑如何优化js以及浏览器性能、浏览器基于边加载文件边渲染dom的机制。

### 8.Window对象(window浏览器全局对象、window对象属性和Api、window窗口支持多窗口操作=》iframe标签、窗口间通信、引用、window全局事件=》load、error事件、window编码方法)

### 9.cookie(存在于浏览器中、key=value形式的字符串、可以读写、js和服务器获取、限制于不同浏览器、同源政策)

### 10.localstorage和sessionstorage存储浏览器数据(可以读写、数据发送变化时触发storage事件、数据以(key,value)形式存储)

### 11.同源政策(ajax跨域通信处理=》ajax支持同源政策=》解决方式：jsonp(只允许get请求)、cors处理、websocket)、不同网页间通信(localstorage、iframe多窗口即不符合同源政策)=>window.postmessage方法处理、监听message事件接受数据、cookie通过修改domain属性来同源

### 12.CORS通信(简单请求(post、get、head请求和content-type：表单、文本格式)=》一次请求=》Access-Control-Allow-Origin判断是否请求成功)复杂请求(除简单请求外的其他类型请求和content-type:json格式=》俩次请求=》预请求options和正式请求)cors通信浏览器已实现、需要服务器端实现跨域

### 13.浏览器端数据库indexedDB=》异步、NOSQL、同源政策、key-value存储。

### 14.ajax的使用(原生ajax=>xmlhttprequest对象的属性和api、支持请求和响应、进度事件、支持http协议、支持请求和响应数据格式)

### 15.js WEBApi(支持动画=》canvas、svg、requestAnimation、支持表单Api、文件file和二进制数据Blob数据处理、支持多线程Worker实现)

### 16.WEBSOCKET实现(高级协议、握手、实现服务端和客户端双向通信、服务端主动推送信息给客户端、open、message、close事件、接受文本和二进制数据格式)

### 17.WebComponents(js原生支持组件化、模块化的概念以及实现、通过注册组件、link元素导入配置注册dom外部文件、以-符号来命名自定义dom/组件、外部dom/组件在当前网页为dom节点来看待)

### 其中支持template模板、customelement、shadow Dom、html

### import四种方式















### 











