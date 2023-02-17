<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 100%"
      border
      highlight-current-row
      current-row-key="bankId"
      row-key="bankId"
      height="100%"
    >
      <el-table-column label="银行代码" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.bankId }}</span>
        </template>
      </el-table-column>
      <el-table-column label="银行名称" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.bankName }}</span>
        </template>
      </el-table-column>
      <el-table-column label="银行类型">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.bankType }}</span>
        </template>
      </el-table-column>
      <el-table-column label="上级银行代码">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.parentCode }}</span>
        </template>
      </el-table-column>
      <el-table-column label="上级银行名称">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.parentName }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否末级银行">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.leafCode ? '是':'否' }}</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  props: {
    tableData: []
  },
  data () {
    return {}
  },
  methods: {
    rowDrop () {
      let tbody = document.querySelector('.el-table__body-wrapper tbody')
      let _this = this
      this.$Sortable.create(tbody, {
        onEnd ({ newIndex, oldIndex }) {
          const currRow = _this.tableData.splice(oldIndex, 1)[0]
          _this.tableData.splice(newIndex, 0, currRow)
        }
      })
    }
  },
  mounted () {
    this.rowDrop()
  }
}
</script>
<style lang="less" scoped></style>
