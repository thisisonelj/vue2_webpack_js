<template>
  <div style="width: 100%;height: calc(100%);">
    <el-table :data="tableData" style="width: 100%;overflow:auto;" height="calc(100%)" border row-key="id">
      <el-table-column fixed prop="userId" label="用户标识" width="150">
      </el-table-column>
      <el-table-column prop="name" label="用户名称" width="150"> </el-table-column>
      <el-table-column prop="shopDate" label="购物日期" width="150">
      </el-table-column>
      <el-table-column prop="sex" label="性别" width="150"> </el-table-column>
      <el-table-column prop="goodName" label="商品名称" width="150">
      </el-table-column>
      <el-table-column prop="storeName" label="商店名称" width="150"> </el-table-column>
      <el-table-column label="操作" fixed="right" align="center" width="200">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
/* 这是表格部分 */
import shopApi from '../../utils/demo-shop-api/shop-api'
export default {
  props: {
    tableData: {
      type: Array,
      default: function () {
        return []
      }
    }
  },
  name: 'demo-table',
  data () {
    return {

    }
  },
  methods: {
    handleEdit ([index, row] = []) {

    },
    async handleDelete (index, row) {
      delete row.sex
      delete row.shopDate
      let respResults = await shopApi.delete(row).catch((error) => {
        console.log(error)
      })
      this.$emit('demo-table-delete', { data: index })
      if (respResults.status === 200) {
        this.$message({
          message: '删除成功',
          type: 'success'
        })
      } else {
        this.$message.error('删除失败')
      }
    }
  }
}
</script>
<style scoped></style>
