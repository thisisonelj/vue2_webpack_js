<template>
  <div class="main-index">
    <button-group
      class="demo-button-groups"
      :selected-nodes="selectedNodes"
      @refresh-insert="refreshInsert"
      @refresh-delete="refreshDelete"
      :update-status="updateNodes"
      @refresh-select="refreshSelect"
    ></button-group>
    <div class="demo-split">
      <Split v-model="split1">
        <div slot="left" class="demo-left-pane">
          <sider-tree
            class="demo-sider-tree"
            @tree-selected="getSelectedNode"
            :tree-data="treeData"
            @input-tree="inputTree"
            :ref="'bankTree'"
            @bank-update="bankUpdate"
          ></sider-tree>
        </div>
        <div slot="right" class="demo-right-pane">
          <bank-table
            :table-data="tableData"
            class="demo-right-table"
          ></bank-table>
          <demo-pagation
            class="demo-right-pagation"
            :currentPage="pagationData.currentPage"
            :pageSize="pagationData.pageSize"
            :demoTotal="pagationData.demoTotal"
            @page-size-change="pageSizeChaneg"
            @page-current-change="pageCurrentChange"

          ></demo-pagation>
        </div>
      </Split>
    </div>
    <!-- <router-view></router-view> -->
  </div>
</template>

<script>

import buttonGroups from '@/components/button-groups'
import siderTree from '@/components/sider-tree'
import bankApi from '@/utils/bank_info'
import validMethods from '@/utils/utils'
import bankTable from '@/components/demo-tables'
import demoPagation from '@/components/demo-tables/demo-pagation.vue'
export default {
  name: 'displayPage',
  components: {
    'button-group': buttonGroups,
    'sider-tree': siderTree,
    'bank-table': bankTable,
    'demo-pagation': demoPagation
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
      treeData: [],
      pagationData: {
        currentPage: 1,
        pageSize: 5,
        demoTotal: 0
      },
      tableData: [],
      selectCondition: {},
      updateNodes: {}
    }
  },
  methods: {
    bankUpdate (data) {
      this.updateNodes = data.data
    },
    defaultPageParams (data) {
      this.pagationData.currentPage = 1
      this.pagationData.pageSize = 5
      this.pagationData.demoTotal = data.length
    },
    commonPagation () {
      this.selectCondition = Object.assign(this.selectCondition, this.selectedNodes)
      this.selectCondition.bankPagation = this.pagationData
      bankApi.selectPagation(this.selectCondition).then((data) => {
        if (data.status === 200) {
          this.tableData = data.data
        }
      }).catch((error) => {
        console.log(error)
      })
    },
    pageCurrentChange (data) {
      this.pagationData.currentPage = data.currentPage
      this.commonPagation()
    },
    pageSizeChaneg (data) {
      this.pagationData.pageSize = data.pageSize
      this.commonPagation()
    },
    async queryTable () {
      let res = await bankApi.query_all({}).catch((error) => {
        console.log(error)
      })
      if (res.status === 200) {
        this.defaultPageParams(res.data)
        this.commonPagation()
      }
    },
    queryTree () {
      bankApi
        .query_all({})
        .then((data) => {
          if (data.status === 200) {
            this.treeData = validMethods.arrayToTree(data.data)
            validMethods.traveTree(this.treeData)
          }
        })
        .catch((error) => {
          console.log(error)
        })
    },
    getSelectedNode (data) {
      this.selectedNodes = data
      if (this.selectedNodes.bankId !== 'root') {
        bankApi.selectById(data).then((res) => {
          if (res.status === 200) {
            this.defaultPageParams(res.data)
            this.commonPagation()
          }
        }).catch((error) => {
          console.log(error)
        })
      } else {
        this.queryTable()
      }
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
        let selectedTreeArray = validMethods.treetoArray(selectedTreeData) // 获取选中后的节点数据转为数组
        bankApi
          .delete(selectedTreeArray)
          .then((data) => {
            if (data.status === 200) {
              this.$Message.info({
                background: true,
                content: '删除成功'
              })
              this.queryTree()
            }
          })
          .catch((error) => {
            console.log(error)
          })
      }
    },
    inputTree (data) {
      this.treeData = data
    },
    refreshSelect (data) {
      let ROOT = [{ bankId: 'root', bankName: '全国银行', leafCode: 0, children: [] }]
      let bankTree = validMethods.arrayToTreeNoRoot(data)
      bankTree.forEach(element => {
        ROOT[0].children.push(element)
      })
      this.treeData = ROOT
      validMethods.traveTree(this.treeData)
    }
  },
  created () {
    this.queryTree()
    this.queryTable()
  },
  mounted () {

  }
}
</script>

<style lang="less" scoped>
@deep:~ ">>>";
.main-index {
  overflow: hidden;
  height: 100%;
  & .demo-button-groups {
  }
  & .demo-split {
    height: 100%;
    .demo-left-pane {
      padding: 10px;
      .demo-sider-tree {
      }
    }
    .demo-right-pane {
      padding: 10px;
      padding-left: 13px;
      height: 100%;
      .demo-right-table {
        height: calc(80%);
        @{deep} .el-table {
          height: 100%;
          overflow: auto;
        }
        @{deep} .el-table--border .el-table__cell {
          border: 1px solid #ebeef5;
        }
      }
      .demo-right-pagation {
        float: right;
        margin-top: 20px;
      }
    }
  }
}
</style>
