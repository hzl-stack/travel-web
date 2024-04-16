package org.example.springdemo.travelapply.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.springdemo.travelapply.result.ResultCodeEnum;


@EqualsAndHashCode(callSuper = true)
@Data
public class TAException extends RuntimeException {

    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     *
     * @param message 错误信息
     * @param code    状态码
     */
    public TAException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     *
     * @param resultCodeEnum 枚举对象
     */
    public TAException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "RPException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
