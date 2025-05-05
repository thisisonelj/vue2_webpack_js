<template>
  <div class="header-container">
    <div class="top">
      <div v-for="(item, index) in displayTypes" :key="index">
        <div v-if="item.id == SETTING.BUTTON">
          <button-info :origin-data-info="item"></button-info>
        </div>
      </div>
      <div>
        <el-dropdown trigger="click" @command="handleSetLanguage">
          <div>
            国际化
            <el-icon class="el-icon--right">
              <arrow-down />
            </el-icon>
          </div>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item :command="localeGroups.ZH_CN" :disabled="language === 'zh_CN'"
                >中文</el-dropdown-item
              >
              <el-dropdown-item :command="localeGroups.EN_US" :disabled="language === 'en'"
                >English</el-dropdown-item
              >
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
    <el-divider style="margin: 0" />
  </div>
</template>
<script setup lang="ts">
import { SETTING } from '@/enums/display-setting'
import { useLocaleStore } from '@/stores/locale'
import { computed, ref } from 'vue'
import buttonInfo from '../button.vue'
import { locale } from '@/enums/locale'
import { ArrowDown } from '@element-plus/icons-vue'
import { useI18n } from 'vue-i18n'
const i18n = useI18n()
const localeGroups = ref(locale)
const displayGroups = defineProps<{
  displayTypes: Array<any>
}>()
let language = computed(() => {
  return useLocaleStore().language
})
function handleSetLanguage(lang: any) {
  useLocaleStore().messageChange(lang)
  i18n.locale.value = lang
}
</script>
<style lang="scss" scoped>
.header-container {
  .top {
    padding: 20px;
    display: flex;
    justify-content: space-around;
  }
}
</style>
