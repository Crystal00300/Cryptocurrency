package com.Group1.CoinShell.model.Yiwen;
//package com.Group1.CoinShell.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity 
//@Table(name="Members")
//public class Members {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "Id", columnDefinition ="int")
//    private Integer memId;
//    
//	@Column(name = "CustomizedUserName", columnDefinition ="nvarchar(50)")
//    private String customizedUserName;
//    
//	@Column(name = "CustomizedUserAvatar", columnDefinition ="varbinary(MAX)")
//    private String customizedUserAvatar;
//    
//	@Column(name = "E_Mail", columnDefinition ="nvarchar(100)")
//    private String eMail;
//    
//	@Column(name = "Password", columnDefinition ="nvarchar(50)")
//    private String password;
//    
//	@Column(name = "MyShell", columnDefinition ="money")
//    private Integer myShell;
//    
//	@Column(name = "IsPremium", columnDefinition ="bit")
//    private Boolean isPremium;
//    
//	@Column(name = "JoinTime", columnDefinition ="date")
//    private String joinTime;
//    
//	@Column(name = "Member01", columnDefinition ="int")
//	private Integer member01;
//	
//	@Column(name = "Member02", columnDefinition ="int")
//	private Integer member02;
//	
//	@Column(name = "Member03", columnDefinition ="int")
//	private Integer member03;
//
//	public Members() {
//	}
//
//	public Members(Integer memId, String customizedUserName, String customizedUserAvatar, String eMail, String password,
//			Integer myShell, Boolean isPremium, String joinTime, Integer member01, Integer member02, Integer member03) {
//		super();
//		this.memId = memId;
//		this.customizedUserName = customizedUserName;
//		this.customizedUserAvatar = customizedUserAvatar;
//		this.eMail = eMail;
//		this.password = password;
//		this.myShell = myShell;
//		this.isPremium = isPremium;
//		this.joinTime = joinTime;
//		this.member01 = member01;
//		this.member02 = member02;
//		this.member03 = member03;
//	}
//
//	public Integer getMemId() {
//		return memId;
//	}
//
//	public void setMemId(Integer memId) {
//		this.memId = memId;
//	}
//
//	public String getCustomizedUserName() {
//		return customizedUserName;
//	}
//
//	public void setCustomizedUserName(String customizedUserName) {
//		this.customizedUserName = customizedUserName;
//	}
//
//	public String getCustomizedUserAvatar() {
//		return customizedUserAvatar;
//	}
//
//	public void setCustomizedUserAvatar(String customizedUserAvatar) {
//		this.customizedUserAvatar = customizedUserAvatar;
//	}
//
//	public String geteMail() {
//		return eMail;
//	}
//
//	public void seteMail(String eMail) {
//		this.eMail = eMail;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Integer getMyShell() {
//		return myShell;
//	}
//
//	public void setMyShell(Integer myShell) {
//		this.myShell = myShell;
//	}
//
//	public Boolean getIsPremium() {
//		return isPremium;
//	}
//
//	public void setIsPremium(Boolean isPremium) {
//		this.isPremium = isPremium;
//	}
//
//	public String getJoinTime() {
//		return joinTime;
//	}
//
//	public void setJoinTime(String joinTime) {
//		this.joinTime = joinTime;
//	}
//
//	public Integer getMember01() {
//		return member01;
//	}
//
//	public void setMember01(Integer member01) {
//		this.member01 = member01;
//	}
//
//	public Integer getMember02() {
//		return member02;
//	}
//
//	public void setMember02(Integer member02) {
//		this.member02 = member02;
//	}
//
//	public Integer getMember03() {
//		return member03;
//	}
//
//	public void setMember03(Integer member03) {
//		this.member03 = member03;
//	}
//
//}
