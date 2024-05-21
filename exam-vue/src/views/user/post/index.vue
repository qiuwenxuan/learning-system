<template>
  <div class="topic-list">

    <div class="search-container">
      <el-input v-model="searchTitle" placeholder="请输入标题" class="search-input"></el-input>
      <el-button type="primary" @click="handleSearch">搜索</el-button>
    </div>

    <el-button type="primary" class="publish-button" @click="handleAdd">发布话题</el-button>

    <template v-for="(record, index) in records">
      <el-descriptions
        size="large"

        :column="2"
        :key="record.id"
        :class="{ 'separator': index !== 0 }"
      >
        <template #title>
          <div class="title-link" @click="viewTopic(record)">{{ record.title }}</div>
        </template>
        <el-descriptions-item label="作者">{{ record.author?record.author.userName:"无" }}</el-descriptions-item>
        <el-descriptions-item label="内容">
          <div class="clamp-text">{{ record.content }}</div>
        </el-descriptions-item>
        <el-descriptions-item label="评论">
          <el-badge :value="record.commentCount"></el-badge>
        </el-descriptions-item>
        <el-descriptions-item label="时间">{{ formatDateTime(record.createTime) }}</el-descriptions-item>
      </el-descriptions>
    </template>

    <div class="pagination-container">
      <pagination v-show="total > 0" :total="total" :page.sync="current" :limit.sync="size" @pagination="fetchData" />
    </div>
  </div>
</template>

<script>
import { fetchPaging } from '@/api/user/userPost';
import Pagination from "@/components/Pagination/index.vue";

export default {
  name: 'Post',
  components: { Pagination },
  data() {
    return {
      current: 1,
      size: 10,
      total: 0,
      records: [],
      searchTitle: '',
      params: {}
    };
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetchPaging({
        current: this.current,
        size: this.size,
        params: this.params,
        t: new Date().getTime()
      }).then(response => {
        const { records, current, size, total } = response.data;
        this.records = records;
        this.current = current;
        this.size = size;
        this.total = total;
      }).catch(error => {
        console.error('Failed to fetch data:', error);
      });
    },
    handleSearch() {
      this.current = 1;
      this.params.title = this.searchTitle;
      this.fetchData();
    },
    formatDateTime(dateTime) {
      return new Date(dateTime).toLocaleString();
    },
    handleAdd() {
      this.$router.push({ name: "AddPost", params: {}})
    },
    viewTopic(record) {
      this.$router.push({ name: "Comment", params: { id: record.id }})
    }
  },
};
</script>

<style lang="scss" scoped>
.topic-list {
  padding: 20px;
}

.search-container {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
}

.search-input {
  width: 300px;
  margin-right: 10px;
}

.el-button {
  min-width: 80px;
}

.pagination-container {
  display: flex;
  justify-content: center;
}

.separator {
  margin-top: 20px; /* 添加分隔间距 */
  border-top: 1px solid #ebeef5; /* 添加分隔线 */
}

.clamp-text {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1; /* 限制显示的行数 */
  overflow: hidden;
}

.publish-button {
  margin-bottom: 20px;
}

.title-link:hover {
  cursor: pointer;
  text-decoration: underline;
  color: blue;
}

</style>
