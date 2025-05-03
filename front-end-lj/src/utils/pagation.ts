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
  sizeChange(size: Number): void
  currentChange(current: Number): void
  initPage(size: Number, current: Number): void
}
export class pagationFunClass implements pagationInfo {
  current: pagationParams['current'],
  size: pagationParams['size'],
  total: pagationParams['total'],
  recordList:any[]
  pageComputedInfo():{total:Number,data:any[]}{
   let showLists = this.recordList.slice((this.current - 1) * this.size, this.current * this.size)
   return {total:showLists.length,data:showLists}
  }
  constructor(current:Number,size:Number,total:Number,recordList:any[]){
    this.current=current
    this.size=size
    this.total=total
    this.recordList=recordList
  }
  sizeChange(size: Number):{total:Number,data:any[]} {
    this.size=size
    this.pageComputedInfo()
  }
  currentChange(current: Number): {total:Number,data:any[]}{
    this.current=current
    this.pageComputedInfo()
  }
  initPage(size: Number, current: Number): {total:Number,data:any[]}{
    this.current=current
    this.size=size
    this.pageComputedInfo()
  }
}
