<template>
  <div>
    <el-dialog
      :visible.sync="selectStatus"
      width="720px"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      class="modal-top-page"
    >
      <div slot="title" class="modal-header">
        <span style="font-size: 20px">{{ operationName }}</span>
      </div>
      <div class="demo-dialog-center">
        <Split v-model="split1">
          <div slot="left" class="demo-left-pane">
            <scheme-tree
              ref="schemeTree"
              @refresh-content="refreshContent"
              @insert-info="insertInfo"
              :tree-data="treeData"
              @tree-selected="treeSelected"
              :insert-node-id="insertNodeId"
              @update-info="updateInfo"
              @delete-info="deleteInfo"
              :delete-id="deleteId"
            ></scheme-tree>
          </div>
          <div slot="right" class="demo-right-pane">
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
                      :value="item.code"
                      :label="item.label"
                    >
                    </el-option>
                  </el-select>
                </template>
                <template v-if="demoItem.type === 'date'">
                  <el-date-picker
                    v-model="FormData.createTime"
                    type="datetime"
                    placeholder="选择日期时间"
                  >
                  </el-date-picker>
                </template>
              </el-form-item>
            </el-form>
          </div>
        </Split>
      </div>
      <div slot="footer" class="modal-footer">
        <el-button type="info" @click="setBlankOperation">重置</el-button>
        <el-button @click="cancelOperation">取 消</el-button>
        <el-button type="primary" @click="handleOperation">查询</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>

