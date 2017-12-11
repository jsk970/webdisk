package webdisk.bean;

public class Catelog {
	private int fid;
	private String fTel;
	private String fCatelog;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getfTel() {
		return fTel;
	}
	public void setfTel(String fTel) {
		this.fTel = fTel;
	}
	public String getfCatelog() {
		return fCatelog;
	}
	public void setfCatelog(String fCatelog) {
		this.fCatelog = fCatelog;
	}
	@Override
	public String toString() {
		return "Catelog [fid=" + fid + ", fTel=" + fTel + ", fCatelog=" + fCatelog + "]";
	} 
	

}
