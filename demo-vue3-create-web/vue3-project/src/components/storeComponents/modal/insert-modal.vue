<template>
  <div>
    <el-dialog
      v-model="dialogFormVisible"
      :title="insertTitle"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
    >
      <el-form :model="formData" :rules="formRules" ref="ruleFormRef">
        <el-form-item
          :label-width="item.width"
          v-for="item in formList"
          :key="item.key"
          :label="item.label"
          :prop="item.prop"
        >
          <el-input
            v-model="formData[item.key]"
            :placeholder="item.placeholder"
            v-if="item.type === 'input'"
          >
            <template #append v-if="item.key === 'storeId' || item.key === 'goodId'">
              <el-select
                :value="selectValues[item.key]"
                placeholder="请选择"
                :style="{ width: '200px' }"
                @change="selectChange($event, item.key)"
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
            </template>
          </el-input>
          <el-date-picker
            v-model="formData[item.key]"
            :type="item.type"
            :placeholder="item.placeholder"
            v-if="item.type === 'datetime'"
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="cancelOperation">{{ footerBtns[0] }}</el-button>
          <el-button type="primary" @click="confirmOperation">
            {{ footerBtns[1] }}
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>
<script lang="ts" setup>
  import { ref, computed, watch, onMounted, provide, reactive, getCurrentInstance } from 'vue';
  import type { FormInstance, FormRules } from 'element-plus';
  import storeApi from '../../../utils/storeApi';
  import { ElMessage } from 'element-plus';
  interface selectType {
    storeId: string;
    goodId: string;
  }
  interface Props {
    modalStatus: boolean;
    formList: any[];
  }
  interface formType {
    storeId: string;
    storeName: string;
    goodId: string;
    goodName: string;
    createTime: Date;
    // [index: number]: string;
  }
  let selectValues = ref<selectType>({
    storeId: '',
    goodId: '',
  });
  const Xeutils = getCurrentInstance().appContext.config.globalProperties.$Xeutils;
  const emit = defineEmits<{
    (e: 'confirm-opration', data: {}): void;
    (e: 'cancel-operation', data: {}): void;
  }>();
  const props = withDefaults(defineProps<Props>(), {
    modalStatus: false,
    formList: () => [],
  });
  const dialogFormVisible = computed(() => {
    return props.modalStatus;
  });
  const formData = ref<formType>({
    storeId: '',
    storeName: '',
    goodId: '',
    goodName: '',
    createTime: Xeutils.toDateString(new Date(), 'yyyy-MM-dd HH:mm:ss'),
  });
  const footerBtns = ref<string[]>(['取消', '确定']);
  let insertTitle = ref<string>('注册添加店铺货物弹窗');
  const ruleFormRef = ref<FormInstance>(null);

  const checkstoreId = (rule: any, value: any, callback: any) => {
    if (!value) {
      callback(new Error('请输入店铺标识'));
    } else {
      callback();
    }
  };
  const checkstoreName = (rule: any, value: any, callback: any) => {
    if (!value) {
      callback(new Error('请输入店铺名称'));
    } else {
      callback();
    }
  };
  const checkgoodId = (rule: any, value: any, callback: any) => {
    if (!value) {
      callback(new Error('请输入货物标识'));
    } else {
      callback();
    }
  };
  const checkgoodName = (rule: any, value: any, callback: any) => {
    if (!value) {
      callback(new Error('请输入货物名称'));
    } else {
      callback();
    }
  };
  const checkCreateTime = (rule: any, value: any, callback: any) => {
    if (!value) {
      callback(new Error('请输入日期时间'));
    } else {
      callback();
    }
  };
  const formRules = ref<FormRules>({
    storeId: [{ validator: checkstoreId, trigger: 'blur' }],
    storeName: [{ validator: checkstoreName, trigger: 'blur' }],
    goodId: [{ validator: checkgoodId, trigger: 'blur' }],
    goodName: [{ validator: checkgoodName, trigger: 'blur' }],
    createTime: [{ validator: checkCreateTime, trigger: 'blur' }],
  });

  let cancelOperation = () => {
    emit('cancel-operation', { modalStatus: false, formData: {} });
  };
  let confirmOperation = (formRule: FormInstance | undefined) => {
    ruleFormRef.value.validate((valid) => {
      if (valid) {
        emit('confirm-opration', { modalStatus: false, formData: formData });
      } else {
        emit('confirm-opration', { modalStatus: true, formData: formData });
        return false;
      }
    });
  };
  let selectChange = ($event, data) => {
    if (data === 'storeId') {
      selectValues.value.storeId = $event;
      formData.value.storeId = $event;
    }
    if (data === 'goodId') {
      selectValues.value.goodId = $event;
      formData.value.goodId = $event;
    }
  };
  onMounted(() => {});
</script>
<style lang="less" scoped></style>
