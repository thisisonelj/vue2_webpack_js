五、css层叠规则

z-index只是其中一个部分

层叠上下文    z轴垂直方向领域    层叠水平   

层叠顺序：在同一个层叠上下文领域内，层叠上下文用z-index设置层叠上下文环境background/border<负z-index<block块状盒子<float浮动盒子<inline内敛盒子<z-index 0或者auto和不依赖z-index属性的层叠上下文<正 z-index

层叠规则：谁大谁上    后来居上    只要是重叠  那么后来的或者层叠层级大的那个永远是覆盖

层叠上下文的特性：

层叠上下文是可以嵌套的   且内部取决于外部的层叠上下文

每个层叠上下文都是独立的，互不影响，且当元素发生重叠的时候必须要考虑父元素的层叠上下文

层叠上下文的主要体现：html根元素、z-index属性主要作用于定位元素、其他css3新属性

当z-index为auto时是不能形成层叠上下文的    为数值是才可以形成层叠上下文

css3新增的层叠上下文属性：flex布局、opacity值不为1、transform值不为none

当一个元素成为层叠上下文元素的时候，它这个元素的层叠顺序就是和z-index为0和auto的层级是一样的

不依赖z-index属性的层叠上下文有：css3新属性flex布局、opacity值不为1、transform值不为none

所有的定位属性

所以层叠上下文有俩种：z-index和不依赖z-index的层叠上下文

z-index负值用途：可访问性隐藏  多背景模拟  定位在元素的后面   可以通过伪元素after和before来实现

z-index主要问题：z-index设置值不要大于2 