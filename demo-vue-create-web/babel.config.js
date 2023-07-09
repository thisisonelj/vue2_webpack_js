module.exports = {
  presets: [
    '@vue/app',
    [
      '@babel/preset-env',
      {
        useBuiltIns: 'usage'
      }
      // 这个设置主要是为了让babel在检测浏览器和源代码遇到语法转换兼容时所缺少的polyfill(相关依赖)自动检测出来装载
    ]
  ],
  plugins: [
    [
      'component',
      {
        libraryName: 'element-ui',
        styleLibraryName: 'theme-chalk'
      }
    ],
    ['@babel/plugin-syntax-dynamic-import']
  ]
}
