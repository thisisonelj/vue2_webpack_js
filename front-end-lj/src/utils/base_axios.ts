import axios from 'axios';
const AUTH_TOKEN = 'ASHDASKJHDKHJASDHJSAKHJD'; // TOKEN 值
axios.defaults.baseURL = 'http://localhost:9000';
axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
export { axios };
