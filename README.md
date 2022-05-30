# Hoxton's Pending

1. 後台設計，目前已經架好商城的CRUD網頁草圖，待竣工
2. 把首頁圖表的X軸隱藏掉
3. 貨幣資訊頁面的24h、7d、30d要記得完成
4. 貨幣資訊頁面排版要排好

## bug to fix
1. 了解如何上傳檔案
2. 了解action路徑與controller之對應關係



# Yiwen's pending
1. 後臺介面(後台人員能登入): `!Important` 登入後能夠增刪查改會員資料、新聞介面、討論區討論串
2. 控制帳號密碼的格式限制(E-mail不能重複 `!Important` ( modify controller Post/SignUp method )
    ( modify controller Post/SignUp method )
3. log In表單，希望可以實現 
    +  Forget Password (Modal + Javax.mail)
    +  每日 e-mail 電子郵件 (Daily post) `Optional`
    +  Remember Me checkbox (跟JSESSIONID時間設定相關嗎?) `Optional`
4. Account Settings 功能 `!Important`
    +  Update userAvatar, update customized UserName
    +  Modal * 2
4. 登入後的下拉選單按鈕改成頭像
5. About coinshell team 頁面優化

# Bear's pending
1. 後台設計，Article的CRUD功能引入
2. 進頁面時，可瀏覽文章及評論、留言
   若想留下評論，須click評論、留言按鈕
   驗證是否登入
   若無，則彈出登入視窗，若不登入，則無法留言
   若已登入，則顯示評論、留言區塊，同時載入userID資訊等
   若userID==authorID，則可編輯文章
3. Article, Comment, Reply新增使用者的相關input(姓名、圖片、ID)

