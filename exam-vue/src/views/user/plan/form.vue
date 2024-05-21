<template>
  <div class="app-container">

    <el-form ref="postForm" :model="postForm" :rules="rules" label-position="top" label-width="100%">

      <el-card>
        <el-form-item label="规划名称" prop="planName">
          <el-input v-model="postForm.planName" />
        </el-form-item>

        <el-form-item label="规划描述" prop="description">
          <el-input v-model="postForm.description" type="textarea" />
        </el-form-item>

        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker
            v-model="postForm.startDate"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker
            v-model="postForm.endDate"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>

      </el-card>

      <div style="margin-top: 20px">
        <el-button type="primary" @click="submitForm">保存</el-button>
        <el-button type="info" @click="onCancel">返回</el-button>
      </div>

    </el-form>

  </div>
</template>

<script>

import { fetchDetail, saveData } from '@/api/user/userLearningPlan'

export default {
  name: 'AddPlan',
  data() {
    return {
      postForm: {

      },
      loading: false,
      rules: {

        planName: [

          { required: true, message: '规划名称不能为空！' }
        ],
        description: [
          { required: true, message: '规划描述不能为空！' }
        ],
        startDate: [
          { required: true, message: '开始日期不能为空！' }
        ],
        endDate: [
          { required: true, message: '结束日期不能为空！' }
        ]

      }
    }
  },
  created() {
    const id = this.$route.params.id
    if (typeof id !== 'undefined') {
      this.fetchData(id)
    }
  },
  methods: {

    // 添加子项
    handleAdd() {
      this.postForm.answerList.push({ isRight: false, content: '', analysis: '' })
    },

    fetchData(id) {
      const params = { id: id }
      fetchDetail(params).then(response => {
        this.postForm = response.data
      })
    },
    submitForm() {
      console.log(JSON.stringify(this.postForm))

      this.$refs.postForm.validate((valid) => {
        if (!valid) {
          return
        }

        saveData(this.postForm).then(() => {
          this.$notify({
            title: '成功',
            message: '保存成功！',
            type: 'success',
            duration: 2000
          })

          this.$router.push({ name: 'Plan' })
        })
      })
    },

    onCancel() {
      this.$router.push({ name: 'Plan' })
    }

  }
}
</script>
