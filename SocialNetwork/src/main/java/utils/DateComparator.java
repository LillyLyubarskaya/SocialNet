package utils;

import model.Message;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Lilly_94 on 29.11.2015.
 */
public class DateComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Date d1 = ((Message) o1).getDate();
        Date d2 = ((Message) o2).getDate();
        if(d1.after(d2)){
            return 1;
        }else if(d1.before(d2)){
            return -1;
        }else{
            return 0;
        }
    }
}
