source：阿里巴巴java 开发手册1.7

一、编程规约
1.1、命名风格
1.所有编程相关的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。解释：保证变量、类、方法命名的规范性，不允许下划线与美元等特殊字符可能具有特定的含义或者被语言本身保留使用，不利于代码的一致性与可读性。

2.所有的编程命名不允许中英文混合，一般使用纯英文，一些国际通用的纯中文也可以视为纯英文，比如：alibaba

3.代码中的命名以及注释中都不允许出现带有侮辱或者种族歧视的词语。

4.类名使用大驼峰命名规则，例如：ForceCode，以下情形例外：DO / PO / DTO / BO / VO / UID 等，例如：UserDO

5.方法名、参数名、成员变量、局部变量都统一使用 小驼峰命名风格，例如：localValue / getHttpMessage()

6.常量命名应该全部大写，单词间用下划线隔开，例如：MAX_STOCK_COUNT

7.抽象类命名使用 Abstract 或 Base 开头(抽象类用来被继承)；异常类命名使用 Exception 结尾，测试类命名以它要测试的类的名称开始，以 Test 结尾。

8.类型与中括号紧挨相连来定义数组。例如：int[] a 尽量不要写成 int a[]

9.POJO 类中的任何布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。注意：需要在<resultMap>设置从 is_xxx 到 xxx 的映射关系。

10.包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形
式，但是类名如果有复数含义，类名可以使用复数形式。例如包名： com.alibaba.ei.kunlun.aap.util 例如类名： MessageUtils

11.避免在子父类的成员变量之间、或者不同代码块的局部变量之间采用完全相同的命名，使可理
解性降低。

12.杜绝完全不规范的英文缩写，避免望文不知义，使用完整的英文单词。

13.为了达到代码自解释的目标，任何自定义编程元素在命名时，使用完整的单词组合来表达。

14.在常量与变量命名时，表示类型的名词放在词尾，以提升辨识度，例如：startTime/workQueue/nameList/TERMINATED_THREAD_COUNT

15.如果模块、接口、类、方法使用了设计模式，在命名时要体现出具体模式。便于代码阅读者快速理解架构的设计思想。例如： public class OrderFactory // 工厂模式
public class LoginProxy // 代理模式
public class ResourceObserver // 观察者模式

16.接口类中的方法和属性不要加任何修饰符号（public 也不要加），保持代码的简洁性，并加上
有效的 Javadoc 注释(类名，创建者，时间，描述信息)。例如：void commit() ;

17.接口和实现类的命名有两套规则，第一套规则是
1）【强制】对于 Service 和 DAO 类，基于 SOA (面向服务架构思想)的理念，暴露出来的服务一定是接口，内部的实现类用 Impl 的后缀
与接口区别。
正例：CacheServiceImpl 实现 CacheService 接口。
2）【推荐】如果是形容能力的接口名称，取对应的形容词为接口名（通常是 –able 结尾的形容词）。
正例：AbstractTranslator 实现 Translatable。

18.枚举类名带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。枚举其实就是特殊的常量类，且构造方法被默认强制是私有。

例如：枚举类 ProcessStatusEnum 的成员名称：SUCCESS / UNKNOWN_REASON

19.服务端各层命名规约：

A）Service / DAO 层方法命名规约：
1）获取单个对象的方法用 get 做前缀。
2）获取多个对象的方法用 list 做前缀，复数结尾，如：listObjects
3）获取统计值的方法用 count 做前缀。
4）插入的方法用 save / insert 做前缀。
5）删除的方法用 remove / delete 做前缀。
6）修改的方法用 update 做前缀。
B）领域模型命名规约：
1）数据对象：xxxDO，xxx 即为数据表名。
2）数据传输对象：xxxDTO，xxx 为业务领域相关的名称。
3）展示对象：xxxVO，xxx 一般为网页名称。
4）POJO 是 DO / DTO / BO / VO 的统称，禁止命名成 xxxPOJO。

注：POJO(Plain Old Java Object)是简单 Java 对象，POJO 可以作为基础数据模型，它没有任何继承特定类或实现特定接口的要求，仅包含属性字段及其 getter 和 setter 方法。

DO (Data Object) ：数据对象/持久化对象。与数据库表结构直接对应，用于表示数据库中存储的数据，通常包含了实体的完整信息，主要用于数据访问层（DAO），用于数据的持久化操作。

DTO (Data Transfer Object)：数据传输对象，用于 service 层，主要目的是为了在系统之间传递数据，特别是跨进程或网络服务调用时，减少数据传输量或者隐藏内部实现细节。

BO (Business Object)：业务对象，BO 封装了一定业务逻辑，可能是对多个持久化对象（DO）的组合，包含复杂的业务规则和操作，并可能负责协调多个 DAO 或服务之间的交互。

VO (Value Object) ：值对象/视图对象。主要是针对界面展示而设计的对象，其属性通常映射到前端显示所需的数据项上，也可能根据展示需求重新组织数据结构。

1.2、常量定义
1.不允许任何魔法值（即未经预先定义的常量）直接出现在代码中。例如下面的变量定义不允许出现：String key = “Id#taobao_” + tradeId;

2.long 或 Long 赋值时，数值后使用大写 L，不能是小写 l，小写容易跟数字混淆，造成误解。例如：public static final Long NUM = 2L;

3.浮点数类型的数值后缀统一为大写的 D 或 F。例如：

public static final double HEIGHT = 175.5D;
public static final float WEIGHT = 150.3F;

4.不要使用一个常量类维护所有常量，要按常量功能进行归类，分开维护。例如：缓存相关常量放在类 CacheConsts 下；系统配置相关常量放在类 SystemConfigConsts 下。

5.常量的复用层次有五层：跨应用共享常量、应用内共享常量、子工程内共享常量、包内共享常
量、类内共享常量。

6.如果变量值仅在一个固定范围内变化用 enum 类型来定义。

1.3、代码格式
1.如果大括号内为空，简洁地写成{}即可，大括号中间无需换行和空格；如果是非空代码块，则：
1）左大括号前不换行。
2）左大括号后换行。
3）右大括号前换行。
4）右大括号后还有 else 等代码则不换行；表示终止的右大括号后必须换行。

2.左小括号和右边相邻字符之间不需要空格；右小括号和左边相邻字符之间也不需要空格；而左大
括号前需要加空格。

3.if / for / while / switch / do 等保留字与左右括号之间都必须加空格。

4.任何二目、三目运算符的左右两边都需要加一个空格。

5.采用 4 个空格缩进，禁止使用 Tab 字符。

6.注释的双斜线与注释内容之间有且仅有一个空格。

7.在进行类型强制转换时，右括号与强制转换值之间不需要任何空格隔开。例如：double first = 3.2D; int second = (int)first + 2;

8.单行字符数限制不超过 120 个，超出需要换行，换行时遵循如下原则：
1）第二行相对第一行缩进 4 个空格，从第三行开始，不再继续缩进，参考示例。
2）运算符与下文一起换行。
3）方法调用的点符号与下文一起换行。
4）方法调用中的多个参数需要换行时，在逗号后进行。
5）在括号前不要换行。

9.方法参数在定义和传入时，多个参数逗号后面必须加空格。例如：method(args1, args2, args3);

上面 method 方法 args1 的逗号后面需要加一个空格。

10.IDE 的 text file encoding 设置为 UTF-8；IDE 中文件的换行符使用 Unix 格式，不要使用
Windows 格式。

11.单个方法的总行数不超过 80 行。主干代码保留，修饰性的共性代码抽取出来方便复用和维护。

12.没有必要增加若干空格来使变量的赋值等号与上一行对应位置的等号对齐。

13.不同逻辑、不同语义、不同业务的代码之间插入一个空行，分隔开来以提升可读性。

1.4、OOP 规约
1.避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用
类名来访问即可。

2.所有的覆写方法，必须加 @Override 注解，可以判断是否覆盖成功，加上注解覆盖失败会编译报错。

3.相同参数类型，相同业务含义，才可以使用的可变参数，参数类型避免定义为 Object。可变参数必须放置在参数列表的最后。（建议开发者尽量不用可变参数编程）

例如：public List<User> listUsers(String type, Long… ids) {…}

4.外部正在调用的接口或者二方库依赖的接口，不允许修改方法签名，避免对接口调用方产生影
响。接口过时必须加 @Deprecated 注解，并清晰地说明采用的新接口或者新服务是什么。

5.不能使用过时的类或方法。

6.Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。

例如：“test”.equals(param); 其中"test"与参数 param 的位置不能互换。

7.所有整型包装类对象之间值的比较，全部使用 equals 方法比较。对于 Integer var = ? 在 -128 至 127 之间的赋值，Integer 对象是在 IntegerCache.cache 产生，会复用已有对象，这个区间内的 Integer 值可以直接使用 == 进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复
用已有对象，这是一个大坑，推荐使用 equals 方法进行判断。

例如：

Integer a = 1000, b = 1000 ;
System.out.println(a==b); // false
System.out.println(a.equals(b)); // true

8.任何货币金额，均以最小货币单位且为整型类型进行存储。

9.浮点数之间的等值判断，基本数据类型不能使用 == 进行比较，包装数据类型不能使用 equals
进行判断。可以使用如下两种方法进行判断：

1）指定一个误差范围，两个浮点数的差值在此范围之内，则认为是相等的。

2）使用 BigDecimal 来定义值，再进行浮点数的运算操作。

10.BigDecimal 的等值比较应使用 compareTo() 方法，而不是 equals() 方法。equals() 方法会比较值和精度（1.0 与 1.00 返回结果为 false），而 compareTo() 则会忽略精度。

11.定义数据对象 DO 类时，属性类型要与数据库字段类型相匹配。例：数据库字段的 bigint 必须与类属性的 Long 类型相对应。

12.禁止使用构造方法 BigDecimal(double) 的方式把 double 值转化为 BigDecimal 对象。
说明：BigDecimal(double) 存在精度损失风险，在精确计算或值比较的场景中可能会导致业务逻辑异常。 如：
BigDecimal g = new BigDecimal(0.1F)；实际的存储值为：0.100000001490116119384765625

应该用如下方式：

BigDecimal recommend1 = new BigDecimal(“0.1”);
BigDecimal recommend2 = BigDecimal.valueOf(0.1);

13.关于基本数据类型与包装数据类型的使用标准如下：
1）【强制】所有的 POJO 类属性必须使用包装数据类型。允许为 null 值。
2）【强制】RPC 方法的返回值和参数必须使用包装数据类型。允许为 null，防止自动拆箱报空指针异常。
3）【推荐】所有的局部变量使用基本数据类型。

14.定义 DO / PO / DTO / VO 等 POJO 类时，不要设定任何属性默认值。

15.序列化类新增属性时，请不要修改 serialVersionUID 字段，避免反序列失败；如果完全不兼
容升级，避免反序列化混乱，那么请修改 serialVersionUID 值。

16.构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init 方法中。

