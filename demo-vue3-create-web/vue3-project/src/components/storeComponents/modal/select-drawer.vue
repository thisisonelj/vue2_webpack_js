<template>
  <div class="ts-drawer">
    <el-drawer
      v-model="drawerVisible"
      :title="drawerTile"
      :direction="drawDirection"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      :show-close="false"
      class="content"
    >
      <template #default>
        <div>
          <el-form :model="formData" ref="drawerRef">
            <el-form-item
              :label-width="item.width"
              v-for="item in drawerList"
              :key="item.key"
              :label="item.label"
              :prop="item.prop"
            >
              <el-select
                v-model="formData[item.key]"
                placeholder="请选择"
                v-if="item.type === 'select'"
                multiple
              >
                <el-option
                  v-for="element in item.selectList"
                  :key="element.value"
                  :label="element.label"
                  :value="element.value"
                >
                  <span style="float: left">{{ element.label }}</span>
                  <span
                    style="float: right; color: var(--el-text-color-secondary); font-size: 13px"
                    >{{ element.value }}</span
                  >
                </el-option>
              </el-select>
              <div class="form-date" v-if="item.type === 'datetime'">
                <el-date-picker
                  v-model="formData[item.content.startTime.key]"
                  :type="item.type"
                  :placeholder="item.placeholder"
                  v-if="item.type === 'datetime'"
                />
                <el-date-picker
                  v-model="formData[item.content.endTime.key]"
                  :type="item.type"
                  :placeholder="item.placeholder"
                  v-if="item.type === 'datetime'"
                  style="margin-left: 5%"
                />
              </div>
            </el-form-item>
          </el-form>
        </div>
      </template>
      <template #footer>
        <div style="flex: auto">
          <el-button @click="cancelClick">{{ btns.cancel }}</el-button>
          <el-button type="primary" @click="confirmClick">{{ btns.confirm }}</el-button>
        </div>
      </template>
    </el-drawer>
  </div>
</template>
<script lang="ts" setup>
  import { ref, computed, watch, onMounted, provide, reactive, getCurrentInstance } from 'vue';
  import { ElMessageBox } from 'element-plus';
  interface Props {
    modalStatus: boolean;
    drawerList: any[];
    [propName: string]: any;
  }
  interface formType {
    storeId?: any[];
    createTime?: Date;
    [propName: string]: any;
  }
  enum btnGroups {
    confirm = '确定',
    cancel = '取消',
  }
  let drawerTile = ref('查询店铺弹窗');
  let drawDirection = ref('ttb');
  const btns = ref(btnGroups);
  const Xeutils = getCurrentInstance().appContext.config.globalProperties.$Xeutils;
  let formData = ref<formType>({
    storeId: [],
    startTime: Xeutils.toDateString(new Date(), 'yyyy-MM-dd HH:mm:ss'),
    endTime: Xeutils.toDateString(new Date(), 'yyyy-MM-dd HH:mm:ss'),
  });
  let drawerVisible = computed(() => {
    return props.modalStatus;
  });
  const emit = defineEmits<{
    (e: 'confirm-select-opration', data: {}): void;
    (e: 'cancel-select-operation', data: {}): void;
  }>();
  const props = withDefaults(defineProps<Props>(), {
    modalStatus: false,
    drawerList: () => [],
  });
  let cancelClick = () => {
    emit('cancel-select-operation', { drawerStatus: false });
  };
  let confirmClick = () => {
    emit('confirm-select-opration', { drawerStatus: false });
  };
</script>
<style lang="less" scoped>
  .ts-drawer {
    :deep(.el-drawer) {
      width: 50%;
      transform: translateX(50%);
      height: auto !important;
    }
    :deep(.el-select) {
      width: 100%;
    }
    :deep(.el-date-editor.el-input) {
      width: 45%;
    }
    .form-date {
      width: 100%;
    }
  }
</style>
