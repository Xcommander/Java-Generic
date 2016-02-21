import java.util.List;

/**
 * Created by SiLing Xu on 2016/2/21.
 */
public class GenericTest {
     class Box<T>{
        private T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Box(T data) {
            this.data = data;
        }

        public Box() {
        }
    }

    public static void main(String[] args) {
        /**
         * java 内部类要实例化，分两种情况：
         * （1）分静态类static，需要实例化包含这个类的父类，如本例中先实例化GenericTest类
         * （2）static class（静态类），不需要这么做,可以直接new Box()
         * **/
        Box<String> b1=new GenericTest().new Box<String>("111");
        Box<Integer> b2=new GenericTest().new Box<>(12);
//        System.out.println("b1 = " + b1.toString());
//        System.out.println("b2.getClass() = " + b2.toString());
        new GenericTest(){
            {
                getData(b1);
                getData(b2);
                getDataEx(b2);
//                getDataSu(b2);

            }
        };

    }
    /**?是通配符，表示适应任何传来的对象引用,
     * 泛型的上限,extends T,只能是T类及其子类
     * 泛型的下限，super，
     * **/
    public void getData(Box<?> D){
        System.out.println("D = " + D.data);

    }
    public void getDataEx(Box<? extends Number> D){
        System.out.println("D = " + D.getData());

    }
    public void getDataSu(Box<? super Number> D){
        System.out.println("true = " + D.getData());

    }



}

