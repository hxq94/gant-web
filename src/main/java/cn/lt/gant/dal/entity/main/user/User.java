package cn.lt.gant.dal.entity.main.user;

import cn.lt.gant.dal.entity.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_user")
public class User extends BaseEntity {
    /**
     * 主键id
     */
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 账号
     */
    @Column(name = "ACCOUNT")
    private String account;

    /**
     * 警号
     */
    @Column(name = "POLICE_NUM")
    private String policeNum;

    /**
     * 电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 身份证号
     */
    @Column(name = "ID_CARD_NUM")
    private String idCardNum;

    /**
     * 用户姓名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 用户头像
     */
    @Column(name = "AVATAR")
    private String avatar;

    /**
     * 个性签名
     */
    @Column(name = "SIGNATURE")
    private String signature;

    /**
     * 用户权限类型
     */
    @Column(name = "AUTH_TYPE")
    private Long authType;

    /**
     * 所属部门ID
     */
    @Column(name = "DEPT_ID")
    private Long deptId;

    /**
     * 部门Code
     */
    @Column(name = "DEPT_CODE")
    private String deptCode;

    /**
     * 登录方式（24001：帐号，24002：数字证书，24003：手机验证码，24004：小程序，24005：App）
     */
    @Column(name = "LOGIN_WAY")
    private String loginWay;

    /**
     * 职务、头衔
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 登录密码
     */
    @Column(name = "PWD")
    private String pwd;

    /**
     * 设备平台
     */
    @Column(name = "DEVICE_TYPE")
    private Long deviceType;

    /**
     * 设备push token
     */
    @Column(name = "PUSH_TOKEN")
    private String pushToken;

    /**
     * 设备名称(user agent)
     */
    @Column(name = "DEVICE_NAME")
    private String deviceName;

    /**
     * MAC码
     */
    @Column(name = "MAC")
    private String mac;

    /**
     * 注册时IP
     */
    @Column(name = "REG_IP")
    private String regIp;

    /**
     * 最后登录IP
     */
    @Column(name = "LAST_IP")
    private String lastIp;

    /**
     * 登录次数
     */
    @Column(name = "LOGIN_SUM")
    private String loginSum;

    /**
     * 所属分局ID
     */
    @Column(name = "BRANCH_ID")
    private Long branchId;

    /**
     * 短号
     */
    @Column(name = "SHORT_PHONE")
    private String shortPhone;

    /**
     * 性别
     */
    @Column(name = "SEX")
    private Long sex;

    /**
     * 员工住址
     */
    @Column(name = "USER_ADDRESS")
    private String userAddress;

    /**
     * 员工生日
     */
    @Column(name = "USER_BIRTH")
    private String userBirth;

    /**
     * 紧急联系人
     */
    @Column(name = "URGENT_PERSON")
    private String urgentPerson;

    /**
     * 紧急联系人号码
     */
    @Column(name = "URGENT_PHONE_NUM")
    private String urgentPhoneNum;

    /**
     * 员工编号
     */
    @Column(name = "USER_NUM")
    private String userNum;

    /**
     * qq
     */
    @Column(name = "QQ")
    private String qq;

    /**
     * 学历
     */
    @Column(name = "EDUCATION")
    private Long education;

    /**
     * 岗位
     */
    @Column(name = "POST")
    private String post;

    /**
     * 岗位级别
     */
    @Column(name = "POST_LEVEL")
    private Long postLevel;

    /**
     * 籍贯
     */
    @Column(name = "NATIVE_PLACE")
    private String nativePlace;

    /**
     * 用户考勤ID
     */
    @Column(name = "ATTLOGS_ID")
    private Integer attlogsId;

    @Column(name = "USER_NICKNAME")
    private String userNickname;

    /**
     * 时段id
     */
    @Column(name = "SD_ID")
    private Long sdId;

