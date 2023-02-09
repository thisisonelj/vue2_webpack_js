const devConfig = require('./config/dev.config')
const proConfig = require('./config/pro.config')
const process = require('process')

console.log(process.env.NODE_ENV)

module.exports = process.env.NODE_ENV === 'development' ? devConfig : proConfig
