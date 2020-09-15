<template>
  <div class="expertContent">
    <div class="Tabletitle">专家信息列表
    <Button type="primary" ghost  icon="md-add" @click.native="addExpert">新增</Button>
    </div>
    <tables ref='table' :columns="columns" :data="dataList" :total="dataList.length" :page-size="13"></tables>
  </div>
</template>

<script>
import tables from '../../components/tables/tables.vue'
import viewExpert from './viewExpert.vue'
import {getList, deleteExpert, updateExpert, increaseExpert} from '../../axios/expert.js'
export default{
  name: 'Expert',
  components: {
    tables,
    viewExpert
  },
  data () {
    return {
      formData: {},
      columns: [
        {
          title: 'Id',
          key: 'id',
          align: 'center',
          tooltip: true
        },
        {
          title: '专家姓名',
          key: 'professorName',
          align: 'center'
        },
        {
          title: '性别',
          key: 'gender',
          align: 'center',
          render: (h, params) => {
            if (params.row.gender === 1 || params.row.gender === '1') {
              return h('span', '男')
            } else return h('span', '女')
          }
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
          tooltip: true,
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
          tooltip: true,
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
                    console.log(params.row)
                    this.view(params)
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
                        deleteExpert(params.row.id).then(() => {
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
          return h(viewExpert, {
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
          updateExpert(this.formData).then(res => {
            this.$Message.success({
              content: '更新成功'
            })
            this.getData()
          })
        }
      })
    },
    addExpert () {
      this.formData = {}
      this.$Modal.confirm({
        render: (h) => {
          return h(viewExpert, {
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
          increaseExpert(this.formData).then(res => {
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
        _this.dataList = res.data.data
      })
    }
  },
  mounted () {
    this.getData()
  }
}
</script>

<style lang="less">
  @import "./Expert.less";
</style>
