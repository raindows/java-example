	1 集合补遗
	  1) 集合复制, 默认的复制规则是浅表(浅层)复制
		   A clone() 方法
		    
		   B 使用复制构造器!
		   Map map = new HashMap();
		   Map map2 = new HashMap(map);
		   
		   List list1 = new ArrayList();
		   List list2 = new LinkedList(list1);
	  2) 同步化(线程安全的)
		   List list = new ArrayList();
		   //synchronizedList 可以将非线程安全的list包装为线程安全的
		   list = Collections.synchronizedList(list); 
		   转换以后就相当于 Vector
		   HashMap map = new HashMap(); 
		   //synchronizedMap 可以将非线程安全的map包装为线程安全的
		   map = Collections.synchronizedMap(map);
	     
	  3) 数组与集合的转换
		  a 数组转List(只读的) 
		    
		     String[] names = {"A","B","C"};
			 List list = Arrays.asList(names);//只读list
		     list = new ArrayList(list);//复制为全功能List
		     Set set = new HashSet(list);//复制为Set集合
		     
		  b 集合转数组
		  
		     Object[] ary1 = list.toArray();//集合转Object[]
		     String[] ary2 = (String[])
		     list.toArray(new String[]{});//集合转制定类型数组
		  
		 4) Collection 与 Collections
			   Collection 集合框架的接口、抽象的集合概念,
			   Collections 集合静态工具类, 包含集合的工具方法
		      (sort, 打乱(洗牌)等)
		 
		 5) Map的迭代, Map 是 [Key:Value] 组成的集合
		  A 对key:value 进行迭代
		    map.entrySet();
		  B 对Key进行迭代
		    map.keySet();
		  C 对Value进行迭代
		    map.values();
		  案例: 统计每个字符出现的次数
	  
	2 内部类- 定义在类的内部 的类， 根据位置分为4类
	
	  1) 静态内部类：使用static修饰，声明在类体中.
	     静态内部类中可以访问外部类的静态成员。
	 
	  2) 成员内部类: 声明在类体中，不使用static，具有类的成员特征
	   也就是，必须有类的实例才能创建内部类实例。内部类实例
	   可以访问共享外部类的成员变量。很常用。
	   如：链表的节点就可以定义为内部类
	  3) 局部内部类：把类声明在方法中，就是局部内部类，作用域
	   类似局部变量。很少见。
	  4) 匿名内部类，匿名类：非常常见，可以写在任何地方,就像一般的语句。
	    语法更象是创建对象：
	    	Date d = new Date(){};
	    匿名类是对原类的一个继承，同时创建了实例，{} 就是继承
	    以后的类体。类体中可使用所有类的语法。
	    匿名类不能写构造器。
	    匿名类可以从抽象类或者接口继承，
	    必须提供抽象方法的实现。
	  5) 任何内部类都编译成独立的class文件
	  6) 最大的作用：封装！封装内部概念:
	    情侣间的土豆和菜市场的土豆是不一样的
	  7) 通过实例简单理解记忆语法.在今后的案例中灵活练习内部类
		
	3 时间日期
	  时间类的本质: Date = long + 操作
	              Calendar = long + 操作
	  时间的标准: (1970)GMT long   (0)UTC long
	  
	  1) java 中基本的时间表示 GMT long 
	  2) Java提供了Date类型表示时间和日期
	    Date 是long类型的包装
	  3) Calendar 是历法的的抽象.
	    历法: 公历, 农历, 太阳历, ...
	    GregorianCalendar 是历法的实现, 采用公历
	    (太阳历) 算法实现的. 
	    Calender cal = Calender.getInstance();
	  4) Date 和 Calendar 的默认值就是当前时间
	  
	  5) 时间的类型转换
	       new Date(long)
	         date.setTime(long)  cal.setTime(Date);
	         ---------->      --------->
	   long <---------- Date <---------  Calendar
	        date.getTime()     cal.getTime()     
	    	
	  6) 时间的计算
	    Calendar 提供丰富的时间计算方法  add() set() 等
	    如: 计算商品的促销日期special Date:
	    输入: 商品生产日期, 和保质期月份
	    返回: 商品的促销日期, 是过期前两周周的周五
	    
	  7) 日期的输入与输出, 
	  	日期输出: 的本质是 Date 转换为格式化的String
	  	日期输入: 的本质是 将格式化的String转换为Date
	    java.text.SimpleDateFormat fmt = 
	      new SimpleDateFormat("yyyy-MM-dd");
	     									
	    构建SimpleDateFormat 一般提供日期的格式
	     "yyyy-MM-dd" 具体参看 javadoc
	    如: "yyyy-MM-dd HH:mm:ss"
	       "yyyyMMdd"
	       "dd/MM/yyyy"
	       "MM/dd/yyyy"
	    
	    fmt.parse(String)可以实现将(合法)字符串解
	     析为日期类型, 经常用于处理日期输入.
	     
	    fmt.format(Date) 可以把日期格式化为字符串
	     用于输出处理.