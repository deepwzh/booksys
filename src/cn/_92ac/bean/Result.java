package cn._92ac.bean;

/**
 * @program: BookSystem1
 * @description:
 * @author: deepwzh
 * @create: 2019-07-11 13:30
 **/
public class Result {
    public Result(int code) {
        this.code = code;
        this.result = "";
    }
    public Result(int code, String result) {
        this.code = code;
        this.result = result;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    private String result;
    private int code;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
