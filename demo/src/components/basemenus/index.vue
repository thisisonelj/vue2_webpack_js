<template>
  <div class="nav-menu-contain">
    <el-breadcrumb separator="|">
      <el-breadcrumb-item v-for="navItem in navList" :key="navItem.id">
        <el-button type="text" @click="handleOperation(navItem)">{{
          navItem.name
        }}</el-button>
      </el-breadcrumb-item>
    </el-breadcrumb>
    <demo-modal
      :operation-name="modalName"
      :modal-status="modalStatus"
      @close-modal="modalStatus = $event.status"
      :demo-form="demoForm"
      :demo-button-id="demoButtonId"
      @demo-table-data="demoTableData=$event.data"
      @demo-table-push="tableDataIncrease=$event.data"
    ></demo-modal>
  </div>
</template>
<script>
/* 页面头部分 */
import demoModal from './basemodal.vue'
export default {
  props: {
    demoForm: {
      type: Array,
      default: function () {
        return []
      }
    }
  },
  name: 'navmenu',
  components: {
    demoModal: demoModal
  },
  data () {
    return {
      navList: [
        { id: 'create', name: '新建' },
        { id: 'query', name: '查询' }
      ],
      navModal: false,
      modalName: '新建弹窗',
      modalStatus: false,
      demoButtonId: 'create',
      demoTableData: [],
      tableDataIncrease: {}
    }
  },
  created () {},
  mounted () {},
  methods: {
    handleOperation ({ id = 'create', name = '新建' } = {}) {
      this.modalName = `${name}弹窗`
      this.modalStatus = true
      this.demoButtonId = id
    }
  },
  watch: {
    'demoTableData': {
      handler: function (value) {
        this.$emit('demo-table-content', {data: value})
      }
    },
    'tableDataIncrease': {
      handler: function (value) {
        this.$emit('table-data-tianjia', { data: value })
      },
      deep: true
    }
  }
}
</script>
<style scoped>
.nav-menu-contain {
  display: -webkit-flex;
  display: flex;
  -webkit-flex-flow: row wrap;
  flex-flow: row wrap;
  font-weight: bold;
  text-align: center;
  width: 100%;
  height: 100%;
  justify-content: flex-start;
  margin-left: 15px;
}
</style>
