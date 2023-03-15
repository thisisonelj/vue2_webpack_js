<!-- eslint-disable vue/no-mutating-props -->
<template>
  <div class="demo-child1">
    <Modal v-model="child1Status" width="720" style="top:5%">
      <template #header>
        <p style="color: #f60; text-align: center">
          <Icon type="ios-information-circle"></Icon>
          <span>表单信息</span>
        </p>
      </template>
      <div style="text-align: center">
        <Form :model="formItem" :label-width="80">
          <FormItem label="Input">
            <Input v-model="formItem.input" placeholder="Enter something..."></Input>
          </FormItem>
          <FormItem label="Select">
            <Select v-model="formItem.select">
              <Option value="beijing">New York</Option>
              <Option value="shanghai">London</Option>
              <Option value="shenzhen">Sydney</Option>
            </Select>
          </FormItem>
          <FormItem label="DatePicker">
            <Row>
              <Col span="11">
                <DatePicker
                  type="date"
                  placeholder="Select date"
                  v-model="formItem.date"
                ></DatePicker>
              </Col>
              <Col span="2" style="text-align: center">-</Col>
              <Col span="11">
                <TimePicker
                  type="time"
                  placeholder="Select time"
                  v-model="formItem.time"
                ></TimePicker>
              </Col>
            </Row>
          </FormItem>
          <FormItem label="Radio">
            <RadioGroup v-model="formItem.radio">
              <Radio label="male">Male</Radio>
              <Radio label="female">Female</Radio>
            </RadioGroup>
          </FormItem>
          <FormItem label="Checkbox">
            <CheckboxGroup v-model="formItem.checkbox">
              <Checkbox label="Eat"></Checkbox>
              <Checkbox label="Sleep"></Checkbox>
              <Checkbox label="Run"></Checkbox>
              <Checkbox label="Movie"></Checkbox>
            </CheckboxGroup>
          </FormItem>
          <FormItem label="Switch">
            <i-switch v-model="formItem.switch" size="large">
              <template #open>
                <span>On</span>
              </template>
              <template #close>
                <span>Off</span>
              </template>
            </i-switch>
          </FormItem>
          <FormItem label="Slider">
            <Slider v-model="formItem.slider" range></Slider>
          </FormItem>
          <FormItem label="Text">
            <Input
              v-model="formItem.textarea"
              type="textarea"
              :autosize="{ minRows: 2, maxRows: 5 }"
              placeholder="Enter something..."
            ></Input>
          </FormItem>
          <FormItem>
            <Button type="primary">Submit</Button>
            <Button style="margin-left: 8px">Cancel</Button>
          </FormItem>
        </Form>
      </div>
      <template #footer>
        <Button type="text" @click="cancelOperation">取消</Button>
        <Button type="info" @click="confirmOperation">确定</Button>
      </template>
    </Modal>
  </div>
</template>
<script setup>
import { ref, defineProps, defineEmits, computed } from 'vue'
let prop = defineProps({
  modalStatus: {
    type: Boolean,
    default: false
  }
})
let child1Status = computed(() => {
  return prop.modalStatus
})
let emit = defineEmits({
  cancelOperate: (status) => {
    return true
  },
  confirmOperate: (status) => {
    return true
  }
})
let cancelOperation = () => {
  emit('cancelOperate', {formItem:formItem,status:false})
}
let confirmOperation = () => {
  emit('confirmOperate', {formItem:formItem,status:false})
}
let formItem = ref({
  input: '',
  select: '',
  radio: 'male',
  checkbox: [],
  switch: true,
  date: '',
  time: '',
  slider: [20, 50],
  textarea: ''
})
</script>
<style scoped>
.demo-child1 {
}
</style>
