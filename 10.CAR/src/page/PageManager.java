package page;

public class PageManager {
	
	private int requestPage;
	
	public PageManager() {
		
	}

	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResullt() {
		PageRowResult pageRowResult = new PageRowResult();
		//PageRowResult�� ��ü���� �� ����
		
		pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PAGE*(requestPage-1)+1);//1, 6
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PAGE*requestPage);//5, 10
		
		return pageRowResult;
	}
	
	public PageGroupResult getPageGroupResult(String sql) {
		PageGroupResult pageGropResult = new PageGroupResult();
		//PageGroupResult�� ��ü���� �� ����
		int requestPageGroupNumber=(requestPage-1)/PageInfo.SHOW_PAGE_COUNT;
		//int requestPageGroupNumber=(int)math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT);
		
		
		System.out.println(requestPageGroupNumber);
		
		pageGropResult.setGroupStartNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT+1);
		pageGropResult.setGroupEndNumber((requestPageGroupNumber+1)*PageInfo.SHOW_PAGE_COUNT);
		
		//pageGropResult.setGroupStartNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT-(PageInfo.SHOW_PAGE_COUNT-1));
		//pageGropResult.setGroupEndNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
		
		//���ټ� ��������
		PageDAO dao = new PageDAOImpl();
		int totalRow = dao.getCount(sql);
		
		//int totalPageNumber = ���ټ�/���������� �����ִ� �ټ�;
		
		//�Ѹ�ũ ����
		int totalPageNumber = (totalRow-1)/PageInfo.ROW_COUNT_PAGE+1;
		//(int)meth.ceil((double)totalRow/PageInfo.ROW_COUNT_PAGE);
		
		//last ������ ��ũ�� ����
		if(pageGropResult.getGroupEndNumber() > totalPageNumber) {
			pageGropResult.setGroupEndNumber(totalPageNumber);
		}
		
		//befor, after 
		if(pageGropResult.getGroupStartNumber()==1) {
			pageGropResult.setBeforPage(false);
			
		}
		if(pageGropResult.getGroupEndNumber()==totalPageNumber) {
			pageGropResult.setAfterPage(false);
			
		}
		
		pageGropResult.setSelectPageNumber(requestPage);
		
		return pageGropResult;
	}
	
	public static void main(String[] args) {
		
		PageManager pm = new PageManager(1);
		
		System.out.println(pm.getPageRowResullt().getRowStartNumber());
		System.out.println(pm.getPageRowResullt().getRowEndNumber());
		
		
	}

}
