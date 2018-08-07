	  1 散列表  Map   
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
	  
	  2 HashMap(关键字:值), 关键字key是唯一不重复的, 查找表
	  
	       1) key可以是任何对象, Value可以任何对象,
	       2) key:value 成对的放置到集合中
	       3) 重复的key算一个, 重复添加是替换操作
	       4) 根据key的散列值计算散列表, 元素按照散列值(不可见)排序
	       5) 默认的容量: 16 默认加载因子(加载率) 0.75
	       6) 根据key检索查找value值
	       7) 用于查找场合, 可以提高根据key查找效率
	
	       8) HashMap VS Hashtable
	          A HashMap 新, 非线程安全, 不检查锁, 快 大约10%      StringBuilder ArrayList
	          B Hashtable 旧 (1.2以前) 线程安全, 检查锁, 慢一点   StringBuffer Vector
	  
	  3 集合框架 (Collection and Map, 集合与映射, 容器类(cpp))
	  
	       1) List 元素有先后次序的集合, 元素有index位置, 元素可以重复
	          继承与Collection接口, 实现类: ArrayList, Vector, LinkedList
	       2) Set 元素无续, 不能重复添加, 是数学意义上的集合, 继承与
	          Collection 接口, 实现类: HashSet(是一个只有Key的HashMap)
	   
	       3) Collection 集概念, 没有说明元素是否重复和有序, 使用集合的
	          跟接口, 很少直接使用, 其他集合都是实现类: ArrayList, HashSet
	       4) Map 描述了:(key:value) 成对放置的集合, key不重复, Value
	          可以重复. key重复算一个. 实现类: HashMap(散列表算法实现)
	          TreeMap(二叉排序树实现,利用Key排序). Map适合检查查找.
	
	   4 Java泛型简介
	   
	       1) Java5 以后提出的语法现象, 在编译期间期检查的类型约束.
	          运行期不检查泛型!
	       2) 可以用来约束类中元素的类型
	  
	   5 集合的迭代(遍历算法)(模仿了数鸡蛋的方式)
	   
	       1) 迭代操作: 播放列表 的 全部播放, 将扑克牌全部发放
	       2) java使用Iterator(迭代器；迭代程序) 接口描述了迭代模式操作
	          Iterator 中的方法模式化设计, 专门配合while循环操作
	       3) Iterator 的实例可以从集合对象获得, 是这个集合的一个元素序列
	          视图, 默认包含一个操作游标, 在第一个元素之前, hasNext() 方法
	          可以检查游标是否有下一个元素, next() 方法移动游标到下一个元素
	          并且返回这个元素引用. 使用while配合这个两个方法, 可以迭代处理
	          集合的所有元素
	       4) 迭代时候可以使用迭代器   remove()    方法删除刚刚迭代的元素
	          在迭代过程中, 不能使用集合方法(add, remove, set) 更改集合
	          元素
	
	   6 Collections 集合的工具类, Arrays 数组的工具类
	       1) 排序, 二分查找, 打乱, 填充等操作 
	
	   7 比较大小
	       1) Comparable 可以比较的 用于类实现, 实现这个接口表示: 这个
	          类的实例可以比较大小的. 可以可以进行,默认排序.  Comparable
	          的实现必须与equals() 的结果一致, 就是相等的对象比较结果一定
	          是0! 
	       2) Comparator 比较工具, 用于临时定义比较规则, 不是默认比较
	          规则
	
	   8 java中的包装类
	       1) 包装类可以把基本类型包装为对象类型
	       2) 有八种包装类
	          int  Integer
	          long Long
	          byte Byte
	          short Short
	          float Float
	          double Double
	          boolean Boolean
	          char Character
	       3 包装类提供了 对应数据类型的工具方法
	          Integer.toHexString()
	          Integer.toString(int)
	          Integer.toBinaryString()
	          Integer.parseInt(String)
	          "3f"->int
	          Integer.parstInt(String str);
	    
	          "2.718" -> 2.718 
	          Double.parseDouble(String str);
	    
	         自动包装(auto boxing / unboxing)(java5 以后可以):
	         Integer i = 2;// i=new Integer(2);
	         Object o = 3.5;
	         System.out.println(o instanceof Double); //true
	         int a = i+1;// a = i.intValue() + 1;
	  
	         注意 
	         1 包装类是final的类
	         2 包装类对象是不变的, 与字符串类似(不变模式)
	           Integer a = 1;
	           Integer b = 2;
	           a = a+b;
	           //a = new Integer(a.intValue() + b.intValue())
	         3 包装类覆盖了 toString equals hashCode compareTo