<template>
  <div class="child-content">
    <div v-for="item in recursionList" :key="item.id">
      <Input v-model="item.name" />
      <recursion-component
        v-if="item.children"
        :recursion-list="item.children"
      ></recursion-component>
    </div>
  </div>
</template>
<script>
import recursionComponent from './recursion.vue'
export default {
  props: {
    recursionList: {
      type: Array,
      default: function () {
        return [
          {
            name: 'liu',
            children: [
              {
                name: 'liu-child'
              }
            ]
          }
        ]
      }
    }
  },
  name: 'recursionComponent',
  components: {
    recursionComponent: recursionComponent
  },
  data () {
    return {
      inputValue: 0
    }
  },
  mounted () {}
}
</script>
<style lang="less" scoped>
.child-content {
}
</style>
