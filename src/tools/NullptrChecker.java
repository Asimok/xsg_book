package tools;

/*
 * 空指针异常检测
 *
 * */
public class NullptrChecker implements BaseFilter_Albert_Frank_Check {

    @Override
    public boolean doCheck(String sin) {
        if (sin == null) {
            System.out.println(getClass().getName() + " error");
            return false;
        }
        return true;
    }

}
