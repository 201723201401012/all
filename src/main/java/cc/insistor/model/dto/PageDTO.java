package cc.insistor.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * f
 * @author cc
 */
@ApiModel("分页查找")
public class PageDTO {
    @ApiModelProperty("页码，从0开始")
    @Min(value = 0, message = "页码不能小于0")
    private Integer offset;

    @ApiModelProperty("分页大小，不能小于1或大于1000，默认10")
    @Min(value = 1, message = "分页大小不能小于1")
    @Max(value = 1000, message = "分页大小不能大于1000")
    private Integer limit;

    public PageDTO() {
        offset = 0;
        limit = 3;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
