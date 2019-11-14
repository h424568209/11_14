class P{
    String name = "No";
    public  P(String s ){
        name = s;
    }
}
class  C extends P{
    String s = "000";
    public C(String ss){
        super(ss);
        s = ss;
    }
}
public class test {
    public static void main(String[] args) {
        C c = new C("123");
        System.out.println(c.s);
    }
}
