eventbus中央事件总线
其中主页面在mounted挂载阶段时分别向子组件分发事件
各子组件监听到相应的事件进行响应
且在组件销毁之前将eventbus事件监听清除