import schemeTree from './scheme-tree.vue'
import bankSchemeInfo from '@/utils/bankscheme_info'
import commonMethods from '@/utils/utils'
export default {
  components: {
    schemeTree: schemeTree
  },
  props: {
    selectStatus: {
      type: Boolean,
      default: false
    },
    demoForm: {
      type: Array,
      default: function () {
        return []
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
    let checkBankTime = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('银行类型不能为空'))
      } else {
        return callback()
      }
    }

    return {
      split1: 0.4,
      operationName: '查询方案',
      FormData: {
        schemeId: '',
        schemeName: '',
        bankName: '',
        bankType: '',
        parentCode: '',
        parentName: '',
        createTime: this.$XeUtils.toDateString(
          new Date(),
          'yyyy-MM-dd HH:mm:ss'
        )
      },
      defaultFormData: {
        schemeId: '',
        schemeName: '',
        bankName: '',
        bankType: '',
        parentCode: '',
        parentName: '',
        createTime: this.$XeUtils.toDateString(
          new Date(),
          'yyyy-MM-dd HH:mm:ss'
        )
      },
      formAgeOptions: [
        { label: '全国银行', code: 'A' },
        { label: '省级银行', code: 'B' },
        { label: '市级银行', code: 'C' }
      ],
      FormRules: {
        bankType: [{ validator: checkBankType, trigger: 'blur' }]
      },
      treeData: [],
      selectedNode: {},
      insertNodeId: '',
      deleteId: ''
    }
  },
  methods: {
    handleOperation () {
      this.$refs.ruleForm.validate(async (valid) => {
        if (valid) {
          let res = await bankSchemeInfo.selectByScheme(this.FormData).catch((error) => {
            console.log(error)
          })
          if (res.status === 200) {
            this.$emit('confirm-select', res.data)
          } else {
            this.$emit('confirm-select', { modalStatus: true })
          }
        } else {
          this.$emit('confirm-select', { modalStatus: true })
        }
      })
    },
    cancelOperation () {
      this.$emit('cancel-select', { modalStatus: false })
    },
    setBlankOperation () {
      this.FormData = {
        schemeId: '',
        schemeName: '',
        bankName: '',
        bankType: '',
        parentCode: '',
        parentName: '',
        createTime: this.$XeUtils.toDateString(
          new Date(),
          'yyyy-MM-dd HH:mm:ss'
        )
      }
    },
    refreshContent (data) {
      if (data && data.schemeId === 'root') {
        this.FormData = Object.assign({}, this.defaultFormData)
      }
    },
    querySchemeTree () {
      bankSchemeInfo.query_all({}).then((res) => {
        if (res.status === 200) {
          let treeList = res.data
          treeList.forEach((element) => {
            element.displayStatus = false
            element.bankId = element.schemeId
            element.id = element.schemeId
          })
          let schemeNoRootTree = commonMethods.arrayToTreeNoRoot(treeList)
          let ROOTSchemeTree = [
            {
              id: 'root',
              bankId: 'root',
              schemeId: 'root',
              schemeName: '方案名称',
              displayStatus: false,
              children: []
            }
          ]
          schemeNoRootTree.forEach((element) => {
            ROOTSchemeTree[0].children.push(element)
          })
          this.treeData = ROOTSchemeTree
        }
      })
    },
    insertInfo (data) {
      let finalForm = Object.assign({}, this.FormData)
      finalForm.parentCode = data.parentNode.schemeId
      finalForm.parentName = data.parentNode.schemeName
      finalForm.schemeName = data.schemeName
      bankSchemeInfo
        .add(finalForm)
        .then((res) => {
          if (res.status === 200) {
            this.querySchemeTree()
            this.insertNodeId = res.data
            let selectedScheme = { schemeId: res.data }
            this.treeSelected(selectedScheme)
            this.$Message.success({
              background: true,
              content: '成功添加一条方案'
            })
          }
        })
        .catch((error) => {
          console.log(error)
        })
    },
    async treeSelected (val) {
      if (val.schemeId === 'root') {
        this.FormData = Object.assign({}, this.defaultFormData)
      } else {
        let selectedSchemeInfo = await bankSchemeInfo
          .queryBySchemeId(val)
          .catch((error) => {
            console.log(error)
          })
        if (selectedSchemeInfo.status === 200) {
          this.FormData = selectedSchemeInfo.data
        }
      }
    },
    updateInfo (data) {
      let finalForm = Object.assign({}, this.FormData)
      finalForm.schemeId = data.parentNode.schemeId
      finalForm.schemeName = data.schemeName
      finalForm.parentCode = data.parentNode.parentCode
      finalForm.parentName = data.parentNode.parentName
      bankSchemeInfo
        .updateBySchemeId(finalForm)
        .then((res) => {
          if (res.status === 200) {
            this.querySchemeTree()
            this.insertNodeId = res.data
            let selectedScheme = { schemeId: res.data }
            this.treeSelected(selectedScheme)
            this.$Message.success({
              background: true,
              content: '成功修改一条方案'
            })
          }
        })
        .catch((error) => {
          console.log(error)
        })
    },

    deleteInfo (data) {
      bankSchemeInfo.deleteBySchemeId(data).then((res) => {
        if (res.status === 200) {
          this.querySchemeTree()
          this.insertNodeId = 'root'
          setTimeout(() => {
            this.$refs.schemeTree.setdefaultSelected('root')
          }, 500)
          this.FormData = Object.assign({}, this.defaultFormData)
          this.$Message.success({
            background: true,
            content: '删除方案成功'
          })
        }
      }).catch((error) => {
        console.log(error)
      })
    }
  },
  created () {
    this.querySchemeTree()
  },
  mounted () {},
  computed: {},
  beforeDestroy () {},
  watch: {}
}
</script>
<style lang="less" scoped>
@base-color: blue;
@deep:~ ">>>";
.modal-top-page {
  @{deep} .el-dialog {
    height: 560px;
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
    padding: 5px;
    & .demo-dialog-center {
      height: 100%;
      .left-pane {
        overflow: auto;
      }
      .demo-left-pane {
        padding: 10px;
        // overflow: auto;
      }
      .demo-right-pane {
        padding: 20px;
        padding-left: 0px;
      }
    }
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
      position: absolute;
      bottom: 30px;
      right: 30px;
    }
  }
}
</style>
