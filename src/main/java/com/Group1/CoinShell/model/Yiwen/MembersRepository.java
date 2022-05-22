package com.Group1.CoinShell.model.Yiwen;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
	
	/**
	 * 會員登入
	 * @param eMail
	 * @param password
	 * @return
	 */
	@Query(value="select m from Members m where m.eMail = ?1 and m.password = ?2")
	public Members findByEMailAndPassword(String eMail, String password);
	
//	@Query(value="select m from Members m where m.Id =?1")
//	public Members findById(String memId);
//	
//	// 沒有Service層，直接用controller呼叫Dao的話，要加@Transactional
//	// delete 跟 update 都要寫 modifying
//
//	/**
//	 * 更新會員頭像、用戶自訂名稱
//	 * @param memId
//	 * @param Members
//	 * @return
//	 */
//	@Transactional
//	@Modifying
//	@Query(value="update Members set CustomizedUserAvatar = ?1, "
//			+ "CustomizedUserName = ?2, where Id = memId", nativeQuery = true)
//	public Members updateUSettingById(Integer memId, Members Members);
//	
//	/**
//	 * 變更會員密碼
//	 * @param memId
//	 * @param Members
//	 * @return
//	 */
//	@Transactional
//	@Modifying
//	@Query(value="update Members set Password = ?1, where Id = memId", nativeQuery = true)
//	public Members updatePasswordById(Integer memId, Members Members);
//	
//	
//	
/////////////////////以下無關/////////////////////
//	
//	@Query("from Members where CustomizedUserName = :CustomizedUserName")
//	public List<Members> findByName(@Param(value = "customizedUserName") String customizedUserName);
//
//	@Query(value="select * from Members where customizedUserName = :customizedUserName",nativeQuery = true)
//	public List<Members> findByName2(@Param(value = "customizedUserName") String customizedUserName);
//	
//	@Transactional
//	@Modifying
//	@Query(value = "delete from members where Id =?1", nativeQuery = true)
//	public void delByMemId(Integer MemId);
//	
//  public List<Members> findByisPremiumTrue(Boolean isPremium);
}
