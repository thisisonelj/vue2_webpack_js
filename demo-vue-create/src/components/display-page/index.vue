<template>
  <div class="main-index">
    <button-group class="demo-button-groups" :selected-nodes="selectedNodes" @refresh-insert="refreshInsert" @refresh-delete="refreshDelete"></button-group>
    <div class="demo-split">
      <Split v-model="split1">
        <div slot="left" class="demo-left-pane">
        <sider-tree class="demo-sider-tree" @tree-selected="getSelectedNode" :tree-data="treeData" @input-tree="inputTree"></sider-tree>
        </div>
        <div slot="right" class="demo-right-pane"></div>
      </Split>
    </div>
  </div>
</template>

<script>
import buttonGroups from '@/components/button-groups'
import siderTree from '@/components/sider-tree'
import bankApi from '@/utils/bank_info'
import validMethods from '@/utils/utils'
export default {
  name: 'displayPage',
  components: {
    'button-group': buttonGroups,
    'sider-tree': siderTree
  },
  props: {
    msg: {
      type: String,
      default: '这是主页'
    }
  },
  data () {
    return {
      split1: 0.2,
      selectedNodes: {},
      treeData: []
    }
  },
  methods: {
    queryTree () {
      bankApi.query_all({}).then((data) => {
        if (data.status === 200) {
          this.treeData = validMethods.arrayToTree(data.data)
          validMethods.traveTree(this.treeData)
        }
      }).catch((error) => {
        console.log(error)
      })
    },
    getSelectedNode (data) {
      this.selectedNodes = data
    },
    refreshInsert (data) {
      if (data) {
        this.queryTree()
      }
    },
    refreshDelete (data) {
      if (data) {
        if (this.selectedNodes.bankId === 'root') {
          this.$Message.warning({
            background: true,
            content: '不能删除根节点'
          })
          return
        }
        let selectedTreeData = []
        selectedTreeData.push(this.selectedNodes)
        let selectedTreeArray = validMethods.treetoArray(selectedTreeData)// 获取选中后的节点数据转为数组
        bankApi.delete(selectedTreeArray).then((data) => {
          if (data.status === 200) {
            this.$Message.info({
              background: true,
              content: '删除成功'
            })
            this.queryTree()
          }
        }).catch((error) => {
          console.log(error)
        })
      }
    },
    inputTree (data) {
      this.treeData = data
    }

  },
  created () {
    this.queryTree()
  }
}
</script>

<style lang="less" scoped>
.main-index {
  overflow: hidden;
  height: 100%;
  & .demo-button-groups {

  }
  & .demo-split {
       height: 100%;
    .demo-left-pane {
      padding: 10px;
      .demo-sider-tree{

      }
    }
    .demo-right-pane{

    }
  }
}
</style>
