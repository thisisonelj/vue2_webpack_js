/**
 * 按钮权限自定义指令
 */
import type { Directive, App } from 'vue';
import { ObjectDirective, ref } from 'vue';
import { storageHanderClass } from '@/utils/storage';
function hasPermission(code: String) {
  let status = ref(false);
  const storageHander = new storageHanderClass();
  const permissions: any[] = storageHander.getStorageInfo('btn-permission') || [];
  if (
    permissions.filter((m) => {
      return m.code == code;
    }).length
  ) {
    status.value = true;
  }
  return status;
}
const btnPermission: ObjectDirective = {
  mounted(el: HTMLButtonElement, binding) {
    if (!binding.value) return;
    const code = binding.value;
    if (!hasPermission(code).value) {
      el.remove();
    }
  },
};
export function setBtnPermission(app: App) {
  app.directive('btnauth', btnPermission);
}
