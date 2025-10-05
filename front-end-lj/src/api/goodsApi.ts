//商品后台api 模拟数据库CRUD
import { getNestServiceApi, postNestServiceApi, requestParams, postNestServiceQueryApi, postNestServiceUploadApi } from '@/utils/request';
import { baseUrl } from '@/constant/index';

// 查询单条记录
export const querySingleRecord = ({ url = '/goods/one', methods = 'get', data = {} }) => {
  return getNestServiceApi({
    url,
    methods,
    data,
  });
};

// 查询所有记录
export const queryAllRecords = ({ url = '/goods/all', methods = 'post', data = {} }) => {
  return postNestServiceApi({
    url,
    methods,
    data,
  });
};

// 测试http GET缓存
export const testHttpGetCache = ({ url = '/cache/', methods = 'get', data = {} }) => {
  return getNestServiceApi({
    url,
    methods,
    data,
  });
};

// 测试SSE
export const testSse = (url = '/sse/') => {
  const eventSource = new EventSource(`${baseUrl}${url}`);
  eventSource.onmessage = (e) => {
    console.log(e);
  };
};

// 测试管道验证
export const testPipeValid = (url = '/pipe/666', methods = 'get', data = {}) => {
  return getNestServiceApi({
    url,
    methods,
    data,
  });
};

// 测试自定义管道验证
export const testPipeValidCustom = (data: Object) => {
  return postNestServiceApi({
    url: '/pipe/custom',
    methods: 'post',
    data,
  });
};

// 测试异常过滤器验证
export const testExceptionFilterValid = (data: Object) => {
  return postNestServiceQueryApi({
    url: '/pipe/exception',
    methods: 'post',
    data,
  });
};
// 测试守卫权限认证
export const testGuardPowerValid = (data: Object) => {
  return postNestServiceApi({
    url: '/pipe/guard',
    methods: 'post',
    data,
  });
};

// 测试拦截器aop
export const testInterceptorValid = (data: Object) => {
  return postNestServiceApi({
    url: '/pipe/interceptor',
    methods: 'post',
    data,
  });
};

// 测试事件监听
export const testEmitterListenerInfo = (data: Object) => {
  return postNestServiceApi({
    url: '/emitter/test',
    methods: 'post',
    data,
  });
};

// 测试调用deepseekApi服务
export const testDeepSeekApiInfo = (data: Object) => {
  return postNestServiceApi({
    url: '/http/test',
    methods: 'post',
    data,
  });
};

// 测试调用文件上传服务
export const testUploadApiInfo = (data: Object) => {
  return postNestServiceUploadApi({
    url: '/upload/file',
    methods: 'post',
    data,
  });
};

// 测试nest微服务
export const testMicroServiceInfo = ({ url = '/microservice/test', methods = 'get', data = {} }) => {
  return getNestServiceApi({
    url,
    methods,
    data,
  });
};
