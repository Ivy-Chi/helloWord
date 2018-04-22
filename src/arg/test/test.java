package arg.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 */

public class test {

    /**
     * 打印出对象
     *
     * @param index
     * @param obj
     */
    public static void print(int index, Object obj) {
        System.out.println(String.format("{%d},%s", index, obj.toString()));
    }

    public static void demoOperation() {
        print(1, 5 / 2);
        print(2, 5 + 2);
        print(3, 5 - 2);
        print(4, 5 * 2);
        print(5, 5 << 2);
        print(6, 5 >> 2);
        print(7, 5 | 2);
        print(8, 5 & 2);   //0x101  &  0x10  =  0x000
        print(9, 5 ^ 2);
        print(10, 5 == 2);
        print(11, 5 != 2);

        int a = 2;
        double b = 2.0;
        a += 2;
        a = a + 2;
        print(12, a);

    }

    public static void demoControlFlow() {
        int score = 65;
        if (score > 80) {
            print(1, "A");
        } else if (score > 60) {
            print(2, "B");
        } else {
            print(3, "C");
        }

        String grade = "B";
        switch (grade) {
            case "A":
                print(4, "score > 80");
                break;
            case "B":
                print(5, "(60,80)");
                break;
            default:
                print(6, "0,60");
        }

        for (int i = 0; i < 6; ++i) {
            if (i == 1) {
                continue;
            }
            if (i == 5) {
                break;
            }
            if (i % 2 == 1) {
                print(8, "i%2=1");
            }
            print(7, i);
        }

        String str = "hello";
        for (char c : str.toCharArray()) {
            print(9, c);
        }

        int target = 20;
        int current = 0;
        while (current < target) {
            current += 5;
            print(10, current);
            if (current == 10) {
                break;
            }
        }
    }

    public static void demoString() {
        String str = "hello nowcoder";
        print(1, str.indexOf('e'));
        print(2, str.charAt(6));
        print(3, str.codePointAt(1));  //输出ascii码
        print(4, str.compareTo("hello mowcoder")); //返回第一个不相等字符ascii码的差
        print(5, str.compareTo("hello oowcoder"));
        print(6, str.compareToIgnoreCase("Hello Nowcoder"));   //忽略大小写比较
        print(7, str.concat("!!"));    //后接字符串
        print(8, str.contains("hello"));  //判断是否包含字符串
        print(9, str.endsWith("xowcoder"));   //判断是否以某字符串结束
        print(10, str.startsWith("hello"));    //
        print(11, str.lastIndexOf('o'));   //从后往前查找字符
        print(12, str.toUpperCase());      // 转换为大写
        print(13, str.replace('o', 'a'));   //字符替代
        print(14, str.replaceAll("o|l", "a"));   // o和l 都替代成a
        print(15, str.replaceAll("hello", "hi"));  //  字符串替代


        StringBuilder sb = new StringBuilder();     //Sring 不可变，只有SringBuilder 和 StringBuffer 可变
        sb.append(true);
        sb.append(1);
        sb.append(2.2);
        print(16, sb.toString());    // 效率较高
        print(17, "a" + "b" + String.valueOf(12));  //效率低
    }

    public static void demoList() {
        List<String> strList = new ArrayList<String>();
        for (int i = 0; i < 4; ++i) {
            strList.add(String.valueOf(i));
        }
        print(1, strList);

        List<String> strListB = new ArrayList<String>();
        for (int i = 0; i < 4; ++i) {
            strListB.add(String.valueOf(i * i));
        }
        strList.addAll(strListB);          //后面接上B
        print(2, strList);
        strList.remove(4);        //按索引删
        print(3, strList);
        strList.remove(String.valueOf(9));    //按数值删
        print(4, strList);
        print(5, strList.get(1));    //读取某个值，必须用get

        Collections.sort(strList);     //从小到大排序
        print(6, strList);
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });        //自定义排序方法
        print(7, strList);

        Collections.reverse(strList);    //逆序排序
        print(8, strList);

        int[] array = new int[]{1, 2, 3};
        print(9, array[1]);
    }

    public static void demoSet() {
        //底层是红黑树
        Set<String> strSet = new HashSet<String>();
        for (int i = 0; i < 3; ++i) {
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
        }
        print(1, strSet);
        strSet.remove("1");
        print(2, strSet);
        print(3, strSet.contains(4));
        strSet.addAll(Arrays.asList(new String[]{"A", "B", "C"}));   //
        print(4, strSet);

        for (String value : strSet) {
            print(5, value);
        }

        print(6, strSet.isEmpty());
        print(7, strSet.size());
    }

    public static void demoKeyValue() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 4; ++i) {
            map.put(String.valueOf(i), String.valueOf(i * i));
        }
        print(1, map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            print(2, entry.getKey() + ":" + entry.getValue());
        }
        print(3, map.keySet());          //遍历Key
        print(4, map.values());          //遍历值
        print(5, map.containsKey("2"));  //是否存在key=2
        print(6, map.get("2"));          //  取key=2 所对映的值
        map.replace("1", "A");                   //把1换成A
        print(7, map);

    }

    public static void demoException1() {                               //异常
        try {
            print(1, "hello");
            int a = 2;
            a = a / 0;
            String b = null;
            b.indexOf('a');
        } catch (NullPointerException npe) {
            print(3, "NPE");
        } catch (Exception e) {
            print(4, "Exception");
        } finally {
            print(2, "finally");        //做清理工作
        }
    }

    public static void demoException2() throws Exception {                 //异常
        print(1, "hello");
        int a = 2;
        a = a / 0;
        String b = null;
        b.indexOf('a');
    }

    public static void demoCommon() {
        Random random = new Random();
        random.setSeed(1);                               //指定种子后产生的随机序列将不变
        for (int i = 0; i < 4; ++i) {
            print(1, random.nextInt(100));     //100以内随机整数(伪随机数)
        }
        //int lastvalue = 11;
        //next = seed + (lastvalue*10001)<<2%1000;
        //lastvalue=next;

        List<Integer> array = Arrays.asList(new Integer[]{1,2,3,4,5});
        print(3,array);
        Collections.shuffle(array);       //随机改变队列顺序
        print(4,array);

        Date date=new Date();
        print(5,date);
        print(6,date.getTime());     //以97年1月1日零点为00000000计算的日期
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //输出时间（格式化的）
        print(7,df.format(date));
        print(8,DateFormat.getDateInstance(DateFormat.FULL).format(date));     //输出中文年月日星期

        print(9, UUID.randomUUID());                 //随机产生一个32位的ID
        print(10,Math.max(1,2));
        print(10,Math.ceil(2.2));
        print(10,Math.floor(2.5));
        print(10,Math.log(2.79));
    }

    public static Animal getAnimal(int type){                           //面向接口编程，程序扩展性好
        //return new Animal("2",1);
        return new Human("Lei",22,"CN");
    }

    public  static void demoClass(){
        Animal animal=new Animal("Jim",1);
        animal.say();
        animal=new Human("Lei",11,"CN");
        animal.say();
    }

    public static void main(String[] args) {
        //System.out.println("Hello Word!");
        // print(1,"hello word");
        //demoOperation();
        //demoControlFlow();
        //demoString();
        //demoList();
        //demoSet();
        //demoKeyValue();
        // demoException1();

        // try{
        //     demoException2();
        // }catch(NullPointerException npe) {
        //      print(3,"NPE");
        // }catch(Exception e) {
        //     print(4,"Exception");
        // }finally{
        //     print(2,"finally");        //做清理工作
        // }}

        //demoCommon();
        demoClass();
    }
}
