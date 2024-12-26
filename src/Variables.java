public class Variables {
    private int  Data;
    private String Name;

    public Variables (String a,int  b){
        Data=b;
        Name =a;
    }
    public void SetData(int  a){
        Data=a;
    }
    public int  GetData(){
        return Data;

    }
    public void SetName(String  a){
        Name=a;
    }
    public String   GetName(){
        return Name;

    }


}
