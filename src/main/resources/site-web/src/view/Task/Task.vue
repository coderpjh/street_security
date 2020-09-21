<template>
  <div class="expertContent">
    <div class="Tabletitle">{{TaskName}}
    <Button type="primary" ghost  icon="md-add" @click.native="addTask">新增</Button>
    </div>
    <tables ref='table' :columns="columns" :data="dataList" :total="dataList.length" :page-size="13"></tables>
  </div>
</template>

<script>
import tables from '../../components/tables/tables.vue'
import viewTask from './viewTask.vue'
import {getList, deleteTask, updateTask, increaseTask} from '../../axios/task.js'
export default{
  name: 'Expert',
  components: {
    tables,
    viewTask
  },
  data () {
    return {
      formData: {},
      TaskName: '常规任务列表',
      taskType: '1',
      columns: [
        {
          title: '任务名称',
          key: 'taskName',
          tooltip: true,
          align: 'center'
        },
        {
          title: '任务类型',
          key: 'taskType',
          tooltip: true,
          align: 'center',
          render: (h, params) => {
            console.log(params)
            switch (params.row.taskType) {
              case 1:return h('span', '常规任务')
              case 2:return h('span', '专项任务')
              case 3:return h('span', '通用任务')
              case 4:return h('span', '特性任务')
            }
          }
        },
        {
          title: '所属部门',
          key: 'taskDepartment',
          align: 'center'
        },
        {
          title: '任务描述',
          key: 'taskDescription',
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
                    console.log(_this)
                    _this.$Modal.confirm({
                      title: '确认要删除该条数据吗？',
                      onOk: () => {
                        deleteTask(params.row.id).then(() => {
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
  watch: {
    $route () {
      this.taskType = this.$route.query.type
      this.TaskName = this.$route.query.label + '列表'
      this.getData()
      console.log(this.$route)
    }
  },
  methods: {
    view (params) {
      this.formData = Object.assign({}, params.row)
      this.$Modal.confirm({
        render: (h) => {
          return h(viewTask, {
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
          updateTask(this.formData).then(res => {
            this.$Message.success({
              content: '更新成功'
            })
            this.getData()
          })
        }
      })
    },
    addTask () {
      this.formData = {}
      this.formData.taskType = this.taskType
      this.$Modal.confirm({
        render: (h) => {
          return h(viewTask, {
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
          this.formData.taskType = parseInt(this.formData.taskType)
          increaseTask(this.formData).then(res => {
            this.$Message.success({
              content: '添加成功'
            })
            this.getData()
          })
        }
      })
    },
    getData () {
      let _this = this
      getList(parseInt(this.taskType)).then(res => {
        console.log(res)
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
  @import "./Task.less";
</style>
