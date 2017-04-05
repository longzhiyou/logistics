package lzy.module.auth.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * User: longzhiyou
 * Date: 2016/11/18
 * Time: 16:18
 */
@Entity
@Table(name = "t_member_login", schema = "epension_community", catalog = "")
public class TMemberLoginEntity {
    private String username;
    private String password;
    private Integer enabled;
    private int memberId;
    private String groupId;
    private String instituteId;
    private Byte deleteFlg;
    private String register;
    private Timestamp insertTime;
    private String modifier;
    private Timestamp updateTime;
    private Integer version;

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled")
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "member_id")
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "institute_id")
    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    @Basic
    @Column(name = "delete_flg")
    public Byte getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(Byte deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    @Basic
    @Column(name = "register")
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Basic
    @Column(name = "insert_time")
    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    @Basic
    @Column(name = "modifier")
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMemberLoginEntity that = (TMemberLoginEntity) o;

        if (memberId != that.memberId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (instituteId != null ? !instituteId.equals(that.instituteId) : that.instituteId != null) return false;
        if (deleteFlg != null ? !deleteFlg.equals(that.deleteFlg) : that.deleteFlg != null) return false;
        if (register != null ? !register.equals(that.register) : that.register != null) return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        if (modifier != null ? !modifier.equals(that.modifier) : that.modifier != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (instituteId != null ? instituteId.hashCode() : 0);
        result = 31 * result + (deleteFlg != null ? deleteFlg.hashCode() : 0);
        result = 31 * result + (register != null ? register.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (modifier != null ? modifier.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
