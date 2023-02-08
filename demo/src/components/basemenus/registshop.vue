<template>
  <div>
    <el-dialog :visible.sync="shopStatus" width="360px" :show-close="false">
      <div slot="title" class="modal-header">
        <span style="font-size:20px">{{ shopName }}</span>
      </div>
      <div class="demo-dialog-center">
        <el-form
          :model="shopData"
          :rules="shopRules"
          ref="registerForm"
          label-width="100px"
          label-position="right"
          size="small"
        >
          <el-form-item
            v-for="shopItem in shopForm"
            :key="shopItem.prop"
            :prop="shopItem.prop"
            size="small"
            :label="shopItem.label"
            class="demo-form-item"
          >
           <template v-if="shopItem.type === 'number'">
              <el-input-number v-if="shopData.hasOwnProperty(shopItem.prop)" v-model="shopData[shopItem.prop]"  :min="1" :key="shopData[shopItem.prop]" :disabled="true"></el-input-number>
            </template>
          <el-input v-if="shopItem.type === 'input'&&shopData.hasOwnProperty(shopItem.prop)" v-model="shopData[shopItem.prop]"></el-input>
       </el-form-item>
        </el-form>
      </div>
      <div slot="footer" class="modal-footer">
        <el-button @click="cancelOperation">取 消</el-button>
        <el-button type="primary" @click="handleOperation">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
/* 模态窗口 */
export default {
  props: {
    shopName: {
      type: String,
      default: '新建'
    },
    shopStatus: {
      type: Boolean,
      default: false
    },
    shopForm: {
      type: Array,
      default: function () {
        return []
      }
    },
    userId: {
      type: Number,
      default: 1
    },
    demoButtonId: {
      type: String,
      default: 'create'
    },
    modalStatus: {
      type: Boolean,
      default: false
    }
  },
  data () {
    let checkGoodId = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('商品标识不能为空'))
      } else {
        return callback()
      }
    }
    let checkGoodName = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('商品名称不能为空'))
      } else {
        return callback()
      }
    }
    let checkStoreId = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('商店标识不能为空'))
      } else {
        return callback()
      }
    }
    let checkStordName = (rule, value, callback) => {
      if (value === undefined || value === null || value === '') {
        return callback(new Error('商品名称不能为空'))
      } else {
        return callback()
      }
    }
    return {
      defaultshopData:
       {
         goodId: this.userId,
         goodName: '',
         storeId: this.userId,
         storeName: ''
       },
      shopData: {
        goodId: this.userId,
        goodName: '',
        storeId: this.userId,
        storeName: ''
      },
      shopRules: {
        goodId: [
          { validator: checkGoodId, trigger: 'blur' }
        ],
        goodName: [
          { validator: checkGoodName, trigger: 'blur' }
        ],
        storeId: [
          { validator: checkStoreId, trigger: 'blur' }
        ],
        storeName: [
          { validator: checkStordName, trigger: 'blur' }
        ]
      }

    }
  },
  methods: {
    cancelOperation () {
      this.$emit('close-modal', { status: false })
    },
    handleOperation () {
      this.$refs['registerForm'].validate((valid) => {
        if (valid) {
          this.$emit('get-good-info', this.shopData)
          this.$emit('close-modal', { status: false })
        } else {
          this.$emit('close-modal', { status: true })
        }
      })
    }

  },
  computed: {

  },
  watch: {
    'userId': {
      handler: function (value) {
        this.shopData.goodId = value
        this.shopData.storeId = value
      }
    },
    'modalStatus': {
      handler: function (value) {
        if (value && this.demoButtonId === 'create') {
          this.shopData = Object.assign({}, this.defaultshopData)
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
  overflow-x:hidden;
}
/deep/ .el-dialog__body {
  padding-right: 50px;
}
/deep/ .el-input-number--small,
.el-date-editor.el-input,.el-select {
  width: 100%;
}
   /* 1,滚动条 */
     ::-webkit-scrollbar {
      width: 20px;          /* 纵向滚动条 宽度 */
      height: 15px;         /* 横向滚动条 高度 */
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
