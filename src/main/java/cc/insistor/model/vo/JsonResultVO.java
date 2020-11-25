package cc.insistor.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author cc
 * 异常信息
 *
 * 在项目中 当字段实体类为Long类型时 如果Long值超过前端js显示的长度范围时会导致前端回显错误
 * 此时我们想到的解决方案是将Long值返回给前端时转为String，
 * 但是我们又不想变更字段的类型，当然我们也不想额外添加新的字段。
 * 这个时候我们可以用@JsonSerialize，在Json序列化的时候把Long自动转为String，
 * 但是这里有个小坑，被转换的字段必须是包装类类型，否则会转换失败。
 *
 * JsonSerialize(using = ToStringSerializer.class)
 * private Long parentId;    //转化成功
 * JsonSerialize(using = ToStringSerializer.class)
 * private long parentId;    //转化失败
 */
@ApiModel("返回接口信息")
public class JsonResultVO {

    @ApiModelProperty("返回状态码200成功")
    private String code;

    @ApiModelProperty("返回描述信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private Object data;


    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("时间戳")
    private Long ts;

    @ApiModelProperty("成功标志：true, false")
    private Boolean success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "JsonResultVO{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", ts=" + ts +
                ", success=" + success +
                '}';
    }
}
