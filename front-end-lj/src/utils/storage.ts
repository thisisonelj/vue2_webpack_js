/**
 * 模拟后台数据库 前端storage本地存储数据
 */
export class storageHanderClass {
  storageSource: {}
  constructor() {
    this.storageSource = window.localStorage ? window.localStorage : {}
  }
  setStorageInfo(key: String, value: String): void {
    this.storageSource.setItem(key, value)
  }
  getStorageInfo(key: String): any {
    return this.storageSource.getItem(key) ? JSON.parse(this.storageSource.getItem(key)) : ''
  }
  removeStorageInfo(key: String) {
    this.storageSource.removeItem(key)
  }
  clearStorageInfo() {
    this.storageSource.clear()
  }
}
