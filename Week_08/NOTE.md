# 位运算
| 含义 | 运算符 | 解释 | 实例
| -- | -- | -- | -- |
| 左移 | `<<` | 整个二进制串左移，溢出的抹掉 | `0011 << 1 == 0110` |
| 右移 | `>>` | 整个二进制串右移，溢出的抹掉| `0110 >> 1 == 0011` |
| 位或 | `|` | 有一个 1，就是 1 | `0011 | 1011 == 1011` |
| 位与 | `&` | 有两个 1，才是 1 | `0011 & 1011 == 0011` |
| 按位取反 | `~` | 0 和 1 取反 | `~0011 == 1100` |
| 异或 | `^` | 相同得 1，不同得 0 | `0011 ^ 1001 == 1010` |

## 应用
### 异或：
```
x ^ 0 = x
x ^ 1s = ~x      // 注意1s = ~0
x ^ (~x) = 1s    // 1s 表示整个二进制串都是 1
x ^ x = 0
c = a ^ b   =>   a ^ c = b, b ^ c = a      // 交换两个数
a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c     // associative 
```
### 指定位置的位运算

- 将 x 最右边的 n 位清零：`x & (~0 << n)`
- 获取 x 的第 n 位值（0 或者 1）：`(x >> n) & 1`
- 获取 x 的第 n 位的幂值：`x & (1 <<n)`
- 仅将第 n 位置为 1：`x |  (1 << n)`
- 仅将第 n 位置为 0：`x & (~ (1 << n))`
- 将 x 最高位至第 n 位（含）清零：`x & ((1 << n) -1)`
- 将第 n 位至第 0 位（含）清零：`x & (~ ((1 << (n + 1)) -1))`

### 实战位运算要点
- 判断奇偶：
    - x % 2 == 1  —> (x & 1) == 1
    - x % 2 == 0  —> (x & 1) == 0
- x >> 1 —> x / 2.
     即：`x = x / 2`   —>    `x = x >> 1`
        `mid = (left + right) / 2`   —>    `mid = (left + right) >> 1`
- X = X & (X-1) 清零最低位的1 [重要]
- X & -X => 得到最低位的1
- X & ~X => 0

# 布隆过滤器
- 使用多个 哈希函数 要加入的值进行哈希运算，计算出多个哈希值，放到对应的多个槽
- 布隆过滤器可能会误识别：
    - 例如数值 A 计算出的哈希值是 `1,2`，B 计算出的哈希值是 `1,3`。把 A 和 B 存进布隆过滤器
    - 现在有一个值 C，想判断是否存在。C 计算出的哈希值是 `2,3`，刚好 A、B 把 `2,3` 填充过了，此时就会误识别
- 如果不存在，一定就是不存在
- 布隆过滤器极其省空间，因为都是存 bit。一般用于基数很大的例如垃圾邮件识别等等。

# LRU 缓存
- 最近最少使用的缓存
- 淘汰策略是：给定一定长度的数组(链表)，访问、插入元素的时候，会把这个元素放到最前面，当长度不够的时候，会淘汰最后一个元素。

# 排序

> 参考：https://www.cnblogs.com/onepixel/p/7674659.html

## 分类
![](img/sort.png)

## 复杂度
![](img/sort_complexity.png)

## 各种排序详讲
### 冒泡排序
- 两层循环
- 相邻两个数比较，用交换的方式，把大的放后面
- 每一遍都会把当前最大的数找到，放在最后面

```python
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(len(nums) - i - 1):
                if nums[j] > nums[j + 1]:
                    nums[j], nums[j + 1] = nums[j + 1], nums[j]
        return nums
```

下面这个是不对的

```python
# 这个是伪冒泡排序！！！
def fake_bubble(num):  
    count = len(num)
    for i in range(count):
        for j in range(i + 1, count):
            if num[i] > num[j]:
                num[i], num[j] = num[j], num[i]
    return num
```

### 选择排序
- 两层循环
- 每次遍历选出最小的值，跟第一个未排序的数交换

```python
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        for i in range(0, len(nums)):
            minIndex = i
            for j in range(i + 1, len(nums)):
                if nums[minIndex] > nums[j]:
                    minIndex = j
            nums[0], nums[minIndex] = nums[minIndex], nums[0]
        return nums
```

### 插入排序
- 两层循环
- 当前元素跟前一个元素比较，如果小于前一个元素，交换。直到比前一个元素大或者是第一个元素了。
- 每次遍历都会把当前索引之前的数排序好

缺点：
- 合并的时候需要需要额外的空间

```python
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        for i in range(1, len(nums)):
            pre = i - 1
            cur = i
            while cur > 0 and nums[pre] > nums[cur]:
                nums[pre], nums[cur] = nums[cur], nums[pre]
                pre -= 1
                cur -= 1
        return nums
```

### 归并排序
- 将数组分成两个子数组
- 左右各采用归并排序（如果个数大于1，则继续分）
- 将左右排序好的数组合并

```python
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def merge(nums1, nums2):
            len1 = len(nums1); len2 = len(nums2)
            res = []
            idx1 = 0; idx2 = 0
            while idx1 < len1 and idx2 < len2:
                if nums1[idx1] <= nums2[idx2]:
                    res.append(nums1[idx1])
                    idx1 += 1
                else:
                    res.append(nums2[idx2])
                    idx2 += 1
            if idx1 < len1: res += nums1[idx1:]
            if idx2 < len2: res += nums2[idx2:]
            return res

        if len(nums) <= 1: return nums
        mid = len(nums) // 2
        left = nums[:mid]; right = nums[mid:]
        return merge(self.sortArray(left), self.sortArray(right))
```

### 快速排序
- 从数组中挑一个元素作为基准（pivot），通常我们拿第一个
- 把所有小于基准的元素放到左边，所有大于基准的放右边，相等的随便放哪一边都行。此操作成为分区（partition），方法会返回最终基准的位置
- 根据基准的位置，分成左边和右边继续递归
```python
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def partition(left, right):
            pivot = left; border = left + 1
            for i in range(border, right + 1):
                if nums[i] < nums[pivot]:
                    nums[i], nums[border] = nums[border], nums[i]
                    border += 1
            nums[pivot], nums[border - 1] = nums[border - 1], nums[pivot]
            return border - 1
        
        def querySort(left, right):
            if left >= right: return
            border = partition(left, right)
            querySort(left, border - 1)
            querySort(border + 1, right)
        
        querySort(0, len(nums) - 1)
        return nums
```