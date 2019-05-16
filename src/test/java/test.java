import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
        Date currentTime = new Date();
        String format1 = format.format(currentTime);
        System.out.println(format1);
    }
}
