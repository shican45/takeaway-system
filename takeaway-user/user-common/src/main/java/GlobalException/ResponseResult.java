package GlobalException;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 6054052582421291408L;

    private int code;
    private String message;
    private Object data;

    public ResponseResult(){}

    public ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(ResponseCodeEnum responseCodeEnum) {
        this.code = responseCodeEnum.getStatus();
        this.message = responseCodeEnum.getMessage();
    }

    public ResponseResult(ResponseCodeEnum responseCodeEnum,  Object data) {
        this.code = responseCodeEnum.getStatus();
        this.message = responseCodeEnum.getMessage();
        this.data = data;
    }

    public ResponseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseResult setCode(int code) {
        this.code = code;
        return this;
    }

}