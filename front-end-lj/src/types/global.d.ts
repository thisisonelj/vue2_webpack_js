/* eslint-disable @typescript-eslint/no-explicit-any */
declare const __VITE_APP_PROXY__: 'true' | 'false'

declare namespace JSX {
  interface IntrinsicElements {
    template: any
    block: any
  }
}

declare type Nullable<T> = T | null
declare type NonNullable<T> = T extends null | undefined ? never : T
declare type Recordable<T = any> = Record<string, T>
declare type ReadonlyRecordable<T = any> = {
  readonly [key: string]: T
}
