1.vue-router地址跳转原理：

无论hash还是history模式  二者都是基于浏览器history对象来进行地址回退和前进的

router对象的全局单例配置   无论嵌套路由还是多种命名试图  都要和对应的组件一一映射

全局路由配置最为关键     vue-router都是以路由为导向，导航成功时，渲染相对应的组件

且渲染组件都是局部刷新本质上是组件的销毁和创建  特殊情况比如keep-alive缓存组件 

在地址跳转时全部都是当前单个页面的部分局部刷新实则为组件的替换与销毁  且必须要有

router-view 这个视图标签才能渲染   因此在输入地址时路由组件的渲染必定是在当前页面的基础上

进行组件的更替渲染的   所以地址输入时先是源地址后是要路由的新地址   因此为什么说vue是

单页面spa应用   router的本质就是这个原理   根本上就是组件的更新替换  永远是同个单个页面。

2.vuex响应原理：

vuex中state是响应式的   本质和data响应一致    只能通过commit mutations来改变状态来进行响应

且用在组件中选项只能是computed计算属性不能是data 因为state和data都是一样的都是属性   且都是

在初始化过程中的  如果data中用vuex state来保存状态  那么这个只能是data中变量的初始值    state的

变化并不能改变data中数据的变化  computed计算属性是根据依赖来进行变化的进行侦听的  所以是可以

侦测到state的变化的

3.vuex中module只是添加了命名空间访问以及全局状态根节点访问  本质上和原来的store仓库没什么区别

都是在同一个单个store实例下   将store分成了多个模块  添加了访问各个子模块以及根模块状态的权限路径

4.vue中computed计算属性本质和watch一样都是根据依赖变化来追踪改变的    或者说computed的属性就不能

显示的赋值改变  只能通过改变它的依赖来进行改变  这点和data属性是不一样的

5.babel主要分为preset预设和plugin插件俩部分  babel本质上是js编译器  将es转为所有浏览器都可以兼容的js

预设preset就是设置在转换过程中所需要的相关依赖polyfill也指第三方库  插件就是转换过程中需要支持的相关

语法以及转换功能

6.webpack打包对于静态资源比如图标、图片、样式等   如果是以绝对路径来访问或者资源放在public文件夹之下   是不会参与进打包依赖中的

如果是以相对路径访问是会打包构建的。

7.vue-cli中webpack调整配置有俩种方法：一种是通过写configurewebpack来实现   原理是通过object.assign()方法来实现最终对象的合并返回一个新属性的对象   另一种是通过写webpackchain来直接改变webpack配置

8.eslint语法检测提示  其中extends属性显示声明所应用的eslint内部规则   rules用户自定义规则进行添加和覆盖继承的同一属性的规则    

9.Vue-loader是将html转为单文件组件.vue的webpack loader    如果是基于vue-cli的构建 那么基于css预处理器 less|sass|stylus| 这些loader内部已经配置好  无需配置   还有就是基于babel-loader的配置也是内部配置好的

10.scoped作用的css父组件样式只能够影响子组件的根元素样式   要想深入影响子组件内部元素样式  必须使用

<<<deep 这个关键属性

11.history模式需要后端配置  因为输入url会请求后端服务   后端返回相应的资源(这里资源并不是纯粹的后端html类似后端返回一个html页面一样即服务端渲染html全局刷新   不是这样的)   然后根据这个返回的资源来找寻前端路由相应的配置  实际上是后端需要配置相关的前端请求url  给前端返回一个资源状态  通过这个状态来找出前端路由中对应的前端地址  history模式本质上还是前端路由   只是先需要后端配置url 再进行前端路由。

12.父子组件生命周期：

父created-子created-子mounted-父mounted-子updated-父updated-子destroy-父destroy

keep-alive内置组件 、history模式为什么后端要配置  父子组件生命周期顺序

13.webpack中bundle的生成本质上是请求服务端webpackdevserver的结果   devserver服务返回bundle

14.webpack代码分离的原理就是将源代码模块的chunk从原来生成的一个整个bundle文件变成多个体积更小的bundle   例如路由懒加载import() 和splitchunkpluglns插件都是将重复使用的模块、单独的路由组件从源代码模块的chunk中分离出来 生成一个单独的bundle   这样总体体积小了  加载这些bundle可以按需加载、并行加载、效率更快

15.webpack中模块、chunk、bundle三者概念   模块就是源代码是webpack的基本单位   chunk就是webpack编译后生成的模块对应的chunk  整个chunk优化也是webpack进行优化的重要阶段  bundle就是最后构建输出的最终产物  也是供外部使用的产品   然而它是根据生成的chunk来一一对应构建输出后的bundle

16.webpack中treeshaking 是只针对es6静态模块的import和export这些命令来进行删除未引用代码的  所以对于其他的模块是不能产生相应作用的

