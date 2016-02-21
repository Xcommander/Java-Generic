/**
 * Created by SiLing Xu on 2016/2/21.
 */
public class insideClass {
    public static void main(String[] args) {
        out.in inOne=new out().new in();
        inOne.setTest("1111");
//        inOne.print();
//        outTwo.inTwo inTwo=new outTwo().new inTwo();
//        inTwo.print();
//        outThree.inThree inThree=new outThree.inThree();
//        inThree.print();
//        outFour outFour=new outFour();
//        outFour.CallIn();
//        outFive outFive=new outFive();
//        outFive.FuncIn(3);

    }


}
/**********************内部类1---start******************************************************/
/**
 * 在另外一个类中调用这个类的内部类，则必须要前面加上这个类，如调用in，则申明为out.in,如果直接在本类中调用内部类，就不需要加上out
 * **/
class out{
    class in{
        public String test;

        public void setTest(String test) {
            this.test = test;
        }

        public String getTest() {
            return test;
        }
        public void print(){
            System.out.println("匿名类-----1 测试 "+test);
        }
    }
}
/**********************内部类1---end******************************************************/
/**********************内部类2---start******************************************************/
class outTwo{
    /**
     * 内部类的变量访问形式
     * 不同名的情况下会直接访问外部类和内部类的变量
     * 同名情况下，则需要通过this来指明
     * 内部类访问外部类是不管变量声明的，不管是private，public还是protected都能访问
     * **/
    private String TAG="ClassTwo";
    private String TAG1="inTwo1";
    class inTwo{
        private String TAG="inTwo";
        public void print(){
            String TAG="InsideTwo";
            System.out.println("访问局部变量"+TAG);
            System.out.println("访问全局变量"+this.TAG);
            System.out.println("访问外部类变量"+outTwo.this.TAG);
            System.out.println("访问外部类变量--1"+TAG1);
        }

    }




}
/**********************内部类2---end******************************************************/
/**********************内部类3---satrt******************************************************/
/**
 * 静态内部类static class,由于在编译阶段,静态类就初始化完成，所以其只能访问外部类的静态变量，因为外部静态变量也是初始化好了
 *
 * **/
class outThree{
    public static String s="outThree";
    public String s1="11";
    static class inThree{
        public void print(){
            System.out.println(s);
        }
    }
}
/**********************内部类3---end******************************************************/
/**********************内部类4---start******************************************************/
/**
 * 私有内部类，私有内部类只允许所在的外部类访问，不允许其他外部类访问，所以要想调用私有内部类的方法或者其他，
 * 则必须由本外部类来提供方法来实例化私有内部类,再调用
 * **/
class outFour{
    private class inFour{
        public  String xxx="inFour";
        public void print(int x){
            System.out.println(xxx);
        }
    }
    public void CallIn(){
        new inFour(){
            {
                print(2);
            }
        };
    }

}
/**********************内部类4---end******************************************************/
/**********************内部类5---start******************************************************/
/**
 * 方法内部类
 * **/
class outFive{
    public void FuncIn(int x){
        class inFive{
            public void print(){
                System.out.println(x);
            }
        }
        new inFive().print();
    }
}
/**********************内部类5---end******************************************************/