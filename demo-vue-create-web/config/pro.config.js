const path = require('path')
const webpack = require('webpack')
const CompressionWebpackPlugin = require('compression-webpack-plugin')

const config = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:8188',
        changeOrigin: true, // 是否跨域
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  },
  configureWebpack: {
    entry: {
      app: './demo-entry.js'
    },
    devtool: 'source-map',
    output: {
      filename: '[name].bundle.js',
      library: 'portal_application',
      libraryTarget: 'umd',
      libraryExport: 'default',
      umdNamedDefine: true,
      globalObject: 'this'
    },
    externals: {

    },
    module: {
      rules: [
        {
          test: /\.(mp4|flv|swf)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
          loader: 'file-loader',
          options: {
            name: 'video/[name].[hash:7].[ext]'
          }
        }
      ]
    },
    resolve: {
      alias: {
        '@': path.resolve(__dirname, '../src/')
      },
      extensions: ['.js', '.vue']
    },
    plugins: [
    ],
    performance: {
      hints: false,
      maxEntrypointSize: 512000,
      maxAssetSize: 512000
    }
  },
  css: { extract: false },

  lintOnSave: false,
  productionSourceMap: false
}

module.exports = config
