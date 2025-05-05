/**
 * 国际化store
 */
import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { locale } from '@/enums/locale'
export const useLocaleStore = defineStore('locale-info', {
  state: () => ({
    language: locale.EN_US,
  }),
  actions: {
    messageChange(type: locale) {
      this.language = type
    },
  },
})
