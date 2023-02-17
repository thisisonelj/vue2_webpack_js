const asyncModule = function () {
  return new Promise((resolve, reject) => {
    import('../views/router-demo/componentes/router-promise.vue')
      .then(result => {
        if (result) {
          resolve(result)
        }
      })
      .catch(error => {
        console.log(error)
        reject(error)
      })
  })
}
export default asyncModule
