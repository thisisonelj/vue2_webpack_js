<template>
  <div class="top-main-toolbar">
    <el-breadcrumb separator="|" class="page-top-crumb" v-if="displayTopPage">
      <el-breadcrumb-item
        ><div class="crumb-insert" @click="insertInfo">
          增加
        </div></el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><div class="crumb-delete" @click="deleteInfo">
          删除
        </div></el-breadcrumb-item
      >
    </el-breadcrumb>
    <div @click="displayExpandInfo" v-if="!displayTopPage" class="expand-icon">
      <i class="el-icon-caret-bottom"></i><span>收缩状态</span>
    </div>
    <div @click="displayShrinkInfo" v-if="displayTopPage" class="shrink-icon">
      <i class="el-icon-caret-top"></i><span>展开状态</span>
    </div>
    <modal-insert :demo-form="modalForm" :modal-status="modalStatus" @cancel-insert="modalStatus=$event.modalStatus" @confirm-insert="confirmInsert" :selected-nodes="selectedNodes"></modal-insert>
    <modal-update :demo-form="modalUpdateForm" :injust-status="injustStatus" @cancel-update="injustStatus=$event.modalStatus" @confirm-update="confirmUpdate" :selected-nodes="selectedNodes" :update-data="updateStatus"></modal-update>
  </div>
</template>
<script>
import bankApi from '@/utils/bank_info'
import modalInsert from './modal-top'
import modalUpdate from './model-update.vue'
export default {
  props: {
    selectedNodes: {
      type: Object,
      default: function () {
        return {}
      }
    },
    updateStatus: {}
  },
  components: {
    modalInsert: modalInsert,
    modalUpdate: modalUpdate
  },
  data () {
    return {
      statusVaryList: ['展开', '收缩'],
      statusVary: '展开',
      displayTopPage: true,
      modalForm: [{
        type: 'input',
        prop: 'bankName',
        label: '银行名称'
      },
      {
        type: 'select',
        prop: 'bankType',
        label: '银行类型'
      },
      {
        type: 'pretype',
        prop: 'parentCode',
        label: '上级银行',
        content: ['名称', '代码']
      },
      {
        type: 'radio',
        prop: 'leafCode',
        label: '是否为末级银行'
      }],
      modalUpdateForm: [{
        type: 'input',
        prop: 'bankName',
        label: '银行名称'
      },
      {
        type: 'select',
        prop: 'bankType',
        label: '银行类型'
      },
      {
        type: 'pretype',
        prop: 'parentCode',
        label: '上级银行',
        content: ['名称', '代码']
      }
      ],
      modalStatus: false,
      refresh: false,
      injustStatus: false,
      updateData: {}
    }
  },
  methods: {
    modifySelectedTree () {
      if (!this.selectedNodes) {
        this.$Message.warning({
          background: true,
          content: '银行节点未选中'
        })
        return false
      }
      return true
    },
    /*
    增加按钮事件
    */
    insertInfo () {
      if (this.modifySelectedTree()) this.modalStatus = true
      else this.modalStatus = false
    },
    /*
    查询按钮事件
    */
    selectInfo () { },
    deleteInfo () {
      if (this.modifySelectedTree()) {
        this.$emit('refresh-delete', { showTreeData: true })
      }
    },
    displayExpandInfo () {
      this.displayTopPage = true
    },
    displayShrinkInfo () {
      this.displayTopPage = false
    },
    confirmInsert (data) {
      this.modalStatus = data.modalStatus
      if (data.showTreeData) {
        this.refresh = data.showTreeData
        this.$emit('refresh-insert', this.refresh)
      }
    },
    confirmUpdate (data) {
      this.injustStatus = data.modalStatus
      if (data.showTreeData) {
        this.refresh = data.showTreeData
        this.$emit('refresh-insert', this.refresh)
      }
    }
  },
  created () {},
  mounted () {

  },
  computed: {

  },
  watch: {
    updateStatus: {
      handler: function (val) {
        this.injustStatus = true
      },
      deep: true
    }
  },
  beforeDestroy () {}
}
</script>
<style lang="less" scoped>
@insert-color: blue;
@select-color: #409eff;
@status-color: green;
@delete-color:red;
@insert-hover-color: yellow;
@select-hover-color: yellow;
@status-hover-color: yellow;
@base-color:#fff;
@deep:~ ">>>";
.top-main-toolbar {
  .page-top-crumb {
    @img-url: "../../assets/sea.jpg";
    padding: 5px;
    font-size: 16px;
    line-height: 2;
    background-image: url("@{img-url}");
    & .crumb-insert {
      cursor: pointer;
      display: inline-block;
      color: @insert-color;
      &:active {
        background-color: @insert-hover-color;
      }
    }
    & .crumb-select {
      cursor: pointer;
      display: inline-block;
      color: @select-color;
      &:active {
        background-color: @select-hover-color;
      }
    }
    & .crumb-delete{
      cursor: pointer;
      display: inline-block;
      color: @delete-color;
      &:active {
        background-color: @select-hover-color;
      }

    }

    & .crumb-status {
      cursor: pointer;
      display: inline-block;
      color: @status-color;
      &:active {
        background-color: @status-hover-color;
      }
    }
    & @{deep} .el-breadcrumb__separator {
      margin: 0 9px;
      font-weight: 700;
      color: black;
    }
  }
  & .expand-icon,.shrink-icon {
    background-color: #d3dce6;
    text-align: center;
    margin-top: -1px;
    color: #d3dce6;
    cursor: pointer;
    &:hover{
        color:#409eff
     }
    span{
        margin-left: 10px;
        font-size: 14px;
    }
    .el-icon-caret-bottom {
      vertical-align: middle;
      font-size: 20px;
      line-height: 2;
      color:black;
      cursor: pointer;
       &:hover{
        color:#409eff
       }
    }
    .el-icon-caret-top {
      vertical-align: middle;
      font-size: 20px;
      line-height: 2;
      color:black;
      cursor: pointer;
      &:hover{
        color:#409eff
       }
    }
  }
}
</style>
