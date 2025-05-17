/// <reference types="vite/client" />

declare module '*.vue' {
  import { DefineComponent } from 'vue'
  // eslint-disable-next-line @typescript-eslint/no-empty-object-type, @typescript-eslint/no-explicit-any
  const component: DefineComponent<{}, {}, any>
  export default component
}
interface ImportMetaEnv {
  /** 网站标题，应用名称 */
  readonly VITE_APP_TITLE: string
  /**app ID标识 */
  readonly VITE_APP_ID: string
  /** 服务端口号 */
  readonly VITE_SERVER_PORT: number
  /** 后台接口地址 */
  readonly VITE_SERVER_BASEURL: string
  /** 上传图片地址 */
  readonly VITE_UPLOAD_BASEURL: string
  /** 是否清除console */
  readonly VITE_DELETE_CONSOLE: string
  /** 是否开启mock */
  readonly VITE_USE_MOCK: 'true' | 'false'
  // 更多环境变量...
}

interface ImportMeta {
  readonly env: ImportMetaEnv
}
