<template>
  <div class="flex-container">
    <div class="flex-header">
      <demo-nav-menu
        style="height:95%"
        :demo-form="demoForm"
        @demo-table-content="respTableEvent($event)"
        @table-data-tianjia="tableDataTianjia($event)"
      >
      </demo-nav-menu>
      <el-divider
        direction="horizontal"
        class="demo-divider-horizontal"
      ></el-divider>
    </div>
    <div class="flex-main">
      <div class="flex-main-asideitem">
        <div class="asideitem-sub-item">
          <base-sidebar
            :sidebar-data="sidebarData"
            @demo-selected-tree="demoSelected"
          ></base-sidebar>
        </div>
      </div>
      <el-divider
        direction="vertical"
        class="demo-divider-vertical"
      ></el-divider>
      <div class="flex-main-contentitem">
        <div class="contentitem-top-part">
          <default-message
            :display-info="contentMainData.displayInfo"
          ></default-message>
        </div>
        <div class="contentitem-main-part">
          <base-table :table-data="contentMainData.tableData" @demo-table-delete="tableRemove"></base-table>
        </div>
      </div>
    </div>
    <div class="flex-footer">
      <base-pagation
        :current-page="pagationData.currentPage"
        :page-size="pagationData.pageSize"
        :demo-total="pagationData.toTal"
        @page-size-change="pageSizeChange"
        @page-current-change="pageCurrentChange"
      ></base-pagation>
    </div>
  </div>
