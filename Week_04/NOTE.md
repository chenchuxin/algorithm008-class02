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