    @Column(name = "DEL_FLAG")
    private Byte delFlag;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "CREATE_UID")
    private Long createUid;

    @Column(name = "MODIFIED_TIME")
    private Date modifiedTime;

    @Column(name = "MODIFIED_UID")
    private Long modifiedUid;

    /**
     * 角色
     */
    @Column(name = "ROLES")
    private String roles;

    /**
     * 权限
     */
    @Column(name = "PERMISSIONS")
    private String permissions;

    /**
     * 获取主键id
     *
     * @return USER_ID - 主键id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置主键id
     *
     * @param userId 主键id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取账号
     *
     * @return ACCOUNT - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取警号
     *
     * @return POLICE_NUM - 警号
     */
    public String getPoliceNum() {
        return policeNum;
    }

    /**
     * 设置警号
     *
     * @param policeNum 警号
     */
    public void setPoliceNum(String policeNum) {
        this.policeNum = policeNum;
    }

    /**
     * 获取电话
     *
     * @return PHONE - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取身份证号
     *
     * @return ID_CARD_NUM - 身份证号
     */
    public String getIdCardNum() {
        return idCardNum;
    }

    /**
     * 设置身份证号
     *
     * @param idCardNum 身份证号
     */
    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    /**
     * 获取用户姓名
     *
     * @return USER_NAME - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户头像
     *
     * @return AVATAR - 用户头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     *
     * @param avatar 用户头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取个性签名
     *
     * @return SIGNATURE - 个性签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个性签名
     *
     * @param signature 个性签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取用户权限类型
     *
     * @return AUTH_TYPE - 用户权限类型
     */
    public Long getAuthType() {
        return authType;
    }

    /**
     * 设置用户权限类型
     *
     * @param authType 用户权限类型
     */
    public void setAuthType(Long authType) {
        this.authType = authType;
    }

    /**
     * 获取所属部门ID
     *
     * @return DEPT_ID - 所属部门ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置所属部门ID
     *
     * @param deptId 所属部门ID
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取部门Code
     *
     * @return DEPT_CODE - 部门Code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门Code
     *
     * @param deptCode 部门Code
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取登录方式（24001：帐号，24002：数字证书，24003：手机验证码，24004：小程序，24005：App）
     *
     * @return LOGIN_WAY - 登录方式（24001：帐号，24002：数字证书，24003：手机验证码，24004：小程序，24005：App）
     */
    public String getLoginWay() {
        return loginWay;
    }

    /**
     * 设置登录方式（24001：帐号，24002：数字证书，24003：手机验证码，24004：小程序，24005：App）
     *
     * @param loginWay 登录方式（24001：帐号，24002：数字证书，24003：手机验证码，24004：小程序，24005：App）
     */
    public void setLoginWay(String loginWay) {
        this.loginWay = loginWay;
    }

    /**
     * 获取职务、头衔
     *
     * @return TITLE - 职务、头衔
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置职务、头衔
     *
     * @param title 职务、头衔
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取登录密码
     *
     * @return PWD - 登录密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置登录密码
     *
     * @param pwd 登录密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取设备平台
     *
     * @return DEVICE_TYPE - 设备平台
     */
    public Long getDeviceType() {
        return deviceType;
    }

    /**
     * 设置设备平台
     *
     * @param deviceType 设备平台
     */
    public void setDeviceType(Long deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * 获取设备push token
     *
     * @return PUSH_TOKEN - 设备push token
     */
    public String getPushToken() {
        return pushToken;
    }

    /**
     * 设置设备push token
     *
     * @param pushToken 设备push token
     */
    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    /**
     * 获取设备名称(user agent)
     *
     * @return DEVICE_NAME - 设备名称(user agent)
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 设置设备名称(user agent)
     *
     * @param deviceName 设备名称(user agent)
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * 获取MAC码
     *
     * @return MAC - MAC码
     */
    public String getMac() {
        return mac;
    }

    /**
     * 设置MAC码
     *
     * @param mac MAC码
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * 获取注册时IP
     *
     * @return REG_IP - 注册时IP
     */
    public String getRegIp() {
        return regIp;
    }

    /**
     * 设置注册时IP
     *
     * @param regIp 注册时IP
     */
    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    /**
     * 获取最后登录IP
     *
     * @return LAST_IP - 最后登录IP
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 设置最后登录IP
     *
     * @param lastIp 最后登录IP
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * 获取登录次数
     *
     * @return LOGIN_SUM - 登录次数
     */
    public String getLoginSum() {
        return loginSum;
    }

    /**
     * 设置登录次数
     *
     * @param loginSum 登录次数
     */
    public void setLoginSum(String loginSum) {
        this.loginSum = loginSum;
    }

    /**
     * 获取所属分局ID
     *
     * @return BRANCH_ID - 所属分局ID
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置所属分局ID
     *
     * @param branchId 所属分局ID
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * 获取短号
     *
     * @return SHORT_PHONE - 短号
     */
    public String getShortPhone() {
        return shortPhone;
    }

    /**
     * 设置短号
     *
     * @param shortPhone 短号
     */
    public void setShortPhone(String shortPhone) {
        this.shortPhone = shortPhone;
    }

    /**
     * 获取性别
     *
     * @return SEX - 性别
     */
    public Long getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Long sex) {
        this.sex = sex;
    }

    /**
     * 获取员工住址
     *
     * @return USER_ADDRESS - 员工住址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置员工住址
     *
     * @param userAddress 员工住址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 获取员工生日
     *
     * @return USER_BIRTH - 员工生日
     */
    public String getUserBirth() {
        return userBirth;
    }

    /**
     * 设置员工生日
     *
     * @param userBirth 员工生日
     */
    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    /**
     * 获取紧急联系人
     *
     * @return URGENT_PERSON - 紧急联系人
     */
    public String getUrgentPerson() {
        return urgentPerson;
    }

    /**
     * 设置紧急联系人
     *
     * @param urgentPerson 紧急联系人
     */
    public void setUrgentPerson(String urgentPerson) {
        this.urgentPerson = urgentPerson;
    }

    /**
     * 获取紧急联系人号码
     *
     * @return URGENT_PHONE_NUM - 紧急联系人号码
     */
    public String getUrgentPhoneNum() {
        return urgentPhoneNum;
    }

    /**
     * 设置紧急联系人号码
     *
     * @param urgentPhoneNum 紧急联系人号码
     */
    public void setUrgentPhoneNum(String urgentPhoneNum) {
        this.urgentPhoneNum = urgentPhoneNum;
    }

    /**
     * 获取员工编号
     *
     * @return USER_NUM - 员工编号
     */
    public String getUserNum() {
        return userNum;
    }

    /**
     * 设置员工编号
     *
     * @param userNum 员工编号
     */
    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    /**
     * 获取qq
     *
     * @return QQ - qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq
     *
     * @param qq qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取学历
     *
     * @return EDUCATION - 学历
     */
    public Long getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(Long education) {
        this.education = education;
    }

    /**
     * 获取岗位
     *
     * @return POST - 岗位
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置岗位
     *
     * @param post 岗位
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取岗位级别
     *
     * @return POST_LEVEL - 岗位级别
     */
    public Long getPostLevel() {
        return postLevel;
    }

    /**
     * 设置岗位级别
     *
     * @param postLevel 岗位级别
     */
    public void setPostLevel(Long postLevel) {
        this.postLevel = postLevel;
    }

    /**
     * 获取籍贯
     *
     * @return NATIVE_PLACE - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 获取用户考勤ID
     *
     * @return ATTLOGS_ID - 用户考勤ID
     */
    public Integer getAttlogsId() {
        return attlogsId;
    }

    /**
     * 设置用户考勤ID
     *
     * @param attlogsId 用户考勤ID
     */
    public void setAttlogsId(Integer attlogsId) {
        this.attlogsId = attlogsId;
    }

    /**
     * @return USER_NICKNAME
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * @param userNickname
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * 获取时段id
     *
     * @return SD_ID - 时段id
     */
    public Long getSdId() {
        return sdId;
    }

    /**
     * 设置时段id
     *
     * @param sdId 时段id
     */
    public void setSdId(Long sdId) {
        this.sdId = sdId;
    }

    /**
     * @return DEL_FLAG
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return CREATE_UID
     */
    public Long getCreateUid() {
        return createUid;
    }

    /**
     * @param createUid
     */
    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    /**
     * @return MODIFIED_TIME
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * @return MODIFIED_UID
     */
    public Long getModifiedUid() {
        return modifiedUid;
    }

    /**
     * @param modifiedUid
     */
    public void setModifiedUid(Long modifiedUid) {
        this.modifiedUid = modifiedUid;
    }

    /**
     * 获取角色
     *
     * @return ROLES - 角色
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置角色
     *
     * @param roles 角色
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * 获取权限
     *
     * @return PERMISSIONS - 权限
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * 设置权限
     *
     * @param permissions 权限
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}