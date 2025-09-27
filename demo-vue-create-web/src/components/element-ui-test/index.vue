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
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="日期" width="180">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column label="姓名" width="180">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>姓名: {{ scope.row.name }}</p>
            <p>住址: {{ scope.row.address }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.name }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="姓名" width="180">
        <template slot-scope="scope">
          <div
            @click="
              switchChange(scope.row.switchsStatus, scope.row, scope.$index)
            "
          >
            <el-switch
              :value="scope.row.switchsStatus"
              active-color="blue"
              inactive-color="#000"
              :active-value="1"
              :inactive-value="0"
              :disabled="scope.row.disableStatus"
              style="pointer-events: none"
            >
            </el-switch>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-table
      :data="rowData"
      border
      header-cell-class-name="table-header"
      style="width: 100%"
      :height="300"
    >
      <el-table-column
        v-for="(item, index) in colData"
        :key="item.id"
        align="center"
        :min-width="columnWidth(item, index)"
      >
        <template slot="header">
          <div>{{ item.label }}</div>
        </template>
        <template slot-scope="scope">
          <div
            v-if="index == 1"
            style="height: 72px; display: flex;gap: 10px;overflow-x: auto;overflow-y: hidden;"
          >
            <div v-for="ele in scope.row[item.type]" :key="ele.id">
              <img :src="ele.name" style="height: 72px; width: 108px"></img>
            </div>
          </div>
          <div v-else>
            {{ scope.row.date }}
          </div>
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-button @click="navigateWhatsAppInfo" type="primary"></el-button>
    </div>
     <div>
      <el-button @click="navigateEmail" type="primary"></el-button>
    </div>
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
      switchValue: 1,
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄",
          switchsStatus: 0,
          disableStatus: false,
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄",
          switchsStatus: 0,
          disableStatus: false,
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄",
          switchsStatus: 0,
          disableStatus: false,
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄",
          switchsStatus: 0,
          disableStatus: false,
        },
      ],
      colData: [
        {
          id: 1,
          label: "日期/餐型",
        },
        {
          id: 2,
          label: "早餐",
          type: "BREAKFAST",
        },
        {
          id: 3,
          label: "午餐",
          type: "LUNCH",
        },
        {
          id: 5,
          label: "晚餐",
          type: "DINNER",
        },
        {
          id: 6,
          label: "晚餐",
          type: "DINNER",
        },
        {
          id: 7,
          label: "晚餐",
          type: "DINNER",
        },
      ],
      rowData: [
        {
          date: "周一",
          BREAKFAST: [
            {
              id: 1,
              name: "../../assets/sea.jpg",
            },
            {
              id: 2,
              name: "../../assets/sea.jpg",
            },
            {
              id: 3,
              name: "../../assets/sea.jpg",
            },
             {
              id: 3,
              name: "../../assets/sea.jpg",
            },
             {
              id: 3,
              name: "../../assets/sea.jpg",
            },
             {
              id: 3,
              name: "../../assets/sea.jpg",
            },
          ],
          LUNCH: [
            {
              id: 1,
              name: "彩椒",
            },
            {
              id: 2,
              name: "韭菜",
            },
          ],
          DINNER: [
            {
              id: 1,
              name: "大米粥",
            },
          ],
          DINNER: [
            {
              id: 1,
              name: "大米粥",
            },
          ],
          DINNER: [
            {
              id: 1,
              name: "大米粥",
            },
          ],
          DINNER: [
            {
              id: 1,
              name: "大米粥",
            },
          ],
        },
        {
          date: "周二",
          BREAKFAST: [
            {
              id: 1,
              name: "../../assets/sea.jpg",
            },
          ],
          LUNCH: [
            {
              id: 1,
              name: "胡萝卜",
            },
            {
              id: 2,
              name: "西兰花",
            },
            {
              id: 1,
              name: "胡萝卜",
            },
            {
              id: 2,
              name: "西兰花",
            },
          ],
          DINNER: [
            {
              id: 1,
              name: "番茄鸡蛋粥",
            },
            {
              id: 2,
              name: "排骨芋头粥",
            },
            {
              id: 3,
              name: "窝蛋肉丝粥",
            },
          ],
        },
      ],
    };
  },
  methods: {
    navigateWhatsAppInfo(){
      // 请替换为你的WhatsApp API密钥和目标电话号码
      const apiKey = 'YOUR_API_KEY';
      const phoneNumber = '15535409713';

     // 请替换为你想发送的消息内容
     const message = 'Hello, World!';

     // 构建WhatsApp API的URL
     const apiUrl = `https://api.whatsapp.com/send?phone=${phoneNumber}&text=${encodeURIComponent(message)}`;

    // 打开WhatsApp并发送消息
     window.open(apiUrl);
    },
    navigateEmail(){
      const data='15535409713m@sina.cn'
      const emailSubjectName='测试跳转邮箱'
      const emailInnerContent='这是邮箱内容'
  const emailNumber = encodeURIComponent(data)
  // 构造mailto链接
  const mailtoLink = `mailto:${emailNumber}?subject=${emailSubjectName}&body=${emailInnerContent}`
  // 创建一个a标签并设置其href属性为mailto链接
  const a = document.createElement('a')
  a.href = mailtoLink
  // 触发a标签的点击事件，从而打开用户的默认邮件客户端
  a.click()
  a.remove()
    },
    columnWidth(column, index) {
      let width = 100;
      if (column.label.length) {
        width = column.label.length * 20;
      }
       if (index == 0) {
        width = 100;
      }
      if (index == 1) {
        width = 260;
      }
    
      return width;
    },
    modifySwitchStatus(arr) {
      let status = arr.filter((m) => {
        return m.switchsStatus == 1;
      }).length;
      return status;
    },
    handleSelectList(val) {
      if (this.selectList.length > 1) {
        this.selectList.splice(0, 1);
      }
    },
    switchChange(e, row, index) {
      if (e == 0 && !this.modifySwitchStatus(this.tableData)) {
        //调用生效接口
        this.tableData[index].switchsStatus = 1;
      } else if (e == 1) {
        //调用失效接口
        this.tableData[index].switchsStatus = 0;
      } else {
        alert("只能启动一个开关");
      }
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log('测试分屏策略')
      console.log(index, row);
      console.log('测试分支策略')
      console.log('测试冲突')
      // console.log('测试分支策略')
       console.log('测试冲突yyds')
    },
  },
};
</script>
<style lang="less" scoped>
/deep/ .el-table__body-wrapper {
  overflow-x: auto;
}
</style>
