package com.neurogine.assesment.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Chinthana
 */
@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date insertTs;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTs;

    @PrePersist
    protected void onCreate() {
        insertTs = new Date();
        modifiedTs = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedTs = new Date();
    }
    
    /**
     * The inserted timestamp.
     *
     * @return The inserted timestamp.
     */
    public Date getInsertTs() {
        return (insertTs == null) ? null : new Date(insertTs.getTime());
    }
    
    /**
     * Set the inserted timestamp.
     *
     * @param insertTs The inserted timestamp.
     */
    public void setInsertTs(final Date insertTs) {
        if (insertTs != null)
            this.insertTs = new Date(insertTs.getTime());
    }

    /**
     * The modified timestamp.
     *
     * @return The modified timestamp.
     */
    public Date getModifiedTs() {
        return (modifiedTs == null) ? null : new Date(modifiedTs.getTime());
    }

    /**
     * Set the modified timestamp.
     *
     * @param modifiedTs The modified timestamp.
     */
    public void setModifiedTs(final Date modifiedTs) {
        if (modifiedTs != null)
            this.modifiedTs = new Date(modifiedTs.getTime());
    }

}
