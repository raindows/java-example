	1  String 对正则表达式的支持
	  .matches() 匹配正则表达式
	  .split("[,\s\|]") 切分字符串为字符串数组
	  .replaceAll()
	
	  Integer.parseInt() 转换字符串为整数: 如: "23"-> 23
	  
	2 StringBuilder 和 StringBuffer
	  String = char[] + 操作(复制创建新对象)
	  StringBuilder=char[] + 对char[]操作(处理当前数组内容)
	  StringBuilder 内部的char[]数组内容可变, 如果长度
	  不够, 利用变长算法维护, 自动扩容长度.
	
	 1) StringBuilder 是变长字符序列
	 2) StringBuilder 方法：append，insert ... 都返回
	   当前 StringBuilder 对象本身的引用。
	 3) 如果软件需要大量字符串处理时候建议使用StringBuilder
	   "A" + "B"
	 4) String s = s1+s2; Java实际上才是如下代码运行：
	   String s=new StringBuilder(s1).append(s2).toString();
	   	
	   String s = s1+s2+s3+s4; 被优化为
	   String s = new StringBuilder(s1)
	   	.append(s2).append(s3).append(s4).toString();
	   
	   s+="a";//会产生两个新对象(StringBuilder, String)
	
	   StringBuilder buf=new StringBuilder();
	   buf.append("a");
	   buf.append("a");
	   
	 5) StringBuffer 和 StringBuilder API几乎一样！
	   StringBuffer 是java早期提供的，速度稍慢，线程安全
	   StringBuilder 是Java5 以后提供的，速度快，非线程安全
	
	char[]  Stirng  StringBuilder(1.5) ==? StringBuffer(1.0)
	                   非线程安全 非同步        线程安全 同步 
	
	3 线性表: List, 表示有先后次序的对象集合, 歌曲列表
	  ArrayList = Object[] + 线性表操作(增删改查)（Object对象）  
	  StringBuilder = char[] + 操作(增删改查)（数组） 
	  
	  ArrayList(1.2以后新的) 是使用变长数组算法实现的 
		List (线性表方法)
	  Vector(1.0) 是使用变长数组算法实现是 List 矢量 向量
	
	  LinkedList 是采用双向循环链表实现的List 
	
	List 集合的实现
	  1 LinkedList 采用双向循环链表实现
	  2 ArrayList 变长数组算法实现 新的 快 非线程安全
	  3 Vector 变长数组算法实现 早期提供 慢 线程安全
	                              
	
	4 线性表的应用
	  贪吃蛇
	  1 蛇是节点的(线性)集合,
	    节点在行列坐标(i,j)的位置
	  2 蛇可以走, 继续向当前方向走一步
	    也可以向指定方向走一步, 不能反向
	    蛇可以吃, 一个坐标上的东西.(以后再考虑)
	  3 蛇在一个面板中运行, 面板控制行列坐标
	    面板可以提供文字界面的打印方法, 显示出一条蛇
	  4 重构Worm类提供检查坐标是否在蛇身上的方法
	  5 提供测试类测试蛇的面板运行.
	
	5 Map   
	  1 HashMap 新
	  2 Hashtable 旧 (1.2以前)
	  
	散列表概念
	  1 容量: 散列表中散列数组大小.
	  2 散列运算: key->散列值(散列数组下标)的算法, 
	  	如: "mm".hashCode()%10->8
	  3 散列桶: 	散列值相同的元素的"线性集合"
	  4 加载因子: 就是散列数组加载率, 一般小于75%性能比较理想
	  	就是:元素数量/散列数组大小, 如: 7/10=70%
	  5 散列查找: 根据Key计算散列值, 根据散列值(下标)找到
	    散列桶,在散列桶中顺序比较Key, 如果一样, 就返回value
	  6 散列表中Key不同, Value可以重复