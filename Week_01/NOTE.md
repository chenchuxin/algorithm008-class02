# 学习笔记

## 一、数组、链表、跳表
### 1. 特性
- 数组：内存连续空间。插入/删除需要移动其他元素，比较慢，随机查询快
- 链表：不连续的空间，前后元素用指针相连。插入/删除只需要更改指针，比较快; 随机查找必须遍历链表，因此查询慢。
- 跳表：在链表的基础上，多添加几个链表，添加一个 down 指针，做用索引。使用跳表的前提是要有序。
    ```
     +-+    next         +-+                 +-+   
     |1|---------------->|5|-----------------|9|->null
     +-+                 +-+                 +-+   
      | down              |                   |   
      v                   v                   v   
     +-+       +-+       +-+       +-+       +-+  
     |1|------>|3|------>|5|------>|7|-------|9|->null
     +-+       +-+       +-+       +-+       +-+  
      |         |         |         |         |   
      v         v         v         v         v            
     +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+ 
     |1|->|2|->|3|->|4|->|5|->|6|->|7|->|8|->|9|->null
     +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  
    ```

## 二、栈、队列、优先队列、双端队列

### 1. 特性
- 栈：后进先出 LIFO
- 队列：先进先出 FIFO
- 优先队列：根据优先级出队
- 双端队列：栈和队列的结合体，可以在队首、队尾进行增加、删除操作。工程实践中推荐使用双端队列替换栈和队列

### 2. Java 源码分析
#### (1) Queue
- 队列 Queue 在 Java 中是一个接口，核心功能就是 入队、出队、查看队首
- 入队、出队、查看队首 分别实现了 "抛出异常版" 跟 "返回默认值版"

| 功能 | 抛出异常 | 返回默认值 |
| --- | --- | --- |
| 入队 | add | offer |
| 出队 | remove | poll |
| 查看队首 | element | peek |

#### (2) PriorityQueue
- 优先队列 PriorityQueue 实现了 Queue 接口。
- 其内部维护了一个小顶堆，底层数据结构是数组。
- 每次入队、出队都会对小顶堆进行调整，保持最小的在第一个元素。
- 如何排序：(如果以下两种都没有，那么会抛出异常)
    - 构造函数中传入的比较器
    - 对象实现 Comparable 接口
- 方法的时间复杂度如下表：

| 方法 | 时间复杂度 | 解释 |
| --- | --- | --- |
| offer、poll、remove()、add | O(logn) | 需要维护小顶堆 |
| remove(Object)、contains(Object) | O(n) | 需要遍历数组才能找到对应的对象 |
| element、peek | O(1) | 只需要查询数组首位 |

## 三、刷题感想
按照超哥的方法，之前觉得不太可能实现的日刷一题，也没有那么难。
<br>没有报班之前，尝试过日刷一题，坚持没两天就放弃了。一来没有氛围，二来老是去死磕题目。
<br>"有一些题目，任凭你怎么想都想不出来怎么做，这个时候看一下题解，记下就行了。"这一点感触非常深啊。
<br> 一开始在选择加入哪个学习小组的时候，第一个就选了"996"组，因为感觉自己工作也挺忙，正常 9 点才下班，晚一点 10、11 点这样，公司也刚执行大小周。
<br>在正式开始前一天晚上睡前，躺在床上想了好久，我究竟要不要选择"刷题狂魔"组，最后还是决定加入了。
<br>在这一周里，有几个晚上十点、十一点才下班，回到家第一时间就想着刷题，都坚持下来了。嘿嘿，这是之前不敢想的。
<br>有时候，不逼自己一把，都不知道自己有多牛bi。
<br>希望在接下来的日子里，我能坚持日刷一题。刷题狂魔！走起！