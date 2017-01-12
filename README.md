# TextWatchers
关于用户输入手机号或者身份证号自动添加空格或者横线

# 前言

今天录入手机号时，突然想起之前某款软件曾经弄得是用户输入时，自动添加空格或者横线，感觉体验性很不错，那么这个该怎么实现呢？自己学习了下，下面为大家讲解~

首先来一张实体图瞅瞅，不然空口套白狼~

# 分析

首先，这个效果肯定是在用户输入的时候，通过判断输入字符长度，去显示我们想要的状态，这个时候，你就会明白，我们只需要对EditText做输入时监听即可，那么究竟该使用那儿种呢？表急，我们慢慢来~

通过搜索，我们发现Android为我们提供了android.text.TextWatcher类去方便我们管理。下面为大家介绍TextWatcher参数以及相应用法。
# TextWatcher接口简介及相关用法

进入TextWatcher类中，我们发现他内部提供了如下三个方法，那么这三个方法都干什么的呢？让我们一起来看看吧~

1) public void beforeTextChanged(CharSequence s, int start, 
int count, int after); 
- s：这里的s表示改变之前的内容，通常start和count组合，可以在s中读取本次改变字段中被改变的内容 
- start：开始的位置 
- count：被改变的旧内容数 
- after：改变后的内容数量

2) public void onTextChanged(CharSequence s, int start, int before, int count); 
- start：开始的位置 
- before：被改变的旧内容数 
- count：新增后的内容数量 
- （我们主要在这里对EditText进行修改）

3) public void afterTextChanged(Editable s); 
- 表示改变后新的内容的数量
# 传统录入与修改后效果相对比

一般的输入手机号显示的格式为：13811604922 
但是经过我们修改后就变成了：138 1160 4922或者138-1160-4922 
大家仔细看，是不是经过修改之后，用户体验性相对来说变好了呢？

而一般的身份证号输入后显示为：130725199608071212 
而经过我们修改后则变成：130 725 1996 0807 1212 
是不是感觉一下子好多了呢？
