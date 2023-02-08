<template>
  <div>
    <el-dialog :visible.sync="modalStatus" width="420px" :show-close="false" :close-on-click-modal="false" :close-on-press-escape="false">
      <div slot="title" class="modal-header">
        <span style="font-size:20px">{{ operationName }}</span>
      </div>
      <div class="demo-dialog-center">
        <el-form
          :model="FormData"
          :rules="FormRules"
          ref="ruleForm"
          label-width="100px"
          label-position="right"
          size="small"
        >
          <el-form-item
            v-for="demoItem in demoForm"
            :key="demoItem.type"
            :prop="demoItem.prop"
            size="small"
            :label="demoItem.label"
            class="demo-form-item"
          >
            <template v-if="demoItem.type === 'number'">
              <el-input-number
                v-model="FormData.userId"
                :min="1"
              ></el-input-number>
            </template>
            <template v-if="demoItem.type === 'input'">
              <el-input v-model="FormData.name"></el-input>
            </template>
            <template v-if="demoItem.type === 'select'">
              <el-select v-model="FormData.age" placeholder="请选择">
                <el-option
                  v-for="(item, index) in formAgeOptions"
                  :key="index"
                  :value="item"
                >
                </el-option>
              </el-select>
            </template>
            <template v-if="demoItem.type === 'datepicker'">
              <el-date-picker
                v-model="FormData.shopDate"
                type="datetime"
                placeholder="选择日期时间"
              >
              </el-date-picker>
            </template>
            <template v-if="demoItem.type === 'radio'">
              <el-radio v-model="FormData.sex" :label="false">男</el-radio>
              <el-radio v-model="FormData.sex" :label="true">女</el-radio>
            </template>
          </el-form-item>
          <el-form-item  v-if="demoButtonId==='create'">
            <el-row  type="flex" justify="center">
              <el-button type="primary" @click="registShopInfo"
                >选择商品</el-button
              >
            </el-row>
          </el-form-item>
        </el-form>
      </div>
      <div slot="footer" class="modal-footer">
        <el-button @click="cancelOperation">取 消</el-button>
        <el-button type="primary" @click="handleOperation">确 定</el-button>
      </div>
    </el-dialog>
    <regist-shop
      :shop-name="shopName"
      :shop-status="shopStatus"
      :shop-form="shopForm"
      @close-modal="shopStatus = $event.status"
      :user-id="contactSign"
      :demo-button-id="demoButtonId"
      @get-good-info="getGoodInfo"
      :modal-status="modalStatus"
    ></regist-shop>
  </div>
