<template>
  <div>
    <el-input
      placeholder="请输入内容"
      prefix-icon="el-icon-search"
      v-model="searchContent"
      @change="focusRespond"
    >
    </el-input>
  </div>
</template>
<script>
export default {
  props: {
    searchContent: {
      type: String,
      default: ''
    }
  },
  data () {
    return {

    }
  },
  methods: {
    focusRespond (value) {
      this.$emit('tree-selected', {data: value})
    }
  },
  created () {

  }
}
</script>
<style scoped></style>
