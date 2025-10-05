/**
 *  请求nest服务接口api
 */
export interface requestParams {
  url: string;
  methods: string;
  data?: Object;
  params?: Object;
  [props: string]: any;
}
import { axios } from './base_axios';
export const getNestServiceApi = (requestParams: requestParams): Promise<Object> => {
  return new Promise((resolve, reject) => {
    axios({
      method: requestParams.methods,
      url: requestParams.url,
      params: requestParams.data,
    })
      .then((res) => {
        resolve(res);
      })
      .catch((error) => {
        reject(error);
      });
  });
};

export const postNestServiceApi = (requestParams: requestParams): Promise<Object> => {
  return new Promise((resolve, reject) => {
    axios({
      method: requestParams.methods,
      url: requestParams.url,
      data: requestParams.data,
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => {
        resolve(res);
      })
      .catch((error) => {
        reject(error);
      });
  });
};
export const postNestServiceQueryApi = (requestParams: requestParams): Promise<Object> => {
  return new Promise((resolve, reject) => {
    axios({
      method: requestParams.methods,
      url: requestParams.url,
      data: requestParams.data,
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
    })
      .then((res) => {
        resolve(res);
      })
      .catch((error) => {
        reject(error);
      });
  });
};

export const postNestServiceUploadApi = (requestParams: requestParams): Promise<Object> => {
  return new Promise((resolve, reject) => {
    axios({
      method: requestParams.methods,
      url: requestParams.url,
      data: requestParams.data,
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    })
      .then((res) => {
        resolve(res);
      })
      .catch((error) => {
        reject(error);
      });
  });
};
