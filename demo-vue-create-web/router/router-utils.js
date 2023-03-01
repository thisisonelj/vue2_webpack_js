import Index from '@/components/router-groups'
import Parent from '@/components/router-groups/parent'
import Son from '@/components/router-groups/son'
import grandSon from '@/components/router-groups/grand-son'
import parentBrother from '@/components/router-groups/parent-brother'
import brotherSon from '@/components/router-groups/brother-son'
import module from '../vuex/vuex-module.vue'
import eventBus from '@/components/event-bus'
import aliveModule from '@/components/keep-alive'
import echartsTable from '@/components/echarts-table'
import webSockets from '@/components/web-sockets'
import renderTree from '@/components/render-tree'
export default {
  Index: Index,
  Parent: Parent,
  Son: Son,
  grandSon: grandSon,
  parentBrother: parentBrother,
  brotherSon: brotherSon,
  module: module,
  eventBus: eventBus,
  aliveModule: aliveModule,
  echartsTable: echartsTable,
  webSockets: webSockets,
  renderTree: renderTree
}
