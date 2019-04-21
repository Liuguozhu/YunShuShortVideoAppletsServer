package top.itning.yunshuvideo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Rest 返回消息
 *
 * @author itning
 */
@ApiModel(description = "Rest 返回消息")
public class RestModel<T> implements Serializable {
    @ApiModelProperty(required = true, value = "状态码")
    private int code;
    @ApiModelProperty(required = true, value = "消息")
    private String msg;
    @ApiModelProperty(required = true, value = "数据")
    private T data;

    public RestModel(HttpStatus status, String msg) {
        this(status, msg, null);
    }

    public RestModel(HttpStatus status, String msg, T data) {
        this(status.value(), msg, data);
    }

    public RestModel(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestModel(T data) {
        this(HttpStatus.OK, "查询成功", data);
    }

    public RestModel(String msg, T data) {
        this(HttpStatus.OK, msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
