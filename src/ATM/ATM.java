package ATM;

import com.sun.source.tree.ContinueTree;

import javax.xml.transform.Source;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ACCOUNT currentAccount;
 private ArrayList<ACCOUNT>allAccount=new ArrayList<>();
 private Scanner sc=new Scanner(System.in);




 public void start(){
     while (true) {
     System.out.println("=======欢迎进入银行=======");
     System.out.println("1.登录账号");
     System.out.println("2.注册账号");


         System.out.println("请输入命令：");
         String command=sc.next();
       switch(command){
           case"1":
               if(allAccount.size()<1) {
                   System.out.println("系统中还没有账号，先去新建一个吧");
                   break;
               }else{
                   while (true) {
                       System.out.println("请输入账号：");
                       String id=sc.next();
                       System.out.println("请输入密码：");
                       String password=sc.next();
                       ACCOUNT loginAcc=getAccountById(id);
                       if (loginAcc!=null&&loginAcc.getPassword().equals(password)){

                           while (true) {
                               System.out.println("========恭喜您登录成功==========");
                               currentAccount=loginAcc;
                               boolean exit=showHome();
                               if(exit){
                                   currentAccount=null;
                                   break;
                               }

                           }
                           break;


                       }else{
                           System.out.println("账号不存在，请仔细检查");
                       }

                   }
                   break;




               }

           case "2":
              registerAccount();

       }

     }

 }

    private boolean showHome() {

        System.out.println("1.卡号查询");
        System.out.println("2.余额查询");
        System.out.println("3.存款业务");
        System.out.println("4.取款业务");
        System.out.println("5.转账业务");
        System.out.println("6.密码修改");
        System.out.println("7.退出账户");
        System.out.println("8.注销账户");
        System.out.println("请输入操作指令：");

        String command=sc.next();

        switch(command){
            case "1":
                System.out.println("您的卡号是："+currentAccount.getId());
                break;
            case "2":
                System.out.println("您当前账号的余额为："+currentAccount.getBalance());
                break;
            case "3":
                System.out.println("请输入您要存入的金额：");
                double num=sc.nextDouble();
                currentAccount.setBalance(+num);
                break;
            case "4":
                System.out.println("请输入您要取的金额：");
                double numget=sc.nextDouble();
                currentAccount.setBalance(-numget);
                break;
            case "5":
                System.out.println("请输入对方的账号：");
                String otherid=sc.next();
               if (getAccountById(otherid)==null){
                   System.out.println("系统中查无此账户");
               } else {
                   System.out.println("请输入您要转账的金额：");
                   double transMoney=sc.nextDouble();
                   currentAccount.setBalance(+transMoney);
               }
                break;
            case "6":
                System.out.println("请输入您当前的密码：");
                String nowPassword=sc.next();
                while (true) {
                    if(currentAccount.getPassword().equals(nowPassword)){

                            System.out.println("请输入您的新密码");
                            String newPassword1=sc.next();
                            System.out.println("请确认您的新密码");
                            String newPassword2=sc.next();
                            if (newPassword1.equals(newPassword2)){
                                System.out.println("恭喜您密码修改成功");
                                currentAccount.setPassword(newPassword1);
                                break;
                            }else{
                                System.out.println("前后密码不一致请重新输入");
                            }


                    }else{
                        System.out.println("当前密码输入错误请重新输入");

                    }
                }
                break;
                case "7":
                    System.out.println("确认要退出吗？");
                    System.out.println("Y/N");
                    String COMD= sc.next();
                    if(COMD.equals("Y")){
                        return true;
                    }
                          break;



        }
        return false;


    }//展示登录主界面

    private void registerAccount() {
         ACCOUNT acc=new ACCOUNT();
        System.out.println("请输入姓名");
        String name = sc.next();
        acc.setName(name);                                //设置姓名
        while (true) {
            System.out.println("请输入性别");
            String sex = sc.next();
            if(sex.equals("男")||sex.equals("女")){
                acc.setSex(sex);
                break;
            }else{
                System.out.println("输入的性别非法，请重新输入");
            }
        }
        //设置性别



        while (true) {
            System.out.println("请输入密码：");
            String password1 = sc.next();
            System.out.println("请确认输入的密码：");
            String password2 = sc.next();
            if (password1.equals(password2)) {
                acc.setPassword(password1);
                System.out.println("密码设置完成");
                break;
            } else {
                System.out.println("密码错误请重新输入！");
            }
              }//判断密码是否正确.

        while (true) {
            String id="";
            Random r=new Random();
            for(int i=0;i<8;i++) {
                id += r.nextInt(10);//生成一个随机的8位置id
            }
            if(getAccountById(id)==null){
                acc.setId(id);
                break;
            }
        }

        allAccount.add(acc);
        System.out.println("恭喜" + acc.getName() + userInfo(acc)+"注册成功您的卡号是"+acc.getId()+"亲妥善保管");

    }    //注册函数

    private  ACCOUNT getAccountById(String id) {
        ACCOUNT acc;
     for (int i=0;i < allAccount.size();i++) {
         acc = allAccount.get(i);

         if (acc.getId().equals(id)) {
             return acc;
         }
     }
        return null;
    }//在已有集合中通过id查找是否有账号，有返回账号，没有返回null；


    private  String userInfo(ACCOUNT acc) {
        return acc.getSex().equals("男") ? "先生" : "女士";


    } //判断先生女士称谓




}
