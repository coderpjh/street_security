<template>
  <div class="riskContent">
    <div class="Tabletitle">街道风险列表</div>
    <tables ref='table' :columns="columns" :data="dataList" :total="dataList.length" :page-size="13"></tables>
  </div>
</template>

<script>
import tables from '../../components/tables/tables.vue'
import viewRisk from './viewRisk.vue'
import {getList, updateRisk, deleteRisk} from '../../axios/riskMonitor.js'
export default{
  name: 'riskMonitor',
  components: {
    tables,
    viewRisk
  },
  data () {
    return {
      formData: {},
      columns: [
        // {
        //   title: 'ID',
        //   key: 'id',
        //   align: 'center'
        // },
        {
          title: '风险名称',
          key: 'riskName',
          align: 'center',
          tooltip: true
        },
        {
          title: '所属区域',
          key: 'riskScope',
          align: 'center'
        },
        {
          title: '风险等级',
          key: 'riskLevel',
          align: 'center'
        },
        {
          title: '风险类型',
          key: 'riskType',
          align: 'center'
        },
        {
          title: '经度',
          key: 'longitude',
          align: 'center'
        },
        {
          title: '纬度',
          key: 'latitude',
          align: 'center'
        },
        {
          title: '风险上报人',
          key: 'reportName',
          align: 'center'
        },
        {
          title: '风险负责人',
          key: 'responsibleName',
          align: 'center'
        },
        {
          title: '风险描述',
          key: 'riskDescription',
          align: 'center',
          tooltip: true
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
                    this.view(params)
                    console.log(params.row)
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
                    _this.$Modal.confirm({
                      title: '确认要删除该条数据吗？',
                      onOk: () => {
                        deleteRisk(params.row.id).then(() => {
                          _this.$Message.success({
                            content: '删除成功'
                          })
                          _this.$refs['table'].remove(params.index)
                        })
                      }
                    })
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
  methods: {
    view (params) {
      this.formData = Object.assign({}, params.row)
      this.$Modal.confirm({
        render: (h) => {
          return h(viewRisk, {
            props: {
              formData: this.formData
            },
            on: {
              input: (val) => {
              }
            }
          })
        },
        onOk: () => {
          updateRisk(this.formData).then(res => {
            this.$Message.success({
              content: '更新成功'
            })
            this.getData()
          })
        }
      })
    },
    getData () {
      let _this = this
      getList().then(res => {
        console.log(res)
        _this.dataList = res.data.data
        console.log(_this.dataList)
      })
    }
  },
  mounted () {
    this.getData()
  }
}
</script>

<style lang="less">
  @import "./riskMonitor.less";
</style>
