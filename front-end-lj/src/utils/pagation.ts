/**
 * 统一分页
 */
type pagationParams = {
  current: Number
  size: Number
  total: Number
  [props: string]: any
}
interface pagationInfo {
  sizeChange(size: Number): { total: Number; data: any[] }
  currentChange(current: Number): { total: Number; data: any[] }
  initPage(size: Number, current: Number): { total: Number; data: any[] }
}
export class pagationFunClass implements pagationInfo {
  current: pagationParams['current']
  size: pagationParams['size']
  total: pagationParams['total']
  recordList: any[]
  currentList: any[]
  pageComputedInfo(): { total: Number; data: any[] } {
    this.currentList = this.recordList.slice(
      (this.current - 1) * this.size,
      this.current * this.size,
    )
    this.total = this.recordList.length
    return {
      total: this.total,
      data: this.currentList,
    }
  }
  constructor(recordList: any[]) {
    this.current = 1
    this.size = 3
    this.total = 0
    this.recordList = recordList
  }
  sizeChange(size: Number, current: Number): { total: Number; data: any[] } {
    this.size = size
    this.current = current
    return this.pageComputedInfo()
  }
  currentChange(current: Number, size: Number): { total: Number; data: any[] } {
    this.current = current
    this.size = size
    return this.pageComputedInfo()
  }
  initPage(): { total: Number; data: any[] } {
    return this.pageComputedInfo()
  }
}
