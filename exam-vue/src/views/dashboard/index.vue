<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="24">
        <el-card class="box">
          <div slot="header" class="clearfix">
            <span>项目信息</span>
            <el-button style="float: right; padding: 3px 0; font-size: 12px" type="text">系统版本：{{ version }}</el-button>
          </div>

          <div style="line-height: 32px;">

            <div class="title" style="padding-top: 0px">系统介绍</div>
            刷题（客观）系统是一款基于SpringBoot+Vue开发的刷题（客观）系统。包含学习规划、研友交流、在线考试、用户体系、错题训练、考试规则、智能算分等考试功能，流程通畅。

            <div class="title">技术栈</div>
            <div class="tags">
              <el-tag>SpringBoot</el-tag>
              <el-tag>Shiro</el-tag>
              <el-tag>MyBatis Plus</el-tag>
              <el-tag>JWT</el-tag>
              <el-tag>Vue</el-tag>
              <el-tag>Vue2</el-tag>
              <el-tag>ElementUI</el-tag>
            </div>

          </div>

        </el-card>
      </el-col>

    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import config from '../../../package.json'

export default {
  name: 'Dashboard',
  data() {
    return {
      currentRole: 'adminDashboard',
      version: config.version
    }
  },
  computed: {
    ...mapGetters([
      'roles',
      'siteData'
    ])
  },
  created() {

  }
}
</script>

<style scoped>
.box{
  height: calc(100vh - 120px);
  font-size: 14px;
  line-height: 28px;
}
.title{
  font-size: 18px;
  font-weight: 700;
  padding-bottom: 10px;
  padding-top: 20px;
  margin-bottom: 10px;
  border-bottom: #eee 1px dotted;
}

.tags span{
  margin-right: 10px;
}

.box a{
  color: #20a0ff;
}

.box a:hover{
  color: #ff0000;
}
</style>
