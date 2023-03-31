1.border-radis:具有圆角特性的css3属性，具有四个值来分别实现四个角的圆形效果，分别为

左上、左下、右上、右下    此外还可以通过设置   水平路径/垂直路径  这种方式来更加具体化的

实现各种圆角效果    例子：圆   半圆   椭圆

2.transform转换：

css3新特性变换属性   可以有translate、rotate、scale、skew四种

主要特性：类似relative   处于文档流中的dom空间和位置不发生改变    即不影响周围元素和布局

所作的变化仅仅是视觉上的改变   即另一层级

仅仅对inline-block、block元素有效   对纯内联元素无效

可以同时做多个变换  但是顺序不同   最终效果不同

clip/clip-path前置剪裁   这个特性永远是先剪裁后变换

具有层叠上下文特性   会形成   层叠水平很高   和定位层叠水平一样

会使固定定位失效   fixed定位失效

改变overflow对绝对定位元素的限制    可以使用transform来剪裁定位属性配合overflow

可以成为绝对定位元素的包含块

transform-origin：该属性可以改变变换元素作用的中心点坐标     

意思就是可以优化或者稍微调整下变换元素的变换效果    支持数值、百分比 、关键字属性值  left|right|top|bottom

zoom属性类似scale()   也是表示缩放的一种    但是它是处于文档流中的   变换的效果是会影响周围元素

布局的     作用的中心点是元素的左上角

3.calc() 函数

该函数是用于css动态计算、自适应、尤其是当元素宽度和高度不确定的时候可以使用该函数来定义当前元素

尺寸大小    例子进度条样式   可以采用var()变量配合calc()函数来自定义不同进度条

min()、max()  函数返回最小、最大值

clamp()函数用于在某一个区间内返回确定一个值

以上函数多用于自适应和响应性场景中

4.css过渡

transition属性有四个属性组成   transition-duration|transition-delay|transition-property|transition-

function    过渡时间、过渡延时时间、过渡的属性、过渡参考的时间速率

过渡是对css属性的变化    即声明要过渡的css属性的初始值和变化后的值   

过渡与visiblity、opacity可见性的结合可以实现淡入淡出、移入移出的效果

5.animation动画

animation该属性主要有动画名称、动画时间、动画规则、关键帧@keyframes这四个元素

动画规则可以由from\to    百分比来表示每一帧   

动画中的关键帧属性的权重相比于作用于当前元素的其他css属性的样式优先级是最高的

比style内联   ！impotant都要高

负延时和即时调用   animation-delay可以为负数   意味着动画已经提前开始   比如延时时间-0.25s

动画总时间是1s    那么动画实际开始应该是已经走了25%的进度了   

reverse和alternate都代表这动画方向相反  前者代表每一轮动画都是相反的    后者代表下一轮动画

和上一轮动画是相反的    常见例子钟表的摆动

动画的播放次数可以是小数  animation-iteration-count    但不可以为负数    

比如1.5代表着一轮动画完成加上半轮动画

animation-fill-mode  动画填充模式    backwards和forwards  前者保持动画开始时初始状态永远是动画的

第一帧状态    后者保持动画结束时结束状态永远是动画的最后一帧状态   意思就是没有突变的状态变更

both值为二者兼具   一般设此属性值

控制动画暂停和播放：animation-play-state   值running为播放状态    值paused为暂停状态

6.flex布局

flex布局中主要的固定全局属性：直接利用即可   不需要设置除flex全局属性外的其他属性

flex布局子项是flex容器的直接子元素只有这样flex布局才能生效

flex布局主要特性：无论子项是什么元素  inline|inline-block|block    在flex布局中每个子项都是block

flex子项使用float是无效的

flex子项支持z-index属性

flex子项的margin不会合并

flex子项是具有格式化高度和宽度的   意味着类似绝对定位absolute一样    是具有自适应特性的

flex-direction   决定整体布局方向   row|column   和文档流方向相关

flex-wrap   决定整体布局换行   wrap|nowrap  

flex-flow  direction和wrap的结合版   取值和其俩者相同

justify-content   决定整体水平方向对齐布局     属性值 略

align-items  决定整体垂直方向对齐布局     属性值 略     align-self  对子项有用 可以调整自己布局   

属性值和align-items属性值一样

align-content 决定整体垂直方向对齐布局  和align-items属性可以进行比较

order决定子项顺序    值越小越排在前面

flex子项属性

flex取值可以有三个值   其中flex-grow和flex-shirnk俩者只能是数值   且shirnk后者默认为1 可以省略

grow默认为0    flex-basis只能是长度值   px|百分比|其他相对单位   默认值为0%

当为1个值时    如果是数字   则表示1 1 0%   如果是长度值  则表示1 1 长度值

当为2个值时   数字肯定表示grow   长度肯定表示flex-basis    shirnk是可以省略的  默认值为1

当为3个值时   这时自行判断

flex-grow  该属性只会在容器宽度剩余或者足够的时候才起作用   自适应分配剩余可利用空间

flex-shirnk  该属性只会在容器宽度不足或者不够的时候才起作用   包裹性自动压缩子项空间  防止溢出

flex-basis   该属性设置一个初始默认值   以便子项有一定的默认宽度

flex:initial  表示0 1 auto  flex子项默认初始值

flex:0  表示flex:0 1 0%    

flex:none   0 0 auto    不能换行显示的元素上   比如按钮

flex:1  1 1 0%  最常用的   等分布局  自适应布局

flex：auto   1  1  auto    动态分布内容布局

flex布局当中  flex子项最小分配尺寸影响因素：优先级：min-width>(width和元素内容宽度进行比较  谁小用谁)

flex布局当中   最后一行不对齐处理办法：自行设置margin处理子项间距