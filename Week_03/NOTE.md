# 学习笔记

## 递归
- 一般一段复杂的程序都能找到重复的地方
- 使用递归很多时候能够让代码很简洁
- 递归是计算机擅长的，人不擅长于递归，所以熟悉后不要手动递归
- 递归按照模板来，不迷路

**python**
```python
def recursion(level, param1, param2, ...): 
    # 终止条件
    if level > MAX_LEVEL: 
	   process_result 
	   return 
    # 处理本层
    process(level, data...) 
    # 递归 
    self.recursion(level + 1, p1, ...) 
    # 如果有需要，清理本层状态
```

**java**
```java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}
```