#对vue3组合式api set-up方面的内容进行练习
vue3相比与vue2来说的变化：
vue3响应性是数据对象的代理   监听数据变化是监听的代理proxy对象不是源对象 vue2是监听的源对象遍历源对象data的每个属性object.defineproperty()
vue3定义响应式数据是以ref引入来定义 且修改时ref.value来改动  vue2选项式在data对象里面定义就可以了
vue3新增了set-up组合式api  所有的状态方法都在一个主线程下执行  更类似于函数式编程 vue2以选项式api来描述
vue3模板引用通过  ref(null)或者ref([])来获取dom或组件实例 且set-up方式的父组件不能直接访问子组件状态   vue2直接this.$refs来访问
vue3提供了watcheffect函数来追踪监听回调函数内的所有用到的响应性依赖 自动追踪  且可以设置flush:post来在watch中获取更新后的dom
vue2则没有这些  只是普通的异步、监听、变化、   
vue3组件事件添加了校验、可以定义列出vue组件的自定义事件  很好的将emit类型事件和原生类型事件进行区分 vue2则没有这个功能
vue3 v-model添加了组件多个v-model可以绑定  v-model可以添加修饰符供子组件灵活配置相关功能    vue2则没有这些功能
vue3提供了provide和reject的响应性状态  意味着这种通信方式的状态ref是可以是响应式的   vue2则是没有响应性的
vue3自定义指令和vue2没有多大区别   自定义指令一般在需要对底层dom操作访问的时候才会用到   一般情况下不会用到
vue3组合式函数比起vue2的混合   优化太多   组合式函数ref+解构清晰的数据来源  命名空间不冲突  解耦组合式函数可以嵌套使用
vue3组合式api对组件实例data数据状态可以使用ref toRef toRefs这些来转换为响应式对象  这点和vue2有很大的不同  vue2只能是初始化定义 
vue3组合式api和选项式api尽量选中一种使用   不要混合使用   类似export default{set up({})}   
script setup和script一块使用的场景有三种：inheritAttrs禁止透传   模块导出声明name    运行在模块作用域只执行一次的副作用
vue3中set up不能使用src属性
vue3组合式api特性：逻辑复用  灵活的代码组织  类型推导通过变量和函数  更小的生产包体积
vue的响应性是基于运行时的   vue3响应性以proxy代理为主拦截源对象生成代理对象  
vue3相比vue2在渲染方面也就是rendertree虚拟dom上的优化：静态提升  静态的不变的模板以及页面dom元素一般情况下会被略过,不重新渲染
更新类型标记   在编译模板时，在编译后的vnode上添加类型标记，可以更快的定位node节点，进行更新渲染
树结构打平  将原来的vnode树中变化的树节点列出来组合成一个数组   相对于遍历数组而不是一个树结构   速度更快