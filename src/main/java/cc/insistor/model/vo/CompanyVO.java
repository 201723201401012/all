package cc.insistor.model.vo;

import cc.insistor.model.po.BaseEntity;

/**
 * fd
 * @author cc
 */
public class CompanyVO extends BaseEntity {

    private String id;
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
        return "CompanyVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTimestamp=" + createTimestamp +
                ", lastChangeTimestamp=" + lastChangeTimestamp +
                '}';
    }
}
