import http from './cross-access';
//注册添加店铺货物接口
const addApi: (data: {}, url?: string | undefined) => any = function (
  data: {},
  url = '/rest/demo/store/add',
): any {
  return http.post(url, data);
};
//查询所有店铺列表信息
const queryStoresApi: (data?: {}, url?: string | undefined) => any = function (
  url = '/rest/demo/store/querystores',
): any {
  return http.post(url);
};
//查询所有货物列表信息
const queryGoodsApi: (data?: {}, url?: string | undefined) => any = function (
  url = '/rest/demo/store/querygoods',
): any {
  return http.post(url);
};
//查询所有店铺货物列表信息
const queryAllApi: (data?: {}, url?: string | undefined) => any = function (
  url = '/rest/demo/store/queryall',
): any {
  return http.post(url);
};
//查询所有店铺对应货物列表信息 ---根据storeId来查询
const queryByStoreIdApi: (data?: {}, url?: string | undefined) => any = function (
  data: {},
  url = '/rest/demo/store/querybystoreid',
): any {
  return http.post(url, data);
};
//查询所有店铺对应货物列表信息 ---根据storeId来查询
const deleteByGoodidApi: (data?: {}, url?: string | undefined) => any = function (
  data: {},
  url = '/rest/demo/store/deletebygoodid',
): any {
  return http.post(url, data);
};
interface dataType {
  insert: any;
  select: any;
  update: any;
  delete: any;
  queryStores: any;
  queryGoods: any;
  queryall: any;
  queryByStoreId: any;
  deleteByGoodid: any;
}
const storeApi = <dataType>{};
storeApi.insert = addApi;
storeApi.queryStores = queryStoresApi;
storeApi.queryGoods = queryGoodsApi;
storeApi.queryall = queryAllApi;
storeApi.queryByStoreId = queryByStoreIdApi;
storeApi.deleteByGoodid = deleteByGoodidApi;
export default storeApi;
