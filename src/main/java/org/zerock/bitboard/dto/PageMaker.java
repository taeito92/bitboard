package org.zerock.bitboard.dto;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

    private int start, end, page, size, total;
    private boolean prev, next;

    public PageMaker(int page, int size, int total){


        this.page = page;
        this.size = size;
        this.total = total;


        //마지막 페이지
        end = (int)Math.ceil(page / 10.0) * 10;
        start = end -9;

        prev = start > 1;

        next = (total /(double)size) > end;

        if(end * size > total){
            end = (int)(Math.ceil((total/(double)size)));
        }

    }

}
