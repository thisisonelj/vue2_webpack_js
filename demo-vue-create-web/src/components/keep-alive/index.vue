<template>
  <div class="flex-main">
    <i-switch
      v-model="control"
      style="transform: translate(87%, -500%)"
    ></i-switch>
    <keep-alive include="leftComponent">
      <component :is="finalValue"></component>
    </keep-alive>
  </div>
</template>
<script>
import leftComponent from './left-component.vue'
import rightComponent from './right-component.vue'
export default {
  data () {
    return {
      left: leftComponent,
      right: rightComponent,
      control: false
    }
  },
  components: {
    leftComponent: leftComponent,
    rightComponent: rightComponent
  },
  computed: {
    finalValue: function () {
      if (this.control) {
        return this.left
      } else {
        return this.right
      }
    }
  }
}
</script>
<style lang="less" scoped>
.flex-main {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}
</style>
