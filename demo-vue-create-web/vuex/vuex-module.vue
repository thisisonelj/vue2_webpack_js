<template>
    <div class="flex-main">
      <div>
        <Input search enter-button placeholder="Enter something..." v-model="inputValue" style="width:70%" size="large"/>
        <Table border :columns="columns12" :data="data6" style="margin-top:15%">
        <template slot-scope="{ row }" slot="name">
            <strong>{{ row.name }}</strong>
        </template>
        <template slot-scope="{ row, index }" slot="action">
            <Button type="primary" size="small" style="margin-right: 5px" @click="show(row,index)">添加</Button>
            <Button type="error" size="small" @click="remove(row,index)">删除</Button>
        </template>
    </Table>
      </div>
   </div>
</template>
<script>
export default {
  data () {
    return {
      inputValue: '',
      columns12: [
        {
          title: 'Name',
          slot: 'name'
        },
        {
          title: 'Age',
          key: 'age'
        },
        {
          title: 'Action',
          slot: 'action',
          width: 150,
          align: 'center'
        }
      ]
    }
  },
  computed: {
    data6: function () {
      return this.$store.state.tableData
    }
  },
  methods: {
    show (row, index) {
      this.$store.dispatch('insert/insertTable', { row: row })
    },
    remove (row, index) {
      this.$store.dispatch('delete/deleteTable', { row: row })
    }
  }
}
</script>
<style lang="less" scoped>
#flex-layout{
  display: flex;
  justify-content: center;
  align-items: center;
}
.flex-main{
  #flex-layout();
  height: 100%;
}
</style>
