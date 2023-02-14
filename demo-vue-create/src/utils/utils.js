const commonMethods = {
  /** 数组转换树结构 => 添加根节点root */
  arrayToTree: function flatToTree2 (data) {
    const result = []
    const fn = (arr, cArr, parentCode = 'root') => {
      for (let i = 0; i < arr.length; i++) {
        const item = { ...arr[i], children: [] }
        // if (arr[i].bankId === 'root') { cArr.push(item) }
        if (arr[i].parentCode === parentCode) {
          cArr.push(item)
          fn(arr, item.children, arr[i].bankId)
        }
      }
    }
    fn(data, result)
    let rootData = {}
    let finalResult = []
    data.forEach(element => {
      if (element.bankId === 'root') {
        rootData = element
      }
    })
    rootData.children = []
    rootData.children = result
    finalResult.push(rootData)

    return finalResult
  },
  /** 数组转换树结构  => 没有根节点root */
  arrayToTreeNoRoot: function flatToTree2 (data) {
    const result = []
    const fn = (arr, cArr, parentCode = 'root') => {
      for (let i = 0; i < arr.length; i++) {
        const item = { ...arr[i], children: [] }
        // if (arr[i].bankId === 'root') { cArr.push(item) }
        if (arr[i].parentCode === parentCode) {
          cArr.push(item)
          fn(arr, item.children, arr[i].bankId)
        }
      }
    }
    fn(data, result)

    return result
  },
  /** 树的遍历 */
  traveTree: function traverseTree (data) {
    data.forEach(element => {
      element.leafCode = true
      if (element.children.length !== 0) {
        element.leafCode = false
        traverseTree(element.children)
      }
    })
  },
  /** 树转数组 */
  treetoArray: function treeToFlat2 (data) {
    const result = []
    data.forEach(item => {
      // const obj = {
      //   name: item.name,
      //   id: item.id,
      //   pId: item.pId
      // }
      result.push(item)
      if (item.children?.length) {
        result.push(...treeToFlat2(item.children, item.bankId))
      }
    })
    return result
  }

}
export default commonMethods
