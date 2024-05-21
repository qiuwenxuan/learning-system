<template>

  <data-table
    ref="pagingTable"
    :options="options"
    :list-query="listQuery"
  >
    <template #filter-content>

      <el-input v-model="listQuery.params.planName" placeholder="搜索名称" style="width: 200px;" class="filter-item" />

    </template>

    <template #data-columns>

      <el-table-column
        label="名称"
        align="center"
        prop="planName"
      />

        <el-table-column
          label="描述"
          align="center"
          prop="description"
        />
        <el-table-column
          label="日期"
          align="center"
          prop="startDate"
        >
          <template #default="scope">
            {{ scope.row.startDate.split(' ')[0] }} - {{ scope.row.endDate.split(' ')[0] }}
          </template>
        </el-table-column>

        <el-table-column
          label="完成状态"
          align="center"
          prop="completionStatus"
        >
          <template #default="scope">
            <template v-if="scope.row.completionStatus === 0">
              <el-tag v-if="new Date() < new Date(scope.row.startDate)" type="info">待开始</el-tag>
              <el-tag v-else-if="new Date() <= new Date(scope.row.endDate)" type="primary">进行中</el-tag>
              <el-tag v-else type="danger">超时</el-tag>
            </template>
            <template v-else>
              <el-tag v-if="new Date(scope.row.completionTime) <= new Date(scope.row.endDate)" type="success">完成</el-tag>
              <el-tag v-else type="warning">超时完成</el-tag>
            </template>
          </template>
        </el-table-column>


        <el-table-column
          label="完成时间"
          align="center"
          prop="completionTime"
        />


      <el-table-column
        label="操作"
        align="center"
        width="220px"
      >
        <template v-slot="scope">
          <el-button v-if="scope.row.completionStatus === 0" type="primary" size="mini"  @click="handleDetail(scope.row.id)">修改</el-button>
          <el-button v-if="scope.row.completionStatus === 0" type="success" size="mini" @click="finishTask(scope.row.id)">完成</el-button>
        </template>
      </el-table-column>

    </template>

  </data-table>

</template>

<script>
import DataTable from '@/components/DataTable'
import {  saveData } from '@/api/user/userLearningPlan'

export default {
  name: 'Plan',
  components: { DataTable },
  data() {
    return {

      listQuery: {
        current: 1,
        size: 10,
        params: {
          planName: ''
        }
      },

      options: {
        // 可批量操作
        multi: true,
        // 批量操作列表
        multiActions: [
          {
            value: 'delete',
            label: '删除'
          }
        ],
        // 列表请求URL
        listUrl: '/exam/api/userLearningPlan/paging',
        // 删除请求URL
        deleteUrl: '/exam/api/userLearningPlan/delete',
        // 启用禁用
        stateUrl: '/exam/api/userLearningPlan/update',
        // 添加数据路由
        addRoute: 'AddPlan'
      }
    }
  },
  methods: {
    // 调整到编辑页
    handleDetail(id) {
      this.$router.push({ name: 'AddPlan', params: { id: id }})
    },
    // 完成任务
    finishTask(id) {
      const params = {
        id: id,
        // 完成状态
        completionStatus: 1,
        // 完成时间
        completionTime: new Date()
      }
      saveData(params).then(() => {
        this.$notify({
          title: '操作成功',
          type: 'success',
          duration: 2000
        })
        // 刷新列表
        this.handleRefresh()
      })
    },
    // 刷新列表数据
    handleRefresh() {
      this.$refs.pagingTable.getList()
    }
  }
}
</script>
