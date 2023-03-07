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
import css3Components from '@/components/css3-components'
import css3Transition from '@/components/css3-components/css3-transition'
import css3Animation from '@/components/css3-components/css3-animation'
import css3Flex from '@/components/css3-components/css3-flex'
import css3FlexAuto from '@/components/css3-components/css3-flex-auto'
import css3FlexLastRow from '@/components/css3-components/css3-flex-last-row'
import extendComponent from '@/components/extend-problem'
import carouselComponent from '@/components/extend-problem/carousel'
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
  renderTree: renderTree,
  css3Components: css3Components,
  css3Transition: css3Transition,
  css3Animation: css3Animation,
  css3Flex: css3Flex,
  css3FlexAuto: css3FlexAuto,
  css3FlexLastRow: css3FlexLastRow,
  extendComponent: extendComponent,
  carouselComponent: carouselComponent
}
