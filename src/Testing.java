

public class Testing {

    private int a;
    private int b;

    public Testing() {
        // TODO Auto-generated constructor stub
    }

    public Testing(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString() {

        // TODO Auto-generated method stub
        return "First" + Integer.toString(this.a) + "SECOND" + Integer.toString(this.b);
    }
// PRECONDITION
    // TODO dd
    public void setA(int a) {
        this.a = a;
    }



    public void setB(int b) {
        this.b = b;
    }
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }



    public int add(int a, int b) {

        int ans = a + b;

        return ans;
    }

    public int aDom(int a, int b){
         a = this.a;
        return  a + b;
    }
 /* Precondition
  this is about the stament below
  this can also do this
  */
public static int minIndex(int[] array){
    int tempSmall = 0;
    for (int i = 1; i < array.length; i++) {
        if (array[tempSmall] > array[i] )
            tempSmall = i;
        }
        return tempSmall;
    }



    public static void main(String[] args) {
        int[] array={2,4,6,5,99,3,4,1,1,155};

        System.out.println("Indexof the smallest is " + minIndex(array));

        Testing a = new Testing(2,3);
        System.out.println(a);
        a.add(33, 66);

        System.out.println(a.add(33, 33));
        System.out.println(a);
        System.out.println(a.aDom(22,44));


        System.out.println("Hello");
    }

}
