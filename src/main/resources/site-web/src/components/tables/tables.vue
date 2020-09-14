<template>
  <div class="tableContent">
    <Table border :columns="columns" :data="showlist"></Table>
    <Page :total="total"  :current='currentindex' :page-size="pageSize" @on-change="pagechange"/>
  </div>
</template>
W
<script>
export default {
  name: 'tabels',
  props: {
    columns: {
      type: Object,
      default: () => {}
    },
    data: {
      type: Object,
      default: () => {}
    },
    total: {
      type: String,
      default: '100'
    },
    pageSize: {
      type: String,
      default: '14'
    }
  },
  data () {
    return {
      showlist: [],
      currentindex: 1
    }
  },
  methods: {
    pagechange (index) {
      var start = (index - 1) * this.pageSize
      var end = index * this.pageSize
      this.showlist = this.data.slice(start, end)
      this.currentindex = index
    }
  },
  mounted () {
    this.pagechange(1)
  }
}
</script>

<style>
    .ivu-page{
      position: absolute;
      bottom: 46px;
    }
</style>
