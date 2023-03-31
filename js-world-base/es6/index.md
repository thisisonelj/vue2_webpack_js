## 二、ES6学习：

### 1.let命令：块级作用域、函数作用域、全局作用域、变量必须先声明后使用、程序按顺序执行、同一级作用域内不能重复声明、外层作用域不能访问内层作用域变量、内外层变量同名声明不是覆盖是内层重新定义一个新的变量、函数声明可以在块级作用域声明=》函数表达式

### 2.const命令：和let命令一致、区别在于不可变、基本类型不可变、引用类型地址不可变(引用对象内容是可变的)、es6中全局对象和全局变量毫无关系、且global为全局对象

### 3.变量解构赋值：数组形式=》需实现iterator迭代器接口均可数组解构、变量可以设默认值(在左边设值)、对象解构赋值和数组一致、区别对象对应属性key数组对应位置索引、：冒号左边为对应的值冒号右边为变量赋值、undifiend和null不能放在右边、解构赋值右边必须是对象数组且左右俩边必须一样的模式、函数参数解构赋值、解构赋值不要使用圆括号

### 4.String字符串扩展：for of循环、at方法、includes()、startswith()、endswith()、repeat()、padstart()、padend()、模板字符串` ${data}` data为js中变量、是一个值、表达式、函数、最终产出字符串、标签模板=》函数名+模板字符串(直接调用该函数、参数为模板字符串)、raw+模板字符串(输出转义\的字符\\)

### 5.Number数值：Number.isNaN()和Number.isfinite()=>参数不会自动类型转换、Number.parseInt()和Number.parseFloat()效果和js一致、Number.isInteger()、Number.isSafeInteger()判断整数是否为安全整数=>是否在表示范围之内、指数运算a**b、Integer数据类型数字后面加n表示不限位数的整数

### 6.函数扩展(函数设置默认值、解构赋值参数默认值=》解构赋值左边赋值默认值、解构赋值必须俩边都要有符合模式)、函数参数位置根据参数顺序对应(undefined取默认值、调用时非尾部参数不能省略)、

### 函数作用域(参数设置默认值=》就有了参数作用域、优先选用当前作用域的变量、内层作用域只受相邻作用域影响、各层作用域间相互独立)、rest参数(变量作为数组使用、...变量、必须放在参数最后)、length属性(不包括参数默认值、rest参数)

### 严格模式(user strict=>全局声明/立即执行的函数内使用)

### 箭头函数：绑定this(唯一指向函数定义时的作用域对象、可以指定回调函数、函数的函数中this指向为当前对象)、js中this=》function函数this指向的是函数运行时的作用域对象

### 箭头函数内部没有this、不能用作构造函数、this指向外部对象、

### 嵌套的箭头函数(多层function嵌套=》子函数为父函数的参数)

### es6中::绑定this替代了js中apply、bind、call方法、且双冒号左边为对象、右边为方法、可以链式使用

### 优化性能(节约内存)：尾调用(函数返回时调用函数返回)、尾递归(递归函数返回尾调用)、递归函数(返回时尽量尾递归)

### 函数参数尾逗号、catch语句可以不带参数

### 7.数组扩展(扩展运算符=》...[]=>rest参数的逆向使用将数组转为可调用的函数参数、可作为表达式使用)用途：合并数组、解构赋值、字符串转为数组、实现了iterator接口的对象可以转为数组

### Array.from()可以将类似数组的对象(必须要有length属性)和实现iterator接口的对象均转为数组  (例子：dom返回的集合、字符串、arguments对象以及具有遍历器的set、map)、其中第二个参数是数组的map函数 (参数必须是对象)

### Array.of()可以将一组值转为数组

### 数组实例的copyWithin()：替换数组数据、修改原数组

### find()、findIndex()、fill()、entries()、values()、keys()、includes(内部使用==进行判断)、es6对数组空位全部表示为undefined、且都会对空位进行处理

### 8.对象的扩展 es6允许定义属性时可以使用属性[表达式]来定义属性和方法、对象的属性一定是字符串、

