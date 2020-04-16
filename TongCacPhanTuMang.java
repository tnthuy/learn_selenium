
public class TongCacPhanTuMang {
	public static void main(String []args){
        //Khai bao mang
        double[] Mang={4.5,3,6,4.6,6,6};
        double tong=0;
        for (int i=0;i<(Mang.length);i++){
            tong+=Mang[i];
        }
        System.out.println("Tong cac gia tri cua mang "+tong);
     }

}
