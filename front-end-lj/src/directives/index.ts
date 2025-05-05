import type { App } from 'vue'
import { setBtnPermission } from './btn-power'
export function setGlobalDirectives(app: App) {
  setBtnPermission(app)
}
