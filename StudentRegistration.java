import java.util.*;
import java.io.*;

interface Sr
{
   public void insertStudent();
 
}
class Student implements Sr
{
    char names[]=new char[100];
    char course[]=new char[100];
    char regid[]=new char[100];
    int n = 0;
   public void display()
    {
        try {//read
      
            FileReader input = new FileReader("StudentFile.txt");
            input.read(names);
            input.read(course);
            input.read(regid);
            System.out.println("Data in the file:");
            System.out.println(names);
            System.out.println(course);
            System.out.println(regid);
            input.close();
          }
          catch(Exception e) {
            e.getStackTrace();
          }
    
    }
    String na;
    String co;
    String r;
   public void insertStudent() 
    {
      Scanner s = new Scanner(System.in);
        System.out.print("Enter name of Student : ");
         this.na=s.nextLine();
        
        System.out.print("Course");
        this.co=s.nextLine();
        
        System.out.print("Registration no. : ");
         this.r = s.nextLine();

     int l1=na.length();
     int l2 = co.length();
     int l3 =r.length();
     for(int i =0;i<l1;++i)
     {
      names[i] = na.charAt(i);
     }
     for(int i =0;i<l2;++i)
     {
      course[i] = co.charAt(i);
     }
     for(int i =0;i<l3;++i)
     {
    regid[i] = r.charAt(i);
     }
  }
  public static void appendStrToFile(String fileName,String str)
{
try {

BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
out.write(str);
out.close();
}

catch (IOException e) {
System.out.println("exception occurred" + e);
}
}
}


class projecttry extends Student
{

public static void main(String args[])throws FileNotFoundException
{  try (Scanner sc = new Scanner(System.in)) {
    projecttry S= new projecttry();
        int op;
      
        File file = new File("StudentFile.txt");

        try {
          boolean value = file.createNewFile();//create
          if (value) {
            System.out.println("The new file is created.");
          }
          else {
            System.out.println("The file already exists.");
          }
        }
        catch(Exception e) 
        {
          e.getStackTrace();
        }
       
        int num;
        int c=0;
       do{ System.out.println("Enter Option:\n1..Insert\n2..Read\n3 ..Exit\n:");
        op=sc.nextInt();
        switch(op)
        {
case 1:System.out.print("Enter no. of students :");
                    num =sc.nextInt();
                    S.n=S.n+num;
                    
                    for(int i=0;i<num;++i){
                    S.insertStudent(); 
                    String fileName = "StudentFile.txt";
                      if(c==0){
                   
                    try {
             
                        
                        BufferedWriter out = new BufferedWriter(
                            new FileWriter(fileName));
             
                        out.close();
                    }
             
                    
                    catch (IOException e) {
             
                        
                        System.out.println("Exception Occurred" + e);
                    } ++c;}
    
                    String n1=S.na;
                    String sss="\n";
                    String c1 = S.co;
                    String str = S.r;
                    
                    appendStrToFile(fileName, n1);
                    appendStrToFile(fileName, sss);
                    appendStrToFile(fileName, str);
                    appendStrToFile(fileName,sss);
                    appendStrToFile(fileName, c1);
                    appendStrToFile(fileName,sss);
                    appendStrToFile(fileName, sss);
                    
                    try {
                        BufferedReader in = new BufferedReader(
                            new FileReader("StudentFile.txt"));
             
                        String mystring;
                        while ((mystring = in.readLine()) != null) {
                            System.out.println(mystring);
                        }
                    }
                    catch (IOException e) {
                        System.out.println("Exception Occurred" + e);
                    }
                    
                  }
                        break;

case 2 :   S.display();
            break;
case 3:break;
 default: System.out.println("Invalid ");
                }//switch


  }while(op!=3);
}
}
}