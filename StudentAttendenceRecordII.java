/**
 * Created by fang on 4/24/17.
 */
public class StudentAttendanceRecord {
    public int res;
    public int checkRecord(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 3;
        }
        char[] record = new char[n+1];
        int canAbsent = 1;
        int absent = 0;
        res = 0;
        record[0]='p';
        help(record,canAbsent, absent,1,n);
        int pow = 1;
        for(int i=0;i<9;i++){
            pow = pow*10;
        }
        return res%(pow+7);
    }

    private void help(char[]record, int canAbsent,int absent, int start, int end){
        if(start>end && absent<=canAbsent){
            res++;
            System.out.println();
            return;
        }
        if(absent >canAbsent ){
            return ;
        }
        int i = start;
        if(record[i-1] =='p'){
            record[i]='p';
            help(record,canAbsent,absent,i+1,end);
            record[i]='l';
            help(record,canAbsent,absent,i+1,end);
            record[i]='a';
            absent+=1;
            help(record,canAbsent,absent,i+1,end);

        }else if(record[i-1] == 'l'){

            //absent--;
            record[i]='p';
            help(record,canAbsent,absent,i+1,end);
            if(i-2>=0 && record[i-2]!='l') {
                record[i] = 'l';
                help(record, canAbsent, absent, i + 1, end);
            }
            record[i]='a';
            absent+=1;
            help(record,canAbsent,absent,i+1,end);
        }else{
            record[i]='p';
            help(record,canAbsent,absent,i+1,end);
            record[i]='l';
            help(record,canAbsent,absent,i+1,end);
        }

    }
    public static void main(String[] args){
        int n =3 ;
        StudentAttendanceRecord solution = new StudentAttendanceRecord();
        int res =solution.checkRecord(n);
        System.out.println(res);
    }

}
