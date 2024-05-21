<template>
  <div class="topic-detail">
    <!-- 话题基本信息 -->
    <div class="topic-info">
      <h2>{{ topic.title }}</h2>
      <p>{{ topic.content }}</p>
      <div class="author-info">
        <span>发布时间：{{ formatDateTime(topic.createTime) }}</span>
      </div>
    </div>

    <!-- 评论列表 -->
    <div class="comment-list">
      <h3>评论列表</h3>
      <ul>
        <li v-for="comment in comments" :key="comment.id" class="comment-item">
          <div class="comment-header">
            <span class="author">{{ comment.author ? comment.author.userName : '' }}</span>
            <span class="time">{{ formatDateTime(comment.createTime) }}</span>
            <el-button type="text" class="reply-btn" @click="replyToComment(comment)">回复</el-button>
          </div>
          <div class="comment-content">{{ comment.content }}</div>
        </li>
      </ul>
    </div>

    <div class="pagination-container">
      <pagination v-show="total > 0" :total="total" :page.sync="current" :limit.sync="size" @pagination="fetchData" />
    </div>

    <!-- 评论输入框 -->
    <div class="comment-input">
      <el-input
        v-model="commentContent"
        placeholder="请输入评论内容"
        type="textarea"
        :autosize="{ minRows: 4, maxRows: 8 }"
      />
      <el-button type="primary" @click="submitComment" style="margin-top: 20px;">提交评论</el-button>
    </div>
  </div>
</template>

<script>
import { fetchDetail as fetchTopicDetail } from '@/api/user/userPost';
import {  fetchPaging as fetchComments, saveData as addComment } from '@/api/user/userComment';
import Pagination from "@/components/Pagination/index.vue";

export default {
  name : 'userComment',
  components: {Pagination},
  data() {
    return {
      topic: {}, // 话题基本信息
      comments: [], // 评论列表
      current: 1,
      size: 10,
      total: 0,
      params: {
        postId:""
      },
      // 评论内容
      commentContent:"",
      // 回复对象
      replyToUserId:"",
    };
  },
  mounted() {
    // 关联话题
    this.params.postId = this.$route.params.id;
    this.fetchTopicDetail();
    this.fetchComments();
  },
  methods: {
    // 获取话题详情
    fetchTopicDetail() {
      fetchTopicDetail({id:this.params.postId}).then(response => {
        this.topic = response.data;
      }).catch(error => {
        console.error('Failed to fetch topic detail:', error);
      });
    },
    // 获取评论列表
    fetchComments() {
      fetchComments({
        current: this.current,
        size: this.size,
        params: this.params,
        t: new Date().getTime()
      }).then(response => {
        const { records, current, size, total } = response.data;
        this.comments = records;
        this.current = current;
        this.size = size;
        this.total = total;
      }).catch(error => {
        console.error('Failed to fetch comments:', error);
      });
    },
    // 格式化时间
    formatDateTime(dateTime) {
      return new Date(dateTime).toLocaleString();
    },
    // 提交评论
    submitComment() {
      if (this.commentContent === '') {
        this.$message.error('评论内容不能为空');
        return;
      }
      addComment({
        postId: this.params.postId,
        content: this.commentContent,
        replyToUserId: this.replyToUserId
      }).then(() => {
        this.$message.success('评论成功');
        this.commentContent = '';
        this.replyToUserId = '';
        this.fetchComments();
      }).catch(error => {
        console.error('Failed to add comment:', error);
      });
    },
    // 回复评论
    replyToComment(comment) {
      this.replyToUserId = comment.userId;
      this.commentContent = `回复 @${comment.author.userName}：`;
    }
  }
};
</script>

<style lang="scss" scoped>
.topic-detail {
  margin: 20px;
}

.topic-info {
  border-bottom: 1px solid #ccc;
  padding-bottom: 20px;
}

.author-info {
  margin-top: 10px;
}

.comment-list {
  margin-top: 20px;

  .comment-item:nth-child(odd) {
    background-color: #f0f0f0; // 奇数行的底色
  }

  .comment-item:nth-child(even) {
    background-color: #e0e0e0; // 偶数行的底色
  }
}

.comment-input {
  margin-top: 20px;
}

.comment-item {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin-bottom: 10px;
  background-color: #f8f8f8; /* 添加背景色 */
}

.comment-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 5px;
}

.time {
  color: #666;
  margin-left: auto; /* 将时间放置到右侧 */
}

.author {
  font-weight: bold; /* 加粗作者名称 */
}

.time {
  color: #666; /* 时间文字颜色 */
}

.reply-btn {
  padding: 0;
  font-size: 12px;
  color: #409EFF;
  background-color: transparent;
  border: none;
  cursor: pointer;
  transition: color 0.3s;
  margin-left: 20px;
}

.reply-btn:hover {
  color: #1989fa;
}

.comment-content {
  margin-top: 5px; /* 调整评论内容的上边距 */
}

</style>
