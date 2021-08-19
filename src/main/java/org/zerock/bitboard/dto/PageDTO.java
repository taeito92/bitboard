package org.zerock.bitboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDTO {

    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 10;

    public int getSkip(){
        // 1페이지는 - 0개 스킵
        // 2 - 10
        // 3 - 20

        return(this.page-1) * size;
    }



}
