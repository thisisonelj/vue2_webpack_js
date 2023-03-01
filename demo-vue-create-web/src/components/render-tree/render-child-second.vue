<script>
export default {
  props: {
    formRender: {
      type: Array,
      default: function () {
        return []
      }
    }
  },
  name: 'renderTreeSecond',
  data () {
    return {
      title: 'render语法'
    }
  },
  methods: {
    getChildrenTextContent (children) {
      return children.map(function (node) {
        return node.children
          ? getChildrenTextContent(node.children)
          : node.text
      }).join('')
    }

  },
  render: function (createElement) {
    // 创建 kebab-case 风格的 ID
    // if (Array.isArray(this.$slots.default)) {
    //   let headingId = this.getChildrenTextContent(this.$slots.default)
    //     .toLowerCase()
    //     .replace(/\W+/g, '-')
    //     .replace(/(^-|-$)/g, '')
    // }
    let formData = []
    this.formRender.forEach(element => {
      formData.push(createElement(element.type, {
        attrs: {
          value: element.attr
        }
      }))
    })
    // debugger
    return createElement(
      'div',
      {
        class: {
          'render-form': true
        }
      },
      this.formRender.map(element => {
        return (element.type === 'Input')
          ? createElement(element.type, {
            attrs: {
              value: element.attr
            },
            style: {
              width: '50%'
            }
          })
          : createElement(element.type, {
            attrs: {
              value: element.attr
            },
            style: {
              display: 'block',
              margin: 'auto',
              'margin-top': '20px'
            }

          }, this.$slots.default)
      })
    )
  }

}
</script>
<style lang="less" scoped>

</style>
<style lang="less">
.render-form{
    height: 200px;
    text-align: center;
}
</style>
