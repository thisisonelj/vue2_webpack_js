/**
 * 模拟后台数据 mock
 */
import xeUtils from 'xe-utils'
export const treeData: any[] = [
  {
    id: 'root',
    label: '主商品',
    children: [
      {
        id: 'subroot',
        label: '次商品',
        children: [
          {
            id: 'subsubroot',
            label: '次次商品',
          },
        ],
      },
      {
        id: 'subrootcopy',
        label: '次商品复制',
        children: [
          {
            id: 'subsubrootcopy',
            label: '次次商品复制',
          },
        ],
      },
    ],
  },
  {
    id: 'rootagain',
    label: '主商品再次',
    children: [
      {
        id: 'subrootagain',
        label: '次商品再次',
        children: [
          {
            id: 'subsubrootagain',
            label: '次次商品再次',
          },
        ],
      },
      {
        id: 'subrootcopyagain',
        label: '次商品复制再次',
        children: [
          {
            id: 'subsubrootcopyagain',
            label: '次次商品复制再次',
          },
        ],
      },
    ],
  },
]
export const tableData: any[] = [
  {
    goodId: 'one',
    goodName: '商品1',
    price: 100,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'two',
    goodName: '商品2',
    price: 200,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'three',
    goodName: '商品3',
    price: 300,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'four',
    goodName: '商品4',
    price: 400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'five',
    goodName: '商品5',
    price: 500,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'six',
    goodName: '商品6',
    price: 600,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'seven',
    goodName: '商品7',
    price: 700,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'eight',
    goodName: '商品8',
    price: 800,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'nine',
    goodName: '商品9',
    price: 900,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'ten',
    goodName: '商品10',
    price: 1000,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'eleven',
    goodName: '商品11',
    price: 1100,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'twive',
    goodName: '商品12',
    price: 1200,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'thirdth',
    goodName: '商品13',
    price: 1300,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
  {
    goodId: 'fourteen',
    goodName: '商品14',
    price: 1400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
  },
]
