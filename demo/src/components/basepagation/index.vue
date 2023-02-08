<template>
  <div>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10,20,30,50]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="demoTotal"
      >
      </el-pagination>
    </div>
  </div>
</template>
<script>
/* 这是分页组件 */
export default {
  props: {
    currentPage: {
      type: Number,
      default: 1
    },
    pageSize: {
      type: Number,
      default: 10
    },
    demoTotal: {
      type: Number,
      default: 0
    }
  },
  data () {
    return {}
  },
  methods: {
    handleSizeChange (pageSize) {
      this.$emit('page-size-change', {'pageSize': pageSize})
    },
    handleCurrentChange (currentPage) {
      this.$emit('page-current-change', {'currentPage': currentPage})
    }
  }
}
</script>
<style scoped>
/deep/ .el-pagination span:not([class*=suffix]){
    font-size: 16px !important;
}
/deep/ .el-pagination__sizes .el-input .el-input__inner{
     font-size: 16px !important;
}
/deep/ .el-pagination .btn-prev .el-icon{
     font-size: 16px !important;
}
/deep/ .el-pager li {
     font-size: 16px !important;
}
/deep/ .el-pagination .btn-next .el-icon{
     font-size: 16px !important;
}

/deep/ .el-pagination__editor.el-input .el-input__inner{
     font-size: 16px !important;
}
</style>