17.POJO 类必须写 toString 方法。出现问题便于排查。

18.禁止在 POJO 类中，同时存在对应属性 xxx 的 isXxx() 和 getXxx() 方法。
说明：框架在调用属性 xxx 的提取方法时，并不能确定哪个方法一定是被优先调用到，神坑之一。

19.使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无内容的检查，
否则会有抛 IndexOutOfBoundsException 的风险

20.当一个类有多个构造方法，或者多个同名方法，这些方法应该按顺序放置在一起，便于阅读，
此条规则优先于下一条。

21.类内方法定义的顺序依次是：公有方法或保护方法 > 私有方法 > getter / setter 方法。
说明：公有方法是类的调用者和维护者最关心的方法，首屏展示最好；保护方法虽然只是子类关心，也可能是“模板设计模式”下的核心方法；而私有方法外部一般不需要特别关心，是一个黑盒实现；因为承载的信息价值较低，所有 Service 和 DAO 的 getter / setter 方法放在类体最后。

22.setter 方法中，参数名称与类成员变量名称一致，this.成员名=参数名。在 getter / setter 方
法中，不要增加业务逻辑，增加排查问题的难度。

23.循环体内，字符串的连接方式，使用 StringBuilder 的 append 方法进行扩展。编译出的字节码文件显示每次循环都会 new 出一个 StringBuilder 对象，然后进行 append 操作，最后通过 toString() 返回 String 对象，造成内存资源浪费。

24.final 可以声明类、成员变量、方法、以及本地变量，下列情况使用 final 关键字：
1）不允许被继承的类，如：String 类。
2）不允许修改引用的域对象，如：POJO 类的域变量。
3）不允许被覆写的方法，如：POJO 类的 setter 方法。
4）不允许运行过程中重新赋值的局部变量。
5）避免上下文重复使用一个变量，使用 final 关键字可以强制重新定义一个变量，方便更好地进行重构。

25.慎用 Object 的 clone 方法来拷贝对象。说明：对象 clone 方法默认是浅拷贝，若想实现深拷贝需覆写 clone 方法实现域对象的深度遍历式拷贝。

26.类成员与方法访问控制从严：过于宽泛的访问范围，不利于模块解耦
1）如果不允许外部直接通过 new 来创建对象，那么构造方法必须是 private。
2）工具类不允许有 public 或 default 构造方法。
3）类非 static 成员变量并且与子类共享，必须是 protected。
4）类非 static 成员变量并且仅在本类使用，必须是 private。
5）类 static 成员变量如果仅在本类使用，必须是 private。
6）若是 static 成员变量，考虑是否为 final。
7）类成员方法只供类内部调用，必须是 private。
8）类成员方法只对继承类公开，那么限制为 protected。

1.5、日期时间
1.日期格式化时，传入 pattern 中表示年份统一使用小写的 y。
说明：日期格式化时，yyyy 表示当天所在的年，而大写的 YYYY 代表是 week in which year（JDK7 之后引入的概念），意思是当天所在的周属于的年份，一周从周日开始，周六结束，只要本周跨年，返回的 YYYY 就是下一年。
正例：表示日期和时间的格式如下所示：new SimpleDateFormat(“yyyy-MM-dd HH:mm:ss”)

2.在日期格式中分清楚大写的 M 和小写的 m，大写的 H 和小写的 h 分别指代的意义。
说明：日期格式中的这两对字母表意如下：
1）表示月份是大写的 M
2）表示分钟则是小写的 m
3）24 小时制的是大写的 H
4）12 小时制的则是小写的 h

3.获取当前毫秒数：System.currentTimeMillis()；而不是 new Date().getTime()。
说明：获取纳秒级时间，则使用 System.nanoTime 的方式。在 JDK8 中，针对统计时间等场景，推荐使用 Instant 类。

4.不允许在程序任何地方中使用： 1）java.sql.Date 2）java.sql.Time 3）java.sql.Timestamp。

5.禁止在程序中写死一年为 365 天，避免在公历闰年时出现日期转换错误或程序逻辑错误。

6.避免公历闰年 2 月问题。闰年的 2 月份有 29 天，一年后的那一天不可能是 2 月 29 日。

7.使用枚举值来指代月份。如果使用数字，注意 Date，Calendar 等日期相关类的月份 month 取
值范围从 0 到 11 之间。

1.6、集合处理
1.关于 hashCode 和 equals 的处理，遵循如下规则：
1）只要覆写 equals，就必须覆写 hashCode。
2）因为 Set 存储的是不重复的对象，依据 hashCode 和 equals 进行判断，所以 Set 存储的对象必须覆写这两种方法。
3）如果自定义对象作为 Map 的键，那么必须覆写 hashCode 和 equals。
说明：String 因为覆写了 hashCode 和 equals 方法，所以可以愉快地将 String 对象作为 key 来使用。

2.判断所有集合内部的元素是否为空，使用 isEmpty() 方法，而不是 size() == 0 的方式。
说明：在某些集合中，前者的时间复杂度为 O(1)，而且可读性更好。

3.在使用 java.util.stream.Collectors 类的 toMap() 方法转为 Map 集合时，一定要使用参数类型
为 Java 中的一个函数式接口 BinaryOperator，参数名为 mergeFunction 的方法，否则当出现相同 key 时会抛出 IllegalStateException 异常。
说明：参数 mergeFunction 的作用是当出现 key 重复时，自定义对 value 的处理策略。

解释：在 Java 8 中，java.util.stream.Collectors类提供了许多用于从 Stream 转换为集合、Map 或其他复杂数据结构的方法。当使用toMap()方法将 Stream 转换为 Map 时，如果源 Stream 中有多个元素具有相同的键（key），那么如果没有提供合并函数（merge function），就会抛出IllegalStateException异常，提示“Duplicate key”。

   // 反例
        String[] departments = new String[]{"RDC", "RDC", "KKB"};
       // 抛出 IllegalStateException 异常
        Map<Integer, String> map = Arrays.stream(departments)
                .collect(Collectors.toMap(String::hashCode, str -> str));
1
2
3
4
5

        // 正例
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        // key相同，保留第二个
        Map<String, Double> map = pairArrayList.stream()
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue,(v1,v2)->v2)) ;
        for(Map.Entry m : map.entrySet()){
            // version 6.28
            System.out.println(m.getKey() + " " +  m.getValue());
        }
1
2
3
4
5
6
7
8
9
10
11
12
13
4.在使用 java.util.stream.Collectors 类的 toMap() 方法转为 Map 集合时，一定要注意当 value
为 null 时会抛 NPE 异常。

5.ArrayList 的 subList 结果不可强转成 ArrayList，否则会抛出 ClassCastException 异常：
java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
说明：subList() 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 本身，而是 ArrayList 的一个视图，对于 SubList 的所有操作最终会反映到原列表上。

解释：

ArrayList.subList(int fromIndex, int toIndex) 方法返回的是 ArrayList 的一个内部类实例，名为 SubList，它实现了 List 接口，并且继承自 AbstractList 类。虽然 SubList 行为上看起来像是一个独立的列表，但实际上它是一个原列表（即调用 subList() 方法的 ArrayList）的视图或切片。

SubList 不是 ArrayList 类型，而是 RandomAccessSubList 类型，这是 ArrayList 为了支持快速随机访问而专门为其子列表实现的一个内部类，它继承了 SubList 并实现了 RandomAccess 接口，表明它支持快速随机访问元素。

6.使用 Map 的方法 keySet() / values() / entrySet() 返回集合对象时，不可以对其进行添加元素
操作，否则会抛出 UnsupportedOperationException 异常。

7.Collections 类返回的对象，如：emptyList() / singletonList() 等都是 immutable list(不可变列表)，不可对其进行添加或者删除元素的操作。
反例：如果查询无结果，返回 Collections.emptyList() 空集合对象，调用方一旦在返回的集合中进行了添加元素的操作，就会触发 UnsupportedOperationException 异常。

8.在 subList 场景中，高度注意对父集合元素的增加或删除，均会导致子列表的遍历、增加、删
除产生 ConcurrentModificationException 异常。
说明：抽查表明，90% 的程序员对此知识点都有错误的认知。

     List<String> nameList = new ArrayList<>() ;
        nameList.add("John") ;
        nameList.add("Steve") ;
        nameList.add("maria") ;
        List<String> subList = nameList.subList(0, 1);
    
        // 先对父列表进行插入操作
        nameList.add("wang") ;
        // 对父类元素进行删除操作
        nameList.remove(0) ;
    
        // 遍历子列表:抛出java.util.ConcurrentModificationException
        for(String key : subList){
            System.out.println(key);
        }
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
9.使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一致、长度为
0 的空数组。
反例：直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现 ClassCastException 错误。

 List<String> nameList = new ArrayList<>() ;
        nameList.add("John") ;
        nameList.add("Steve") ;
        nameList.add("maria") ;
        // 等于0，动态创建于size相同的数组，性能最好
        String[] strings = nameList.toArray(new String[0]);
1
2
3
4
5
6
10.使用 Collection 接口任何实现类的 addAll() 方法时，要对输入的集合参数进行 NPE 判断。
说明：在 ArrayList#addAll 方法的第一行代码即 Object[] a = c.toArray()；其中 c 为输入集合参数，如果为 null，则直接抛出异常.

 List<String> lists = new ArrayList<>(2) ;
        List<String> list = null;
        //  抛出java.lang.NullPointerException
        lists.addAll(list) ;
1
2
3
4
11.使用工具类 Arrays.asList() 把数组转换成集合时，不能使用其修改集合相关的方法，它的 add
/ remove / clear 方法会抛出 UnsupportedOperationException 异常。
说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配器模式，只是转换接口，后台的数据仍是数组。

 String [] strings = {"wang", "yang", "li"} ;
        // 数组转换成list
        List<String> list = Arrays.asList(strings);
        // 抛异常：java.lang.UnsupportedOperationException
        list.add("sun") ;
1
2
3
4
5
12.泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add 方法，
而<? super T>不能使用 get 方法，两者在接口调用赋值的场景中容易出错。

解释：<? extends T>表示上界通配符，具体表示可以接收类型为 T 及 T 的子类对象。

<? super T>表示的接收的一个未知的具体类型 T 的超类型，即 T 或 T 的父类型。

13.在无泛型限制定义的集合赋值给泛型限制的集合时，在使用集合元素时，需要进行
instanceof 判断，避免抛出 ClassCastException 异常。

       List<String> generics = null;
        List notGenerics = new ArrayList(10);
        notGenerics.add(new Object());
        notGenerics.add(new Integer(1));
        generics = notGenerics;
        // 此处抛出 ClassCastException 异常
        String string = generics.get(0);
1
2
3
4
5
6
7
14.不要在 foreach 循环里进行元素的 remove / add 操作。remove 元素请使用 iterator 方式，
如果并发操作，需要对 iterator 对象加锁。

