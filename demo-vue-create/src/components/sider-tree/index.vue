<template>
  <div>
    <Input
      placeholder="Enter something..."
      v-model="inputKeyWords"
    />
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
    ></el-tree>
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
    }
  },
  data () {
    return {
      inputKeyWords: '',
      defaultProps: {
        children: 'children',
        label: 'bankName'
      },
      bankId: 'bankId'
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
    handleNodeClick () {
      this.selectedTreeNode()
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
    }
  },
  mounted () {
    // this.selectedTreeNode()
  },
  created () {

  },
  watch: {
    inputKeyWords: {
      handler: function (val) {
        this.$refs.bank_tree.filter(val)
      }
    },
    treeData: {
      handler: function (val) {
        this.setdefaultSelected(val[0].id)
        this.selectedTreeNode()
      }
    }

  }
}
</script>
<style lang="less" scoped>
@deep:~ ">>>";
.demo-tree {
  margin-top: 10px;
  @{deep} .el-tree-node__expand-icon {
    font-size: 20px;
    color: black;
  }
  @{deep} .el-tree-node__label{
    font-size: 16px;
    color: black;
  }
}
</style>
