public class SecondLargest {

    
    public static int get2ndLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i]>secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    public static void main(String[] args){
        int[] arr = new int[]{2,4,3,9,4,47,5,18,89, 48,5};

        System.out.println(get2ndLargest(arr));
    }
}


