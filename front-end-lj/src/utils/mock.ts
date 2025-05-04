/**
 * 模拟后台数据 mock
 */
import xeUtils from 'xe-utils'
export const treeData: any[] = [
  {
    id: 'one',
    label: '主商品',
    children: [
      {
        id: 'two',
        label: '次商品',
        children: [
          {
            id: 'three',
            label: '次次商品',
          },
        ],
      },
      {
        id: 'four',
        label: '次商品复制',
        children: [
          {
            id: 'five',
            label: '次次商品复制',
          },
        ],
      },
    ],
  },
  {
    id: 'six',
    label: '主商品再次',
    children: [
      {
        id: 'seven',
        label: '次商品再次',
        children: [
          {
            id: 'eight',
            label: '次次商品再次',
          },
        ],
      },
      {
        id: 'nine',
        label: '次商品复制再次',
        children: [
          {
            id: 'ten',
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
    index: 0,
  },
  {
    goodId: 'one',
    goodName: '商品2',
    price: 200,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 1,
  },
  {
    goodId: 'one',
    goodName: '商品3',
    price: 300,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 2,
  },
  {
    goodId: 'two',
    goodName: '商品4',
    price: 400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 3,
  },
  {
    goodId: 'two',
    goodName: '商品5',
    price: 500,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 4,
  },
  {
    goodId: 'two',
    goodName: '商品6',
    price: 600,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 5,
  },
  {
    goodId: 'three',
    goodName: '商品7',
    price: 700,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 6,
  },
  {
    goodId: 'three',
    goodName: '商品8',
    price: 800,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 7,
  },
  {
    goodId: 'three',
    goodName: '商品9',
    price: 900,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 8,
  },
  {
    goodId: 'three',
    goodName: '商品10',
    price: 1000,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 9,
  },
  {
    goodId: 'four',
    goodName: '商品11',
    price: 1100,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 10,
  },
  {
    goodId: 'four',
    goodName: '商品12',
    price: 1200,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 11,
  },
  {
    goodId: 'four',
    goodName: '商品13',
    price: 1300,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 12,
  },
  {
    goodId: 'four',
    goodName: '商品14',
    price: 1400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 13,
  },
  {
    goodId: 'five',
    goodName: '商品14',
    price: 1400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 14,
  },
  {
    goodId: 'five',
    goodName: '商品14',
    price: 1400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 15,
  },
  {
    goodId: 'five',
    goodName: '商品14',
    price: 1400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 16,
  },
  {
    goodId: 'five',
    goodName: '商品14',
    price: 1400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 17,
  },
  {
    goodId: 'five',
    goodName: '商品14',
    price: 1400,
    createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    index: 18,
  },
]
