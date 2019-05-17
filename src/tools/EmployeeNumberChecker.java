package tools;

/*
 * 员工号合法性检查
 *
 * */

public class EmployeeNumberChecker implements BaseFilter_Albert_Frank_Check {

    public boolean doCheck(String sin) {

        if (!numAndWordTest.numAndWordTest(sin)) {
            System.out.println(getClass().getName() + "  error");
            System.out.println(sin + "    账户名非法，请重新输入");
            return false;
        }
        System.out.println(sin + "    账户名合法");
        return true;
    }

}