</template>
<script>
/* demo主页面 */
import demoNavMenu from '@/components/basemenus'
import baseSidebar from '@/components/basesidebar'
import defaultMessage from '@/components/basetables/defaultmessage.vue'
import baseTable from '@/components/basetables'
import basePagation from '@/components/basepagation'
import shopApi from '../../utils/demo-shop-api/shop-api'
export default {
  name: 'demoTrain',
  components: {
    demoNavMenu: demoNavMenu,
    baseSidebar: baseSidebar,
    defaultMessage: defaultMessage,
    baseTable: baseTable,
    basePagation: basePagation
  },
  created () {
    // debugger
    this.tableQueryInfo() // 初始化页面表格中心部分数据
  },
  mounted () {},
  data () {
    return {
      pagationData: {
        currentPage: 1,
        pageSize: 10,
        toTal: 0
      },
      sidebarData: {
        searchContent: '',
        TreeData: []
      },
      contentMainData: {
        displayInfo: {},
        tableData: []
      },
      demoForm: [
        {
          type: 'number',
          label: '标识：',
          prop: 'userId'
        },
        {
          type: 'input',
          label: '名称：',
          prop: 'name'
        },
        {
          type: 'select',
          label: '年龄：',
          prop: 'age'
        },
        {
          type: 'radio',
          label: '性别：',
          prop: 'sex'
        },
        {
          type: 'datepicker',
          label: '日期：',
          prop: 'shopDate'
        }
      ],
      treeDateConst: []
    }
  },
  methods: {
    pageSizeChange ({ pageSize = 10 } = {}) {},
    pageCurrentChange ({ currentPage = 1 } = {}) {},
    tableDataFormat (respResults) {
      this.contentMainData.tableData = respResults.data.map(item => {
        item.sex = item.sex === false ? '男' : '女'
        item.shopDate = this.$XeUtils.toDateString(
          item.shopDate,
          'yyyy-MM-dd HH:mm:ss'
        )
        return item
      })
      let messageData = {}
      this.$set(
        messageData,
        'name',
        respResults.data.length === 0 ? '' : respResults.data[0].name
      )
      this.$set(
        messageData,
        'goodName',
        respResults.data.length === 0 ? '' : respResults.data[0].goodName
      )
      this.$set(
        messageData,
        'storeName',
        respResults.data.length === 0 ? '' : respResults.data[0].storeName
      )
      this.contentMainData.displayInfo = messageData
    },
    formatArrayTree (treeList) {
      let finalTree = []
      if (Array.isArray(treeList)) {
        // eslint-disable-next-line standard/object-curly-even-spacing
        let root = { id: 'root', title: '用户', name: '用户', leaf: false }
        finalTree.push(root)
        let secodeList = []
        let thirdList = []
        treeList.forEach(element => {
          secodeList.push({
            id: element.userId,
            name: element.name,
            userId: element.userId,
            age: element.age,
            sex: element.sex,
            shopDate: element.shopDate,
            title: element.name,
            parentId: root.id,
            leaf: true
          })
          // thirdList.push({
          //   id: `${element.storeId}`,
          //   parentId: element.userId,
          //   name: element.storeName,
          //   storeId: element.storeId,
          //   storeName: element.storeName,
          //   leaf: true
          // })
        })
        let TreeList = finalTree.concat(secodeList, thirdList)
        this.sidebarData.TreeData = this.$XeUtils.toArrayTree(TreeList, {
          data: 'data'
        })
        this.treeDateConst = this.$XeUtils.toArrayTree(TreeList, {
          data: 'data'
        })
      }
    },
    async tableQueryInfo () {
      let respResults = await shopApi.query({}).catch(error => {
        console.log(error)
      })
      if (respResults.status === 200) {
        this.tableDataFormat(respResults)
        this.formatArrayTree(respResults.data)
      }
    },
    respTableEvent (event) {
      this.tableDataFormat(event)
    },
    tableDataTianjia (event) {
      this.contentMainData.tableData.push(event.data)
      let messageData = {}
      this.$set(
        messageData,
        'name',
        this.contentMainData.tableData.length === 0
          ? ''
          : this.contentMainData.tableData[0].name
      )
      this.$set(
        messageData,
        'goodName',
        this.contentMainData.tableData.length === 0
          ? ''
          : this.contentMainData.tableData[0].goodName
      )
      this.$set(
        messageData,
        'storeName',
        this.contentMainData.tableData.length === 0
          ? ''
          : this.contentMainData.tableData[0].storeName
      )
      this.contentMainData.displayInfo = messageData
    },
    demoSelected (value) {
      this.sidebarData.searchContent = value.data
      if (this.sidebarData.searchContent) {
        this.sidebarData.TreeData =
          this.$XeUtils.filterTree(
            this.sidebarData.TreeData,
            item => item.id === Number(value.data)
          )
        if (value.data === 'root') {
          this.sidebarData.TreeData = this.treeDateConst
        }
      } else {
        this.sidebarData.TreeData = this.treeDateConst
      }
    },
    tableRemove (value) {
      this.contentMainData.tableData.splice(value.data, 1)
    }
  },
  computed: {},
  watch: {
    data (newValue, oldValue) {}
  },
  beforeDestroy () {}
}
</script>
<style scoped lang="less">
.flex-container {
  display: -webkit-flex;
  display: flex;
  -webkit-flex-flow: row wrap;
  flex-flow: row wrap;
  font-weight: bold;
  text-align: center;
  width: 100%;
  height: 100%;
  overflow-x: hidden;
  overflow-y: hidden;
}
.flex-header {
  width: 100%;
  height: 6%;
}
.flex-footer {
  width: 100%;
  height: 8%;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding-right: 15px;
}
.flex-main {
  width: 100%;
  height: 86%;
  display: flex;
  flex-flow: row wrap;
  justify-content: flex-start;
}
.flex-main-asideitem {
  height: 100%;
  width: 20%;
  flex: 1;
}
.flex-main-contentitem {
  height: 100%;
  width: 80%;
  flex: 4;
}
.demo-divider-vertical {
  height: 100%;
  margin: 0 8px;
  background-color: cadetblue;
  border-left: 5px solid;
  position: relative;
}
.demo-divider-horizontal {
  width: 100%;
  margin: 0 0;
  background-color: cadetblue;
  border-top: 5px solid;
  position: relative;
  height: 5%;
}
.asideitem-sub-item {
  display: -webkit-flex;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 100%;
  height: 100%;
}
.contentitem-top-part {
  width: 100%;
  height: 20%;
}
.contentitem-main-part {
  width: 100%;
  height: 80%;
}
</style>
