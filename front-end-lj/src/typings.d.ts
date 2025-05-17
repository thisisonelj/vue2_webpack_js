// 全局要用的类型放到这里

declare global {
  type userInfo = {
    id: string
    name: string
  }
}

export {} // 防止模块污染
