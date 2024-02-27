package DAY_22_Questions;
class Student
{
    private int id;
    private String name;
    private String contactNo;
    Student(int id,String name,String contactNo)
    {
        this.id=id;
        this.name=name;
        this.contactNo=contactNo;
    }
    public boolean equals(Object obj)
    {
          if(obj==this)           //shallow comparison
          {
              /**if Shallow comparison returns true only then need to check their contents also i.e. perform deep comparison
               *
               */
              Student newobj=(Student) obj;
              if(newobj.id==this.id && newobj.contactNo.equals(this.contactNo) && this.name.equals(newobj.name))  //Deep comparison
              {
                  return true;
              }
              else/** if shallow comparison returns false then no need to do its deep comparison **/
              {
                  return false;
              }
          }
          return false;
    }
}
public class Question5_DeepComparator
{
    public static void main(String[] args)
    {

        Student s1= new Student(23,"Simran","7740066387");
        Student s2=s1;
        Student s3= new Student(45,"Harman","998873729");
        System.out.println((s1.equals(s2)));
        System.out.println(s1.equals(s3));
    }
}
