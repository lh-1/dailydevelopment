package info.mjy.boottest.test;

import lombok.Data;

@Data
public class ResponseVO {

    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";

    private String code;
    private String message;

    public ResponseVO() {
    }

    public ResponseVO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseVO success(String result) {
        ResponseVO responseVO = new ResponseVO(SUCCESS, result);
        return responseVO;
    }

}
