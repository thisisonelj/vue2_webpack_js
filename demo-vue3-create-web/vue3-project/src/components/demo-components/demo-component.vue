<template>
  <div class="vue3-demo-main">
    <Split v-model="split">
      <template #left>
        <div class="demo-left-pane">
          <Button type="info" @click="clickFunction1" ref="refBtn">vue3组件状态和缓存</Button>
          <h1 style="">{{ msg.name }}</h1>
          <h2 style="">{{ cacheMsg.name }}</h2>
          <span>vue3组件数据状态ref和computed</span>
          <Button style="width: 50%" @click="clickFunction2" :class="[varyColor]"
            >点击切换按钮颜色</Button
          >
          <template v-for="item in renderList" :key="item.name">
            <Input v-model="item.age" placeholder="Enter something..." style="width: 50%" />
          </template>
          <Select
            v-model="selectValue"
            style="width: 200px"
            @on-change="($event) => clickFunction3($event)"
          >
            <Option
              v-for="item in selectList"
              :value="item.name"
              :key="item.name"
              :label="item.name"
              ref="refList"
              >{{ item.name }}||{{ item.age }}</Option
            >
          </Select>
          <Modal
            v-model="modalStatus"
            :title="modalTitle"
            @on-ok="confirmHandler"
            @on-cancel="cancelHandler"
          >
            <p><span>这是一个iview-plus的弹框</span></p>
          </Modal>
          <Checkbox v-model="checkStatus">Checkbox</Checkbox>
        </div>
      </template>
      <template #right>
        <div class="demo-right-pane">
          <demo-child2 />
          <demo-child4
            id="demoCard"
            style="background-color: blueviolet; border: 1px solid black"
            @click="attrsEvent"
            v-bind="$attrs"
          />
          <demo-child5>
            <template #content="{ slotList }">
              <Input
                placeholder="Enter something..."
                style="width: 10%"
                v-for="item in slotList"
                :key="item.index"
                v-model="item.value"
              />
            </template>
          </demo-child5>
        </div>
      </template>
    </Split>
  </div>
</template>
<script setup>
  import demoChild2 from './demo-component-groups/demo-child2.vue';
  import demoChild4 from './demo-component-groups/demo-child4.vue';
  import demoChild5 from './demo-component-groups/demo-child5.vue';
  import { ref, computed, watch, onMounted, provide } from 'vue';
  let provideValue = ref('这是provide注入');
  provide('message', {
    injectValue: provideValue,
    modifyData: (e) => {
      let param = '注入完成';
      e.value = `${param}`;
    },
  });
  let attrsEvent = () => {
    console.log('这是透传的原生事件属性');
  };
  let refBtn = ref(null);
  let refList = ref([]);
  let split = ref(0.5);
  let msg = ref({ name: 'liu', age: 24 });
  let defaultColor = ref('vue3-btn-color1');
  let btnColor = ref(['vue3-btn-color1', 'vue3-btn-color2']);
  let renderList = ref([
    { name: 'liu', age: 24 },
    { name: 'liu1', age: 24 },
    { name: 'liu2', age: 24 },
  ]);
  let selectList = renderList;
  let selectValue = ref('liu');
  let modalStatus = ref(false);
  let modalTitle = ref('iview-plus弹框');
  let checkStatus = ref(false);
  let cacheMsg = computed(() => {
    return msg.value;
  });
  let varyColor = computed(() => {
    return defaultColor.value;
  });
  let clickFunction1 = () => {
    msg.value = { name: 'liu1', age: 25 };
  };
  let clickFunction2 = () => {
    defaultColor.value = btnColor.value.filter((e) => e !== defaultColor.value)[0];
  };
  let clickFunction3 = (event) => {
    console.log(event);
  };
  let confirmHandler = function () {
    modalStatus.value = false;
  };
  let cancelHandler = function () {
    modalStatus.value = false;
  };
  watch(modalStatus, async function (value) {
    if (value) {
      checkStatus.value = true;
    } else {
      checkStatus.value = false;
    }
  });
  onMounted(() => {
    modalStatus.value = false;
    // console.log(import.meta.env.VITE_SOME_KEY)
    // console.log(__APP_ENV__)
  });
</script>
<style lang="less" scoped>
  .vue3-demo-main {
    width: 100%;
    height: 100%;
  }
  .demo-left-pane {
    width: 100%;
    height: 100%;
    display: inline-flex;
    justify-content: space-between;
    align-items: flex-start;
    flex-flow: row wrap;
    /* align-content: flex-start; */
  }
  .vue3-btn-color1 {
    background-color: red;
  }
  .vue3-btn-color2 {
    background-color: blue;
  }
  .demo-right-pane {
    width: 100%;
    height: 100%;
  }
  .demo-card {
    background-color: blueviolet;
    border: 1px solid black;
  }
</style>
