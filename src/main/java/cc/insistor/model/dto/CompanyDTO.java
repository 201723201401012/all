package cc.insistor.model.dto;


import cc.insistor.model.po.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * @author cc
 */
@ApiModel("公司")
public class CompanyDTO extends BaseEntity {
    @ApiModelProperty("id")
    private String id;


    @ApiModelProperty("公司名称")
    @Length(max = 5)
    @NotNull
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTimestamp=" + createTimestamp +
                ", lastChangeTimestamp=" + lastChangeTimestamp +
                '}';
    }
}