### object.is()(和js中===效果一致区别在于NaN等于自身、+0不等于-0)、object.assign()=>合并对象(源对象和目标对象必须为对象、同名属性会覆盖(选取最右边的对象属性)、对象浅拷贝(值为对象时是对象的引用)、合并不是对象时自动转为对象(只有字符串可以合并)、合并条件是必须是对象的可枚举属性和自身属性=》undefiend和null无效) 用途：对象添加属性、方法、拷贝对象、合并多个对象、为对象指定默认值

### 对象的遍历：尽量使用object.keys()=>可枚举的、自身的属性、

### for in不要用以及其他遍历方法   对象的属性名的值：字符串、数值、symbol三种类型

### 对象深拷贝：原型对象一致和属性描述对象一致、对象相关的原型方法

### object.keys()、object.values()、object.entries()三者都是表示属性、值、【属性、值】的可枚举和自身属性的特点的

### 对象扩展运算符(类似数组...对象名)=》解构赋值(必须用于末尾、表示未读取和可枚举自身属性的对象集合)

### 9.symbol(es6新增的数据类型类似字符串=>为了属性名的不同、是基本数据类型)

### symbol作为对象属性名使用时只能使用[]来定义属性不能用.

### 10.Set数据结构：只能通过new Set()来构造set对象、参数可以是类似数组的对象、实现iterator接口的对象   内部通过===来去重

### Set:size返回个数、add()、delete()、has()、clear()

### set遍历：keys()、values()、entries()、foreach()、键名和键值都是同一个值、可以使用map()、filter()  还可以用来处理并集、交集、差集

### weakset：一种内部成员只能是对象的数据结构

### 11.map数据结构：map是es6为了解决对象属性只能用字符串来命名的、map的键值任意类型都可以命名、map只能通过new map()来构造、参数是实现iterator接口的对象和每个成员都是一个双元素表示的数组的数据结构、map的键名为对象时是对象的引用

### map:size、set()、get()、has()、delete()、clear()、

### keys()、values()、entries()、foreach()

### map没有filter()和map()方法   weakmap对象键名只支持对象

### map用途：map转数组、数组转map、map转对象和json=>map中的键名必须是字符串

### 12.promise对象 异步操作的统一接口   new promise()构造    内部是异步操作、resolve(成功)和reject(失败)方法用来传递数据给回调函数

### 异步操作最终只有一种状态resolve/reject、promise建立后立即执行

### 异步操作封装ajax、异步操作返回状态有时由另一个异步操作决定(异步操作返回promise对象)、  resolve()和reject()函数后面可以有执行语句(俩个方法都是异步操作)

### Promise.then()：俩个参数(第一个为resolve的回调、第二个为reject的回调)、且then()返回一个promise对象、可以链式使用then()方法

### promise.catch():捕获then()方法和reject()的错误、promise实例结果只能是一种状态、一般都要使用catch()来捕获error、catch()方法也是返回一个promise实例、可以链式调用

### promise.all():参数必须是实现iterator接口的对象、每个成员必须是promise实例、返回一个新的promise实例=》所有成员实例都是resolve返回结果才是resolve、其中有一个成员是reject返回结果就是reject、promise结果被catch()捕获后结果变为resolve

### promise.race():类似all()方法、参数是实现iterator接口的对象、只要有一个成员状态率先改变最后返回结果就是该成员的结果状态

### promise.resolve():返回一个状态为resolve的promise实例、参数：没有参数、promise实例、thenable对象(内部有then方法的对象)、基本数据类型和引用对象(内部没有then方法)四种类型

### promise.reject():类似resolve、返回一个状态为reject的promise实例、参数和resolve一致、唯一区别：reject(data)=>data会直接作为catch(e)e的参数对象

### done()：用于promise实例的回调尾端、用于捕获可能出现的错误、从而向全局抛出错误、promise实例的内部错误无法向外抛出、只能通过内部catch()解决

### finally()：无论promise实例是resolve、reject(finally(function(){})都会执行)



### 13.async:是generator函数的语法糖

### async function()返回一个promise对象、代表该函数是异步操作

