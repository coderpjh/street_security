<template>
  <div class="expertContent">
    <div class="Tabletitle">专家信息列表</div>
    <tables :columns="columns" :data="dataList" :total="dataList.length" :page-size="13"></tables>
  </div>
</template>

<script>
import tables from '../../components/tables/tables.vue'
import {getList} from '../../axios/expert.js'
export default{
  name: 'Expert',
  components: {
    tables
  },
  data () {
    return {
      columns: [
        {
          title: 'Id',
          key: 'id',
          align: 'center'
        },
        {
          title: '专家姓名',
          key: 'professorName',
          align: 'center'
        },
        {
          title: '性别',
          key: 'gender',
          align: 'center'
        },
        {
          title: '出生日期',
          key: 'data',
          tooltip: true,
          align: 'center'
        },
        {
          title: '家庭住址',
          key: 'address',
          align: 'center'
        },
        {
          title: '联系方式',
          key: 'telephone',
          align: 'center'
        },
        {
          title: '所属领域',
          key: 'field',
          align: 'center'
        },
        {
          title: '所属专业',
          key: 'professional',
          align: 'center'
        },
        {
          title: '相关经验',
          key: 'relatedExperience',
          align: 'center'
        },
        {
          title: '资质政府',
          key: 'qualificationGovernment',
          align: 'center'
        },
        {
          title: '所获奖项',
          key: 'awards',
          align: 'center'
        },
        {
          title: '操作',
          key: 'action',
          width: 150,
          align: 'center',
          render: (h, params) => {
            let _this = this
            return h('div', [
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.show(params.index)
                  }
                }
              }, '编辑'),
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                on: {
                  click: () => {
                    _this.remove(params.index)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      dataList: []
    }
  },
  mounted () {
    let _this = this
    getList().then(res => {
      console.log(res)
      _this.dataList = res.data.data
      console.log(_this.dataList)
    })
  }
}
</script>

<style lang="less">
  @import "./Expert.less";
</style>
