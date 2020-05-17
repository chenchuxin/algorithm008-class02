# 深度优先搜索 (dfs) 和 广度优先搜索 (bfs)
- 要用到 dfs、bfs 一般就是暴力求解了，把各种路径走一遍。
- 剪枝一般就是优化 dfs、bfs 的最有效手段，毕竟剪枝很多时候可以避免走很多没有用的路径
- 这两种算法应用的经典题目就是 树的遍历。
    - 树经典的前中后序遍历，就是 dfs。
    - 树一层一层遍历就是 bfs
- dfs 和 bfs 的区别就是：
    - dfs：一条路径一路走到底，走到无路可走。再选择另一条路
    - bfs：一层一层扩散地遍历

## dfs
- 通常用递归实现，也可以用栈手动模拟递归的调用栈。

以下是代码模板：
一定要注意考虑`visited`，不然遇到图就会重复访问，无限递归了

- 递归写法
```python
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

- 非递归写法
```python
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

## bfs
- bfs 的特点就是一层一层遍历
- 通常用一个队列来维护
- 同样要注意考虑 `visited`

```python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

# 贪心算法
- 当下做局部最优判断，不能回退
- 用贪心算法之前，一定要确认，局部最优，是否代表这全局最优
- 一旦判断可以用贪心算法，通常都能以很简洁又高性能的代码
- 贪心算法虽然可能结果不对，但是通常来说会比较接近正确答案，如果对结果要求不高，可以用贪心算法辅助计算

# 二分查找
- 二分查找指的是，从一个有序的序列中，每次从中间拿出一个数跟目标数字对比而收敛目标位置的方法
- 二分查找的前提
    - 目标序列的有序性(否则无法收敛)
    - 存在上下界(否则无法求中间数)
    - 能够通过索引访问(否则定位中间数所需的复杂度高)

二分查找的代码模板
- 注意数字的溢出
```python
def search(array):
    left, right = 0, len(array) - 1 
    while left <= right: 
        # mid = (left + right) / 2 可能 int 会溢出
        mid = left + (right - left) / 2 
        if array[mid] == target: 
            # find the target!! 
            break or return result 
        elif array[mid] < target: 
            left = mid + 1 
        else: 
            right = mid - 1
```