import { post } from '@/utils/request'

/**
 * 用户学习计划
 * @param data
 * @returns {Promise}
 */
export function fetchPaging(data) {
  return post('/exam/api/userLearningPlan/paging', data)
}

/**
 * 题库详情
 * @param data
 */
export function fetchDetail(data) {
  return post('/exam/api/userLearningPlan/detail', data)
}

/**
 * 保存题库
 * @param data
 */
export function saveData(data) {
  return post('/exam/api/userLearningPlan/save', data)
}
