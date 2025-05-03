/**
 * 模拟后台api
 */
import { ElMessage } from 'element-plus'
import { treeData, tableData } from './mock'
interface httpRequestParams {
  url?: String
  data: Object
  name: String
  options?: {}
  [props: string]: any
}
interface httpResponseParams {
  code: Number
  data: any
  msg: String
}
export const queryTreeData = (param: httpRequestParams): Promise => {
  return new Promise((resolve, reject) => {
    try {
      let treeDataInfo: any[] = treeData
      let result: httpResponseParams = {
        code: 200,
        data: treeDataInfo,
        msg: '请求成功',
      }
      setTimeout(() => {
        console.log('查询树形数据成功')
        resolve(result)
      }, 100)
    } catch (error) {
      ElMessage({
        message: `${JSON.stringify(error)}`,
        type: 'error',
      })
      reject(error)
    }
  })
}

export const queryTableData = (param: httpRequestParams): Promise => {
  return new Promise((resolve, reject) => {
    try {
      let tableDataInfo: any[] = tableData
      let result: httpResponseParams = {
        code: 200,
        data: tableDataInfo,
        msg: '请求成功',
      }
      setTimeout(() => {
        console.log('查询表格数据成功')
        resolve(result)
      }, 100)
    } catch (error) {
      ElMessage({
        message: `${JSON.stringify(error)}`,
        type: 'error',
      })
      reject(error)
    }
  })
}
