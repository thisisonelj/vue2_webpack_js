<template>
  <div>
    <el-checkbox-group v-model="selectList" @change="handleSelectList">
      <el-checkbox
        v-for="(setting, sIndex) in settings"
        :key="sIndex"
        :label="setting.text"
      >
        <i>{{ setting.text }}</i>
      </el-checkbox>
    </el-checkbox-group>
  </div>
</template>

<script>
export default {
  data() {
    return {
      settings: [
        {
          text: "文本",
          value: "text",
        },
        {
          text: "上传",
          value: "upload",
        },
      ],
      selectList: [],
    };
  },
  methods: {
    handleSelectList(val) {
      if (this.selectList.length > 1) {
        this.selectList.splice(0, 1);
      }
    },
  },
};
</script>
<style lang="less" scoped></style>
