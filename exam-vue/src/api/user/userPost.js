import { post } from '@/utils/request'

/**
 * 分页数据
 * @param data
 * @returns {Promise}
 */
export function fetchPaging(data) {
  return post('/exam/api/userPost/paging', data)
}

/**
 * 详情
 * @param data
 */
export function fetchDetail(data) {
  return post('/exam/api/userPost/detail', data)
}

/**
 * 保存
 * @param data
 */
export function saveData(data) {
  return post('/exam/api/userPost/save', data)
}