### await promise实例/基本类型  await相当于promise实例的then回调    用途：要使用await  必须函数是async  async用于普通函数、对象函数、函数表达式、class类中方法、箭头函数

### promise对象：async函数的then回调必须使得内部所有异步操作均执行完才能进行回调

### await命令：async内部有多个await异步操作、如果await promise返回状态是reject、那么函数会中断执行、async返回一个promise实例且只有一种状态取决于内部多个异步操作的结果(所有异步操作都是resolve=》总体返回resolve、只要有一个操作是reject=>总体返回reject)、解决办法是对reject进行catch捕获处理

### 错误处理：async一旦某一await异步操作为reject、就会中断函数执行、采用try...catch结构来错误处理

### 注意点：await promise尽量在try..catch代码块中运行

### 多个await异步操作尽量同时(并发)执行=》promise.all()、将多个promise实例放在一个iterator接口实现的对象

### 同步执行：A:let A=await promise  B:let B=await promise   AB同步执行 

### 并发执行：A:let A=promise     let a=await A

### B:let B=promise     let b=await B

### AB同时执行

### awiat命令只能在async中使用    不要在foreach中使用async

### 可以用for of 代替

### 异步操作的历史：回调函数=》promise对象=》generator函数=》async

### 单个异步操作用promise、多个异步操作用async

### map()函数可以实现多个异步操作同时并发执行

### for of实现多个异步操作同步继发执行

### 传统的iterator遍历器for of是同步遍历

### 实现了asynciterator遍历器for await of是异步遍历

### 14.iterator:实现该接口的js对象：数组、map、set、string、nodelist、arguments、typedarray  均可以使用for of

### 15.模块化:

### es6模块化是在编译时的静态化处理

### export命令：export {}  尽量写出这种形式  export提供的是对外接口    export输出的变量都是动态更新的(原来模块的变量更新会同步输出的变量)、export命令只能放在顶层作用域不能放在块级作用域

### import命令：import {} from '/..'   尽量使用这种形式   变量名和被引入模块的变量名一致、as别名、相对、绝对路径、.js后缀可以省略

### 引入模块没有指定路径只有模块名：必须在配置文件中配置

### import无法使用变量和表达式以及执行语句   是静态执行的

### import '模块'  加载整个模块  没有输入

### import * as 对象名 from '/..'   import整体加载   将输出变量封装成一个对象导入

### export default命令：只能输出一个变量 

### export{}  输出多个变量   对应import {} from '/...' 输入多个变量

### export default  一个变量(没有大括号)   对于import 变量名(任意名称) from '/...'输入一个变量

### export default 一个模块只能使用一次    export使用多次

### export和import可以复合使用：export {} from '/..'

### 先导入再导出   export * from '/..'   整体输出

### 跨模块常量：export const 变量名=赋值

### import()和import命令一致、唯一区别import()可以运行时加载、用于任何位置、返回promise对象、和require()区别是异步加载

### require()运行时加载

### import()用途：按需加载、条件加载、动态模块路径

### import()返回promise实例 回调函数then参数可以使用对象解构赋值{a、b}、可用promise.all() 同时加载多个模块   可以用于async中

### 16.es6 this不允许指向全局对象(顶层对象)、delete命令只能删除对象属性、各个模块间都是独立的、模块之间只能通过import、export命令来共享资源

### es6模块和commonjs区别：

### commonjs：运行时加载  es6编译时加载

### commonjs:输出的变量是值的拷贝(原模块和现模块变量没有关系)  es6输出的变量是值的引用(原模块和现模块变量是同一个)

### commonjs:输入require()   输出module.exports

### es6:输入import、输出export

### es6输出的变量是引用时对象只能修改、不能重新赋值  

### obj={}不可取  因为俩个模块指向的是同一个引用

### commonjs模块中this指向当前模块

### import加载commonjs模块(module.exports作为默认输出相当于export default 变量)  import 变量 from '/..'

### require加载es6模块：require()返回的是一个对象、对象内部对应每个变量都是每个get()函数

### commonjs模块加载时生成缓存

### 循环加载：a.js加载b.js   b.js加载a.js

# 至此前端js基础已学习完    原生js和es6

