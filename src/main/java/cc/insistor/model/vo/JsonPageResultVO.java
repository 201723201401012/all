package cc.insistor.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 分页返回信息
 * @author cc
 */
@ApiModel("分页数据信息")
public class JsonPageResultVO {
    /**
     * 数据总数
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("数据总数")
    private Long total;

    /**
     * 总页数
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("总页数")
    private Integer totalPage;

    /**
     * 数据集合
     */
    @ApiModelProperty("数据集合")
    private List list;

    public JsonPageResultVO(Long total, Integer totalPage, List list) {
        this.total = total;
        this.totalPage = totalPage;
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "JsonPageResultVO{" +
                "total=" + total +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
