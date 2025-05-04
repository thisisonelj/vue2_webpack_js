/**
 * 测试hooks
 */
import { ref, onMounted, watch, computed } from 'vue'

//监听loading
export function btnToLoading(data: ref<any[]>) {
  let loading = ref(false)
  function changeLoad() {
    loading.value = true
  }
  watch(data, (val) => {
    changeLoad()
  })
  return { loading, changeLoad }
}
