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