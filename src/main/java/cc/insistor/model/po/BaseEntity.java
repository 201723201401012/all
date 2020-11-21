package cc.insistor.model.po;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author cc
 *
 *
 * MappedSuperclass：jpa里的一个注解
 *      注解表示在父类上面的，用来标识父类。
 *      基于代码复用和模型分离的思想，在项目开发中使用JPA的@MappedSuperclass注解将实体类的多个属性分别封装到不同的非实体类中。
 *          例如，数据库表中都需要id来表示编号，id是这些映射实体类的通用的属性，交给jpa统一生成主键id编号，那么使用一个父类来封装这些通用属性，并用@MappedSuperclas标识。
 *      注意:
 *      1.标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中。
 *      2.标注为@MappedSuperclass的类不能再标注@Entity或@Table注解，也无需实现序列化接口。
 *
 *
 *
 * Temporal
 *      1、如果在某类中有Date类型的属性，数据库中存储可能是'yyyy-MM-dd hh:MM:ss'要在查询时获得年月日，
 *          在该属性上标注@Temporal(TemporalType.DATE) 会得到形如'yyyy-MM-dd' 格式的日期。
 *          DATE ：等于java.sql.Date
 *
 *
 *      日期：
 *          Temporal(TemporalType.DATE)
 *          @Column(name = "applyDate", nullable = false, length = 12)
 *              public Date getApplyDate() {
 *              return applyDate;
 *          }
 *
 *          在页面端取值：2016--09--28
 *
 *       2、如果在某类中有Date类型的属性，数据库中存储可能是'yyyy-MM-dd hh:MM:ss'要获得时分秒，
 *          在该属性上标注 @Temporal(TemporalType.TIME) 会得到形如'HH:MM:SS' 格式的日期。
 *          TIME ：等于java.sql.Time
 *
 *
 *          时间：
 *          Temporal(TemporalType.TIME)
 *              在页面端取值：15:50:30
 *
 *       3、如果在某类中有Date类型的属性，数据库中存储可能是'yyyy-MM-dd hh:MM:ss'
 *          要获得'是'yyyy-MM-dd hh:MM:ss'，在该属性上标注 @Temporal(TemporalType.TIMESTAMP)
 *              会得到形如'HH:MM:SS' 格式的日期
 *
 *      TIMESTAMP ：等于java.sql.Timestamp
 *      日期和时间(默认)：
 *      @Temporal(TemporalType.TIMESTAMP)
 *      在页面端取值：2016-09-28 15:52:32:000
 *      在jsp里控制不显示毫秒：
 *   <td align="center">&nbsp;<fmt:formatDate value="${list[0].createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
 */
@MappedSuperclass
public class BaseEntity {
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    protected Date createTimestamp;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    protected Date lastChangeTimestamp;

    public Date getCreateTimestamp() {
        return createTimestamp != null ? (Date) createTimestamp.clone() : null;
    }

    public void setCreateTimestamp(Date createTime) {
        this.createTimestamp = createTime != null ? (Date) createTime.clone() : null;
    }

    public Date getLastChangeTimestamp() {
        return lastChangeTimestamp != null ? (Date) lastChangeTimestamp.clone() : null;
    }

    public void setLastChangeTimestamp(Date modifiedTime) {
        this.lastChangeTimestamp = modifiedTime != null ? (Date) modifiedTime.clone() : null;
    }

}
