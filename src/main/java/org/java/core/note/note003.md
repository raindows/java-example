		1 Java Bean
	     关于JavaBean规范
	     1) JavaBean 不是语法规范，是习惯性编程规范，用这个规范
	        写的类使用方便。有时候JavaBean的类也称为:POJO
	        Plan Old Java Object
	  
	     2) 简化规范：
	        a 必须有包.
	        b Java类，具有无参数构造器。
	        c 有用getXxx() 和 setXxx() 声明的Bean属性。
	          如：getName() 和 setName(String n) 声明的
	          Bean属性为：name, 与是否有实例变量name无关.
	          boolean类型的get方法可以有两种形式：
	         * getMarried() 或者 isMarried()*
	        d 必须实现序列化接口(在学习IO的时候具体学习。)
	        e JDK提供的类几乎都符合JavaBean规范。
	          如：String
	   
	     3) JavaBean 最大的好处：“使用方便”
	
	2 static(在内存中就一份但可以改) 静态 关键字, 修饰: 属性, 方法, 内部类, 代码块
	 
	     static修饰的资源属于类级别, 是全体对象实例共享的资源(属性, 方法, 内部类)
	     1) 静态属性, 使用static修饰的属性, 是在类的加载期间初始化
	        是属于类的, 全体类的实例共享的变量, *使用类名访问属性*.
	        实例变量: 属于对象的属性.
	     2) static 方法, 使用static声明的方法, 属于类的方法, 一般
	        用来表示工具方法. 在类加载以后就可以自己调用, 不需要创建任何
	        类的实例. 
	     3) 静态代码块，是在类加载期间运行的代码块，由于类只加载
	        一次，所以静态代码块只执行一次！
	        用途不是很常见,一般用来在类加载以后初始化一些静态资源
	        时候使用，如：加载配置文件。
	 
	     4) 静态内部类（在内部类专题讲解）
	
	3 final （在内存中可以多份,但在每份各自中不能改）最终的
	 
	     1) final 修饰的类，不能再被继承。
	       *** Java 的String就是final类，不能被继承！
	       *** Math 也是final
	       *** Integer (包装类)
	        在实际项目开发中，原则上不允许使用final类！
	        Spring, Hibernate,Struts 2, 这个框架经常动态继承
	        代理我们的类。使用final的类可能造成这些框架的工作问题
	 
	     2) final修饰的方法，不能再被覆盖。
	        在实际项目开发中，原则上不允许使用final方法！
	  
	     3) final 修饰的变量，初始化以后不允许再修改了。
	         a final 局部变量
	         b final 方法参数
	         c final 的成员变量
	     4) final static -- Java使用final static修饰的变量作为常量。
	         一般要求常量名都用大写字母。
	         常量不是: const
	
	
	4 abstract class 抽象类--不具体的类
	 
	     1) 抽象方法，只有行为的概念，没有具体的行为实现。
	        使用：abstract 关键字修饰，并且没有方法体。
	     2) 包含抽象方法的类，就一定是抽象类。
	        使用： abstract 关键字修饰，包含抽象方法。
	        如：平面图形一定可以计算面积。
	
	     3) 抽象类不能直接创建实例。可以定义引用变量。
	     4) 抽象类只能被继承，一个具体类继承一个抽象类，必须实
	        现所有抽象方法。  
	     5) 抽象方法和抽象类非常适合作为系统的分析和设计的工具。
		     public class abstract CRM System{
		         public abstract Client add(Client newGuy);
		         public abstract Event add(Event e, Client guy);
		         public abstract Event[] todayEvents();
		      }
	
	5 接口, 相当于纯抽象类(cpp纯虚类)
	 
	     1 接口：全部的方法都是抽象方法，全部的属性都是常量。
	       接口用来表示纯抽象概念，没有任何具体的方法和属性。
	         public interface CRMSystem{
		         Client add(Client newGuy);
		         Event add(Event e, Client guy);
		         Event[] todayEvents();
	         }
	     2 不能实例化，可以定义变量。
	     3 接口变量可以引用具体实现类的实例。
	     4 接口只能被实现(继承)，一个具体类实现接口，必须使用全部的
	       抽象方法。
	     5 *接口之间可以继承。*
	     6 一个具体类可以实现多个接口，实现多继承现象，表示：
	       一个概念即是XXX也是XXX.
	     7 接口中的属性，默认是常量 public static final 
	     8 接中的方法一定是:public abstract 
	     9 实现一个接口，使用关键字implements, 实现实际上是
	       一种继承关系。接口和实现类是父子类型的关系
	
	5 Object
	 
	     1) Java 类默认继承于Object! 继承了Object 的属性和方法
	        如: toString(),  hashCode(), equals() 
	     2) toString() 方法, 经常有系统默认调用, 活动当前对象的
	        文本描述, Object默认返回: 全限定名@hashCode
	        建议覆盖为: 当前对象的文本描述 
	 