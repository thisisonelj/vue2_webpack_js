interface Rowtype {
  id: string;
  [propName: string]: any;
}
interface pagationParams {
  currentPage: number;
  total?: number;
  pageSize: number;
}

function pagation(pagationObj: pagationParams, sourceArray: Array<Rowtype>): any {
  const totalPages = Math.ceil(pagationObj.total / pagationObj.pageSize);
  const padStart = (pagationObj.currentPage - 1) * pagationObj.pageSize;
  const padEnd = padStart + pagationObj.pageSize;
  let resultArray: Array<Rowtype> = [];
  resultArray = sourceArray.slice(padStart, padEnd);
  const result = { totalPages: totalPages, data: resultArray, total: pagationObj.total };
  return result;
}
export { pagation };
