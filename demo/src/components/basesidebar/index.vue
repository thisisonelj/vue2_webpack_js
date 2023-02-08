<template>
  <div style="height:100%;width:100%">
    <base-input style="height:20%;padding-top: 20px;" :search-content="sidebarData.searchContent" @tree-selected="treeselected"></base-input>
    <base-tree style="height:80%;" :tree-data="sidebarData.TreeData"></base-tree>
  </div>
</template>
<script>
/* 这是侧边栏部分 */
import baseTree from '@/components/basetrees'
import baseInput from '@/components/basesidebar/baseinput.vue'
export default {
  props: {
    sidebarData: {
      type: Object,
      default: function () {
        return {}
      }
    }
  },
  name: 'siderPart',
  components: {
    baseTree: baseTree,
    baseInput: baseInput
  },
  data () {
    return {}
  },
  methods:
  {
    treeselected (value) {
      this.$emit('demo-selected-tree', {data: value.data})
    }

  }
}
</script>
<style scoped></style>
