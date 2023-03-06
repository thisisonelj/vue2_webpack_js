const lazyData = []
for (let i = 0; i <= 10000; i++) {
  let obj = {}
  obj.id = i
  obj.name = `liu-${i}`
  obj.age = `24-${i}`
  lazyData.push(obj)
}
export default lazyData
