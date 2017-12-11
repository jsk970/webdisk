package webdisk.bean;

public class Friend {
	private int fid;
	private String fMytel;
	private String fFriendTel;
	private String fUser;
	private String fMemo;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getfMytel() {
		return fMytel;
	}
	public void setfMytel(String fMytel) {
		this.fMytel = fMytel;
	}
	public String getfFriendTel() {
		return fFriendTel;
	}
	public void setfFriendTel(String fFriendTel) {
		this.fFriendTel = fFriendTel;
	}
	public String getfUser() {
		return fUser;
	}
	public void setfUser(String fUser) {
		this.fUser = fUser;
	}
	public String getfMemo() {
		return fMemo;
	}
	public void setfMemo(String fMemo) {
		this.fMemo = fMemo;
	}
	@Override
	public String toString() {
		return "Friend [fid=" + fid + ", fMytel=" + fMytel + ", fFriendTel=" + fFriendTel + ", fUser=" + fUser
				+ ", fMemo=" + fMemo + "]";
	}
	
}