反例：

  List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for(String s : list){
            if ("2".equals(s)) {
                // 抛出java.util.ConcurrentModificationException
                list.remove(s) ;
            }
        }
1
2
3
4
5
6
7
8
9
解释：

这段 Java 代码会抛出java.util.ConcurrentModificationException异常，这是因为你在遍历集合（List）的同时尝试修改它。在 Java 的 ArrayList（以及其他非线程安全集合类如 LinkedList 等）中，当迭代器遍历集合时，它期望集合在其遍历期间不会发生结构上的改变，即不会添加或移除元素。

当你在 for-each 循环内部调用list.remove(s)时，实际上是在尝试从正在遍历的列表中删除元素，这违反了迭代器对集合不变性的假设，因此抛出了ConcurrentModificationException异常。

正例：

使用迭代器本身的 api 在遍历过程中进行插入与删除操作：

List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }
1
2
3
4
5
6
7
8
9
10
15.在 JDK7 版本及以上，Comparator 实现类要满足如下三个条件，不然 Arrays.sort，
Collections.sort 会抛 IllegalArgumentException 异常。
说明：三个条件如下
1）x，y 的比较结果和 y，x 的比较结果相反。
2）x > y，y > z，则 x > z。
3）x = y，则 x，z 比较结果和 y，z 比较结果相同。

16.泛型集合使用时，在 JDK7 及以上，使用 diamond 语法或全省略。
说明：菱形泛型，即 diamond，直接使用<>来指代前边已经指定的类型。

        // diamond 方式，即<>
        HashMap<String, String> userCache = new HashMap<>(16);
       // 全省略方式
        ArrayList<String> users = new ArrayList(10);
1
2
3
4
17.集合初始化时，指定集合初始值大小。
说明：HashMap 使用构造方法 HashMap(int initialCapacity) 进行初始化时，如果暂时无法确定集合大小，那么指定默认值（16）即可。
正例：initialCapacity = (需要存储的元素个数 / 负载因子) + 1。注意负载因子（即 loaderfactor）默认为 0.75，如果暂时无法确定初始值大小，请设置为 16（即默认值）。
反例：HashMap 需要放置 1024 个元素，由于没有设置容量初始大小，随着元素增加而被迫不断扩容，resize() 方法总共会调用 8 次，反复重建哈希表和数据迁移。当放置的集合元素个数达千万级时会影响程序性能。

 // diamond 方式，即<>
        HashMap<String, String> userCache = new HashMap<>(16);
