import { createI18n } from 'vue-i18n'
import enLocale from '@/plugins/locale/en'
import zhLocale from '@/plugins/locale/zh'
import { useLocaleStore } from '@/stores/locale'
import type { App } from 'vue'
import pinia from '@/stores/index'
const messages = {
  en: {
    ...enLocale,
  },
  zh_CN: {
    ...zhLocale,
  },
}
const i18n = createI18n({
  legacy: false,
  locale: useLocaleStore(pinia).language,
  globalInjection: true,
  messages,
})
export function setupI18n(app: App) {
  app.use(i18n)
}
