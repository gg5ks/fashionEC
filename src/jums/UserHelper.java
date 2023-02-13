package jums;

import java.util.ArrayList;

public class UserHelper {
	//トップへのリンクを定数として設定
    private final String topURL = "User_TopPage.jsp";
    private final String logoutURL = "User_Logout";
    private final String myPageURL = "MyPage";
    private final String top = "Login";

    public static UserHelper getInstance(){
        return new UserHelper();
    }

    //リンク
    //トップページ
    public String top(){
        return "<a href=\""+topURL+"\">Logo</a>";
    }
    //ログアウトボタン
    public String logout() {
    	return "<form action=\""+logoutURL+"\"><input type=submit value=\"ログアウト\"></form>";
    }
    //マイページボタン
    public String mypage() {
    	return "<form action=\""+myPageURL+"\"><input type=submit value=\"マイページ\"></form>";
    }

    public String TopA(){
        return "<a href=\""+top+"\">トップページへ戻る</a>";
    }

    public String TopF() {
    	return "<form action=\""+top+"\" method=\"get\"><input type=submit value=\"トップ\"></form>";
    }

    public String exValueForFlagName(int i){
        switch(i){
        case 1:
            return "未削除";
        case 2:
            return "削除済み";
        case 3:
            return "不問";
    }
    return "";
    }

    public String exDBForVal(boolean flag) {
    	if(flag) {
    		return "削除済み";
    	}else {
    		return "";
    	}
    }

    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("year")){
                    output +="年";
                }
                if(val.equals("month")){
                    output +="月";
                }
                if(val.equals("day")){
                    output +="日";
                }
                if(val.equals("mail")){
                    output +="メールアドレス";
                }
                if(val.equals("pass")){
                    output +="パスワード";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
}
