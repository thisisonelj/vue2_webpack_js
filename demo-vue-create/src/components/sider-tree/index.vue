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
      node-key="bankId"
      :filter-node-method="filterNode"
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
      }
    }
  },
  methods: {
    filterNode (value, data) {
      if (!value) return true
      return data.bankName.indexOf(value) !== -1
    },
    handleNodeClick () {
      this.selectedTreeNode()
    },
    selectedTreeNode () {
      let selectedNodes = this.$refs.bank_tree.getCurrentNode()
      this.$nextTick(() => {
        this.$emit('tree-selected', selectedNodes)
      })
    }
  },
  mounted () {
    this.selectedTreeNode()
  },
  created () {

  },
  watch: {
    inputKeyWords: {
      handler: function (val) {
        this.$refs.bank_tree.filter(val)
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
