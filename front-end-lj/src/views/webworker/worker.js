/**
 * 使用子线程处理复杂计算任务 完成浏览器父子线程通信
 */
// Web Worker 文件 - 处理耗时计算任务

// 监听主线程发送的消息
self.onmessage = function (event) {
  const { type, data } = event.data;
  switch (type) {
    case 'CALCULATE_FIBONACCI':
      const result = calculateFibonacci(data.number);
      self.postMessage({
        type: 'FIBONACCI_RESULT',
        data: { result, input: data.number },
      });
      break;
    default:
      self.postMessage({
        type: 'ERROR',
        data: { message: '未知的任务类型' },
      });
  }
};

// 计算斐波那契数列（模拟CPU密集型任务）
function calculateFibonacci(n) {
  if (n <= 1) return n;
  let a = 0,
    b = 1;
  for (let i = 2; i <= n; i++) {
    const temp = a + b;
    a = b;
    b = temp;
  }
  return b;
}

// 错误处理
self.onerror = function (error) {
  console.error('Worker 错误:', error);
};
