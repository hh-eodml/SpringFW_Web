package web.spring.skintalk.util;

public class PageMaker {
	private PageCriteria criteria;
	private int totalCount; 		// 전체 개시글 개수
	private int numsOfPageLinks; 	// 페이지 번호 링크의 개수 
	private int startPageNo; 		// 시작 페이지 링크 번호
	private int endPageNo;			// 끝 페이지 링크 번호
	private boolean hasPrev; 		// 화면에 보이는 시작 페이지 번호보다 작은 숫자의 페이지가 있는
	private boolean hasNext; 		// 화면에 보이는 끝 페이지 번호보다 큰 숫자의 페이지가 있는
	
	public PageMaker() {
		this.numsOfPageLinks = 5;
	}
	
	public PageCriteria getCriteria() {
		return criteria;
	}
	
	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}
	
	public int getStartPageNo() {
		return startPageNo;
	}
	
	public int getEndPageNo() {
		return endPageNo;
	}
	
	public boolean isHasPrev() {
		return hasPrev;
	}
	
	public boolean isHasNext() {
		return hasNext;
	}
	
	public void setPageData() {
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
		
		if (temp > totalLinkNo) {
			endPageNo = totalLinkNo;
		} else {
			endPageNo = temp;
		}
		
		startPageNo = ((endPageNo - 1) / numsOfPageLinks) * numsOfPageLinks + 1;
		
		if (startPageNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
		}
		
		if (endPageNo * criteria.getNumsPerPage() >= totalCount) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		
	}

	@Override
	public String toString() {
		return "PageMaker [criteria=" + criteria + ", totalCount=" + totalCount + ", numsOfPageLinks=" + numsOfPageLinks
				+ ", startPageNo=" + startPageNo + ", endPageNo=" + endPageNo + ", hasPrev=" + hasPrev + ", hasNext="
				+ hasNext + "]";
	}
	
	
}
