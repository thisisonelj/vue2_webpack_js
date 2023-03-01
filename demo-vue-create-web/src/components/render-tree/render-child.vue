<script>
export default {
  props: {
    level: {
      type: Number,
      default: 1
    }
  },
  name: 'renderTree',
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
    let headingId = this.getChildrenTextContent(this.$slots.default)
      .toLowerCase()
      .replace(/\W+/g, '-')
      .replace(/(^-|-$)/g, '')

    return createElement(
      'h' + this.level,
      [
        createElement('a', {
          attrs: {
            name: headingId,
            href: '#' + headingId
          }
        }, this.$slots.default)
      ]
    )
  }

}
</script>
<style lang="less" scoped>

</style>
