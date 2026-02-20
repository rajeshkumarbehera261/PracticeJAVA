import java.util.ArrayList;

public class R {
    public static ArrayList<Integer> getUnique(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< arr.length;i++){
            boolean found = false;
            for(int j =0; j< arr.length; j++){
                if(i != j && arr[i] == arr[j]){
                    found = true;
                    break;
                }
            }
            if(found == false){
                list.add(arr[i]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(getUnique(new int[]{4,3,2,3,4,5,6}));
    }
}
