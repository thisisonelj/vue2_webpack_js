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