1
2
18.使用 entrySet 遍历 Map 类集合 KV，而不是 keySet 方式进行遍历。
说明：keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出 key 所对应的 value。而只是遍历了一次就把 key 和 value 都放到了 entry 中，效率更高。如果是 JDK8，使用 Map.forEach 方法。
正例：values() 返回的是 V 值集合，是一个 list 集合对象；keySet() 返回的是 K 值集合，是一个 Set 集合对象；entrySet() 返回的是 K-V 值组合的 Set 集合。


        // diamond 方式，即<>
        Map<String, String> userCache = new HashMap<>(16);
        userCache.put("1", "liu") ;
        userCache.put("2", "wang") ;
        userCache.put("3", "hu") ;
        // for循环遍历
        for(Map.Entry entry : userCache.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // Map.forEach()方法遍历
        userCache.forEach((key, value)->{
            System.out.println(key + " " + value);
        });
1
2
3
4
5
6
7
8
9
10
11
12
13
14
19.高度注意 Map 类集合 K / V 能不能存储 null 值的情况

主要使用的是 HashMap 和 ConcurrentHashMap 两种，前者键值均可以为 null，后者键值都不可以为 null，因此使用的时候需要特别注意。
由于 HashMap 的干扰，很多人认为 ConcurrentHashMap 是可以置入 null 值，而事实上，存储 null 值时会抛出 NPE 异常。
主要原因是在高并发场景下，ConcurrentHashMap 需要精确地控制锁的粒度来保证并发性能。对于null键这样的特殊情况进行处理会增加额外的复杂性和潜在的风险。

1.7、并发处理
1.获取单例对象需要保证线程安全，其中的方法也要保证线程安全。
说明：资源驱动类、工具类、单例工厂类都需要注意。(饿汉模式 or 懒汉模式+双重检查锁)

2.创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。

3.线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
说明：线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决资源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题。

4.线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方
式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
说明：Executors 返回的线程池对象的弊端如下：
1）FixedThreadPool 和 SingleThreadPool：
允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
2）CachedThreadPool：
允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
3）ScheduledThreadPool：
允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。

解释：直接使用Executors类提供的默认配置可能会导致一些潜在的问题：

资源耗尽的风险：例如，Executors.newFixedThreadPool(int nThreads)创建的线程池，其内部工作队列通常是一个无界的 LinkedBlockingQueue，这意味着如果提交的任务数量远大于线程池的最大线程数且这些任务不能及时完成时，工作队列会无限增长，最终可能导致内存溢出（OOM）。

不明确的运行规则：Executors中的预定义线程池配置可能并不符合每个应用的具体需求。例如，默认配置可能没有设置合理的拒绝策略或空闲线程存活时间，这在特定场景下可能会导致性能问题或者异常处理不当。

因此，推荐的做法是直接通过构造ThreadPoolExecutor对象并显式地指定核心线程数、最大线程数、工作队列类型与容量、线程存活时间、以及拒绝策略等参数来创建线程池。这样开发者可以更精确地控制线程池的行为，从而避免资源耗尽的风险，并且更好地适应不同应用场景的需求。

5.SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为 static，必须
加锁，或者使用 DateUtils 工具类。

6.必须回收自定义的 ThreadLocal 变量记录的当前线程的值，尤其在线程池场景下，线程经常会
被复用，如果不清理自定义的 ThreadLocal 变量，可能会影响后续业务逻辑和造成内存泄露等问题。尽量在代码中使用 try-finally 块进行回收。

7.高并发时，同步调用应该去考量锁的性能损耗。能用无锁数据结构，就不要用锁；能锁区块，就
不要锁整个方法体；能用对象锁，就不要用类锁。
说明：尽可能使加锁的代码块工作量尽可能的小，避免在锁代码块中调用 RPC 方法。

8.对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造成死锁。
说明：线程一需要对表 A、B、C 依次全部加锁后才可以进行更新操作，那么线程二的加锁顺序也必须是 A、B、C，否则可能出现死锁。

9.在使用阻塞等待获取锁的方式中，必须在 try 代码块之外，并且在加锁方法与 try 代码块之间没
有任何可能抛出异常的方法调用，避免加锁成功后，在 finally 中无法解锁。
说明一：在 lock 方法与 try 代码块之间的方法调用抛出异常，无法解锁，造成其它线程无法成功获取锁。
说明二：如果 lock 方法在 try 代码块之内，可能由于其它方法抛出异常，导致在 finally 代码块中，unlock 对未加锁的对象解锁，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），抛出 IllegalMonitorStateException 异常。
说明三：在 Lock 对象的 lock 方法实现中可能抛出 unchecked 异常，产生的后果与说明二相同。

 Lock lock = new ReentrantLock();
        // 加琐方法放到try块的外面
        lock.lock();
        // 这个地方不允许出现任何可能抛出异常的方法
        try {
            doSomething();
            doOthers();
        } finally {
            lock.unlock();
        }
1
2
3
4
5
6
7
8
9
10
10.在使用尝试机制来获取锁的方式中，进入业务代码块之前，必须先判断当前线程是否持有锁。
锁的释放规则与锁的阻塞等待方式相同。
说明：Lock 对象的 unlock 方法在执行时，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），如果当前线程不持有锁，则抛出 IllegalMonitorStateException 异常。

        Lock lock = new ReentrantLock();
        // 加琐方法放到try块的外面
        boolean isLock = lock.tryLock();
        // 这个地方不允许出现任何可能抛出异常的方法
    
        if(isLock) {
            // 进入业务代码之前需要先去判断该线程是否持有琐
            try {
                doSomething();
                doOthers();
            } finally {
                lock.unlock();
            }
        }
1
2
3
4
5
6
7
8
9
10
11
12
13
14
11.并发修改同一记录时，避免更新丢失，需要加锁。要么在应用层加锁，要么在缓存加锁，要么
在数据库层使用乐观锁，使用 version 作为更新依据。
说明：如果每次访问冲突概率小于 20%，推荐使用乐观锁，否则使用悲观锁。乐观锁的重试次数不得小于 3 次。

12.多线程并行处理定时任务时，Timer 运行多个 TimeTask 时，只要其中之一没有捕获抛出的异
常，其它任务便会自动终止运行，使用 ScheduledExecutorService 则没有这个问题。

13.资金相关的金融敏感信息，使用悲观锁策略。
说明：乐观锁在获得锁的同时已经完成了更新操作，校验逻辑容易出现漏洞，另外，乐观锁对冲突的解决策略有较复杂的要求，处理不当容易造成系统压力或数据异常，所以资金相关的金融敏感信息不建议使用乐观锁更新。
正例：悲观锁遵循一锁二判三更新四释放的原则。

14.使用 CountDownLatch 进行异步转同步操作，每个线程退出前必须调用 countDown 方法，线
程执行代码注意 catch 异常，确保 countDown 方法被执行到，避免主线程无法执行至 await 方法，直到超时才返回结果。
说明：注意，子线程抛出异常堆栈，不能在主线程 try-catch 到。

解释：CountDownLatch通常用于一个或多个线程等待其他线程完成其工作的情况，通过计数器来协调这些线程。

每个线程退出前必须调用 countDown 方法：当一个线程完成了自己的任务部分后，它应该调用 countDown() 方法将计数器减一。这样可以告知等待的线程（如主线程）有一个任务已完成。

线程执行代码注意 catch 异常：为了避免由于子线程内部抛出异常导致的未正确调用 countDown() 方法，从而使得主线程无法正确地等待所有子线程完成，应在子线程的任务代码中妥善处理异常，确保即使发生异常也能调用 countDown() 方法。

确保 countDown 方法被执行到：这是因为主线程会调用 await() 方法阻塞直到计数器归零，如果任何子线程没有成功调用 countDown()，主线程可能会一直等待下去，或者达到设定的超时时间后返回结果，这都不是期望的行为。

子线程抛出异常堆栈，不能在主线程 try-catch 到：这意味着主线程无法直接捕获和处理从子线程中抛出的异常。要获取并处理子线程中的异常，需要在线程内部捕获异常，并通过某种方式（例如通过共享变量、Future.get() 或者 UncaughtExceptionHandler 等机制）传递给主线程。

因此，在使用 CountDownLatch 的场景下，开发者应当确保无论何时何地，只要子线程完成任务就应该减少计数，同时处理好子线程可能抛出的异常，以保证整个程序逻辑的正常进行。

15.避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一 seed 导致
的性能下降。
说明：Random 实例包括 java.util.Random 的实例或者 Math.random() 的方式。
正例：在 JDK7 之后，可以直接使用 API ThreadLocalRandom，而在 JDK7 之前，需要编码保证每个线程持有一个单独的 Random 实例。

16.通过双重检查锁（double-checked locking），实现延迟初始化需要将目标属性声明为
volatile 型，（比如修改 helper 的属性声明为 private volatile Helper helper = null;）。

解释：饿汉模式延迟实例化需要将对象用 volatile 修饰，因为 JVM 为了性能优化，会进行指令重排序，这可能会导致 NPE 问题，故需要使用 volatile 关键字进行禁止指令重排序。

class Helper{
    // 由于编译器和处理器优化可能导致指令重排序，使得即使使用了双重检查锁定也可能出现问题
    private volatile Helper helper = null;
    public Helper getHelper() {
        if (helper == null) {
            synchronized(this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }

}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
17.volatile 解决多线程内存不可见问题对于一写多读，是可以解决变量同步问题，但是如果多
写，同样无法解决线程安全问题。
说明：如果是 count++操作，使用如下原子类实现：

 AtomicInteger count = new AtomicInteger();
 count.addAndGet(1) ;
1
2
如果是 JDK8，推荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观锁的重试次数）。

 LongAdder longAdder = new LongAdder() ;
 // longAdder.add(1);
 longAdder.increment();
 System.out.println(longAdder);
1
2
3
4
18.HashMap 在容量不够进行 resize 时由于高并发可能出现死链，导致 CPU 飙升，在开发过程中注意规避此风险。

解释：HashMap 在容量不够进行 resize（即扩容）时，如果并发环境下有多个线程同时尝试进行 resize 操作，确实有可能导致死链问题。这是因为当HashMap的大小发生变化时，它需要重新分配一个新的数组，并将旧数组中的元素迁移到新数组中。这个过程中涉及到大量的节点移动和指针重置，如果没有合适的同步控制，在多线程下可能会出现循环引用，形成死链（也称为“死循环”或“循环链表”），从而导致 CPU 使用率飙升。对于并发环境下的 HashMap 使用，最佳实践是选择线程安全的数据结构（如 ConcurrentHashMap），并在设计程序时充分考虑到并发访问可能带来的各种问题。

19.ThreadLocal 对象使用 static 修饰，ThreadLocal 无法解决共享对象的更新问题。
说明：这个变量是针对一个线程内所有操作共享的，所以设置为静态变量，所有此类实例共享此静态变量，也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象（只要是这个线程内定义的）都可以操控这个变量。

1.8、控制语句
1.在一个 switch 块内，每个 case 要么通过 continue / break / return 等来终止，要么注释说明
程序将继续执行到哪一个 case 为止；在一个 switch 块内，都必须包含一个 default 语句并且放在最后，即使它什么代码也没有。
说明：注意 break 是退出 switch 语句块，而 return 是退出方法体。

 public static void test(String s){
        switch (s){
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            default:
                System.out.println("others");
        }
    }
1
2
3
4
5
6
7
8
9
10
11
12
2.当 switch 括号内的变量类型为 String 并且此变量为外部参数时，必须先进行 null 判断。

解释：不允许传入 null 给 switch，否则会报 NPE 问题。

3.在 if / else / for / while / do 语句中必须使用大括号。
反例： if (condition) statements;
说明：即使只有一行代码，也要采用大括号的编码方式。

4.三目运算符 condition ? 表达式 1：表达式 2 中，高度注意表达式 1 和 2 在类型对齐时，可能
抛出因自动拆箱导致的 NPE 异常。
说明：以下两种场景会触发类型对齐的拆箱操作：
1）表达式 1 或 表达式 2 的值只要有一个是原始类型。
2）表达式 1 或 表达式 2 的值的类型不一致，会强制拆箱升级成表示范围更大的那个类型。

Integer a = 1;
Integer b = 2;
Integer c = null;
Boolean flag = false;
// a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
Integer result = (flag ? a * b : c);
1
2
3
4
5
6
5.在高并发场景中，避免使用“等于”判断作为中断或退出的条件。
说明：如果并发控制没有处理好，容易产生等值判断被“击穿”的情况，使用大于或小于的区间判断条件来代替。
反例：判断剩余奖品数量等于 0 时，终止发放奖品，但因为并发处理错误导致奖品数量瞬间变成了负数，这样的话，活动无法终止。

6.当方法的代码总行数超过 10 行时，return / throw 等中断逻辑的右大括号后需要加一个空行。
说明：这样做逻辑清晰，有利于代码阅读时重点关注。

7.表达异常的分支时，少用 if-else 方式，这种方式可以改写成：
if (condition) {
…
return obj;
}
// 接着写 else 的业务逻辑代码;
说明：如果非使用 if()…else if()…else…方式表达逻辑，避免后续代码维护困难，请勿超过 3 层。

8.除常用方法（如 getXxx / isXxx）等外不要在条件判断中执行其它复杂的语句，将复杂逻辑判
断的结果赋值给一个有意义的布尔变量名，以提高可读性。
说明：很多 if 语句内的逻辑表达式相当复杂，与、或、取反混合运算，甚至各种方法纵深调用，理解成本非常高。如果赋值一个非常好理解的布尔变量名字，则是件令人爽心悦目的事情。

9.不要在其它表达式（尤其是条件表达式）中，插入赋值语句。
说明：赋值点类似于人体的穴位，对于代码的理解至关重要，所以赋值语句需要清晰地单独成为一行。

10.循环体中的语句要考量性能，以下操作尽量移至循环体外处理，如定义对象、变量、获取数据
库连接，进行不必要的 try-catch 操作（这个 try-catch 是否可以移至循环体外）。

11.避免采用取反逻辑运算符。
说明：取反逻辑不利于快速理解，并且取反逻辑写法一般都存在对应的正向逻辑写法。
正例：使用 if(x < 628) 来表达 x 小于 628。
反例：使用 if(!(x >= 628)) 来表达 x 小于 628。

12.公开接口需要进行入参保护，尤其是批量操作的接口。
反例：某业务系统，提供一个用户批量查询的接口，API 文档上有说最多查多少个，但接口实现上没做任何保护，导致调用方传了一个 1000 的用户 id 数组过来后，查询信息后，内存爆了。

1.9、注释规约
1.类、类属性、类方法的注释必须使用 Javadoc 规范，使用 /** 内容 */ 格式，不得使用 // xxx
方式。
说明：在 IDE 编辑窗口中，Javadoc 方式会提示相关注释，生成 Javadoc 可以正确输出相应注释；在 IDE 中，工程调用方法时，不进入方法即可悬浮提示方法、参数、返回值的意义，提高阅读效率。

/**
 * @author nuist__NJUPT
 * @ClassName Main
 * @description: 阿里巴巴Java开发手册
 * @date 2024/02/22
 */
    public class Main {}
    /**
     *
     * @param a 第一个数字
     * @param b 第一个数字
     * @return 求和
     */
     public static Integer getSum(Integer a, Integer b){
        return a + b ;
     }

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
2.所有的抽象方法（包括接口中的方法）必须要用 Javadoc 注释、除了返回值、参数异常说明
外，还必须指出该方法做什么事情，实现什么功能。
说明：对子类的实现要求，或者调用注意事项，请一并说明。

3.所有的类都必须添加创建者和创建日期。
说明：在设置模板时，注意 IDEA 的@author 为`${USER}`，而 eclipse 的@author 为`${user}`，大小写有区别，而日期的设置统一为 yyyy/MM/dd 的格式。

/**
 * @author nuist__NJUPT
 * @ClassName Main
 * @description: 阿里巴巴Java开发手册
 * @date 2024/02/22
 */
 1
 2
 3
 4
 5
 6
 4.方法内部单行注释，在被注释语句上方另起一行，使用 // 注释。方法内部多行注释使用 /* */
 注释，注意与代码对齐。

5.所有的枚举类型字段必须要有注释，说明每个数据项的用途。

6.与其用半吊子英文来注释，不如用中文注释说清楚。专有名词与关键字保持英文原文即可。
反例：“TCP 连接超时”解释成“传输控制协议连接超时”，理解反而费脑筋。

7.代码修改的同时，注释也要进行相应的修改，尤其是参数、返回值、异常、核心逻辑等。
说明：代码与注释更新不同步，就像公路网与导航软件更新不同步一样，如果导航软件严重滞后，就失去了导航的意义。

8.在类中删除未使用的任何字段和方法、内部类；在方法中删除未使用的参数声明与内部变量。

1.10、前后端规约
1.前后端交互的 API，需要明确协议、域名、路径、请求方法、请求内容、状态码、响应体。
说明：
1）协议：生产环境必须使用 HTTPS。
2）路径：每一个 API 需对应一个路径，表示 API 具体的请求地址：
a）代表一种资源，只能为名词，推荐使用复数，不能为动词，请求方法已经表达动作意义。
b）URL 路径不能使用大写，单词如果需要分隔，统一使用下划线。
c）路径禁止携带表示请求内容类型的后缀，比如".json"，“.xml”，通过 accept 头表达即可。
3）请求方法：对具体操作的定义，常见的请求方法如下：
a）GET：从服务器取出资源。
b）POST：在服务器新建一个资源。
c）PUT：在服务器更新资源。
d）DELETE：从服务器删除资源。
4）请求内容：URL 带的参数必须无敏感信息或符合安全要求；body 里带参数时必须设置 Content-Type。
5）响应体：响应体 body 可放置多种数据类型，由 Content-Type 头来确定

2.前后端数据列表相关的接口返回，如果为空，则返回空数组[]或空集合{}。
说明：此条约定有利于数据层面上的协作更加高效，减少前端很多琐碎的 null 判断。

3.服务端发生错误时，返回给前端的响应信息必须包含 HTTP 状态码，errorCode、errorMessage、用户提示信息四个部分。
说明：四个部分的涉众对象分别是浏览器、前端开发、错误排查人员、用户。其中输出给用户的提示信息要求：简短清晰、提示友好，引导用户进行下一步操作或解释错误原因，提示信息可以包括错误原因、上下文环境、推荐操作等。

4.在前后端交互的 JSON 格式数据中，所有的 key 必须为小写字母开始的 lowerCamelCase
风格，符合英文表达习惯，且表意完整。
正例：errorCode / errorMessage / assetStatus / menuList / orderList / configFlag
反例：ERRORCODE / ERROR_CODE / error_message / error-message / errormessage

5.errorMessage 是前后端错误追踪机制的体现，可以在前端输出到 type=“hidden” 文字类控
件中，或者用户端的日志中，帮助我们快速地定位出问题。

6.对于需要使用超大整数的场景，服务端一律使用 String 字符串类型返回，禁止使用 Long 类型。
说明：Java 服务端如果直接返回 Long 整型数据给前端，Javascript 会自动转换为 Number 类型（注：此类型为双精度浮点数，表示原理与取值范围等同于 Java 中的 Double）。
反例：通常在订单号或交易号大于等于 16 位，大概率会出现前后端订单数据不一致的情况。
比如，后端传输的 “orderId”：362909601374617692，前端拿到的值却是：362909601374617660

7.HTTP 请求通过 URL 传递参数时，不能超过 2048 字节。
说明：不同浏览器对于 URL 的最大长度限制略有不同，并且对超出最大长度的处理逻辑也有差异，2048 字节是取所有浏览器的最小值。
反例：某业务将退货的商品 id 列表放在 URL 中作为参数传递，当一次退货商品数量过多时，URL 参数超长，传递到后端的参数被截断，导致部分商品未能正确退货。

8.HTTP 请求通过 body 传递内容时，必须控制长度，超出最大长度后，后端解析会出错。
说明：nginx 默认限制是 1MB，tomcat 默认限制为 2MB，当确实有业务需要传较大内容时，可以调大服务器端的限制。

9.在翻页场景中，用户输入参数的小于 1，则前端返回第一页参数给后端；后端发现用户输入的
参数大于总页数，直接返回最后一页。

10.服务器内部重定向必须使用 forward；外部重定向地址必须使用 URL 统一代理模块生成，否
则会因线上采用 HTTPS 协议而导致浏览器提示“不安全”，并且还会带来 URL 维护不一致的问题。

这句话是在阐述服务器端重定向的两种处理方式及其潜在问题：

1）. 服务器内部重定向（Internal Redirect）：
- “服务器内部重定向必须使用 `forward`”：在 Web 应用开发中，尤其是在 Java Servlet 或类似技术环境下，当需要在服务器内部将请求转发到另一个资源处理器时，通常会使用`forward`方法。这种方法不会改变浏览器地址栏中的 URL，而是由服务器端直接将请求传递给内部目标资源，客户端（浏览器）感知不到这次转发。

2）. 外部重定向（External Redirect）：
- “外部重定向地址必须使用 URL 统一代理模块生成”：对于那些需要告知客户端重新发起新的 HTTP 请求的情况（例如，从一个域名跳转到另一个域名，或者从 HTTP 协议转向 HTTPS 协议），服务器应当发送一个 HTTP 响应状态码指示重定向，并提供一个新的 URL。如果线上环境采用了 HTTPS 加密通信，那么这个重定向的目标 URL 也必须是安全的 HTTPS 链接，否则浏览器可能会显示“不安全”的警告。
- 使用统一代理模块（如 URLBroker）的目的在于确保所有对外的重定向都经过正确配置和管理，从而避免由于手动编写 URL 导致的安全性和一致性问题。通过这样的模块可以自动转换和规范化 URL，保证重定向到正确的 HTTPS 地址，同时方便集中管理和维护所有的外部链接策略。

总结来说，该句话强调了在实现服务器端重定向时，应根据实际场景选择合适的方法，内部转发保证无缝且安全的内部处理，而外部重定向则需借助专门工具来确保 HTTPS 安全性和 URL 的一致性及可维护性。

11.服务器返回信息必须被标记是否可以缓存，如果缓存，客户端可能会重用之前的请求结果。
说明：缓存有利于减少交互次数，减少交互的平均延迟。
正例：http1.1 中，s-maxage 告诉服务器进行缓存，时间单位为秒，用法如下，
response.setHeader(“Cache-Control”, “s-maxage=” + cacheSeconds);

12.服务端返回的数据，使用 JSON 格式而非 XML。
说明：尽管 HTTP 支持使用不同的输出格式，例如纯文本，JSON，CSV，XML，RSS 甚至 HTML。如果我们使用的面向用户的服务，应该选择 JSON 作为通信中使用的标准数据交换格式，包括请求和响应。此外，application/JSON 是一种通用的 MIME 类型，具有实用、精简、易读的特点。

13.前后端的时间格式统一为"yyyy-MM-dd HH:mm:ss"，统一为 GMT。

14.在接口路径中不要加入版本号，版本控制在 HTTP 头信息中体现，有利于向前兼容。
说明：当用户在低版本与高版本之间反复切换工作时，会导致迁移复杂度升高，存在数据错乱风险。

1.11、其它
1.在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。
说明：不要在方法体内定义：Pattern pattern = Pattern.compile(“规则”);

解释：

当程序每次调用Pattern.compile()时，它都会消耗一定的时间去解析正则表达式语法，并构建相应的状态机或确定匹配算法的数据结构。如果同一个正则表达式在程序运行过程中需要反复使用，每次都重新编译显然是不必要的性能开销。因此，建议的做法是在类初始化、方法初始化或者程序启动阶段就预先编译好常用的正则表达式，然后将编译后的Pattern对象保存起来复用，而不是在频繁执行的方法体内每次都重新编译。

2.避免用 ApacheBeanutils 进行属性的 copy。
说明：ApacheBeanUtils 性能较差，可以使用其他方案比如 SpringBeanUtils，CglibBeanCopier，注意均是浅拷贝。

3.velocity 调用 POJO 类的属性时，直接使用属性名取值即可，模板引擎会自动按规范调用 POJO
的 getXxx()，如果是 boolean 基本数据类型变量（boolean 命名不需要加 is 前缀），会自动调 isXxx()方法。
说明：注意如果是 Boolean 包装类对象，优先调用 getXxx() 的方法。

解释：这句话是关于 Velocity 模板引擎如何处理 Java POJO（Plain Old Java Object，普通 Java 对象）类的属性访问机制。Velocity 是一个用于生成动态内容的模板引擎，它可以方便地将变量、表达式嵌入到文本中进行输出。

4.后台输送给页面的变量必须加 $!{var} ——中间的感叹号。
说明：如果 var 等于 null 或者不存在，那么 ${var} 会直接显示在页面上。

5.注意 Math.random() 这个方法返回是 double 类型，注意取值的范围 0 ≤ x < 1（能够
取到零值，注意除零异常），如果想获取整数类型的随机数，不要将 x 放大 10 的若干倍然后取
整，直接使用 Random 对象的 nextInt 或者 nextLong 方法。

Random random = new Random();
int anInt = random.nextInt();
long aLong = random.nextLong();
1
2
3
6.枚举 enum（括号内）的属性字段必须是私有且不可变。

7.不要在视图模板中加入任何复杂的逻辑运算。
说明：根据 MVC 理论，视图的职责是展示，不要抢模型和控制器的活。

8.任何数据结构的构造或初始化，都应指定大小，避免数据结构无限增长吃光内存。

9.及时清理不再使用的代码段或配置信息。
说明：对于垃圾代码或过时配置，坚决清理干净，避免程序过度臃肿，代码冗余。
正例：对于暂时被注释掉，后续可能恢复使用的代码片断，在注释代码上方，统一规定使用三个斜杠(///)

二、日常日志
2.1、错误码
1.错误码的制定原则：快速溯源、沟通标准化。
说明：错误码想得过于完美和复杂，就像康熙字典的生僻字一样，用词似乎精准，但是字典不容易随身携带且简单易懂。
正例：错误码回答的问题是谁的错？错在哪？
1）错误码必须能够快速知晓错误来源，可快速判断是谁的问题。
2）错误码必须能够进行清晰地比对（代码中容易 equals）。
3）错误码有利于团队快速对错误原因达到一致认知。

2.错误码不体现版本号和错误等级信息。
说明：错误码以不断追加的方式进行兼容。错误等级由日志和错误码本身的释义来决定。

3.全部正常，但不得不填充错误码时返回五个零：00000。

4.错误码为字符串类型，共 5 位，分成两个部分：错误产生来源+四位数字编号。
说明：错误产生来源分为 A/B/C，A 表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付超时等问题；B 表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；C 表示错误来源于第三方服务，比如 CDN 服务出错，消息投递超时等问题；四位数字编号从 0001 到 9999，大类之间的步长间距预留 100

5.编号不与公司业务架构，更不与组织架构挂钩，以先到先得的原则在统一平台上进行，审批生
效，编号即被永久固定。

6.错误码使用者避免随意定义新的错误码。
说明：尽可能在原有错误码附表中找到语义相同或者相近的错误码在代码中使用即可。

7.错误码不能直接输出给用户作为提示信息使用。
说明：堆栈（stack_trace）、错误信息(error_message) 、错误码（error_code）、提示信息（user_tip）是一个有效关联并互相转义的和谐整体，但是请勿互相越俎代庖。

8.错误码之外的业务信息由 error_message 来承载，而不是让错误码本身涵盖过多具体业务属性。

2.2、异常处理
1.Java 类库中定义的可以通过预检查方式规避的 RuntimeException 异常不应该通过 catch 的方
式来处理，比如：NullPointerException，IndexOutOfBoundsException 等等。
说明：无法通过预检查的异常除外，比如，在解析字符串形式的数字时，可能存在数字格式错误，不得不通过 catchNumberFormatException 来实现。
正例：if (obj != null) {…}
反例：try { obj.method(); } catch (NullPointerException e) {…}

2.异常捕获后不要用来做流程控制，条件控制。
说明：异常设计的初衷是解决程序运行中的各种意外情况，且异常的处理效率比条件判断方式要低很多。

3.catch 时请分清稳定代码和非稳定代码，稳定代码指的是无论如何不会出错的代码。对于非稳定
代码的 catch 尽可能进行区分异常类型，再做对应的异常处理。
说明：对大段代码进行 try-catch，使程序无法根据不同的异常做出正确的应激反应，也不利于定位问题，这是一种不负责任的表现。
正例：用户注册的场景中，如果用户输入非法字符，或用户名称已存在，或用户输入密码过于简单，在程序上作出分门别类的判断，并提示给用户。

4.捕获异常是为了处理它，不要捕获了却什么都不处理而抛弃之，如果不想处理它，请将该异常
抛给它的调用者。最外层的业务使用者，必须处理异常，将其转化为用户可以理解的内容。

5.事务场景中，抛出异常被 catch 后，如果需要回滚，一定要注意手动回滚事务。

6.finally 块必须对资源对象、流对象进行关闭，有异常也要做 try-catch。
说明：如果 JDK7，可以使用 try-with-resources 方式。

7.不要在 finally 块中使用 return
说明：try 块中的 return 语句执行成功后，并不马上返回，而是继续执行 finally 块中的语句，如果此处存在 return 语句，则会在此直接返回，无情丢弃掉 try 块中的返回点。

8.捕获异常与抛异常，必须是完全匹配，或者捕获异常是抛异常的父类。
说明：如果预期对方抛的是绣球，实际接到的是铅球，就会产生意外情况。

9.在调用 RPC、二方包、或动态生成类的相关方法时，捕捉异常使用 Throwable 类进行拦截。

解释：Throwable是 Java 中所有错误和异常的超类，它有两个主要子类：Error和Exception。其中Error通常表示系统级错误或严重故障，而Exception则涵盖了程序运行时可能出现的可捕获问题。

当我们在上述场景中使用try-catch语句来捕获异常时，直接捕获Throwable可以在一个地方处理所有预期之外的问题。

10.方法的返回值可以为 null，不强制返回空集合，或者空对象等，必须添加注释充分说明什么情
况下会返回 null 值。
说明：本规约明确防止 NPE 是调用者的责任。即使被调用方法返回空集合或者空对象，对调用者来说，也并非高枕无忧，必须考虑到远程调用失败，运行时异常等场景返回 null 的情况。

11.防止 NPE，是程序员的基本修养，注意 NPE 产生的场景：
1）返回类型为基本数据类型，return 包装数据类型的对象时，自动拆箱有可能产生 NPE
反例：public int method() { return Integer 对象; }，如果为 null，自动解箱抛 NPE。
2）数据库的查询结果可能为 null。
3）集合里的元素即使 isNotEmpty，取出的数据元素也可能为 null。
4）远程调用返回对象时，一律要求进行空指针判断，防止 NPE。
5）对于 Session 中获取的数据，建议进行 NPE 检查，避免空指针。
6）级联调用 obj.getA().getB().getC()；一连串调用，易产生 NPE。
正例：使用 JDK8 的 Optional 类来防止 NPE 问题。

2.3、日志规约
1.应用中不可直接使用日志系统（Log4j、Logback）中的 API，而应依赖使用日志框架 （SLF4J、
JCL—Jakarta Commons Logging） 中的 API，使用门面模式的日志框架，有利于维护和各个类的日志处理。

2.日志文件至少保存 15 天，因为有些异常具备以“周”为频次发生的特点。对于当天日志，以
“应用名.log”来保存，保存在/{统一目录}/{应用名}/logs/目录下，过往日志格式为：
{logname}.log.{保存日期}，日期格式：yyyy-MM-dd
正例：以 mppserver 应用为例，日志保存/home/admin/mppserver/logs/mppserver.log，历史日志名称为 mppserver.log.2021-11-28

3.根据国家法律，网络运行状态、网络安全事件、个人敏感信息操作等相关记录，留存的日志不
少于六个月，并且进行网络多机备份。

4.应用中的扩展日志（如打点、临时监控、访问日志等）命名方式：
appName_logType_logName.log。logType：日志类型，如 stats / monitor / access 等；
logName：日志描述。这种命名的好处：通过文件名就可知道日志文件属于什么应用，什么类型，什么目的，也有利于归类查找。
说明：推荐对日志进行分类，将错误日志和业务日志分开放，便于开发人员查看，也便于通过日志对系统进行及时监控。
正例：mppserver 应用中单独监控时区转换异常，如：mppserver_monitor_timeZoneConvert.log

5.在日志输出时，字符串变量之间的拼接使用占位符的方式。
说明：因为 String 字符串的拼接会使用 StringBuilder 的 append() 方式，有一定的性能损耗。使用占位符仅是替换动作，可以有效提升性能。
正例：logger.debug(“Processing trade with id : {} and symbol : {}”, id, symbol);

6.对于 trace / debug / info 级别的日志输出，必须进行日志级别的开关判断：
说明：虽然在 debug(参数) 的方法体内第一行代码 isDisabled(Level.DEBUG_INT) 为真时（Slf4j 的常见实现 Log4j 和 Logback），就直接 return，但是参数可能会进行字符串拼接运算。此外，如果 debug(getName()) 这种参数内有 getName() 方法调用，无谓浪费方法调用的开销。

7.避免重复打印日志，浪费磁盘空间，务必在日志配置文件中设置 additivity=false
正例：<logger name=“com.taobao.dubbo.config” additivity=“false”>

8.生产环境禁止使用 System.out 或 System.err 输出或使用 e.printStackTrace() 打印异常堆栈。
说明：标准日志输出与标准错误输出文件每次 Jboss 重启时才滚动，如果大量输出送往这两个文件，容易造成文件大小超过操作系统大小限制。

9.异常信息应该包括两类信息：案发现场信息和异常堆栈信息。如果不处理，那么通过关键字
throws 往上抛出。
正例：logger.error(“inputParams: {} and errorMessage: {}”, 各类参数或者对象 toString(), e.getMessage(), e);

10.日志打印时禁止直接用 JSON 工具将对象转换成 String。
说明：如果对象里某些 get 方法被覆写，存在抛出异常的情况，则可能会因为打印日志而影响正常业务流程的执行。
正例：打印日志时仅打印出业务相关属性值或者调用其对象的 toString() 方法。

三、单元测试
1.好的单元测试必须遵守 AIR 原则。
说明：单元测试在线上运行时，感觉像空气（AIR）一样感觉不到，但在测试质量的保障上，却是非常关键的。好的单元
测试宏观上来说，具有自动化、独立性、可重复执行的特点。
⚫ A：Automatic（自动化）
⚫ I：Independent（独立性）
⚫ R：Repeatable（可重复）

2.单元测试应该是全自动执行的，并且非交互式的。测试用例通常是被定期执行的，执行过程必须
完全自动化才有意义。输出结果需要人工检查的测试不是一个好的单元测试。不允许使用 System.out 来进行人肉验证，单元测试必须使用 assert 来验证。

3.保持单元测试的独立性。为了保证单元测试稳定可靠且便于维护，单元测试用例之间决不能互相
调用，也不能依赖执行的先后次序。
反例：method2 需要依赖 method1 的执行，将执行结果作为 method2 的输入。

4.单元测试是可以重复执行的，不能受到外界环境的影响。
说明：单元测试通常会被放到持续集成中，每次有代码 push 时单元测试都会被执行。如果单测对外部环境（网络、服务、中间件等）有依赖，容易导致持续集成机制的不可用。

5.对于单元测试，要保证测试粒度足够小，有助于精确定位问题。单测粒度至多是类级别，一般是
方法级别。
说明：测试粒度小才能在出错时尽快定位到出错的位置。单元测试不负责检查跨类或者跨系统的交互逻辑，那是集成测试的领域。

6.核心业务、核心应用、核心模块的增量代码确保单元测试通过。
说明：新增代码及时补充单元测试，如果新增代码影响了原有单元测试，请及时修正。

7.单元测试代码必须写在如下工程目录： src/test/java，不允许写在业务代码目录下。
说明：源码编译时会跳过此目录，而单元测试框架默认是扫描此目录。

8.单测的基本目标：语句覆盖率达到 70%；核心模块的语句覆盖率和分支覆盖率都要达到 100%
说明：在工程规约的应用分层中提到的 DAO 层，Manager 层，可重用度高的 Service，都应该进行单元测试。

注：在实际的 IntelliJ IDEA 开发环境中，可以使用集成的代码覆盖率工具来评估和查看单元测试的覆盖率。

9.编写单元测试代码遵守 BCDE 原则，以保证被测试模块的交付质量 。
⚫ B：Border，边界值测试，包括循环边界、特殊取值、特殊时间点、数据顺序等。
⚫ C：Correct，正确的输入，并得到预期的结果。
⚫ D：Design，与设计文档相结合，来编写单元测试。
⚫ E：Error，强制错误信息输入（如：非法数据、异常流程、业务允许外等），并得到预期的结果。

10.对于数据库相关的查询，更新，删除等操作，不能假设数据库里的数据是存在的，或者直接操
作数据库把数据插入进去，请使用程序插入或者导入数据的方式来准备数据。
反例：删除某一行数据的单元测试，在数据库中，先直接手动增加一行作为删除目标，但是这一行新增数据并不符合业务插入规则，导致测试结果异常。

四、安全规约
1.隶属于用户个人的页面或者功能必须进行权限控制校验。
说明：防止没有做水平权限校验就可随意访问、修改、删除别人的数据，比如查看他人的私信内容。

2.用户敏感数据禁止直接展示，必须对展示数据进行脱敏。
正例：中国大陆个人手机号码显示：139****1219，隐藏中间 4 位，防止隐私泄露。

3.用户输入的 SQL 参数严格使用参数绑定或者 METADATA 字段值限定，防止 SQL 注入，禁止字
符串拼接 SQL 访问数据库。
反例：某系统签名大量被恶意修改，即是因为对于危险字符#–没有进行转义，导致数据库更新时，where 后边的信息被注释掉，对全库进行更新。

解释：强调了在编写数据库操作代码时，应采取安全措施来防止 SQL 注入攻击。SQL 注入是一种常见的安全漏洞，攻击者通过输入恶意构造的 SQL 语句片段，改变原本 SQL 命令的逻辑，以达到非法获取数据、修改或删除记录等目的，具体来说，为了防止 SQL 注入，应该避免直接将用户输入的内容拼接到 SQL 查询字符串中，而是推荐采用参数绑定或者基于元数据（Metadata）字段值限定的方式来处理动态 SQL 条件。

4.用户请求传入的任何参数必须做有效性验证。

5.禁止向 HTML 页面输出未经安全过滤或未正确转义的用户数据。

6.表单、AJAX 提交必须执行 CSRF 安全验证。
说明：CSRF (Cross-site request forgery) 跨站请求伪造是一类常见编程漏洞。对于存在 CSRF 漏洞的应用/网站，攻击者可以事先构造好 URL，只要受害者用户一访问，后台便在用户不知情的情况下对数据库中用户参数进行相应修改。

CSRF 攻击场景举例： 假设银行网站有一个转账功能，URL 可能是https://bank.example/transfer?to_account=12345&amount=10000。攻击者可以构造一个 HTML 表单或者 JavaScript 脚本，嵌入到自己的网页中，当受害者在不知情的情况下访问该页面并触发表单提交或 AJAX 请求时，其浏览器会自动带上受害者在银行网站上的有效 session cookie，导致服务器误以为这是受害者自己发起的转账请求，并完成转账操作。

7.URL 外部重定向传入的目标地址必须执行白名单过滤。
说明：攻击者通过恶意构造跳转的链接，可以向受害者发起钓鱼攻击。

8.在使用平台资源，譬如短信、邮件、电话、下单、支付，必须实现正确的防重放的机制，如数量
限制、疲劳度控制、验证码校验，避免被滥刷而导致资损。
说明：如注册时发送验证码到手机，如果没有限制次数和频率，那么可以利用此功能骚扰到其它用户，并造成短信平台资源浪费。

9.对于文件上传功能，需要对于文件大小、类型进行严格检查和控制。
说明：攻击者可以利用上传漏洞，上传恶意文件到服务器，并且远程执行，达到控制网站服务器的目的。

10.配置文件中的密码需要加密。

11.发贴、评论、发送等即时消息，需要用户输入内容的场景。必须实现防刷、内容违禁词过滤等
风控策略。

五、MySQL 数据库
5.1、建表规约
1.表达是与否概念的字段，必须使用 is_xxx 的方式命名，数据类型是 unsigned tinyint（1 表示
是，0 表示否）。
注意：POJO 类中的任何布尔类型的变量，都不要加 is 前缀，所以，需要在<resultMap>设置从 is_xxx 到 Xxx 的映射关系。数据库表示是与否的值，使用 tinyint 类型，坚持 is_xxx 的命名方式是为了明确其取值含义与取值范围。
说明：任何字段如果为非负数，必须是 unsigned。
正例：表达逻辑删除的字段名 is_deleted，1 表示删除，0 表示未删除。

2.表名、字段名必须使用小写字母或数字，禁止出现数字开头禁止两个下划线中间只出现数字。数
据库字段名的修改代价很大，因为无法进行预发布，所以字段名称需要慎重考虑。
说明：MySQL 在 Windows 下不区分大小写，但在 Linux 下默认是区分大小写。因此，数据库名、表名、字段名，都不允许出现任何大写字母，避免节外生枝。
正例：aliyun_admin，rdc_config，level3_name
反例：AliyunAdmin，rdcConfig，level_3_name

3.表名不使用复数名词。
说明：表名应该仅仅表示表里面的实体内容，不应该表示实体数量，对应于 DO 类名也是单数形式，符合表达习惯。

4.禁用保留字，如 desc、range、match、delayed 等，请参考 MySQL 官方保留字。

解释：在使用 MySQL 数据库时，有一些特定的关键词是被 MySQL 系统保留用来执行特定功能或表示特殊含义的，这些关键词不能作为表名、列名或其他标识符来使用，否则会导致语法错误。

5.主键索引名为 pk_字段名；唯一索引名为 uk_字段名；普通索引名则为 idx_字段名。
说明：pk_即 primary key；uk_即 unique key；idx_即 index 的简称。

6.小数类型为 decimal，禁止使用 float 和 double。
说明：在存储的时候，float 和 double 都存在精度损失的问题，很可能在比较值的时候，得到不正确的结果。如果存储的数据范围超过 decimal 的范围，建议将数据拆成整数和小数并分开存储。

7.如果存储的字符串长度几乎相等，使用 char 定长字符串类型。

8.varchar 是可变长字符串，不预先分配存储空间，长度不要超过 5000，如果存储长度大于此
值，定义字段类型为 text，独立出来一张表，用主键来对应，避免影响其它字段索引率

9.表必备三字段：id，create_time，update_time。
说明：其中 id 必为主键，类型为 bigint unsigned、单表时自增、步长为 1。create_time，update_time 的类型均为 datetime 类型，如果要记录时区信息(或者发生的精确时间)，那么类型设置为 timestamp。

10.在数据库中不能使用物理删除操作，要使用逻辑删除。
说明：逻辑删除在数据删除后可以追溯到行为操作。不过会使得一些情况下的唯一主键变得不唯一，需要根据情况来酌情解决。

11.表的命名最好是遵循“业务名称_表的作用”。
正例：alipay_task / force_project / trade_config / tes_question

12.库名与应用名称尽量一致。

13.如果修改字段含义或对字段表示的状态追加时，需要及时更新字段注释。

5.2、索引规约
1.业务上具有唯一特性的字段，即使是组合字段，也必须建成唯一索引。
说明：不要以为唯一索引影响了 insert 速度，这个速度损耗可以忽略，但提高查找速度是明显的；另外，即使在应用层做了非常完善的校验控制，只要没有唯一索引，根据墨菲定律，必然有脏数据产生。

注：墨菲定律强调了在设计、规划和执行任务时应考虑到最糟糕情况的可能性，并通过严谨的工作流程和备份机制来减少错误发生的概率。

2.超过三个表禁止 join。需要 join 的字段，数据类型保持绝对一致；多表关联查询时，保证被关联
的字段需要有索引。
说明：即使双表 join 也要注意表索引、SQL 性能。

3.在 varchar 字段上建立索引时，必须指定索引长度，没必要对全字段建立索引，根据实际文本区
分度决定索引长度。
说明：索引的长度与区分度是一对矛盾体，一般对字符串类型数据，长度为 20 的索引，区分度会高达 90%以上，可以使用 count(distinct left(列名，索引长度)) / count(*) 的区分度来确定。

4.页面搜索严禁左模糊或者全模糊，如果需要请走搜索引擎来解决。
说明：索引文件具有 B-Tree 的最左前缀匹配特性，如果左边的值未确定，那么无法使用此索引。

5.如果有 order by 的场景，请注意利用索引的有序性。order by 最后的字段是组合索引的一部
分，并且放在索引组合顺序的最后，避免出现 filesort 的情况，影响查询性能。
正例：where a = ? and b = ? order by c；索引：a_b_c
反例：索引如果存在范围查询，那么索引有序性无法利用，如：WHERE a > 10 ORDER BY b；索引 a_b 无法排序。

正例说明： 在 SQL 查询语句 where a = ? and b = ? order by c 中，假设有一个组合索引是 a_b_c。这意味着索引按照字段 a、b、c 的顺序存储了数据，并且每个记录在索引树中的位置反映了这三个字段值的排序情况。

由于查询条件同时包含了 a 和 b 字段的等值匹配（即 WHERE 子句），并且 order by 子句要求对字段 c 进行排序，而 c 恰好是该组合索引的一部分，并且位于索引定义的最后。因此，在这种情况下，MySQL 可以利用这个组合索引来直接获取已经按 c 字段排序的数据，无需额外的文件排序操作（filesort），从而提高查询性能。

5.3、SQL 语句
1.不要使用 count(列名) 或 count(常量) 来替代 count(*)，count(*) 是 SQL92 定义的标准统计行
数的语法，跟数据库无关，跟 NULL 和非 NULL 无关。
说明：count(*) 会统计值为 NULL 的行，而 count(列名) 不会统计此列为 NULL 值的行。

2.count(distinct col) 计算该列除 NULL 之外的不重复行数，注意 count(distinct col1 , col2) 如
果其中一列全为 NULL，那么即使另一列有不同的值，也返回为 0。

3.当某一列的值全是 NULL 时，count(col) 的返回结果为 0；但 sum(col) 的返回结果为 NULL，因
此使用 sum() 时需注意 NPE 问题。
正例：可以使用如下方式来避免 sum 的 NPE 问题：SELECT IFNULL(SUM(column) , 0) FROM table;

4.使用 ISNULL() 来判断是否为 NULL 值。
说明：NULL 与任何值的直接比较都为 NULL。
1）NULL<>NULL 的返回结果是 NULL，而不是 false。
2）NULL=NULL 的返回结果是 NULL，而不是 true。
3）NULL<>1 的返回结果是 NULL，而不是 true。
反例：在 SQL 语句中，如果在 null 前换行，影响可读性。

5.代码中写分页查询逻辑时，若 count 为 0 应直接返回，避免执行后面的分页语句。

6.不得使用外键与级联，一切外键概念必须在应用层解决。

7.禁止使用存储过程，存储过程难以调试和扩展，更没有移植性。

8.数据订正（特别是删除或修改记录操作）时，要先 select，避免出现误删除的情况，确认无误才
能执行更新语句。

9.对于数据库中表记录的查询和变更，只要涉及多个表，都需要在列名前加表的别名（或表名）进
行限定。
说明：对多表进行查询记录、更新记录、删除记录时，如果对操作列没有限定表的别名（或表名），并且操作列在多个表中存在时，就会抛异常。
正例：select t1.name from first_table as t1 , second_table as t2 where t1.id = t2.id;
反例：在某业务中，由于多表关联查询语句没有加表的别名（或表名）的限制，正常运行两年后，最近在某个表中增加一个同名字段，在预发布环境做数据库变更后，线上查询语句出现出 1052 异常：Column ‘name’ infield list is ambiguous。

10.QL 语句中表的别名前加 as ， 并且以 t1、t2、t3、…的顺序依次命名。
说明：
1）别名可以是表的简称，或者是依照表在 SQL 语句中出现的顺序，以 t1、t2、t3 的方式命名。
2）别名前加 as 使别名更容易识别。
正例：select t1.name from first_table as t1 , second_table as t2 where t1.id = t2.id;

11.in 操作能避免则避免，若实在避免不了，需要仔细评估 in 后边的集合元素数量，控制在
1000 个之内。

解释：IN 操作符用于在 SQL 查询语句中指定一个条件列表，例如：WHERE id IN (1, 2, 3, ..., n)，它允许查询结果集中包含与列表中任何一个值相匹配的数据行。在设计 SQL 查询时要关注IN操作符的使用，尽量避免大集合带来的性能问题，并在必要时寻找替代方案以提高查询效率。

5.4、ORM 映射
1.在表查询中，一律不要使用 * 作为查询的字段列表，需要哪些字段必须明确写明。
说明：
1）增加查询分析器解析成本。
2）增减字段容易与 resultMap 配置不一致。
3）无用字段增加网络消耗，尤其是 text 类型的字段。

2.POJO 类的布尔属性不能加 is，而数据库字段必须加 is_，要求在 resultMap 中进行字段与属
性之间的映射。
说明：参见定义 POJO 类以及数据库字段定义规定，在 sql.xml 增加映射，是必须的。

3.不要用 resultClass 当返回参数，即使所有类属性名与数据库字段一一对应，也需要定义
<resultMap>；反过来，每一个表也必然有一个<resultMap>与之对应。
说明：配置映射关系，使字段与 DO 类解耦，方便维护。

4.sql.xml 配置参数使用：#{}，#param# 不要使用 ${} 此种方式容易出现 SQL 注入。

5.iBATIS 自带的 queryForList(String statementName，int start，int size) 不推荐使用。
说明：其实现方式是在数据库取到 statementName 对应的 SQL 语句的所有记录，再通过 subList 取 start，size 的子集合，线上因为这个原因曾经出现过 OOM。

6.不允许直接拿 HashMap 与 Hashtable 作为查询结果集的输出。
反例：某同学为避免写一个<resultMap>xxx</resultMap>，直接使用 Hashtable 来接收数据库返回结果，结果出现日常是把 bigint 转成 Long 值，而线上由于数据库版本不一样，解析成 BigInteger，导致线上问题。

7.更新数据表记录时，必须同时更新记录对应的 update_time 字段值为当前时间。

8.不要写一个大而全的数据更新接口。传入为 POJO 类，不管是不是自己的目标更新字段，都进行
update table set c1 = value1 , c2 = value2 , c3 = value3；这是不对的。执行 SQL 时，不要更新无改动的字段，一是易出错；二是效率低；三是增加 binlog 存储。

六、工程结构
6.1、应用分层
根据业务架构实践，结合业界分层规范与流行技术框架分析

开放 API 层：可直接封装 Service 接口暴露成 RPC 接口；通过 Web 封装成 http 接口；网关控制层等。
⚫ 终端显示层：各个端的模板渲染并执行显示的层。当前主要是 velocity 渲染，JS 渲染，JSP 渲染，移动端展示等。
⚫ Web 层：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
⚫ Service 层：相对具体的业务逻辑服务层。
⚫ Manager 层：通用业务处理层，它有如下特征
1）对第三方平台封装的层，预处理返回结果及转化异常信息，适配上层接口。
2）对 Service 层通用能力的下沉，如缓存方案、中间件通用处理。
3）与 DAO 层交互，对多个 DAO 的组合复用。
⚫ DAO 层：数据访问层，与底层 MySQL、Oracle、Hbase、OceanBase 等进行数据交互。
⚫ 第三方服务：包括其它部门 RPC 服务接口，基础平台，其它公司的 HTTP 接口，如淘宝开放平台、支付宝付款服务、
高德地图服务等。
⚫ 外部数据接口：外部（应用）数据存储服务提供的接口，多见于数据迁移场景中。

6.2、二方库依赖
1.定义 GAV 遵从以下规则：
1）GroupId 格式：com.{公司/BU}.业务线.[子业务线]，最多 4 级。
说明：{公司/BU}例如：alibaba / taobao / tmall / kaikeba 等 BU 一级；子业务线可选。
正例：com.taobao.jstorm 或 com.alibaba.dubbo.register
2）ArtifactId 格式：产品线名-模块名。语义不重复不遗漏，先到中央仓库去查证一下。
正例：dubbo-client / fastjson-api / jstorm-tool
3）Version：详细规定参考下方。

2.二方库版本号命名方式：主版本号.次版本号.修订号
1）主版本号：产品方向改变，或者大规模 API 不兼容，或者架构不兼容升级。
2）次版本号：保持相对兼容性，增加主要功能特性，影响范围极小的 API 不兼容修改。
3）修订号：保持完全兼容性，修复 BUG、新增次要功能特性等。
说明：注意起始版本号必须为：1.0.0，而不是 0.0.1。
反例：仓库内某二方库版本号从 1.0.0.0 开始，一直默默“升级”成 1.0.0.64，完全失去版本的语义信息。

3.线上应用不要依赖 SNAPSHOT 版本（安全包除外）；正式发布的类库必须先去中央仓库进行查
证，使 RELEASE 版本号有延续性，且版本号不允许覆盖升级。
说明：不依赖 SNAPSHOT 版本是保证应用发布的幂等性。另外，也可以加快编译时的打包构建。

解释：

SNAPSHOT 版本通常是指开发过程中的不稳定版本，它可能包含未完成的功能、修复中的 bug 或者是尚未经过充分测试的新特性。上线环境使用 SNAPSHOT 版本会带来不稳定性风险，因为 SNAPSHOT 版本可能会在任何时间点进行更新，导致线上应用的行为不可预测。
安全包除外是因为安全相关的更新往往需要快速响应，即使它们可能是 SNAPSHOT 版本，也必须尽快部署以修补已知的安全漏洞。
一旦一个 RELEASE 版本发布，不应该用新的内容直接覆盖原有的版本号，而应递增版本号来表示更新。这有助于维护版本历史清晰，避免因重复版本号造成混乱，并且使得依赖于特定版本的应用能够选择正确的版本进行更新。

不依赖 SNAPSHOT 版本有利于保证应用部署的幂等性，即多次部署相同的版本会产生相同的结果，这对于持续集成/持续部署（CI/CD）流程至关重要。

同时，由于 RELEASE 版本相对固定，不需要每次构建时都去检查是否有 SNAPSHOT 版本的更新，因此在编译时查找和下载依赖的速度更快，从而加快了打包构建的进程。

4.二方库的新增或升级，保持除功能点之外的其它 jar 包仲裁结果不变。如果有改变，必须明确评
估和验证。
说明：在升级时，进行 dependency:resolve 前后信息比对，如果仲裁结果完全不一致，那么通过 dependency:tree 命令，找出差异点，进行<exclude>排除 jar 包。

5.二方库里可以定义枚举类型，参数可以使用枚举类型，但是接口返回值不允许使用枚举类型或者
包含枚举类型的 POJO 对象。

6.二方库定制包的命名方式，在规定的版本号之后加“-英文说明[序号]”，英文说明可以是部门
简称、业务名称，序号直接紧跟在英文说明之后，表示此定制包的顺序号。
说明：fastjson 给 SCM 定制的版本号：1.0.0-SCM1。注：请尽可能在应用端来解决类冲突和加载问题，避免随意发布此类定制包。

7.依赖于一个二方库群时，必须定义一个统一的版本变量，避免版本号不一致。
说明：依赖 springframework-core，-context，-beans，它们都是同一个版本，可以定义一个变量来保存版本：${spring.version}，定义依赖的时候，引用该版本。

8.禁止在子项目的 pom 依赖中出现相同的 GroupId，相同的 ArtifactId，但是不同的 Version。

9.底层基础技术框架、核心数据管理平台、或近硬件端系统谨慎引入第三方实现。

6.3、服务器
1.调用远程操作必须有超时设置。
说明：类似于 HttpClient 的超时设置需要自己明确去设置 Timeout。根据经验表明，无数次的故障都是因为没有设置超时时间。

2.客户端设置远程接口方法的具体超时时间（单位 ms），超时设置生效顺序一般为：1）客户
端 Special Method；2）客户端接口级别；3）服务端 Special Method；4）服务端接口级别。

3.高并发服务器建议调小 TCP 协议的 time_wait 超时时间。
说明：操作系统默认 240 秒后，才会关闭处于 time_wait 状态的连接，在高并发访问下，服务器端会因为处于 time_wait 的连接数太多，可能无法建立新的连接，所以需要在服务器上调小此等待值。
正例：在 linux 服务器上请通过变更/etc/sysctl.conf 文件去修改该缺省值（秒）：net.ipv4.tcp_fin_timeout=30

七、设计规约
1.存储方案和底层数据结构的设计获得评审一致通过，并沉淀成为文档。
说明：有缺陷的底层数据结构容易导致系统风险上升，可扩展性下降，重构成本也会因历史数据迁移和系统平滑过渡而陡然增加，所以，存储方案和数据结构需要认真地进行设计和评审，生产环境提交执行后，需要进行 double check。
正例：评审内容包括存储介质选型、表结构设计能否满足技术方案、存取性能和存储空间能否满足业务发展、表或字段之间的辩证关系、字段名称、字段类型、索引等；数据结构变更（如在原有表中新增字段）也需要在评审通过后上线。

2.在需求分析阶段，如果与系统交互的 User 超过一类并且相关的 UseCase 超过 5 个，使用用例图来表达更加清晰的结构化需求。

3.如果某个业务对象的状态超过 3 个，使用状态图来表达并且明确状态变化的各个触发条件。
说明：状态图的核心是对象状态，首先明确对象有多少种状态，然后明确两两状态之间是否存在直接转换关系，再明确触发状态转换的条件是什么。
正例：淘宝订单状态有已下单、待付款、已付款、待发货、已发货、已收货等。比如已下单与已收货这两种状态之间是不可能有直接转换关系的。

4.如果系统中某个功能的调用链路上的涉及对象超过 3 个，使用时序图来表达并且明确各调用环
节的输入与输出。
说明：时序图反映了一系列对象间的交互与协作关系，清晰立体地反映系统的调用纵深链路。

5.如果系统中模型类超过 5 个，且存在复杂的依赖关系，使用类图来表达并且明确类之间的关系。
说明：类图像建筑领域的施工图，如果搭平房，可能不需要，但如果建造蚂蚁 Z 空间大楼，肯定需要详细的施工图。

6.如果系统中超过 2 个对象之间存在协作关系，并需要表示复杂的处理流程，使用活动图来表示。
说明：活动图是流程图的扩展，增加了能够体现协作关系的对象泳道，支持表示并发等。

7.系统设计时要准确识别出弱依赖，并针对性地设计降级和应急预案，保证核心系统正常可用。
说明：系统依赖的第三方服务被降级或屏蔽后，依然不会影响主干流程继续进行，仅影响信息展示、或消息通知等非关键功能，那么这些服务称为弱依赖。
正例：当系统弱依赖于多个外部服务时，如果下游服务耗时过长，则会严重影响当前调用者，必须采取相应降级措施，比如，当调用链路中某个下游服务调用的平均响应时间或错误率超过阈值时，系统自动进行降级或熔断操作，屏蔽弱依赖负面影响，保护当前系统主干功能可用。
反例：某个疫情相关的二维码出错：“服务器开了点小差，请稍后重试”，不可用时长持续很久，引起社会高度关注，原因可能为调用的外部依赖服务 RT 过高而导致系统假死，而在显示端没有做降级预案，只能直接抛错给用户。

八、其它
8.1、版本历史
2017/02/09 正式版 1.0.0->详尽版本 1.4.0->华山版 1.5.0->泰山版 1.6.0->嵩山版 1.7.0->2022/02/03 黄山版 1.7.1

8.2、专用名词解释
POJO（Plain Ordinary Java Object）：在本规约中，POJO 专指只有 setter / getter / toString 的简单类，包括 DO / DTO / BO / VO 等。
DO（Data Object）：阿里巴巴专指数据库表一 一对应的 POJO 类。 此对象与数据库表结构一 一对应，通过 DAO 层向上传输数据源对象。
PO（Persistent Object）：也指数据库表一 一对应的 POJO 类。 此对象与数据库表结构一 一对应，通过 DAO 层向上传输数据源对象。
DTO（Data Transfer Object ）：数据传输对象，Service 或 Manager 向外传输的对象。
BO（Business Object）：业务对象，可以由 Service 层输出的封装业务逻辑的对象。
Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类来传输。
VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。
CAS（Compare And Swap） ：解决多线程并行情况下使用锁造成性能损耗的一种机制，这是硬件实现的原子操作。CAS 操作包含三个操作数：内存位置、预期原值和新值。如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值。否则，处理器不做任何操作。
GAV（GroupId、ArtifactId、Version）：Maven 坐标，是用来唯一标识 jar 包。
OOP（Object Oriented Programming）：本文泛指类、对象的编程处理方式。
AQS（AbstractQueuedSynchronizer）：利用先进先出队列实现的底层同步工具类，它是很多上层同步实现类的基础，比如： ReentrantLock、CountDownLatch、 Semaphore 等，它们通过继承 AQS 实现其模版方法，然后将 AQS 子类作为同步组件的内部类，通常命名为 Sync。
ORM（Object Relation Mapping）：对象关系映射，对象领域模型与底层数据之间的转换，本文泛指 iBATIS，mybatis 等框架。
NPE（java.lang.NullPointerException）：空指针异常。
OOM（Out Of Memory）：源于 java.lang.OutOfMemoryError，当 JVM 没有足够的内存来为对象分配空间并且垃圾回收器也无法回收空间时，系统出现的严重状况。
GMT（Greenwich Mean Time）：指位于英国伦敦郊区的皇家格林尼治天文台的标准时间，因为本初子午线被定义在通过那里的经线。地球每天的自转是有些不规则的，而且正在缓慢减速，现在的标准时间是协调世界时（UTC），它由原子钟提供。
一方库：本工程内部子项目模块依赖的库（jar 包）。
二方库：公司内部发布到中央仓库，可供公司内部其它应用依赖的库（jar 包）。
三方库：公司之外的开源库（jar 包）。