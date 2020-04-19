# 学习笔记
## Queue
- 队列 Queue 在 Java 中是一个接口，核心功能就是 入队、出队、查看队首
- 入队、出队、查看队首 分别实现了 "抛出异常版" 跟 "返回默认值版"

| 功能 | 抛出异常 | 返回默认值 |
| --- | --- | --- |
| 入队 | add | offer |
| 出队 | remove | poll |
| 查看队首 | element | peek |

## PriorityQueue
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