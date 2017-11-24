import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Media {
    public static void main(String[] args) throws Exception{
        MedAA medAA=new MedAA();
        while (true) {


            Scanner in = new Scanner(System.in);
            System.out.println("选择操作");
            System.out.println("a 增加内容");
            System.out.println("b 删除内容");
            System.out.println("c 修改内容");
            System.out.println("d 查看内容");
            String opertype = in.next();
            if (opertype.equals("a")) {
                System.out.println("输入name");
                String name = in.next();
                System.out.println("输入number");
                int number = in.nextInt();
                Med med = new Med(name, number);
                medAA.add(med);
            } else if (opertype.equals("b")) {
                System.out.println("输入要删除的number");
                int number = in.nextInt();
                medAA.delete(number);
            } else if (opertype.equals("c")) {
                System.out.println("输入要修改的name");
                String name = in.next() ;
                System.out.println("重新录入内容，请输入name");
                String newname = in.next();
                System.out.println("重新录入内容，请输入number");
                int newnumber = in.nextInt();
                Med newmed = new Med(newname, newnumber);
                medAA.updata(name, newmed);
            } else if (opertype.equals("d")) {
                medAA.output();
            }

        }
    }
}
class Med{
    private String name;
    private int number;

    public Med(String n, int ID) {
        name = n;
        number = ID;
    }

    public String getName() {

        return name;
    }

    public int getNumber() {

        return number;
    }
}

//信息操作
class MedAA {
    ArrayList<Med> a = new ArrayList<>() ;
    private int count;

    //增加
    public void add(Med med) {
        a.add(med);
    }


    //删除
    public void delete(int id) {
        Iterator<Med> it = a.iterator();
        while (it.hasNext()) {
            Med med = it.next();
            if (med.getNumber() == id) {
                it.remove();
            }
        }
    }


    //替换
    public void updata(String name, Med newmed) {
        for (Med med : a) {
            if (med.getName().equals(name)) {
                a.set(count - 1, newmed);
                break;
            }
        }
    }

    //输出
    public void output() {
        for (Med med : a) {

                System.out.print(med.getName());
                System.out.print(" " + med.getNumber());

        }
    }
}



