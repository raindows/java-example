		1 Object
	      1) Java 类默认继承于Object! -> 啥都是东西
	         继承了Object 的属性和方法
	         如: toString(),  hashCode(), equals() 
	      2) toString() 方法, 经常有系统默认调用, 活动当前对象的
	         文本描述, Object默认返回: 全限定名@hashCode
	         建议覆盖为: 当前对象的文本描述 ;
	      3) equals 是用来比较两个对象是否相等的方法。
	         区别：引用相等 与 对象相等
	         引用值相等： 使用 “==”
	         对象的内容相等： .equals() 方法
	         equals在Object类中声明，默认的比较规则是：比较引用
	         建议覆盖，实现对象的比较(比较对象的状态，就是比较对象
	         的数据)。
	        * 覆盖规则：
	         a 自反性：对于任何非空引用值 x，x.equals(x) 
	           都应返回 true。
	         b 对称性：对于任何非空引用值 x 和 y，当且仅当 
	           y.equals(x) 返回 true 时，x.equals(y) 
	           才应返回 true。
	         c 传递性：对于任何非空引用值 x、y 和 z，如果
	           x.equals(y) 返回 true，并且 y.equals(z) 返回 
	           true，那么 x.equals(z) 应返回 true。
	         d 一致性：对于任何非空引用值 x 和 y，多次调用
	           x.equals(y) 始终返回 true 或始终返回 false，
	           前提是对象上 equals 比较中所用的信息没有被修改。
	         e 对于任何非空引用值 x，x.equals(null) 都应返回 
	           false。
	    
	      4) hashCode() 
	        A hashCode()方法要与equals方法一同覆盖
	          a 当两个对象equals比较为true时候，这两个对象应该
	            具有相同的hashCode()值
	          b 当两个对象equals比较为false时候，这两个对象应该
	            具有不相同的hashCode()值
	          c hashCode() 值要稳定（一致性），一个对象创建以
	            后就不应该再变化
	        B 默认的hashCode() 值是当前堆对象地址转换的一个整数
	            这个整数不是内存地址。
	        C 一般使用对象的OID值作为hashCode的值。
	          OID 对象的唯一编号，在工程项目中一般采用数据库来
	          生成OID，也就是数据库中的“主键”
		
		
	2 String 字符串
	
	     String 字符串 = char[] + 操作(toUpperCase(), concat())
	     类: 数据+相关的操作
	     char数组只是数据, 没有操作
	     一串字符就是字符串: char[] , String, StringBuilder
	  1 字符串"字面量"都是String类型实例
	    Stirng 内部就是一个char[].
	  2 String API 有一个实现原则: 对象内容永远不变
	    也就是说: String对象永远不变. 
	  3 String 字面量(直接量), 如果相同, 会替换为同
	    一个String对象的引用, 常量连接的结果也被优化
	    为一个字符串.
	    String s = new String("abc");
	  4 String 的比较, equals, hashCode()
	  5 String API (字符串的常用方法)
	    这些方法如果返回String 一般是一个新String对象
	    toString()  除外.
	    字符串中的字符有序号, 从0开始.
	    API 方法:
	    charAt() 
	    length()
	    trim()
	    indexOf()
	    lastIndexOf()
	    endsWith()
	    startsWith()
	    substring(int start, int end)
	    substring(int start)
	
	3 正则表达式: 负责的字符串匹配处理规则, 应用广泛.
	  学习建议: 1 要能够读懂"正则表达式"
	           2 能够写出简单的"正则表达式"
	           3 不要过多的分配学习时间!
	  可以应用于: java grep vi
	  1 字符集: [1234] 表示 1,2,3,4 之一
	            [^12] 表示除了 1,2
	            [1-5] 表示 1,2,3,4,5
	            [a-f] 表示 a-f 之间的
	            [0-9a-fA-F] 表示:一个16进制字符
	            
	            0[xX][0-9a-fA-F]{1,8}
	            [\w-]{8,15}
	    预定义字符集:
	            \d : [0-9]
	            . : 任意字符
	            \w: 单词字符 [0-9a-zA-Z_]
	            \s: 匹配空白: \t \n \r \b \p
	            
	            \D
	            \S
	            \W
	 
	  2 {m,n} 数词
	       {n}
	       {m,n}
	       ? : {0,1}//有或没有
	       + : {1,}
	       * : {0,}
	  
	  3 ^ 开头
	    $ 结尾  
	 
	  
	邮政编码: ^[0-9][0-9][0-9][0-9][0-9][0-9]$
	         ^[0-9]{6}$
	         ^\d{6}$
	         
	用户名规则: ^\w{8,10}$
	电话号:  +86 13912345678
	        ^(\+86)?\s?\d{11}$
	身份证号码: ^\d{15}(\d{2}[0-9xX])?$
	一个点的坐标: ^\d+(,\s*|\s+)\d+$ 
	            ^\d+[,\s]\s*\d+$ 
	     答案规则^\s*A?(\s+|,\s*)B?(\s+|,\s*)C?(\s+|,\s*)D?\s*$
	            
	            
	日期: 2011-01-30 
	       ^\d{4}-\d{2}-\d{2}$
	       ^\d{4}(-\d{2}){2}$
	
	  IP 地址: 192.168.0.2
	          ^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$
	          ^\d{1,3}(\.\d{1,3}){3}$
	          ^(\d{1,3}\.){3}\d{1,3}$
	           
	String 对正则表达式的支持
	  .matches() 匹配正则表达式
	  .split("[,\s\|]") 切分字符串为字符串数组
	  .replaceAll()
	
	Integer.parseInt() 转换到字符串到整数: 如: "23"-> 23
	