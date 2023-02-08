<template>
  <div class="demo-base-tree">
    <el-tree
      ref="demo-base-tree"
      :data="treeData"
      node-key="id"
      default-expand-all
      :expand-on-click-node="false"
      :highlight-current="true"
      :props="{ children: 'children',label: 'title' }"
      @node-click="nodehandle"
      :check-strictly="true"
      :show-checkbox="true"
      @check-change="datachange"
    >
      <span slot-scope="{ node, data }">
        <span class="schemeNode">
          <span style="vertical-align: middle;">
            <i v-if="data.leaf" class="el-icon-suitcase"></i>
            <i v-else class="el-icon-suitcase-1"></i>
            {{ data.id}}
          </span>
        </span>
      </span>
    </el-tree>
  </div>
</template>
<script>
/* 树形部分 */
export default {
  props: {
    treeData: {
      type: Array,
      default: function () {
        return []
      }
    }
  },
  name: 'siderbarTree',
  data () {
    return {
      templateData: [
        {
          id: 1,
          label: '一级 2',
          children: [
            {
              id: 3,
              label: '二级 2-1',
              children: [
                {
                  id: 4,
                  label: '三级 3-1-1'
                },
                {
                  id: 5,
                  label: '三级 3-1-2',
                  disabled: true
                }
              ]
            },
            {
              id: 2,
              label: '二级 2-2',
              disabled: true,
              children: [
                {
                  id: 6,
                  label: '三级 3-2-1'
                },
                {
                  id: 7,
                  label: '三级 3-2-2',
                  disabled: true
                }
              ]
            }
          ]
        }
      ]
    }
  },
  methods: {
    nodehandle () {

    },
    datachange () {

    }

  },
  computed: {

  },
  created () {

  },
  mounted () {

  },
  watch: {

  }
}
</script>
<style scoped>
.schemeNode {
  display: inline-block;
  width: 100%;
}
.demo-base-tree{

}
</style>
