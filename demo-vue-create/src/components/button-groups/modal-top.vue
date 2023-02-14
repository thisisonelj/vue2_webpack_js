<template>
  <div>
    <el-dialog
      :visible.sync="modalStatus"
      width="420px"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      class="modal-top-page"
    >
      <div slot="title" class="modal-header">
        <span style="font-size: 20px">{{ operationName }}</span>
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
            <template v-if="demoItem.type === 'input'">
              <el-input v-model="FormData.bankName"></el-input>
            </template>
            <template v-if="demoItem.type === 'select'">
              <el-select v-model="FormData.bankType" placeholder="请选择">
                <el-option
                  v-for="(item, index) in formAgeOptions"
                  :key="item.code"
                  :value="item.label"
                >
                </el-option>
              </el-select>
            </template>
            <template v-if="demoItem.type === 'pretype'">
              <el-input
                v-model="FormData.parentCode"
                :placeholder="demoItem.content[1]"
                style="margin-bottom:18px"
                disabled
              ></el-input>

              <el-input
                v-model="FormData.parentName"
                :placeholder="demoItem.content[0]"
                disabled
              ></el-input>
            </template>
            <template v-if="demoItem.type === 'radio'">
              <el-radio v-model="FormData.leafCode" :label="true">是</el-radio>
              <el-radio v-model="FormData.leafCode" :label="false">否</el-radio>
            </template>
          </el-form-item>
        </el-form>
      </div>
      <div slot="footer" class="modal-footer">
        <el-button type="info" @click="setBlankOperation">重置</el-button>
        <el-button @click="cancelOperation">取 消</el-button>
        <el-button type="primary" @click="handleOperation">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import bankApi from '@/utils/bank_info'
export default {
  props: {
    demoForm: {
      type: Array,
      default: function () {
        return []
      }
    },
    modalStatus: {
      type: Boolean,
      default: false
    },
    selectedNodes: {
      type: Object,
      default: function () {
        return {}
      }
    }
  },
  data () {
    let checkBankName = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('银行名称不能为空'))
      } else {
        return callback()
      }
    }
    let checkBankType = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('银行类型不能为空'))
      } else {
        return callback()
      }
    }
    let checkParentCode = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('上级银行代码不能为空'))
      } else {
        return callback()
      }
    }
    let checkParentName = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('上级银行名称不能为空'))
      } else {
        return callback()
      }
    }
    return {
      operationName: '新增银行',
      FormData: {
        bankId: '',
        bankName: '',
        bankType: '',
        parentCode: '',
        parentName: '',
        leafCode: true
      },
      formAgeOptions: [
        { label: '全国银行', code: 'A' },
        { label: '省级银行', code: 'B' },
        { label: '市级银行', code: 'C' }
      ],
      FormRules: {
        bankName: [
          { validator: checkBankName, trigger: 'blur' }
        ],
        bankType: [
          { validator: checkBankType, trigger: 'blur' }
        ],
        parentCode: [
          { validator: checkParentCode, trigger: 'blur' }
        ],
        parentName: [
          { validator: checkParentName, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleOperation () {
      this.$refs.ruleForm.validate(async (valid) => {
        if (valid) {
          let res = await bankApi.add(this.FormData).catch((error) => {
            console.log(error)
          })
          if (res.status === 200) {
            this.$Message.success({
              background: true,
              content: '成功添加一条数据'
            })
            this.$emit('confirm-insert', { modalStatus: false, showTreeData: true })
          } else {
            this.$emit('confirm-insert', { modalStatus: true })
          }
        } else {
          this.$emit('confirm-insert', { modalStatus: true })
        }
      })
    },
    cancelOperation () {
      this.$emit('cancel-insert', { modalStatus: false })
    },
    setBlankOperation () {
      this.FormData = {
        bankId: '',
        bankName: '',
        bankType: '',
        parentCode: '',
        parentName: '',
        leafCode: true
      }
    }
  },
  created () {},
  mounted () {

  },
  computed: {},
  watch: {
    modalStatus: {
      handler: function (val) {
        if (this.selectedNodes && Object.keys(this.selectedNodes).length !== 0) {
          this.FormData.parentCode = this.selectedNodes.bankId
          this.FormData.parentName = this.selectedNodes.bankName
        }
      }

    }
  },
  beforeDestroy () {}
}
</script>
<style lang="less" scoped>
@base-color: blue;
@deep:~ ">>>";
.modal-top-page {
  @{deep} .el-dialog {
    height: 420px;
  }
  @{deep} .el-dialog__header {
    & span {
      line-height: 1;
      vertical-align: 5px;
    }
  }
  @{deep} .el-dialog__body {
    border-top: 2px solid;
    border-bottom: 2px solid;
    overflow: auto;
    height: 65%;
    .el-select {
      width: 100%;
    }
    .el-form-item__label {
      white-space: nowrap;
    }
    .bank-code {
    }
    .bank-name {
    }
  }
  @{deep} .el-dialog__footer {
    & .modal-footer {
      margin-top: 30px;
    }
  }
}
</style>
