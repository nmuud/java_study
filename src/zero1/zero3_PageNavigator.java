package zero1;

class Pager {
    private long totalCount;
    private int pageSize;
    private int blockSize;

    public Pager(long totalCount) {
        this.totalCount = totalCount;
        this.pageSize = 10;
        this.blockSize = 10;
    }

    public String html(long currentPage) {
        long totalPageCount = (long) Math.ceil((double) totalCount / pageSize);
        long startPage = ((currentPage - 1) / blockSize) * blockSize + 1;
        long endPage = Math.min(startPage + blockSize - 1, totalPageCount);

        StringBuilder sb = new StringBuilder();

        if (currentPage >= 1) {
            sb.append("<a href='#'>[처음]</a>\n");
            sb.append("<a href='#'>[이전]</a>\n");
        }

        sb.append("\n");

        for (long i = startPage; i <= endPage; i++) {
            if (i == currentPage) {
                sb.append("<a href='#' class='on'>" + i + "</a>\n");
            } else {
                sb.append("<a href='#'>" + i + "</a>\n");
            }
        }

        sb.append("\n");

        if (currentPage < totalPageCount) {
            sb.append("<a href='#'>[다음]</a>\n");
            sb.append("<a href='#'>[마지막]</a>\n");
        }

        return sb.toString().trim();
    }
}

public class zero3_PageNavigator {
    public static void main(String[] args) {
        long totalCount = 127;
        long pageIndex = 1;

        Pager pager = new Pager(totalCount);
        System.out.println(pager.html(pageIndex));
    }
}