</template>
<script>
/* 模态窗口 */
import registShop from './registshop'
import shopApi from '../../utils/demo-shop-api/shop-api'
import fun from '../testvalid'
export default {
  name: 'basemodal',
  components: {
    registShop: registShop
  },
  props: {
    operationName: {
      type: String,
      default: '新建'
    },
    modalStatus: {
      type: Boolean,
      default: false
    },
    demoForm: {
      type: Array,
      default: function () {
        return []
      }
    },
    demoButtonId: {
      type: String,
      default: 'create'
    }
  },
  data () {
    let checkUserId = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('用户标识不能为空'))
      } else {
        return callback()
      }
    }
    let checkName = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('用户名称不能为空'))
      } else {
        return callback()
      }
    }
    let checkAge = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('用户年龄不能为空'))
      } else {
        return callback()
      }
    }
    let checkDate = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('用户日期不能为空'))
      } else {
        return callback()
      }
    }
    let checkSex = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('用户性别不能为空'))
      } else {
        return callback()
      }
    }
    return {
      defaultFormData: {
        name: '',
        age: 0,
        shopDate: this.$XeUtils.toDateString(this.$XeUtils.now(), 'yyyy-MM-dd HH:mm:ss'),
        sex: false,
        userId: ''
      },
      FormData: {
        name: '',
        age: 0,
        shopDate: this.$XeUtils.toDateString(this.$XeUtils.now(), 'yyyy-MM-dd HH:mm:ss'),
        sex: false,
        userId: ''
      },
      formAgeOptions: [5, 10, 15, 20, 25],
      FormRules: {
        userId: [
          { validator: checkUserId, trigger: 'blur' }
        ],
        age: [
          { validator: checkAge, trigger: 'blur' }
        ],
        sex: [
          { validator: checkSex, trigger: 'blur' }
        ],
        name: [
          { validator: checkName, trigger: 'blur' }
        ],
        shopDate: [
          { validator: checkDate, trigger: 'blur' }
        ]
      },
      shopStatus: false,
      shopForm: [
        {
          type: 'number',
          label: '商品标识：',
          prop: 'goodId'
        },
        {
          type: 'input',
          label: '商品名称：',
          prop: 'goodName'
        },
        {
          type: 'number',
          label: '商店标识：',
          prop: 'storeId'
        },
        {
          type: 'input',
          label: '商店名称：',
          prop: 'storeName'
        }
      ],
      shopName: '',
      contactSign: 1

    }
  },
  methods: {
    cancelOperation () {
      this.$emit('close-modal', { status: false })
    },
    handleOperation () {
      this.$refs['ruleForm'].validate(async (valid) => {
        if (valid) {
          if (this.demoButtonId === 'create') {
            let formData = {}
            formData.shopUser = {
              userId: this.FormData.userId,
              name: this.FormData.name,
              age: this.FormData.age,
              sex: this.FormData.sex,
              shopDate: this.$XeUtils.toDateString(this.FormData.shopDate, 'yyyy-MM-dd HH:mm:ss')
            }
            formData.shopGood = {
              goodId: this.FormData.goodId || 1,
              goodName: this.FormData.goodName || ''
            }
            formData.shopStore = {
              storeId: this.FormData.storeId || 1,
              storeName: this.FormData.storeName || ''
            }
            let respResultAdd = await shopApi.valid(formData.shopUser).catch((error) => {
              console.log(error)
            })
            if (respResultAdd.status === 200 && respResultAdd.data.length === 0) {
              let respResults = await shopApi.add(formData).catch((error) => {
                console.log(error)
              })
              if (respResults.status === 200) {
                let tableDataIncrease = Object.assign({}, formData.shopUser, formData.shopGood, formData.shopStore)
                tableDataIncrease.sex = tableDataIncrease.sex === false ? '男' : '女'
                this.$emit('demo-table-push', { data: tableDataIncrease })
                this.$emit('close-modal', { status: false })
                this.$message({
                  message: '新建成功',
                  type: 'success'
                })
              } else {
                this.$emit('close-modal', { status: true })
                this.$message.error(`${respResults.msg}`)
              }
            } else {
              this.$message.error(`用户标识重复`)
            }
          } else {
            this.FormData.shopDate = this.$XeUtils.toDateString(this.FormData.shopDate, 'yyyy-MM-dd HH:mm:ss')
            let respResults = await shopApi.query(this.FormData).catch((error) => {
              console.log(error)
            })
            if (respResults.status === 200) {
              this.$emit('demo-table-data', {data: respResults.data})
              this.$message({
                message: '查询成功',
                type: 'success'
              })
            }
            this.$emit('close-modal', { status: false })
          }
        } else {
          this.$emit('close-modal', { status: true })
        }
      })
    },
    registShopInfo () {
      this.shopStatus = true
      this.shopName = `${this.operationName.slice(
        0,
        this.operationName.indexOf('弹窗')
      )}商品弹窗`
      this.contactSign = Number(this.FormData.userId)
    },
    getGoodInfo (registShopInfo) {
      this.FormData = Object.assign(this.FormData, typeof (registShopInfo) === 'object' ? registShopInfo : {})
    }

  },
  computed: {

  },
  created () {

  },
  mounted () {

  },
  watch: {
    'modalStatus': {
      handler: function (value) {
        if (value && this.demoButtonId === 'create') {
          this.FormData = Object.assign({}, this.defaultFormData)
        }
      }

    }

  }
}
</script>
<style scoped>
.modal-footer {
  display: -webkit-flex;
  display: flex;
  -webkit-flex-flow: row wrap;
  flex-flow: row wrap;
  font-weight: bold;
  text-align: center;
  width: 100%;
  height: 100%;
  justify-content: flex-end;
}
.modal-header {
  width: 100%;
  height: 100%;
  display: flex;
  flex-flow: row wrap;
  justify-content: flex-start;
}
/deep/ .el-dialog__wrapper {
  overflow: hidden;
}
.demo-dialog-center {
  height: 260px;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
}
/deep/ .el-dialog__body {
  padding-right: 50px;
}
/deep/ .el-input-number--small,
.el-date-editor.el-input,
.el-select {
  width: 100%;
}
/* 1,滚动条 */
::-webkit-scrollbar {
  width: 20px; /* 纵向滚动条 宽度 */
  height: 15px; /* 横向滚动条 高度 */
}
::-webkit-scrollbar:horizontal {
  height: 6px;
}
/* 5,滑块 */
::-webkit-scrollbar-thumb {
  /* background: #bec5ca; */
  height: 20px;
}
</style>
