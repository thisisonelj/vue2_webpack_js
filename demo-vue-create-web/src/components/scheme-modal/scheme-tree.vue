<template>
  <div>
    <!-- <Input placeholder="Enter something..." v-model="inputKeyWords" /> -->
    <el-tree
      :data="treeData"
      :props="defaultProps"
      @node-click="handleNodeClick"
      class="demo-tree"
      :highlight-current="true"
      default-expand-all
      :ref="'bank_tree'"
      node-key="id"
      :filter-node-method="filterNode"
      :default-checked-keys="['root']"
      @node-contextmenu="displayBankUpdate"
    >
      <span slot-scope="{ node, data }" class="bank-tree-node">
        <span
          style="display: inline-block; width: 100%"
          @mouseenter="buttonEnter(data)"
          @mouseleave="buttonLeave(data)"
        >
          <span>{{ node.label }}</span>
          <span :class="[isdisPlay(data) ? buttonGroup : displayDeney]">
            <el-button type="text" @click.native.stop="schemeUpdate(node, data)" v-if="data.schemeId !== 'root'"
              ><i class="el-icon-circle-check"></i
            ></el-button>
            <el-button type="text" @click.native.stop="schemeInsert(node, data)"
              ><i class="el-icon-circle-plus-outline"></i
            ></el-button>
            <el-button
              type="text"
              @click.native.stop="schemeDelete(node, data)"
              v-if="data.schemeId !== 'root'"
              ><i class="el-icon-remove-outline"></i
            ></el-button>
          </span>
        </span>
      </span>
    </el-tree>
    <Modal v-model="insertModal" :title="title" :z-index="2000" width="360px">
      <Input placeholder="请输入方案名称" v-model="inputValue" />
      <div slot="footer">
        <el-button @click="schemeCancel">取 消</el-button>
        <el-button type="primary" @click="schemeAdd">确 定</el-button>
      </div>
    </Modal>
    <Modal
      v-model="deleteSchemeStatus"
      width="420"
      :closable="false"
      footer-hide
      :z-index="2001"
      class="modal-delete"
    >
      <div style="padding-left: 20px; padding-top: 10px; display: flex">
        <i class="ivu-icon ivu-icon-ios-help-circle import-icon"></i>
        <!-- <Icon type="ios-help-circle-outline" class="import-icon" size="28" /> -->
        <span class="title-notice" style="margin-left: 10px">删除方案</span>
      </div>
      <div style="padding-left: 55px">
        <span>确定要删除方案吗</span>
      </div>
      <div style="padding-left: 220px; margin-top: 30px">
        <Button type="primary" @click="cancelDelete" ghost>取消</Button>
        <Button type="primary" style="margin-left: 10px" @click="deleteScheme"
          >确定</Button
        >
      </div>
    </Modal>
  </div>
</template>
<script>

import commonMethods from '@/utils/utils'
export default {
  props: {
    treeData: {
      type: Array,
      default: function () {
        return []
      }
    },
    insertNodeId: {
      type: String,
      default: ''
    },
    deleteId: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      inputKeyWords: '',
      defaultProps: {
        children: 'children',
        label: 'schemeName'
      },
      bankId: 'bankId',
      buttonGroup: 'button-group',
      displayDeney: 'display-deney',
      insertModal: false,
      inputValue: '',
      currentNode: {}, // 当前已选中的节点
      title: '',
      schemeKey: '',
      deleteSchemeStatus: false
    }
  },
  methods: {
    displayBankUpdate (event, data, node, currentNode) {
      this.$emit('bank-update', node)
    },
    filterNode (value, data) {
      if (!value) return true
      return data.bankName.indexOf(value) !== -1
    },
    handleNodeClick (data, node) {
      this.selectedTreeNode()
      this.$emit('refresh-content', data)
    },
    selectedTreeNode () {
      this.$nextTick(() => {
        let selectedNodes = this.$refs.bank_tree.getCurrentNode()
        this.$emit('tree-selected', selectedNodes)
      })
    },
    setdefaultSelected (data) {
      this.$nextTick(() => {
        this.$refs.bank_tree.setCurrentKey(data, true)
      })
    },
    schemeUpdate (node, data) {
      this.$nextTick(() => {
        this.currentNode = this.$refs.bank_tree.getCurrentNode()
      })
      this.schemeKey = 'update'
      this.title = '更新方案并保存'
      this.insertModal = true
    },
    schemeInsert (node, data) {
      this.$nextTick(() => {
        this.currentNode = this.$refs.bank_tree.getCurrentNode()
      })
      this.schemeKey = 'create'
      this.title = '添加方案并保存'
      this.insertModal = true
    },
    schemeDelete (node, data) {
      this.deleteSchemeStatus = true
    },
    buttonEnter (data) {
      data.displayStatus = true
    },
    buttonLeave (data) {
      data.displayStatus = false
    },
    isdisPlay (data) {
      return data.displayStatus
    },
    schemeAdd () {
      if (this.schemeKey === 'create') {
        this.$emit('insert-info', {
          parentNode: this.currentNode,
          schemeName: this.inputValue
        })
      }
      if (this.schemeKey === 'update') {
        this.$emit('update-info', {
          parentNode: this.currentNode,
          schemeName: this.inputValue
        })
      }
      this.insertModal = false
    },
    schemeCancel () {
      this.insertModal = false
    },
    cancelDelete () {
      this.deleteSchemeStatus = false
    },
    deleteScheme () {
      let selectedTreeData = []
      selectedTreeData.push(this.$refs.bank_tree.getCurrentNode())
      let selectedTreeArray = commonMethods.treetoArray(selectedTreeData) // 获取选中后的节点数据转为数组
      this.$emit('delete-info', selectedTreeArray)
      this.deleteSchemeStatus = false
    }
  },
  computed: {

  },
  mounted () {
    this.setdefaultSelected('root')
    this.selectedTreeNode()
  },
  created () {},
  watch: {
    inputKeyWords: {
      handler: function (val) {
        this.$refs.bank_tree.filter(val)
      }
    },
    treeData: {
      handler: function (val) {}
    },
    insertNodeId: {
      handler: function (val) {
        setTimeout(() => {
          this.$refs.bank_tree.setCurrentKey(val, true)
        }, 500)
      },
      immediate: true
    }

  }
}
</script>
<style lang="less" scoped>
@deep:~ ">>>";
.modal-delete {
  & @{deep} .ivu-modal{
    top:30%;
  }
  .title-notice {
    font: bold;
    font-size: 15px;
  }
  .import-icon {
    color: #f90;
    font-size: 28px;
  }
}

.display-info {
  display: inline-block;
}
.display-deney {
  display: none;
}
.demo-tree {
  margin-top: 10px;
  @{deep} .el-tree-node__expand-icon {
    font-size: 20px;
    color: black;
  }
  @{deep} .el-tree-node__label {
    font-size: 16px;
    color: black;
  }
  .bank-tree-node {
    width: 100%;
    display: inline-block;
    .button-group {
      display: inline-block;
      width: calc(100% - 40px);
      text-align: right;

      .el-icon-circle-plus-outline {
        vertical-align: middle;
        font-size: 20px;
      }
      .el-icon-remove-outline {
        vertical-align: middle;
        font-size: 20px;
      }
      .el-icon-circle-check {
        vertical-align: middle;
        font-size: 20px;
      }
      @{deep} .el-button:last-child {
        margin-right: 10%;
      }
    }
  }
}
</style>
