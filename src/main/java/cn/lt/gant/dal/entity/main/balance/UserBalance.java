package cn.lt.gant.dal.entity.main.balance;

import cn.lt.gant.dal.entity.base.BaseEntity;
import javax.persistence.*;

@Table(name = "t_user_balance")
public class UserBalance extends BaseEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "count")
    private Long count;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return count
     */
    public Long getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Long count) {
        this.count = count;
    }
}